package uo.ri.business.impl.admin.mecanicos;

import java.util.List;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Mecanico;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.mecanico.FinderMecanicoAll;
import uo.ri.persistence.util.Finder;

/**
 * Clase de la parte de lógica encargada de listar a los mecánicos.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindAllMechanics implements Command {

	@SuppressWarnings("unchecked")
	@Override
	public Object execute() throws BusinessException {
		return (List<Mecanico>) new Finder(new FinderMecanicoAll()).execute();
	}

	@Override
	public String toString() {
		return "Mostrar todos los mecanicos.";
	}

}
