package de.rs.test.prototype.mail;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Group;

public class WorkOrderView extends ViewPart {
	
	private Text projectId;
	private FormToolkit toolkit;
	 private Form form;
	 private Text decederName;
	 private Text txtDecederfirstname;
	 private Text txtAdresse;
	 private Text profession;
	 private Text txtPartnername;
	 private Text partnerFirstName;
	 private Text partnerProfession;
	 private Text txtPartneradresse;
	 private Text txtClinicname;
	 private Text clinicAdresse;
	 private Text dieReason;
	 private Text txtTelefonnr;
	 private Text text;
	 private Text txtStandsamtname;
	public WorkOrderView() {
	}

	@Override
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
			new Label(form.getBody(), SWT.NONE);
			
			Group group = new Group(form.getBody(), SWT.NONE);
			group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
			toolkit.adapt(group);
			toolkit.paintBordersFor(group);
			group.setLayout(new GridLayout(2, false));
			
			Label lblVerstorbenerName = new Label(group, SWT.NONE);
			toolkit.adapt(lblVerstorbenerName, true, true);
			lblVerstorbenerName.setText("Verstorbener Name");
			
			decederName = new Text(group, SWT.BORDER);
			decederName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			toolkit.adapt(decederName, true, true);
			
			Label lblVerstorbenerVorname = new Label(group, SWT.NONE);
			lblVerstorbenerVorname.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			toolkit.adapt(lblVerstorbenerVorname, true, true);
			lblVerstorbenerVorname.setText("Verstorbener Vorname");
			
			txtDecederfirstname = new Text(group, SWT.BORDER);
			txtDecederfirstname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			txtDecederfirstname.setText("DecederFirstName");
			toolkit.adapt(txtDecederfirstname, true, true);
			
			Label lblAdresse = new Label(group, SWT.NONE);
			toolkit.adapt(lblAdresse, true, true);
			lblAdresse.setText("Adresse");
			
			txtAdresse = new Text(group, SWT.BORDER);
			txtAdresse.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			txtAdresse.setText("Adresse");
			toolkit.adapt(txtAdresse, true, true);
			
			Label lblGeburtsdatum = new Label(group, SWT.NONE);
			toolkit.adapt(lblGeburtsdatum, true, true);
			lblGeburtsdatum.setText("Geburtsdatum");
			
			DateTime birthDay = new DateTime(group, SWT.BORDER);
			toolkit.adapt(birthDay);
			toolkit.paintBordersFor(birthDay);
			
			Label lblSterbedatum = new Label(group, SWT.NONE);
			toolkit.adapt(lblSterbedatum, true, true);
			lblSterbedatum.setText("Sterbedatum");
			
			DateTime dieDay = new DateTime(group, SWT.BORDER);
			toolkit.adapt(dieDay);
			toolkit.paintBordersFor(dieDay);
			
			Label lblBeruf = new Label(group, SWT.NONE);
			toolkit.adapt(lblBeruf, true, true);
			lblBeruf.setText("Beruf");
			
			profession = new Text(group, SWT.BORDER);
			profession.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			toolkit.adapt(profession, true, true);
			
			Label lblPartnerName = new Label(group, SWT.NONE);
			toolkit.adapt(lblPartnerName, true, true);
			lblPartnerName.setText("Partner Name");
			
			txtPartnername = new Text(group, SWT.BORDER);
			txtPartnername.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			txtPartnername.setText("partnerName");
			toolkit.adapt(txtPartnername, true, true);
			
			Label lblPartnerVorname = new Label(group, SWT.NONE);
			toolkit.adapt(lblPartnerVorname, true, true);
			lblPartnerVorname.setText("Partner Vorname");
			
			partnerFirstName = new Text(group, SWT.BORDER);
			partnerFirstName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			toolkit.adapt(partnerFirstName, true, true);
			
