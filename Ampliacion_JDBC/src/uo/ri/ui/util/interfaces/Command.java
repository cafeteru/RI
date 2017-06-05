package uo.ri.ui.util.interfaces;

import java.sql.SQLException;

import alb.util.menu.Action;
import uo.ri.common.BusinessException;

/**
 * Interfaz que es implementada por la clase que no devuelven alg�n objeto.
 * 
 * @author Iván González Mahagamage
 *
 */

public interface Command extends Action {
	/**
	 * Ejecuta la acción indica en la subclase.
	 * 
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	public abstract void execute() throws BusinessException, SQLException;
}
