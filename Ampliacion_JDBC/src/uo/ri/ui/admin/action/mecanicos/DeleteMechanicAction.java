package uo.ri.ui.admin.action.mecanicos;

import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import uo.ri.ui.util.PrinterAdapter;
import uo.ri.ui.util.interfaces.Command;

import java.sql.SQLException;

import alb.util.console.Console;

/**
 * Clase de la interfaz de usuario para borrar a un mecánico.
 * 
 * @author Iván González Mahagamage
 *
 */
public class DeleteMechanicAction implements Command {

	@Override
	public void execute() throws BusinessException, SQLException {
		Long idMecanico = Console.readLong("Id de mec�nico");
		AdminService service = ServiceFactory.getAdminService();
		service.deleteMechanic(idMecanico);
		PrinterAdapter.print("Se ha eliminado el mec�nico");
	}

}
