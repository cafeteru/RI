package uo.ri.conf;

import uo.ri.business.*;
import uo.ri.business.impl.*;

public class ServiceFactory {

	public static AdminService getAdminService() {
		return new AdminServiceImpl();
	}

	public static CashService getCashService() {
		return new CashServiceImple();
	}

}
