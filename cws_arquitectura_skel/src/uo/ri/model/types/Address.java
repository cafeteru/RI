package uo.ri.model.types;

import javax.persistence.Embeddable;

/**
 * Clase del modelo de dominio que simula una dirección.
 * 
 * @author Iván González Mahagamage
 *
 */
@Embeddable
public class Address {
	private String street;
	private String city;
	private String zipCode;

	/**
	 * Constructor por defecto.
	 *
	 */
	Address() {
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param street
	 *            Calle de la dirección.
	 * @param city
	 *            Ciudad de la dirección.
	 * @param zipCode
	 *            Código postal de la dirección.
	 */
	public Address(String street, String city, String zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	/**
	 * Devuelve el parámetro street.
	 * 
	 * @return El parámetro street.
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Devuelve el parámetro city.
	 * 
	 * @return El parámetro city.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Devuelve el parámetro zipCode.
	 * 
	 * @return El parámetro zipCode.
	 */
	public String getZipCode() {
		return zipCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", zipCode="
				+ zipCode + "]";
	}

}
