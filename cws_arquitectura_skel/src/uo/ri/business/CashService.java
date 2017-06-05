package uo.ri.business;

import java.util.List;
import uo.ri.model.Factura;
import uo.ri.model.exception.BusinessException;

/**
 * Interfaz de la parte de lógica que declara los métodos que usa la clase Cash.
 * 
 * @author Iván González Mahagamage
 *
 */
public interface CashService {

	/**
	 * Crea una factura.
	 * 
	 * @param idsAveria
	 *            Lista de averías que contiene la factura.
	 * @return Un objeto de la clase Factura.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	public Factura createInvoiceFor(List<Long> idsAveria)
			throws BusinessException;
}
