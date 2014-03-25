package de.rs.firdaous.xml.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;
import org.xml.sax.SAXException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PRAcroForm;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfFormField;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.AcroFields.Item;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

import de.rs.auxiliary.FormatUtil;
import de.rs.auxiliary.PdfReaderUtils;
import de.rs.prototype.firdaous.model.FieldInfoList;
import de.rs.prototype.firdaous.model.IField;
import de.rs.prototype.firdaous.model.IPDFFieldInfo;
import de.rs.prototype.firdaous.model.WorkOrder;
import de.rs.test.prototype.mail.Activator;

public class ServiceForDocument implements IDocumentService {

	public static IDocumentService instance;

	public static final String RESULT = "./resources/AnlageZumSterbefall%s.pdf";

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private ServiceForDocument() {

	}

	public static IDocumentService getInstance() {
		if (instance == null)
			instance = new ServiceForDocument();
		return instance;
	}

	@Override
	public void setFieldToPDF(WorkOrder order, String file) throws IOException, ParserConfigurationException, SAXException, DocumentException {

		// IPath relativePagePath = new
		// Path("./resources/AnlageZumSterbefall.pdf");
		// File fileIO = relativePagePath.toFile();

		PdfReader reader = new PdfReader("./resources/AnlagezumSterbefall.pdf");
		// copyPDF(fileIO.getAbsolutePath());
		String s = FormatUtil.toDateString(Calendar.getInstance().getTime(), format);
		String newFile = String.format(RESULT, s);
		newFile = newFile.replace("-", "_");
		newFile = newFile.replace(" ", "_");
		newFile = newFile.replace(":", "_");

		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(newFile));

		AcroFields acroFields = stamper.getAcroFields();

		@SuppressWarnings("unchecked")
		Map<String, AcroFields.Item> map = (Map<String, AcroFields.Item>) stamper.getAcroFields().getFields();
		ArrayList<String> pdfItemsNames = new ArrayList<String>();
		Map<String, String> fieldValue = new HashMap<String, String>();
		for (int i = 0; i < map.size(); i++) {
			String itemName = (String) map.keySet().toArray()[i];
			pdfItemsNames.add(itemName);
			fieldValue.put(itemName, "");
		}
		try {
			for (Entry<String, String> e : fieldValue.entrySet()) {

				System.out.println(e.getKey());
				acroFields.setFieldProperty(e.getKey(), "setfflags", PdfFormField.FF_READ_ONLY, null);
			}
			for (Entry<String, String> e : fieldValue.entrySet()) {
				acroFields.setField(e.getKey(), "Willy Brandt");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		stamper.close();
		reader.close();

	}

	@Override
	public void copyPDF(String file) throws IOException, DocumentException {
		IPath relativePagePath = new Path("./resources/AnlageZumSterbefall.pdf");
		File fileIO = relativePagePath.toFile();
		PdfReader reader = new PdfReader(fileIO.getAbsolutePath());
		reader = unlockPdf(reader);
		Document document;
		PdfCopy copy;
		// loop over all the pages in the original PDF
		int n = reader.getNumberOfPages();
		for (int i = 0; i < n;) {
			// step 1
			document = new Document();
			// step 2
			copy = new PdfCopy(document, new FileOutputStream(String.format(RESULT, ++i)));
			// step 3
			document.open();
			// step 4
			copy.addPage(copy.getImportedPage(reader, i));
			// step 5
			document.close();
		}

		reader.close();

	}

	public static PdfReader unlockPdf(PdfReader reader) {
		if (reader == null) {
			return reader;
		}
		try {
			Field f = reader.getClass().getDeclaredField("encrypted");
			f.setAccessible(true);
			f.set(reader, false);
		} catch (Exception e) { // ignore
		}
		return reader;
	}

	@Override
	public void encryptPdf(String src, String dest) throws IOException, DocumentException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFieldToPDF(List<IPDFFieldInfo> fieldInfoList) throws IOException, ParserConfigurationException, SAXException, DocumentException {
		PdfReader reader = new PdfReader("./resources/AnlagezumSterbefall.pdf");
		String s = FormatUtil.toDateString(Calendar.getInstance().getTime(), format);
		String newFile = String.format(RESULT, s);
		newFile = newFile.replace("-", "_");
		newFile = newFile.replace(" ", "_");
		newFile = newFile.replace(":", "_");
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(newFile));
		AcroFields acroFields = stamper.getAcroFields();
		@SuppressWarnings("unchecked")
		Map<String, AcroFields.Item> map = (Map<String, AcroFields.Item>) stamper.getAcroFields().getFields();
		ArrayList<String> pdfItemsNames = new ArrayList<String>();
		Map<String, String> fieldValue = new HashMap<String, String>();
		for (int i = 0; i < map.size(); i++) {
			String itemName = (String) map.keySet().toArray()[i];
			pdfItemsNames.add(itemName);
			fieldValue.put(itemName, "");
		}
		
		try {
			FieldInfoList fieldInfoListPDF = new FieldInfoList(fieldInfoList);
			for (Entry<String, String> e : fieldValue.entrySet()) {
				IField field = fieldInfoListPDF.getIField(e.getKey());
				if (field != null) {
					acroFields.setFieldProperty(e.getKey(), "setfflags", PdfFormField.FF_READ_ONLY, null);
					acroFields.setField(e.getKey(), String.valueOf(field.getFieldValue()));
				}
			}

		} catch (DocumentException e) {
			e.printStackTrace();
		}

		stamper.close();
		reader.close();

	}

}
