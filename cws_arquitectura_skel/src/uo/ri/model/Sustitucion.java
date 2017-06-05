package uo.ri.model;

import javax.persistence.*;

import uo.ri.model.types.keys.SustitucionKey;

/**
 * Clase del modelo de dominio que simula una sustitución.
 * 
 * @author Iván González Mahagamage
 *
 */
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

	/**
	 * Constructor por defecto.
	 */
	Sustitucion() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param repuesto
	 *            Objeto de la clase Repuesto.
	 * @param intervencion
	 *            Objeto de la clase Intervencion.
	 */
	public Sustitucion(Repuesto repuesto, Intervencion intervencion) {
		Association.Sustituir.link(repuesto, this, intervencion);
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
	void _setRespuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	/**
	 * Método que devuelve una copia del parámetro intervención.
	 * 
	 * @return Una copia del parámetro intervencion.
	 */
	public Intervencion getIntervencion() {
		return intervencion;
	}

	/**
	 * Método que modifica el parámetro intervención.
	 * 
	 * @param intervencion
	 *            Objeto de la clase Intervencion.
	 */
	void _setIntervencion(Intervencion intervencion) {
		this.intervencion = intervencion;
	}

	/**
	 * Método que devuelve el parámetro cantidad.
	 * 
	 * @return El parámetro cantidad.
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Método que modifica el parámetro cantidad.
	 * 
	 * @param cantidad
	 *            Cantidad de repuestos utilizados.
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Método que devuelve el importe.
	 * 
	 * @return El importe de la sustitución.
	 */
	public Double getImporte() {
		if (this.cantidad != 0) {
			return cantidad * repuesto.getPrecio();
		}
		return 0.0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((intervencion == null) ? 0 : intervencion.hashCode());
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
		Sustitucion other = (Sustitucion) obj;
		if (intervencion == null) {
			if (other.intervencion != null) {
				return false;
			}
		} else if (!intervencion.equals(other.intervencion)) {
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
		return "Sustitucion [repuesto=" + repuesto + ", intervencion="
				+ intervencion + ", cantidad=" + cantidad + "]";
	}

}
