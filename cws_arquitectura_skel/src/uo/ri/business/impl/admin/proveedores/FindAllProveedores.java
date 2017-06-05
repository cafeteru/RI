package uo.ri.business.impl.admin.proveedores;

import java.util.List;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Proveedor;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.proveedor.FinderProveedorAll;
import uo.ri.persistence.util.Finder;

/**
 * Clase de la parte de lógica encargada de listar todos proveedores.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindAllProveedores implements Command {

	@SuppressWarnings("unchecked")
	@Override
	public Object execute() throws BusinessException {
		return (List<Proveedor>) new Finder(new FinderProveedorAll()).execute();
	}

	@Override
	public String toString() {
		return "Mostrar todos los proveedores.";
	}

}
