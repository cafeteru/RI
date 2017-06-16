package uo.ri.persistence.impl;

import java.sql.*;

import uo.ri.common.BusinessException;
import uo.ri.common.TratamientoExcepciones;

/**
 * Clase de la parte de persistencia que se encarga de realizar la conexi�n a la
 * base de datos.
 * 
 * @author Iván González Mahagamage
 *
 */
public class ConexionGateway {
	Connection c;
	PreparedStatement pst;
	ResultSet rs;

	/**
	 * Constructor por defecto.
	 * 
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	public ConexionGateway() throws SQLException, BusinessException {
		setConnection();
	}

	/**
	 * Método que se encarga de conectarse a la base de datos.
	 * 
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 */
	public void setConnection() throws BusinessException {
		c = TratamientoExcepciones.setConnection();
	}
}
