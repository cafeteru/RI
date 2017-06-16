package uo.ri.business.impl.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import uo.ri.model.exception.BusinessException;
import uo.ri.persistence.util.Jpa;

/**
 * Clase que configura el mapeador de JPA para que lo usen los objetos de tipo
 * Command.
 * 
 * @author Iván González Mahagamage
 *
 */
public class CommandExecutor {
	/**
	 * Crea el mapeador para que los objetos Command puedan usarlo.
	 * 
	 * @param cmd
	 *            Objeto Command.
	 * @return El objeto que devuelve el mapeador al ejecutar el Command.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	public Object execute(Command cmd) throws BusinessException {
		EntityManager em = Jpa.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		try {
			Object res = cmd.execute();
			trx.commit();
			return res;
		} catch (PersistenceException | BusinessException e) {
			if (trx.isActive())
				trx.rollback();
			throw e;
		} finally {
			if (em.isOpen())
				em.close();
		}
	}
}
