package uo.ri.business.impl.admin.mecanicos;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Mecanico;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la parte de lógica encargada de crear un nuevo mecánico.
 * 
 * @author Iván González Mahagamage
 *
 */
public class AddMechanic implements Command {

	private Mecanico mecanico;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param mecanico
	 *            Mecánico que vamos a añadir.
	 */
	public AddMechanic(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	@Override
	public String toString() {
		return "Añadir al mecanico \n\t" + mecanico;
	}

	@Override
	public Object execute() throws BusinessException {
		Jpa.getManager().persist(mecanico);
		return mecanico;
	}

}
