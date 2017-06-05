package uo.ri.persistence.proveedor;

import uo.ri.model.Proveedor;
import uo.ri.persistence.util.FinderType;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la capa de persistencia que busca todos los proveedores.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FinderProveedorAll implements FinderType {

	@Override
	public Object execute() {
		return Jpa.getManager()
				.createNamedQuery("Proveedor.findAll", Proveedor.class)
				.getResultList();

	}

	@Override
	public String toString() {
		return "Buscar todos los pedidos.";
	}

}
