package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Clase del modelo de dominio que simula un proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@Table(name = "TPROVEEDORES")
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String codigo;

	@OneToMany(mappedBy = "proveedor")
	private Set<Suministro> suministros = new HashSet<>();

	@OneToMany(mappedBy = "proveedor")
	private Set<Pedido> pedidos = new HashSet<>();

	/**
	 * Constructor por defecto.
	 */
	Proveedor() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param nombre
	 *            Nombre del proveedor.
	 * @param codigo
	 *            Código del proveedor.
	 */
	public Proveedor(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
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
	 *            Nombre del proveedor.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método que devuelve el parámetro codigo.
	 * 
	 * @return El parámetro codigo.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método que modifica el parámetro codigo.
	 * 
	 * @param codigo
	 *            Código del proveedor.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método que devuelve una copia del parámetro suministros.
	 * 
	 * @return Una copia del parámetro suministros.
	 */
	public Set<Suministro> getSuministros() {
		return new HashSet<>(suministros);
	}

	/**
	 * Método que devuelve el parámetro suministros.
	 * 
	 * @return El parámetro suministros.
	 */
	Set<Suministro> _getSuministros() {
		return suministros;
	}

	/**
	 * Método que devuelve una copia del parámetro pedidos.
	 * 
	 * @return Una copia del parámetro pedidos.
	 */
	public Set<Pedido> getPedidos() {
		return new HashSet<>(pedidos);
	}

	/**
	 * Método que devuelve el parámetro pedidos
	 * 
	 * @return El parámetro pedidos
	 */
	Set<Pedido> _getPedidos() {
		return pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
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
		return "Proveedor [nombre=" + nombre + ", codigo=" + codigo + "]";
	}
}
