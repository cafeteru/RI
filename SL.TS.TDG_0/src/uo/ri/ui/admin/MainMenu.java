package uo.ri.ui.admin;

import alb.util.menu.BaseMenu;

public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { 
			{ "Administrador", null },
			{ "Gesti�n de mec�nicos", 			MecanicosMenu.class }, 
			{ "Gesti�n de repuestos", 			RepuestosMenu.class },
			{ "Gesti�n de tipos de veh�culo", 	TiposVehiculoMenu.class },
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}

}
