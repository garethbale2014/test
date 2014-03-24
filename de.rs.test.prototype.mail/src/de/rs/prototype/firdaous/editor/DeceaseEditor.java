package de.rs.prototype.firdaous.editor;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.wb.swt.SWTResourceManager;

import de.rs.prototype.firdaous.model.PresentationWorkOrder;
import de.rs.prototype.firdaous.model.WorkOrder;



public class DeceaseEditor extends EditorPart {
	public DeceaseEditor() {
		
		
	}
  public static final String ID = "de.vogella.rcp.editor.example.editor.deceaseeditor";
  
  
  private PresentationWorkOrder workOrderModel = PresentationWorkOrder.getInstance();
  private FileStoreEditorInput input;
  private Text nationality;
  private Text applyNr;
  private Text phonenr;
  private Text nname2;
  private Text telefonPrivate;
  private Text employerName;
  private Text decedeName;
  private Text decedeLastname;
  private Text birthName;
  private Text birthcity;
  private Text fathername;
  private Text mothername;
  private Text address;
  private Text clinicName;
  private Text decedeRaison;
  private Text decedeCity;
  private Text partnerName;
  private Text partnerLastname;
  private Text partnerProfession;
  private Text partnerBirthCity;
  private Text marriageCity;
  private Text pass;
  private Text cin;

  // Will be called before createPartControl
  @Override
  public void init(IEditorSite site, IEditorInput input)
      throws PartInitException {
    if (!(input instanceof WorkOrderEditorInput)) {
      throw new RuntimeException("Wrong input");
    }
    setSite(site);
    setInput(input);    
    setPartName("Sterbe Formular : " );
    
  }

  @Override
  public void createPartControl(Composite parent) {
	  
	  
	  
  	parent.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
    GridLayout layout = new GridLayout();
    
    layout.numColumns = 4;
    parent.setLayout(layout);
    
    Group grpAusweisangaben = new Group(parent, SWT.NONE);
    grpAusweisangaben.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
    grpAusweisangaben.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
    grpAusweisangaben.setText("Ausweisangaben");
    grpAusweisangaben.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 4, 1));
    grpAusweisangaben.setLayout(new GridLayout(6, false));
    
    Button btnCheckButton_3 = new Button(grpAusweisangaben, SWT.CHECK);
    btnCheckButton_3.setText("Pa\u00DF");
    
    pass = new Text(grpAusweisangaben, SWT.BORDER);

    GridData gd_pass = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
    gd_pass.widthHint = 205;
    pass.setLayoutData(gd_pass);
    
    
    Label lblNewLabel_4 = new Label(grpAusweisangaben, SWT.NONE);
    lblNewLabel_4.setText("Nationalit\u00E4t");
    
    nationality = new Text(grpAusweisangaben, SWT.BORDER);
    nationality.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
    
    Label lblNewLabel_5 = new Label(grpAusweisangaben, SWT.NONE);
    lblNewLabel_5.setText("Berabeitung-Nr");
    
    applyNr = new Text(grpAusweisangaben, SWT.BORDER);
    applyNr.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
    
    Button btnCheckButton_2 = new Button(grpAusweisangaben, SWT.CHECK);
    btnCheckButton_2.setText("C.I.N");
    
    cin = new Text(grpAusweisangaben, SWT.BORDER);
    cin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    
    Button btnCheckButton = new Button(grpAusweisangaben, SWT.CHECK);
    btnCheckButton.setText("Tel");
    
    phonenr = new Text(grpAusweisangaben, SWT.BORDER);
    phonenr.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
    
    Label lblBearbeiter = new Label(grpAusweisangaben, SWT.NONE);
    lblBearbeiter.setText("Bearbeiter");
    
    employerName = new Text(grpAusweisangaben, SWT.BORDER);
    employerName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
    
    Button btnCheckButton_1 = new Button(grpAusweisangaben, SWT.CHECK);
    btnCheckButton_1.setText("Heiratsurkunde");
    new Label(grpAusweisangaben, SWT.NONE);
    
    Button btnCheckButton_5 = new Button(grpAusweisangaben, SWT.CHECK);
    btnCheckButton_5.setText("Name");
    
    nname2 = new Text(grpAusweisangaben, SWT.BORDER);
    nname2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
    
    Label label = new Label(grpAusweisangaben, SWT.NONE);
    label.setText("Datum");
    
    DateTime createDate = new DateTime(grpAusweisangaben, SWT.DATE | SWT.MEDIUM | SWT.BORDER | SWT.DROP_DOWN);
    
    Button btnCheckButton_4 = new Button(grpAusweisangaben, SWT.CHECK);
    btnCheckButton_4.setText("Geburtsurkunde");
    new Label(grpAusweisangaben, SWT.NONE);
    
    Button btnCheckButton_6 = new Button(grpAusweisangaben, SWT.CHECK);
    btnCheckButton_6.setText("Privat");
    
    telefonPrivate = new Text(grpAusweisangaben, SWT.BORDER);
    telefonPrivate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
    new Label(grpAusweisangaben, SWT.NONE);
    new Label(grpAusweisangaben, SWT.NONE);
    
    Label lblNewLabel = new Label(parent, SWT.NONE);
    lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
    lblNewLabel.setText("Verstorbener");
    
    Label lblNewLabel_1 = new Label(parent, SWT.NONE);
    lblNewLabel_1.setText("Geschlecht");
    
    Button btnCheckButton_7 = new Button(parent, SWT.CHECK);
    btnCheckButton_7.addSelectionListener(new SelectionAdapter() {
    	@Override
    	public void widgetSelected(SelectionEvent e) {
    	}
    });
    btnCheckButton_7.setText("M\u00E4nnlich");
    
    Button btnCheckButton_8 = new Button(parent, SWT.CHECK);
    btnCheckButton_8.setText("Weiblich");
    
    Label lblNewLabel_2 = new Label(parent, SWT.NONE);
    lblNewLabel_2.setText("Name");
    
    decedeName = new Text(parent, SWT.BORDER);
    decedeName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
