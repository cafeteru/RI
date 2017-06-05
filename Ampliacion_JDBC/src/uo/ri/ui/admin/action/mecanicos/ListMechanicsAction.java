package uo.ri.ui.admin.action.mecanicos;

import java.sql.SQLException;
import java.util.*;

import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import uo.ri.ui.util.PrinterAdapter;
import uo.ri.ui.util.interfaces.Command;
import alb.util.console.Console;

/**
 * Clase de la interfaz de usuario para listar a los mecánicos.
 * 
 * @author Iván González Mahagamage
 *
 */
public class ListMechanicsAction implements Command {

	@Override
	public void execute() throws BusinessException, SQLException {
		Console.println("\nListado de mecánicos\n");
		AdminService service = ServiceFactory.getAdminService();
		List<Map<String, Object>> mecanicos = service.findAllMechanics();
		PrinterAdapter.imprimirListaMecanicos(mecanicos);
	}
}
