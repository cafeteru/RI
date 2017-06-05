package uo.ri.ui.admin.action.proveedores;

import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import uo.ri.ui.util.PrinterAdapter;
import uo.ri.ui.util.interfaces.Command;

import java.sql.SQLException;

import alb.util.console.Console;

/**
 * Clase de la interfaz de usuario para borrar un proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class DeleteProveedorAction implements Command {

	@Override
	public void execute() throws BusinessException, SQLException {
		Long idProveedor = Console.readLong("Id de proveedor");
		AdminService service = ServiceFactory.getAdminService();
		service.deleteProveedor(idProveedor);
		PrinterAdapter.print("Se ha eliminado el proveedor");
	}

}
