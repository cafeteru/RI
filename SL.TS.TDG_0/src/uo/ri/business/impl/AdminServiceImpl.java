package uo.ri.business.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.business.AdminService;
import uo.ri.business.impl.admin.*;
import uo.ri.common.BusinessException;

public class AdminServiceImpl implements AdminService {

	@Override
	public void newMechanic(String nombre, String apellidos) throws BusinessException, SQLException {
		new AddMechanic(nombre, apellidos).execute();
	}

	@Override
	public void deleteMechanic(Long idMecanico) throws BusinessException, SQLException {
		new DeleteMechanic(idMecanico).execute();
	}

	@Override
	public void updateMechanic(Long id, String nombre, String apellidos) throws BusinessException, SQLException {
		new UpdateMechanic(id, nombre, apellidos).execute();
	}

	@Override
	public List<Map<String, Object>> findAllMechanics() throws BusinessException, SQLException {
		return new FindAllMechanics().execute();
	}

}
