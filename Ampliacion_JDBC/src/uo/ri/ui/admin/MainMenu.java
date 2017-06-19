package uo.ri.ui.admin;

import alb.util.menu.BaseMenu;
import uo.ri.ui.admin.menus.MecanicosMenu;
import uo.ri.ui.admin.menus.PedidosMenu;
import uo.ri.ui.admin.menus.ProveedoresMenu;
import uo.ri.ui.admin.menus.RepuestosMenu;
import uo.ri.ui.admin.menus.SuministrosMenu;

/**
 * Clase en la interfaz de usuario que crea el men� principal del administrador
 * 
 * @author Iv�n Gonz�lez Mahagamage
 *
 */
public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { 
			{ "Administrador", null },
			{ "Gestión de mecánicos", MecanicosMenu.class }, 
			{ "Gestión de repuestos (Ampliado)", RepuestosMenu.class },
			{ "Gestión de proveedores", ProveedoresMenu.class },
			{ "Gestión de los repuestos suministrados por proveedor", SuministrosMenu.class },
			{ "Gestión de pedidos", PedidosMenu.class },
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}

}
