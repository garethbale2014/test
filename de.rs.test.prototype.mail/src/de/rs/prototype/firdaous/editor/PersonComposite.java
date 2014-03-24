package de.rs.prototype.firdaous.editor;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import de.rs.prototype.firdaous.model.PersonData;
import de.rs.prototype.firdaous.model.WorkOrder;

public class PersonComposite extends EditorComposite {
	
	private Text nameText;
	private Text firstnameText;
	private Text professionText;
	private Text partnerNameText;
	private Text partnerFirstNameText;
	private Text partnerProfessionText;
	
	private Text streetText;
	private Text houseNumberText;
	private Text zipText;
	
	private DateTime birthDay;
	private DateTime dieDay;
	private DateTime partnerBirthDay;
	private Text cityText;
	private Text birthCityText;
	private Text partnerStreetText;
	private Text partnerHouseNrText;
	private Text partnerCityText;
	private Text partnerZIPText;
	
	private PersonData person;
	

	
	
	
	
	public PersonComposite(Composite composite, FormToolkit toolkit, Long projectId) {
		super(projectId);
		GridLayout layout2 = new GridLayout(2, false);
		layout2.marginHeight = 0;
		layout2.marginRight =0;
		layout2.marginWidth = 0;
		layout2.horizontalSpacing=0;;
		layout2.verticalSpacing = 0;
		
		composite.setLayout(layout2);
		Group grpPersonAngaben = new Group(composite, SWT.NONE);
		grpPersonAngaben.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		grpPersonAngaben.setText("Person Angaben");
		GridData gd_grpPersonAngaben = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 2);
		grpPersonAngaben.setLayoutData(gd_grpPersonAngaben);
		toolkit.adapt(grpPersonAngaben);
		toolkit.paintBordersFor(grpPersonAngaben);
		grpPersonAngaben.setLayout(new GridLayout(2, true));

		Label lblVerstorbenerName = new Label(grpPersonAngaben, SWT.NONE);
		lblVerstorbenerName.setText("Verstorbener Name");
		toolkit.adapt(lblVerstorbenerName, true, true);
		



		GridData gd_lblVerstorbenerName = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_lblVerstorbenerName.widthHint = 48;
		lblVerstorbenerName.setLayoutData(gd_lblVerstorbenerName);
		
