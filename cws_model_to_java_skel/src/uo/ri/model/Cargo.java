package uo.ri.model;

import uo.ri.model.exception.BusinessException;
import uo.ri.model.types.FacturaStatus;

public class Cargo {

	private Factura factura;
	private MedioPago medioPago;
	private double importe = 0.0;

	public Cargo(Factura factura, MedioPago medioPago, double importe) throws BusinessException {
		// incrementar el importe en el acumulado del medio de pago
		// guardar el importe
		// enlazar (link) factura, este cargo y medioDePago
		medioPago.acumulado += importe;
		this.importe = importe;
		Association.Cargar.link(factura, medioPago, this);
	}

	/**
	 * Anula (retrocede) este cargo de la factura y el medio de pago Solo se
	 * puede hacer si la factura no está abonada Decrementar el acumulado del
	 * medio de pago Desenlazar el cargo de la factura y el medio de pago
	 * 
	 * @throws BusinessException
	 */
	public void rewind() throws BusinessException {
		// verificar que la factura no esta ABONADA
		// decrementar acumulado en medio de pago
		// desenlazar factura, cargo y medio de pago
		if (factura.getStatus().equals(FacturaStatus.SIN_ABONAR)) {
			medioPago.acumulado -= importe;
			factura._getCargos().remove(this);
			medioPago._getCargos().remove(this);
		}
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Factura getFactura() {
		return factura;
	}

	void _setFactura(Factura factura) {
		this.factura = factura;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	void _setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

}