			Label lblGeburtsdatum_1 = new Label(group, SWT.NONE);
			toolkit.adapt(lblGeburtsdatum_1, true, true);
			lblGeburtsdatum_1.setText("Geburtsdatum");
			
			DateTime partnerBirthDay = new DateTime(group, SWT.BORDER);
			toolkit.adapt(partnerBirthDay);
			toolkit.paintBordersFor(partnerBirthDay);
			
			Label lblBeruf_1 = new Label(group, SWT.NONE);
			toolkit.adapt(lblBeruf_1, true, true);
			lblBeruf_1.setText("partnerBeruf");
			
			partnerProfession = new Text(group, SWT.BORDER);
			partnerProfession.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			toolkit.adapt(partnerProfession, true, true);
			
			Label lblNewLabel = new Label(form.getBody(), SWT.NONE);
			toolkit.adapt(lblNewLabel, true, true);
			lblNewLabel.setText("Adresse");
			
			txtPartneradresse = new Text(form.getBody(), SWT.BORDER);
			txtPartneradresse.setText("partnerAdresse");
			txtPartneradresse.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			toolkit.adapt(txtPartneradresse, true, true);
			
			Label lblKrankenhaus = new Label(form.getBody(), SWT.NONE);
			toolkit.adapt(lblKrankenhaus, true, true);
			lblKrankenhaus.setText("Krankenhaus");
			
			txtClinicname = new Text(form.getBody(), SWT.BORDER);
			txtClinicname.setText("ClinicName");
			txtClinicname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			toolkit.adapt(txtClinicname, true, true);
			
			Label lblAdresse_1 = new Label(form.getBody(), SWT.NONE);
			toolkit.adapt(lblAdresse_1, true, true);
			lblAdresse_1.setText("Adresse");
			
			clinicAdresse = new Text(form.getBody(), SWT.BORDER);
			clinicAdresse.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			toolkit.adapt(clinicAdresse, true, true);
			
			Label lblNewLabel_1 = new Label(form.getBody(), SWT.NONE);
			toolkit.adapt(lblNewLabel_1, true, true);
			lblNewLabel_1.setText("Todursache");
			
			dieReason = new Text(form.getBody(), SWT.BORDER);
			dieReason.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			toolkit.adapt(dieReason, true, true);
			
			Label lblTelefonNr = new Label(form.getBody(), SWT.NONE);
			lblTelefonNr.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			toolkit.adapt(lblTelefonNr, true, true);
			lblTelefonNr.setText("Telefon Nr");
			
			txtTelefonnr = new Text(form.getBody(), SWT.BORDER);
			txtTelefonnr.setText("telefonNr");
			txtTelefonnr.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			toolkit.adapt(txtTelefonnr, true, true);
			
			Label lblAnsprechpartner = new Label(form.getBody(), SWT.NONE);
			lblAnsprechpartner.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			toolkit.adapt(lblAnsprechpartner, true, true);
			lblAnsprechpartner.setText("Ansprechpartner");
			
			text = new Text(form.getBody(), SWT.BORDER);
			text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			toolkit.adapt(text, true, true);
			
			Label lblStandamt = new Label(form.getBody(), SWT.NONE);
			lblStandamt.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			toolkit.adapt(lblStandamt, true, true);
			lblStandamt.setText("Standamt");
			
			txtStandsamtname = new Text(form.getBody(), SWT.BORDER);
			txtStandsamtname.setText("standsamtName");
			txtStandsamtname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			toolkit.adapt(txtStandsamtname, true, true);
			
			Label lblNewLabel_2 = new Label(form.getBody(), SWT.NONE);
			toolkit.adapt(lblNewLabel_2, true, true);
			lblNewLabel_2.setText("Kripo");
			
			StyledText styledText = new StyledText(form.getBody(), SWT.BORDER);
			styledText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			toolkit.adapt(styledText);
			toolkit.paintBordersFor(styledText);
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

}
