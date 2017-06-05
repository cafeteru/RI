package uo.ri.model;

/**
 * Clase del modelo de dominio que controla las relaciones de la clase entre sí.
 * 
 * @author Iván González Mahagamage
 *
 */
public class Association {

	/**
	 * Clase estática que maneja la relación entre clientes y vehiculos.
	 * 
	 * @author Iván González Mahagamage
	 *
	 */
	public static class Poseer {
		/**
		 * Método estático que crea la relácion.
		 * 
		 * @param cliente
		 *            Objeto de la clase Cliente.
		 * @param vehiculo
		 *            Objeto de la clase Vehiculo.
		 */
		public static void link(Cliente cliente, Vehiculo vehiculo) {
			vehiculo._setCliente(cliente);
			cliente._getVehiculos().add(vehiculo);
		}

		/**
		 * Método estático que elimina la relácion.
		 * 
		 * @param cliente
		 *            Objeto de la clase Cliente.
		 * @param vehiculo
		 *            Objeto de la clase Vehiculo.
		 */
		public static void unlink(Cliente cliente, Vehiculo vehiculo) {
			cliente._getVehiculos().remove(vehiculo);
			vehiculo._setCliente(null);
		}
	}

	/**
	 * Clase estática que maneja la relación entre vehículos y tipos de
	 * vehículos.
	 * 
	 * @author Iván González Mahagamage
	 *
	 */
	public static class Clasificar {
		/**
		 * Método estático que crea la relácion.
		 * 
		 * @param tipoVehiculo
		 *            Objeto de la clase TipoVehiculo.
		 * @param vehiculo
		 *            Objeto de la clase Vehiculo.
		 */
		public static void link(TipoVehiculo tipoVehiculo, Vehiculo vehiculo) {
			vehiculo._setTipo(tipoVehiculo);
			tipoVehiculo._getVehiculos().add(vehiculo);
		}

		/**
		 * Método estático que elimina la relácion.
		 * 
		 * @param tipoVehiculo
		 *            Objeto de la clase TipoVehiculo.
		 * @param vehiculo
		 *            Objeto de la clase Vehiculo.
		 */
		public static void unlink(TipoVehiculo tipoVehiculo,
				Vehiculo vehiculo) {
			tipoVehiculo._getVehiculos().remove(vehiculo);
			vehiculo._setTipo(null);
		}
	}

	/**
	 * Clase estática que maneja la relación entre medios de pago y clientes.
	 * 
	 * @author Iván González Mahagamage
	 *
	 */
	public static class Pagar {
		/**
		 * Método estático que crea la relácion.
		 * 
		 * @param medioPago
		 *            Objeto de la clase MedioPago.
		 * @param cliente
		 *            Objeto de la clase Cliente.
		 */
		public static void link(MedioPago medioPago, Cliente cliente) {
			medioPago._setCliente(cliente);
			cliente._getMediosPagos().add(medioPago);
		}

		/**
		 * Método estático que elimina la relácion.
		 * 
		 * @param cliente
		 *            Objeto de la clase Cliente.
		 * @param medioPago
		 *            Objeto de la clase MedioPago.
		 */
		public static void unlink(Cliente cliente, MedioPago medioPago) {
			cliente._getMediosPagos().remove(medioPago);
			medioPago._setCliente(null);
		}
	}

	/**
	 * Clase estática que maneja la relación entre vehículos y averías.
	 * 
	 * @author Iván González Mahagamage
	 *
	 */
	public static class Averiar {
		/**
		 * Método estático que crea la relácion.
		 * 
		 * @param vehiculo
		 *            Objeto de la clase Vehiculo.
		 * @param averia
		 *            Objeto de la clase Averia.
		 */
		public static void link(Vehiculo vehiculo, Averia averia) {
			averia._setVehiculo(vehiculo);
			vehiculo._getAverias().add(averia);
		}

		/**
		 * Método estático que elimina la relácion.
		 * 
		 * @param vehiculo
		 *            Objeto de la clase Vehiculo.
		 * @param averia
		 *            Objeto de la clase Averia.
		 */
		public static void unlink(Vehiculo vehiculo, Averia averia) {
			vehiculo._getAverias().remove(averia);
			averia._setVehiculo(null);
		}
	}

