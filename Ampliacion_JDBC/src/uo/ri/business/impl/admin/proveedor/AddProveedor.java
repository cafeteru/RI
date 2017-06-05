package uo.ri.business.impl.admin.proveedor;

import java.sql.SQLException;

import uo.ri.ui.util.interfaces.Command;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistencieFactory;

/**
 * Clase de la parte de l�gica encargada de a�adir un nuevo proveedor.
 * 
 * @author Iv�n Gonz�lez Mahagamage
 *
 */
public class AddProveedor implements Command {
	String nombre, codigo;

	/**
	 * Constructor con par�metros.
	 * 
	 * @param nombre
	 *            Nombre del proveedor.
	 * @param codigo
	 *            Codigo del proveedor.
	 */
	public AddProveedor(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}

	@Override
	public void execute() throws BusinessException, SQLException {
		PersistencieFactory.getProveedoresGateway().añadirProveedor(nombre,
				codigo);
	}
}
