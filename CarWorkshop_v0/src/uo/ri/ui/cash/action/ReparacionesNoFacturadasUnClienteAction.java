package uo.ri.ui.cash.action;

import java.sql.*;

import alb.util.console.Console;
import alb.util.jdbc.Jdbc;
import alb.util.menu.Action;
import uo.ri.common.BusinessException;

public class ReparacionesNoFacturadasUnClienteAction implements Action {

	/**
	 * Proceso:
	 * 
	 * - Pide el DNI del cliente
	 * 
	 * - Muestra en pantalla todas sus averias no facturadas (status <>
	 * 'FACTURADA'). De cada avería muestra su id, fecha, status, importe y
	 * descripción
	 */
	@Override
	public void execute() throws BusinessException {
		int idCliente = Console.readInt("DNI del cliente");	
		String SQL = "SELECT t.ID, t.FECHA, t.STATUS, t.IMPORTE, t.DESCRIPCION "
				+ "FROM TAVERIAS t, TVEHICULOS v, TCLIENTES c " 
				+ "WHERE t.VEHICULO_ID  = v.ID "
				+ "AND v.CLIENTE_ID = c.ID " 
				+ "AND t.status != 'FACTURADA' " 
				+ "AND c.DNI = ?";
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			c = Jdbc.getConnection();
			ps = c.prepareStatement(SQL);
			ps.setInt(1, idCliente);
			rs = ps.executeQuery();
			String averias = "";
			int numeroAverias = 0;
			while (rs.next()) {
				numeroAverias++;
				averias += "\t" + numeroAverias + " -> Id: " + rs.getInt("ID");
				averias += ", fecha: " + rs.getDate("FECHA");
				averias += ", estado: " + rs.getString("STATUS");
				averias += ", importe: " + rs.getDouble("IMPORTE");
				averias += " €, descripción: " + rs.getString("DESCRIPCION") + ".\n";
			}
			// Si no tiene averias sin facturar avisa
			if (numeroAverias == 0)
				System.out.println("No tiene averías sin facturar");
			else {
				System.out.println("Número de averías sin facturar: " + numeroAverias);
				System.out.println(averias);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, ps, c);
		}
	}

}
