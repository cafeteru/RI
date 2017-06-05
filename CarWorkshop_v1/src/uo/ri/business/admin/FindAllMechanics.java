package uo.ri.business.admin;

import java.sql.*;
import java.util.*;

import alb.util.console.Printer;
import alb.util.jdbc.Jdbc;

public class FindAllMechanics {
	private static String SQL = "select id, nombre, apellidos from TMecanicos";

	public List<Map<String, Object>> execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Map<String, Object>> mecanicos = null;
		try {
			c = Jdbc.getConnection();
			c.setAutoCommit(false);
			pst = c.prepareStatement(SQL);
			rs = pst.executeQuery();
			mecanicos = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> mecanico = new HashMap<String, Object>();
				mecanico.put("id", rs.getLong("id"));
				mecanico.put("nombre", rs.getString("nombre"));
				mecanico.put("apellidos", rs.getString("apellidos"));
				mecanicos.add(mecanico);
			}
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
		return mecanicos;
	}
}
