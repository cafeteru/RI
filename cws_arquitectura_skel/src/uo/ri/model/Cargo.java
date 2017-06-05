package uo.ri.model;

import javax.persistence.*;

import uo.ri.model.exception.BusinessException;
import uo.ri.model.types.keys.CargoKey;
import uo.ri.model.types.status.FacturaStatus;

/**
 * Clase del modelo de dominio que simula un cargo.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@IdClass(CargoKey.class)
@Table(name = "TCARGOS")
public class Cargo {

	@Id
	@ManyToOne
	private Factura factura;

	@Id
	@ManyToOne
	private MedioPago medioPago;
	private double importe = 0.0;

	/**
	 * Constructor por defecto.
	 *
	 */
	Cargo() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param factura
	 *            Objeto de la clase Factura.
	 * @param medioPago
	 *            Objeto de la clase MedioPago.
	 */
	public Cargo(Factura factura, MedioPago medioPago) {
		this(factura, medioPago, 0);
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param factura
	 *            Objeto de la clase Factura.
	 * @param medioPago
	 *            Objeto de la clase MedioPago.
	 * @param importe
	 *            Importe de la factura.
	 */
	public Cargo(Factura factura, MedioPago medioPago, double importe) {
		medioPago.setAcumulado(medioPago.getAcumulado() + importe);
		Association.Cargar.link(medioPago, this, factura);
	}

	/**
	 * Método que devuelve el parámetro factura.
	 * 
	 * @return El parámetro factura.
	 */
	public Factura getFactura() {
		return factura;
	}

	/**
	 * Método que modifica el parámetro factura.
	 * 
	 * @param factura
	 *            Objeto de la clase Factura.
	 */
	void _setFactura(Factura factura) {
		this.factura = factura;
	}

	/**
	 * Método que devuelve el parámetro medioPago.
	 * 
	 * @return El parámetro medioPago.
	 */
	public MedioPago getMedioPago() {
		return medioPago;
	}

	/**
	 * Método que modifica el parámetro medioPago.
	 * 
	 * @param medioPago
	 *            Objeto de la clase MedioPago.
	 */
	void _setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	/**
	 * Método que devuelve el parámetro importe.
	 * 
	 * @return El parámetro importe.
	 */
	public double getImporte() {
		return importe;
	}

	/**
	 * Anula (retrocede) este cargo de la factura y el medio de pago Solo se
	 * puede hacer si la factura no está abonada Decrementar el acumulado del
	 * medio de pago Desenlazar el cargo de la factura y el medio de pago
	 * 
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	public void rewind() throws BusinessException {
		if (!factura.getStatus().equals(FacturaStatus.ABONADA)) {
			medioPago.acumulado -= importe;
			Association.Cargar.unlink(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result
				+ ((medioPago == null) ? 0 : medioPago.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cargo other = (Cargo) obj;
		if (factura == null) {
			if (other.factura != null) {
				return false;
			}
		} else if (!factura.equals(other.factura)) {
			return false;
		}
		if (medioPago == null) {
			if (other.medioPago != null) {
				return false;
			}
		} else if (!medioPago.equals(other.medioPago)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cargo [factura=" + factura + ", medioPago=" + medioPago
				+ ", importe=" + importe + "]";
	}

}
