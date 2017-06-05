package uo.ri.ui.admin;

import uo.ri.ui.admin.menus.*;
import uo.ri.ui.util.MenuExcepciones;

public class MainMenu extends MenuExcepciones {
	/**
	 * Constructor por defecto.
	 *
	 */
	public MainMenu() {
		menuOptions = new Object[][] { { "Administrador", null },
				{ "Gestión de mecánicos", MecanicosMenu.class },
				{ "Gestión de repuestos", RepuestosMenu.class },
				{ "Gestión de proveedores", ProveedoresMenu.class },
				{ "Gestión de los repuestos suministrados por proveedor",
						SuministrosMenu.class },
				{ "Gestión de pedidos", PedidosMenu.class }, };
	}

	/**
	 * Método Main del programa
	 * 
	 * @param args
	 *            Argumentos que le pasamos.
	 */
	public static void main(String[] args) {
		new MainMenu().execute();
	}

}
