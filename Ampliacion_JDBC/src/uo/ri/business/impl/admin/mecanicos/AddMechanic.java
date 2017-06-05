package uo.ri.business.impl.admin.mecanicos;

import java.sql.*;

import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;
import uo.ri.ui.util.interfaces.Command;

/**
 * Clase de la parte de l�gica encargada de crear un nuevo mec�nico.
 * 
 * @author Iv�n Gonz�lez Mahagamage
 *
 */
public class AddMechanic implements Command {
	private String nombre, apellidos;

	/**
	 * Constructor con par�metros.
	 * 
	 * @param nombre
	 *            Nombre del nuevo mec�nico.
	 * @param apellidos
	 *            Apellidos del nuevo mec�nico.
	 */
	public AddMechanic(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	@Override
	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getMecanicosGateway().añadirMecanico(nombre, apellidos);
	}

}
