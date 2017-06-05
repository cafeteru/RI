package uo.ri.business.impl.cash;

import java.util.List;

import uo.ri.business.impl.util.Command;
import uo.ri.model.*;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.averia.FinderAveriaByIds;
import uo.ri.persistence.factura.FinderFacturaGetNextInvoiceNumber;
import uo.ri.persistence.util.*;

/**
 * Clase de la parte de lógica encargada de crear una factura.
 * 
 * @author Iván González Mahagamage
 *
 */
public class CreateInvoiceFor implements Command {

	private List<Long> idsAveria;

	/**
	 * Constructor con parámetros.
	 *
	 * @param idsAveria
	 *            Lista de objetos de la clase Avería.
	 */
	public CreateInvoiceFor(List<Long> idsAveria) {
		this.idsAveria = idsAveria;
	}

	@Override
	public String toString() {
		return "Crear factura para las averías\n\t" + idsAveria + "]";
	}

	@Override
	public Object execute() throws BusinessException {
		Long numeroFactura = (Long) new Finder(
				new FinderFacturaGetNextInvoiceNumber()).execute();
		@SuppressWarnings("unchecked")
		List<Averia> averias = (List<Averia>) new Finder(
				new FinderAveriaByIds(idsAveria)).execute();
		Factura factura = new Factura(numeroFactura, averias);
		Jpa.getManager().persist(factura);
		return factura;
	}

}
