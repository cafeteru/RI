package uo.ri.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alb.util.jdbc.Jdbc;
import uo.ri.common.BusinessException;
import uo.ri.common.TratamientoExcepciones;
import uo.ri.persistence.ProveedoresGateway;

/**
 * Clase de la parte de persistencia que implementa a la clase
 * ProveedoresGateway.
 * 
 * @author Iván González Mahagamage
 *
 */
public class ProveedoresGatewayImpl extends ConexionGateway
		implements ProveedoresGateway {
	/**
	 * Constructor por defecto.
	 * 
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	public ProveedoresGatewayImpl() throws SQLException, BusinessException {
		super();
	}

	@Override
	public void añadirProveedor(String nombre, String codigo)
			throws BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_INSERTAR_PROVEEDOR");
			TratamientoExcepciones.setString(pst, 1, nombre);
			TratamientoExcepciones.setString(pst, 2, codigo);
			TratamientoExcepciones.executeUpdate(pst);
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException("Error al a�adir el proveedor");
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}

	@Override
	public void borrarProveedor(Long idProveedor) throws BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_BORRAR_PROVEEDOR_PEDIDOS");
			TratamientoExcepciones.setLong(pst, 1, idProveedor);
			TratamientoExcepciones.executeUpdate(pst);
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_BORRAR_PROVEEDOR_SUMINISTROS");
			TratamientoExcepciones.setLong(pst, 1, idProveedor);
			TratamientoExcepciones.executeUpdate(pst);
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_BORRAR_PROVEEDOR");
			TratamientoExcepciones.setLong(pst, 1, idProveedor);
			TratamientoExcepciones.executeUpdate(pst);
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException("Error al borrar el proveedor");
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}

	@Override
	public List<Map<String, Object>> listarProveedores()
			throws BusinessException {
		List<Map<String, Object>> proveedores = null;
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_LISTAR_PROVEEDORES");
			rs = TratamientoExcepciones.executeQuery(pst);
			proveedores = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> proveedor = new HashMap<String, Object>();
				proveedor.put("id", rs.getLong("id"));
				proveedor.put("nombre", rs.getString("nombre"));
				proveedor.put("codigo", rs.getString("codigo"));
				proveedores.add(proveedor);
			}
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException("Error al listar los proveedores");
		} finally {
			Jdbc.close(rs, pst, c);
		}
		return proveedores;
	}

	@Override
	public void actualizarProveedor(Long id, String nombre, String codigo)
			throws BusinessException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_ACTUALIZAR_PROVEEDOR");
			TratamientoExcepciones.setString(pst, 1, nombre);
			TratamientoExcepciones.setString(pst, 2, codigo);
			TratamientoExcepciones.setLong(pst, 3, id);
			TratamientoExcepciones.executeUpdate(pst);
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException("Error al actualizar el proveedor");
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}

	@Override
	public Long buscarIDProveedor(String nombre) throws BusinessException {
		Long id = null;
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_ID_PROVEEDOR");
			TratamientoExcepciones.setString(pst, 1, nombre);
			rs = TratamientoExcepciones.executeQuery(pst);
			while (rs.next())
				id = rs.getLong("id");
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException("Error al buscar el ID del proveedor");
		} finally {
			Jdbc.close(rs, pst, c);
		}
		return id;
	}

}
