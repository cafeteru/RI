package uo.ri.business.impl.admin.proveedor;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.ui.util.interfaces.CommandList;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de l�gica encargada de listar todos proveedores.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindAllProveedor implements CommandList {

	@Override
	public List<Map<String, Object>> execute()
			throws SQLException, BusinessException {
		return PersistencieFactory.getProveedoresGateway().listarProveedores();
	}
}
