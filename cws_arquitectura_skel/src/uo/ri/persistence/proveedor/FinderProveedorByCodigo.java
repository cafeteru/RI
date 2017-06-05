package uo.ri.persistence.proveedor;

import uo.ri.model.Proveedor;
import uo.ri.persistence.util.FinderType;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la capa de persistencia que busca un proveedor por su código.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FinderProveedorByCodigo implements FinderType {
	private String codigoProveedor;

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigoProveedor
	 *            Código del proveedor.
	 */
	public FinderProveedorByCodigo(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	@Override
	public Object execute() {
		return Jpa.getManager()
				.createNamedQuery("Proveedor.findByCodigo", Proveedor.class)
				.setParameter(1, codigoProveedor).getSingleResult();
	}

	@Override
	public String toString() {
		return "Buscar al proveedor con el código -> " + codigoProveedor;
	}
}
