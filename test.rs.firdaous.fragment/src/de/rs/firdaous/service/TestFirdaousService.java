package de.rs.firdaous.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import junit.framework.Assert;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;

import de.rs.firdaous.xml.service.IDocumentService;
import de.rs.firdaous.xml.service.IXMLService;
import de.rs.firdaous.xml.service.ProjectList;
import de.rs.firdaous.xml.service.ServiceForDocument;
import de.rs.firdaous.xml.service.XMLService;
import de.rs.prototype.firdaous.model.WorkOrder;
import de.rs.test.prototype.mail.Activator;

public class TestFirdaousService {
	
	private WorkOrder order;


	@Before
	public void setUp(){
		
		IXMLService xmlIxmlService = XMLService.getxmlService();
		try {
			ProjectList projectList = xmlIxmlService.loadProjectList();
			if(projectList.getProjectList().size() > 0){
				order = projectList.getProjectList().get(0);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void setField_ShowFieldValue(){
		IDocumentService instance = ServiceForDocument.getInstance();
		try {
			instance.setFieldToPDF(order, null);
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
	
	
	
	
	

}
