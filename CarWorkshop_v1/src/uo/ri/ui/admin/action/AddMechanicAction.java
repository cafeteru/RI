package uo.ri.ui.admin.action;

import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;
import uo.ri.business.admin.AddMechanic;
import uo.ri.common.BusinessException;

public class AddMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {		
		String nombre = Console.readString("Nombre");
		String apellidos = Console.readString("Apellidos");
		new AddMechanic(nombre, apellidos).execute();
		Printer.print("Nuevo mec�nico a�adido");
	}

}
