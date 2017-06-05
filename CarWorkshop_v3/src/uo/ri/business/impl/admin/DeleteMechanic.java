package uo.ri.business.impl.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import alb.util.console.Printer;
import alb.util.jdbc.Jdbc;
import uo.ri.common.BusinessException;

public class DeleteMechanic {
	private static String SQL = "delete from TMecanicos where id = ?";
	private Long idMecanico;

	public DeleteMechanic(Long idMecanico) {
		this.idMecanico = idMecanico;
	}

	public void execute() throws BusinessException {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			c = Jdbc.getConnection();
			c.setAutoCommit(false);
			pst = c.prepareStatement(SQL);
			pst.setLong(1, idMecanico);
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
