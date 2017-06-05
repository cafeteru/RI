package uo.ri.ui.admin.action.proveedores;

import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import uo.ri.ui.util.Preguntar;
import uo.ri.ui.util.PrinterAdapter;
import uo.ri.ui.util.interfaces.Command;

import java.sql.SQLException;

import alb.util.console.Console;

/**
 * Clase de la interfaz de usuario que actualiza los datos de un proveedor
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdateProveedorAction implements Command {

	@Override
	public void execute() throws BusinessException, SQLException {
		Long id = null;
		String nombre = null, codigo = null;
		AdminService service = ServiceFactory.getAdminService();
		if (Preguntar.hacerPregunta("�Sabe el ID del proveedor? (Si o no)")) {
			id = Console.readLong("Id del proveedor");
			nombre = Console.readString("Nombre");
			codigo = Console.readString("C�digo");
			service.updateProveedor(id, nombre, codigo);
		} else {
			nombre = Console.readString("Nombre");
			String nombreNuevo = Console.readString("Nombre nuevo");
			codigo = Console.readString("C�digo");
			service.updateProveedorSinID(nombre, nombreNuevo, codigo);
		}
		PrinterAdapter.print("Proveedor actualizado");
	}

}