	/**
	 * Clase estática que maneja la relación entre facturas y averías.
	 * 
	 * @author Iván González Mahagamage
	 *
	 */
	public static class Facturar {
		/**
		 * Método estático que crea la relácion.
		 * 
		 * @param factura
		 *            Objeto de la clase Factura.
		 * @param averia
		 *            Objeto de la clase Averia.
		 */
		public static void link(Factura factura, Averia averia) {
			averia._setFactura(factura);
			factura._getAverias().add(averia);
		}

		/**
		 * Método estático que elimina la relácion.
		 * 
		 * @param factura
		 *            Objeto de la clase Factura.
		 * @param averia
		 *            Objeto de la clase Averia.
		 */
		public static void unlink(Factura factura, Averia averia) {
			factura._getAverias().remove(averia);
			averia._setFactura(null);
		}

	}

	/**
	 * Clase estática que maneja la relación entre los medios de pago, los
	 * cargos y las facturas.
	 * 
	 * @author Iván González Mahagamage
	 *
	 */
	public static class Cargar {
		/**
		 * Método estático que crea la relácion.
		 * 
		 * @param medioPago
		 *            Objeto de la clase MedioPago
		 * @param cargo
		 *            Objeto de la clase Cargo
		 * @param factura
		 *            Objeto de la clase Factura
		 */
		public static void link(MedioPago medioPago, Cargo cargo,
				Factura factura) {
			cargo._setMedioPago(medioPago);
			cargo._setFactura(factura);
			medioPago._getCargos().add(cargo);
			factura._getCargos().add(cargo);
		}

		/**
		 * Método estático que elimina la relácion.
		 * 
		 * @param cargo
		 *            Objeto de la clase Cargo
		 */
		public static void unlink(Cargo cargo) {
			cargo.getFactura()._getCargos().remove(cargo);
			cargo.getMedioPago()._getCargos().remove(cargo);
			cargo._setFactura(null);
			cargo._setMedioPago(null);
		}
	}

	/**
	 * Clase estática que maneja la relación entre los mecánicos y averías.
	 * 
	 * @author Iván González Mahagamage
	 *
	 */
	public static class Asignar {
		/**
		 * Método estático que crea la relácion.
		 * 
		 * @param mecanico
		 *            Objeto de la clase Mecanico.
		 * @param averia
		 *            Objeto de la clase Averia.
		 */
		public static void link(Mecanico mecanico, Averia averia) {
			averia._setMecanico(mecanico);
			mecanico._getAverias().add(averia);
		}

		/**
		 * Método estático que elimina la relácion.
		 * 
		 * @param mecanico
		 *            Objeto de la clase Mecanico.
		 * @param averia
		 *            Objeto de la clase Averia.
		 */
		public static void unlink(Mecanico mecanico, Averia averia) {
			mecanico._getAverias().remove(averia);
			averia._setMecanico(null);
		}
	}

	/**
	 * Clase estática que maneja la relación entre averías, intervenciones y
	 * mecánicos.
	 * 
	 * @author Iván González Mahagamage
	 *
	 */
	public static class Intervenir {
		/**
		 * Método estático que crea la relácion.
		 * 
		 * @param averia
		 *            Objeto de la clase Averia.
		 * @param intervencion
		 *            Objeto de la clase Intervencion.
		 * @param mecanico
		 *            Objeto de la clase Mecanico.
		 */
		public static void link(Averia averia, Intervencion intervencion,
				Mecanico mecanico) {
			intervencion._setAveria(averia);
			intervencion._setMecanico(mecanico);
			averia._getIntervenciones().add(intervencion);
			mecanico._getIntervenciones().add(intervencion);
		}

		/**
		 * Método estático que elimina la relácion.
		 * 
		 * @param intervencion
		 *            Objeto de la clase Intervencion.
		 */
		public static void unlink(Intervencion intervencion) {
			intervencion.getAveria()._getIntervenciones().remove(intervencion);
			intervencion.getMecanico()._getIntervenciones()
					.remove(intervencion);
			intervencion._setAveria(null);
			intervencion._setMecanico(null);
		}
	}

