package uo.ri.persistence.pedido;

import uo.ri.persistence.util.FinderType;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la capa de persistencia que busca un pedido por su código.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FinderPedidoByCodigo implements FinderType {
	private String codigoPedido;

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigoPedido
	 *            Código del pedido.
	 */
	public FinderPedidoByCodigo(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	@Override
	public Object execute() {
		return Jpa.getManager()
				.createNamedQuery("Pedido.findByCodigo", Long.class)
				.setParameter(1, codigoPedido).getSingleResult();
	}

	@Override
	public String toString() {
		return "Buscar pedido con el código -> " + codigoPedido;
	}
}
