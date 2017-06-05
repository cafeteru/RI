package uo.ri.ui.admin.action.mecanicos;

import uo.ri.model.Mecanico;
import uo.ri.model.exception.BusinessException;
import uo.ri.ui.admin.action.util.TemplateCommand;
import alb.util.console.Console;

/**
 * Clase de la interfaz de usuario para actualizar los datos de un mecánico.
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdateMechanicAction extends TemplateCommand {
	private Long id;
	private String nombre, apellidos;

	@Override
	protected void pedirDatos() {
		id = Console.readLong("Id del mecánico");
		nombre = Console.readString("Nombre");
		apellidos = Console.readString("Apellidos");
	}

	@Override
	protected void procesarDatos() throws BusinessException {
		Mecanico m = as.findMechanicById(id);
		m.setNombre(nombre);
		m.setApellidos(apellidos);
		as.updateMechanic(m);
	}

	@Override
	protected void imprimirMensaje() {
		Console.println("Mecánico actualizado");
	}

}
