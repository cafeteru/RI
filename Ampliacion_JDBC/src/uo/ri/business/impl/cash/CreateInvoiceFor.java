package uo.ri.business.impl.cash;

import java.sql.*;
import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de lógica encargada de crear una factura con las averías
 * indicadas.
 * 
 * @author Iván González Mahagamage
 *
 */

public class CreateInvoiceFor {
	private List<Long> idsAveria;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param idsAveria
	 *            Lista de averias
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	public CreateInvoiceFor(List<Long> idsAveria) throws SQLException {
		this.idsAveria = idsAveria;
	}

	/**
	 * Crea la factura para un cliente con la lista de averías.
	 * 
	 * @return Una factura
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	public Map<String, Object> execute()
			throws SQLException, BusinessException {
		return PersistencieFactory.getFacturasGateway().crearFactura(idsAveria);
	}
}
