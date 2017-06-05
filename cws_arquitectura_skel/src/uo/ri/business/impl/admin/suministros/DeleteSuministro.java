package uo.ri.business.impl.admin.suministros;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Suministro;
import uo.ri.model.exception.BusinessException;
import uo.ri.model.types.keys.SuministroKey;
import uo.ri.persistence.proveedor.FinderProveedorIdByCodigo;
import uo.ri.persistence.repuesto.FinderRepuestoIdByCodigo;
import uo.ri.persistence.util.Finder;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la parte de lógica encargada de eliminar a un suministro.
 * 
 * @author Iván González Mahagamage
 *
 */
public class DeleteSuministro implements Command {
	private String codigoRepuesto, codigoProveedor;

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigoRepuesto
	 *            Código del repuesto.
	 * @param codigoProveedor
	 *            Código del proveedor.
	 */
	public DeleteSuministro(String codigoRepuesto, String codigoProveedor) {
		this.codigoRepuesto = codigoRepuesto;
		this.codigoProveedor = codigoProveedor;
	}

	@Override
	public Object execute() throws BusinessException {
		Suministro s = Jpa.getManager().find(Suministro.class,
				buscarClavePrimaria());
		checkNotNull(s);
		checkSinProveedor(s);
		checkSinRepuesto(s);
		Jpa.getManager().remove(s);
		return s;
	}

	/**
	 * Busca la clave primaria de un suministro.
	 * 
	 * @return Una copia de la clave primaria del suministro.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	private SuministroKey buscarClavePrimaria() throws BusinessException {
		Long idRepuesto = (Long) new Finder(
				new FinderRepuestoIdByCodigo(codigoRepuesto)).execute();
		Long idProveedor = (Long) new Finder(
				new FinderProveedorIdByCodigo(codigoProveedor)).execute();
		return new SuministroKey(idProveedor, idRepuesto);
	}

	/**
	 * Comprueba que no sea null.
	 * 
	 * @param s
	 *            Objeto de la clase Suministro.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	private void checkNotNull(Suministro s) throws BusinessException {
		if (s == null) {
			throw new BusinessException("No existe el suministro.");
		}
	}

	/**
	 * Comprueba que el suministro no tiene asignado un proveedor.
	 * 
	 * @param s
	 *            Objeto de la clase Suministro.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	private void checkSinProveedor(Suministro s) throws BusinessException {
		if (s.getProveedor() != null) {
			throw new BusinessException("No se puede borrar el suministro, "
					+ "tiene un proveedor asignado.");
		}
	}

	/**
	 * Comprueba que un suministro no tenga asignado un repuesto.
	 * 
	 * @param s
	 *            Objeto de la clase Suministro.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	private void checkSinRepuesto(Suministro s) throws BusinessException {
		if (s.getRepuesto() != null) {
			throw new BusinessException("No se puede borrar el suministro, "
					+ "tiene un repuesto asignado.");
		}
	}

	@Override
	public String toString() {
		return "Borrando el suministros\n\tcodigoRepuesto = " + codigoRepuesto
				+ ", codigoProveedor = " + codigoProveedor;
	}

}
