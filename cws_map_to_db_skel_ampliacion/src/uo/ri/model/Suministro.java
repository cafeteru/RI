package uo.ri.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import uo.ri.model.types.keys.SuministroKey;

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

	Suministro() {
	}

	public Suministro(Proveedor proveedor, Repuesto repuesto) {
		Association.Suministrar.link(repuesto, this, proveedor);
	}

	public Suministro(Proveedor proveedor, Repuesto repuesto, double precio) {
		this(proveedor, repuesto);
		this.precio = precio;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	void _setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Repuesto getRepuesto() {
		return repuesto;
	}

	void _setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	public double getPrecio() {
		return precio;
	}

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
