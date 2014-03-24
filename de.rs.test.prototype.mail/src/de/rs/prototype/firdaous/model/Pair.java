package de.rs.prototype.firdaous.model;

public class Pair {
	
	private PersonData person = new PersonData();
	
	private PersonData partner = new PersonData();
	
	public Pair() {
		// TODO Auto-generated constructor stub
	}

	public PersonData getPerson() {
		return person;
	}

	public void setPerson(PersonData person) {
		this.person = person;
	}

	public PersonData getPartner() {
		return partner;
	}

	public void setPartner(PersonData partner) {
		this.partner = partner;
	}
	
	

}
