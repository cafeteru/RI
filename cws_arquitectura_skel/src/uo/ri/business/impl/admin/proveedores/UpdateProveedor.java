package uo.ri.business.impl.admin.proveedores;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Proveedor;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la parte de lógica encargada de actualizar un proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdateProveedor implements Command {
	private Proveedor proveedor;

	/**
	 * Constructor con parámetros.
	 *
	 * @param proveedor
	 *            Objeto de la clase Proveedor.
	 */
	public UpdateProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public Object execute() throws BusinessException {
		return Jpa.getManager().merge(proveedor);
	}

	@Override
	public String toString() {
		return "Actualizar al proveedor\n\t" + proveedor;
	}

}
