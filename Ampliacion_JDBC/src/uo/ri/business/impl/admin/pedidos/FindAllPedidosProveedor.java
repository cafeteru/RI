package uo.ri.business.impl.admin.pedidos;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.ui.util.interfaces.CommandList;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de l�gica encargada de listar todos los pedidos de un
 * proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindAllPedidosProveedor implements CommandList {
	Long idProveedor;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param idProveedor
	 *            ID del proveedor.
	 */
	public FindAllPedidosProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	@Override
	public List<Map<String, Object>> execute()
			throws SQLException, BusinessException {
		return PersistencieFactory.getPedidosGateway()
				.listarPedidosProveedor(idProveedor);
	}
}
