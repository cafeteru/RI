package uo.ri.ui.admin.menus;

import uo.ri.ui.admin.action.mecanicos.AddMechanicAction;
import uo.ri.ui.admin.action.mecanicos.DeleteMechanicAction;
import uo.ri.ui.admin.action.mecanicos.ListMechanicsAction;
import uo.ri.ui.admin.action.mecanicos.UpdateMechanicAction;
import uo.ri.ui.util.MenuExcepciones;

/**
 * Clase que crea el menú para administrar los mecánicos.
 * 
 * @author Iván González Mahagamage
 *
 */
public class MecanicosMenu extends MenuExcepciones {

	/**
	 * Constructor por defecto.
	 *
	 */
	public MecanicosMenu() {
		menuOptions = new Object[][] {
				{ "Administrador > Gestión de mecánicos", null },

				{ "Añadir mecánico", AddMechanicAction.class },
				{ "Modificar datos de mecánico", UpdateMechanicAction.class },
				{ "Eliminar mecánico", DeleteMechanicAction.class },
				{ "Listar mecánicos", ListMechanicsAction.class }, };
	}

}
