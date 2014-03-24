package de.rs.prototype.firdaous.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

import javax.xml.bind.annotation.XmlType;


public class PersonData implements IPerson{
	
	
	
	
	private String firstname;
	
	private String lastname;
	
	private String email;	
	
	private Date birthday;
	
	private Date decedDay;
	
	private Address addresse = new Address();
	
	private Nationality nationality = new Nationality();
	
	private String birthCity;
	
	private PhoneNumber phone = new PhoneNumber();
	
	private String profession;
	
	private FamillyState famillyState = FamillyState.unbekannt;
	
	private Genre sexe = Genre.masculin ;
	
	private PropertyChangeSupport propertyChangeSupport;
	
	public PersonData() {
		propertyChangeSupport = new PropertyChangeSupport(this);
	}
	public void addPropertyChangeListener(String propertyName,
		      PropertyChangeListener listener) {
		    propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
		  }

		  public void removePropertyChangeListener(PropertyChangeListener listener) {
		    propertyChangeSupport.removePropertyChangeListener(listener);
		  }
	

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getDecedDay() {
		return decedDay;
	}
	public void setDecedDay(Date decedDay) {
		this.decedDay = decedDay;
	}
	public Address getAddresse() {
		return addresse;
	}
	public void setAddresse(Address addresse) {
		this.addresse = addresse;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public FamillyState getFamillyState() {
		return famillyState;
	}
	
	public void setFamillyState(FamillyState famillyState) {
		this.famillyState = famillyState;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public PhoneNumber getPhone() {
		return phone;
	}
	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}
	
	public Genre getSexe() {
		return sexe;
	}
	
	public void setSexe(Genre sexe) {
		this.sexe = sexe;
	}
	
	public Nationality getNationality() {
		return nationality;
	}
	
	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	
	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}
	
	public String getBirthCity() {
		return birthCity;
	}
	
	
	

	
	
	
	

}
