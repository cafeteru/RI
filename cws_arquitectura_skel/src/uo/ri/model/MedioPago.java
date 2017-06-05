package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Clase del modelo de dominio que simula un medio de pago.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@Table(name = "TMEDIOSPAGO")
public abstract class MedioPago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	protected double acumulado = 0.0;

	@ManyToOne
	private Cliente cliente;

	@OneToMany(mappedBy = "medioPago")
	private Set<Cargo> cargos = new HashSet<Cargo>();

	/**
	 * Constructor por defecto.
	 */
	MedioPago() {
	}

	/**
	 * Método que devuelve el parámetro Id
	 * 
	 * @return El Id del objeto.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método que devuelve el parámetro cliente.
	 * 
	 * @return El parámetro cliente.
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Método que modifica el parámetro cliente
	 * 
	 * @param cliente
	 *            Objeto de la clase Cliente.
	 */
	void _setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Método que devuelve una copia del parámetro cargos.
	 * 
	 * @return Una copia del parámetro cargos.
	 */
	public Set<Cargo> getCargos() {
		return new HashSet<Cargo>(cargos);
	}

	/**
	 * Método que devuelve el parámetro cargos.
	 * 
	 * @return El parámetro cargos.
	 */
	Set<Cargo> _getCargos() {
		return cargos;
	}

	/**
	 * Método que devuelve el parámetro acumulado.
	 * 
	 * @return El parámetro acumulado.
	 */
	public double getAcumulado() {
		return acumulado;
	}

	/**
	 * Método que modifica el parámetro acumulado
	 * 
	 * @param acumulado
	 *            El gasto acumulado.
	 */
	public void setAcumulado(double acumulado) {
		this.acumulado = acumulado;
	}

	/**
	 * Método que devuelve el método toString().
	 * 
	 * @return El método toString().
	 */
	public String toFormatedString() {
		return toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
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
		MedioPago other = (MedioPago) obj;
		if (cliente == null) {
			if (other.cliente != null) {
				return false;
			}
		} else if (!cliente.equals(other.cliente)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "MedioPago [acumulado=" + acumulado + ", cliente=" + cliente
				+ "]";
	}

}
