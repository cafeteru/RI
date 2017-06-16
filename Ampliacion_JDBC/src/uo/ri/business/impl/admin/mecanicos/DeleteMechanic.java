package uo.ri.business.impl.admin.mecanicos;

import java.sql.SQLException;

import uo.ri.ui.util.interfaces.Command;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de l�gica encargada de borrar mec�nico.
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
	 *            Id del mec�nico.
	 */
	public DeleteMechanic(Long idMecanico) {
		this.idMecanico = idMecanico;
	}

	@Override
	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getMecanicosGateway().borrarMecanico(idMecanico);
	}
}
