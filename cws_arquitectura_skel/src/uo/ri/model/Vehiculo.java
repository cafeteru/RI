package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Clase del modelo de dominio que simula un vehículo.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@Table(name = "TVEHICULOS")
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String matricula;
	private String modelo;

	@Column(name = "NUM_AVERIAS")
	private int numAverias = 0;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private TipoVehiculo tipo;

	@OneToMany(mappedBy = "vehiculo")
	private Set<Averia> averias = new HashSet<Averia>();

	/**
	 * Constructor por defecto.
	 *
	 */
	Vehiculo() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param matricula
	 *            Matricula del vehículo.
	 */
	public Vehiculo(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param matricula
	 *            Matricula del vehículo.
	 * @param marca
	 *            Marca del vehículo.
	 */
	public Vehiculo(String matricula, String marca) {
		this(matricula);
		this.marca = marca;
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param matricula
	 *            Matricula del vehículo.
	 * @param marca
	 *            Marca del vehículo.
	 * @param modelo
	 *            Modelo del vehículo.
	 */
	public Vehiculo(String matricula, String marca, String modelo) {
		this(matricula, marca);
		this.modelo = modelo;
	}

	/**
	 * Método que devuelve el parámetro Id.
	 * 
	 * @return El Id del objeto.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método que devuelve la marca del vehículo.
	 * 
	 * @return La marca del vehículo
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Método que modifica la marca del vehículo.
	 * 
	 * @param marca
	 *            Marca del vehículo
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Método que devuelve el modelo del vehículo.
	 * 
	 * @return El modelo del vehículo.
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Método que modifica el modelo del vehículo.
	 * 
	 * @param modelo
	 *            El modelo del vehículo.
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Método que devuelve el número de averías.
	 * 
	 * @return El número de averías.
	 */
	public int getNumAverias() {
		return numAverias;
	}

	/**
	 * Método que modifica el número de averías.
	 * 
	 * @param numAverias
	 *            El número de averías.
	 */
	public void setNumAverias(int numAverias) {
		this.numAverias = numAverias;
	}

	/**
	 * Método que devuelve la matricula del vehículo.
	 * 
	 * @return La matricula del vehículo
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Método que devuelve el dueño del vehículo.
	 * 
	 * @return El dueño del vehículo.
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Método que modifica el dueño del vehículo.
	 * 
	 * @param cliente
	 *            El dueño del vehículo.
	 */
	void _setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Método que devuelve el tipo del vehículo.
	 * 
	 * @return El tipo del vehículo.
	 */
	public TipoVehiculo getTipo() {
		return tipo;
	}

	/**
	 * Método que modifica el tipo del vehículo.
	 * 
	 * @param tipo
	 *            El tipo del vehículo.
	 */
	void _setTipo(TipoVehiculo tipo) {
		this.tipo = tipo;
	}

	/**
	 * Método que devuelve las averías del vehículo.
	 * 
	 * @return Una copia de las averías del vehículo.
	 */
	public Set<Averia> getAverias() {
		return new HashSet<Averia>(averias);
	}

	/**
	 * Método que devuelve una copia de las averías del vehículo.
	 * 
	 * @return Las averías del vehículo.
	 */
	Set<Averia> _getAverias() {
		return averias;
	}

	/**
	 * Método que aumenta el número de averías.
	 */
	public void incrementarAverias() {
		numAverias++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
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
		Vehiculo other = (Vehiculo) obj;
		if (matricula == null) {
			if (other.matricula != null) {
				return false;
			}
		} else if (!matricula.equals(other.matricula)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", matricula=" + matricula
				+ ", modelo=" + modelo + ", numAverias=" + numAverias + "]";
	}

}
