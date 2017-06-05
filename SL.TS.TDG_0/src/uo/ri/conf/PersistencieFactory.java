package uo.ri.conf;

import java.sql.SQLException;

import uo.ri.common.BusinessException;
import uo.ri.persistence.*;
import uo.ri.persistence.impl.*;

public class PersistencieFactory {

	public static FacturasGateway getFacturasGateway() throws SQLException, BusinessException {
		return new FacturasGatewayImpl();
	}

	public static MecanicosGateway getMecanicosGateway() throws SQLException, BusinessException {
		return new MecanicosGatewayImpl();
	}

}
