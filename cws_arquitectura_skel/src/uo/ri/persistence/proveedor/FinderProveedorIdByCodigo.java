package uo.ri.persistence.proveedor;

import uo.ri.persistence.util.FinderType;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la capa de persistencia que busca el id de un proveedor por su
 * código.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FinderProveedorIdByCodigo implements FinderType {
	private String codigoProveedor;

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigoProveedor
	 *            Código del proveedor
	 */
	public FinderProveedorIdByCodigo(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	@Override
	public Object execute() {
		return Jpa.getManager()
				.createNamedQuery("Proveedor.findIdByCodigo", Long.class)
				.setParameter(1, codigoProveedor).getSingleResult();
	}

	@Override
	public String toString() {
		return "Buscar el id del proveedor con el código -> " + codigoProveedor;
	}

}
