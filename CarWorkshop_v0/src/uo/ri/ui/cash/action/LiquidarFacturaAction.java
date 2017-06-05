package uo.ri.ui.cash.action;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

import alb.util.console.Console;
import alb.util.jdbc.Jdbc;
import alb.util.math.Round;
import alb.util.menu.Action;
import uo.ri.common.BusinessException;

public class LiquidarFacturaAction implements Action {
	private static String METALICO = "TMetalico";
	private static String BONOS = "TBonos";
	private static String TARJETA = "TTarjetasCredito";
	
	private Connection c = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String SQL;
	private int numeroFactura = 0;
	private int idFactura = 0;
	private double importeFactura = 0;
	private double disponibleBono = 0;
	private HashMap<String, Integer> mediosPago = new HashMap<>();
	
	/**
	 * Proceso:
	 * 
	 *  - Pedir al usuario el nº de factura
	 *  - Recuperar los datos de la factura
	 *  - Mostrar la factura en pantalla
	 *  - Verificar que está sin abonar (status <> 'ABONADA')
	 *  - Listar en pantalla los medios de pago registrados para el cliente
	 *  - Mostrar los medios de pago
	 *  - Pedir el importe a cargar en cada medio de pago. 
	 *  	Verificar que la suma de los cargos es igual al importe de la factura
	 *  - Registrar los cargos en la BDD
	 *  - Incrementar el acumulado de cada medio de pago
	 *  - Si se han empleado bonos, decrementar el saldo disponible 
	 *  - Finalmente, marcar la factura como abonada 
	 *  
	 */
	@Override
	public void execute() throws BusinessException {
		numeroFactura = Console.readInt("Número de la factura");
		if (!mostrarFacturaSinAbonar(numeroFactura)) {
			listarMediosPago();
			crearCargos();
		} else
			System.out.println("La factura está pagada");
	}

