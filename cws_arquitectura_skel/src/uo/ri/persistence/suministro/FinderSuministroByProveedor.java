package uo.ri.persistence.suministro;

import uo.ri.model.Suministro;
import uo.ri.persistence.util.FinderType;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la capa de persistencia que busca los repuestos que suministra un
 * proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FinderSuministroByProveedor implements FinderType {
	private String codigoProveedor;

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigoProveedor
	 *            Código del proveedor.
	 */
	public FinderSuministroByProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	@Override
	public Object execute() {
		return Jpa.getManager()
				.createNamedQuery("Suministro.findByProveedor",
						Suministro.class)
				.setParameter(1, codigoProveedor).getResultList();
	}

	@Override
	public String toString() {
		return "Buscar los repuestos suministrados por el proveedor con el código -> "
				+ codigoProveedor;
	}
}
