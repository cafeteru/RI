package uo.ri.business;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

/**
 * Interfaz de la parte de lógica que declara los métodos que usa la clase Cash
 * 
 * @author Iván González Mahagamage
 *
 */

public interface CashService {
	/**
	 * Crea la factura de las averías del cliente.
	 * 
	 * @param idsAveria
	 *            Lista de averias
	 * @return La factura del cliente.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	Map<String, Object> createInvoiceFor(List<Long> idsAveria)
			throws BusinessException, SQLException;
}
