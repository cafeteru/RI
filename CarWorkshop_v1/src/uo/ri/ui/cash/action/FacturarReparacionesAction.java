package uo.ri.ui.cash.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uo.ri.business.cash.CreateInvoiceFor;
import uo.ri.common.BusinessException;
import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;

public class FacturarReparacionesAction implements Action {

	@Override
	public void execute() throws BusinessException, SQLException {
		List<Long> idsAveria = new ArrayList<Long>();
		do {
			Long id = Console.readLong("ID de averia");
			idsAveria.add(id);
		} while (masAverias());
		Map<String, Object> factura = new CreateInvoiceFor(idsAveria).execute();
		Printer.imprimirFactura(factura);
	}

	private boolean masAverias() {
		return Console.readString("¿Añadir más averias? (s/n) ").equalsIgnoreCase("s");
	}
}
