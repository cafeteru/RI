package uo.ri.conf;

import java.sql.SQLException;

import uo.ri.common.BusinessException;
import uo.ri.persistence.*;
import uo.ri.persistence.impl.*;

/**
 * Clase que genera las clase de tipo Gateway (Modifican la base de datos).
 * 
 * @author Iván González Mahagamage
 *
 */
public class PersistencieFactory {

	/**
	 * Devuelve un objeto que maneja las facturas de la base de datos.
	 * 
	 * @return Un objeto que manega las facturas de la base de datos.
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	public static FacturasGateway getFacturasGateway()
			throws SQLException, BusinessException {
		return new FacturasGatewayImpl();
	}

	/**
	 * Devuelve un objeto que maneja los mec�nicos de la base de datos.
	 * 
	 * @return Un objeto que manega los mec�nicos de la base de datos.
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	public static MecanicosGateway getMecanicosGateway()
			throws SQLException, BusinessException {
		return new MecanicosGatewayImpl();
	}

	/**
	 * Devuelve un objeto que maneja los pedidos de la base de datos.
	 * 
	 * @return Un objeto que manega los pedidos de la base de datos.
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	public static PedidosGateway getPedidosGateway()
			throws SQLException, BusinessException {
		return new PedidosGatewayImpl();
	}

	/**
	 * Devuelve un objeto que maneja los proveedores de la base de datos.
	 * 
	 * @return Un objeto que manega los proveedores de la base de datos.
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	public static ProveedoresGateway getProveedoresGateway()
			throws SQLException, BusinessException {
		return new ProveedoresGatewayImpl();
	}

	/**
	 * Devuelve un objeto que maneja los suministos de la base de datos.
	 * 
	 * @return Un objeto que manega los suministos de la base de datos.
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	public static SuministrosGateway getSuministrosGateway()
			throws SQLException, BusinessException {
		return new SuministrosGatewayImpl();
	}

}
