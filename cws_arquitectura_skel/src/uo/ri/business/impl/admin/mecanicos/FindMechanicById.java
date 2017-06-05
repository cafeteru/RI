package uo.ri.business.impl.admin.mecanicos;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Mecanico;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la parte de lógica encargada de buscar a un mecánico a partir de un
 * Id.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindMechanicById implements Command {
	private Long id;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param id
	 *            Identificador del mecánico.
	 */
	public FindMechanicById(Long id) {
		this.id = id;
	}

	@Override
	public Object execute() throws BusinessException {
		return Jpa.getManager().find(Mecanico.class, id);
	}

	@Override
	public String toString() {
		return "Buscar al mecanico por el id ->" + id;
	}
}
