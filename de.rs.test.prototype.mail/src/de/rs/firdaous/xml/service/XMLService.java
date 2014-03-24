package de.rs.firdaous.xml.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;

import de.rs.prototype.firdaous.model.WorkOrder;
import de.rs.test.prototype.mail.Activator;

public class XMLService implements IXMLService {

	private static final String SAVED_PROJECTS_DIR = "./resources/projectListNew.xml";

	private ProjectList projectList = new ProjectList();
	
	private static XMLService xmlService;
	
	private static File fileLoadDir;
	
	private XMLService() {
		
		
	}
	
	public static XMLService getxmlService(){
		if(xmlService == null)
		xmlService = new XMLService();
		return xmlService;
	}

	@Override
	public void saveProjects(WorkOrder workOrder) throws IOException {

		try {
			File file = new File(SAVED_PROJECTS_DIR);
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
				projectList = new ProjectList();
			} else {
				if (projectList == null) {
					File fileTmp = new File(SAVED_PROJECTS_DIR);
					JAXBContext jc = JAXBContext.newInstance(ProjectList.class);
	                Unmarshaller unmarshaller = jc.createUnmarshaller();
	                projectList = (ProjectList) unmarshaller.unmarshal(fileTmp);
				}
			}
			JAXBContext jc = JAXBContext.newInstance(ProjectList.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			WorkOrder oo = null;
			for(WorkOrder o : projectList.getProjectList()){
				if(o.getProjectId().equals(workOrder.getProjectId())){
					oo = o;
					break;
				}
			}
			if(oo != null)
			projectList.getProjectList().remove(oo);
			projectList.getProjectList().add(workOrder);
			
			projectList.addProject(workOrder);
			marshaller.marshal(projectList, file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public ProjectList loadProjectList() throws IOException, JAXBException {
		
//		Bundle plugin = Activator.getDefault().getBundle();
//		IPath relativePagePath = new Path(SAVED_PROJECTS_DIR);
//		
//		URL fileInPlugin = FileLocator.find(plugin, relativePagePath, null);
//		fileLoadDir = new File(fileInPlugin.getFile());
		
		JAXBContext jc = JAXBContext.newInstance(ProjectList.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File fileTmp = new File(SAVED_PROJECTS_DIR);
        if(fileTmp.exists()){
        projectList = (ProjectList) unmarshaller.unmarshal(fileTmp);
        return projectList;
        }
		return projectList;
		
	}

}
