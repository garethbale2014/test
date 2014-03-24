package de.rs.prototype.firdaous.editor;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;

import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import de.rs.prototype.firdaous.model.PresentationWorkOrder;
import de.rs.prototype.firdaous.model.WorkOrder;

public class EntryComposite extends EditorComposite {
	private Text projectIdText;
	private Text userName;
	private DateTime projectCreateDate;



	public EntryComposite(Composite composite, FormToolkit toolkit, Long projectId) {
		super(projectId);

		final SashForm sashForm = new SashForm(composite, SWT.HORIZONTAL);

		GridLayout layout2 = new GridLayout(2, false);
		layout2.marginWidth = 0;
		layout2.verticalSpacing = 0;
		layout2.marginHeight = 0;
		layout2.horizontalSpacing = 0;
		layout2.marginBottom = 0;
		composite.setLayout(layout2);

		Group grpPersonAngaben = new Group(composite, SWT.NONE);
		grpPersonAngaben.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		grpPersonAngaben.setText("Antrag Information");
		GridData gd_grpPersonAngaben = new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 2);
		grpPersonAngaben.setLayoutData(gd_grpPersonAngaben);
		toolkit.adapt(grpPersonAngaben);
		toolkit.paintBordersFor(grpPersonAngaben);
		grpPersonAngaben.setLayout(new GridLayout(2, true));

		grpPersonAngaben.setLayoutData(gd_grpPersonAngaben);
		Label lblKrankenhaus = new Label(grpPersonAngaben, SWT.NONE);
		lblKrankenhaus.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(lblKrankenhaus, true, true);
		lblKrankenhaus.setText("Auftrag Nummer");

		GridData gd_lblKrankenhaus = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_lblKrankenhaus.widthHint = 258;
		lblKrankenhaus.setLayoutData(gd_lblKrankenhaus);
		projectIdText = new Text(grpPersonAngaben, SWT.BORDER);
		GridData gd_txtClinicname = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_txtClinicname.widthHint = 248;
		projectIdText.setLayoutData(gd_txtClinicname);
		projectIdText.setBackground(SWTResourceManager.getColor(240, 230, 140));

		Label lblAnsprechPartner = new Label(grpPersonAngaben, SWT.NONE);
		lblAnsprechPartner.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(lblAnsprechPartner, true, true);
		lblAnsprechPartner.setText("Bearbeiter");
		userName = new Text(grpPersonAngaben, SWT.BORDER);
		GridData gd_txtansprechPartnerText = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_txtansprechPartnerText.widthHint = 248;
		userName.setLayoutData(gd_txtansprechPartnerText);
		userName.setBackground(SWTResourceManager.getColor(240, 230, 140));

		Label lblAuftragDatum = new Label(grpPersonAngaben, SWT.NONE);
		lblAuftragDatum.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		toolkit.adapt(lblAuftragDatum, true, true);
		lblAuftragDatum.setText("Auftragdatum");
		projectCreateDate = new DateTime(grpPersonAngaben, SWT.DATE | SWT.MEDIUM | SWT.BORDER | SWT.DROP_DOWN);
		GridData gd_txtlblAuftragDatum = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_txtlblAuftragDatum.widthHint = 265;
		projectCreateDate.setLayoutData(gd_txtlblAuftragDatum);
		projectCreateDate.setBackground(SWTResourceManager.getColor(240, 230, 140));

	}

	@Override
	protected DataBindingContext initDataBindingContext() {
		IObservableValue userNameWidget = SWTObservables.observeText(userName, SWT.Modify);
		IObservableValue userNameValue = PojoProperties.value("userName").observe(order);
		IObservableValue entryNumberWidget = SWTObservables.observeText(projectIdText, SWT.Modify);
		IObservableValue projectIdValue = PojoProperties.value("projectId").observe(order);
		dbc.bindValue(userNameWidget, userNameValue);
		dbc.bindValue(entryNumberWidget, projectIdValue);
		return dbc;

	}

	public void setOrder(WorkOrder order) {

		super.setOrder(order);
		dbc = initDataBindingContext();
	}
}
