package uo.ri.business.impl.admin.suministros;

import java.sql.SQLException;

import uo.ri.ui.util.interfaces.Command;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de lógica encargada de actualizar la información de un
 * repuesto suministrado por un proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdateSuministros implements Command {
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
	public UpdateSuministros(Long idRepuesto, Long idProveedor, Double precio) {
		this.idRepuesto = idRepuesto;
		this.idProveedor = idProveedor;
		this.precio = precio;
	}

	@Override
	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getSuministrosGateway().actualizarSuministro(idRepuesto, idProveedor, precio);
	}

}
