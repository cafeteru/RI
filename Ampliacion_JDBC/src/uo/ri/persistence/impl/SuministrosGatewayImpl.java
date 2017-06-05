package uo.ri.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alb.util.jdbc.Jdbc;
import uo.ri.common.BusinessException;
import uo.ri.common.TratamientoExcepciones;
import uo.ri.persistence.SuministrosGateway;

/**
 * Clase de la parte de persistencia que implementa a la clase
 * SuministrosGateway.
 * 
 * @author Iván González Mahagamage
 *
 */
public class SuministrosGatewayImpl extends ConexionGateway
		implements SuministrosGateway {
	/**
	 * Constructor por defecto.
	 * 
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	public SuministrosGatewayImpl() throws SQLException, BusinessException {
		super();
	}

	@Override
	public void añadirSuministros(Long idRepuesto, Long idProveedor,
			Double precio) throws BusinessException, SQLException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_INSERTAR_SUMINISTRO");
			TratamientoExcepciones.setLong(pst, 1, idRepuesto);
			TratamientoExcepciones.setLong(pst, 2, idProveedor);
			TratamientoExcepciones.setDouble(pst, 3, precio);
			TratamientoExcepciones.executeUpdate(pst);
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException(
					"Error al a�adir el repuesto suministrado por el proveedor");
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}

	@Override
	public void borrarSuministros(Long idRepuesto, Long idProveedor)
			throws BusinessException, SQLException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_BORRAR_SUMINISTRO");
			TratamientoExcepciones.setLong(pst, 1, idRepuesto);
			TratamientoExcepciones.setLong(pst, 2, idProveedor);
			TratamientoExcepciones.executeUpdate(pst);
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException(
					"Error al borrar el repuesto suministrado por el proveedor");
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}

	@Override
	public List<Map<String, Object>> listarSuministrosProveedor(
			Long idProveedor) throws BusinessException, SQLException {
		List<Map<String, Object>> suministros = null;
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_LISTAR_SUMINISTROS_PROVEEDOR");
			TratamientoExcepciones.setLong(pst, 1, idProveedor);
			rs = TratamientoExcepciones.executeQuery(pst);
			suministros = listarSuministros();
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException(
					"Error al listar los repuestos suministrado por el proveedor");
		} finally {
			Jdbc.close(rs, pst, c);
		}
		return suministros;
	}

	/**
	 * M�todo que lista de repuestos suministrados por un proveedor.
	 * 
	 * @return Una lista de repuestos suministrados por un proveedor.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	private List<Map<String, Object>> listarSuministros() throws SQLException {
		List<Map<String, Object>> suministros;
		suministros = new ArrayList<Map<String, Object>>();
		while (rs.next()) {
			Map<String, Object> suministro = new HashMap<String, Object>();
			suministro.put("repuesto_id", rs.getLong("REPUESTO_ID"));
			suministro.put("proveedor_id", rs.getLong("proveedor_id"));
			suministro.put("precio", rs.getDouble("precio"));
			suministros.add(suministro);
		}
		return suministros;
	}

	@Override
	public List<Map<String, Object>> listarSuministrosRepuesto(Long idRepuesto)
			throws BusinessException, SQLException {
		List<Map<String, Object>> suministros = null;
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_LISTAR_SUMINISTROS_REPUESTO");
			TratamientoExcepciones.setLong(pst, 1, idRepuesto);
			rs = TratamientoExcepciones.executeQuery(pst);
			suministros = listarSuministros();
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException(
					"Error al listar los repuestos suministrado por el proveedor");
		} finally {
			Jdbc.close(rs, pst, c);
		}
		return suministros;
	}

	@Override
	public void actualizarSuministro(Long idRepuesto, Long idProveedor,
			Double precio) throws BusinessException, SQLException {
		try {
			pst = TratamientoExcepciones.configurarPreparementStament(c,
					"SQL_ACTUALIZAR_SUMINISTRO");
			TratamientoExcepciones.setDouble(pst, 1, precio);
			TratamientoExcepciones.setLong(pst, 2, idRepuesto);
			TratamientoExcepciones.setLong(pst, 3, idProveedor);
			TratamientoExcepciones.executeUpdate(pst);
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException(
					"Error al actualizar el repuesto suministrado por el proveedor");
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}

}
