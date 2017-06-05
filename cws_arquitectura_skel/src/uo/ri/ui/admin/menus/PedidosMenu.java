package uo.ri.ui.admin.menus;

import alb.util.menu.NotYetImplementedAction;
import uo.ri.ui.admin.action.pedidos.ListarPedidosProveedorAction;
import uo.ri.ui.admin.action.pedidos.RecibirPedidoAction;
import uo.ri.ui.util.MenuExcepciones;

/**
 * Clase que crea el mení para administrar los pedidos
 * 
 * @author Iván González Mahagamage
 *
 */
public class PedidosMenu extends MenuExcepciones {
	/**
	 * Constructor por defecto.
	 *
	 */
	public PedidosMenu() {
		menuOptions = new Object[][] {
				{ "Administrador > Gestión de pedidos", null },

				{ "Generar pedido", NotYetImplementedAction.class },
				{ "Recibir pedido", RecibirPedidoAction.class },
				{ "Listar pedidos", ListarPedidosProveedorAction.class }, };
	}

}
