package uo.ri.common;

/**
 * Clase que crea una excepci�n personalizada para nuestro proyecto.
 * 
 * @author Iván González Mahagamage
 *
 */
public class BusinessException extends Exception {
	private static final long serialVersionUID = -308694287126038961L;

	/**
	 * Constructor por defecto.
	 */
	public BusinessException() {
	}

	/**
	 * Muestra un mensaje cuando ocurre una excepci�n
	 * 
	 * @param message
	 *            Mensaje de la excepci�n
	 */
	public BusinessException(String message) {
		super(message);
	}

	/**
	 * Muestra la causa de una excepci�n
	 * 
	 * @param cause
	 *            Causa de la excepci�n
	 */
	public BusinessException(Throwable cause) {
		super(cause);
	}

	/**
	 * Muestra la causa y un mensaje de una excepci�n
	 * 
	 * @param message
	 *            Mensaje de la excepci�n
	 * @param cause
	 *            Causa de la excepci�n
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

}
