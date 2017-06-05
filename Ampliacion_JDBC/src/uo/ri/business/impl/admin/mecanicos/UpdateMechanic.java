package uo.ri.business.impl.admin.mecanicos;

import java.sql.SQLException;

import uo.ri.ui.util.interfaces.Command;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de lógica encargada de actualizar los datos de un mecánico.
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
	 *            ID del mecánico.
	 * @param nombre
	 *            Nombre del mecánico.
	 * @param apellidos
	 *            Apellidos del mecánico.
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
