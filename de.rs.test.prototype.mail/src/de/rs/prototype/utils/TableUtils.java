package de.rs.prototype.utils;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;

import de.rs.prototype.firdaous.model.PersonData;
import de.rs.prototype.firdaous.model.PresentationWorkOrder;
import de.rs.prototype.firdaous.model.WorkOrder;
import de.rs.test.prototype.mail.RowsView;

public class TableUtils {

	public static PersonData getSelectedPerson(IWorkbenchWindow window) {
		IWorkbenchPage page = window.getActivePage();
		RowsView view = (RowsView) page.findView(RowsView.ID);
		ISelection selection = view.getSite().getSelectionProvider().getSelection();
		if (selection != null && selection instanceof IStructuredSelection) {
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			PresentationWorkOrder presentationModel = PresentationWorkOrder.getInstance();
			WorkOrder order = (WorkOrder) obj;
			order = (WorkOrder) (order != null ? (WorkOrder) order : new WorkOrder());
			presentationModel.getOrders().put(order.projectId, order);
			presentationModel.getOrders();
			return order.getPerson();
		}
		return new PersonData();
	}
	
	public static WorkOrder getSelectedWorkOrder(IWorkbenchWindow window) {
		IWorkbenchPage page = window.getActivePage();
		RowsView view = (RowsView) page.findView(RowsView.ID);
		ISelection selection = view.getSite().getSelectionProvider().getSelection();
		if (selection != null && selection instanceof IStructuredSelection) {
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			PresentationWorkOrder presentationModel = PresentationWorkOrder.getInstance();
			WorkOrder order = (WorkOrder) obj;
			order = (WorkOrder) (order != null ? (WorkOrder) order : new WorkOrder());
			presentationModel.getOrders().put(order.projectId, order);
			presentationModel.getOrders();
			return order;
		}
		return new WorkOrder();
	}
	
	public static long getCurrentProjectId(IWorkbenchWindow window) {
		IWorkbenchPage page = window.getActivePage();
		RowsView view = (RowsView) page.findView(RowsView.ID);
		if(view == null)
			return -1;
		ISelection selection = view.getSite().getSelectionProvider().getSelection();
		if (selection != null && selection instanceof IStructuredSelection) {
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			PresentationWorkOrder presentationModel = PresentationWorkOrder.getInstance();
			WorkOrder order = (WorkOrder) obj;
			order = (WorkOrder) (order != null ? (WorkOrder) order : new WorkOrder());
			presentationModel.getOrders().put(order.projectId, order);
			presentationModel.getOrders();
			return order.getProjectId();
		}
		return -1;
	}
	
public static RowsView getRowView(IWorkbenchWindow window){
	IWorkbenchPage page = window.getActivePage();
	RowsView view = (RowsView) page.findView(RowsView.ID);
	return view;
}

}
