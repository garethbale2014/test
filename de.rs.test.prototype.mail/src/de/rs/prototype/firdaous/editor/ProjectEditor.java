package de.rs.prototype.firdaous.editor;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.osgi.framework.Bundle;

import de.rs.firdaous.xml.service.XMLService;
import de.rs.prototype.firdaous.model.PresentationWorkOrder;
import de.rs.prototype.firdaous.model.WorkOrder;
import de.rs.test.prototype.mail.Activator;

public class ProjectEditor {
	
	private FormToolkit toolkit;
	
	private ScrolledForm form;

	DataBindingContext bindingContext = new DataBindingContext();

	private PersonComposite personComposite;
	
	private EntryComposite entryComposite;
	
	
	long workerId = -1;
	
	private WorkOrder workOrder;
	
	
	
	@SuppressWarnings("unused")
	private class ActionSave extends Action {
		public ActionSave() {
			setImageDescriptor(Activator.getImageDescriptor("/icons/save.ico"));			
		}
		@Override
		public void run() {
			Map<Long, WorkOrder> map = PresentationWorkOrder.getInstance().getOrders();
			workOrder = map.get(workerId);
			try {
				XMLService.getxmlService().saveProjects(workOrder);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			System.out.println("ProjectEditor person firstname :"+workOrder.getPerson().getFirstname());
		
		}
	}
	
	@SuppressWarnings("unused")
	private class ActionLeichenNameForm extends Action {
		public ActionLeichenNameForm() {
			setImageDescriptor(Activator.getImageDescriptor("/icons/movingBox.gif"));			
		}
		@Override
		public void run() {
			Map<Long, WorkOrder> map = PresentationWorkOrder.getInstance().getOrders();
			WorkOrder order = map.get(workerId);
		}
	}
	
	
	@SuppressWarnings("unused")
	private class ActionSozialForm extends Action {
		public ActionSozialForm() {
			setImageDescriptor(Activator.getImageDescriptor("/icons/newBook.gif"));			
		}
		@Override
		public void run() {
			Map<Long, WorkOrder> map = PresentationWorkOrder.getInstance().getOrders();
			WorkOrder order = map.get(workerId);
		
		}
	}
	
	@SuppressWarnings("unused")
	private class ActionStandesamt extends Action {
		public ActionStandesamt() {
			setImageDescriptor(Activator.getImageDescriptor("/icons/meBook.gif"));			
		}
		@Override
		public void run() {
			Map<Long, WorkOrder> map = PresentationWorkOrder.getInstance().getOrders();
			WorkOrder order = map.get(workerId);
			
		}
	}
	
//	private class ActionDelete extends Action {
//		public ActionDelete() {
//			setImageDescriptor(Activator.getImageDescriptor("/icons/delete.ico"));
//			
//		}
//		@Override
//		public void run() {
//			
//			super.run();
//		}
//	}
	
	private class ActionNewEntry extends Action {
		public ActionNewEntry() {
			setImageDescriptor(Activator.getImageDescriptor("/icons/sample2.gif"));
			
		}
		@Override
		public void run() {
			
			
		}
	}
	
	public ProjectEditor(Composite parent, long id ) {
		
		
		toolkit = new FormToolkit(parent.getDisplay());
		form = toolkit.createScrolledForm(parent);
		form.getToolBarManager().add(new ActionSave ());
		form.getToolBarManager().add(new ActionNewEntry());
//		form.getToolBarManager().add(new ActionLeichenNameForm());
//		form.getToolBarManager().add(new ActionSozialForm());
//		form.getToolBarManager().add(new ActionStandesamt());
		form.getToolBarManager().update(true);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.horizontalSpacing = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginBottom=0;
		//form.getBody().setLayout(layout);
		//form.setText("Erfassung der Auftragangaben");
		workerId = id;
		workOrder = PresentationWorkOrder.getInstance().getOrders().get(workerId);

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
//		if(PresentationWorkOrder.getInstance().getOrders().get(id) != null)
			addProjectDataDlg();
//		else
		//openBrowser();
		
		
		
		
		
		
		
		
		
	}
	
	private void addProjectDataDlg(){
		Composite editorComposite = form.getBody();
		
		final GridLayout gridLayoutParent = new GridLayout();
		gridLayoutParent.marginWidth = 0;
		gridLayoutParent.verticalSpacing = 0;
		gridLayoutParent.marginHeight = 0;
		gridLayoutParent.verticalSpacing = 0;
		gridLayoutParent.horizontalSpacing = 0;
		gridLayoutParent.marginRight = 0;
		editorComposite.setLayout(gridLayoutParent);
		
		final SashForm sashForm = new SashForm(editorComposite, SWT.NONE);

		final Composite groupComposite = new Composite(sashForm, SWT.NONE);
		final GridLayout gridLayout = new GridLayout();
		
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing=0;
		gridLayout.marginWidth = 0;		
		gridLayout.marginHeight = 0;	
		gridLayout.marginRight =0;
		gridLayout.marginLeft = 0;
		gridLayout.marginTop=0;
		groupComposite.setLayout(gridLayout);

		final Composite groupToolBarComposite = new Composite(groupComposite,
				SWT.NONE);
		groupToolBarComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));
		
