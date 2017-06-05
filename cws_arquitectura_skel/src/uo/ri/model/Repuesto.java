package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Clase del modelo de dominio que simula un repuesto.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@Table(name = "TREPUESTOS")
public class Repuesto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String codigo;
	private String descripcion;
	private double precio;

	@OneToMany(mappedBy = "repuesto")
	private Set<Sustitucion> sustituciones = new HashSet<Sustitucion>();

	@OneToMany(mappedBy = "repuesto")
	private Set<Suministro> suministros = new HashSet<>();

	@OneToMany(mappedBy = "repuesto")
	private Set<DetallePedido> detallesPedidos = new HashSet<>();

	private int existencias;
	private int maxExistencias;
	private int minExistencias;

	/**
	 * Constructor por defecto.
	 */
	Repuesto() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigo
	 *            Código del repuesto.
	 */
	public Repuesto(String codigo) {
		super();
		this.codigo = codigo;
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigo
	 *            Código del repuesto.
	 * @param descripcion
	 *            Descripción del repuesto.
	 * @param precio
	 *            Precio del repuesto.
	 */
	public Repuesto(String codigo, String descripcion, double precio) {
		this(codigo);
		this.descripcion = descripcion;
		this.precio = precio;
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigo
	 *            Código del repuesto.
	 * @param descripcion
	 *            Descripción del repuesto.
	 * @param precio
	 *            Precio del repuesto.
	 * @param existencias
	 *            Número de existencias disponibles.
	 * @param maxExistencias
	 *            Número máximo de existencias.
	 * @param minExistencias
	 *            Número mínimo de existencias.
	 */
	public Repuesto(String codigo, String descripcion, double precio,
			int existencias, int maxExistencias, int minExistencias) {
		this(codigo, descripcion, precio);
		this.existencias = existencias;
		this.maxExistencias = maxExistencias;
		this.minExistencias = minExistencias;
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
	 * Método que devuelve el parámetro codigo.
	 * 
	 * @return El parámetro codigo.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método que devuelve el parámetro descripcion
	 * 
	 * @return El parámetro descripcion.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Método que modifica el parámetro repuesto.
	 * 
	 * @param descripcion
	 *            Descripción del repuesto.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	/**
	 * Método que devuelve el parámetro existencias.
	 * 
	 * @return El parámetro existencias.
	 */
	public int getExistencias() {
		return existencias;
	}

	/**
	 * Método que modifica el parámetro existencias.
	 * 
	 * @param existencias
	 *            Número de existencias disponibles.
	 */
	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	/**
	 * Método que devuelve el parámetro maxExistencias.
	 * 
	 * @return El parámetro maxExistencias.
	 */
	public int getMaxExistencias() {
		return maxExistencias;
	}

	/**
	 * Método que modifica el parámetro maxExistencias.
	 * 
	 * @param maxExistencias
	 *            Número máximo de existencias.
	 */
	public void setMaxExistencias(int maxExistencias) {
		this.maxExistencias = maxExistencias;
	}

	/**
	 * Método que devuelve el parámetro minExistencias.
	 * 
	 * @return El parámetro minExistencias.
	 */
	public int getMinExistencias() {
		return minExistencias;
	}

	/**
	 * Método que modifica el parámetro minExistencias.
	 * 
	 * @param minExistencias
	 *            Número mínimo de existencias.
	 */
	public void setMinExistencias(int minExistencias) {
		this.minExistencias = minExistencias;
	}

	/**
	 * Método que devuelve una copia del parámetro sustituciones.
	 * 
	 * @return Una copia del parámetro sustituciones.
	 */
	public Set<Sustitucion> getSustituciones() {
		return new HashSet<Sustitucion>(sustituciones);
	}

	/**
	 * Método que devuelve el parámetro sustituciones
	 * 
	 * @return El parámetro sustituciones.
	 */
	Set<Sustitucion> _getSustituciones() {
		return sustituciones;
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
	 * Método que devuelve una copia del parámetro detallesPedidos.
	 * 
	 * @return Una copia del parámetro detallesPedidos.
	 */
	public Set<DetallePedido> getDetallesPedidos() {
		return new HashSet<>(detallesPedidos);
	}

	/**
	 * Método que devuelve el parámetro detallesPedidos
	 * 
	 * @return El parámetro detallesPedidos
	 */
	Set<DetallePedido> _getDetallesPedidos() {
		return detallesPedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Repuesto other = (Repuesto) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Repuesto [codigo=" + codigo + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", existencias=" + existencias
				+ ", maxExistencias=" + maxExistencias + ", minExistencias="
				+ minExistencias + "]";
	}

}
