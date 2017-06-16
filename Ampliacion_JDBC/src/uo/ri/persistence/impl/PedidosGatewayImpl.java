package uo.ri.persistence.impl;

import java.sql.*;
import java.util.*;

import alb.util.date.DateUtil;
import alb.util.jdbc.Jdbc;
import uo.ri.common.*;
import uo.ri.persistence.PedidosGateway;
import uo.ri.ui.util.CalculosMatematicos;

/**
 * Clase de la parte de persistencia que implementa a la clase PedidosGateway.
 * 
 * @author Iván González Mahagamage
 *
 */
public class PedidosGatewayImpl extends ConexionGateway
		implements PedidosGateway {
	private List<Map<String, Object>> pedidos = new ArrayList<Map<String, Object>>();

	/**
	 * Constructor por defecto.
	 * 
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	public PedidosGatewayImpl() throws SQLException, BusinessException {
		super();
	}

	@Override
	public List<Map<String, Object>> listarPedidosProveedor(Long idProveedor)
			throws BusinessException {
		try {
			leerPedidos(idProveedor, "SQL_LISTAR_PEDIDOS_PROVEEDOR_PEDIDO");
			leerPedidos(idProveedor, "SQL_LISTAR_PEDIDOS_PROVEEDOR_RECIBIDO");
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException(
					"Error al listar los pedidos al proveedor " + idProveedor);
		} finally {
			Jdbc.close(rs, pst, c);
		}
		return pedidos;
	}

	/**
	 * 
	 * @param idProveedor
	 * @param SQL
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	private void leerPedidos(Long idProveedor, String SQL)
			throws SQLException, BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c, SQL);
			TratamientoExcepciones.setLong(pst, 1, idProveedor);
			rs = TratamientoExcepciones.executeQuery(pst);
			while (rs.next()) {
				Map<String, Object> proveedor = new HashMap<String, Object>();
				proveedor.put("id", rs.getLong("id"));
				proveedor.put("codigo", rs.getString("codigo"));
				proveedor.put("fecha_creacion", rs.getDate("fecha_creacion"));
				proveedor.put("fecha_recepcion", rs.getDate("fecha_recepcion"));
				proveedor.put("estado", rs.getString("estado"));
				pedidos.add(proveedor);
			}
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException("Error leer los pedidos");
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}

	@Override
	public List<Map<String, Object>> listarRepuestosPedidoId(Long idPedido)
			throws BusinessException {
		List<Map<String, Object>> repuestosPedido = null;
		try {
			verificarPedido(idPedido);
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_LISTAR_REPUESTOS_PEDIDO");
			TratamientoExcepciones.setLong(pst, 1, idPedido);
			repuestosPedido = new ArrayList<Map<String, Object>>();
			rs = TratamientoExcepciones.executeQuery(pst);
			while (rs.next()) {
				Map<String, Object> repuesto = new HashMap<String, Object>();
				repuesto.put("id", rs.getLong("id"));
				repuesto.put("codigo", rs.getString("codigo"));
				repuesto.put("descripcion", rs.getString("descripcion"));
				repuesto.put("unidades", rs.getInt("unidades"));
				repuesto.put("precio", rs.getDouble("precio"));
				repuestosPedido.add(repuesto);
			}
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException("Error leer el pedido");
		} finally {
			Jdbc.close(rs, pst, c);
		}
		return repuestosPedido;
	}

	/**
	 * 
	 * @param idPedido
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	private void verificarPedido(Long idPedido)
			throws SQLException, BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_VERIFICAR_ESTADO_PEDIDO");
			TratamientoExcepciones.setLong(pst, 1, idPedido);
			rs = TratamientoExcepciones.executeQuery(pst);
			if (rs.next() == false)
				throw new BusinessException("No existe el pedido " + idPedido);
			String estado = rs.getString("estado");
			if (!"PEDIDO".equalsIgnoreCase(estado))
				throw new BusinessException(
						"El pedido " + idPedido + " ya ha sido recibido ");
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException("Error leer el pedido");
		} finally {
			Jdbc.close(rs, pst);
		}
	}

	@Override
	public void modificarExistenciasPrecioRepuesto(Long idRepuesto,
			Long idPedido) throws BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_EXISTENCIAS_PRECIO_REPUESTOS");
			TratamientoExcepciones.setLong(pst, 1, idRepuesto);
			rs = TratamientoExcepciones.executeQuery(pst);
			while (rs.next()) {
				int existencias = rs.getInt("existencias");
				double precioExistencias = rs.getLong("precio");
				PreparedStatement ps2 = TratamientoExcepciones
						.configurarPreparementStament(c,
								"SQL_CANTIDAD_PRECIO_REPUESTOS_PEDIDOS");
				TratamientoExcepciones.setLong(ps2, 1, idPedido);
				TratamientoExcepciones.setLong(ps2, 2, idRepuesto);
				ResultSet rs2 = TratamientoExcepciones.executeQuery(ps2);
				int unidades = 0;
				double precioUnidades = 0;
				while (rs2.next()) {
					unidades = rs2.getInt("unidades");
					precioUnidades = rs2.getDouble("precio");
				}
				int existenciasTotales = existencias + unidades;
				double precioNuevo = CalculosMatematicos.calcularMedia(
						existencias, precioExistencias, unidades,
						precioUnidades, existenciasTotales);
				ps2 = TratamientoExcepciones.configurarPreparementStament(c,
						"SQL_ACTUALIZAR_EXISTENCIAS_PRECIO_REPUESTOS");
				TratamientoExcepciones.setInt(ps2, 1, existenciasTotales);
				TratamientoExcepciones.setDouble(ps2, 2, precioNuevo);
				TratamientoExcepciones.setLong(ps2, 3, idRepuesto);
				TratamientoExcepciones.executeUpdate(ps2);
				Jdbc.close(rs2, ps2);
			}
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException("Error leer el pedido");
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}

	@Override
	public void modificarFechaRecepcionEstadoPedido(Long idPedido)
			throws BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_MODIFICAR_RECEPCION_ESTADO_PEDIDO");
			TratamientoExcepciones.setDate(pst, 1, DateUtil.today().getTime());
			TratamientoExcepciones.setString(pst, 2, "RECIBIDO");
			TratamientoExcepciones.setLong(pst, 3, idPedido);
			TratamientoExcepciones.executeUpdate(pst);
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException("Error leer el pedido");
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}

}