	/**
	 * Clase estática que maneja la relación entre repuestos, sustituciones e
	 * intervenciones.
	 * 
	 * @author Iván González Mahagamage
	 *
	 */
	public static class Sustituir {
		/**
		 * Método estático que crea la relácion.
		 * 
		 * @param repuesto
		 *            Objeto de la clase Repuesto.
		 * @param sustitucion
		 *            Objeto de la clase Sustitucion.
		 * @param intervencion
		 *            Objeto de la clase Intervencion.
		 */
		public static void link(Repuesto repuesto, Sustitucion sustitucion,
				Intervencion intervencion) {
			sustitucion._setRespuesto(repuesto);
			sustitucion._setIntervencion(intervencion);
			repuesto._getSustituciones().add(sustitucion);
			intervencion._getSustituciones().add(sustitucion);
		}

		/**
		 * Método estático que elimina la relácion.
		 * 
		 * @param sustitucion
		 *            Objeto de la clase Sustitucion.
		 */
		public static void unlink(Sustitucion sustitucion) {
			sustitucion.getRepuesto()._getSustituciones().remove(sustitucion);
			sustitucion.getIntervencion()._getSustituciones()
					.remove(sustitucion);
			sustitucion._setRespuesto(null);
			sustitucion._setIntervencion(null);
		}
	}

	/**
	 * Clase estática que maneja la relación entre respuestos, suministros y
	 * proveedores.
	 * 
	 * @author Iván González Mahagamage
	 *
	 */
	public static class Suministrar {
		/**
		 * Método estático que crea la relácion.
		 * 
		 * @param repuesto
		 *            Objeto de la clase Repuesto.
		 * @param suministro
		 *            Objeto de la clase Suministro.
		 * @param proveedor
		 *            Objeto de la clase Proveedor.
		 */
		public static void link(Repuesto repuesto, Suministro suministro,
				Proveedor proveedor) {
			suministro._setRepuesto(repuesto);
			suministro._setProveedor(proveedor);
			repuesto._getSuministros().add(suministro);
			proveedor._getSuministros().add(suministro);
		}

		/**
		 * Método estático que elimina la relácion.
		 * 
		 * @param suministro
		 *            Objeto de la clase Suministro.
		 */
		public static void unlink(Suministro suministro) {
			suministro.getRepuesto()._getSuministros().remove(suministro);
			suministro.getProveedor()._getSuministros().remove(suministro);
			suministro._setProveedor(null);
			suministro._setRepuesto(null);
		}
	}

	/**
	 * Clase estática que maneja la relación entre respuestos y pedidos.
	 * 
	 * @author Iván González Mahagamage
	 *
	 */
	public static class Contiene {
		/**
		 * Método estático que crea la relácion.
		 * 
		 * @param repuesto
		 *            Objeto de la clase Repuesto.
		 * @param detallePedido
		 *            Objeto de la clase DetallePedido.
		 * @param pedido
		 *            Objeto de la clase Pedido.
		 */
		public static void link(Repuesto repuesto, DetallePedido detallePedido,
				Pedido pedido) {
			detallePedido._setPedido(pedido);
			detallePedido._setRepuesto(repuesto);
			repuesto._getDetallesPedidos().add(detallePedido);
			pedido._getDetallesPedidos().add(detallePedido);
		}

		/**
		 * Método estático que elimina la relácion.
		 * 
		 * @param detallePedido
		 *            Objeto de la clase DetallePedido
		 */
		public static void unlink(DetallePedido detallePedido) {
			detallePedido.getPedido()._getDetallesPedidos()
					.remove(detallePedido);
			detallePedido.getRepuesto()._getDetallesPedidos()
					.remove(detallePedido);
			detallePedido._setPedido(null);
			detallePedido._setRepuesto(null);
		}
	}

	/**
	 * Clase estática que maneja la relación entre proveedores y pedidos.
	 * 
	 * @author Iván González Mahagamage
	 *
	 */
	public static class Servir {
		/**
		 * Método estático que crea la relácion.
		 * 
		 * @param proveedor
		 *            Objeto de la clase Proveedor.
		 * @param pedido
		 *            Objeto de la clase Pedido.
		 */
		public static void link(Proveedor proveedor, Pedido pedido) {
			pedido._setProveedor(proveedor);
			proveedor._getPedidos().add(pedido);
		}

		/**
		 * Método estático que elimina la relácion.
		 * 
		 * @param proveedor
		 *            Objeto de la clase Proveedor.
		 * @param pedido
		 *            Objeto de la clase Pedido.
		 */
		public static void unlink(Proveedor proveedor, Pedido pedido) {
			proveedor._getPedidos().remove(pedido);
			pedido._setProveedor(null);
		}
	}

}
