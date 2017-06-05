package uo.ri.persistence.suministro;

import uo.ri.model.Suministro;
import uo.ri.persistence.util.FinderType;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la capa de persistencia que busca todos los repuesto suministrados
 * por los proveedores.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FinderSuministroAll implements FinderType {

	@Override
	public Object execute() {
		return Jpa.getManager()
				.createNamedQuery("Suministro.findAll", Suministro.class)
				.getResultList();
	}

	@Override
	public String toString() {
		return "Buscar todos los suministros.";
	}

}
