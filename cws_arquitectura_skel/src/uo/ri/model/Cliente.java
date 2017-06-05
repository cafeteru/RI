package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import uo.ri.model.types.Address;

/**
 * Clase del modelo de dominio que simula un cliente.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@Table(name = "TCLIENTES")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String apellidos;
	private String dni;

	@Embedded
	private Address address;

	@OneToMany(mappedBy = "cliente")
	private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();

	@OneToMany(mappedBy = "cliente")
	private Set<MedioPago> mediosPago = new HashSet<MedioPago>();

	/**
	 * Constructor por defecto.
	 *
	 */
	Cliente() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param dni
	 *            Dni del cliente
	 */
	public Cliente(String dni) {
		super();
		this.dni = dni;
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param dni
	 *            Dni del cliente.
	 * @param nombre
	 *            Nombre del cliente.
	 * @param apellidos
	 *            Apellidos del cliente.
	 */
	public Cliente(String dni, String nombre, String apellidos) {
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
	 * Método que devuelve el parámetro nombre.
	 * 
	 * @return El parámetro nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método que modifica el parámetro nombre.
	 * 
	 * @param nombre
	 *            Nombre del cliente.
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
	 * Método que modifica el parámetro apellidos.
	 * 
	 * @param apellidos
	 *            Apellidos del cliente.
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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
	 * Método que devuelve el parámetro address.
	 * 
	 * @return El parámetro address.
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Método que modifica el parámetro address.
	 * 
	 * @param address
	 *            Dirección del cliente.
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Método que devuelve una copia del parámetro vehículos.
	 * 
	 * @return Una copia del parámetro vehículos.
	 */
	public Set<Vehiculo> getVehiculos() {
		return new HashSet<Vehiculo>(vehiculos);
	}

	/**
	 * Método que devuelve el parámetro vehículos.
	 * 
	 * @return El parámetro vehículos.
	 */
	Set<Vehiculo> _getVehiculos() {
		return vehiculos;
	}

	/**
	 * Método que devuelve una copia del parámetro mediosPago.
	 * 
	 * @return Una copia del parámetro mediosPago.
	 */
	public Set<MedioPago> getMediosPago() {
		return new HashSet<MedioPago>(mediosPago);
	}

	/**
	 * Método que devuelve el parámetro mediosPago.
	 * 
	 * @return El parámetro mediosPago.
	 */
	Set<MedioPago> _getMediosPagos() {
		return mediosPago;
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
		Cliente other = (Cliente) obj;
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
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos
				+ ", dni=" + dni + "]";
	}

}
