package uo.ri.business.impl.admin.mecanicos;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Mecanico;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la parte de lógica encargada de actualizar los datos de un mecánico.
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdateMechanic implements Command {
	private Mecanico mecanico;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param mecanico
	 *            Objeto de la clase Mecanico.
	 */
	public UpdateMechanic(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	@Override
	public Object execute() throws BusinessException {
		return Jpa.getManager().merge(mecanico);
	}

	@Override
	public String toString() {
		return "Actualizar al mecanico:\n\t" + mecanico;
	}
}
