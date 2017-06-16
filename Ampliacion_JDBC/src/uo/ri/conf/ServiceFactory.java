package uo.ri.conf;

import uo.ri.business.*;
import uo.ri.business.impl.*;

/**
 * Clase que genera las clase de tipo Service (Se encarga de la parte de
 * l�gica).
 * 
 * @author Iván González Mahagamage
 *
 */
public class ServiceFactory {

	/**
	 * Crea un objeto que maneja la parte de l�gica de Admin.
	 * 
	 * @return Un objeto que maneja la parte de l�gica de Admin.
	 */
	public static AdminService getAdminService() {
		return new AdminServiceImpl();
	}

	/**
	 * Crea un objeto que maneja la parte de l�gica de Cash.
	 * 
	 * @return Un objeto que maneja la parte de l�gica de Cash.
	 */
	public static CashService getCashService() {
		return new CashServiceImpl();
	}

}