		nameText = new Text(grpPersonAngaben, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		nameText.setBackground(SWTResourceManager.getColor(240, 230, 140));
	
		Label lblVerstorbenerVorname = new Label(grpPersonAngaben, SWT.NONE);

		lblVerstorbenerVorname.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(lblVerstorbenerVorname, true, true);
		lblVerstorbenerVorname.setText("Verstorbener Vorname");

		firstnameText = new Text(grpPersonAngaben, SWT.BORDER);
		firstnameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(firstnameText, true, true);
		firstnameText.setBackground(SWTResourceManager.getColor(240, 230, 140));

		Label lblStrae = new Label(grpPersonAngaben, SWT.NONE);
		toolkit.adapt(lblStrae, true, true);
		lblStrae.setText("Stra\u00DFe Hausnummer");
		
		Composite cAdressStreeHouseNr = WidgetFactory.createAddressComposite(grpPersonAngaben);
		streetText = new Text(cAdressStreeHouseNr, SWT.BORDER);
		GridData gd_street = new GridData(SWT.FILL, SWT.RIGHT, false, false, 1, 1);
		gd_street.widthHint = 178;
		streetText.setLayoutData(gd_street);
		streetText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		houseNumberText = new Text(cAdressStreeHouseNr, SWT.BORDER);
		GridData gd_houseNumber = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_houseNumber.widthHint = 58;
		houseNumberText.setLayoutData(gd_houseNumber);
		houseNumberText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		
		
		
		Label lblNewLabel_4 = new Label(grpPersonAngaben, SWT.NONE);
		toolkit.adapt(lblNewLabel_4, true, true);
		lblNewLabel_4.setText("Stadt Postleitzahl");
		
		Composite cAdressCityZip = WidgetFactory.createAddressComposite(grpPersonAngaben);
		
		
		cityText = new Text(cAdressCityZip, SWT.BORDER);
		cityText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		cityText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		GridData gd_city = new GridData(SWT.RIGHT, SWT.RIGHT, false, false, 1, 1);
		gd_city.widthHint = 178;
		cityText.setLayoutData(gd_city);
		
		zipText = new Text(cAdressCityZip, SWT.BORDER);
		zipText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		GridData gd_zip = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_zip.widthHint = 58;
		zipText.setLayoutData(gd_zip);
		zipText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		
		Label lblGeburtsdatum = new Label(grpPersonAngaben, SWT.NONE);
		lblGeburtsdatum.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(lblGeburtsdatum, true, true);
		lblGeburtsdatum.setText("Geburtsdatum");

		birthDay = new DateTime(grpPersonAngaben, SWT.DATE | SWT.MEDIUM | SWT.BORDER | SWT.DROP_DOWN);
		birthDay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.paintBordersFor(birthDay);
		birthDay.setBackground(SWTResourceManager.getColor(240, 230, 140));

		Label lblSterbedatum = new Label(grpPersonAngaben, SWT.NONE);
		toolkit.adapt(lblSterbedatum, true, true);
		lblSterbedatum.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		lblSterbedatum.setText("Sterbedatum");

		dieDay = new DateTime(grpPersonAngaben, SWT.DATE | SWT.MEDIUM | SWT.BORDER | SWT.DROP_DOWN);
		toolkit.adapt(dieDay);
		dieDay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.paintBordersFor(dieDay);
		
		Label lblNewLabel_5 = new Label(grpPersonAngaben, SWT.NONE);
		toolkit.adapt(lblNewLabel_5, true, true);
		lblNewLabel_5.setText("Geburtsort");
		
		birthCityText = new Text(grpPersonAngaben, SWT.BORDER);
		birthCityText.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		birthCityText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		birthCityText.setBackground(SWTResourceManager.getColor(240, 230, 140));

		Label lblBeruf = new Label(grpPersonAngaben, SWT.NONE);
		toolkit.adapt(lblBeruf, true, true);
		lblBeruf.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		lblBeruf.setText("Beruf");

		professionText = new Text(grpPersonAngaben, SWT.BORDER);
		professionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		professionText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		
		Label familieTestLabel = new Label(grpPersonAngaben, SWT.NONE);
		toolkit.adapt(familieTestLabel, true, true);
		familieTestLabel.setText("Familienstatus");
		
		WidgetFactory.createPersonFamiliyState(grpPersonAngaben, toolkit);


		
		
		


		Label lblPartnerAngaben = new Label(grpPersonAngaben, SWT.NONE);
		lblPartnerAngaben.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		toolkit.adapt(lblPartnerAngaben, true, true);
		lblPartnerAngaben.setText("Partner Angaben");
		new Label(grpPersonAngaben, SWT.NONE);

		Label lblPartnerName = new Label(grpPersonAngaben, SWT.NONE);
		toolkit.adapt(lblPartnerName, true, true);
		lblPartnerName.setText("Partner Name");

		partnerNameText = new Text(grpPersonAngaben, SWT.BORDER);
		partnerNameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		partnerNameText.setBackground(SWTResourceManager.getColor(240, 230, 140));

		Label lblPartnerVorname = new Label(grpPersonAngaben, SWT.WRAP);
		toolkit.adapt(lblPartnerVorname, true, true);
		lblPartnerVorname.setText("Partner Vorname");

		partnerFirstNameText = new Text(grpPersonAngaben, SWT.BORDER);
		partnerFirstNameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		partnerFirstNameText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		
		Label lblGeburtsdatum_1 = new Label(grpPersonAngaben, SWT.NONE);
		toolkit.adapt(lblGeburtsdatum_1, true, true);
		lblGeburtsdatum_1.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		lblGeburtsdatum_1.setText("Geburtsdatum");

		partnerBirthDay = new DateTime(grpPersonAngaben, SWT.DATE | SWT.MEDIUM | SWT.BORDER | SWT.DROP_DOWN);
		partnerBirthDay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		Label lblBeruf_1 = new Label(grpPersonAngaben, SWT.NONE);
		toolkit.adapt(lblBeruf_1, true, true);
		lblBeruf_1.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		lblBeruf_1.setText("Partner Beruf");

		partnerProfessionText = new Text(grpPersonAngaben, SWT.BORDER);
		partnerProfessionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		partnerProfessionText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		
		Label lblNewLabel_1 = new Label(grpPersonAngaben, SWT.NONE);
		toolkit.adapt(lblNewLabel_1, true, true);
		lblNewLabel_1.setText("Stra\u00DFe Hausnummer");
		
		Composite cPartnerAdressStreetHouseNr = WidgetFactory.createAddressComposite(grpPersonAngaben);
		
		partnerStreetText = new Text(cPartnerAdressStreetHouseNr, SWT.BORDER);
		partnerStreetText.setForeground(SWTResourceManager.getColor(0, 0, 0));
		partnerStreetText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		GridData gd_partnerStreet = new GridData(SWT.RIGHT, SWT.RIGHT, false, false, 1, 1);
		gd_partnerStreet.widthHint = 178;
		partnerStreetText.setLayoutData(gd_partnerStreet);		
		partnerHouseNrText = new Text(cPartnerAdressStreetHouseNr, SWT.BORDER);
		partnerHouseNrText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		GridData gd_partnerHouseNr = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_partnerHouseNr.widthHint = 53;
		
		Label lblStadt = new Label(grpPersonAngaben, SWT.NONE);
		toolkit.adapt(lblStadt, true, true);
		lblStadt.setText("Stadt Postleitzahl");		
		Composite cPartnerCityZip = WidgetFactory.createAddressComposite(grpPersonAngaben);
		partnerCityText = new Text(cPartnerCityZip, SWT.BORDER);
		partnerCityText.setBackground(SWTResourceManager.getColor(240, 230, 140));
		partnerCityText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		GridData gd_Partnerstreet = new GridData(SWT.RIGHT, SWT.RIGHT, false, false, 1, 1);
		gd_Partnerstreet.widthHint = 178;
		partnerCityText.setLayoutData(gd_Partnerstreet);		
		partnerZIPText = new Text(cPartnerCityZip, SWT.BORDER);
		partnerZIPText.setBackground(SWTResourceManager.getColor(240, 230, 140));		
		GridData gd_partnerZIP = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_partnerZIP.widthHint = 53;
		person = order.getPerson();
		initDataBindingContext();
		
		
	}
	


