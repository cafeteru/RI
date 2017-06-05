package uo.ri.ui.admin.action.pedidos;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import alb.util.console.Console;
import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import uo.ri.ui.util.*;
import uo.ri.ui.util.interfaces.Command;

/**
 * Clase de la interfaz de usuario para recibir un pedido.
 * 
 * @author Iván González Mahagamage
 *
 */
public class RecibirPedidoAction implements Command {

	@Override
	public void execute() throws BusinessException, SQLException {
		Long idPedido = Console.readLong("Id de pedido");
		AdminService service = ServiceFactory.getAdminService();
		List<Map<String, Object>> repuestos = service
				.findRepuestosPedidoID(idPedido);
		PrinterAdapter.imprimirRepuestosPedido(repuestos);
		if (Preguntar.hacerPregunta("�El pedido esta correcto? (Si o no)")) {
			service.updateRepuestosExistenciasPrecio(repuestos, idPedido);
			service.updateFechaRecepcionEstadoPedido(idPedido);
			PrinterAdapter.print(
					"El pedido es correcto y se ha actualizado la base de datos");
		} else
			PrinterAdapter.print("El pedido no es correcto");
	}
}
