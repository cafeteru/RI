package uo.ri.model;

import uo.ri.model.exception.BusinessException;

public class Association {

	public static class Poseer {

		public static void link(Cliente cliente, Vehiculo vehiculo) {
			vehiculo._setCliente(cliente);
			cliente._getVehiculos().add(vehiculo);
		}

		public static void unlink(Cliente cliente, Vehiculo vehiculo) {
			cliente._getVehiculos().remove(vehiculo);
			vehiculo._setCliente(null);
		}

	}

	public static class Clasificar {
		public static void link(TipoVehiculo tipoVehiculo, Vehiculo vehiculo) {
			vehiculo._setTipoVehiculo(tipoVehiculo);
			tipoVehiculo._getVehiculos().add(vehiculo);
		}

		public static void unlink(Vehiculo vehiculo,
				TipoVehiculo tipoVehiculo) {
			tipoVehiculo._getVehiculos().remove(vehiculo);
			vehiculo._setTipoVehiculo(null);
		}
	}

	public static class Pagar {
		public static void link(Cliente cliente, MedioPago medioPago) {
			medioPago._setCliente(cliente);
			cliente._getMediosPago().add(medioPago);
		}

		public static void unlink(Cliente cliente, MedioPago medioPago) {
			cliente._getMediosPago().remove(medioPago);
			medioPago._setCliente(null);
		}
	}

	public static class Averiar {

		public static void link(Vehiculo vehiculo, Averia averia) {
			averia._setVehiculo(vehiculo);
			vehiculo._getAverias().add(averia);
			vehiculo.incrementarNumAverias();
		}

		public static void unlink(Vehiculo vehiculo, Averia averia) {
			vehiculo._getAverias().remove(averia);
			vehiculo.disminuirNumAverias();
			averia._setVehiculo(null);
		}
	}

	public static class Facturar {
		public static void link(Factura factura, Averia averia) {
			averia._setFactura(factura);
			factura._getAverias().add(averia);
		}

		public static void unlink(Factura factura, Averia averia) {
			factura._getAverias().remove(averia);
			averia._setFactura(null);
		}
	}

	public static class Cargar {
		public static void link(Factura factura, MedioPago medioPago,
				Cargo cargo) {
			medioPago._getCargos().add(cargo);
			factura._getCargos().add(cargo);
			cargo._setFactura(factura);
			cargo._setMedioPago(medioPago);
		}

		public static void unlink(Cargo cargo) throws BusinessException {
			cargo.rewind();
			cargo._setMedioPago(null);
			cargo._setFactura(null);
		}
	}

	public static class Asignar {

		public static void link(Mecanico mecanico, Averia averia) {
			averia._setMecanico(mecanico);
			mecanico._getAsignadas().add(averia);
		}

		public static void unlink(Mecanico mecanico, Averia averia) {
			mecanico._getAsignadas().remove(averia);
			averia._setMecanico(null);
		}
	}

	public static class Intervenir {

		public static void link(Averia averia, Intervencion intervencion,
				Mecanico mecanico) {
			intervencion._setAveria(averia);
			intervencion._setMecanico(mecanico);
			averia._getIntervenciones().add(intervencion);
			mecanico._getIntervenciones().add(intervencion);
		}

		public static void unlink(Intervencion intervencion) {
			intervencion.getMecanico()._getIntervenciones()
					.remove(intervencion);
			intervencion.getAveria()._getIntervenciones().remove(intervencion);
			intervencion._setAveria(null);
			intervencion._setMecanico(null);
		}
	}

	public static class Sustituir {

		public static void link(Repuesto repuesto, Sustitucion sustitucion,
				Intervencion intervencion) {
			sustitucion._setIntervencion(intervencion);
			sustitucion._setRepuesto(repuesto);
			intervencion._getSustituciones().add(sustitucion);
			repuesto._getSustituciones().add(sustitucion);
		}

		public static void unlink(Sustitucion sustitucion) {
			sustitucion.getRepuesto()._getSustituciones().remove(sustitucion);
			sustitucion.getIntervencion()._getSustituciones()
					.remove(sustitucion);
			sustitucion._setIntervencion(null);
			sustitucion._setRepuesto(null);
		}
	}

	public static class Suministrar {
		public static void link(Repuesto repuesto, Suministro suministro,
				Proveedor proveedor) {
			suministro._setRepuesto(repuesto);
			suministro._setProveedor(proveedor);
			repuesto._getSuministros().add(suministro);
			proveedor._getSuministros().add(suministro);
		}

		public static void unlink(Suministro suministro) {
			suministro.getRepuesto()._getSuministros().remove(suministro);
			suministro.getProveedor()._getSuministros().remove(suministro);
			suministro._setProveedor(null);
			suministro._setRepuesto(null);
		}
	}

	public static class Contiene {
		public static void link(Repuesto repuesto, DetallePedido detallePedido,
				Pedido pedido) {
			detallePedido._setPedido(pedido);
			detallePedido._setRepuesto(repuesto);
			repuesto._getDetallesPedidos().add(detallePedido);
			pedido._getDetallesPedidos().add(detallePedido);
		}

		public static void unlink(DetallePedido detallePedido) {
			detallePedido.getPedido()._getDetallesPedidos()
					.remove(detallePedido);
			detallePedido.getRepuesto()._getDetallesPedidos()
					.remove(detallePedido);
			detallePedido._setPedido(null);
			detallePedido._setRepuesto(null);
		}
	}

	public static class Servir {
		public static void link(Proveedor proveedor, Pedido pedido) {
			pedido._setProveedor(proveedor);
			proveedor._getPedidos().add(pedido);
		}

		public static void unlink(Proveedor proveedor, Pedido pedido) {
			proveedor._getPedidos().remove(pedido);
			pedido._setProveedor(null);
		}
	}

}
