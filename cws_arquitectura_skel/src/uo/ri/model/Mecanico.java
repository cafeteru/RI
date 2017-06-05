package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Clase del modelo de dominio que simula un mecánico.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@Table(name = "TMECANICOS")
public class Mecanico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	private String dni;
	private String nombre;

	private String apellidos;
	@OneToMany(mappedBy = "mecanico")
	private Set<Averia> averias = new HashSet<Averia>();

	@OneToMany(mappedBy = "mecanico")
	private Set<Intervencion> intervenciones = new HashSet<Intervencion>();

	/**
	 * Constructor por defecto.
	 */
	Mecanico() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param dni
	 *            Dni del mecánico.
	 */
	public Mecanico(String dni) {
		super();
		this.dni = dni;
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param dni
	 *            Dni del mecánico.
	 * @param nombre
	 *            Nombre del mecánico.
	 * @param apellidos
	 *            Apellidos del mecánico.
	 */
	public Mecanico(String dni, String nombre, String apellidos) {
		this(dni);
		this.nombre = nombre;
		this.apellidos = apellidos;
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
	 * Método que devuelve el parámetro dni.
	 * 
	 * @return El parámetro dni.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Método que devuelve el parámetro nombre.
	 * 
	 * @return El parámetro nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método que modifica el parámetro
	 * 
	 * @param nombre
	 *            Nombre del mecánico.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método que devuelve el parámetro apellidos.
	 * 
	 * @return El parámetro apellidos.
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Método que modifica el parámetro
	 * 
	 * @param apellidos
	 *            Apellidos del mecánico.
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Método que devuelve una copia del parámetro averias.
	 * 
	 * @return Una copia del parámetro averias.
	 */
	public Set<Averia> getAverias() {
		return new HashSet<Averia>(averias);
	}

	/**
	 * Método que devuelve el parámetro averias.
	 * 
	 * @return el parámetro averias.
	 */
	Set<Averia> _getAverias() {
		return averias;
	}

	/**
	 * Método que devuelve una copia del parámetro averias.
	 * 
	 * @return Una copia del parámetro averias.
	 */
	public Set<Intervencion> getIntervenciones() {
		return new HashSet<Intervencion>(intervenciones);
	}

	/**
	 * Método que devuelve el parámetro averias.
	 * 
	 * @return el parámetro averias.
	 */
	Set<Intervencion> _getIntervenciones() {
		return intervenciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Mecanico other = (Mecanico) obj;
		if (dni == null) {
			if (other.dni != null) {
				return false;
			}
		} else if (!dni.equals(other.dni)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Mecanico [dni=" + dni + ", apellidos=" + apellidos + ", nombre="
				+ nombre + ", averias=" + averias + "]";
	}

}
