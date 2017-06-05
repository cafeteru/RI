package uo.ri.ui.admin.menus;

import alb.util.menu.BaseMenu;
import uo.ri.ui.admin.action.suministros.*;

/**
 * Clase que crea el menú para administrar los repuestos sumnistrador por los proveedores
 * 
 * @author Iván González Mahagamage
 *
 */
public class SuministrosMenu extends BaseMenu {

	/**
	 * Constructor por defecto.
	 *
	 */
	public SuministrosMenu() {
		menuOptions = new Object[][] { 
			{"Administrador > Gesti�n de repuestos suministrados por proveedor", null},
			
			{ "A�adir repuesto suministrado por proveedor", 				AddSuministrosAction.class }, 
			{ "Modificar datos de repuesto suministrado por proveedor", 	UpdateSuministrosAction.class }, 
			{ "Eliminar repuesto suministrado por proveedor", 				DeleteSuministrosAction.class }, 
			{ "Listar repuestos suministrado por proveedor", 				ListSuministrosAction.class },
		};
	}

}
