package uo.ri.business.impl.admin.pedidos;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Pedido;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.pedido.FinderPedidoByCodigo;
import uo.ri.persistence.util.Finder;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la parte de lógica encargada de listar todos los repuesto dentro de
 * un pedido.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindRepuestosPedidoID implements Command {
	String codigoPedido;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param codigoPedido
	 *            Código del pedido.
	 */
	public FindRepuestosPedidoID(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	@Override
	public Object execute() throws BusinessException {
		Long id = (Long) new Finder(new FinderPedidoByCodigo(codigoPedido))
				.execute();
		return Jpa.getManager().find(Pedido.class, id);
	}

	@Override
	public String toString() {
		return "Buscar los repuesto del pedido -> " + codigoPedido;
	}

}
