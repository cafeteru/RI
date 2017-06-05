package uo.ri.ui.admin;

import uo.ri.ui.admin.action.AddMechanicAction;
import uo.ri.ui.admin.action.DeleteMechanicAction;
import uo.ri.ui.admin.action.ListMechanicsAction;
import uo.ri.ui.admin.action.UpdateMechanicAction;
import alb.util.menu.BaseMenu;

public class MecanicosMenu extends BaseMenu {

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
