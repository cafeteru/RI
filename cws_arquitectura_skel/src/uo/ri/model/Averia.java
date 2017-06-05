package uo.ri.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import alb.util.math.Round;
import uo.ri.model.exception.BusinessException;
import uo.ri.model.types.status.AveriaStatus;

/**
 * Clase del modelo de dominio que simula una avería.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@Table(name = "TAVERIAS")
public class Averia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;
	private double importe = 0.0;

	@Enumerated(EnumType.STRING)
	private AveriaStatus status = AveriaStatus.ABIERTA;

	@ManyToOne
	private Vehiculo vehiculo;

	@OneToMany(mappedBy = "averia")
	private Set<Intervencion> intervenciones = new HashSet<Intervencion>();

	@ManyToOne
	private Mecanico mecanico;

	@ManyToOne
	private Factura factura;

	/**
	 * Constructor por defecto.
	 *
	 */
	Averia() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param vehiculo
	 *            Objeto de la clase Vehiculo.
	 */
	public Averia(Vehiculo vehiculo) {
		this(new Date(), vehiculo);
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param fecha
	 *            Fecha en la que se registra la avería.
	 * @param vehiculo
	 *            Objeto de la clase Vehiculo.
	 */
	public Averia(Date fecha, Vehiculo vehiculo) {
		this.fecha = fecha;
		Association.Averiar.link(vehiculo, this);
		vehiculo.incrementarAverias();
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param vehiculo
	 *            Objeto de la clase Vehiculo.
	 * @param descripcion
	 *            Descripción de la avería.
	 */
	public Averia(Vehiculo vehiculo, String descripcion) {
		this(new Date(), vehiculo);
		this.descripcion = descripcion;
	}

	/**
	 * Método que devuelve el parámetro Id.
	 * 
	 * @return El Id del objeto.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Devuelve el parámetro fecha.
	 * 
	 * @return La fecha de registro de la avería.
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Devuelve el parámetro importe.
	 * 
	 * @return El importe de la avería.
	 */
	public double getImporte() {
		return importe;
	}

	/**
	 * Modifica el parámetro importe.
	 * 
	 * @param importe
	 *            Importe de la avería.
	 */
	public void setImporte(double importe) {
		this.importe = importe;
	}

	/**
	 * Devuelve el parámetro status.
	 * 
	 * @return El estado de la avería.
	 */
	public AveriaStatus getStatus() {
		return status;
	}

	/**
	 * Modifica el parámetro status.
	 * 
	 * @param status
	 *            Estado de la avería.
	 */
	public void setStatus(AveriaStatus status) {
		this.status = status;
	}

	/**
	 * Devuelve el parámetro descripción.
	 * 
	 * @return La descripción de la avería.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Modifica el parámetro descripción.
	 * 
	 * @param descripcion
	 *            Descripción de la avería.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve el parámetro vehículo.
	 * 
	 * @return El vehículo que tiene la avería.
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * Modifica el parámetro vehículo.
	 * 
	 * @param vehiculo
	 *            Vehículo que tiene la avería
	 */
	void _setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	/**
	 * Devuelve el parámetro mecanico.
	 * 
	 * @return El mecánico asignado para la avería.
	 */
	public Mecanico getMecanico() {
		return mecanico;
	}

	/**
	 * Modifica el parámetro mecanico.
	 * 
	 * @param mecanico
	 *            Mecánico asignado para la avería
	 */
	void _setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	/**
	 * Devuelve una copia el parámetro intervenciones.
	 * 
	 * @return Una copia de las intervenciones recibidas.
	 */
	public Set<Intervencion> getIntervenciones() {
		return new HashSet<Intervencion>(intervenciones);
	}

	/**
	 * Devuelve el parámetro intervenciones.
	 * 
	 * @return Intervenciones recibidas.
	 */
	Set<Intervencion> _getIntervenciones() {
		return intervenciones;
	}

	/**
	 * Devuelve el parámetro factura.
	 * 
	 * @return La factura en la que sale la avería.
	 */
	public Factura getFactura() {
		return factura;
	}

	/**
	 * Modifica el parámetro factura.
	 * 
	 * @param factura
	 *            Factura en la que sale la avería.
	 */
	void _setFactura(Factura factura) {
		this.factura = factura;
	}

	/**
	 * Asigna la averia al mecanico
	 * 
	 * @param mecanico
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 */
	public void assignTo(Mecanico mecanico) throws BusinessException {
		if (getStatus().equals(AveriaStatus.ABIERTA)) {
			Association.Asignar.link(mecanico, this);
			setStatus(AveriaStatus.ASIGNADA);
		} else {
			throw new BusinessException(
					"La averia no se puede asignar, su estado es abierta");
		}
	}

	/**
	 * El mecánico da por finalizada esta avería, entonces se calcula el importe
	 * 
	 * @throws BusinessException
	 *             Excepción ocurrida durante la ejecución.
	 * 
	 */
	public void markAsFinished() throws BusinessException {
		if (getStatus().equals(AveriaStatus.ASIGNADA)) {
			calcularImporte();
			Association.Asignar.unlink(mecanico, this);
			setStatus(AveriaStatus.TERMINADA);
		} else {
			throw new BusinessException(
					"La avería no esta asignada para poder finalizarla.");
		}
	}

	/**
	 * Calcula el importe de la avería.
	 */
	public void calcularImporte() {
		double precio = 0;
		for (Intervencion intervencion : intervenciones) {
			precio += intervencion.getImporte();
		}
		setImporte(Round.twoCents(precio));
	}

	/**
	 * Una averia en estado TERMINADA se puede asignar a otro mec�nico (el
	 * primero no ha podido terminar la reparaci�n), pero debe ser pasada a
	 * ABIERTA primero
	 */
	public void reopen() {
		if (status.equals(AveriaStatus.TERMINADA)) {
			setStatus(AveriaStatus.ABIERTA);
		}
	}

	/**
	 * Una avería ya facturada se elimina de la factura
	 */
	public void markBackToFinished() {
		if (getStatus().equals(AveriaStatus.FACTURADA)) {
			Association.Facturar.unlink(factura, this);
			setStatus(AveriaStatus.TERMINADA);
		}
	}

	/**
	 * Elimina la relación entre el mecánico y la avería.
	 */
	public void desassign() {
		Association.Asignar.unlink(mecanico, this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result
				+ ((vehiculo == null) ? 0 : vehiculo.hashCode());
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
		Averia other = (Averia) obj;
		if (fecha == null) {
			if (other.fecha != null) {
				return false;
			}
		} else if (!fecha.equals(other.fecha)) {
			return false;
		}
		if (vehiculo == null) {
			if (other.vehiculo != null) {
				return false;
			}
		} else if (!vehiculo.equals(other.vehiculo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Averia [descripcion=" + descripcion + ", fecha=" + fecha
				+ ", importe=" + importe + ", status=" + status + "]";
	}

}
