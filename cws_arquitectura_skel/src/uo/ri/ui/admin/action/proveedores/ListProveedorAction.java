package uo.ri.ui.admin.action.proveedores;

import java.util.*;

import uo.ri.model.Proveedor;
import uo.ri.model.exception.BusinessException;
import uo.ri.ui.admin.action.util.TemplateCommand;
import uo.ri.ui.util.Printer;

/**
 * Clase de la interfaz de usuario para listar a los proveedores.
 * 
 * @author Iván González Mahagamage
 *
 */
public class ListProveedorAction extends TemplateCommand {
	private List<Proveedor> provedores;

	@Override
	protected void pedirDatos() {
	}

	@Override
	protected void procesarDatos() throws BusinessException {
		provedores = as.findAllProveedores();
	}

	@Override
	protected void imprimirMensaje() {
		Printer.imprimirListaProveedores(provedores);
	}
}
