package de.rs.prototype.firdaous.editor;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.swt.SWT;

import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

public class PoliceComposite extends EditorComposite {
	
	
	private Text txtClinicname;
	private Text streetText;
	private Text houseNumberText;
	private Text cityText;
	private Text zipText;
	private Text emailAdresseText;
	private Text ansprechPartnerText;
	private Text telephonText;

	
	public PoliceComposite(Composite composite, FormToolkit toolkit, Long projectId) {
		super(projectId);
		
		final SashForm sashForm = new SashForm(composite, SWT.HORIZONTAL);
		//Composite personCompositeForm = new Composite(sashForm, SWT.NONE);
		GridLayout layout2 = new GridLayout(2, false);
		layout2.marginWidth = 0;
		layout2.verticalSpacing = 0;
		layout2.marginHeight = 0;
		layout2.horizontalSpacing=0;
		composite.setLayout(layout2);
		Group grpPersonAngaben = new Group(composite, SWT.NONE);
		grpPersonAngaben.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		grpPersonAngaben.setText("Polizei Information");
		GridData gd_grpPersonAngaben = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 2);
		//gd_grpPersonAngaben.widthHint = 557;
		//gd_grpPersonAngaben.heightHint = 752;
		grpPersonAngaben.setLayoutData(gd_grpPersonAngaben);
		grpPersonAngaben.setTouchEnabled(true);
		
		//grpPersonAngaben.setBackground(SWTResourceManager.getColor(240, 230, 140));
		toolkit.adapt(grpPersonAngaben);
		toolkit.paintBordersFor(grpPersonAngaben);
		grpPersonAngaben.setLayout(new GridLayout(2, true));
		
		grpPersonAngaben.setLayoutData(gd_grpPersonAngaben);
		Label lblKrankenhaus = new Label(grpPersonAngaben, SWT.NONE);
		lblKrankenhaus.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(lblKrankenhaus, true, true);
		lblKrankenhaus.setText("Polizei");

		GridData gd_lblKrankenhaus = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_lblKrankenhaus.widthHint = 248;
		lblKrankenhaus.setLayoutData(gd_lblKrankenhaus);
		txtClinicname = new Text(grpPersonAngaben, SWT.BORDER);
		GridData gd_txtClinicname = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_txtClinicname.widthHint = 236;
		txtClinicname.setLayoutData(gd_txtClinicname);
		txtClinicname.setBackground(SWTResourceManager.getColor(240, 230, 140));

		Label lblAnsprechPartner = new Label(grpPersonAngaben, SWT.NONE);
		lblAnsprechPartner.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(lblAnsprechPartner, true, true);
		lblAnsprechPartner.setText("Ansprechpartner");
		ansprechPartnerText= new Text(grpPersonAngaben, SWT.BORDER);
		GridData gd_txtansprechPartnerText = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_txtansprechPartnerText.widthHint = 236;
		ansprechPartnerText.setLayoutData(gd_txtansprechPartnerText);
		ansprechPartnerText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		
		Label lblemailAdresseText = new Label(grpPersonAngaben, SWT.NONE);
		lblemailAdresseText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(lblemailAdresseText, true, true);
		lblemailAdresseText.setText("Emailadresse");
		emailAdresseText= new Text(grpPersonAngaben, SWT.BORDER);
		GridData gd_txtEmailAdresseText = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_txtEmailAdresseText.widthHint = 236;
		emailAdresseText.setLayoutData(gd_txtEmailAdresseText);
		emailAdresseText.setBackground(SWTResourceManager.getColor(240, 230, 140));
	
		
		
		Label lbltelephonText = new Label(grpPersonAngaben, SWT.NONE);
		lbltelephonText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(lbltelephonText, true, true);
		lbltelephonText.setText("Telefon");
		telephonText= new Text(grpPersonAngaben, SWT.BORDER);
		GridData gd_txttelephonText = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_txttelephonText.widthHint = 236;
		telephonText.setLayoutData(gd_txttelephonText);
		telephonText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		Label lblWebSiteText = new Label(grpPersonAngaben, SWT.NONE);
		lblWebSiteText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(lblWebSiteText, true, true);
		lblWebSiteText.setText("Website");
		Label lblWebSiteLink = new Label(grpPersonAngaben, SWT.NONE);
		lblWebSiteLink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(lblWebSiteLink, true, true);
		lblWebSiteLink.setText("www.policewebsite.com");
		
		
		
		Label lblStrae = new Label(grpPersonAngaben, SWT.NONE);
		toolkit.adapt(lblStrae, true, true);
		lblStrae.setText("Stra\u00DFe Hausnummer");
		
		Composite cAdressStreeHouseNr = WidgetFactory.createAddressComposite(grpPersonAngaben);
		streetText = new Text(cAdressStreeHouseNr, SWT.BORDER);
		GridData gd_street = new GridData(SWT.RIGHT, SWT.RIGHT, false, false, 1, 1);
		gd_street.widthHint = 178;
		streetText.setLayoutData(gd_street);
		streetText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		houseNumberText = new Text(cAdressStreeHouseNr, SWT.BORDER);
		GridData gd_houseNumber = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_houseNumber.widthHint = 58;
		houseNumberText.setLayoutData(gd_houseNumber);
		//toolkit.adapt(houseNumber, true, true);
		houseNumberText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		
		
		
		Label lblNewLabel_4 = new Label(grpPersonAngaben, SWT.NONE);
		toolkit.adapt(lblNewLabel_4, true, true);
		lblNewLabel_4.setText("Stadt Postleitzahl");
		
		Composite cAdressCityZip = WidgetFactory.createAddressComposite(grpPersonAngaben);
		
		
		cityText = new Text(cAdressCityZip, SWT.BORDER);
		cityText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		//toolkit.adapt(cityText, true, true);
		cityText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		GridData gd_city = new GridData(SWT.RIGHT, SWT.RIGHT, false, false, 1, 1);
		gd_city.widthHint = 178;
		cityText.setLayoutData(gd_city);

//		Label lblPlz = new Label(grpPersonAngaben, SWT.NONE);
//		toolkit.adapt(lblPlz, true, true);
//		lblPlz.setText("PLZ");

		zipText = new Text(cAdressCityZip, SWT.BORDER);
		zipText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		GridData gd_zip = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_zip.widthHint = 58;
		zipText.setLayoutData(gd_zip);
		//toolkit.adapt(zip, true, true);
		zipText.setBackground(SWTResourceManager.getColor(240, 230, 140));
	}

	@Override
	protected DataBindingContext initDataBindingContext() {
		
return null;
	}
}
