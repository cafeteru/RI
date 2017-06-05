package uo.ri.ui.admin.menus;

import alb.util.menu.BaseMenu;
import alb.util.menu.NotYetImplementedAction;

/**
 * Clase que crea el menú para administrar los tipos de vehículos.
 * 
 * @author Iván González Mahagamage
 *
 */
public class TiposVehiculoMenu extends BaseMenu {

	/**
	 * Constructor por defecto.
	 *
	 */
	public TiposVehiculoMenu() {
		menuOptions = new Object[][] {
				{ "Administrador > Gestión de tipos de vehiculo", null },

				{ "Añadir tipo de vehiculo", NotYetImplementedAction.class },
				{ "Modificar datos de tipo de vehiculo",
						NotYetImplementedAction.class },
				{ "Eliminar tipo de vehiculo", NotYetImplementedAction.class },
				{ "Listar tipos de vehiculo",
						NotYetImplementedAction.class }, };
	}

}
