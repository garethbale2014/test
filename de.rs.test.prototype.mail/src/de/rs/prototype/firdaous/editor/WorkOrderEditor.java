package de.rs.prototype.firdaous.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class WorkOrderEditor extends EditorPart {

	public static String ID = "de.vogella.rcp.editor.example.workorder";	

	private WorkOrderEditorInput input;

	public WorkOrderEditor() {
		
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		

	}

	@Override
	public void doSaveAs() {
		

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		if (!(input instanceof WorkOrderEditorInput)) {
			throw new RuntimeException("Wrong input");
		}
		this.input = (WorkOrderEditorInput) input;

		setSite(site);
		setInput(input);
		setPartName("Anlage zum Sterbefall.pdf");

	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {

		long workOrderId = this.input.getId();		
		new ProjectEditor(parent, workOrderId);
		
		
    	

	}



	@Override
	public void setFocus() {
		

	}
	
	

}
