package uo.ri.business.impl.admin.mecanicos;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Mecanico;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la parte de lógica encargada de borrar mecánico.
 * 
 * @author Iván González Mahagamage
 *
 */
public class DeleteMechanic implements Command {

	private Long idMecanico;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param idMecanico
	 *            Id del mecánico.
	 */
	public DeleteMechanic(Long idMecanico) {
		this.idMecanico = idMecanico;
	}

	/**
	 * Comprueba que el mecánico no tiene averías asignadas.
	 * 
	 * @param m
	 *            Objeto de la clase Mecanico
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	private void checkSinAsignadas(Mecanico m) throws BusinessException {
		if (m.getAverias().size() > 0) {
			throw new BusinessException(
					"No se puede borrar el mecanico, tiene averias asignadas");
		}
	}

	/**
	 * Comprueba que el mecánico no tiene intervenciones asignadas.
	 * 
	 * @param m
	 *            Objeto de la clase Mecanico
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	private void checkSinIntervenciones(Mecanico m) throws BusinessException {
		if (m.getIntervenciones().size() > 0) {
			throw new BusinessException(
					"No se puede borrar el mecanico, tiene intervenciones");
		}
	}

	/**
	 * Comprueba que el objeto de la clase Mecanico no es null.
	 * 
	 * @param m
	 *            Objeto de la clase Mecanico
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	private void checkNotNull(Mecanico m) throws BusinessException {
		if (m == null) {
			throw new BusinessException("No existe el mecanico");
		}
	}

	@Override
	public Object execute() throws BusinessException {
		Mecanico m = Jpa.getManager().find(Mecanico.class, idMecanico);
		checkNotNull(m);
		checkSinIntervenciones(m);
		checkSinAsignadas(m);
		Jpa.getManager().remove(m);
		return m;
	}

	@Override
	public String toString() {
		return "Borrar al mecanico con id -> " + idMecanico;
	}

}