pass.addSelectionListener(new SelectionListener() {
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		//System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT : "+decedeModel.getFirstname());
		
	}
	
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		//System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT : "+decedeModel.getFirstname());
		
	}
});
    Label lblNewLabel_8 = new Label(parent, SWT.NONE);
    lblNewLabel_8.setText("Geburtsname");
    
    birthName = new Text(parent, SWT.BORDER);
    birthName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    
    Label lblNewLabel_3 = new Label(parent, SWT.NONE);
    lblNewLabel_3.setText("Vorname");
    
    decedeLastname = new Text(parent, SWT.BORDER);
    decedeLastname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    decedeLastname.addFocusListener(new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			//String testValue = decedeModel.getNationality().getName();
			System.out.println("QWERQWERQWERQWERQWER");
			System.out.println("nationality : "+nationality.getText());
			System.out.println("emoployer name : "+employerName.getText());
			
		}
	});
    
    Label lblNewLabel_9 = new Label(parent, SWT.NONE);
    lblNewLabel_9.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
    lblNewLabel_9.setText("Geburtsort");
    
    birthcity = new Text(parent, SWT.BORDER);
    birthcity.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    
    Label lblNewLabel_6 = new Label(parent, SWT.NONE);
    lblNewLabel_6.setText("Geburtsdatum");
    
    DateTime dateTime_2 = new DateTime(parent, SWT.DATE | SWT.MEDIUM | SWT.BORDER | SWT.DROP_DOWN);
    
    Label lblNameDesVaters = new Label(parent, SWT.NONE);
    lblNameDesVaters.setText("Name des Vaters");
    
    fathername = new Text(parent, SWT.BORDER);
    GridData gd_fathername = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
    gd_fathername.widthHint = 95;
    fathername.setLayoutData(gd_fathername);
    
    Label lblNewLabel_10 = new Label(parent, SWT.NONE);
    lblNewLabel_10.setText("Adresse");
    
    address = new Text(parent, SWT.BORDER);
    address.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    
    Label lblNewLabel_7 = new Label(parent, SWT.NONE);
    lblNewLabel_7.setText("Name der Mutter");
    
    mothername = new Text(parent, SWT.BORDER);
    mothername.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    
    Label lblNewLabel_11 = new Label(parent, SWT.NONE);
    lblNewLabel_11.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
    lblNewLabel_11.setText("Sterbedatum");
    
    DateTime dateTime = new DateTime(parent, SWT.DATE | SWT.MEDIUM | SWT.BORDER | SWT.DROP_DOWN);
    
    Label lblNewLabel_14 = new Label(parent, SWT.NONE);
    lblNewLabel_14.setText("Sterbeort");
    
    decedeCity = new Text(parent, SWT.BORDER);
    decedeCity.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    
    Label lblNewLabel_12 = new Label(parent, SWT.NONE);
    lblNewLabel_12.setText("Krankenhaus");
    
    clinicName = new Text(parent, SWT.BORDER);
    clinicName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    
    Label lblNewLabel_15 = new Label(parent, SWT.NONE);
    lblNewLabel_15.setText("Obduktion durchgef\u00FChrt");
    
    Button btnRadioButton = new Button(parent, SWT.RADIO);
    btnRadioButton.setText("Ja");
    
    Label lblNewLabel_13 = new Label(parent, SWT.NONE);
    lblNewLabel_13.setText("Todursache");
    
    decedeRaison = new Text(parent, SWT.BORDER);
    decedeRaison.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    new Label(parent, SWT.NONE);
    
    Button btnNein = new Button(parent, SWT.RADIO);
    btnNein.setText("Nein");
    
    Button naturalDecede = new Button(parent, SWT.CHECK);
    naturalDecede.addSelectionListener(new SelectionAdapter() {
    	@Override
    	public void widgetSelected(SelectionEvent e) {
    	}
    });
    naturalDecede.setText("Nat\u00FCrlicher Tod");
    
    Button birthDecede = new Button(parent, SWT.CHECK);
    birthDecede.setText("Totgeburt");
    
    Label lblNewLabel_16 = new Label(parent, SWT.NONE);
    lblNewLabel_16.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
    lblNewLabel_16.setText("Kripo(KK)");
    
    StyledText cripoDescription = new StyledText(parent, SWT.BORDER);
    GridData gd_cripoDescription = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
    gd_cripoDescription.heightHint = 52;
    gd_cripoDescription.widthHint = 205;
    cripoDescription.setLayoutData(gd_cripoDescription);
    
    Group group = new Group(parent, SWT.NONE);
    group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 4, 1));
    group.setLayout(new GridLayout(4, false));
    
    Group grpFamilienstand = new Group(group, SWT.NONE);
    grpFamilienstand.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 4, 1));
    grpFamilienstand.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
    grpFamilienstand.setText("Familienstand");
    grpFamilienstand.setLayout(new GridLayout(5, false));
    
    Button btnRadioButton_4 = new Button(grpFamilienstand, SWT.RADIO);
    btnRadioButton_4.setText("Ledig");
    
    Button btnRadioButton_3 = new Button(grpFamilienstand, SWT.RADIO);
    btnRadioButton_3.setText("Verheiratet");
    
    Button btnGeschieden = new Button(grpFamilienstand, SWT.RADIO);
    btnGeschieden.setText("Geschieden");
    
    Button btnRadioButton_1 = new Button(grpFamilienstand, SWT.RADIO);
    btnRadioButton_1.addSelectionListener(new SelectionAdapter() {
    	@Override
    	public void widgetSelected(SelectionEvent e) {
    	}
    });
    btnRadioButton_1.setText("Verwitwet");
    
    Button btnRadioButton_2 = new Button(grpFamilienstand, SWT.RADIO);
    btnRadioButton_2.setText("Unbekannt");
    
    Label lblNewLabel_19 = new Label(grpFamilienstand, SWT.NONE);
    lblNewLabel_19.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
    lblNewLabel_19.setText("Name letzter Ehegatte");
    
    partnerName = new Text(grpFamilienstand, SWT.BORDER);
    GridData gd_partnerName = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
    gd_partnerName.widthHint = 178;
    partnerName.setLayoutData(gd_partnerName);
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    
    Label lblNewLabel_20 = new Label(grpFamilienstand, SWT.NONE);
    lblNewLabel_20.setText("Vorname");
    
    partnerLastname = new Text(grpFamilienstand, SWT.BORDER);
    partnerLastname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    
    Label lblBeruf = new Label(grpFamilienstand, SWT.NONE);
    lblBeruf.setText("Beruf");
    
    partnerProfession = new Text(grpFamilienstand, SWT.BORDER);
    partnerProfession.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    
    Label lblGeburtsort = new Label(grpFamilienstand, SWT.NONE);
    lblGeburtsort.setText("Geburtsort");
    
    partnerBirthCity = new Text(grpFamilienstand, SWT.BORDER);
    partnerBirthCity.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    
    Label lblEheschlieungsort = new Label(grpFamilienstand, SWT.NONE);
    lblEheschlieungsort.setText("Eheschlie\u00DFungsort");
    
    marriageCity = new Text(grpFamilienstand, SWT.BORDER);
    marriageCity.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    
    Label lblNewLabel_23 = new Label(grpFamilienstand, SWT.NONE);
    lblNewLabel_23.setText("Geburtsdatum");
    
    DateTime partnerBirthday = new DateTime(grpFamilienstand, SWT.DATE | SWT.MEDIUM | SWT.BORDER | SWT.DROP_DOWN);
    GridData gd_partnerBirthday = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    gd_partnerBirthday.widthHint = 190;
    partnerBirthday.setLayoutData(gd_partnerBirthday);
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    
    Label lblNewLabel_21 = new Label(grpFamilienstand, SWT.NONE);
    lblNewLabel_21.setText("Eheschlie\u00DFungsdatum");
    
    DateTime marriageDate = new DateTime(grpFamilienstand, SWT.DATE | SWT.MEDIUM | SWT.BORDER | SWT.DROP_DOWN);
    GridData gd_marriageDate = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    gd_marriageDate.widthHint = 190;
    marriageDate.setLayoutData(gd_marriageDate);
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    
    Label lblNewLabel_24 = new Label(grpFamilienstand, SWT.NONE);
    lblNewLabel_24.setText("Todesdatum");
    
    DateTime decedeDate = new DateTime(grpFamilienstand, SWT.DATE | SWT.MEDIUM | SWT.BORDER | SWT.DROP_DOWN);
    GridData gd_decedeDate = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    gd_decedeDate.widthHint = 190;
    decedeDate.setLayoutData(gd_decedeDate);
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    new Label(grpFamilienstand, SWT.NONE);
    
    bind();
  }

  private void bind() {
	
	  DataBindingContext ctx = new DataBindingContext();

	 
//	  IObservableValue targetNationality = WidgetProperties.text(SWT.Modify).	    observe(nationality);
//	  IObservableValue modelNationality = PojoProperties.value(DecedeViewModel.class,"nationality.name").observe(decedeModel);
//	  ctx.bindValue(targetNationality, modelNationality); 
//	  
//	  IObservableValue employerNameTarget = WidgetProperties.text(SWT.Modify).	    observe(employerName);
//	  IObservableValue modelEmployer = PojoProperties.value(DecedeViewModel.class,"email").observe(decedeModel);
//	  ctx.bindValue(employerNameTarget, modelEmployer); 
	  
	  
	  /*
	   * private Text nationality;

  private Text phonenr;
  private Text nname2;
  private Text telefonPrivate;
  private Text employerName;
  private Text decedeName;
  private Text decedeLastname;
  private Text birthName;
  private Text birthcity;
  private Text fathername;
  private Text mothername;
  private Text address;
  private Text clinicName;
  private Text decedeRaison;
  private Text decedeCity;
  private Text partnerName;
  private Text partnerLastname;
  private Text partnerProfession;
  private Text partnerBirthCity;
  private Text marriageCity;
  private Text pass;
  private Text cin;*/
	 
//	  IObservableValue targetApplyNr = WidgetProperties.text(SWT.Modify).	    observe(applyNr);
//	  IObservableValue modelApplyNr = PojoProperties.value(DecedeViewModel.class,"formId").observe(decedeModel);
//	  ctx.bindValue(targetApplyNr, modelApplyNr); 
//	  
//	  IObservableValue targetPhonenr = WidgetProperties.text(SWT.Modify).	    observe(phonenr);
//	  IObservableValue modelPhonenr = PojoProperties.value(DecedeViewModel.class,"phone.telNumber").observe(decedeModel);
//	  ctx.bindValue(targetPhonenr, modelPhonenr); 
	  
	  
	  
	  
	  
  }

@Override
  public void doSave(IProgressMonitor monitor) {
    // person.getAddress().setCountry(text2.getText());
  }

  @Override
  public void doSaveAs() {
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
  public void setFocus() {
  }
} 