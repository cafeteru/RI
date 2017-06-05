package uo.ri.persistence;

import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

/**
 * Clase de la parte de persistencia encargada de manejar los datos de los
 * pedidos.
 * 
 * @author Iván González Mahagamage
 *
 */
public interface PedidosGateway {
	/**
	 * M�todo que se encarga de conectarse a la base de datos.
	 * 
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 */
	void setConnection() throws BusinessException;

	/**
	 * M�todo que lista todos los pedidos que hay en la base de datos realizados
	 * a un proveedor.
	 * 
	 * @param idProveedor
	 *            ID del proveedor.
	 * @return Una lista todos los pedidos realizados a un proveedor
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 */
	List<Map<String, Object>> listarPedidosProveedor(Long idProveedor)
			throws BusinessException;

	/**
	 * M�todo que lista todos los repuestos que hay en un pedido en la base de
	 * datos.
	 * 
	 * @param idPedido
	 *            ID del pedido.
	 * @return Una lista todos los repuestos que hay en un pedido.
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 */
	List<Map<String, Object>> listarRepuestosPedidoId(Long idPedido)
			throws BusinessException;

	/**
	 * M�todo que modifica las existencias y el precio de un repuesto en la base
	 * de datos.
	 * 
	 * @param idRepuesto
	 *            ID del repuesto.
	 * @param idPedido
	 *            ID del pedido.
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 */
	void modificarExistenciasPrecioRepuesto(Long idRepuesto, Long idPedido)
			throws BusinessException;

	/**
	 * M�todo que la fecha de recepci�n y el estado de un pedido en la base de
	 * datos.
	 * 
	 * @param idPedido
	 *            ID del pedido.
	 * @throws BusinessException
	 *             Excepci�n ocurrida al realizar el programa.
	 */
	void modificarFechaRecepcionEstadoPedido(Long idPedido)
			throws BusinessException;
}
