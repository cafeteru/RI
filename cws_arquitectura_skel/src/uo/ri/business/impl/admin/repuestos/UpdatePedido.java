package uo.ri.business.impl.admin.repuestos;

import alb.util.date.DateUtil;
import alb.util.math.Round;
import uo.ri.business.impl.util.Command;
import uo.ri.model.*;
import uo.ri.model.exception.BusinessException;
import uo.ri.model.types.status.PedidoStatus;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la parte de lógica encargada de actualizar la base de datos y un
 * pedido al recibir este.
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdatePedido implements Command {
	private Pedido pedido;

	/**
	 * Constructor con parámetros.
	 *
	 * @param pedido
	 *            Objeto de la clase Pedido
	 */
	public UpdatePedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public Object execute() throws BusinessException {
		actualizarRepuestosPedido();
		pedido.setFechaRecepcion(DateUtil.today());
		pedido.setEstado(PedidoStatus.RECIBIDO);
		return Jpa.getManager().merge(pedido);
	}

	/**
	 * Modifica los datos de los repuesto contenidos en el pedido.
	 */
	private void actualizarRepuestosPedido() {
		for (DetallePedido detallePedido : pedido.getDetallesPedidos()) {
			Repuesto repuesto = Jpa.getManager().find(Repuesto.class,
					detallePedido.getRepuesto().getId());
			repuesto.setExistencias(
					repuesto.getExistencias() + detallePedido.getUnidades());
			repuesto.setPrecio(calcularMedia(repuesto.getExistencias(),
					repuesto.getPrecio(), detallePedido.getUnidades(),
					detallePedido.getPrecio()));
			Jpa.getManager().merge(repuesto);
		}
	}

	/**
	 * Calcula el nuevo precio de un repuesto después de recibir un pedido.
	 * 
	 * @param existencias
	 *            Número de existencias antes de la recepción del pedido.
	 * @param precioExistencias
	 *            Precio del repuesto antes de la recepción del pedido.
	 * @param unidades
	 *            Unidades del repuesto dentro del pedido.
	 * @param precioUnidades
	 *            Precio unidad del repuesto dentro del pedido.
	 * @param existenciasTotales
	 *            La suma de existencias y unidades.
	 * @return Nuevo precio del repuesto.
	 */
	private static double calcularMedia(int existencias,
			double precioExistencias, int unidades, double precioUnidades) {
		double precioExistenciasTotal = precioExistencias * existencias;
		double precioUnidadesTotal = precioUnidades * unidades;
		double resultado = (precioExistenciasTotal + precioUnidadesTotal)
				/ (existencias + unidades);
		return Round.twoCents(resultado);
	}

	@Override
	public String toString() {
		return "Actualizar el pedido\n\t" + pedido;
	}

}
