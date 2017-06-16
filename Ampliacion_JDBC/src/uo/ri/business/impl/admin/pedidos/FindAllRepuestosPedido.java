package uo.ri.business.impl.admin.pedidos;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.ui.util.interfaces.CommandList;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de l�gica encargada de listar todos los pedidos en los que
 * aparezca un repuesto.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindAllRepuestosPedido implements CommandList {
	Long idPedido;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param idPedido
	 *            ID del pedido
	 */
	public FindAllRepuestosPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	@Override
	public List<Map<String, Object>> execute()
			throws SQLException, BusinessException {
		return PersistencieFactory.getPedidosGateway()
				.listarRepuestosPedidoId(idPedido);
	}

}
