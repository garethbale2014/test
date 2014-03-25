package de.rs.xml.test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Calendar;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;

import de.rs.firdaous.xml.service.IDocumentService;
import de.rs.firdaous.xml.service.IXMLService;
import de.rs.firdaous.xml.service.ProjectList;
import de.rs.firdaous.xml.service.ServiceForDocument;
import de.rs.firdaous.xml.service.XMLService;
import de.rs.prototype.firdaous.model.Address;
import de.rs.prototype.firdaous.model.Clinic;
import de.rs.prototype.firdaous.model.Country;
import de.rs.prototype.firdaous.model.FamillyState;
import de.rs.prototype.firdaous.model.PersonData;
import de.rs.prototype.firdaous.model.PhoneNumber;
import de.rs.prototype.firdaous.model.Police;
import de.rs.prototype.firdaous.model.WorkOrder;


public class TestXMLService {
	
	private IXMLService xmlService = XMLService.getxmlService();
	static WorkOrder workOrder;
	
	@Before
	public void setUp(){
		
		createTestData();
		
		
	}
	
	@Ignore
	@Test
	public void encryptPDF(){
		IDocumentService instance = ServiceForDocument.getInstance();
		try {
			instance.encryptPdf(null, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Ignore
	@Test
	public void copyPDF(){
		IDocumentService instance = ServiceForDocument.getInstance();
		try {
			instance.copyPDF(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	@Test
	public void setField_ShowFieldValue(){
		IDocumentService instance = ServiceForDocument.getInstance();
		try {
			instance.setFieldToPDF(workOrder, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	@Ignore
	@Test
	public void testSaveProjectList() throws IOException{	
		xmlService.saveProjects(workOrder);
		xmlService.saveProjects(workOrder);
		xmlService.saveProjects(workOrder);
		xmlService.saveProjects(workOrder);
	}
	
	@Ignore
	@Test
	public void setLoadProjectList() throws IOException {
		try {
			ProjectList list = xmlService.loadProjectList();
			System.out.println();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private static void createTestData(){
		
		Calendar calendarBirthDay = Calendar.getInstance();
		calendarBirthDay.set(Calendar.YEAR, 1945);
		calendarBirthDay.set(Calendar.MONTH, 5);
		calendarBirthDay.set(Calendar.DAY_OF_MONTH, 14);		
		Calendar calendarDieDay = Calendar.getInstance();
		calendarDieDay.set(Calendar.YEAR, 1990);
		calendarDieDay.set(Calendar.MONTH, 3);
		calendarDieDay.set(Calendar.DAY_OF_MONTH, 24);
		
		workOrder = new WorkOrder();
		Calendar entryDate = Calendar.getInstance();
		entryDate.getTime().setTime(System.currentTimeMillis());
		workOrder.setWorkOrderDate(entryDate.getTime());
		PersonData personData = workOrder.getPerson();
		personData.setFirstname("Albert");
		personData.setLastname("Einstein");
		personData.setBirthCity("Koblenz");
		personData.setBirthday(calendarBirthDay.getTime());
		personData.setDecedDay(calendarDieDay.getTime());
		PersonData personDataPartner = new PersonData();
		personDataPartner.setLastname("Aniett");
		personDataPartner.setFirstname("Lorf");
		
		
		workOrder.setPartner(personDataPartner);
		Address addresse = new Address();
		addresse.setCity("Virginia");
		Country country = new Country();
		country.setName("USA");
		addresse.setCountry(country);
		addresse.setStreet("marguerittestr");
		addresse.setHouseNumber("112a");
		addresse.setZip("551487");		
		personData.setProfession("Physiker");
		personData.setAddresse(addresse);
		personDataPartner.setAddresse(addresse);
		PhoneNumber phone = new PhoneNumber(0034, 34, 66544);
		personData.setPhone(phone);
		personDataPartner.setPhone(phone);
		FamillyState famillyState = FamillyState.verheiratet;
		personData.setFamillyState(famillyState);
		personDataPartner.setFamillyState(famillyState);
		Clinic clinic = new Clinic();
		clinic.setName("Hospital Bale");
		addresse.setStreet("Havinggulstr");
		clinic.setAddress(addresse);
		Police police = new Police();
		addresse.setStreet("heighway");
		police.setName("Police newyork city");
		police.setAddress(addresse);
		workOrder.setPerson(personData);
		workOrder.setPolice(police);
		workOrder.setClinic(clinic);
		long id = System.currentTimeMillis();
		workOrder.setProjectId(id);
		workOrder.setUserName(System.getenv("USERNAME"));
	}
}
