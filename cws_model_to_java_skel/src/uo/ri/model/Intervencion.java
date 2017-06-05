package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

import alb.util.math.Round;

public class Intervencion {

	private Averia averia;
	private Mecanico mecanico;
	private int minutos;

	private Set<Sustitucion> sustituciones = new HashSet<>();

	public Intervencion(Mecanico mecanico, Averia averia) {
		Association.Intervenir.link(averia, this, mecanico);
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public Averia getAveria() {
		return averia;
	}

	void _setAveria(Averia averia) {
		this.averia = averia;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	void _setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averia == null) ? 0 : averia.hashCode());
		result = prime * result + ((mecanico == null) ? 0 : mecanico.hashCode());
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
		Intervencion other = (Intervencion) obj;
		if (averia == null) {
			if (other.averia != null)
				return false;
		} else if (!averia.equals(other.averia))
			return false;
		if (mecanico == null) {
			if (other.mecanico != null)
				return false;
		} else if (!mecanico.equals(other.mecanico))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Intervencion [averia=" + averia + ", mecanico=" + mecanico + ", minutos=" + minutos + "]";
	}

	public Set<Sustitucion> getSustituciones() {
		return new HashSet<>(sustituciones);
	}

	Set<Sustitucion> _getSustituciones() {
		return sustituciones;
	}

	public double getImporte() {
		double precioHora = averia.getVehiculo().getTipoVehiculo().getPrecioHora();
		precioHora *= (double) getMinutos() / 60;
		double precioSustituciones = 0;
		for (Sustitucion sustitucion : getSustituciones())
			precioSustituciones += sustitucion.getImporte();
		return Round.twoCents(precioHora + precioSustituciones);
	}
}
