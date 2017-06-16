package uo.ri.business;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

/**
 * Interfaz de la parte de l�gica que declara los métodos que usa la clase
 * Admin.
 * 
 * @author Iván González Mahagamage
 *
 */
public interface AdminService {
	/**
	 * A�ade un mec�nico.
	 * 
	 * @param nombre
	 *            Nombre del nuevo mec�nico.
	 * @param apellidos
	 *            Apellidos del nuevo mec�nico.
	 * @throws BusinessException
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	void newMechanic(String nombre, String apellidos)
			throws BusinessException, SQLException;

	/**
	 * Borra un mec�nico.
	 * 
	 * @param idMecanico
	 *            ID del mec�nico.
	 * @throws BusinessException
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	void deleteMechanic(Long idMecanico) throws BusinessException, SQLException;

	/**
	 * Actualiza la informaci�n de mec�nico.
	 * 
	 * @param id
	 *            ID del mec�nico.
	 * @param nombre
	 *            Nombre del nuevo mec�nico.
	 * @param apellidos
	 *            Apellidos del nuevo mec�nico.
	 * @throws BusinessException
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	void updateMechanic(Long id, String nombre, String apellidos)
			throws BusinessException, SQLException;

	/**
	 * Lista a todos los mec�nicos.
	 * 
	 * @return Un lista con todos los mec�nicos.
	 * @throws BusinessException
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	List<Map<String, Object>> findAllMechanics()
			throws BusinessException, SQLException;

	/**
	 * A�ade un proveedor.
	 * 
	 * @param nombre
	 *            Nombre del proveedor.
	 * @param codigo
	 *            Codigo del proveedor.
	 * @throws BusinessException
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	void newProveedor(String nombre, String codigo)
			throws BusinessException, SQLException;

	/**
	 * Borra un proveedor.
	 * 
	 * @param idProveedor
	 *            ID del proveedor.
	 * @throws BusinessException
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	void deleteProveedor(Long idProveedor)
			throws BusinessException, SQLException;

	/**
	 * Actualiza la informaci�n de un proveedor sabiendo su ID.
	 * 
	 * @param idProveedor
	 *            ID del proveedor.
	 * @param nombre
	 *            Nombre del proveedor.
	 * @param codigo
	 *            Codigo del proveedor.
	 * @throws BusinessException
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	void updateProveedor(Long idProveedor, String nombre, String codigo)
			throws BusinessException, SQLException;

	/**
	 * Actualiza la informaci�n de un proveedor sabiendo su nombre.
	 * 
	 * @param nombre
	 *            Nombre del proveedor.
	 * @param nombreNuevo
	 *            Nuevo nombre del proveedor.
	 * @param codigo
	 *            Codigo del proveedor.
	 * @throws BusinessException
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	void updateProveedorSinID(String nombre, String nombreNuevo, String codigo)
			throws BusinessException, SQLException;

	/**
	 * Lista a todos los proveedores.
	 * 
	 * @return Una lista con todos los proveedores.
	 * @throws BusinessException
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	List<Map<String, Object>> findAllProveedores()
			throws BusinessException, SQLException;

	/**
	 * A�ade un nuevo respuesto suministrado por un proveedor.
	 * 
	 * @param idRepuesto
	 *            Id del repuesto.
	 * @param idProveedor
	 *            ID del proveedor.
	 * @param precio
	 *            Precio del repuesto.
	 * @throws BusinessException
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
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
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	void deleteSuministro(Long idRepuesto, Long idProveedor)
			throws BusinessException, SQLException;

	/**
	 * Actualiza la informaci�n de un respuesto suministrado por un proveedor.
	 * 
	 * @param idRepuesto
	 *            Id del repuesto.
	 * @param idProveedor
	 *            ID del proveedor.
	 * @param precio
	 *            Precio del repuesto.
	 * @throws BusinessException
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
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
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
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
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
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
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	void updateRepuestosExistenciasPrecio(List<Map<String, Object>> repuestos,
			Long idPedido) throws BusinessException, SQLException;

	/**
	 * Actualiza la fecha de recepci�n y el estado de un pedido.
	 * 
	 * @param idPedido
	 *            Id del pedido.
	 * @throws BusinessException
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
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
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
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
	 *             Excepixi�n ocurrida al realizar el programa.
	 * @throws SQLException
	 *             Excepci�n ocurrida al realizar secuencias SQL.
	 */
	List<Map<String, Object>> findAllPedidosProveedor(Long idProveedor)
			throws BusinessException, SQLException;
}
