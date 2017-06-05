package uo.ri.ui.admin.action.mecanicos;

import java.util.List;

import uo.ri.model.Mecanico;
import uo.ri.model.exception.BusinessException;
import uo.ri.ui.admin.action.util.TemplateCommand;
import uo.ri.ui.util.Printer;

/**
 * Clase de la interfaz de usuario para listar a los mecánicos.
 * 
 * @author Iván González Mahagamage
 *
 */
public class ListMechanicsAction extends TemplateCommand {
	private List<Mecanico> mechanics;

	@Override
	protected void pedirDatos() {
	}

	@Override
	protected void procesarDatos() throws BusinessException {
		mechanics = as.findAllMechanics();
	}

	@Override
	protected void imprimirMensaje() {
		for (Mecanico m : mechanics) {
			Printer.printMechanic(m);
		}
	}
}
