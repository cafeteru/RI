package uo.ri.persistence;

import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

public interface MecanicosGateway {
	void setConnection() throws BusinessException;

	void añadirMecanico(String nombre, String apellidos)
			throws BusinessException;

	void borrarMecanico(Long idMecanico) throws BusinessException;

	List<Map<String, Object>> listarMecanicos() throws BusinessException;

	void actualizarMecanico(Long id, String nombre, String apellidos)
			throws BusinessException;
}
