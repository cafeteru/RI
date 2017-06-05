package uo.ri.ui.admin.menus;

import alb.util.menu.BaseMenu;
import alb.util.menu.NotYetImplementedAction;
import uo.ri.ui.admin.action.pedidos.ListarPedidosProveedorAction;
import uo.ri.ui.admin.action.pedidos.RecibirPedidoAction;

/**
 * Clase que crea el menú para administrar los pedidos.
 * 
 * @author Iván González Mahagamage
 *
 */
public class PedidosMenu extends BaseMenu {

	/**
	 * Constructor por defecto.
	 *
	 */
	public PedidosMenu() {
		menuOptions = new Object[][] {
				{ "Administrador > Gesti�n de pedidos", null },

				{ "Generar pedido", NotYetImplementedAction.class },
				{ "Recibir pedido", RecibirPedidoAction.class },
				{ "Listar pedidos de un proveedor",
						ListarPedidosProveedorAction.class }, };
	}

}
