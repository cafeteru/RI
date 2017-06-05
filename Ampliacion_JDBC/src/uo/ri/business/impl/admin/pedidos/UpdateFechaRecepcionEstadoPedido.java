package uo.ri.business.impl.admin.pedidos;

import java.sql.SQLException;

import uo.ri.ui.util.interfaces.Command;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de l�gica encargada de actualizar la fecha de recepci�n y
 * el estado de un pedido.
 * 
 * @author Iv�n Gonz�lez Mahagamage
 *
 */
public class UpdateFechaRecepcionEstadoPedido implements Command {
	Long idPedido;

	/**
	 * Constructor con par�metros.
	 * 
	 * @param idPedido
	 *            ID del pedido
	 */
	public UpdateFechaRecepcionEstadoPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	@Override
	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getPedidosGateway()
				.modificarFechaRecepcionEstadoPedido(idPedido);
	}
}
