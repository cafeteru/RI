package uo.ri.persistence.averia;

import java.util.ArrayList;
import java.util.List;

import uo.ri.model.*;
import uo.ri.persistence.util.FinderType;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la capa de persistencia que busca un listado de averías.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FinderAveriaByIds implements FinderType {
	private List<Long> idsAveria;

	/**
	 * Constructor con parámetros.
	 *
	 * @param idsAveria
	 *            Listado de averías.
	 */
	public FinderAveriaByIds(List<Long> idsAveria) {
		this.idsAveria = idsAveria;
	}

	@Override
	public Object execute() {
		List<Averia> averias = new ArrayList<Averia>();
		for (Long idAveria : idsAveria) {
			averias.add(Jpa.getManager()
					.createNamedQuery("Averia.findByIds", Averia.class)
					.setParameter(1, idAveria).getSingleResult());
		}
		return averias;
	}

	@Override
	public String toString() {
		return "Buscar averías por id -> " + idsAveria;
	}
}
