package uo.ri.business.impl.admin.proveedores;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Proveedor;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.proveedor.FinderProveedorIdByCodigo;
import uo.ri.persistence.util.Finder;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la parte de lógica encargada de buscar un proveedor por su código.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindProveedorByCodigo implements Command {
	private String codigo;

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigo
	 *            Código del proveedor.
	 */
	public FindProveedorByCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public Object execute() throws BusinessException {
		Long idProveedor = (Long) new Finder(
				new FinderProveedorIdByCodigo(codigo)).execute();
		return Jpa.getManager().find(Proveedor.class, idProveedor);
	}

	@Override
	public String toString() {
		return "Buscar al proveedor con el código -> " + codigo;
	}

}
