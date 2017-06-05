package uo.ri.ui.util.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

/**
 * Interfaz que es implementada por la clase que devuelven alg�n objeto.
 * 
 * @author Iván González Mahagamage
 *
 */
public interface CommandList {
	/**
	 * Crea una lista de todos los elementos que necesita la clase.
	 * 
	 * @return Una lista con toda la información indica en la clase.
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	public List<Map<String, Object>> execute()
			throws SQLException, BusinessException;
}
