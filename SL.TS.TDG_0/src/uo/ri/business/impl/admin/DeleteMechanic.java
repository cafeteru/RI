package uo.ri.business.impl.admin;

import java.sql.SQLException;

import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

public class DeleteMechanic {
	private Long idMecanico;

	public DeleteMechanic(Long idMecanico) {
		this.idMecanico = idMecanico;
	}

	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getMecanicosGateway().borrarMecanico(idMecanico);
	}
}
