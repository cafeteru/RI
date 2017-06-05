package uo.ri.ui.admin.action;

import java.util.*;

import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;

public class ListMechanicsAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Console.println("\nListado de mecánicos\n");
		AdminService service = ServiceFactory.getAdminService();
		List<Map<String, Object>> mecanicos = service.findAllMechanics();
		Printer.imprimirListaMecanicos(mecanicos);
	}
}
