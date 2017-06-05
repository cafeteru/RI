package uo.ri.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import alb.util.date.DateUtil;
import alb.util.math.Round;
import uo.ri.model.exception.BusinessException;
import uo.ri.model.types.AveriaStatus;
import uo.ri.model.types.FacturaStatus;

public class Factura {

	private Long numero;
	private Date fecha;
	private double importe;
	private double iva;
	private FacturaStatus status = FacturaStatus.SIN_ABONAR;

	private Set<Averia> averias = new HashSet<>();
	private Set<Cargo> cargos = new HashSet<>();

	public Factura(Long numero) {
		this.numero = numero;
		this.fecha = DateUtil.today();
	}

	public Factura(long numero, Date fecha) {
		this(numero);
		this.fecha = fecha;
	}

	public Factura(long numero, List<Averia> averias) throws BusinessException {
		this(numero);
		inicializarFactura(averias);
	}

	public Factura(long numero, Date fecha, List<Averia> averias) throws BusinessException {
		this(numero, fecha);
		inicializarFactura(averias);
	}

	private void inicializarFactura(List<Averia> averias) throws BusinessException {
		for (Averia averia : averias) {
			if (!averia.getStatus().equals(AveriaStatus.TERMINADA))
				throw new BusinessException("La avería " + averia.getDescripcion() + " no esta terminada.");
			else
				averia.setStatus(AveriaStatus.FACTURADA);
		}
		this.averias = new HashSet<>(averias);
		calcularImporte();
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public FacturaStatus getStatus() {
		return status;
	}

	public void setStatus(FacturaStatus status) {
		this.status = status;
	}

	public Long getNumero() {
		return numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", fecha=" + fecha + ", importe=" + importe + ", iva=" + iva + ", status="
				+ status + "]";
	}

	/**
	 * Añade la averia a la factura
	 * 
	 * @param averia
	 */
	public void addAveria(Averia averia) {
		// Verificar que la factura está en estado SIN_ABONAR
		// Verificar que La averia está TERMINADA
		// linkar factura y averia
		// marcar la averia como FACTURADA ( averia.markAsInvoiced() )
		// calcular el importe
		if (status.equals(FacturaStatus.SIN_ABONAR)) {
			if (averia.getStatus().equals(AveriaStatus.TERMINADA)) {
				Association.Facturar.link(this, averia);
				averia.markAsInvoiced();
				calcularImporte();
			}
		}
	}

	/**
	 * Calcula el importe de la avería y su IVA, teniendo en cuenta la fecha de
	 * factura
	 */
	void calcularImporte() {
		// iva = ...
		// importe = ...
		double iva = DateUtil.fromString("1/7/2012").before(fecha) ? 21.0 : 18.0;
		double importe = 0;
		for (Averia averia : averias)
			importe += averia.getImporte();
		importe *= 1 + (iva / 100);
		setImporte(Round.twoCents(importe));
	}

	/**
	 * Elimina una averia de la factura, solo si está SIN_ABONAR y recalcula el
	 * importe
	 * 
	 * @param averia
	 */
	public void removeAveria(Averia averia) {
		// verificar que la factura está sin abonar
		// desenlazar factura y averia
		// la averia vuelve al estado FINALIZADA ( averia.markBackToFinished() )
		// volver a calcular el importe
		if (getStatus().equals(FacturaStatus.SIN_ABONAR)) {
			Association.Facturar.unlink(this, averia);
			averia.markBackToFinished();
			calcularImporte();
		}
	}

	public Set<Averia> getAverias() {
		return new HashSet<>(averias);
	}

	Set<Averia> _getAverias() {
		return averias;
	}

	public Set<Cargo> getCargos() {
		return new HashSet<>(cargos);
	}

	Set<Cargo> _getCargos() {
		return cargos;
	}
}
