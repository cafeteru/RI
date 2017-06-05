package uo.ri.business.impl.admin.pedidos;

import java.util.List;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Pedido;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.pedido.FinderPedidoAllProveedor;
import uo.ri.persistence.util.Finder;

/**
 * Clase de la parte de lógica encargada de listar todos los pedidos de un
 * proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindAllPedidosProveedor implements Command {
	String codigoProveedor;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param codigoProveedor
	 *            Código del proveedor.
	 */
	public FindAllPedidosProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object execute() throws BusinessException {
		return (List<Pedido>) new Finder(
				new FinderPedidoAllProveedor(codigoProveedor)).execute();
	}

	@Override
	public String toString() {
		return "Mostrar los pedido del provedor con codigo -> "
				+ codigoProveedor;
	}

}
