package uo.ri.common;

import java.sql.*;

import alb.util.jdbc.Jdbc;
import alb.util.properties.Settings;

public class TratamientoExcepciones {

	public static Connection setConnection() throws BusinessException {
		try {
			Connection c = Jdbc.getConnection();
			c.setAutoCommit(false);
			return c;
		} catch (SQLException e) {
			throw new BusinessException("Error al conectar con la base de datos ");
		}
	}

	public static PreparedStatement configurarPreparementStament(Connection c, String sentencia)
			throws SQLException, BusinessException {
		try {
			return c.prepareStatement(Settings.get(sentencia));
		} catch (RuntimeException e) {
			throw new BusinessException("No se encuentra la sentencia SQL -> " + sentencia);
		} catch (SQLSyntaxErrorException e) {
			throw new BusinessException("La sentencia SQL no es correcta -> " + sentencia);
		}
	}

	public static void setString(PreparedStatement pst, int posicion, String valor)
			throws SQLException, BusinessException {
		try {
			pst.setString(posicion, valor);
		} catch (NullPointerException e) {
			throw new BusinessException("Error al modificar el parámetro -> " + valor + "para la sentencia SQL");
		}
	}

	public static void setLong(PreparedStatement pst, int posicion, Long valor) throws SQLException, BusinessException {
		try {
			pst.setLong(posicion, valor);
		} catch (NullPointerException e) {
			throw new BusinessException("Error al modificar el parámetro -> " + valor + "para la sentencia SQL");
		}
	}

	public static void setDouble(PreparedStatement pst, int posicion, double valor)
			throws SQLException, BusinessException {
		try {
			pst.setDouble(posicion, valor);
		} catch (NullPointerException e) {
			throw new BusinessException("Error al modificar el parámetro -> " + valor + "para la sentencia SQL");
		}
	}

	public static void setDate(PreparedStatement pst, int posicion, Date valor) throws SQLException, BusinessException {
		try {
			pst.setDate(posicion, valor);
		} catch (NullPointerException e) {
			throw new BusinessException("Error al modificar el parámetro -> " + valor + "para la sentencia SQL");
		}
	}

	public static void executeUpdate(PreparedStatement pst) throws SQLException, BusinessException {
		try {
			pst.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new BusinessException("Violación del restricción de integridad");
		}
	}

	public static ResultSet executeQuery(PreparedStatement pst) throws BusinessException {
		try {
			return pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Fallo al ejecutar la consulta");
		}

	}
}
