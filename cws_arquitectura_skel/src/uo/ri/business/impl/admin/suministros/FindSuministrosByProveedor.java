package uo.ri.business.impl.admin.suministros;

import uo.ri.business.impl.util.Command;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.suministro.FinderSuministroByProveedor;
import uo.ri.persistence.util.Finder;

/**
 * Clase de la parte de lógica encargada de buscar los suministros que ofrecen
 * un proveedor determinado.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindSuministrosByProveedor implements Command {
	private String codigoProveedor;

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigoProveedor
	 *            Código del proveedor.
	 */
	public FindSuministrosByProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	@Override
	public Object execute() throws BusinessException {
		return new Finder(new FinderSuministroByProveedor(codigoProveedor))
				.execute();
	}

	@Override
	public String toString() {
		return "Mostrar los repuestos suministrados por "
				+ "el proveedor con el código -> " + codigoProveedor;
	}

}
