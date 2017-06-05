package uo.ri.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import alb.util.date.DateUtil;
import uo.ri.model.types.status.PedidoStatus;

/**
 * Clase del modelo de dominio que simula un pedido.
 * 
 * @author Iván González Mahagamage
 *
 */
@Entity
@Table(name = "TPEDIDOS")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String codigo;

	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	@Temporal(TemporalType.DATE)
	private Date fechaRecepcion;

	@Enumerated(EnumType.STRING)
	private PedidoStatus estado = PedidoStatus.PEDIDO;

	@ManyToOne
	private Proveedor proveedor;

	@OneToMany(mappedBy = "pedido")
	private Set<DetallePedido> detallesPedidos = new HashSet<>();

	/**
	 * Constructor por defecto.
	 */
	Pedido() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigo
	 *            Código del pedido.
	 */
	public Pedido(String codigo) {
		this.codigo = codigo;
		fechaCreacion = DateUtil.today();
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param codigo
	 *            Código del pedido.
	 * @param fechaCreacion
	 *            Fecha de creación del pedido.
	 */
	public Pedido(String codigo, Date fechaCreacion) {
		this(codigo);
		this.fechaCreacion = fechaCreacion;
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
	 * Método que devuelve el parámetro fechaCreacion.
	 * 
	 * @return El parámetro fechaCreacion.
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Método que modifica el parámetro fechaCreacion.
	 * 
	 * @param fechaCreacion
	 *            Fecha de creación del pedido.
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Método que devuelve el parámetro fechaRecepcion.
	 * 
	 * @return El parámetro fechaRecepcion.
	 */
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	/**
	 * Método que modifica el parámetro fechaRecepcion.
	 * 
	 * @param fechaRecepcion
	 *            La fecha de recepción del pedido.
	 */
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	/**
	 * Método que devuelve el parámetro estado.
	 * 
	 * @return El parámetro estado.
	 */
	public PedidoStatus getEstado() {
		return estado;
	}

	/**
	 * Método que modifica el parámetro estado.
	 * 
	 * @param estado
	 *            Estado del pedido.
	 */
	public void setEstado(PedidoStatus estado) {
		this.estado = estado;
	}

	/**
	 * Método que devuelve el parámetro código.
	 * 
	 * @return El parámetro código.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método que devuelve el parámetro proveedor.
	 * 
	 * @return El parámetro proveedor.
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * Método que modifica el parámetro proveedor.
	 * 
	 * @param proveedor
	 *            Proveedor del pedido.
	 */
	void _setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * Método que devuelve una copia del parámetro detallesPedidos.
	 * 
	 * @return Una copia del parámetro detallesPedidos.
	 */
	public Set<DetallePedido> getDetallesPedidos() {
		return new HashSet<>(detallesPedidos);
	}

	/**
	 * Método que devuelve el parámetro detallesPedidos.
	 * 
	 * @return El parámetro detallesPedidos.
	 */
	Set<DetallePedido> _getDetallesPedidos() {
		return detallesPedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Pedido other = (Pedido) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", fechaCreacion=" + fechaCreacion
				+ ", fechaRecepcion=" + fechaRecepcion + ", estado=" + estado
				+ "]";
	}

}
