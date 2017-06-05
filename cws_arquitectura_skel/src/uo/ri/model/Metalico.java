package uo.ri.model;

import javax.persistence.*;

/**
 * Clase del modelo de dominio que simula un pago en metálico.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@DiscriminatorValue("TMETALICO")
@Table(name = "TMEDIOSPAGO")
public class Metalico extends MedioPago {
	/**
	 * Constructor por defecto.
	 */
	Metalico() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param cliente
	 *            Objeto de la clase Cliente.
	 */
	public Metalico(Cliente cliente) {
		Association.Pagar.link(this, cliente);
	}

}
