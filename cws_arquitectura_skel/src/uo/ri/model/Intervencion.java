package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import uo.ri.model.types.keys.IntervencionKey;

/**
 * Clase del modelo de dominio que simula una intervención.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@IdClass(IntervencionKey.class)
@Table(name = "TINTERVENCIONES")
public class Intervencion {

	@Id
	@ManyToOne
	private Averia averia;

	@Id
	@ManyToOne
	private Mecanico mecanico;

	private int minutos;

	@OneToMany(mappedBy = "intervencion")
	private Set<Sustitucion> sustituciones = new HashSet<Sustitucion>();

	/**
	 * Constructor por defecto.
	 */
	Intervencion() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param mecanico
	 *            Objeto de la clase Mecanico
	 * @param averia
	 *            Objeto de la clase Averia.
	 */
	public Intervencion(Mecanico mecanico, Averia averia) {
		Association.Intervenir.link(averia, this, mecanico);
	}

	/**
	 * Método que devuelve el parámetro minutos.
	 * 
	 * @return El parámetro minutos.
	 */
	public int getMinutos() {
		return minutos;
	}

	/**
	 * Método que modifica el parámetro minutos.
	 * 
	 * @param minutos
	 *            Los minutos de duración.
	 */
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	/**
	 * Método que devuelve el parámetro averia.
	 * 
	 * @return El parámetro averia.
	 */
	public Averia getAveria() {
		return averia;
	}

	/**
	 * Método que modifica el parámetro averia.
	 * 
	 * @param averia
	 *            Objeto de la clase Averia.
	 */
	void _setAveria(Averia averia) {
		this.averia = averia;
	}

	/**
	 * Método que devuelve el parámetro mecanico.
	 * 
	 * @return El parámetro mecanico.
	 */
	public Mecanico getMecanico() {
		return mecanico;
	}

	/**
	 * Método que modifica el parámetro
	 * 
	 * @param mecanico
	 *            Objeto de la clase Mecanico
	 */
	void _setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	/**
	 * Método que devuelve una copia del parámetro sustituciones.
	 * 
	 * @return Una copia del parámetro sustituciones
	 */
	public Set<Sustitucion> getSustituciones() {
		return new HashSet<Sustitucion>(sustituciones);
	}

	/**
	 * Método que devuelve el parámetro sustituciones.
	 * 
	 * @return el parámetro sustituciones
	 */
	Set<Sustitucion> _getSustituciones() {
		return sustituciones;
	}

	/**
	 * Método que devuelve el importe de la intervención.
	 * 
	 * @return El importe de la intervención
	 */
	public Double getImporte() {
		Double manoDeObra = averia.getVehiculo().getTipo().getPrecioHora()
				* minutos / 60;
		Double piezas = 0.0;
		for (Sustitucion s : sustituciones) {
			piezas += s.getImporte();
		}
		return manoDeObra + piezas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averia == null) ? 0 : averia.hashCode());
		result = prime * result
				+ ((mecanico == null) ? 0 : mecanico.hashCode());
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
		Intervencion other = (Intervencion) obj;
		if (averia == null) {
			if (other.averia != null) {
				return false;
			}
		} else if (!averia.equals(other.averia)) {
			return false;
		}
		if (mecanico == null) {
			if (other.mecanico != null) {
				return false;
			}
		} else if (!mecanico.equals(other.mecanico)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Intervencion [averia=" + averia + ", mecanico=" + mecanico
				+ ", minutos=" + minutos + "]";
	}

}
