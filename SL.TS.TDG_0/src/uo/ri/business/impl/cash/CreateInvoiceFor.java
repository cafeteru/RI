package uo.ri.business.impl.cash;

import java.sql.*;
import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

public class CreateInvoiceFor {
	private List<Long> idsAveria;

	public CreateInvoiceFor(List<Long> idsAveria) throws SQLException {
		this.idsAveria = idsAveria;
	}

	public Map<String, Object> execute() throws SQLException, BusinessException {
		return PersistencieFactory.getFacturasGateway().crearFactura(idsAveria);
	}
}
