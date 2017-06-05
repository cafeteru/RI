package uo.ri.business.impl.admin.proveedor;

import java.sql.SQLException;

import uo.ri.ui.util.interfaces.Command;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de lógica encargada de actualizar un proveedor sabiendo su
 * ID.
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdateProveedor implements Command {
	private Long id;
	private String nombre, codigo;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param id
	 *            ID del proveedor.
	 * @param nombre
	 *            Nombre del proveedor.
	 * @param codigo
	 *            Codigo del proveedor.
	 */
	public UpdateProveedor(Long id, String nombre, String codigo) {
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
	}

	@Override
	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getProveedoresGateway().actualizarProveedor(id,
				nombre, codigo);
	}
}
