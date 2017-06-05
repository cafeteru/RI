package uo.ri.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("TMETALICO")
@Table(name = "TMEDIOSPAGO")
public class Metalico extends MedioPago {

	Metalico() {
	}

	public Metalico(Cliente cliente) {
		Association.Pagar.link(this, cliente);
	}

}
