package uo.ri.business.impl.admin.suministros;

import uo.ri.business.impl.util.Command;
import uo.ri.model.Suministro;
import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.util.Jpa;

/**
 * Clase de la parte de lógica encargada de actualizar la información de un
 * suministro.
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdateSuministro implements Command {
	private Suministro suministro;

	/**
	 * Constructor con parámetros.
	 *
	 * @param suministro
	 *            Objeto de la clse Suministro.
	 */
	public UpdateSuministro(Suministro suministro) {
		this.suministro = suministro;
	}

	@Override
	public Object execute() throws BusinessException {
		return Jpa.getManager().merge(suministro);
	}

	@Override
	public String toString() {
		return "Actualizar el sumnistro\n\t" + suministro;
	}

}
