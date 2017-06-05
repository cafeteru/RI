package uo.ri.ui.cash.action;

import java.sql.*;
import java.util.*;
import java.util.Date;

import alb.util.console.Console;
import alb.util.date.DateUtil;
import alb.util.jdbc.Jdbc;
import alb.util.math.Round;
import alb.util.menu.Action;
import uo.ri.common.BusinessException;

public class FacturarReparacionesAction implements Action {
	private Connection c = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String SQL;
	private int idUltimaFactura = 0, numeroUltimaFactura = 0;
	private Calendar c1 = GregorianCalendar.getInstance();
	
	/**
	 * Proceso:
	 * 
	 * - Pide los ids de las averías a incluir en la factura. 
	 * 		El usuario, antes, habrá listado las averias no facturadas del 
	 * 		cliente y tendrá en pantalla, a la vista, los ids de las averías.
	 * - Verifica que las averías se pueden facturar (status 'TERMINADA')
	 * - Genera un nuevo número de factura (el último registrado + 1)
	 * - Calcula el importe de cada una de las averias y lo acumula al total de la factura
	 * - Calcula lo que corresponde por IVA (cuidado con la fecha)
	 * - Calcula el total (importe + IVA) y lo redondea a dos decimales (Round.twoCents( x ))
	 * - Establece como fecha de factura la del instante
	 * - Registra la factura en BDD
	 * - Vincula las averias con la factura generada
	 * - Pone el status de las averias a 'FACTURADA'
	 * - Finalmente, muestra el detalle de la factura generada en pantalla:
	 * 		nº de factura, fecha, importe, importe de IVA, importe total, status
	 * 
	 */

	@Override
	public void execute() throws BusinessException {
		int dniCliente = Console.readInt("DNI del cliente");
		// Comprueba si hay averías terminadas para pagar
		List<Integer> averias = generarListadoAveriasNoFacturadas(dniCliente);
		if (averias.size() > 0) {
			ultimaFacturaGenerada(); // Número e id de la nueva factura
			double importeTotal = 0;
			for (Integer averia : averias) { // Añado los importes a BBDD
				double importe = calcularImporteAveria(averia);
				importeTotal += importe;
				cambiarEstadoAveriaFacturada(averia, importe);
			}
			crearFactura(importeTotal); // Creo la factura
			for (Integer averia : averias) {
				// Asigno la factura a cada avería
				rellenarFacturaAverias(averia);
			}
			mostrarFacturaRecienCreada(); // Muestro la factura recién creada
		} else
			System.out.println("No hay averias pendientes");
	}

