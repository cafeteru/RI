package uo.ri.business.impl.admin.mecanicos;

import java.sql.SQLException;

import uo.ri.ui.util.interfaces.Command;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de lógica encargada de borrar mecánico.
 * 
 * @author Iván González Mahagamage
 *
 */
public class DeleteMechanic implements Command {
	private Long idMecanico;

	/**
	 * Constructor con parámetos.
	 * 
	 * @param idMecanico
	 *            Id del mecánico.
	 */
	public DeleteMechanic(Long idMecanico) {
		this.idMecanico = idMecanico;
	}

	@Override
	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getMecanicosGateway().borrarMecanico(idMecanico);
	}
}
