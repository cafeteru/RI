package uo.ri.business.impl;

import java.util.List;
import java.util.Map;

import uo.ri.business.AdminService;
import uo.ri.business.impl.admin.*;
import uo.ri.common.BusinessException;

public class AdminServiceImpl implements AdminService {

	@Override
	public void newMechanic(String nombre, String apellidos) throws BusinessException {
		new AddMechanic(nombre, apellidos).execute();

	}

	@Override
	public void deleteMechanic(Long idMecanico) throws BusinessException {
		new DeleteMechanic(idMecanico).execute();
	}

	@Override
	public void updateMechanic(Long id, String nombre, String apellidos) throws BusinessException {
		new UpdateMechanic(id, nombre, apellidos).execute();
	}

	@Override
	public List<Map<String, Object>> findAllMechanics() throws BusinessException {
		return new FindAllMechanics().execute();
	}

}
