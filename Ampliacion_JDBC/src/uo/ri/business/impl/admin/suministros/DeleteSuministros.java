package uo.ri.business.impl.admin.suministros;

import java.sql.SQLException;

import uo.ri.ui.util.interfaces.Command;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de l�gica encargada de borrar un repuesto suministrado por
 * un proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class DeleteSuministros implements Command {
	Long idRepuesto, idProveedor;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param idRepuesto
	 *            ID del repuesto.
	 * @param idProveedor
	 *            ID del proveedor.
	 */
	public DeleteSuministros(Long idRepuesto, Long idProveedor) {
		this.idRepuesto = idRepuesto;
		this.idProveedor = idProveedor;
	}

	@Override
	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getSuministrosGateway().borrarSuministros(idRepuesto, idProveedor);

	}

}
