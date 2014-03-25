package de.rs.firdaous.xml.service;

import java.io.File;
import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PRAcroForm;
import com.lowagie.text.pdf.PdfFormField;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.AcroFields.Item;

import de.rs.auxiliary.PdfReaderUtils;
import de.rs.prototype.firdaous.model.WorkOrder;
import de.rs.test.prototype.mail.Activator;

public class ServiceForDocument implements IDocumentService {

	public static IDocumentService instance;

	private ServiceForDocument() {

	}

	public static IDocumentService getInstance() {
		if (instance == null)
			instance = new ServiceForDocument();
		return instance;
	}

	@Override
	public void setFieldToPDF(WorkOrder order, String file) throws IOException, ParserConfigurationException, SAXException {

		IPath relativePagePath = new Path("./resources/konvertiert_online.pdf");
		File fileIO = relativePagePath.toFile();
		PdfReader pdfReader = new PdfReader(fileIO.getAbsolutePath());
		AcroFields acroFields = pdfReader.getAcroFields();
		@SuppressWarnings("unchecked")
		Map<String, AcroFields.Item> map = (Map<String, AcroFields.Item>) acroFields.getFields();
		ArrayList<String> pdfItemsNames = new ArrayList<String>();
		Map<String, String> fieldValue = new HashMap<String, String>();
		for (int i = 0; i < map.size(); i++) {
			String itemName = (String) map.keySet().toArray()[i];
			pdfItemsNames.add(itemName);
			fieldValue.put(itemName, "");
		}
		try {
			for (Entry<String, String> e : fieldValue.entrySet()) {
				acroFields.setFieldProperty(e.getKey(), "setfflags", PdfFormField.FF_READ_ONLY, null);
			}
			for (Entry<String, String> e : fieldValue.entrySet()) {
				acroFields.setField(e.getKey(), "Willy Brandt");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

}
