package de.rs.firdaous.xml.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import de.rs.prototype.firdaous.model.WorkOrder;


@XmlRootElement(name = "ProjectList")
public class ProjectList {
	
	private List<WorkOrder> projectList = new ArrayList<WorkOrder>();
	

	public ProjectList() {
		
	}
	@XmlElementWrapper(name = "list")
	@XmlElement(name = "entries")
	public List<WorkOrder> getProjectList() {
		return projectList;
	}
	
	public void setProjectList(List<WorkOrder> projectList) {
		this.projectList = projectList;
	}
	
	public void addProject(WorkOrder workOrder){
		this.projectList.add(workOrder);
	}
	
	@Override
	public String toString() {
		StringBuilder projectListStr = new StringBuilder();
		for(WorkOrder order : projectList){
			projectListStr.append("Neuer Person ====================================\n");
			projectListStr.append("PersonData :");
			projectListStr.append("Firstname:"+order.getPerson().getFirstname()+"\n");
			projectListStr.append("Lastname:"+order.getPerson().getLastname()+"\n");
			projectListStr.append("BirthCity:"+order.getPerson().getBirthCity()+"\n");
			projectListStr.append("DecedDay:"+order.getPerson().getDecedDay()+"\n");
			projectListStr.append("Street:"+order.getPerson().getAddresse().getStreet()+"\n");
			projectListStr.append("HouseNumber:"+order.getPerson().getAddresse().getHouseNumber()+"\n");
			projectListStr.append("Partner Data :"+"\n");
			projectListStr.append("Firstname:"+order.getPartner().getFirstname()+"\n");
			projectListStr.append("Lastname:"+order.getPartner().getLastname()+"\n");
			projectListStr.append("BirthCity:"+order.getPartner().getBirthCity()+"\n");
			projectListStr.append("DecedDay:"+order.getPartner().getDecedDay()+"\n");
			projectListStr.append("Street:"+order.getPartner().getAddresse().getStreet()+"\n");
			projectListStr.append("HouseNumber:"+order.getPartner().getAddresse().getHouseNumber()+"\n");
		}
		return projectListStr.toString();
	}

}
