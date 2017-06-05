package uo.ri.persistence;

import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

/**
 * Clase de la parte de persistencia encargada de manejar los datos de los
 * mecánicos.
 * 
 * @author Iván González Mahagamage
 *
 */
public interface MecanicosGateway {
	/**
	 * Método que se encarga de conectarse a la base de datos.
	 * 
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 */
	void setConnection() throws BusinessException;

	/**
	 * Método que a�ade un mecánico a la base de datos.
	 * 
	 * @param nombre
	 *            Nombre del mecánico.
	 * @param apellidos
	 *            Apellidos del mecánico.
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 */
	void añadirMecanico(String nombre, String apellidos)
			throws BusinessException;

	/**
	 * Método que borra un mecánico de la base de datos.
	 * 
	 * @param idMecanico
	 *            ID del mecánico.
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 */
	void borrarMecanico(Long idMecanico) throws BusinessException;

	/**
	 * Método que lista todos los mecánicos de la base de datos.
	 * 
	 * @return Una lista con los mecánicos de la base de datos.
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 */
	List<Map<String, Object>> listarMecanicos() throws BusinessException;

	/**
	 * Método que actualiza la información de un mecánico de la base de datos.
	 * 
	 * @param id
	 *            ID del mecánico.
	 * @param nombre
	 *            Nombre del mecánico.
	 * @param apellidos
	 *            Apellidos del mecánico.
	 * @throws BusinessException
	 *             Excepción ocurrida al realizar el programa.
	 */
	void actualizarMecanico(Long id, String nombre, String apellidos)
			throws BusinessException;
}
