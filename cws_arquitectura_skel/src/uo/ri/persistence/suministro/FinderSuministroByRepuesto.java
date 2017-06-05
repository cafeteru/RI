package uo.ri.persistence.suministro;

import uo.ri.model.Suministro;
import uo.ri.persistence.util.FinderType;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la capa de persistencia que busca los proveedores que suministran un
 * repuesto.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FinderSuministroByRepuesto implements FinderType {
	private String codigoRepuesto;

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigoRepuesto
	 *            Código del respuesto.
	 */
	public FinderSuministroByRepuesto(String codigoRepuesto) {
		this.codigoRepuesto = codigoRepuesto;
	}

	@Override
	public Object execute() {
		return Jpa.getManager()
				.createNamedQuery("Suministro.findByRepuesto", Suministro.class)
				.setParameter(1, codigoRepuesto).getResultList();
	}

	@Override
	public String toString() {
		return "Buscar los proveedores que suministran el repuesto con código -> "
				+ codigoRepuesto;
	}

}
