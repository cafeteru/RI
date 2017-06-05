package uo.ri.ui.admin.action.proveedores;

import alb.util.console.Console;
import uo.ri.model.Proveedor;
import uo.ri.model.exception.BusinessException;
import uo.ri.ui.admin.action.util.TemplateCommand;

/**
 * Clase de la interfaz de usuario para añadir un proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class AddProveedorAction extends TemplateCommand {
	String nombre, codigo;

	@Override
	protected void pedirDatos() {
		nombre = Console.readString("Nombre");
		codigo = Console.readString("Código");
	}

	@Override
	protected void procesarDatos() throws BusinessException {
		as.newProveedor(new Proveedor(nombre, codigo));
	}

	@Override
	protected void imprimirMensaje() {
		Console.println("Nuevo proveedor añadido");
	}
}
