package uo.ri.ui.admin.action.pedidos;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import alb.util.console.Console;
import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import uo.ri.ui.util.PrinterAdapter;
import uo.ri.ui.util.interfaces.Command;

/**
 * Clase de la interfaz de usuario para listar los pedidos de un proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class ListarPedidosProveedorAction implements Command {

	@Override
	public void execute() throws BusinessException, SQLException {
		Long idProveedor = Console.readLong("Id de proveedor");
		AdminService service = ServiceFactory.getAdminService();
		List<Map<String, Object>> pedidos = service
				.findAllPedidosProveedor(idProveedor);
		PrinterAdapter.imprimirListaPedidosProveedor(pedidos);
	}

}
