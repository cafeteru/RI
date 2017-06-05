package uo.ri.ui.admin.menus;

import alb.util.menu.BaseMenu;

import uo.ri.ui.admin.action.proveedores.*;

/**
 * Clase que crea el menú para administrar los proveedores
 * 
 * @author Iván González Mahagamage
 *
 */
public class ProveedoresMenu extends BaseMenu {

	/**
	 * Constructor por defecto.
	 */
	public ProveedoresMenu() {
		menuOptions = new Object[][] {
				{ "Administrador > Gesti�n de proveedores", null },

				{ "A�adir proveedor", AddProveedorAction.class },
				{ "Modificar datos de proveedor", UpdateProveedorAction.class },
				{ "Eliminar proveedor", DeleteProveedorAction.class },
				{ "Listar proveedor", ListProveedorAction.class }, };
	}

}
