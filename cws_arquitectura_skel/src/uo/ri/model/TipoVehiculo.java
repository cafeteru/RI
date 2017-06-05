package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Clase del modelo de dominio que simula un tipo de vehículo.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@Table(name = "TTIPOSVEHICULO")
public class TipoVehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private double precioHora;

	@OneToMany(mappedBy = "tipo")
	private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();

	/**
	 * Constructor por defecto.
	 */
	TipoVehiculo() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param nombre
	 *            Nombre del tipo de vehiculo.
	 */
	public TipoVehiculo(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param nombre
	 *            Nombre del tipo de vehiculo.
	 * @param precioHora
	 *            Precio por hora de trabajo.
	 */
	public TipoVehiculo(String nombre, double precioHora) {
		this(nombre);
		this.precioHora = precioHora;
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
	 * Método que devuelve el parámetro nombre.
	 * 
	 * @return El parámetro nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método que devuelve el parámetro precioHora.
	 * 
	 * @return El parámetro precioHora.
	 */
	public double getPrecioHora() {
		return precioHora;
	}

	/**
	 * Método que modifica el parámetro precioHora.
	 * 
	 * @param precioHora
	 *            Precio por hora de trabajo.
	 */
	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}

	/**
	 * Método que devuelve una copia del parámetro vehiculos.
	 * 
	 * @return Una copia del parámetro vehiculos.
	 */
	public Set<Vehiculo> getVehiculos() {
		return new HashSet<Vehiculo>(vehiculos);
	}

	/**
	 * Método que devuelve el parámetro vehiculos.
	 * 
	 * @return El parámetro vehiculos.
	 */
	Set<Vehiculo> _getVehiculos() {
		return vehiculos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		TipoVehiculo other = (TipoVehiculo) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TipoVehiculo [nombre=" + nombre + ", precioHora=" + precioHora
				+ "]";
	}

}
