package uo.ri.model.types.keys;

import java.io.Serializable;

/**
 * Clase que simula la clave primaria de clase Suministro.
 * 
 * @author Iván González Mahagamage
 *
 */
public class SuministroKey implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long proveedor;
	private Long repuesto;

	/**
	 * Constructor por defecto
	 *
	 */
	SuministroKey() {
	}

	public SuministroKey(Long proveedor, Long repuesto) {
		this.proveedor = proveedor;
		this.repuesto = repuesto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((proveedor == null) ? 0 : proveedor.hashCode());
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
		SuministroKey other = (SuministroKey) obj;
		if (proveedor == null) {
			if (other.proveedor != null) {
				return false;
			}
		} else if (!proveedor.equals(other.proveedor)) {
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
