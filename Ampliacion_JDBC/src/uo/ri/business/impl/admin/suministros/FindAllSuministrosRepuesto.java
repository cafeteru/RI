package uo.ri.business.impl.admin.suministros;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.ui.util.interfaces.CommandList;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de lógica encargada de lista todos proveedores que
 * suministran un repuesto.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindAllSuministrosRepuesto implements CommandList {
	Long idRepuesto;

	/**
	 * Constructor con parámetros.
	 * 
	 * @param idRepuesto
	 *            ID del repuesto.
	 */
	public FindAllSuministrosRepuesto(Long idRepuesto) {
		this.idRepuesto = idRepuesto;
	}

	@Override
	public List<Map<String, Object>> execute() throws BusinessException, SQLException {
		return PersistencieFactory.getSuministrosGateway().listarSuministrosRepuesto(idRepuesto);
	}

}
