package uo.ri.ui.admin.action.mecanicos;

import java.sql.SQLException;

import alb.util.console.Console;
import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import uo.ri.ui.util.PrinterAdapter;
import uo.ri.ui.util.interfaces.Command;

/**
 * Clase de la interfaz de usuario para añadir un mecánico.
 * 
 * @author Iván González Mahagamage
 *
 */
public class AddMechanicAction implements Command {

	@Override
	public void execute() throws BusinessException, SQLException {
		String nombre = Console.readString("Nombre");
		String apellidos = Console.readString("Apellidos");
		AdminService service = ServiceFactory.getAdminService();
		service.newMechanic(nombre, apellidos);
		PrinterAdapter.print("Nuevo mec�nico a�adido");
	}

}
