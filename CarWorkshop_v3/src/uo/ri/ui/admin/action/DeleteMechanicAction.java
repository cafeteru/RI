package uo.ri.ui.admin.action;

import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;

public class DeleteMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Long idMecanico = Console.readLong("Id de mecánico");
		AdminService service = ServiceFactory.getAdminService();
		service.deleteMechanic(idMecanico);
		Printer.print("Se ha eliminado el mecánico");
	}

}
