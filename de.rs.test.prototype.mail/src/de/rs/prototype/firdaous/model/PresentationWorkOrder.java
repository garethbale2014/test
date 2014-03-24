package de.rs.prototype.firdaous.model;

import java.util.HashMap;
import java.util.Map;

public class PresentationWorkOrder implements IPresentationModel{
	
	private static PresentationWorkOrder order = new PresentationWorkOrder();
	
	private Map<Long, WorkOrder> orders = new HashMap<Long, WorkOrder>();
	
	private PresentationWorkOrder() {
		
	}
	
	public void put(Long timeStamp, WorkOrder order){
		orders.put(timeStamp, order);
	}
	
	
	public Map<Long, WorkOrder> getOrders() {
		return orders;
	}
	
	
	public static PresentationWorkOrder getInstance(){
		return order;
	}
	
	

}
