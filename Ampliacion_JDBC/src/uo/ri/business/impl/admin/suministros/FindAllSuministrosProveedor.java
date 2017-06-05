package uo.ri.business.impl.admin.suministros;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.ui.util.interfaces.CommandList;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de l�gica encargada de listar todos los repuestos
 * suministrado por un proveedor.
 * 
 * @author Iv�n Gonz�lez Mahagamage
 *
 */
public class FindAllSuministrosProveedor implements CommandList {
	Long idProveedor;

	/**
	 * Constructor con par�metros.
	 * 
	 * @param idProveedor
	 *            ID del proveedor.
	 */
	public FindAllSuministrosProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	@Override
	public List<Map<String, Object>> execute() throws BusinessException, SQLException {
		return PersistencieFactory.getSuministrosGateway().listarSuministrosProveedor(idProveedor);
	}

}
