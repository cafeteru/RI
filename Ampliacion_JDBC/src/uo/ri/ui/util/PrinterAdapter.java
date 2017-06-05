package uo.ri.ui.util;

import java.util.List;
import java.util.Map;

import alb.util.console.Printer;

/**
 * Clases adaptadora para la Clase Printer de alb.util para poder usarla y
 * aumentar sus métodos
 * 
 * @author Iván González Mahagamage
 */
public class PrinterAdapter {

	/**
	 * Imprime una cabecera.
	 * 
	 * @param string
	 *            Cabecera a imprimir
	 */
	public static void printHeading(String string) {
		Printer.printHeading(string);
	}

	/**
	 * Avisa de error lógico en la ejecución, muy probablemente por equivocación
	 * del usuario o por circunstancias que han cambiado durante el "think time"
	 * del usuario (control optimista y eso...).
	 * 
	 * @param e
	 *            Excepción ocurrida.
	 */
	public static void printBusinessException(Exception e) {
		Printer.printBusinessException(e);
	}

	/**
	 * Avisa de error irrecuperable en la interfaz del usuario.
	 * 
	 * @param e
	 *            Excepción ocurrida.
	 */
	public static void printRuntimeException(RuntimeException e) {
		Printer.printRuntimeException(e);
	}

	/**
	 * Imprime un mensaje.
	 * 
	 * @param msg
	 *            Mensaje a mostrar.
	 */
	public static void print(String msg) {
		Printer.print(msg);
	}

	/**
	 * Imprime una excepción.
	 * 
	 * @param string
	 *            Mensaje a mostrar cuando ocurre la excepción.
	 * @param e
	 *            Mensaje especifico de la excepción ocurrida.
	 */
	public static void printException(String string, Exception e) {
		Printer.printException(string, e);
	}

	/**
	 * Imprime la lista de mecánicos de la base de datos.
	 * 
	 * @param mecanicos
	 *            Lista de mecánicos.
	 */
	public static void imprimirListaMecanicos(
			List<Map<String, Object>> mecanicos) {
		for (Map<String, Object> a : mecanicos) {
			String aux = "ID: " + a.get("id");
			aux += ", nombre: " + a.get("nombre");
			aux += ", apellidos: " + a.get("apellidos");
			Printer.print(aux);
		}
	}

	/**
	 * Imprime una factura mostrando todos los datos de esta.
	 * 
	 * @param factura
	 *            Factura que queremos mostrar.
	 */
	public static void imprimirFactura(Map<String, Object> factura) {
		double iva = (double) factura.get("iva");
		double totalFactura = (double) factura.get("totalFactura");
		System.out.printf("Factura nº: " + factura.get("numeroFactura") + "\n");
		System.out.printf("\tFecha: %1$td/%1$tm/%1$tY\n",
				factura.get("fechaFactura"));
		System.out.printf("\tTotal: %.2f €\n", totalFactura / (iva / 100 + 1));
		System.out.printf("\tIva: %.1f %% \n", iva);
		System.out.printf("\tTotal con IVA: %.2f €\n", totalFactura);
	}

	/**
	 * Imprime una lista de proveedores.
	 * 
	 * @param provedores
	 *            Proveedores que queremos mostrar.
	 */
	public static void imprimirListaProveedores(
			List<Map<String, Object>> provedores) {
		for (Map<String, Object> proveedor : provedores) {
			String aux = "ID: " + proveedor.get("id");
			aux += ", nombre: " + proveedor.get("nombre");
			aux += ", código: " + proveedor.get("codigo");
			Printer.print(aux);
		}
	}

	/**
	 * Imprime una lista de pedidos.
	 * 
	 * @param pedidos
	 *            Pedido que queremos mostrar.
	 */
	public static void imprimirListaPedidosProveedor(
			List<Map<String, Object>> pedidos) {
		for (Map<String, Object> pedido : pedidos) {
			String aux = "ID: " + pedido.get("id");
			aux += ", código: " + pedido.get("codigo");
			aux += ", fecha de creción: " + pedido.get("fecha_creacion");
			aux += ", fecha de recepción: " + pedido.get("fecha_recepcion");
			aux += ", estado: " + pedido.get("estado");
			Printer.print(aux);
		}
	}

	/**
	 * Imprime una lista de suministros.
	 * 
	 * @param suministros
	 *            Suministros que queremos mostrar.
	 */
	public static void imprimirListaSuministros(
			List<Map<String, Object>> suministros) {
		for (Map<String, Object> suministro : suministros) {
			String aux = "ID del repuesto: " + suministro.get("repuesto_id");
			aux += ", ID del proveedor: " + suministro.get("proveedor_id");
			aux += ", precio: " + suministro.get("precio") + " €";
			Printer.print(aux);
		}
	}

	/**
	 * Imprime los repuesto de un pedido
	 * 
	 * @param repuestos
	 *            Repuesto contenido en dicho pedido.
	 */
	public static void imprimirRepuestosPedido(
			List<Map<String, Object>> repuestos) {
		for (Map<String, Object> repuesto : repuestos) {
			String aux = "Id: " + repuesto.get("id");
			aux += ", código: " + repuesto.get("codigo");
			aux += ", descripción: " + repuesto.get("descripcion");
			aux += ", unidades: " + repuesto.get("unidades");
			aux += ", precio: " + repuesto.get("precio") + " €";
			Printer.print(aux);
		}
	}
}
