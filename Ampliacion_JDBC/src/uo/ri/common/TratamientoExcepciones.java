package uo.ri.common;

import java.sql.*;

import alb.util.jdbc.Jdbc;
import alb.util.properties.Settings;

/**
 * Clase que trata las excepciones que se producen durante la ejecución del
 * programa.
 * 
 * @author Iv�n Gonz�lez Mahagamage
 *
 */
public class TratamientoExcepciones {

	/**
	 * Método estático que conecta a una base de datos.
	 * 
	 * @return Una conexi�n a una base de datos.
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 */
	public static Connection setConnection() throws BusinessException {
		try {
			Connection c = Jdbc.getConnection();
			c.setAutoCommit(false);
			return c;
		} catch (SQLException e) {
			throw new BusinessException(
					"Error al conectar con la base de datos");
		}
	}

	/**
	 * Método estático que prepara una consulta en una base de datos.
	 * 
	 * @param c
	 *            Conexi�n a la base de datos.
	 * @param sentencia
	 *            Sentencia SQL.
	 * @return Un PreparedStatement con la consulta SQL.
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	public static PreparedStatement configurarPreparementStament(Connection c,
			String sentencia) throws SQLException, BusinessException {
		try {
			return c.prepareStatement(Settings.get(sentencia));
		} catch (RuntimeException e) {
			throw new BusinessException(
					"No se encuentra la sentencia SQL -> " + sentencia);
		} catch (SQLSyntaxErrorException e) {
			throw new BusinessException(
					"La sentencia SQL no es correcta -> " + sentencia);
		}
	}

	/**
	 * Método estático que inserta un String en un PreparedStatement.
	 * 
	 * @param pst
	 *            PreparedStatement con la consulta SQL.
	 * @param posicion
	 *            Posicion del parámetro de la consulta
	 * @param valor
	 *            Parámetro a añadir a la consulta
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	public static void setString(PreparedStatement pst, int posicion,
			String valor) throws SQLException, BusinessException {
		try {
			pst.setString(posicion, valor);
		} catch (NullPointerException e) {
			throw new BusinessException("Error al modificar el Parámetro -> "
					+ posicion + " para la sentencia SQL");
		} catch (SQLException e) {
			throw new BusinessException("Error al ejecutar la consulta");
		}
	}

	/**
	 * Método estático que inserta un int en un PreparedStatement.
	 * 
	 * @param pst
	 *            PreparedStatement con la consulta SQL.
	 * @param posicion
	 *            Posicion del parámetro de la consulta.
	 * @param valor
	 *            Parámetro a añadir a la consulta.
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 */
	public static void setInt(PreparedStatement pst, int posicion, int valor)
			throws BusinessException {
		try {
			pst.setInt(posicion, valor);
		} catch (NullPointerException e) {
			throw new BusinessException("Error al modificar el Parámetro -> "
					+ posicion + " para la sentencia SQL");
		} catch (SQLException e) {
			throw new BusinessException("Error al ejecutar la consulta");
		}
	}

	/**
	 * Método estático que inserta un Long en un PreparedStatement.
	 * 
	 * @param pst
	 *            PreparedStatement con la consulta SQL.
	 * @param posicion
	 *            Posicion del parámetro de la consulta.
	 * @param valor
	 *            Parámetro a añadir a la consulta.
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	public static void setLong(PreparedStatement pst, int posicion, Long valor)
			throws SQLException, BusinessException {
		try {
			pst.setLong(posicion, valor);
		} catch (NullPointerException e) {
			throw new BusinessException("Error al modificar el Parámetro -> "
					+ posicion + " para la sentencia SQL");
		} catch (SQLException e) {
			throw new BusinessException("Error al ejecutar la consulta");
		}
	}

	/**
	 * Método estático que inserta un Double en un PreparedStatement.
	 * 
	 * @param pst
	 *            PreparedStatement con la consulta SQL.
	 * @param posicion
	 *            Posicion del parámetro de la consulta.
	 * @param valor
	 *            Parámetro a añadir a la consulta.
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	public static void setDouble(PreparedStatement pst, int posicion,
			double valor) throws SQLException, BusinessException {
		try {
			pst.setDouble(posicion, valor);
		} catch (NullPointerException e) {
			throw new BusinessException("Error al modificar el Parámetro -> "
					+ posicion + " para la sentencia SQL");
		} catch (SQLException e) {
			throw new BusinessException("Error al ejecutar la consulta");
		}
	}

	/**
	 * Método estático que inserta un fecha en un PreparedStatement.
	 * 
	 * @param pst
	 *            PreparedStatement con la consulta SQL.
	 * @param posicion
	 *            Posicion del parámetro de la consulta.
	 * @param valor
	 *            Parámetro a añadir a la consulta.
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	public static void setDate(PreparedStatement pst, int posicion, Date valor)
			throws SQLException, BusinessException {
		try {
			pst.setDate(posicion, valor);
		} catch (NullPointerException e) {
			throw new BusinessException("Error al modificar el Parámetro -> "
					+ posicion + " para la sentencia SQL");
		} catch (SQLException e) {
			throw new BusinessException("Error al ejecutar la consulta");
		}
	}

	/**
	 * Método estático que inserta un fecha en un PreparedStatement.
	 * 
	 * @param pst
	 *            PreparedStatement con la consulta SQL.
	 * @param posicion
	 *            Posicion del parámetro de la consulta.
	 * @param valor
	 *            Parámetro a añadir a la consulta.
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	public static void setDate(PreparedStatement pst, int posicion, long valor)
			throws BusinessException, SQLException {
		java.sql.Date fecha = new java.sql.Date(valor);
		try {
			pst.setDate(posicion, fecha);
		} catch (NullPointerException e) {
			throw new BusinessException("Error al modificar el Parámetro -> "
					+ posicion + " para la sentencia SQL");
		} catch (SQLException e) {
			throw new BusinessException("Error al ejecutar la consulta");
		}
	}

	/**
	 * Método estático ejecuta una consulta que actualiza una base de datos.
	 * 
	 * @param pst
	 *            PreparedStatement con la consulta SQL.
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	public static void executeUpdate(PreparedStatement pst)
			throws SQLException, BusinessException {
		try {
			pst.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new BusinessException(
					"Violación de restricción de integridad");
		} catch (SQLException e) {
			throw new BusinessException(
					"Todos los parámetros no han sido indicados");
		}
	}

	/**
	 * Método estático que Ejecuta una consulta que devuelve datos de una base
	 * de datos.
	 * 
	 * @param pst
	 *            PreparedStatement con la consulta SQL.
	 * @return Un ResultSet con los datos de la consulta.
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 */
	public static ResultSet executeQuery(PreparedStatement pst)
			throws BusinessException {
		try {
			return pst.executeQuery();
		} catch (SQLException e) {
			throw new BusinessException("Fallo al ejecutar la consulta");
		}
	}

}
