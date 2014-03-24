//package de.rs.prototype.firdaous.model;
//
//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;
//import java.lang.reflect.Field;
//import java.util.Date;
//
//public class DecedeViewModel extends WorkOrder implements PropertyChangeListener{
//	
//	static DecedeViewModel form = new DecedeViewModel();
//	
//	
//	private String dummyFeld;
//	
//	private  DecedeViewModel() {
//		this.personData = new PersonData();
//		this.clinic = new Clinic();
//		this.police = new Police();
//		
//			
//	} 
//	
//	public static DecedeViewModel getInstance(){
//		return form;
//	}
//	
//	
//	@Override
//	public String getDescription() {
//		// TODO Auto-generated method stub
//		return super.getDescription();
//	}
//	
//	public String getDummyFeld() {
//		return dummyFeld;
//	}
//	
//	public void setDummyFeld(String dummyFeld) {
//		this.dummyFeld = dummyFeld;
//	}
//	
//	
//	
//	@Override
//	public String getEmail() {
//		// TODO Auto-generated method stub
//		return super.getEmail();
//	}
//	
//	@Override
//	public String getFirstname() {
//		// TODO Auto-generated method stub
//		return super.getFirstname();
//	}
//	
//	@Override
//	public IPerson getPartner() {
//		// TODO Auto-generated method stub
//		return super.getPartner();
//	}
//
//	@Override
//	public void setPartner(IPerson partner) {
//		// TODO Auto-generated method stub
//		super.setPartner(partner);
//	}
//
//	@Override
//	public void setFirstname(String firstname) {
//		// TODO Auto-generated method stub
//		super.setFirstname(firstname);
//	}
//
//	@Override
//	public String getLastname() {
//		// TODO Auto-generated method stub
//		return super.getLastname();
//	}
//
//	@Override
//	public void setLastname(String lastname) {
//		// TODO Auto-generated method stub
//		super.setLastname(lastname);
//	}
//
//	@Override
//	public Date getBirthday() {
//		// TODO Auto-generated method stub
//		return super.getBirthday();
//	}
//
//	@Override
//	public void setBirthday(Date birthday) {
//		// TODO Auto-generated method stub
//		super.setBirthday(birthday);
//	}
//
//	@Override
//	public Date getDecedDay() {
//		// TODO Auto-generated method stub
//		return super.getDecedDay();
//	}
//
//	@Override
//	public void setDecedDay(Date decedDay) {
//		// TODO Auto-generated method stub
//		super.setDecedDay(decedDay);
//	}
//
//	@Override
//	public String getProfession() {
//		// TODO Auto-generated method stub
//		return super.getProfession();
//	}
//
//	@Override
//	public void setProfession(String profession) {
//		// TODO Auto-generated method stub
//		super.setProfession(profession);
//	}
//
//	@Override
//	public FamillyState getFamillyState() {
//		// TODO Auto-generated method stub
//		return super.getFamillyState();
//	}
//
//	@Override
//	public void setFamillyState(FamillyState famillyState) {
//		// TODO Auto-generated method stub
//		super.setFamillyState(famillyState);
//	}
//
//	@Override
//	public void setEmail(String email) {
//		// TODO Auto-generated method stub
//		super.setEmail(email);
//	}
//
//	@Override
//	public PhoneNumber getPhone() {
//		// TODO Auto-generated method stub
//		return super.getPhone();
//	}
//
//	@Override
//	public void setPhone(PhoneNumber phone) {
//		// TODO Auto-generated method stub
//		super.setPhone(phone);
//	}
//
//	@Override
//	public Sexe getSexe() {
//		// TODO Auto-generated method stub
//		return super.getSexe();
//	}
//
//	@Override
//	public void setSexe(Sexe sexe) {
//		// TODO Auto-generated method stub
//		super.setSexe(sexe);
//	}
//
//	@Override
//	public Address getAddress() {
//		// TODO Auto-generated method stub
//		return super.getAddress();
//	}
//
//	@Override
//	public void setId(int id) {
//		// TODO Auto-generated method stub
//		super.setId(id);
//	}
//	@Override
//	public int getFormId() {
//		// TODO Auto-generated method stub
//		return super.getFormId();
//	}
//	
//	@Override
//	public void setNationality(Nationality nationality) {
//		// TODO Auto-generated method stub
//		super.setNationality(nationality);
//	}
//	
//	@Override
//	public Nationality getNationality() {
//		// TODO Auto-generated method stub
//		return super.getNationality();
//	}
//
//	@Override
//	public void propertyChange(PropertyChangeEvent evt) {
//		DecedeViewModel model = (DecedeViewModel)evt.getSource();
//		evt.getPropertyName();
//		
//		Class<?> clazz = DecedeViewModel.class;
//	    Field field;
//		try {
//			field = clazz.getField("fieldName");
//			 try {
//				Object fieldValue = field.get(clazz);
//				System.out.println(fieldValue);
//			} catch (IllegalArgumentException | IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (NoSuchFieldException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} //Note, this can throw an exception if the field doesn't exist.
//	   
//		
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//}
