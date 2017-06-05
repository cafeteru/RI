package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

public class Repuesto {

	private String codigo;
	private String descripcion;
	private double precio;
	private int existencias;
	private int max_existencias;
	private int min_existencias;

	private Set<Sustitucion> sustituciones = new HashSet<>();
	private Set<Suministro> suministros = new HashSet<>();
	private Set<DetallePedido> detallesPedidos = new HashSet<>();

	public Repuesto(String codigo) {
		this.codigo = codigo;
	}

	public Repuesto(String codigo, String descripcion, double precio) {
		this(codigo);
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Repuesto(String codigo, String descripcion, double precio,
			int existencias, int max_existencias, int min_existencias) {
		this(codigo, descripcion, precio);
		this.existencias = existencias;
		this.max_existencias = max_existencias;
		this.min_existencias = min_existencias;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	public int getMax_existencias() {
		return max_existencias;
	}

	public void setMax_existencias(int max_existencias) {
		this.max_existencias = max_existencias;
	}

	public int getMin_existencias() {
		return min_existencias;
	}

	public void setMin_existencias(int min_existencias) {
		this.min_existencias = min_existencias;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Repuesto other = (Repuesto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Repuesto [codigo=" + codigo + ", descripcion=" + descripcion
				+ ", precio=" + precio + "]";
	}

	public Set<Sustitucion> getSustituciones() {
		return new HashSet<>(sustituciones);
	}

	Set<Sustitucion> _getSustituciones() {
		return sustituciones;
	}

	public Set<Suministro> getSuministros() {
		return new HashSet<>(suministros);
	}

	Set<Suministro> _getSuministros() {
		return suministros;
	}

	public Set<DetallePedido> getDetallesPedidos() {
		return new HashSet<>(detallesPedidos);
	}

	Set<DetallePedido> _getDetallesPedidos() {
		return detallesPedidos;
	}

}
