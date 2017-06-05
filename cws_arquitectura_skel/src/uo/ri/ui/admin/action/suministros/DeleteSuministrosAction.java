package uo.ri.ui.admin.action.suministros;

import alb.util.console.Console;
import uo.ri.model.exception.BusinessException;
import uo.ri.ui.admin.action.util.TemplateCommand;

/**
 * Clase de la interfaz de usuario para borrar un repuesto suministrado por un
 * proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class DeleteSuministrosAction extends TemplateCommand {
	private String codigoRepuesto, codigoProveedor;

	@Override
	protected void pedirDatos() {
		codigoRepuesto = Console.readString("Código del repuesto");
		codigoProveedor = Console.readString("Código del proveedor");
	}

	@Override
	protected void procesarDatos() throws BusinessException {
		as.deleteSuministro(codigoRepuesto, codigoProveedor);
	}

	@Override
	protected void imprimirMensaje() {
		Console.println("Se ha eliminado el suministro");
	}

}