	@Override
	protected DataBindingContext initDataBindingContext() {
		
		IObservableValue decedeNameWidget = SWTObservables.observeText(nameText, SWT.Modify);
		IObservableValue decedeLastNameValue = PojoProperties.value("lastname").observe(order.getPair().getPerson());
		
		IObservableValue decedeFirstNameWidget = SWTObservables.observeText(firstnameText, SWT.Modify);
		IObservableValue decedeFirstNameValue = PojoProperties.value("firstname").observe(order.getPair().getPerson());
		
		IObservableValue streetWidget = SWTObservables.observeText(streetText, SWT.Modify);
		IObservableValue streetValue = PojoProperties.value("street").observe(order.getPair().getPerson().getAddresse()); 
		
		IObservableValue houseNumberWidget = SWTObservables.observeText(houseNumberText, SWT.Modify);
		IObservableValue houseNumberValue = PojoProperties.value("houseNumber").observe(order.getPair().getPerson().getAddresse()); 
		
		IObservableValue cityTextNameWidget = SWTObservables.observeText(cityText, SWT.Modify);
		IObservableValue cityTextValue = PojoProperties.value("city").observe(order.getPair().getPerson().getAddresse()); 
		
		IObservableValue zipWidget = SWTObservables.observeText(zipText, SWT.Modify);
		IObservableValue zipValue = PojoProperties.value("zip").observe(order.getPair().getPerson().getAddresse()); 
		
		IObservableValue birthCityTextWidget = SWTObservables.observeText(birthCityText, SWT.Modify);
		IObservableValue birthCityTextValue = PojoProperties.value("birthCity").observe(order.getPair().getPerson()); 
		
		IObservableValue professionWidget = SWTObservables.observeText(professionText, SWT.Modify);
		IObservableValue professionValue = PojoProperties.value("profession").observe(order.getPair().getPerson()); 
		
		
		
		
		IObservableValue birthDayValue = PojoProperties.value("birthday").observe(order.pair.getPerson()); 
		IObservableValue dieDayValue = PojoProperties.value("decedDay").observe(order.pair.getPerson()); 
		
		IObservableValue txtPartnernameWidget = SWTObservables.observeText(partnerNameText, SWT.Modify);
		IObservableValue txtPartnernameValue = PojoProperties.value("lastname").observe(order.pair.getPartner()); 
		
		IObservableValue partnerFirstNameWidget = SWTObservables.observeText(partnerFirstNameText, SWT.Modify);
		IObservableValue partnerFirstNameValue = PojoProperties.value("firstname").observe(order.pair.getPartner()); 
		
		IObservableValue partnerProfessionWidget = SWTObservables.observeText(partnerProfessionText, SWT.Modify);
		IObservableValue partnerProfessionValue = PojoProperties.value("profession").observe(order.pair.getPartner()); 
		IObservableValue partnerStreetWidget = SWTObservables.observeText(partnerStreetText, SWT.Modify);
		IObservableValue partnerStreetValue = PojoProperties.value("street").observe(order.getPair().getPartner().getAddresse()); 
		
		IObservableValue partnerHouseNumberWidget = SWTObservables.observeText(partnerHouseNrText, SWT.Modify);
		IObservableValue partnerHouseNumberValue = PojoProperties.value("houseNumber").observe(order.getPair().getPartner().getAddresse()); 
		
		IObservableValue partnerCityTextNameWidget = SWTObservables.observeText(partnerCityText, SWT.Modify);
		IObservableValue partnerCityTextValue = PojoProperties.value("city").observe(order.getPair().getPartner().getAddresse()); 
		
		IObservableValue partnerZipWidget = SWTObservables.observeText(partnerZIPText, SWT.Modify);
		IObservableValue partnerZipValue = PojoProperties.value("zip").observe(order.getPair().getPartner().getAddresse()); 
		
		
		IObservableValue partnerBirthDayValue = PojoProperties.value("birthday").observe(order.pair.getPartner()); 
		dbc.bindValue(WidgetProperties.selection().observe(partnerBirthDay),partnerBirthDayValue);
		dbc.bindValue(WidgetProperties.selection().observe(partnerBirthDay),partnerBirthDayValue);
		dbc.bindValue(partnerStreetWidget, partnerStreetValue);
		dbc.bindValue(partnerHouseNumberWidget, partnerHouseNumberValue);
		dbc.bindValue(partnerCityTextNameWidget, partnerCityTextValue);
		dbc.bindValue(partnerZipWidget, partnerZipValue);
		
		dbc.bindValue(WidgetProperties.selection().observe(birthDay),birthDayValue);
		dbc.bindValue(WidgetProperties.selection().observe(dieDay),dieDayValue);
		
		
		
		
		dbc.bindValue(decedeNameWidget, decedeLastNameValue);
		dbc.bindValue(decedeFirstNameWidget, decedeFirstNameValue);
		dbc.bindValue(streetWidget, streetValue);
		dbc.bindValue(houseNumberWidget, houseNumberValue);
		dbc.bindValue(cityTextNameWidget, cityTextValue);
		dbc.bindValue(zipWidget, zipValue);
		
		dbc.bindValue(birthCityTextWidget, birthCityTextValue);
		
		dbc.bindValue(professionWidget, professionValue);
		
		dbc.bindValue(txtPartnernameWidget, txtPartnernameValue);
		
		dbc.bindValue(partnerFirstNameWidget, partnerFirstNameValue);
		dbc.bindValue(partnerProfessionWidget, partnerProfessionValue);
		return dbc;
		
		
	}
	
	public PersonData getPerson() {
		return person;
	}
	public void setPerson(PersonData person) {
		this.person = person;		
	}
	
	public WorkOrder getOrder() {
		return super.getOrder();
	}
	public void setOrder(WorkOrder order) {		
		super.setOrder(order);
		dbc = initDataBindingContext();
	}
	
	

}
