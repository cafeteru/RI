package uo.ri.ui.admin.action.suministros;

import alb.util.console.Console;
import uo.ri.model.exception.BusinessException;
import uo.ri.ui.admin.action.util.TemplateCommand;

/**
 * Clase de la interfaz de usuario para añadir un repuesto suministrado por un
 * proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class AddSuministrosAction extends TemplateCommand {
	private String codigoRepuesto, codigoProveedor;
	private Double precio;

	@Override
	protected void pedirDatos() {
		codigoRepuesto = Console.readString("Código del repuesto");
		codigoProveedor = Console.readString("Código del proveedor");
		precio = Console.readDouble("Precio del repuesto");
	}

	@Override
	protected void procesarDatos() throws BusinessException {
		as.newSuministro(codigoRepuesto, codigoProveedor, precio);
	}

	@Override
	protected void imprimirMensaje() {
		Console.println("Nuevo repuesto ofrecido por el proveedor añadido");
	}
}
