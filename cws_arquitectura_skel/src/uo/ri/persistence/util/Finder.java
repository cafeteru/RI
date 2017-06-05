package uo.ri.persistence.util;

import javax.persistence.NoResultException;
import uo.ri.model.exception.BusinessException;

/**
 * Clase de la capa de persistencia que busca objetos de la aplicación.
 * 
 * @author Iván González Mahagamage
 *
 */
public class Finder {
	private FinderType finderType;

	/**
	 * Constructor con parámetros.
	 *
	 * @param finderType
	 *            Buscador de un objeto determinado.
	 */
	public Finder(FinderType finderType) {
		this.finderType = finderType;
	}

	/**
	 * Método que realiza una búsqueda en la base de datos.
	 * 
	 * @return Un objeto de la base de datos.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	public Object execute() throws BusinessException {
		try {
			return finderType.execute();
		} catch (NoResultException e) {
			throw new BusinessException("No se encuentra el objeto indicado -> "
					+ finderType.toString());
		} catch (IllegalArgumentException e) {
			throw new BusinessException("La clave primaria no es correcta -> "
					+ finderType.toString());
		} catch (Exception e) {
			throw new BusinessException(
					e.getMessage() + "\n\t" + finderType.toString());
		}
	}
}
