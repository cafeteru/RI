package uo.ri.business.impl;

import java.util.List;
import uo.ri.business.CashService;
import uo.ri.business.impl.cash.CreateInvoiceFor;
import uo.ri.business.impl.util.CommandExecutor;
import uo.ri.model.Factura;
import uo.ri.model.exception.BusinessException;

/**
 * Clase de la parte lógica que implementa a la interfaz CashService.
 * 
 * @author Iván González Mahagamage
 *
 */
public class CashServiceImpl implements CashService {
	private CommandExecutor executor = new CommandExecutor();

	@Override
	public Factura createInvoiceFor(List<Long> idsAveria)
			throws BusinessException {
		return (Factura) executor.execute(new CreateInvoiceFor(idsAveria));
	}

}
