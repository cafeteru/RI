package uo.ri.business.impl.admin.proveedores;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Proveedor;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.proveedor.FinderProveedorIdByNombre;
import uo.ri.persistence.util.Finder;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la parte de lógica encargada de buscar un proveedor por su nombre.
 * 
 * @author Iván González Mahagamage
 *
 */
public class FindProveedorByNombre implements Command {
	private String nombre;

	/**
	 * Constructor con parámetros.
	 *
	 * @param nombre
	 *            Nombre del proveedor.
	 */
	public FindProveedorByNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public Object execute() throws BusinessException {
		Long idProveedor = (Long) new Finder(
				new FinderProveedorIdByNombre(nombre)).execute();
		return Jpa.getManager().find(Proveedor.class, idProveedor);
	}

	@Override
	public String toString() {
		return "Buscar al proveedor con el nombre -> " + nombre;
	}

}
