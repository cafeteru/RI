package uo.ri.model;

import javax.persistence.*;

import uo.ri.model.types.keys.SuministroKey;

/**
 * Clase del modelo de dominio que simula un suministro.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@IdClass(SuministroKey.class)
@Table(name = "TSUMINISTROS")
public class Suministro {
	@Id
	@ManyToOne
	private Proveedor proveedor;

	@Id
	@ManyToOne
	private Repuesto repuesto;

	private double precio;

	/**
	 * Constructor por defecto.
	 */
	Suministro() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param proveedor
	 *            Objeto de la clase Proveedor.
	 * @param repuesto
	 *            Objeto de la clase Repuesto.
	 */
	public Suministro(Proveedor proveedor, Repuesto repuesto) {
		Association.Suministrar.link(repuesto, this, proveedor);
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param proveedor
	 *            Objeto de la clase Proveedor.
	 * @param repuesto
	 *            Objeto de la clase Repuesto.
	 * @param precio
	 *            Precio del repuesto.
	 */
	public Suministro(Proveedor proveedor, Repuesto repuesto, double precio) {
		this(proveedor, repuesto);
		this.precio = precio;
	}

	/**
	 * Método que devuelve el parámetro proveedor.
	 * 
	 * @return El parámetro proveedor.
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * Método que modifica el parámetro proveedor.
	 * 
	 * @param proveedor
	 *            Objeto de la clase Proveedor.
	 */
	void _setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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
	 * Método que modifica el parámetro repuesto.
	 * 
	 * @param repuesto
	 *            Objeto de la clase Repuesto.
	 */
	void _setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
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
	 *            Precio del repuesto.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((proveedor == null) ? 0 : proveedor.hashCode());
		result = prime * result
				+ ((repuesto == null) ? 0 : repuesto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suministro other = (Suministro) obj;
		if (proveedor == null) {
			if (other.proveedor != null)
				return false;
		} else if (!proveedor.equals(other.proveedor))
			return false;
		if (repuesto == null) {
			if (other.repuesto != null)
				return false;
		} else if (!repuesto.equals(other.repuesto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Suministro [proveedor=" + proveedor + ", repuesto=" + repuesto
				+ ", precio=" + precio + "]";
	}

}
