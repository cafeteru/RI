package uo.ri.ui.admin.action;

import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;

import java.sql.SQLException;

import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;

public class UpdateMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException, SQLException {
		Long id = Console.readLong("Id del mecánico");
		String nombre = Console.readString("Nombre");
		String apellidos = Console.readString("Apellidos");
		AdminService service = ServiceFactory.getAdminService();
		service.updateMechanic(id, nombre, apellidos);
		Printer.print("Mecánico actualizado");
	}

}