		entryComposite = new EntryComposite(groupComposite, toolkit, workerId);
		entryComposite.dbc = bindingContext;
		personComposite = new  PersonComposite(groupToolBarComposite, toolkit, workerId);
		personComposite.dbc = bindingContext;
		
		final SashForm personSashForm = new SashForm(sashForm, SWT.VERTICAL);

		final Composite cOffices = new Composite(personSashForm, SWT.NONE);
		final GridLayout gridLayout2 = new GridLayout();
		gridLayout2.marginWidth = 0;
		gridLayout2.verticalSpacing = 0;
		gridLayout2.marginHeight = 0;
		gridLayout2.horizontalSpacing=0;
		gridLayout2.marginWidth = 0;
		gridLayout2.verticalSpacing = 0;
		gridLayout2.marginHeight = 0;
		gridLayout2.verticalSpacing = 0;
		gridLayout2.horizontalSpacing = 0;
		gridLayout2.marginRight =0;
		cOffices.setLayout(gridLayout2);
		final Composite cOffices2 = new Composite(cOffices,				SWT.NONE);
		
		final Composite cOffices3 = new Composite(cOffices2,				SWT.NONE);
		new PoliceComposite(cOffices2, toolkit, workerId);
		final Composite cOffices4 = new Composite(cOffices3,				SWT.NONE);
		new ClinicComposite(cOffices3, toolkit, workerId);		
		
		
		new StandesamtComposite(cOffices4, toolkit, workerId);
		
		BrowserComponent.getInstance().setEditor(this);
		
		
		
//		Composite editorComposite = form.getBody();
//		
//		final SashForm sashForm = new SashForm(editorComposite, SWT.HORIZONTAL);
//		final GridLayout gridLayout = new GridLayout();
//		gridLayout.marginWidth = 0;
//		gridLayout.verticalSpacing = 0;
//		gridLayout.marginHeight = 0;
//		gridLayout.verticalSpacing = 0;
//		gridLayout.horizontalSpacing = 0;
//		gridLayout.marginRight = 0;
//		editorComposite.setLayout(gridLayout);
//		
//		
//		//final Composite EntryCompositeComposite = new Composite(sashForm, SWT.FILL);
//		final SashForm sashFormEntry = new SashForm(editorComposite, SWT.HORIZONTAL);
//		new EntryComposite(sashForm, toolkit, workerId);
//		PersonComposite personComposite = new  PersonComposite(sashFormEntry, toolkit, workerId);
//		personComposite.dbc = bindingContext;
//		
//		final SashForm entryForm = new SashForm(sashForm, SWT.VERTICAL);
//		final Composite entryOfficesComposite = new Composite(entryForm, SWT.FILL);
//		entryOfficesComposite.setLayout(createGridLayout());
//		new ClinicComposite(entryOfficesComposite, toolkit, workerId);
//		new PoliceComposite(entryOfficesComposite, toolkit, workerId);
//		new StandesamtComposite(entryOfficesComposite, toolkit, workerId);
	}
	
	private void openBrowser(){
		Composite editorComposite = form.getBody();
		final SashForm sashForm = new SashForm(editorComposite, SWT.HORIZONTAL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginBottom = 0;
		editorComposite.setLayout(new FillLayout());
		
		
		final SashForm personSashForm = new SashForm(sashForm, SWT.VERTICAL);

		final Composite personCenter = new Composite(personSashForm, SWT.FILL);
		personCenter.setLayout(new FillLayout());
		
		Browser browser = new Browser(personCenter, SWT.NONE);
    	Bundle plugin = Activator.getDefault().getBundle(); // Where Activator is my org.eclipse.core.runtime.Plugin
    	
    	IPath relativePagePath = new Path("./resources/Anlage zum Sterbefall.pdf");
    	URL fileInPlugin = FileLocator.find(plugin, relativePagePath, null);
    	URL pageUrl;
		try {
	
			pageUrl = FileLocator.toFileURL(fileInPlugin);
			browser.setUrl(pageUrl.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private GridLayout createGridLayout(){
		final GridLayout gridLayout_2 = new GridLayout();
		gridLayout_2.horizontalSpacing = 0;
		gridLayout_2.marginWidth = 0;
		gridLayout_2.verticalSpacing = 0;
		gridLayout_2.marginHeight = 0;
		gridLayout_2.marginBottom=0;
		gridLayout_2.marginTop = 0;
		return gridLayout_2;
	}
	
	public PersonComposite getPersonComposite() {
		return personComposite;
	}
	
	public void setPersonComposite(PersonComposite personComposite) {
		this.personComposite = personComposite;
	}

	
	public WorkOrder getWorkOrder() {
		return workOrder;
	}
	
	public void setWorkOrder(WorkOrder workOrder) {
		this.workOrder = workOrder;
	}

	public EntryComposite getEntryComposition() {
		// TODO Auto-generated method stub
		return entryComposite;
	}

	
	
	

}
