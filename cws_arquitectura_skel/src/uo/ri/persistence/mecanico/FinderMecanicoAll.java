package uo.ri.persistence.mecanico;

import uo.ri.model.Mecanico;
import uo.ri.persistence.util.FinderType;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la capa de persistencia que busca todos los mecánicos.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FinderMecanicoAll implements FinderType {

	@Override
	public Object execute() {
		return Jpa.getManager()
				.createNamedQuery("Mecanico.findAll", Mecanico.class)
				.getResultList();
	}

	@Override
	public String toString() {
		return "Buscar todos los mecánicos.";
	}

}
