package uo.ri.business;

import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

public interface AdminService {
	void newMechanic(String nombre, String apellidos) throws BusinessException;

	void deleteMechanic(Long idMecanico) throws BusinessException;

	void updateMechanic(Long id, String nombre, String apellidos) throws BusinessException;

	List<Map<String, Object>> findAllMechanics() throws BusinessException;
}
