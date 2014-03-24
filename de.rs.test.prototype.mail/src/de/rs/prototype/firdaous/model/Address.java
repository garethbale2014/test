package de.rs.prototype.firdaous.model;
public class Address {

	private Integer id;
	private String houseNumber, street, zip, city;
	private Country country;
	private String email;
	

	public Address(Address adr) {
		this.id = adr.id;
		this.houseNumber = adr.houseNumber;
		this.street = adr.street;
		this.zip = adr.zip;
		this.city = adr.city;
		this.country = adr.country;
		this.email = adr.email;
	}

	public Address() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"%s, %s, %s,%s",street,houseNumber,zip, //$NON-NLS-1$
				 city);
	}

}