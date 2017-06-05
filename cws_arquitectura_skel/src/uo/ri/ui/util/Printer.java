package uo.ri.ui.util;

import java.util.List;
import uo.ri.model.*;
import alb.util.console.Console;
import alb.util.date.DateUtil;

/**
 * Clase de la capa de interfaz de usuario que imprime datos en la consola.
 * 
 * @author Iván González Mahagamage
 *
 */
public class Printer {

	/**
	 * Método que imprime un factura.
	 * 
	 * @param invoice
	 *            Factura a imprimir.
	 */
	public static void printInvoice(Factura invoice) {
		double importeConIVa = invoice.getImporte();
		double iva = (Double) invoice.getIva();
		double importeSinIva = importeConIVa / (1 + iva / 100);
		Console.printf("Factura nº: %d\n", invoice.getNumero());
		Console.printf("\tFecha: %1$td/%1$tm/%1$tY\n", invoice.getFecha());
		Console.printf("\tTotal: %.2f €\n", importeSinIva);
		Console.printf("\tIva: %.1f %% \n", invoice.getIva());
		Console.printf("\tTotal con IVA: %.2f €\n", invoice.getImporte());
		Console.printf("\tEstado: %s\n", invoice.getStatus());
	}

	/**
	 * Método que imprime los métodos de pago de un cliente.
	 * 
	 * @param medios
	 *            Lista de medios de pagos.
	 */
	public static void printPaymentMeans(List<MedioPago> medios) {
		Console.println();
		Console.println("Medios de pago disponibles");
		Console.printf("\t%s \t%-8.8s \t%s \n", "ID", "Tipo", "Acumulado");
		for (MedioPago medio : medios) {
			Console.println(medio.toFormatedString());
		}
	}

	/**
	 * Método que imprime una avería.
	 * 
	 * @param rep
	 *            Avería a imprimir.
	 */
	public static void printRepairing(Averia rep) {
		Console.printf("\t%d \t%-40.40s \t%td/%<tm/%<tY \t%-12.12s \t%.2f\n",
				rep.getId(), rep.getDescripcion(), rep.getFecha(),
				rep.getStatus(), rep.getImporte());
	}

	/**
	 * Método que imprime los datos de un mecánico.
	 * 
	 * @param m
	 *            Mecánico a imprimir.
	 */
	public static void printMechanic(Mecanico m) {
		Console.printf("\t%d %-10.10s %-25.25s %-25.25s\n", m.getId(),
				m.getDni(), m.getNombre(), m.getApellidos());
	}

	/**
	 * Imprime una lista de proveedores.
	 * 
	 * @param provedores
	 *            Proveedores que queremos mostrar.
	 */
	public static void imprimirListaProveedores(List<Proveedor> provedores) {
		for (Proveedor proveedor : provedores) {
			String aux = "\tID: " + proveedor.getId();
			aux += ", nombre: " + proveedor.getNombre();
			aux += ", código: " + proveedor.getCodigo();
			Console.println(aux);
		}
	}

	/**
	 * Imprime una lista de pedidos.
	 * 
	 * @param pedidos
	 *            Pedido que queremos mostrar.
	 */
	public static void imprimirListaPedidosProveedor(List<Pedido> pedidos) {
		for (Pedido pedido : pedidos) {
			String aux = "\tID: " + pedido.getId();
			aux += ", código: " + pedido.getCodigo();
			aux += ", fecha de creción: "
					+ DateUtil.toString(pedido.getFechaCreacion());
			aux += ", fecha de recepción: "
					+ DateUtil.toString(pedido.getFechaRecepcion());
			aux += ", estado: " + pedido.getEstado();
			Console.println(aux);
		}
	}

	/**
	 * Imprime una lista de suministros.
	 * 
	 * @param suministros
	 *            Suministros que queremos mostrar.
	 */
	public static void imprimirListaSuministros(List<Suministro> suministros) {
		for (Suministro suministro : suministros) {
			String aux = "\tID del repuesto: "
					+ suministro.getRepuesto().getId();
			aux += ", ID del proveedor: " + suministro.getProveedor().getId();
			aux += ", precio: " + suministro.getPrecio() + " €";
			Console.println(aux);
		}
	}

	/**
	 * Imprime los repuesto de un pedido
	 * 
	 * @param repuestos
	 *            Repuesto contenido en dicho pedido.
	 */
	public static void imprimirRepuestosPedido(Pedido pedido) {
		Console.println(
				"Lista de repuesto del pedido " + pedido.getCodigo() + ": ");
		for (DetallePedido detallePedido : pedido.getDetallesPedidos()) {
			String aux = "\tID: " + detallePedido.getRepuesto().getId();
			aux += ", código: " + detallePedido.getRepuesto().getCodigo();
			aux += ", descripción: "
					+ detallePedido.getRepuesto().getDescripcion();
			aux += ", unidades: " + detallePedido.getUnidades();
			aux += ", precio: " + detallePedido.getPrecio() + " €";
			Console.println(aux);
		}
	}

}
