package uo.ri.persistence.factura;

import uo.ri.persistence.util.FinderType;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la capa de persistencia que devuelve el ultimo numero de factura.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FinderFacturaGetNextInvoiceNumber implements FinderType {

	@Override
	public Object execute() {
		return Jpa.getManager()
				.createNamedQuery("Factura.getNextInvoiceNumber", Long.class)
				.getSingleResult();
	}

	@Override
	public String toString() {
		return "Buscar el número de la nueva factura.";
	}

}
