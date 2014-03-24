package de.rs.prototype.firdaous.model;



public class Police {
	
	private int id ;
	
	private String name;
	
	private Address address;
	
	public Police() {
		
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	

}
