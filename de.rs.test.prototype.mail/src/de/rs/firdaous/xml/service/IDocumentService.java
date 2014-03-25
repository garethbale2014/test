package de.rs.firdaous.xml.service;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;

import de.rs.prototype.firdaous.model.WorkOrder;

public interface IDocumentService {
	
	public void setFieldToPDF(WorkOrder order, String file) throws IOException, ParserConfigurationException, SAXException ;

}
