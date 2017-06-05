package uo.ri.business.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.business.AdminService;
import uo.ri.business.impl.admin.mecanicos.*;
import uo.ri.business.impl.admin.pedidos.*;
import uo.ri.business.impl.admin.pedidos.repuestos.*;
import uo.ri.business.impl.admin.proveedor.*;
import uo.ri.business.impl.admin.suministros.*;
import uo.ri.common.BusinessException;

/**
 * Clase de la parte logica que implementa a la clase AdminService.
 * 
 * @author Iván González Mahagamage
 *
 */
public class AdminServiceImpl implements AdminService {

	@Override
	public void newMechanic(String nombre, String apellidos)
			throws BusinessException, SQLException {
		new AddMechanic(nombre, apellidos).execute();
	}

	@Override
	public void deleteMechanic(Long idMecanico)
			throws BusinessException, SQLException {
		new DeleteMechanic(idMecanico).execute();
	}

	@Override
	public void updateMechanic(Long id, String nombre, String apellidos)
			throws BusinessException, SQLException {
		new UpdateMechanic(id, nombre, apellidos).execute();
	}

	@Override
	public List<Map<String, Object>> findAllMechanics()
			throws BusinessException, SQLException {
		return new FindAllMechanics().execute();
	}

	@Override
	public List<Map<String, Object>> findAllPedidosProveedor(Long idProveedor)
			throws BusinessException, SQLException {
		return new FindAllPedidosProveedor(idProveedor).execute();
	}

	@Override
	public void newProveedor(String nombre, String codigo)
			throws BusinessException, SQLException {
		new AddProveedor(nombre, codigo).execute();
	}

	@Override
	public void deleteProveedor(Long idProveedor)
			throws BusinessException, SQLException {
		new DeleteProveedor(idProveedor).execute();
	}

	@Override
	public void updateProveedor(Long id, String nombre, String codigo)
			throws BusinessException, SQLException {
		new UpdateProveedor(id, codigo, codigo).execute();
	}

	@Override
	public void updateProveedorSinID(String nombre, String nombreNuevo,
			String codigo) throws BusinessException, SQLException {
		new UpdateProveedorSinID(nombre, nombreNuevo, codigo).execute();
	}

	@Override
	public List<Map<String, Object>> findAllProveedores()
			throws BusinessException, SQLException {
		return new FindAllProveedor().execute();
	}

	@Override
	public void newSuministro(Long idRepuesto, Long idProveedor, Double precio)
			throws BusinessException, SQLException {
		new AddSuministros(idRepuesto, idProveedor, precio).execute();
	}

	@Override
	public void deleteSuministro(Long idRepuesto, Long idProveedor)
			throws BusinessException, SQLException {
		new DeleteSuministros(idRepuesto, idProveedor).execute();
	}

	@Override
	public void updateSuministro(Long idRepuesto, Long idProveedor,
			Double precio) throws BusinessException, SQLException {
		new UpdateSuministros(idRepuesto, idProveedor, precio).execute();
	}

	@Override
	public List<Map<String, Object>> findAllSuministrosProveedor(
			Long idProveedor) throws BusinessException, SQLException {
		return new FindAllSuministrosProveedor(idProveedor).execute();
	}

	@Override
	public List<Map<String, Object>> findAllSuministrosRepuesto(Long idRepuesto)
			throws BusinessException, SQLException {
		return new FindAllSuministrosRepuesto(idRepuesto).execute();
	}

	@Override
	public List<Map<String, Object>> findRepuestosPedidoID(Long idPedido)
			throws BusinessException, SQLException {
		return new FindAllRepuestosPedido(idPedido).execute();
	}

	@Override
	public void updateRepuestosExistenciasPrecio(
			List<Map<String, Object>> repuestos, Long idPedido)
			throws BusinessException, SQLException {
		for (Map<String, Object> repuesto : repuestos) {
			new UpdateRepuestoExistenciasPrecio((Long) repuesto.get("id"),
					idPedido).execute();
		}
	}

	@Override
	public void updateFechaRecepcionEstadoPedido(Long idPedido)
			throws BusinessException, SQLException {
		new UpdateFechaRecepcionEstadoPedido(idPedido).execute();
	}

}
