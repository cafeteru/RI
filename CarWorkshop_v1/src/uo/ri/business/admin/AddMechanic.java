package uo.ri.business.admin;

import java.sql.*;

import uo.ri.common.BusinessException;
import alb.util.console.Printer;
import alb.util.jdbc.Jdbc;

public class AddMechanic {
	private static String SQL = "insert into TMecanicos(nombre, apellidos) values (?, ?)";

	private String nombre, apellidos;

	public AddMechanic(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public void execute() throws BusinessException {
		// Procesar
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			c = Jdbc.getConnection();
			c.setAutoCommit(false);
			pst = c.prepareStatement(SQL);
			pst.setString(1, nombre);
			pst.setString(2, apellidos);

			pst.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				Printer.print("Fallo al deshacer el cambio.");
			}
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}

}
