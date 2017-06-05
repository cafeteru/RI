package uo.ri.ui.admin.action.mecanicos;

import uo.ri.model.Mecanico;
import uo.ri.model.exception.BusinessException;
import uo.ri.ui.admin.action.util.TemplateCommand;
import alb.util.console.Console;

/**
 * Clase de la interfaz de usuario para añadir un mecánico.
 * 
 * @author Iván González Mahagamage
 *
 */
public class AddMechanicAction extends TemplateCommand {
	private String dni, nombre, apellidos;

	@Override
	public void pedirDatos() {
		dni = Console.readString("Dni");
		nombre = Console.readString("Nombre");
		apellidos = Console.readString("Apellidos");
	}

	@Override
	public void procesarDatos() throws BusinessException {
		as.newMechanic(new Mecanico(dni, nombre, apellidos));
	}

	@Override
	protected void imprimirMensaje() {
		Console.println("Nuevo mecánico añadido");
	}

}
