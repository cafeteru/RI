package uo.ri.business.impl.admin.proveedor;

import java.sql.SQLException;

import uo.ri.ui.util.interfaces.Command;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de lógica encargada de actualizar un proveedor
 * desconociendo su ID pero sabiendo su nombre.
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdateProveedorSinID implements Command {
	String nombre, codigo;
	String nombreNuevo;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param nombre
	 *            Nombre del proveedor.
	 * @param nombreNuevo
	 *            Nuevo nombre del proveedor.
	 * @param codigo
	 *            Codigo del proveedor.
	 */
	public UpdateProveedorSinID(String nombre, String nombreNuevo,
			String codigo) {
		this.nombre = nombre;
		this.nombreNuevo = nombreNuevo;
		this.codigo = codigo;
	}

	@Override
	public void execute() throws BusinessException, SQLException {
		Long id = PersistencieFactory.getProveedoresGateway()
				.buscarIDProveedor(nombre);
		PersistencieFactory.getProveedoresGateway().actualizarProveedor(id,
				nombreNuevo, codigo);
	}

}