	/**
	 * - Recuperar los datos de la factura - Mostrar la factura en pantalla -
	 * Verificar que está sin abonar (status <> 'ABONADA')
	 * 
	 * @param numeroFactura
	 * @return
	 */
	private boolean mostrarFacturaSinAbonar(int numeroFactura) {
		SQL = "SELECT * " + "FROM TFACTURAS f " + "WHERE f.NUMERO = ?";
		boolean pagada = false;
		try {
			c = Jdbc.getConnection();
			ps = c.prepareStatement(SQL);
			ps.setInt(1, numeroFactura);
			rs = ps.executeQuery();
			String factura = "";
			while (rs.next()) {
				factura = "Factura -> ";
				idFactura = rs.getInt("ID");
				factura += "id: " + idFactura;
				factura += ", fecha: " + rs.getDate("FECHA");
				importeFactura = rs.getDouble("IMPORTE"); // Guarda el importe de la factura
				factura += ", importe: " + importeFactura;
				factura += "€, iva: " + rs.getDouble("IVA");
				factura += "%, número: " + rs.getInt("NUMERO");
				String estado = rs.getString("STATUS");
				factura += ", estado: " + estado + ".";
				System.out.println(factura);
				if (estado.equals("ABONADA"))
					pagada = true;
			}
			if (factura.equals("")) // Si no encuentra la factura
				System.err.println("No existe la factura");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, ps, c);
		}
		return pagada;
	}

	/**
	 * 	- Listar en pantalla los medios de pago registrados para el cliente
	 *  - Mostrar los medios de pago
	 */
	private void listarMediosPago() {
		int idCliente = buscarClienteFactura();
		SQL = "SELECT * FROM TMEDIOSPAGO WHERE CLIENTE_ID = ?";
		try {
			c = Jdbc.getConnection();
			ps = c.prepareStatement(SQL);
			ps.setInt(1, idCliente);
			rs = ps.executeQuery();
			String listado = "";
			while (rs.next()) {
				String tipoPago = rs.getString("DTYPE");
				int id = rs.getInt("ID");
				mediosPago.put(tipoPago, id);
				listado += "\t- Tipo: " + tipoPago;
				listado += ", id: " + id;
				listado += ", acumulado: " + Round.twoCents(rs.getDouble("ACUMULADO"));
				if (tipoPago.equals(BONOS)) {
					listado += ", código: " + rs.getString("CODIGO");
					disponibleBono = Round.twoCents(rs.getDouble("DISPONIBLE"));
					listado += ", disponible: " + disponibleBono;
					comprobarSaldoBono();
				} else if (tipoPago.equals(TARJETA)) {
					listado += ", número: " + rs.getString("NUMERO");
					listado += ", tipo de tarjeta: " + rs.getString("TIPO");
					Timestamp fecha = rs.getTimestamp("VALIDEZ");
					listado += ", validez hasta: " + fecha;
					listado = listado.substring(0, listado.length() - 11);
					comprobarTarjeta(fecha);
				}
				listado += ".\n";
			}
			if (listado.equals(""))
				System.out.println("No hay métodos de pago registrados");
			else
				System.out.println("Métodos de pago:\n" + listado);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, ps, c);
		}
	}

	/**
	 * Busca al cliente asignado a la factura
	 * 
	 * @return El dni del cliente asignado a la factura
	 */
	private int buscarClienteFactura() {
		int id = 0;
		SQL = "SELECT DISTINCT(c.ID) "
				+ "FROM TFACTURAS f,TAVERIAS a, TVEHICULOS v, TCLIENTES c "
				+ "WHERE f.ID = a.FACTURA_ID " 
				+ "AND a.VEHICULO_ID  = v.ID " 
				+ "AND v.CLIENTE_ID = c.ID "
				+ "AND f.status = 'SIN_ABONAR' " 
				+ "AND f.NUMERO = ?";
		try {
			c = Jdbc.getConnection();
			ps = c.prepareStatement(SQL);
			ps.setInt(1, numeroFactura);
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("ID");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, ps, c);
		}
		return id;
	}
	
	/**
	 *  - Pedir el importe a cargar en cada medio de pago. 
	 *  	Verificar que la suma de los cargos es igual al importe de la factura
	 *  - Registrar los cargos en la BDD
	 *  - Incrementar el acumulado de cada medio de pago
	 *  - Si se han empleado bonos, decrementar el saldo disponible 
	 */
	private void crearCargos() {
		double cantidadIntroducida = 0;
		while (cantidadIntroducida < importeFactura) {
			double cantidadRestante = Round.twoCents(importeFactura - cantidadIntroducida);
			System.out.println("Falta por pagar: " + (cantidadRestante));
			if (mediosPago.size() > 1) {
				String tipo = comprobarTipoMedioPago(Console.readString("Elija método de pago"));
				// Comprobar que es un método valido
				if (tipo.equals(METALICO) || tipo.equals(BONOS) || tipo.equals(TARJETA)) {
					int idMedio = mediosPago.get(tipo);
					// Comprobar si el método esta registrado
					if (idMedio != 0) {
						double importe = Console.readDouble("Introduzca el importe");
						if (importe <= 0) {
							System.err.println("Importe no válido");
							continue;
						} else if (tipo.equals(BONOS) && importe > disponibleBono) {
							importe = disponibleBono;
							System.err.println("El importe es mayor que el saldo disponible del bono");
							System.out.println("Se ha cambiado el importe a " + importe + " €.");
						} else if (importe > cantidadRestante) {
							importe = cantidadRestante;
							System.out.println("El importe ha excedido a la cantidad pendiente de pago");
							System.out.println("Se ha cambiado el importe a " + importe + " €.");
						}
						cantidadIntroducida = cantidadIntroducida + importe;
						importe = Round.twoCents(importe); 
						crearNuevoCargo(tipo, idMedio, importe);
						// Elimina el método de pago para que no se repita a  pagar con el en la factura actual
						mediosPago.remove(tipo);
					} else {
						System.err.println("Método no registrado o no disponible");
						continue;
					}
				} else {
					System.err.println("Método incorrecto");
					continue;
				}
			} else {
				unicoMedioPago(cantidadRestante);
				break;
			}
		}
		registrarFacturaPagada();
	}

	/**
	 * Comprueba que el cliente puede usar bonos
	 */
	private void comprobarSaldoBono() {
		if (disponibleBono == 0) {
			System.err.println("El importe disponible del bono es 0");
			System.err.println("Se borrará del listado actual de métodos de pago");
			mediosPago.remove(BONOS);
		}
	}
	
	/**
	 * Comprueba la fecha de validez de una tarjeta de credito
	 * 
	 * @param fecha
	 *            Fecha de validez de la tarjeta de credito
	 */
	private void comprobarTarjeta(Timestamp fecha){
		Calendar c1 = GregorianCalendar.getInstance();
		if (fecha.before(c1.getTime())){
			System.err.println("La tarjeta de crédito esta caducada");
			System.err.println("Se borrará del listado actual de métodos de pago");
			mediosPago.remove(TARJETA);
		}
	}
	
	/**
	 * Realiza el cargo si el cliente solo tiene disponible un método de pago
	 * 
	 * @param importe
	 *            Importe cargado sobre el método de pago
	 */
	private void unicoMedioPago(double importe) {
		Iterator<String> iterator = mediosPago.keySet().iterator();
		String tipo = "";
		while (iterator.hasNext())
			tipo = iterator.next();
		System.out.println("Se ha elegido su única de opción disponible: " + tipo.substring(1, tipo.length()));
		System.out.println("y se cargará un importe de: " + importe);
		int idMedio = mediosPago.get(tipo);
		crearNuevoCargo(tipo, idMedio, importe);
	}
	
	/**
	 * Comprueba el tipo de método introducido para que sea más fácil al
	 * usuario.
	 * 
	 * @param tipo
	 *            Tipo introducido
	 * @return Uno de los tipos que admite el sistema. Si no reconoce el texto
	 *         introducido lo devuelve tal cual.
	 */
	private String comprobarTipoMedioPago(String tipo){
		tipo = tipo.toUpperCase();
		if (tipo.equals("METALICO") || tipo.equals("TMETALICO"))
			return METALICO;
		else if (tipo.equals("BONOS") || tipo.equals("BONO")
				|| tipo.equals("TBONOS"))
			return BONOS;
		else if (tipo.equals("TARJETA") || tipo.equals("TARJETACREDITO")
				|| tipo.equals("TARJETADECREDITO")
				|| tipo.equals("TARJETASCREDITO")
				|| tipo.equals("TTARJETASCREDITO"))
			return TARJETA;
		return tipo;
	}
	
	/**
	 * Registra el nuevo cargo en la base de datos
	 * 
	 * @param tipo
	 *            Tipo del cargo
	 * @param idMedio
	 *            Id del cargo
	 * @param importe
	 *            Importe del cargo
	 */
	private void crearNuevoCargo(String tipo, int idMedio, double importe) {
		registrarNuevoCargo(idMedio, importe);
		modificarMedioPago(tipo, importe, idMedio);
	}

	/**
	 * - Registrar los cargos en la BDD
	 * 
	 * @param idMedio
	 *            Id del método ultilizado
	 * @param importe
	 *            Importe cargado al método utilizado
	 */
	private void registrarNuevoCargo(int idMedio, double importe) {
		SQL = "INSERT INTO TCARGOS (IMPORTE, FACTURA_ID, MEDIOPAGO_ID) VALUES (?,?,?)";
		try {
			c = Jdbc.getConnection();
			ps = c.prepareStatement(SQL);
			ps.setDouble(1, importe);
			ps.setInt(2, idFactura);
			ps.setInt(3, idMedio);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, ps, c);
		}
	}

	/**
	 * - Incrementar el acumulado de cada medio de pago 
	 * - Si se han empleado bonos, decrementar el saldo disponible
	 * 
	 * @param tipo
	 *            Tipo del método ultilizado
	 * @param idMedio
	 *            Id del método ultilizado
	 */
	private void modificarMedioPago(String tipo, double importe, int idMedio) {
		if (tipo.equals(BONOS))
			SQL = "UPDATE TMEDIOSPAGO SET ACUMULADO = ACUMULADO + ?, DISPONIBLE = DISPONIBLE - ? WHERE ID = ?";
		else
			SQL = "UPDATE TMEDIOSPAGO SET ACUMULADO = ACUMULADO + ? WHERE ID = ?";
		try {
			c = Jdbc.getConnection();
			ps = c.prepareStatement(SQL);
			ps.setDouble(1, importe);
			if (tipo.equals(BONOS)) {
				ps.setDouble(2, importe);
				ps.setInt(3, idMedio);
			} else {
				ps.setInt(2, idMedio);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, ps, c);
		}
	}

	/**
	 * - Finalmente, marcar la factura como abonada 
	 */
	private void registrarFacturaPagada() {
		SQL = "UPDATE TFACTURAS SET STATUS = 'ABONADA' WHERE NUMERO = ?";
		try {
			c = Jdbc.getConnection();
			ps = c.prepareStatement(SQL);
			ps.setDouble(1, numeroFactura);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, ps, c);
		}
	}
}
