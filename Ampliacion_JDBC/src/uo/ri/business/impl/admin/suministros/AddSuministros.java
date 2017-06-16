package uo.ri.business.impl.admin.suministros;

import java.sql.SQLException;

import uo.ri.ui.util.interfaces.Command;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de l�gica encargada de a�adir un repuesto suministrado por
 * un proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class AddSuministros implements Command {
	Long idRepuesto, idProveedor;
	Double precio;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param idRepuesto
	 *            ID del repuesto.
	 * @param idProveedor
	 *            ID del proveedor.
	 * @param precio
	 *            Precio del repuesto.
	 */
	public AddSuministros(Long idRepuesto, Long idProveedor, Double precio) {
		this.idRepuesto = idRepuesto;
		this.idProveedor = idProveedor;
		this.precio = precio;
	}

	@Override
	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getSuministrosGateway()
				.añadirSuministros(idProveedor, idProveedor, precio);
	}

}
