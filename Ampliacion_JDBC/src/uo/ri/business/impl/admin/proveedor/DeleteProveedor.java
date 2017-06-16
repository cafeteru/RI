package uo.ri.business.impl.admin.proveedor;

import java.sql.SQLException;

import uo.ri.ui.util.interfaces.Command;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de l�gica encargada de borrar un proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class DeleteProveedor implements Command {
	Long idProveedor;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param idProveedor
	 *            ID del proveedor.
	 */
	public DeleteProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	@Override
	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getProveedoresGateway()
				.borrarProveedor(idProveedor);
	}
}
