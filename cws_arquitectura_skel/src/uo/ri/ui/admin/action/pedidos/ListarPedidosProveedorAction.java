package uo.ri.ui.admin.action.pedidos;

import java.util.List;
import alb.util.console.Console;
import uo.ri.model.Pedido;
import uo.ri.model.exception.BusinessException;
import uo.ri.ui.admin.action.util.TemplateCommand;
import uo.ri.ui.util.Printer;

/**
 * Clase de la interfaz de usuario para listar los pedidos de un proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class ListarPedidosProveedorAction extends TemplateCommand {
	private List<Pedido> pedidos;
	private String codigoProveedor;

	@Override
	protected void pedirDatos() {
		codigoProveedor = Console.readString("Código del proveedor");
	}

	@Override
	protected void procesarDatos() throws BusinessException {
		pedidos = as.findAllPedidosProveedor(codigoProveedor);
	}

	@Override
	protected void imprimirMensaje() {
		Console.println("\nListado de pedidos:");
		Printer.imprimirListaPedidosProveedor(pedidos);
	}

}
