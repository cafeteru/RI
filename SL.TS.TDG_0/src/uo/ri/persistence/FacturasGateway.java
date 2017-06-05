package uo.ri.persistence;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

public interface FacturasGateway {
	void setConnection() throws BusinessException;

	Map<String, Object> crearFactura(List<Long> idsAveria) throws SQLException, BusinessException;
}
