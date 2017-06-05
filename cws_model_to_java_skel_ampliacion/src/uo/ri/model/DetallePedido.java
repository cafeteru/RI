package uo.ri.model;

public class DetallePedido {
	private Pedido pedido;
	private Repuesto repuesto;
	private int unidades;
	private double precio;

	public DetallePedido(Pedido pedido, Repuesto repuesto) {
		Association.Contiene.link(repuesto, this, pedido);
	}

	public DetallePedido(Pedido pedido, Repuesto repuesto, int unidades,
			double precio) {
		this(pedido, repuesto);
		this.unidades = unidades;
		this.precio = precio;
	}

	public Pedido getPedido() {
		return pedido;
	}

	void _setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Repuesto getRepuesto() {
		return repuesto;
	}

	void _setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result
				+ ((repuesto == null) ? 0 : repuesto.hashCode());
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
		DetallePedido other = (DetallePedido) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (repuesto == null) {
			if (other.repuesto != null)
				return false;
		} else if (!repuesto.equals(other.repuesto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetallePedido [pedido=" + pedido + ", repuesto=" + repuesto
				+ ", unidades=" + unidades + ", precio=" + precio + "]";
	}

}
