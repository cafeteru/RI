package uo.ri.ui.admin.action.suministros;

import java.util.List;

import alb.util.console.Console;
import uo.ri.model.*;
import uo.ri.model.exception.BusinessException;
import uo.ri.ui.admin.action.util.TemplateCommand;
import uo.ri.ui.util.*;

/**
 * Clase que actualiza los datos de un repuesto ofrecido por un proveedor
 * 
 * @author Iván González Mahagamage
 *
 */
public class UpdateSuministrosAction extends TemplateCommand {
	String codigoProveedor, codigoRepuesto;
	List<Suministro> suministros;

	@Override
	protected void pedirDatos() {
		if (Preguntar.hacerPregunta("¿Desea buscar por proveedor? (Si o no)")) {
			codigoProveedor = Console.readString("Código del proveedor");
		} else {
			codigoRepuesto = Console.readString("Código del repuesto");
		}
	}

	@Override
	protected void procesarDatos() throws BusinessException {
		Suministro suministro;
		if (codigoProveedor != null)
			suministro = buscarSuministrosPorProveedor();
		else
			suministro = buscarSuministrosPorRepuesto();
		double precio = Console.readDouble("Nuevo precio del suministro");
		suministro.setPrecio(precio);
		as.updateSuministro(suministro);
	}

	@Override
	protected void imprimirMensaje() {
		Console.println("Suministro actualizado");
	}

	/**
	 * Método que busca los repuestos suministrados por un proveedor.
	 * 
	 * @return Los repuestos suministrados por un proveedor.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	private Suministro buscarSuministrosPorProveedor()
			throws BusinessException {
		suministros = as.findSuministrosByProveedor(codigoProveedor);
		imprimirSuministros();
		Long id = Console.readLong(
				"Seleccione el repuesto del proveedor que desea modificar");
		return buscarSuministroPorRepuesto(id);
	}

	/**
	 * Método que busca los proveedor que suministran un repuesto.
	 * 
	 * @return Los proveedor que suministran un repuesto.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	private Suministro buscarSuministrosPorRepuesto() throws BusinessException {
		suministros = as.findSuministrosByRepuesto(codigoRepuesto);
		imprimirSuministros();
		Long id = Console.readLong(
				"Seleccione el proveedor del repuesto que desea modificar");
		return buscarSuministroPorProveedor(id);
	}

	/**
	 * Método que imprime los suministros encontrados.
	 *
	 */
	private void imprimirSuministros() {
		Console.println("Estos son los suministro encontrados");
		Printer.imprimirListaSuministros(suministros);
	}

	/**
	 * Método que selecciona un suministro dentro de una lista.
	 * 
	 * @param idProveedor
	 *            Id del proveedor.
	 * @return Un suministro dentro de una lista.
	 */
	private Suministro buscarSuministroPorProveedor(Long idProveedor) {
		for (Suministro s : suministros)
			if (s.getProveedor().getId().equals(idProveedor))
				return s;
		return null;
	}

	/**
	 * Método que selecciona un suministro dentro de una lista.
	 * 
	 * @param idRepuesto
	 *            Id del repuesto.
	 * @return Un suministro dentro de una lista.
	 */
	private Suministro buscarSuministroPorRepuesto(Long idRepuesto) {
		for (Suministro s : suministros)
			if (s.getRepuesto().getId().equals(idRepuesto))
				return s;
		return null;
	}

}
