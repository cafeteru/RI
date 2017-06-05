package uo.ri.ui.admin.action.proveedores;

import uo.ri.model.exception.BusinessException;
import uo.ri.ui.admin.action.util.TemplateCommand;
import alb.util.console.Console;

/**
 * Clase de la interfaz de usuario para borrar un proveedor.
 * 
 * @author Iv�n Gonz�lez Mahagamage
 *
 */
public class DeleteProveedorAction extends TemplateCommand {
	private String codigoProveedor;

	@Override
	protected void pedirDatos() {
		codigoProveedor = Console.readString("Codigo de proveedor");
	}

	@Override
	protected void procesarDatos() throws BusinessException {
		as.deleteProveedor(codigoProveedor);
	}

	@Override
	protected void imprimirMensaje() {
		Console.println("Se ha eliminado el proveedor");
	}

}
