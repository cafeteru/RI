package uo.ri.business.impl.admin.suministros;

import uo.ri.business.impl.util.Command;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.suministro.FinderSuministroByRepuesto;
import uo.ri.persistence.util.Finder;

/**
 * Clase de la parte de lógica encargada de buscar los suministros que ofrecen
 * un repuesto determinado.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindSuministrosByRepuesto implements Command {
	private String codigoRepuesto;

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigoRepuesto
	 *            Código del repuesto.
	 */
	public FindSuministrosByRepuesto(String codigoRepuesto) {
		this.codigoRepuesto = codigoRepuesto;
	}

	@Override
	public Object execute() throws BusinessException {
		return new Finder(new FinderSuministroByRepuesto(codigoRepuesto))
				.execute();
	}

	@Override
	public String toString() {
		return "Mostrar todos los proveedores que suministran "
				+ "el repuesto con código -> " + codigoRepuesto;
	}

}
