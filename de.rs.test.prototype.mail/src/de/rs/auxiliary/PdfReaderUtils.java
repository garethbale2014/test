package de.rs.auxiliary;

import java.awt.List;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import com.lowagie.text.Document;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.AcroFields.Item;
import com.lowagie.text.pdf.PRAcroForm;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.XfaForm;



public class PdfReaderUtils {

	public static void getMetaData(String file) throws IOException, ParserConfigurationException, SAXException {
		
		Document document = new Document();
		
	InputStream tInputStream = PdfReaderUtils.class.getResourceAsStream(file);
		PdfReader tPdfReader = new PdfReader( tInputStream );
	      String tContent = new String( tPdfReader.getPageContent( 1 ) );
	      System.out.println( tContent );
	      
	      
	      
		
		
		
		final InputStream inputStream = PdfReaderUtils.class.getResourceAsStream(file);
		
		PdfReader reader = new PdfReader(inputStream);
		
		
		Map<String, String> info = reader.getInfo();
		String key;
		String value;
		for (Iterator<String> i = info.keySet().iterator(); i.hasNext();) {
			key = (String) i.next();
			value = (String) info.get(key);
			System.out.println(key + ": " + value);
		}
		scanFields(file);
		//parsePdf(file, null);
	}
	
	public static void scanFields(String path) throws IOException, ParserConfigurationException, SAXException {
		final InputStream inputStream = PdfReaderUtils.class.getResourceAsStream(path);
		
		
	    PdfReader pdfReader = new PdfReader(path);
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
	    
        
//        
//        XfaForm xfa = new XfaForm(pdfReader);
//        org.w3c.dom.Document document = (org.w3c.dom.Document) xfa.getDomDocument();
//        Node node = xfa.getDatasetsNode();
//        NodeList list = node.getChildNodes();
//        for (int i = 0; i < list.getLength(); i++) {
//            if("movies".equals(list.item(i).getLocalName())) {
//                node = list.item(i);
//                break;
//            }
//            else 
//            	System.out.println("Nodename  :"+list.item(i).getLocalName()+"Nodevalue :"+list.item(i).getNodeValue());
//            
//        }
	
	    
	    
	  
	        
	    
	    
	    
	    
	    
	    
	    

	   

	    

	
	}
	

	
	
	
	
    
	

}
