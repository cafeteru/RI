package uo.ri.business;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

public interface AdminService {
	void newMechanic(String nombre, String apellidos) throws BusinessException, SQLException;

	void deleteMechanic(Long idMecanico) throws BusinessException, SQLException;

	void updateMechanic(Long id, String nombre, String apellidos) throws BusinessException, SQLException;

	List<Map<String, Object>> findAllMechanics() throws BusinessException, SQLException;
}
