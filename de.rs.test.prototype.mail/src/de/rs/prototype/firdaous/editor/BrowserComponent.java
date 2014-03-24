package de.rs.prototype.firdaous.editor;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.viewers.ViewersObservables;

import de.rs.test.prototype.mail.RowsView;

public class BrowserComponent {
	
	private RowsView rowView;
	
	private ProjectEditor editor;
	
	private static BrowserComponent browser;
	
	private BrowserComponent() {
		
	}
	
	public static BrowserComponent getInstance(){
		if(browser == null)
			browser = new BrowserComponent();
		return browser;
	}
	
	

	
	public void setEditor(ProjectEditor editor) {
		this.editor = editor;
		IObservableValue phoneBookDetailPersonObserveValue = BeansObservables.observeValue(editor.getPersonComposite(), "order");
		IObservableValue m_personViewerSelectionObserveSelection = ViewersObservables.observeSingleSelection(rowView.getTableViewer());
		
		DataBindingContext bindingContext = new DataBindingContext();
		bindingContext.bindValue(phoneBookDetailPersonObserveValue, m_personViewerSelectionObserveSelection, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		
		IObservableValue phoneBookDetailAntragObserveValue = BeansObservables.observeValue(editor.getEntryComposition(), "order");
		//IObservableValue m_personViewerSelectionObserveSelection = ViewersObservables.observeSingleSelection(rowView.getTableViewer());
		
		//DataBindingContext bindingContext = new DataBindingContext();
		bindingContext.bindValue(phoneBookDetailPersonObserveValue, m_personViewerSelectionObserveSelection, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		bindingContext.bindValue(phoneBookDetailAntragObserveValue, m_personViewerSelectionObserveSelection, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
	}
	public ProjectEditor getEditor() {
		return editor;
	}
	
	public void setRowView(RowsView rowView) {
		this.rowView = rowView;
	}
	
	public RowsView getRowView() {
		return rowView;
	}

}
