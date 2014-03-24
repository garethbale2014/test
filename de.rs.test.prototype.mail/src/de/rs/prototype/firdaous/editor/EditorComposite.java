package de.rs.prototype.firdaous.editor;

import org.eclipse.core.databinding.DataBindingContext;

import de.rs.prototype.firdaous.model.PresentationWorkOrder;
import de.rs.prototype.firdaous.model.WorkOrder;

public abstract class EditorComposite {

	protected Long projectId;
	
	protected WorkOrder order = new WorkOrder();

	protected DataBindingContext dbc = new DataBindingContext();

	public EditorComposite(Long projectId) {
		this.projectId = projectId;
		if(this.projectId > 0)
		order = PresentationWorkOrder.getInstance().getOrders().get(projectId);
		PresentationWorkOrder.getInstance().getOrders().put(System.currentTimeMillis(), order);
	}

	public WorkOrder getModel(long id) {
		return PresentationWorkOrder.getInstance().getOrders().get(id);
	}

	abstract protected DataBindingContext initDataBindingContext();
	

	public WorkOrder getOrder() {
		return order;
	}
	public void setOrder(WorkOrder order) {
		this.order = order;
		if (dbc != null) {
			dbc.dispose();
		}
		this.order = order;
	}



}
