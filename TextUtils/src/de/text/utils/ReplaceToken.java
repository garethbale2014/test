package de.text.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class ReplaceToken {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (FileReader reader = new FileReader("text.properties")) {
			Properties properties = new Properties();
			properties.load(reader);
			
			
		    
		    Enumeration e = properties.propertyNames();
		    int i = 0;

		    for (; e.hasMoreElements();) {
		    	StringBuilder element = new StringBuilder(String.valueOf(e.nextElement()).replace(".", "_"));
		    	String key = element.toString().toUpperCase();
		    	String value = new StringBuilder("("+"\""+String.valueOf(e.nextElement())).append("\"").append(")").toString();
		    	if("FORMULAR1[0]_SEITE1[0]_#AREA[6]_NAME4[0]".equals(key))
		    		 System.out.println(key+value);
		      System.out.println(key+value);
		      i++;
		      System.out.println("Counter line : "+i);

		    }
		    System.out.println("Counter line : "+i);
//			while (e.hasMoreElements()) {
//			      String key = (String) e..nextElement();
//			      System.out.println(key );
//			      //System.out.println(key + " -- " + properties.getProperty(key));
//		}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
