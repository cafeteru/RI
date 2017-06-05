package uo.ri.business.impl.admin.suministros;

import uo.ri.business.impl.util.Command;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.suministro.FinderSuministroAll;
import uo.ri.persistence.util.Finder;

/**
 * Clase de la parte de lógica encargada de mostrar todos los suministros.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindAllSuministros implements Command {

	@Override
	public Object execute() throws BusinessException {
		return new Finder(new FinderSuministroAll()).execute();
	}

	@Override
	public String toString() {
		return "Mostrar todos los suministros ofertados.";
	}

}
