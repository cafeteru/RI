package uo.ri.associations;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import uo.ri.model.Association;
import uo.ri.model.Pedido;
import uo.ri.model.Proveedor;
import uo.ri.model.exception.BusinessException;

public class ServirTest {
	private Proveedor proveedor;
	private Pedido pedido;

	@Before
	public void setUp() throws BusinessException {
		proveedor = new Proveedor("asdfadf");
		pedido = new Pedido("afr");
		Association.Servir.link(proveedor, pedido);
	}

	@Test
	public void testAsignarLinked() throws BusinessException {
		assertTrue(proveedor.getPedidos().contains(pedido));
		assertTrue(pedido.getProveedor().equals(proveedor));
	}

	@Test
	public void testAsignarUnlink() throws BusinessException {
		Association.Servir.unlink(proveedor, pedido);

		assertTrue(!proveedor.getPedidos().contains(pedido));
		assertTrue(proveedor.getPedidos().size() == 0);
		assertTrue(pedido.getProveedor() == null);
	}

	@Test
	public void testSafeReturn() throws BusinessException {
		Set<Pedido> pedidos = proveedor.getPedidos();
		pedidos.remove(pedido);

		assertTrue(pedidos.size() == 0);
		assertTrue(
				"Se debe retornar copia de la coleccion o hacerla de solo lectura",
				proveedor.getPedidos().size() == 1);
	}

}
