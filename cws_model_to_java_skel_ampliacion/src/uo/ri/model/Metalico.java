package uo.ri.model;

public class Metalico extends MedioPago {
	public Metalico() {
		Association.Pagar.link(cliente, this);
	}

	public Metalico(Cliente cliente) {
		Association.Pagar.link(cliente, this);
	}

}
