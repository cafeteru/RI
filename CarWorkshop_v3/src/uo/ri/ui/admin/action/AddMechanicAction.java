package uo.ri.ui.admin.action;

import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;
import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;

public class AddMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {
		String nombre = Console.readString("Nombre");
		String apellidos = Console.readString("Apellidos");
		AdminService service = ServiceFactory.getAdminService();
		service.newMechanic(nombre, apellidos);
		Printer.print("Nuevo mecánico añadido");
	}

}
