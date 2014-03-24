package de.rs.test.prototype.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;

import de.rs.prototype.firdaous.editor.BrowserComponent;
import de.rs.prototype.firdaous.handler.CallEditor;
import de.rs.prototype.firdaous.model.PresentationWorkOrder;
import de.rs.prototype.firdaous.model.WorkOrder;
import de.rs.prototype.utils.ColumnCreator;
import de.rs.prototype.utils.ColumnConstants;
import de.rs.prototype.utils.GenericObservableMapLabelProvider;

public class RowsView extends ViewPart {

	public static final String ID = "de.rs.test.prototype.mail.RowsView";

	private WritableList input;

	private TableViewer tableViewer;

	private DataBindingContext bindingContext;
	
	

	

	

	@Override
	public void createPartControl(Composite parent) {

		tableViewer = new TableViewer(parent, SWT.VIRTUAL | SWT.FULL_SELECTION | SWT.MULTI);
		//bindingContext = Activator.getDefault().getBindingContext();
		for (String headerText : ColumnConstants.RowViewerColumns) {
			ColumnCreator.createColumn(tableViewer, headerText);
		}

		tableViewer.getTable().setHeaderVisible(true);

		List<WorkOrder> ordersList = new ArrayList<WorkOrder>();
		for (Entry<Long, WorkOrder> entry : PresentationWorkOrder.getInstance().getOrders().entrySet()) {
			ordersList.add(entry.getValue());
		}
		
		//"Nationalität", "Adresse", "Adresse"
		
		input = new WritableList(ordersList, WorkOrder.class);
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setInput(ordersList);
		
//		ViewerSupport.bind(tableViewer, input,
//				PojoProperties.values(new String[] { "projectId", "workOrderDate", "person.firstname", "person.lastname", "person.birthday", "person.decedDay",
//						"person.birthCity", "person.nationality.name", "person.addresse" }));

		

		
		
		getSite().setSelectionProvider(tableViewer);
		hookDoubleClickCommand();
		BrowserComponent.getInstance().setRowView(this);
		
		

	}

	private void hookDoubleClickCommand() {
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				String commandID = CallEditor.id;
				IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
				try {
					handlerService.executeCommand(commandID, null);
				} catch (Exception ex) {
					throw new RuntimeException(commandID + " not found");
				}
			}
		});
	}

	@Override
	public void setFocus() {

	}

	public void setBinding() {

	}
	
	public TableViewer getTableViewer() {
		return tableViewer;
	}
	public void setTableViewer(TableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}

}
