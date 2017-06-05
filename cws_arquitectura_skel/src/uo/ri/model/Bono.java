package uo.ri.model;

import javax.persistence.*;

/**
 * Clase del modelo de dominio que simula un bono.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@DiscriminatorValue("TBONOS")
@Table(name = "TMEDIOSPAGO")
public class Bono extends MedioPago {

	protected double disponible = 0.0;
	protected String codigo;

	/**
	 * Constructor por defecto.
	 *
	 */
	Bono() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param cliente
	 *            Objeto de la clase Cliente.
	 * @param codigo
	 *            Código del bono.
	 */
	public Bono(Cliente cliente, String codigo) {
		this.codigo = codigo;
		Association.Pagar.link(this, cliente);
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigo
	 *            Código del bono.
	 * @param disponible
	 *            Cantidad disponible del bono.
	 */
	public Bono(String codigo, double disponible) {
		this.codigo = codigo;
		this.disponible = disponible;
	}

	/**
	 * Método que devuelve el parámetro disponible.
	 * 
	 * @return Parámetro disponible
	 */
	public double getDisponible() {
		return disponible;
	}

	public void setDisponible(double disponible) {
		this.disponible = disponible;
	}

	/**
	 * Método que devuelve el parámetro codigo.
	 * 
	 * @return El parámetro codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Bono other = (Bono) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Bono [disponible=" + disponible + ", codigo=" + codigo + "]";
	}
}
