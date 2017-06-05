package uo.ri.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import alb.util.date.DateUtil;
import uo.ri.model.types.status.PedidoStatus;

@Entity
@Table(name = "TPEDIDOS")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String codigo;

	@Temporal(TemporalType.DATE)
	private Date fecha_creacion;

	@Temporal(TemporalType.DATE)
	private Date fecha_recepcion;

	@Enumerated(EnumType.STRING)
	private PedidoStatus estado = PedidoStatus.PEDIDO;

	@ManyToOne
	private Proveedor proveedor;

	@OneToMany(mappedBy = "pedido")
	private Set<DetallePedido> detallesPedidos = new HashSet<>();

	Pedido() {
	}

	public Pedido(String codigo) {
		this.codigo = codigo;
		fecha_creacion = DateUtil.today();
	}

	public Pedido(String codigo, Date fecha_creacion) {
		this(codigo);
		this.fecha_creacion = fecha_creacion;
	}

	public Long getId() {
		return id;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_recepcion() {
		return fecha_recepcion;
	}

	public void setFecha_recepcion(Date fecha_recepcion) {
		this.fecha_recepcion = fecha_recepcion;
	}

	public PedidoStatus getEstado() {
		return estado;
	}

	public void setEstado(PedidoStatus estado) {
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	void _setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", fecha_creacion=" + fecha_creacion
				+ ", fecha_recepcion=" + fecha_recepcion + ", estado=" + estado
				+ "]";
	}

	public Set<DetallePedido> getDetallesPedidos() {
		return new HashSet<>(detallesPedidos);
	}

	Set<DetallePedido> _getDetallesPedidos() {
		return detallesPedidos;
	}

}
