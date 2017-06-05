package uo.ri.business.impl.admin.mecanicos;

import java.sql.*;
import java.util.*;

import uo.ri.ui.util.interfaces.CommandList;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de l�gica encargada de listar a los mec�nicos.
 * 
 * @author Iv�n Gonz�lez Mahagamage
 *
 */
public class FindAllMechanics implements CommandList {
	@Override
	public List<Map<String, Object>> execute()
			throws SQLException, BusinessException {
		return PersistencieFactory.getMecanicosGateway().listarMecanicos();
	}
}
