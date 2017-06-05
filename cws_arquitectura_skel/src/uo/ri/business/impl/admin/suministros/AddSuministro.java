package uo.ri.business.impl.admin.suministros;

import uo.ri.business.impl.util.Command;
import uo.ri.model.*;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.proveedor.FinderProveedorByCodigo;
import uo.ri.persistence.repuesto.FinderRepuestoByCodigo;
import uo.ri.persistence.util.Finder;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la parte de lógica encargada de añadir un nuevo Suministro.
 * 
 * @author Iván González Mahagamage
 *
 */
public class AddSuministro implements Command {
	private String codigoRepuesto, codigoProveedor;
	private double precio;

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigoRepuesto
	 *            Código del repuesto.
	 * @param codigoProveedor
	 *            Código del proveedor.
	 * @param precio
	 *            Precio del suministro.
	 */
	public AddSuministro(String codigoRepuesto, String codigoProveedor,
			double precio) {
		this.codigoRepuesto = codigoRepuesto;
		this.codigoProveedor = codigoProveedor;
		this.precio = precio;
	}

	@Override
	public Object execute() throws BusinessException {
		Repuesto repuesto = (Repuesto) new Finder(
				new FinderRepuestoByCodigo(codigoRepuesto)).execute();
		Proveedor proveedor = (Proveedor) new Finder(
				new FinderProveedorByCodigo(codigoProveedor)).execute();
		Suministro suministro = new Suministro(proveedor, repuesto, precio);
		Jpa.getManager().persist(suministro);
		return suministro;
	}

	@Override
	public String toString() {
		return "Añadir el suministro:\n\tcodigoRepuesto = " + codigoRepuesto
				+ ", codigoProveedor = " + codigoProveedor + ", precio = "
				+ precio;
	}

}
