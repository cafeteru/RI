package uo.ri.ui.cash.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uo.ri.business.CashService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServiceFactory;
import uo.ri.ui.util.PrinterAdapter;
import alb.util.console.Console;
import alb.util.menu.Action;

public class FacturarReparacionesAction implements Action {

	@Override
	public void execute() throws BusinessException, SQLException {
		List<Long> idsAveria = new ArrayList<Long>();
		do {
			Long id = Console.readLong("ID de averia");
			idsAveria.add(id);
		} while (masAverias());
		CashService service = ServiceFactory.getCashService();
		Map<String, Object> factura = service.createInvoiceFor(idsAveria);
		PrinterAdapter.imprimirFactura(factura);
	}

	private boolean masAverias() {
		return Console.readString("¿Añadir más averias? (s/n) ")
				.equalsIgnoreCase("s");
	}
}
