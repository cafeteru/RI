package uo.ri.persistence.util;

/**
 * Interfaz de la capa de persistencia que estable la estructura de los
 * buscadores de objetos de la aplicación.
 * 
 * @author Iván González Mahagamage
 *
 */
public interface FinderType {

	/**
	 * Método que ejecuta una búsqueda.
	 * 
	 * @return El objeto que devuelve la búsqueda.
	 */
	public Object execute();

}
