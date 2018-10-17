package uo.ri.associations;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import uo.ri.model.Association;
import uo.ri.model.Averia;
import uo.ri.model.Cliente;
import uo.ri.model.DetallePedido;
import uo.ri.model.Intervencion;
import uo.ri.model.Mecanico;
import uo.ri.model.Pedido;
import uo.ri.model.Repuesto;
import uo.ri.model.Sustitucion;
import uo.ri.model.TipoVehiculo;
import uo.ri.model.Vehiculo;
import uo.ri.model.exception.BusinessException;

public class ContieneTest {
	private Mecanico mecanico;
	private Averia averia;
	private Intervencion intervencion;
	private Repuesto repuesto;
	private Sustitucion sustitucion;
	private Vehiculo vehiculo;
	private TipoVehiculo tipoVehiculo;
	private Cliente cliente;
	private DetallePedido detallesPedido;
	private Pedido pedido;

	@Before
	public void setUp() throws BusinessException {
		cliente = new Cliente("dni-cliente", "nombre", "apellidos");
		vehiculo = new Vehiculo("1234 GJI", "seat", "ibiza");
		Association.Poseer.link(cliente, vehiculo);

		tipoVehiculo = new TipoVehiculo("coche", 50.0);
		Association.Clasificar.link(tipoVehiculo, vehiculo);

		averia = new Averia(vehiculo, "falla la junta la trocla");

		mecanico = new Mecanico("dni-mecanico", "nombre", "apellidos");

		intervencion = new Intervencion(mecanico, averia);
		intervencion.setMinutos(60);

		repuesto = new Repuesto("R1001", "junta la trocla", 100.0, 5, 9, 2);
		sustitucion = new Sustitucion(repuesto, intervencion);

		pedido = new Pedido("asdasd");
		detallesPedido = new DetallePedido(pedido, repuesto, 25, 25.26);
	}

	@Test
	public void testSuministrarAdd() throws BusinessException {
		assertTrue(detallesPedido.getPedido().equals(pedido));
		assertTrue(detallesPedido.getRepuesto().equals(repuesto));

		assertTrue(repuesto.getDetallesPedidos().contains(detallesPedido));
		assertTrue(repuesto.getDetallesPedidos().size() == 1);

		assertTrue(pedido.getDetallesPedidos().contains(detallesPedido));
		assertTrue(pedido.getDetallesPedidos().size() == 1);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testSuministrarRemove() throws BusinessException {
		Association.Contiene.unlink(detallesPedido);

		assertTrue(detallesPedido.getPedido() == null);
		assertTrue(detallesPedido.getRepuesto() == null);

		assertTrue(!repuesto.getDetallesPedidos().contains(sustitucion));
		assertTrue(repuesto.getDetallesPedidos().size() == 0);

		assertTrue(!pedido.getDetallesPedidos().contains(sustitucion));
		assertTrue(pedido.getDetallesPedidos().size() == 0);
	}

	@Test
	public void testSafeReturnpedido() throws BusinessException {
		Set<DetallePedido> detallesPedidos = pedido.getDetallesPedidos();
		detallesPedidos.remove(detallesPedido);

		assertTrue(detallesPedidos.size() == 0);
		assertTrue(
				"Se debe retornar copia de la coleccion o hacerla de solo lectura",
				pedido.getDetallesPedidos().size() == 1);
	}

	@Test
	public void testSafeReturnRepuesto() throws BusinessException {
		Set<DetallePedido> detallesPedidos = repuesto.getDetallesPedidos();
		detallesPedidos.remove(detallesPedido);

		assertTrue(detallesPedidos.size() == 0);
		assertTrue(
				"Se debe retornar copia de la coleccion o hacerla de solo lectura",
				repuesto.getDetallesPedidos().size() == 1);
	}

}
