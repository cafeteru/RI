package uo.ri.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import uo.ri.model.exception.BusinessException;
import uo.ri.model.types.status.*;
import alb.util.date.DateUtil;
import alb.util.math.Round;

/**
 * Clase del modelo de dominio que simula una factura.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@Table(name = "TFACTURAS")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long numero;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private double importe;
	private double iva;

	@Enumerated(EnumType.STRING)
	private FacturaStatus status = FacturaStatus.SIN_ABONAR;

	@OneToMany(mappedBy = "factura")
	private Set<Averia> averias = new HashSet<Averia>();

	@OneToMany(mappedBy = "factura")
	private Set<Cargo> cargos = new HashSet<Cargo>();

	/**
	 * Constructor por defecto.
	 */
	Factura() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param numero
	 *            Número de la factura.
	 */
	public Factura(Long numero) {
		this.numero = numero;
		this.fecha = DateUtil.today();
	}

	/**
	 * Constructor con parámetros.
	 * 
	 * @param numero
	 *            Número de la factura.
	 * @param fecha
	 *            Fecha de la factura.
	 */
	public Factura(long numero, Date fecha) {
		this(numero);
		this.fecha = new Date(fecha.getTime());
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param numero
	 *            Número de la factura.
	 * @param averias
	 *            Lista de averías.
	 * @throws BusinessException
	 */
	public Factura(long numero, List<Averia> averias) throws BusinessException {
		this(numero);
		for (Averia a : averias) {
			addAveria(a);
		}
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param numero
	 *            Número de la factura.
	 * @param fecha
	 *            Fecha de la factura.
	 * @param averias
	 *            Lista de averías.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	public Factura(long numero, Date fecha, List<Averia> averias)
			throws BusinessException {
		this(numero, fecha);
		for (Averia a : averias) {
			addAveria(a);
		}
	}

	/**
	 * Método que devuelve el parámetro Id
	 * 
	 * @return El Id del objeto.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método que devuelve el parámetro numero.
	 * 
	 * @return El parámetro numero.
	 */
	public Long getNumero() {
		return numero;
	}

	/**
	 * Método que devuelve el parámetro fecha.
	 * 
	 * @return El parámetro fecha.
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Método que modifica el parámetro fecha.
	 * 
	 * @param fecha
	 *            Fecha de la factura.
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	 * Método que modifica el parámetro importe.
	 * 
	 * @param importe
	 *            Importe de la factura.
	 */
	public void setImporte(double importe) {
		this.importe = importe;
	}

	/**
	 * Método que devuelve el parámetro iva.
	 * 
	 * @return El parámetro iva.
	 */
	public double getIva() {
		Date _01_07_2012 = DateUtil.fromString("1/7/2012");
		if (fecha.after(_01_07_2012)) {
			setIva(21);
		} else {
			setIva(18);
		}
		return iva;
	}

	/**
	 * Método que modifica el parámetro iva.
	 * 
	 * @param iva
	 *            IVA aplicado.
	 */
	public void setIva(double iva) {
		this.iva = iva;
	}

	/**
	 * Método que devuelve el parámetro status.
	 * 
	 * @return El parámetro status.
	 */
	public FacturaStatus getStatus() {
		return status;
	}

	/**
	 * Método que modifica el parámetro status.
	 * 
	 * @param status
	 *            El estado de la factura.
	 */
	public void setStatus(FacturaStatus status) {
		this.status = status;
	}

	/**
	 * Método que devuelve una copia del parámetro cargos.
	 * 
	 * @return Una copia del parámetro cargos.
	 */
	public Set<Cargo> getCargos() {
		return new HashSet<>(cargos);
	}

	/**
	 * Método que devuelve el parámetro cargos.
	 * 
	 * @return El parámetro cargos.
	 */
	Set<Cargo> _getCargos() {
		return cargos;
	}

	/**
	 * Método que devuelve una copia del parámetro averias.
	 * 
	 * @return Una copia del parámetro averias.
	 */
	public Set<Averia> getAverias() {
		return new HashSet<>(averias);
	}

	/**
	 * Método que devuelve el parámetro averias.
	 * 
	 * @return El parámetro averias.
	 */
	Set<Averia> _getAverias() {
		return this.averias;
	}

	/**
	 * Añade la averia a la factura
	 * 
	 * @param averia
	 *            Objeto de la clase Averia.
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	public void addAveria(Averia averia) throws BusinessException {
		if (getStatus().equals(FacturaStatus.SIN_ABONAR)
				&& averia.getStatus().equals(AveriaStatus.TERMINADA)) {
			Association.Facturar.link(this, averia);
			averia.setStatus(AveriaStatus.FACTURADA);
			calcularImporte();
		} else {
			throw new BusinessException("No se puede añadir la avería a"
					+ " la factura, no está terminada");
		}

	}

	/**
	 * Calcula el importe de la avería y su IVA, teniendo en cuenta la fecha de
	 * factura
	 */
	void calcularImporte() {
		double importe = 0;
		for (Averia averia : averias) {
			importe += averia.getImporte();
		}
		importe *= (1 + getIva() / 100);
		setImporte(Round.twoCents(importe));
	}

	/**
	 * Elimina una avería de la factura, solo si está SIN_ABONAR y recalcula el
	 * importe
	 * 
	 * @param averia
	 *            Avería a borrar.
	 */
	public void removeAveria(Averia averia) {
		if (getStatus().equals(FacturaStatus.SIN_ABONAR)) {
			Association.Facturar.unlink(this, averia);
			averia.setStatus(AveriaStatus.TERMINADA);
			calcularImporte();
		}
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Factura other = (Factura) obj;
		if (numero == null) {
			if (other.numero != null) {
				return false;
			}
		} else if (!numero.equals(other.numero)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", fecha=" + fecha + ", importe="
				+ importe + ", iva=" + iva + ", status=" + status + ", averias="
				+ averias + "]";
	}

}
