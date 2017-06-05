package uo.ri.ui.admin.menus;

import alb.util.menu.NotYetImplementedAction;
import uo.ri.ui.util.MenuExcepciones;

/**
 * Clase que crea el menú para administrar los repuestos.
 * 
 * @author Iván González Mahagamage
 *
 */
public class RepuestosMenu extends MenuExcepciones {
	/**
	 * Constructor por defecto.
	 *
	 */
	public RepuestosMenu() {
		menuOptions = new Object[][] {
				{ "Administrador > Gestión de repuestos", null },

				{ "Añadir repuesto", NotYetImplementedAction.class },
				{ "Modificar datos de repuesto",
						NotYetImplementedAction.class },
				{ "Eliminar repuesto", NotYetImplementedAction.class },
				{ "Listar repuestos", NotYetImplementedAction.class }, };
	}

}
