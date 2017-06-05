package uo.ri.ui.admin.action.util;

import alb.util.menu.Action;
import uo.ri.business.AdminService;
import uo.ri.conf.ServicesFactory;
import uo.ri.model.exception.BusinessException;

/**
 * Clase de la capa de interfaz de usuario que implementa las acciones comunes a
 * todos los objetos Action y establece su estructura.
 * 
 * @author Iván González Mahagamage
 *
 */
public abstract class TemplateCommand implements Action {
	protected AdminService as;

	@Override
	public void execute() throws BusinessException {
		as = ServicesFactory.getAdminService();
		pedirDatos();
		procesarDatos();
		imprimirMensaje();
	}

	/**
	 * Método que pide datos al usuario.
	 *
	 */
	protected abstract void pedirDatos();

	/**
	 * Método que procesa los datos obtenidos del usuario.
	 * 
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	protected abstract void procesarDatos() throws BusinessException;

	/**
	 * Método que un mensaje para el usuario.
	 *
	 */
	protected abstract void imprimirMensaje();
}
