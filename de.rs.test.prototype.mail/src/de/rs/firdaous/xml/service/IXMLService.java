package de.rs.firdaous.xml.service;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import de.rs.prototype.firdaous.model.WorkOrder;

public interface IXMLService {
	public void saveProjects(WorkOrder workOrder) throws IOException;
	
	
	public ProjectList loadProjectList() throws IOException, JAXBException;
}
