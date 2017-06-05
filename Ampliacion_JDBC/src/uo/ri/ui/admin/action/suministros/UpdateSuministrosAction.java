package uo.ri.ui.admin.action.suministros;

import java.sql.SQLException;

import alb.util.console.Console;
import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import uo.ri.ui.util.PrinterAdapter;
import uo.ri.ui.util.interfaces.Command;

/**
 * Clase que actualiza los datos de un repuesto ofrecido por un proveedor
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdateSuministrosAction implements Command {

	@Override
	public void execute() throws BusinessException, SQLException {
		Long idRepuesto = Console.readLong("Id del repuesto");
		Long idProveedor = Console.readLong("Id del proveedor");
		Double precio = Console.readDouble("Precio del repuesto");
		AdminService service = ServiceFactory.getAdminService();
		service.updateSuministro(idRepuesto, idProveedor, precio);
		PrinterAdapter.print("Repuesto ofrecido por el proveedor actualizado");
	}

}
