package uo.ri.ui.admin.action;

import java.util.*;

import uo.ri.business.AdminService;
import uo.ri.business.impl.AdminServiceImpl;
import uo.ri.common.BusinessException;
import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;

public class ListMechanicsAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Console.println("\nListado de mecánicos\n");
		AdminService service = new AdminServiceImpl();
		List<Map<String, Object>> mecanicos = service.findAllMechanics();
		Printer.imprimirListaMecanicos(mecanicos);
	}
}
