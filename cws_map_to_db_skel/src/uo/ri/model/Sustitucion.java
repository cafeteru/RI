package uo.ri.model;

import javax.persistence.*;

import uo.ri.model.types.SustitucionKey;

@Entity
@IdClass(SustitucionKey.class)
@Table(name = "TSUSTITUCIONES")
public class Sustitucion {
	@Id
	@ManyToOne
	private Repuesto repuesto;

	@Id
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "INTERVENCION_AVERIA_ID", referencedColumnName = "AVERIA_ID"),
			@JoinColumn(name = "INTERVENCION_MECANICO_ID", referencedColumnName = "MECANICO_ID") })
	private Intervencion intervencion;
	private int cantidad;

	Sustitucion() {
	}

	public Sustitucion(Repuesto repuesto, Intervencion intervencion) {
		Association.Sustituir.link(repuesto, this, intervencion);
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Repuesto getRepuesto() {
		return repuesto;
	}

	public Intervencion getIntervencion() {
		return intervencion;
	}

	void _setIntervencion(Intervencion intervencion) {
		this.intervencion = intervencion;
	}

	void _setRespuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	public Double getImporte() {
		if (this.cantidad != 0)
			return cantidad * repuesto.getPrecio();
		return 0.0;
	}

	@Override
	public String toString() {
		return "Sustitucion [repuesto=" + repuesto + ", intervencion="
				+ intervencion + ", cantidad=" + cantidad + "]";
	}

}
