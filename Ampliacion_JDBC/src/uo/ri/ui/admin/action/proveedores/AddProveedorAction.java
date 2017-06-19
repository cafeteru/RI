package uo.ri.ui.admin.action.proveedores;

import java.sql.SQLException;

import alb.util.console.Console;
import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import uo.ri.ui.util.PrinterAdapter;
import uo.ri.ui.util.interfaces.Command;

/**
 * Clase de la interfaz de usuario para añadir un proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class AddProveedorAction implements Command {

	@Override
	public void execute() throws BusinessException, SQLException {
		String nombre = Console.readString("Nombre");
		String codigo = Console.readString("Código");
		AdminService service = ServiceFactory.getAdminService();
		service.newProveedor(nombre, codigo);
		PrinterAdapter.print("Nuevo proveedor añadido");
	}
}
