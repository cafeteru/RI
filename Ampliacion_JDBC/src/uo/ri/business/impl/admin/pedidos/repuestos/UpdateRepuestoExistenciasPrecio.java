package uo.ri.business.impl.admin.pedidos.repuestos;

import java.sql.SQLException;

import uo.ri.ui.util.interfaces.Command;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de lógica encargada de actualizar las existencias y el
 * precio de un repuesto.
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdateRepuestoExistenciasPrecio implements Command {
	Long idRepuesto, idPedido;

	public UpdateRepuestoExistenciasPrecio(Long idRepuesto, Long idPedido) {
		this.idRepuesto = idRepuesto;
		this.idPedido = idPedido;
	}

	@Override
	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getPedidosGateway()
				.modificarExistenciasPrecioRepuesto(idRepuesto, idPedido);
	}

}
