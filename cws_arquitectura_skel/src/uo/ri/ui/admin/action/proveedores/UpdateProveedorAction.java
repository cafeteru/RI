package uo.ri.ui.admin.action.proveedores;

import uo.ri.model.Proveedor;
import uo.ri.model.exception.BusinessException;
import uo.ri.ui.admin.action.util.TemplateCommand;
import uo.ri.ui.util.Preguntar;

import alb.util.console.Console;

/**
 * Clase de la interfaz de usuario que actualiza los datos de un proveedor
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdateProveedorAction extends TemplateCommand {
	String nombre, codigo;

	@Override
	protected void pedirDatos() {
		if (Preguntar
				.hacerPregunta("¿Sabe el nombre del proveedor? (Si o no)")) {
			nombre = Console.readString("Nombre del proveedor");
		} else {
			codigo = Console.readString("Código del proveedor");
		}
	}

	@Override
	protected void procesarDatos() throws BusinessException {
		Proveedor proveedor;
		if (nombre != null)
			proveedor = as.findProveedorByNombre(nombre);
		else
			proveedor = as.findProveedorByCodigo(codigo);
		nombre = Console.readString("Nombre");
		codigo = Console.readString("Código");
		proveedor.setNombre(nombre);
		proveedor.setCodigo(codigo);
		as.updateProveedor(proveedor);
	}

	@Override
	protected void imprimirMensaje() {
		Console.println("Proveedor actualizado");
	}

}
