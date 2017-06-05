package uo.ri.ui.util;

import alb.util.console.Console;

/**
 * Clase creada para hacer preguntas.
 * 
 * @author Iván González Mahagamage
 *
 */
public class Preguntar {

	/**
	 * Realiza una pregunta al usuario.
	 * 
	 * @param mensaje
	 *            Pregunta a realizar al usuario.
	 * @return La respuesta del usuario.
	 */
	public static boolean hacerPregunta(String mensaje) {
		String respuesta;
		do {
			respuesta = Console.readString(mensaje);
		} while (!respuesta.equals("s") && !respuesta.equals("S")
				&& !respuesta.equals("n") && !respuesta.equals("N"));
		if (respuesta.equals("s") || respuesta.equals("S"))
			return true;
		else if (respuesta.equals("n") || respuesta.equals("N"))
			return false;
		return false;
	}
}
