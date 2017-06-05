package uo.ri.business.impl.admin;

import java.sql.*;
import java.util.*;

import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

public class FindAllMechanics {

	public List<Map<String, Object>> execute() throws SQLException, BusinessException {
		return PersistencieFactory.getMecanicosGateway().listarMecanicos();
	}
}
