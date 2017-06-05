package uo.ri.ui.foreman;

import alb.util.menu.BaseMenu;
import alb.util.menu.NotYetImplementedAction;

public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { 
			{ "Jefe de Taller", null },
			{ "Recepci�n en taller", RecepcionMenu.class }, 
			{ "Gesti�n de clientes", ClientesMenu.class },
			{ "Gesti�n de veh�culos", VehiculosMenu.class },
			{ "Revisar historial de un cliente", NotYetImplementedAction.class }, 
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}

}
