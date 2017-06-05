package uo.ri.ui.admin.menus;

import uo.ri.ui.admin.action.proveedores.*;
import uo.ri.ui.util.MenuExcepciones;

/**
 * Clase que crea el menú para administrar los proveedores
 * 
 * @author Iván González Mahagamage
 *
 */
public class ProveedoresMenu extends MenuExcepciones {
	/**
	 * Constructor por defecto.
	 *
	 */
	public ProveedoresMenu() {
		menuOptions = new Object[][] {
				{ "Administrador > Gestión de proveedores", null },

				{ "Añadir proveedor", AddProveedorAction.class },
				{ "Modificar datos de proveedor", UpdateProveedorAction.class },
				{ "Eliminar proveedor", DeleteProveedorAction.class },
				{ "Listar proveedores", ListProveedorAction.class }, };
	}

}
