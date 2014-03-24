package de.rs.prototype.firdaous.model;

import java.beans.PropertyChangeEvent;
import java.beans.Transient;

import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public  class WorkOrder extends AbstractModelObject {	

	

	
	public Long projectId;	
	
	public String userName;	
	public String description;	
	public Date workOrderDate;	
	
	@XmlElement
	public Pair pair  = new Pair();	
	@XmlElement
	public Clinic clinic = new Clinic();
	@XmlElement
	public Police police = new Police();
	
	public WorkOrder() {
		this.projectId = System.currentTimeMillis();
		this.userName = System.getenv("USERNAME");
	}
	
	public String getDescription() {
		return description;
	}
	
	public Pair getPair() {
		return pair;
	}
	
	public void setPair(Pair pair) {
		this.pair = pair;
	}
	
	
//	public PersonData getPartner() {
//		return personData.getPartner();
//	}
//
//	public void setPartner(PersonData partner) {
//		personData.setPartner(partner);
//	}
//
//	public String getFirstname() {
//		return personData.getFirstname();
//	}
//
//	public void setFirstname(String firstname) {
//		personData.setFirstname(firstname);
//	}
//
//	public String getLastname() {
//		return personData.getLastname();
//	}
//
//	public void setLastname(String lastname) {
//		personData.setLastname(lastname);
//	}
//
//	public Date getBirthday() {
//		return personData.getBirthday();
//	}
//
//	public void setBirthday(Date birthday) {
//		personData.setBirthday(birthday);
//	}
//
//	public Date getDecedDay() {
//		return personData.getDecedDay();
//	}
//
//	public void setDecedDay(Date decedDay) {
//		personData.setDecedDay(decedDay);
//	}
//
//	public String getProfession() {
//		return personData.getProfession();
//	}
//
//	public void setProfession(String profession) {
//		personData.setProfession(profession);
//	}
//
//	public FamillyState getFamillyState() {
//		return personData.getFamillyState();
//	}
//
//	public void setFamillyState(FamillyState famillyState) {
//		personData.setFamillyState(famillyState);
//	}
//
//	public String getEmail() {
//		return personData.getEmail();
//	}
//
//	public void setEmail(String email) {
//		personData.setEmail(email);
//	}
//
//	public PhoneNumber getPhone() {
//		return personData.getPhone();
//	}
//
//	public void setPhone(PhoneNumber phone) {
//		personData.setPhone(phone);
//	}
//
//	public Genre getSexe() {
//		return personData.getSexe();
//	}
//
//	public void setSexe(Genre sexe) {
//		personData.setSexe(sexe);
//	}

//	public Address getAddress() {
//		return police.getAddress();
//	}
//
//	public void setId(int id) {
//		police.setId(id);
//	}
//	
//
//	public Nationality getNationality() {
//		return personData.getNationality();
//	}
//
//	public void setNationality(Nationality nationality) {
//		personData.setNationality(nationality);
//	}
	
	@XmlTransient
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	@XmlTransient
	public Clinic getClinic() {
		return clinic;
	}
	
	public void setPolice(Police police) {
		this.police = police;
	}
	
	@XmlTransient
	public Police getPolice() {
		return police;
	}
	

	
	public PersonData getPerson() {
		return pair.getPerson();
	}

	public void setPerson(PersonData person) {
		pair.setPerson(person);
	}

	public PersonData getPartner() {
		return pair.getPartner();
	}

	public void setPartner(PersonData partner) {
		pair.setPartner(partner);
	}

	public void setWorkOrderDate(Date workOrderDate) {
		this.workOrderDate = workOrderDate;
	}
	
	@XmlTransient
	public Date getWorkOrderDate() {
		return workOrderDate;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@XmlTransient
	public String getUserName() {
		return userName;
	}




	
	
	

}
