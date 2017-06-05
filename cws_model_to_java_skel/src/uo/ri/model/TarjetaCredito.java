package uo.ri.model;

import java.util.Date;

public class TarjetaCredito extends MedioPago {

	protected String numero;
	protected String tipo;
	protected Date validez;

	public TarjetaCredito(String numero) {
		this.numero = numero;
	}

	public TarjetaCredito(String numero, String tipo) {
		this(numero);
		this.tipo = tipo;
	}

	public TarjetaCredito(String numero, String tipo, Date validez) {
		this(numero, tipo);
		this.validez = validez;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getValidez() {
		return validez;
	}

	public void setValidez(Date validez) {
		this.validez = validez;
	}

	public String getNumero() {
		return numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarjetaCredito other = (TarjetaCredito) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TarjetaCredito [numero=" + numero + ", tipo=" + tipo + ", validez=" + validez + "]";
	}
}
