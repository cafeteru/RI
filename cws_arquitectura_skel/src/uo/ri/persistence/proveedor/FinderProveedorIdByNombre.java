package uo.ri.persistence.proveedor;

import uo.ri.persistence.util.FinderType;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la capa de persistencia que busca el id de un proveedor por su
 * nombre.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FinderProveedorIdByNombre implements FinderType {
	private String nombreProveedor;

	/**
	 * Constructor con parámetros.
	 *
	 * @param nombreProveedor
	 *            Nombre del proveedor.
	 */
	public FinderProveedorIdByNombre(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	@Override
	public Object execute() {
		return Jpa.getManager()
				.createNamedQuery("Proveedor.findIdByNombre", Long.class)
				.setParameter(1, nombreProveedor).getSingleResult();
	}

	@Override
	public String toString() {
		return "Buscar el id del proveedor con el nombre -> " + nombreProveedor;
	}

}
