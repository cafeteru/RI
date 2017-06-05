package uo.ri.business.impl;

import java.util.List;

import uo.ri.business.AdminService;
import uo.ri.business.impl.admin.mecanicos.*;
import uo.ri.business.impl.admin.pedidos.*;
import uo.ri.business.impl.admin.proveedores.*;
import uo.ri.business.impl.admin.repuestos.UpdatePedido;
import uo.ri.business.impl.admin.suministros.*;
import uo.ri.business.impl.util.CommandExecutor;
import uo.ri.model.*;
import uo.ri.model.exception.BusinessException;

/**
 * Clase de la parte lógica que implementa a la interfaz AdminService.
 * 
 * @author Iván González Mahagamage
 *
 */
public class AdminServiceImpl implements AdminService {
	private CommandExecutor executor = new CommandExecutor();

	@Override
	public void newMechanic(Mecanico mecanico) throws BusinessException {
		executor.execute(new AddMechanic(mecanico));
	}

	@Override
	public void updateMechanic(Mecanico mecanico) throws BusinessException {
		executor.execute(new UpdateMechanic(mecanico));
	}

	@Override
	public void deleteMechanic(Long idMecanico) throws BusinessException {
		executor.execute(new DeleteMechanic(idMecanico));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mecanico> findAllMechanics() throws BusinessException {
		return (List<Mecanico>) executor.execute(new FindAllMechanics());
	}

	@Override
	public Mecanico findMechanicById(Long id) throws BusinessException {
		return (Mecanico) executor.execute(new FindMechanicById(id));
	}

	@Override
	public void newProveedor(Proveedor proveedor) throws BusinessException {
		executor.execute(new AddProveedor(proveedor));
	}

	@Override
	public void deleteProveedor(String codigoProveedor)
			throws BusinessException {
		executor.execute(new DeleteProveedor(codigoProveedor));
	}

	@Override
	public void updateProveedor(Proveedor proveedor) throws BusinessException {
		executor.execute(new UpdateProveedor(proveedor));
	}

	@Override
	public Proveedor findProveedorByNombre(String nombre)
			throws BusinessException {
		return (Proveedor) executor.execute(new FindProveedorByNombre(nombre));
	}

	@Override
	public Proveedor findProveedorByCodigo(String codigo)
			throws BusinessException {
		return (Proveedor) executor.execute(new FindProveedorByCodigo(codigo));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proveedor> findAllProveedores() throws BusinessException {
		return (List<Proveedor>) executor.execute(new FindAllProveedores());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findAllPedidosProveedor(String idProveedor)
			throws BusinessException {
		return (List<Pedido>) executor
				.execute(new FindAllPedidosProveedor(idProveedor));
	}

	@Override
	public Pedido findRepuestosPedidoID(String codigoPedido)
			throws BusinessException {
		return (Pedido) executor
				.execute(new FindRepuestosPedidoID(codigoPedido));
	}

	@Override
	public void newSuministro(String codigoRepuesto, String codigoProveedor,
			Double precio) throws BusinessException {
		executor.execute(
				new AddSuministro(codigoRepuesto, codigoProveedor, precio));

	}

	@Override
	public void deleteSuministro(String codigoRepuesto, String codigoProveedor)
			throws BusinessException {
		executor.execute(new DeleteSuministro(codigoRepuesto, codigoProveedor));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Suministro> findAllSuministros() throws BusinessException {
		return (List<Suministro>) executor.execute(new FindAllSuministros());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Suministro> findSuministrosByProveedor(String codigoProveedor)
			throws BusinessException {
		return (List<Suministro>) executor
				.execute(new FindSuministrosByProveedor(codigoProveedor));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Suministro> findSuministrosByRepuesto(String codigoRepuesto)
			throws BusinessException {
		return (List<Suministro>) executor
				.execute(new FindSuministrosByRepuesto(codigoRepuesto));
	}

	@Override
	public void updateSuministro(Suministro suministro)
			throws BusinessException {
		executor.execute(new UpdateSuministro(suministro));
	}

	@Override
	public void updatePedido(Pedido pedido) throws BusinessException {
		executor.execute(new UpdatePedido(pedido));
	}

}
