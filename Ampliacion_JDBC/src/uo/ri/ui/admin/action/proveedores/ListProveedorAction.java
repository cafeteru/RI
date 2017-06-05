package uo.ri.ui.admin.action.proveedores;

import java.sql.SQLException;
import java.util.*;

import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import uo.ri.ui.util.PrinterAdapter;
import uo.ri.ui.util.interfaces.Command;

/**
 * Clase de la interfaz de usuario para listar a los proveedores.
 * 
 * @author Iván González Mahagamage
 *
 */
public class ListProveedorAction implements Command {

	@Override
	public void execute() throws BusinessException, SQLException {
		PrinterAdapter.print("\nListado de mec�nicos\n");
		AdminService service = ServiceFactory.getAdminService();
		List<Map<String, Object>> provedores = service.findAllProveedores();
		PrinterAdapter.imprimirListaProveedores(provedores);
	}
}
