package uo.ri.model.types.keys;

import java.io.Serializable;

/**
 * Clase que simula la clave primaria de clase Detalles.
 * 
 * @author Iván González Mahagamage
 *
 */
public class DetallesKey implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long pedido;
	private Long repuesto;

	/**
	 * Constructor por defecto
	 */
	DetallesKey() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result
				+ ((repuesto == null) ? 0 : repuesto.hashCode());
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
		DetallesKey other = (DetallesKey) obj;
		if (pedido == null) {
			if (other.pedido != null) {
				return false;
			}
		} else if (!pedido.equals(other.pedido)) {
			return false;
		}
		if (repuesto == null) {
			if (other.repuesto != null) {
				return false;
			}
		} else if (!repuesto.equals(other.repuesto)) {
			return false;
		}
		return true;
	}

}
