package uo.ri.persistence;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

/**
 * Clase de la parte de persistencia encargada de manejar los datos de las
 * facturas.
 * 
 * @author Iván González Mahagamage
 *
 */
public interface FacturasGateway {
	/**
	 * M�todo que se encarga de conectarse a la base de datos.
	 * 
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 */
	void setConnection() throws BusinessException;

	/**
	 * M�todo que crea una factura en la base de datos.
	 * 
	 * @param idsAveria
	 *            Una lista de aver�as de la factura.
	 * @return Una Map con aver�as.
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	Map<String, Object> crearFactura(List<Long> idsAveria)
			throws SQLException, BusinessException;
}
