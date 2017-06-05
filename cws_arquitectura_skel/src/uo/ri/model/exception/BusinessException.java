package uo.ri.model.exception;

/**
 * Clase que crea una excepción personalizada para nuestro proyecto.
 * 
 * @author Iván González Mahagamage
 *
 */
public class BusinessException extends Exception {
	private static final long serialVersionUID = 6193644331843268598L;

	/**
	 * Constructor por defecto.
	 */
	public BusinessException() {
		super();
	}

	/**
	 * Muestra la causa y un mensaje de una excepción
	 * 
	 * @param message
	 *            Mensaje de la excepción
	 * @param cause
	 *            Causa de la excepción
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Muestra un mensaje cuando ocurre una excepción
	 * 
	 * @param message
	 *            Mensaje de la excepción
	 */
	public BusinessException(String message) {
		super(message);
	}

	/**
	 * Muestra la causa de una excepción
	 * 
	 * @param cause
	 *            Causa de la excepción
	 */
	public BusinessException(Throwable cause) {
		super(cause);
	}

}
