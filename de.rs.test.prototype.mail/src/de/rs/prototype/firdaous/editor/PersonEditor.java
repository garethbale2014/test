package de.rs.prototype.firdaous.editor;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.EditorPart;

import de.rs.firdaous.xml.service.XMLService;
import de.rs.prototype.firdaous.model.PresentationWorkOrder;
import de.rs.prototype.firdaous.model.WorkOrder;
import de.rs.test.prototype.mail.Activator;

public class PersonEditor extends EditorPart {

	// private FormToolkit toolkit;

	private ScrolledForm form;

	long workerId = -1;

	public PersonEditor() {
	}

	public static final String ID = "de.rs.test.prototype.mail.personeditor";

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		if (!(input instanceof IPersonEditorInput)) {
			throw new RuntimeException("Wrong input");
		}
		setSite(site);
		setInput(input);
		IPersonEditorInput IPersonEditorInput = (IPersonEditorInput) input;
		workerId = Long.parseLong(IPersonEditorInput.getId());
		setPartName("Person Information " + IPersonEditorInput.getId());

	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@SuppressWarnings("unused")
	private class ActionSave extends Action {
		public ActionSave() {
			setImageDescriptor(Activator.getImageDescriptor("/icons/save.ico"));
		}

		@Override
		public void run() {
			Map<Long, WorkOrder> map = PresentationWorkOrder.getInstance().getOrders();
			WorkOrder order = map.get(workerId);
			String firstname = order.getPerson().getFirstname();
			try {
				XMLService.getxmlService().saveProjects(order);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		form = toolkit.createScrolledForm(parent);
		form.getToolBarManager().add(new ActionSave());

		form.getToolBarManager().update(true);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.horizontalSpacing = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginBottom = 0;
		form.getBody().setLayout(new FillLayout());

		Composite editorComposite = form.getBody();
		final SashForm sashForm = new SashForm(editorComposite, SWT.HORIZONTAL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginBottom = 0;
		editorComposite.setLayout(gridLayout);
		form.setText("Erfassung der Auftragangaben");

		final Runnable reflow = new Runnable() {
			public void run() {
				form.reflow(true);
			}
		};
		parent.addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				form.getDisplay().asyncExec(reflow);
			}
		});
		new PersonComposite(editorComposite,toolkit, workerId);
		

	}

	@Override
	public void setFocus() {
		

	}

}
