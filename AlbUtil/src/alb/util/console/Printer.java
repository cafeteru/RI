package alb.util.console;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

/**
 * M�todos de utilidad para escribir cosas en pantalla de forma controlada. Aqu�
 * irian todas las decoraciones pertinentes
 * 
 * @author alb
 */
public class Printer {
	private static PrintStream con = System.out;
	private static PrintStream err = System.err;

	/**
	 * Imprime una cabecera
	 * 
	 * @param string
	 *            Cabecera a imprimir
	 */
	public static void printHeading(String string) {
		con.println(string);
	}

	/**
	 * Avisa de error l�gico en la ejecuci�n, muy probablemente por equivocaci�n
	 * del usuario o por circunstancias que han cambiado durante el "think time"
	 * del usuario (control optimista y eso...)
	 * 
	 * @param e
	 */
	public static void printBusinessException(Exception e) {

		con.println("Ha ocurrido un problema procesando su opcion:");
		con.println("\t- " + e.getLocalizedMessage());
	}

	/**
	 * Avisa de error irrecuperable en la interfaz del usuario
	 * 
	 * @param string
	 * @param e
	 */
	public static void printRuntimeException(RuntimeException e) {
		con.println("Ha ocurrido un error interno no recuperable, "
				+ "el programa debe terminar.\n"
				+ "A continuaci�n se muestra una traza del error.\n"
				+ "[la traza no sería visible por el usuario en una alicaci�n final]");

		e.printStackTrace();
	}

	/**
	 * Imprime un mensaje
	 * 
	 * @param msg
	 *            Mensaje a mostrar
	 */
	public static void print(String msg) {
		con.println(msg);
	}

	/**
	 * Imprime una excepci�n
	 * 
	 * @param string
	 *            Mensaje a mostrar cuando ocurre la excepci�n
	 * @param e
	 *            Mensaje especifico de la excepci�n ocurrida
	 */
	public static void printException(String string, Exception e) {
		con.println(string);
		con.println("\t- " + e.getLocalizedMessage());
	}

	/**
	 * Imprime la lista de mec�nicos de la base de datos.
	 * 
	 * @param mecanicos
	 *            Lista de mec�nicos
	 */
	public static void imprimirListaMecanicos(
			List<Map<String, Object>> mecanicos) {
		try {
			for (Map<String, Object> a : mecanicos) {
				String aux = "ID: " + a.get("id");
				aux += ", nombre: " + a.get("nombre");
				aux += ", apellidos: " + a.get("apellidos");
				con.println(aux);
			}
		} catch (NullPointerException e) {
			System.err.println("La base de datos no est� conectada");
		}
	}

	/**
	 * Imprime una factura mostrando todos los datos de esta.
	 * 
	 * @param factura
	 *            Factura que quqeremos mostrar
	 */
	public static void imprimirFactura(Map<String, Object> factura) {
		double iva = (double) factura.get("iva");
		double totalFactura = (double) factura.get("totalFactura");

		con.printf("Factura n�: %d\n", factura.get("numeroFactura"));
		con.printf("\tFecha: %1$td/%1$tm/%1$tY\n", factura.get("fechaFactura"));
		con.printf("\tTotal: %.2f �\n", totalFactura / (iva / 100 + 1));
		con.printf("\tIva: %.1f %% \n", iva);
		con.printf("\tTotal con IVA: %.2f �\n", totalFactura);
	}

	/**
	 * Imprime un mensaje de error. Se usar� sobretodo en tratamiento de
	 * excepciones
	 * 
	 * @param mensaje
	 *            Mensaje de error a mostrar
	 */
	public static void imprimirError(String mensaje) {
		err.println(mensaje);
	}
}
