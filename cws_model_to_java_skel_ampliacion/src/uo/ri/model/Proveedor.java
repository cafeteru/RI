package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

public class Proveedor {
	String nombre;
	String codigo;

	private Set<Suministro> suministros = new HashSet<>();
	private Set<Pedido> pedidos = new HashSet<>();

	public Proveedor(String codigo) {
		this.codigo = codigo;
	}

	public Proveedor(String nombre, String codigo) {
		this(nombre);
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Proveedor [nombre=" + nombre + ", codigo=" + codigo + "]";
	}

	public Set<Suministro> getSuministros() {
		return new HashSet<>(suministros);
	}

	Set<Suministro> _getSuministros() {
		return suministros;
	}

	public Set<Pedido> getPedidos() {
		return new HashSet<>(pedidos);
	}

	Set<Pedido> _getPedidos() {
		return pedidos;
	}
}
