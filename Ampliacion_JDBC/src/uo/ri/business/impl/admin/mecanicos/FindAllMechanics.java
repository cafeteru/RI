package uo.ri.business.impl.admin.mecanicos;

import java.sql.*;
import java.util.*;

import uo.ri.ui.util.interfaces.CommandList;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de lógica encargada de listar a los mecánicos.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindAllMechanics implements CommandList {
	@Override
	public List<Map<String, Object>> execute()
			throws SQLException, BusinessException {
		return PersistencieFactory.getMecanicosGateway().listarMecanicos();
	}
}
