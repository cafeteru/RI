package uo.ri.ui.admin.action.suministros;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import alb.util.console.Console;
import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import uo.ri.ui.util.Preguntar;
import uo.ri.ui.util.PrinterAdapter;
import uo.ri.ui.util.interfaces.Command;

/**
 * Clase de la interfaz de usuario que lista los repuestos suministrados por un
 * proveedor o los proveedores que suministran un repuesto.
 * 
 * @author Iván González Mahagamage
 *
 */
public class ListSuministrosAction implements Command {

	@Override
	public void execute() throws BusinessException, SQLException {
		AdminService service = ServiceFactory.getAdminService();
		List<Map<String, Object>> repuestos = null;
		if (Preguntar
				.hacerPregunta("�Desea mostrar por proveedor? (Si o no)")) {
			Long idProveedor = Console.readLong("Id del proveedor");
			repuestos = service.findAllSuministrosProveedor(idProveedor);
		} else {
			Long idRepuesto = Console.readLong("Id del repuesto");
			repuestos = service.findAllSuministrosRepuesto(idRepuesto);
		}
		Console.println("\nListado de repuesto ofrecido por el proveedor\n");
		PrinterAdapter.imprimirListaSuministros(repuestos);
	}

}
