package uo.ri.business.impl.admin;

import java.sql.SQLException;

import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

public class UpdateMechanic {
	private Long id;
	private String nombre, apellidos;

	public UpdateMechanic(Long id, String nombre, String apellidos) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getMecanicosGateway().actualizarMecanico(id, nombre, apellidos);
	}
}
