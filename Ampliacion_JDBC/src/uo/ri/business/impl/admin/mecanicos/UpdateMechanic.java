package uo.ri.business.impl.admin.mecanicos;

import java.sql.SQLException;

import uo.ri.ui.util.interfaces.Command;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de l�gica encargada de actualizar los datos de un mec�nico.
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdateMechanic implements Command {
	private Long id;
	private String nombre, apellidos;

	/**
	 * Constructor con parámetros
	 * 
	 * @param id
	 *            ID del mec�nico.
	 * @param nombre
	 *            Nombre del mec�nico.
	 * @param apellidos
	 *            Apellidos del mec�nico.
	 */
	public UpdateMechanic(Long id, String nombre, String apellidos) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	@Override
	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getMecanicosGateway().actualizarMecanico(id, nombre,
				apellidos);
	}
}
