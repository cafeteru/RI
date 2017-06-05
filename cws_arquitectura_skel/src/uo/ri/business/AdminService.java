package uo.ri.business;

import java.util.List;

import uo.ri.model.*;
import uo.ri.model.exception.BusinessException;

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
	 * @param mecanico
	 *            Objeto de la clase Mecanico.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	void newMechanic(Mecanico mecanico) throws BusinessException;

	/**
	 * Borra un mecánico.
	 * 
	 * @param idMecanico
	 *            Identificador del mecánico en la base de datos.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	void deleteMechanic(Long idMecanico) throws BusinessException;

	/**
	 * Actualiza la información de mecánico.
	 * 
	 * @param mecanico
	 *            Objeto de la clase Mecanico.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	void updateMechanic(Mecanico mecanico) throws BusinessException;

	/**
	 * Busca a un mecánico por su ID
	 * 
	 * @param id
	 *            Identificador del mecánico en la base de datos.
	 * @return Objeto de la clase Mecanico.
	 * @throws BusinessException
	 */
	Mecanico findMechanicById(Long id) throws BusinessException;

	/**
	 * Lista a todos los mecánicos.
	 * 
	 * @return Una lista con objetos de la clase Mecanico.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	List<Mecanico> findAllMechanics() throws BusinessException;

	/**
	 * Añade un proveedor.
	 * 
	 * @param proveedor
	 *            Objeto de la clase Proveedor.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	void newProveedor(Proveedor proveedor) throws BusinessException;

	/**
	 * Borra un proveedor.
	 * 
	 * @param codigoProveedor
	 *            Código del proveedor.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	void deleteProveedor(String codigoProveedor) throws BusinessException;

	/**
	 * Actualiza la información de un proveedor.
	 * 
	 * @param proveedor
	 *            Objeto de la clase Proveedor.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	void updateProveedor(Proveedor proveedor) throws BusinessException;

	/**
	 * Busca un proveedor en la base de datos a partir de su nombre.
	 * 
	 * @param nombre
	 *            Nombre del proveedor.
	 * @return Un objeto de la clase Proveedor.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	Proveedor findProveedorByNombre(String nombre) throws BusinessException;

	/**
	 * Busca un proveedor en la base de datos a partir de su código.
	 * 
	 * @param codigo
	 *            Código del proveedor.
	 * @return Un objeto de la clase Proveedor.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	Proveedor findProveedorByCodigo(String codigo) throws BusinessException;

	/**
	 * Lista a los proveedores de la base de datos.
	 * 
	 * @return Una lista de objetos de clase Proveedor.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	List<Proveedor> findAllProveedores() throws BusinessException;

	/**
	 * Lista todos los pedidos realizados a un proveedor determinado.
	 * 
	 * @param codigoProveedor
	 *            Código del proveedor.
	 * @return Lista de objetos de la clase Pedido.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	List<Pedido> findAllPedidosProveedor(String codigoProveedor)
			throws BusinessException;

	/**
	 * Busca los repuestos de un determinado pedido.
	 * 
	 * @param codigoPedido
	 *            Código del pedido.
	 * @return Una objeto Pedido.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	Pedido findRepuestosPedidoID(String codigoPedido) throws BusinessException;

	/**
	 * Añade un repuesto suministrado por un proveedor.
	 * 
	 * @param codigoRepuesto
	 *            Código del repuesto.
	 * @param codigoProveedor
	 *            Código del proveedor
	 * @param precio
	 *            Precio del repuesto.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	void newSuministro(String codigoRepuesto, String codigoProveedor,
			Double precio) throws BusinessException;

	/**
	 * Borra un repuesto suministrado por un proveedor.
	 * 
	 * @param codigoRepuesto
	 *            Código del repuesto.
	 * @param codigoProveedor
	 *            Código del proveedor
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	void deleteSuministro(String codigoRepuesto, String codigoProveedor)
			throws BusinessException;

	/**
	 * Lista todos los repuestos suministrados por todos los proveedores.
	 * 
	 * @return Una lista de objetos de la clase Suministro.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	List<Suministro> findAllSuministros() throws BusinessException;

	/**
	 * Devuelve los repuestos suministrados por un determinado proveedor.
	 * 
	 * @param codigoProveedor
	 *            Código del proveedor.
	 * @return Una lista de objetos de la clase Suministro.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	List<Suministro> findSuministrosByProveedor(String codigoProveedor)
			throws BusinessException;

	/**
	 * Devuelve una lista con las ofertas de un determinado repuesto.
	 * 
	 * @param codigoRepuesto
	 *            Código del repuesto.
	 * @return Una lista de objetos de la clase Suministro.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	List<Suministro> findSuministrosByRepuesto(String codigoRepuesto)
			throws BusinessException;

	/**
	 * Actualiza la información de un repuesto suministrado por un proveedor.
	 * 
	 * @param suministro
	 *            Objeto de la clase Suministro.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	void updateSuministro(Suministro suministro) throws BusinessException;

	/**
	 * Actualiza la base de datos tras recibir un pedido.
	 * 
	 * @param pedido
	 *            Objeto de la clase Pedido.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	void updatePedido(Pedido pedido) throws BusinessException;
}
