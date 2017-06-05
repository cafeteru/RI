package uo.ri.ui.admin.action.mecanicos;

import uo.ri.model.exception.BusinessException;
import uo.ri.ui.admin.action.util.TemplateCommand;
import alb.util.console.Console;

/**
 * Clase de la interfaz de usuario para borrar a un mecánico.
 * 
 * @author Iván González Mahagamage
 *
 */
public class DeleteMechanicAction extends TemplateCommand {
	private Long idMecanico;

	@Override
	protected void procesarDatos() throws BusinessException {
		as.deleteMechanic(idMecanico);
	}

	@Override
	protected void pedirDatos() {
		idMecanico = Console.readLong("Id de mecánico");
	}

	@Override
	protected void imprimirMensaje() {
		Console.println("Se ha eliminado el mecánico");
	}

}
