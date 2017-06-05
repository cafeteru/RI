package uo.ri.persistence.pedido;

import uo.ri.model.Pedido;
import uo.ri.persistence.util.FinderType;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la capa de persistencia que busca todos los pedidos realizados a un
 * proveedor
 * 
 * @author Iván González Mahagamage
 *
 */
public class FinderPedidoAllProveedor implements FinderType {
	private String codigoProveedor;

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigoProveedor
	 *            Código del proveedor.
	 */
	public FinderPedidoAllProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	@Override
	public Object execute() {
		return Jpa.getManager()
				.createNamedQuery("Pedido.findAllProveedor", Pedido.class)
				.setParameter(1, codigoProveedor).getResultList();
	}

	@Override
	public String toString() {
		return "Buscar pedidos del proveedor con código -> " + codigoProveedor;
	}

}
