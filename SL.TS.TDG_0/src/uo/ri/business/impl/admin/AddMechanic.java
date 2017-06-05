package uo.ri.business.impl.admin;

import java.sql.*;

import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

public class AddMechanic {
	private String nombre, apellidos;

	public AddMechanic(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getMecanicosGateway().añadirMecanico(nombre, apellidos);
	}

}
