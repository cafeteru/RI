package uo.ri.business.impl.admin.proveedores;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Proveedor;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.proveedor.FinderProveedorIdByCodigo;
import uo.ri.persistence.util.Finder;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la parte de lógica encargada de borrar un proveedor.
 * 
 * @author Iván González Mahagamage
 *
 */
public class DeleteProveedor implements Command {
	private String codigoProveedor;

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigoProveedor
	 *            Código del proveedor.
	 */
	public DeleteProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	@Override
	public Object execute() throws BusinessException {
		Long idProveedor = (Long) new Finder(
				new FinderProveedorIdByCodigo(codigoProveedor)).execute();
		Proveedor p = Jpa.getManager().find(Proveedor.class, idProveedor);
		checkNotNull(p);
		checkSinSuministros(p);
		checkSinPedidos(p);
		Jpa.getManager().remove(p);
		return p;
	}

	/**
	 * Comprueba que el objeto no es null.
	 * 
	 * @param p
	 *            Objeto de la clase Proveedor
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	private void checkNotNull(Proveedor p) throws BusinessException {
		if (p == null) {
			throw new BusinessException("No existe el proveedor");
		}
	}

	/**
	 * Comprueba que el proveedor no tiene enlazado suministros.
	 * 
	 * @param p
	 *            Objeto de la clase Proveedor
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	private void checkSinSuministros(Proveedor p) throws BusinessException {
		if (p.getSuministros().size() > 0) {
			throw new BusinessException(
					"No se puede borrar el proveedor, tiene suministros asignados");
		}
	}

	/**
	 * Comprueba que el proveedor no tiene pedidos enlazados.
	 * 
	 * @param p
	 *            Objeto de la clase Proveedor
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	private void checkSinPedidos(Proveedor p) throws BusinessException {
		if (p.getPedidos().size() > 0) {
			throw new BusinessException(
					"No se puede borrar el proveedor, tiene pedidos asignados");
		}
	}

	@Override
	public String toString() {
		return "Borrar al proveedor con código ->" + codigoProveedor;
	}

}
