package uo.ri.model;

import java.util.Date;

import javax.persistence.*;

/**
 * Clase del modelo de dominio que simula una tarjeta de crédito.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@DiscriminatorValue("TTARJETASCREDITO")
@Table(name = "TMEDIOSPAGO")
public class TarjetaCredito extends MedioPago {

	protected String numero;
	protected String tipo;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date validez;

	/**
	 * Constructor por defecto.
	 */
	TarjetaCredito() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param numero
	 *            Número de la tarjeta
	 */
	public TarjetaCredito(String numero) {
		this.numero = numero;
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param cliente
	 *            Objeto de la clase Cliente.
	 * @param numero
	 *            Número de la tarjeta
	 */
	public TarjetaCredito(Cliente cliente, String numero) {
		Association.Pagar.link(this, cliente);
		this.numero = numero;
	}

	/**
	 * Método que devuelve el parámetro numero.
	 * 
	 * @return El parámetro número.
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Método que devuelve el parámetro tipo.
	 * 
	 * @return El parámetro tipo.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Método que modifica el parámetro tipo.
	 * 
	 * @param tipo
	 *            Tipo de la tarjeta de crédito.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Método que devuelve el parámetro validez.
	 * 
	 * @return El parámetro validez
	 */
	public Date getValidez() {
		return validez;
	}

	/**
	 * Método que modifica el parámetro validez.
	 * 
	 * @param validez
	 *            Fecha tope de validez de la tarjeta de crédito.
	 */
	public void setValidez(Date validez) {
		this.validez = validez;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TarjetaCredito other = (TarjetaCredito) obj;
		if (numero == null) {
			if (other.numero != null) {
				return false;
			}
		} else if (!numero.equals(other.numero)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TarjetaCredito [numero=" + numero + ", tipo=" + tipo
				+ ", validez=" + validez + "]";
	}

}
