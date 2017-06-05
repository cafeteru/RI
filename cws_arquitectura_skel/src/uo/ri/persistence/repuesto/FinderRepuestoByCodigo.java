package uo.ri.persistence.repuesto;

import uo.ri.model.Repuesto;
import uo.ri.persistence.util.FinderType;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la capa de persistencia que busca un repuesto por su código.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FinderRepuestoByCodigo implements FinderType {
	private String codigoRepuesto;

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigoRepuesto
	 *            Código del repuesto.
	 */
	public FinderRepuestoByCodigo(String codigoRepuesto) {
		this.codigoRepuesto = codigoRepuesto;
	}

	@Override
	public Object execute() {
		return Jpa.getManager()
				.createNamedQuery("Repuesto.findByCodigo", Repuesto.class)
				.setParameter(1, codigoRepuesto).getSingleResult();
	}

	@Override
	public String toString() {
		return "Buscar el repuesto con el código -> " + codigoRepuesto;
	}

}
