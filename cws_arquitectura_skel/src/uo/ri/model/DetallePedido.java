package uo.ri.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import uo.ri.model.types.keys.DetallesKey;

/**
 * Clase del modelo de dominio que simula un detalle en un pedido.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@IdClass(DetallesKey.class)
@Table(name = "TDETALLES")
public class DetallePedido {
	@Id
	@ManyToOne
	private Pedido pedido;

	@Id
	@ManyToOne
	private Repuesto repuesto;

	private int unidades;
	private double precio;

	/**
	 * Constructor por defecto.
	 *
	 */
	DetallePedido() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param pedido
	 *            Objeto de la clase Pedido.
	 * @param repuesto
	 *            Objeto de la clase Repuesto.
	 */
	public DetallePedido(Pedido pedido, Repuesto repuesto) {
		Association.Contiene.link(repuesto, this, pedido);
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param pedido
	 *            Objeto de la clase Pedido.
	 * @param repuesto
	 *            Objeto de la clase Repuesto.
	 * @param unidades
	 *            Número de unidades dentro de un pedido de un repuesto.
	 * @param precio
	 *            Precio del repuesto en el pedido.
	 */
	public DetallePedido(Pedido pedido, Repuesto repuesto, int unidades,
			double precio) {
		this(pedido, repuesto);
		this.unidades = unidades;
		this.precio = precio;
	}

	/**
	 * Método que devuelve el parámetro pedido.
	 * 
	 * @return El parámetro pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * Método que modifica el parámetro pedido.
	 * 
	 * @param pedido
	 *            Objeto de la clase Pedido.
	 */
	void _setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * Método que devuelve el parámetro repuesto.
	 * 
	 * @return El parámetro repuesto.
	 */
	public Repuesto getRepuesto() {
		return repuesto;
	}

	/**
	 * Método que modifica el parámetro Repuesto.
	 * 
	 * @param repuesto
	 *            Objeto de la clase Repuesto.
	 */
	void _setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	/**
	 * Método que devuelve el parámetro unidades.
	 * 
	 * @return El parámetro unidades.
	 */
	public int getUnidades() {
		return unidades;
	}

	/**
	 * Método que modifica el parámetro unidades.
	 * 
	 * @param unidades
	 *            Número de unidades dentro de un pedido de un repuesto.
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	/**
	 * Método que devuelve el parámetro precio.
	 * 
	 * @return El parámetro precio.
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Método que modifica el parámetro precio.
	 * 
	 * @param precio
	 *            Precio del repuesto en el pedido.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result
				+ ((repuesto == null) ? 0 : repuesto.hashCode());
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
		DetallePedido other = (DetallePedido) obj;
		if (pedido == null) {
			if (other.pedido != null) {
				return false;
			}
		} else if (!pedido.equals(other.pedido)) {
			return false;
		}
		if (repuesto == null) {
			if (other.repuesto != null) {
				return false;
			}
		} else if (!repuesto.equals(other.repuesto)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "DetallePedido [pedido=" + pedido + ", repuesto=" + repuesto
				+ ", unidades=" + unidades + ", precio=" + precio + "]";
	}

}
