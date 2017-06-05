package uo.ri.business;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

public interface CashService {
	Map<String, Object> createInvoiceFor(List<Long> idsAveria) throws BusinessException, SQLException;
}
