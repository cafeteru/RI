package uo.ri.ui.admin.action.suministros;

import java.util.List;

import uo.ri.model.Suministro;
import uo.ri.model.exception.BusinessException;
import uo.ri.ui.admin.action.util.TemplateCommand;
import uo.ri.ui.util.Printer;

/**
 * Clase de la interfaz de usuario que lista los repuestos suministrados por un
 * proveedor o los proveedores que suministran un repuesto.
 * 
 * @author Iván González Mahagamage
 *
 */
public class ListSuministrosAction extends TemplateCommand {
	private List<Suministro> suministros;

	@Override
	protected void pedirDatos() {
	}

	@Override
	protected void procesarDatos() throws BusinessException {
		suministros = as.findAllSuministros();
	}

	@Override
	protected void imprimirMensaje() {
		Printer.imprimirListaSuministros(suministros);
	}

}
