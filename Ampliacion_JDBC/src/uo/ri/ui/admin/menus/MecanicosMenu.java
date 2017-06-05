package uo.ri.ui.admin.menus;

import alb.util.menu.BaseMenu;
import uo.ri.ui.admin.action.mecanicos.AddMechanicAction;
import uo.ri.ui.admin.action.mecanicos.DeleteMechanicAction;
import uo.ri.ui.admin.action.mecanicos.ListMechanicsAction;
import uo.ri.ui.admin.action.mecanicos.UpdateMechanicAction;

/**
 * Clase que crea el menú para administrar los mecánicos.
 * 
 * @author Iván González Mahagamage
 *
 */
public class MecanicosMenu extends BaseMenu {

	/**
	 * Constructor por defecto.
	 *
	 */
	public MecanicosMenu() {
		menuOptions = new Object[][] { 
			{"Administrador > Gesti�n de mec�nicos", null},
			
			{ "A�adir mec�nico", 				AddMechanicAction.class }, 
			{ "Modificar datos de mec�nico", 	UpdateMechanicAction.class }, 
			{ "Eliminar mec�nico", 				DeleteMechanicAction.class }, 
			{ "Listar mec�nicos", 				ListMechanicsAction.class },
		};
	}

}
