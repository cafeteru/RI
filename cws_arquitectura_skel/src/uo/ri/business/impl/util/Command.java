package uo.ri.business.impl.util;

import uo.ri.model.exception.BusinessException;

/**
 * Interfaz que deben cumplir los objetos que realizan acciones en la capa de
 * lógica de la aplicación.
 * 
 * @author Iván González Mahagamage
 *
 */
public interface Command {
	/**
	 * Acción a realizar.
	 * 
	 * @return El objeto que usa para realizar la acción.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	Object execute() throws BusinessException;
}
