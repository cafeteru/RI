package uo.ri.ui.admin.menus;

import uo.ri.ui.admin.action.suministros.*;
import uo.ri.ui.util.MenuExcepciones;

/**
 * Clase que crea el menú para administrar los repuestos suministrados por los
 * proveedores
 * 
 * @author Iván González Mahagamage
 *
 */
public class SuministrosMenu extends MenuExcepciones {

	/**
	 * Constructor por defecto.
	 *
	 */
	public SuministrosMenu() {
		menuOptions = new Object[][] {
				{ "Administrador > Gestión de repuestos suministrados por proveedor",
						null },

				{ "Añadir repuesto suministrado por proveedor",
						AddSuministrosAction.class },
				{ "Modificar datos de repuesto suministrado por proveedor",
						UpdateSuministrosAction.class },
				{ "Eliminar repuesto suministrado por proveedor",
						DeleteSuministrosAction.class },
				{ "Listar repuestos suministrado por proveedor",
						ListSuministrosAction.class }, };
	}

}
