package uo.ri.ui.admin.action;

import java.util.*;

import uo.ri.business.admin.FindAllMechanics;
import uo.ri.common.BusinessException;
import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;

public class ListMechanicsAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Console.println("\nListado de mecánicos\n");
		List<Map<String, Object>> mecanicos = new FindAllMechanics().execute();
		Printer.imprimirListaMecanicos(mecanicos);
	}
}