	/**
	 * Pide los ids de las averías a incluir en la factura. El usuario, antes,
	 * habrá listado las averias no facturadas del cliente y tendrá en pantalla,
	 * a la vista, los ids de las averías.
	 * 
	 * Verifica que las averías se pueden facturar (status 'TERMINADA')
	 * 
	 * @param dniCliente
	 *            DNI del cliente
	 * @return Lista de los id de las averias TERMINADAS del cliente
	 */
	private List<Integer> generarListadoAveriasNoFacturadas(int dniCliente) {
		List<Integer> listaAverias = new ArrayList<>();
		SQL = "SELECT t.ID " 
				+ "FROM TAVERIAS t, TVEHICULOS v, TCLIENTES c "
				+ "WHERE t.VEHICULO_ID  = v.ID "
				+ "AND v.CLIENTE_ID = c.ID AND " 
				+ "t.STATUS = 'TERMINADA' " 
				+ "AND c.DNI = ?";
		try {
			c = Jdbc.getConnection();
			ps = c.prepareStatement(SQL);
			ps.setInt(1, dniCliente);
			rs = ps.executeQuery();
			String averias = "Averías terminadas: \n";
			while (rs.next()) {
				averias += "\tId: " + rs.getInt("ID") + "\n";
				listaAverias.add(rs.getInt("ID"));
			}
			System.out.println(averias);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, ps, c);
		}
		return listaAverias;
	}
	
	/**
	 * Genera un nuevo número de factura (el último registrado + 1)
	 * 
	 * @return El número de la ultima factura + 1
	 */
	private void ultimaFacturaGenerada() {
		SQL = "SELECT MAX(ID) AS idUltimaFactura, MAX(NUMERO) AS numeroUltimaFactura "
				+ "FROM TFACTURAS";
		try {
			c = Jdbc.getConnection();
			ps = c.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				idUltimaFactura = rs.getInt("idUltimaFactura") + 1;
				numeroUltimaFactura = rs.getInt("numeroUltimaFactura") + 1;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, ps, c);
		}
	}

	/**
	 * Calcula el importe de cada una de las averias y lo acumula al total de la
	 * factura. Para cada avería se debe calcular su importe. Éste vendrá dado
	 * por la suma del importe de la mano de obra y el importe de los repuestos.
	 * 
	 * @param idAveria
	 *            Identidicador de la avería
	 * @return El importe total de la avería
	 */
	private double calcularImporteAveria(int idAveria) {
		return calcularImporteManoObraAveria(idAveria) + calcularImporteRespuestosAveria(idAveria);
	}

	/**
	 * El importe de mano de obra depende del tiempo empleado (se expresa en
	 * minutos) y del precio de la hora para ese tipo de vehículo. Aunque el
	 * precio se fije por horas, el cálculo se hace por minutos.
	 * 
	 * @param idAveria
	 *            Identidicador de la avería
	 * @return El importe de la mano de obra de la avería
	 */
	private double calcularImporteManoObraAveria(int idAveria){
		double importeManoObra = 0;
		SQL = "SELECT (t.PRECIOHORA / 60 * i.MINUTOS) AS MANOOBRA "
				+ "FROM TAVERIAS a, TINTERVENCIONES i, TVEHICULOS v, TTIPOSVEHICULO t "
				+ "WHERE a.ID = i.AVERIA_ID "
				+ "AND a.VEHICULO_ID = v.ID "
				+ "AND v.TIPO_ID = t.ID "
				+ "AND a.ID = ?";
		try {
			c = Jdbc.getConnection();
			ps = c.prepareStatement(SQL);
			ps.setInt(1, idAveria);
			rs = ps.executeQuery();			
			while (rs.next()) {
				importeManoObra += rs.getDouble("MANOOBRA");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, ps, c);
		}
		return importeManoObra;
	}

	/**
	 * El importe de los repuestos resulta de multiplicar el precio del tipo de
	 * repuesto por la cantidad empleada.
	 * 
	 * @param idAveria
	 *            Identidicador de la avería
	 * @return El importe de los repuestos de la avería
	 */
	private double calcularImporteRespuestosAveria(int idAveria){
		double importeRepuestos = 0;
		SQL = "SELECT (s.CANTIDAD * r.PRECIO) AS PRECIOREPUESTOS "
				+ "FROM TAVERIAS a, TSUSTITUCIONES s, TREPUESTOS r "
				+ "WHERE a.ID =  s.INTERVENCION_AVERIA_ID "
				+ "AND s.REPUESTO_ID = r.ID AND a.ID = ?";
		try {
			c = Jdbc.getConnection();
			ps = c.prepareStatement(SQL);
			ps.setInt(1, idAveria);
			rs = ps.executeQuery();			
			while (rs.next()) {
				importeRepuestos += rs.getDouble("PRECIOREPUESTOS");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, ps, c);
		}
		return importeRepuestos;
	}
	
	/**
	 * Una vez se ha fijado el importe la avería pasa a estado FACTURADA
	 * Se le añade el importe y se le asigna a una factura.
	 */
	private void cambiarEstadoAveriaFacturada(int idAveria, double importe){
		SQL = "UPDATE TAVERIAS SET STATUS = 'FACTURADA', IMPORTE = ? WHERE ID = ?";
		try {
			c = Jdbc.getConnection();	
			ps = c.prepareStatement(SQL);
			ps.setDouble(1, importe);
			ps.setInt(2, idAveria);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			Jdbc.close(rs, ps, c);
		}
	}
	
	/**
	 * - El importe será la suma de los importes de las averías. 
	 * - Al importe total hay que aplicarle un porcentaje de IVA. Se guardará el 
	 *   resultado de este cómputo. El valor del IVA depende de la fecha en la que se haya
	 *   generado la factura: si es anterior al 1/7/2012 se aplicará el 18%, a
	 *   partir de entonces el 21%. 
	 * - La fecha será la del día, sin precisión de hora.
	 * - Toda factura debe llevar un número que, por razones legales
	 *   (Ministerio de Hacienda), debe ser secuencial y sin saltos (no puede
	 *   haber la factura de nº 1012 si no hay la 1011). 
	 * - La factura recién creada quedará en estado SIN_ABONAR.
	 * 
	 * @param importe 
	 * 			Importe de la factura
	 */
	private void crearFactura(double importe){
		SQL = "INSERT INTO TFACTURAS (ID,FECHA,IMPORTE,IVA,NUMERO,STATUS)"
				+ "VALUES (?, ?, ?, ?, ?, 'SIN_ABONAR')";
		try {
			int iva = calcularIva(DateUtil.now());
			c = Jdbc.getConnection();	
			ps = c.prepareStatement(SQL);
			ps.setInt(1, idUltimaFactura);
			ps.setDate(2, new java.sql.Date(c1.getTimeInMillis()));
			ps.setDouble(3, Round.twoCents(importe * (iva / 100 + 1))); // Le añadimos el IVA
			ps.setInt(4, iva);
			ps.setInt(5, numeroUltimaFactura);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			Jdbc.close(rs, ps, c);
		}
	}
	
	/**
	 * Calcula lo que corresponde por IVA
	 * 
	 * @param date
	 *            Día actual
	 * @return el porcentaje de IVA correspondiente
	 */
	private int calcularIva(Date date) {
		int iva = 21;
		c1.set(2012, Calendar.JULY, 1); // Cambia la fecha a 2012-07-01
		if (date.before(c1.getTime()))
			iva = 18;
		c1 = Calendar.getInstance(); // Vuelve a poner la fecha actual
		return iva;
	}

	/**
	 * Asigna la factura recien creada a las averias recien facturadas
	 * 
	 * @param idAveria
	 *            identificador de la avería
	 */
	private void rellenarFacturaAverias(int idAveria) {
		SQL = "UPDATE TAVERIAS SET FACTURA_ID = ? WHERE ID = ?";
		try {
			c = Jdbc.getConnection();	
			ps = c.prepareStatement(SQL);
			ps.setInt(1, idUltimaFactura);
			ps.setInt(2, idAveria);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			Jdbc.close(rs, ps, c);
		}
	}

	
	/**
	 * Finalmente, muestra el detalle de la factura generada en pantalla:
	 * 		nº de factura, fecha, importe, importe de IVA, importe total, status
	 * 
	 */
	private void mostrarFacturaRecienCreada() {
		SQL = "SELECT NUMERO, FECHA, IMPORTE, IVA, STATUS "
				+ "FROM TFACTURAS "
				+ "WHERE ID = ?";
		try {
			c = Jdbc.getConnection();
			ps = c.prepareStatement(SQL);
			ps.setDouble(1, idUltimaFactura);
			rs = ps.executeQuery();
			while (rs.next()) {
				String factura = "Factura: \n";
				factura += "Número: " + rs.getInt("NUMERO");
				factura += ", fecha: " + rs.getDate("FECHA");
				int iva = rs.getInt("IVA");
				factura += ", importe: " + Round.twoCents(rs.getDouble("IMPORTE") / ((double) iva / 100 + 1));
				factura += "€, importe de IVA: " + iva;
				factura += "%, importe total: " + rs.getDouble("IMPORTE");
				factura += "€, status: " + rs.getString("STATUS") + ".";
				System.out.println(factura);			
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, ps, c);
		}
	}
}
