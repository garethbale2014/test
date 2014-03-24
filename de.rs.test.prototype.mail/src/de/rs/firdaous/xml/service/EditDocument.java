package de.rs.firdaous.xml.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PRAcroForm;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.AcroFields.Item;

import de.rs.auxiliary.PdfReaderUtils;
import de.rs.prototype.firdaous.model.WorkOrder;

public class EditDocument implements IEditDocument {

	@Override
	public void setFieldToPDF(WorkOrder order, String file)throws IOException, ParserConfigurationException, SAXException {
		
			final InputStream inputStream = PdfReaderUtils.class.getResourceAsStream(file);
			
			
		    PdfReader pdfReader = new PdfReader(file);
		    PRAcroForm pRAcroForm = pdfReader.getAcroForm();
		    AcroFields acroFields = pdfReader.getAcroFields();
		    Map<String,AcroFields.Item> fields = (HashMap<String, Item>) acroFields.getFields();
		    
		    Map<String,AcroFields.Item> map = acroFields.getFields(); 
	       ArrayList<String> pdfItemsNames = new ArrayList<String>(); 
	       Map<String, String> fieldValue = new HashMap<String, String>();
	        for (int i = 0; i <map.size (); i++) { 
	                         String itemName = (String) map.keySet().toArray()[i]; 
	                         pdfItemsNames.add (itemName); 
	                         fieldValue.put(itemName, "");
	                   } 
	        ArrayList<String> pdfItemsValues = new ArrayList<String>();
	        
	        for (int j = 0 ;j < pdfItemsNames.size (); j++) {	
	            pdfItemsValues.add(acroFields.getField(pdfItemsNames.get(j))); 
	            fieldValue.put(pdfItemsNames.get(j), acroFields.getField(pdfItemsNames.get(j)));
	        }
	        for(Entry<String, String> e : fieldValue.entrySet()){
	        	System.out.println("key : "+e.getKey()+"\tvalue : "+ e.getValue());
	        }
		    

	}

}
