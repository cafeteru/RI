package uo.ri.business;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

/**
 * Interfaz de la parte de lógica que declara los métodos que usa la clase
 * Admin.
 * 
 * @author Iván González Mahagamage
 *
 */
public interface AdminService {
	/**
	 * Añade un mecánico.
	 * 
	 * @param nombre
	 *            Nombre del nuevo mecánico.
	 * @param apellidos
	 *            Apellidos del nuevo mecánico.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	void newMechanic(String nombre, String apellidos)
			throws BusinessException, SQLException;

	/**
	 * Borra un mecánico.
	 * 
	 * @param idMecanico
	 *            ID del mecánico.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	void deleteMechanic(Long idMecanico) throws BusinessException, SQLException;

	/**
	 * Actualiza la información de mecánico.
	 * 
	 * @param id
	 *            ID del mecánico.
	 * @param nombre
	 *            Nombre del nuevo mecánico.
	 * @param apellidos
	 *            Apellidos del nuevo mecánico.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	void updateMechanic(Long id, String nombre, String apellidos)
			throws BusinessException, SQLException;

	/**
	 * Lista a todos los mecánicos.
	 * 
	 * @return Un lista con todos los mecánicos.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	List<Map<String, Object>> findAllMechanics()
			throws BusinessException, SQLException;

	/**
	 * Añade un proveedor.
	 * 
	 * @param nombre
	 *            Nombre del proveedor.
	 * @param codigo
	 *            Codigo del proveedor.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	void newProveedor(String nombre, String codigo)
			throws BusinessException, SQLException;

	/**
	 * Borra un proveedor.
	 * 
	 * @param idProveedor
	 *            ID del proveedor.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	void deleteProveedor(Long idProveedor)
			throws BusinessException, SQLException;

	/**
	 * Actualiza la información de un proveedor sabiendo su ID.
	 * 
	 * @param idProveedor
	 *            ID del proveedor.
	 * @param nombre
	 *            Nombre del proveedor.
	 * @param codigo
	 *            Codigo del proveedor.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	void updateProveedor(Long idProveedor, String nombre, String codigo)
			throws BusinessException, SQLException;

	/**
	 * Actualiza la información de un proveedor sabiendo su nombre.
	 * 
	 * @param nombre
	 *            Nombre del proveedor.
	 * @param nombreNuevo
	 *            Nuevo nombre del proveedor.
	 * @param codigo
	 *            Codigo del proveedor.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	void updateProveedorSinID(String nombre, String nombreNuevo, String codigo)
			throws BusinessException, SQLException;

	/**
	 * Lista a todos los proveedores.
	 * 
	 * @return Una lista con todos los proveedores.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	List<Map<String, Object>> findAllProveedores()
			throws BusinessException, SQLException;

	/**
	 * Añade un nuevo respuesto suministrado por un proveedor.
	 * 
	 * @param idRepuesto
	 *            Id del repuesto.
	 * @param idProveedor
	 *            ID del proveedor.
	 * @param precio
	 *            Precio del repuesto.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	void newSuministro(Long idRepuesto, Long idProveedor, Double precio)
			throws BusinessException, SQLException;

	/**
	 * Borra un respuesto suministrado por un proveedor.
	 * 
	 * @param idRepuesto
	 *            Id del repuesto.v
	 * @param idProveedor
	 *            ID del proveedor.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	void deleteSuministro(Long idRepuesto, Long idProveedor)
			throws BusinessException, SQLException;

	/**
	 * Actualiza la información de un respuesto suministrado por un proveedor.
	 * 
	 * @param idRepuesto
	 *            Id del repuesto.
	 * @param idProveedor
	 *            ID del proveedor.
	 * @param precio
	 *            Precio del repuesto.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	void updateSuministro(Long idRepuesto, Long idProveedor, Double precio)
			throws BusinessException, SQLException;

	/**
	 * Lista todos los repuestos sumnistrados por un proveedor.
	 * 
	 * @param idProveedor
	 *            ID del proveedor.
	 * @return Una lista con los repuestos suministrador por un proveedor.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	List<Map<String, Object>> findAllSuministrosProveedor(Long idProveedor)
			throws BusinessException, SQLException;

	/**
	 * Lista todos los elementos que suministran un repuesto.
	 * 
	 * @param idRepuesto
	 *            Id del repuesto.
	 * @return Una lista con los proveedores que suministran un repuesto.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	List<Map<String, Object>> findAllSuministrosRepuesto(Long idRepuesto)
			throws BusinessException, SQLException;

	/**
	 * Actualiza las existencias y el precio de una lista de repuestos.
	 * 
	 * @param repuestos
	 *            Lista de repuestos.
	 * @param idPedido
	 *            Id del pedido.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	void updateRepuestosExistenciasPrecio(List<Map<String, Object>> repuestos,
			Long idPedido) throws BusinessException, SQLException;

	/**
	 * Actualiza la fecha de recepción y el estado de un pedido.
	 * 
	 * @param idPedido
	 *            Id del pedido.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	void updateFechaRecepcionEstadoPedido(Long idPedido)
			throws BusinessException, SQLException;

	/**
	 * Lista los repuestos que hay en un pedido.
	 * 
	 * @param idPedido
	 *            Id del pedido.
	 * @return Una lista de los repuesto que hay en un pedido.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	List<Map<String, Object>> findRepuestosPedidoID(Long idPedido)
			throws BusinessException, SQLException;

	/**
	 * Lista todos los pedidos realizados a un proveedor.
	 * 
	 * @param idProveedor
	 *            ID del proveedor.
	 * @return Una lista con los pedidos realizados a un proveedor.
	 * @throws BusinessException
	 *             Excepixión ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepción ocurrida al realizar secuencias SQL.
	 */
	List<Map<String, Object>> findAllPedidosProveedor(Long idProveedor)
			throws BusinessException, SQLException;
}
