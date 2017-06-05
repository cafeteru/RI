package uo.ri.ui.admin.action.pedidos;

import alb.util.console.Console;
import uo.ri.model.Pedido;
import uo.ri.model.exception.BusinessException;
import uo.ri.model.types.status.PedidoStatus;
import uo.ri.ui.admin.action.util.TemplateCommand;
import uo.ri.ui.util.Preguntar;
import uo.ri.ui.util.Printer;

/**
 * Clase de la interfaz de usuario para recibir un pedido.
 * 
 * @author Iván González Mahagamage
 *
 */
public class RecibirPedidoAction extends TemplateCommand {
	private String codigoPedido;
	private Pedido pedido;

	@Override
	public void execute() throws BusinessException {
		super.execute();
		if (Preguntar.hacerPregunta("¿El pedido esta correcto? (Si o no)")) {
			as.updatePedido(pedido);
			Console.println(
					"El pedido es correcto y se ha actualizado la base de datos");
		} else {
			Console.println("El pedido no es correcto");
		}
	}

	@Override
	protected void pedirDatos() {
		codigoPedido = Console.readString("Código de pedido");
	}

	@Override
	protected void procesarDatos() throws BusinessException {
		pedido = as.findRepuestosPedidoID(codigoPedido);
		if (pedido.getEstado().equals(PedidoStatus.RECIBIDO)) {
			throw new BusinessException("El pedido ya ha sido recibido");
		}
	}

	@Override
	protected void imprimirMensaje() {
		Printer.imprimirRepuestosPedido(pedido);
	}
}
