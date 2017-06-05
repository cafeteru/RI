package uo.ri.ui.admin.menus;

import alb.util.menu.BaseMenu;
import alb.util.menu.NotYetImplementedAction;

/**
 * Clase que crea el menú para administrar los repuestos.
 * 
 * @author Iván González Mahagamage
 *
 */
public class RepuestosMenu extends BaseMenu {

	/**
	 * Constructor por defecto.
	 *
	 */
	public RepuestosMenu() {
		menuOptions = new Object[][] {
				{ "Administrador > Gesti�n de repuestos", null },

				{ "A�adir repuesto", NotYetImplementedAction.class },
				{ "Modificar datos de repuesto",
						NotYetImplementedAction.class },
				{ "Eliminar repuesto", NotYetImplementedAction.class },
				{ "Listar repuestos", NotYetImplementedAction.class }, };
	}

}
