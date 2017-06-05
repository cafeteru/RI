package uo.ri.ui.admin.action.mecanicos;

import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import uo.ri.ui.util.PrinterAdapter;
import uo.ri.ui.util.interfaces.Command;

import java.sql.SQLException;

import alb.util.console.Console;

/**
 * Clase de la interfaz de usuario para actualizar los datos de un mecánico.
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdateMechanicAction implements Command {

	@Override
	public void execute() throws BusinessException, SQLException {
		Long id = Console.readLong("Id del mecánico");
		String nombre = Console.readString("Nombre");
		String apellidos = Console.readString("Apellidos");
		AdminService service = ServiceFactory.getAdminService();
		service.updateMechanic(id, nombre, apellidos);
		PrinterAdapter.print("mecánico actualizado");
	}

}
