package de.rs.test.prototype.mail;

import org.eclipse.jface.action.Action;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.CoolBar;

public class SearchView extends ViewPart {
	
	public static final String ID ="de.rs.test.prototype.mail.SearchView";
	private Text projectId;
//
//	public SearchView() {
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public void createPartControl(Composite parent) {
//		parent.setLayout(new GridLayout(2, false));
//		
//		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
//		ScrolledForm  form = toolkit.createForm(parent);
//		  form.setText("Hello, Eclipse Forms");
//		  GridLayout layout = new GridLayout();
//		  form.getBody().setLayout(layout);
//		
//		
//		
//		Label lblNewLabel = new Label(parent, SWT.NONE);
//		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		lblNewLabel.setText("Auftrag Nummer");
//		
//		projectId = new Text(parent, SWT.BORDER);
//		projectId.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//		
//		Label lblAuftragDatum = new Label(parent, SWT.NONE);
//		lblAuftragDatum.setText("Auftrag Datum");
//		
//		DateTime projectCreateDate = new DateTime(parent, SWT.BORDER);
//		new Label(parent, SWT.NONE);
//		
//		
//		// TODO Auto-generated method stub
//		
//		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
//
//	}
//
//	@Override
//	public void setFocus() {
//		// TODO Auto-generated method stub
//
//	}
	
	
	private FormToolkit toolkit;
	 private Form form;

	 /**
	  * The constructor.
	  */
	 public SearchView() {
	 }

	 /**
	  * This is a callback that will allow us to create the viewer and
	  * initialize it.
	  */
	 public void createPartControl(Composite parent) {
		 
		 toolkit = new FormToolkit(parent.getDisplay());
		  form = toolkit.createForm(parent);
		  //form.setText("Hello, Eclipse Forms");
		  GridLayout layout = new GridLayout();
		  form.getBody().setLayout(layout);
		  
		  
		  layout.numColumns = 2;
		  GridData gd = new GridData();
		  gd.horizontalSpan = 2;
		  //link.setLayoutData(gd);
		  Label label = new Label(form.getBody(), SWT.NULL);
		  label.setText("Auftrag Nummer");
		  projectId = new Text(form.getBody(), SWT.BORDER);
		  GridData gd_projectId = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		  gd_projectId.widthHint = 110;
		  //projectId.setLayoutData(gd_projectId);
		  //projectId.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		  //Button button = new Button(form.getBody(), SWT.CHECK);
		  //button.setText("An example of a checkbox in a form");
		  gd = new GridData();
		  gd.horizontalSpan = 2;
		  //button.setLayoutData(gd);
		  
		  
			Label lblAuftragDatum = new Label(form.getBody(), SWT.NONE);
			lblAuftragDatum.setText("Auftrag Datum");
			
			DateTime projectCreateDate = new DateTime(form.getBody(), SWT.DATE | SWT.MEDIUM | SWT.BORDER | SWT.DROP_DOWN);
			
			Hyperlink link = toolkit.createHyperlink(form.getBody(), "Trefferanzahl", SWT.WRAP);
			  link.addHyperlinkListener(new HyperlinkAdapter() {
			   public void linkActivated(HyperlinkEvent e) {
			    System.out.println("Link activated!");
			   }
			  });
			  //projectCreateDate.setLayoutData(gd_projectId);
			//new Label(parent, SWT.NONE);
			
			
			// TODO Auto-generated method stub
			
			//IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	 }

	 /**
	  * Passing the focus request to the form.
	  */
	 public void setFocus() {
	  form.setFocus();
	 }

	 /**
	  * Disposes the toolkit
	  */
	 public void dispose() {
	  toolkit.dispose();
	  super.dispose();
	 }
	 
	 private void createViewMenu(){
			IActionBars bars = getViewSite().getActionBars();
			bars.getMenuManager().add(new AbcAction());
			bars.getToolBarManager().add(new BcdAction());
		}
		class AbcAction extends Action {
			AbcAction(){
				setText("Abc");
				setImageDescriptor(Activator.getDefault().getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));
			}
			public void run(){
				
			}
		}
		class BcdAction extends Action {
			BcdAction(){
				setText("Bcd");
				setImageDescriptor(Activator.getDefault().getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_DEF_VIEW));
			}
			public void run(){
				
			}
		}

}
