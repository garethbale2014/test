package de.rs.prototype.firdaous.model;



public class Clinic {
	
	private int id;
	
	private String name;
	
	private Address address;
	
	
	public Clinic() {
		
	}
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
