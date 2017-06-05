package uo.ri.ui.util;

import alb.util.menu.BaseMenu;
import uo.ri.model.exception.BusinessException;

/**
 * Clase de la capa de la interfaz de usuario
 * 
 * @author Iván González Mahagamage
 *
 */
public class MenuExcepciones extends BaseMenu {

	@Override
	protected void processOption(int option) throws Exception {
		try {
			super.processOption(option);
		} catch (IndexOutOfBoundsException e) {
			throw new BusinessException("Opción no valida.");
		}
	}

}
