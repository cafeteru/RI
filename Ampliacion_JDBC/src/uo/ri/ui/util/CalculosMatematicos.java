package uo.ri.ui.util;

import alb.util.math.Round;

/**
 * Clase creada para realizar c�lculos matem�ticos.
 * 
 * @author Iv�n Gonzalez Mahagamage
 *
 */
public class CalculosMatematicos {

	/**
	 * Calcula el nuevo precio de un repuesto despu�s de recibir un pedido.
	 * 
	 * @param existencias
	 *            N�mero de existencias antes de la recepci�n del pedido.
	 * @param precioExistencias
	 *            Precio del repuesto antes de la recepci�n del pedido.
	 * @param unidades
	 *            Unidades del repuesto dentro del pedido.
	 * @param precioUnidades
	 *            Precio unidad del repuesto dentro del pedido.
	 * @param existenciasTotales
	 *            La suma de existencias y unidades.
	 * @return Nuevo precio del repuesto.
	 */
	public static double calcularMedia(int existencias,
			double precioExistencias, int unidades, double precioUnidades,
			int existenciasTotales) {
		double precioExistenciasTotal = precioExistencias * existencias;
		double precioUnidadesTotal = precioUnidades * unidades;
		double resultado = (precioExistenciasTotal + precioUnidadesTotal)
				/ existenciasTotales;
		return Round.twoCents(resultado);
	}

}
