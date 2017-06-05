package uo.ri.business.impl.admin.proveedores;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Proveedor;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la parte de lógica encargada de añadir un nuevo proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class AddProveedor implements Command {
	private Proveedor proveedor;

	/**
	 * Constructor con parámetros.
	 *
	 * @param proveedor
	 *            Objeto de la clase Proveedor.
	 */
	public AddProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public Object execute() throws BusinessException {
		Jpa.getManager().persist(proveedor);
		return proveedor;
	}

	@Override
	public String toString() {
		return "Añadir proveedor\n\t" + proveedor;
	}

}
