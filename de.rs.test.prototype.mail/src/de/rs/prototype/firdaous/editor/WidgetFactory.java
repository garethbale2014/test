package de.rs.prototype.firdaous.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

public final class WidgetFactory {
	
	
	public static Composite createAddressComposite(Composite compositeParent){
		
		
		
		final Composite groupComposite = new Composite(compositeParent, SWT.NONE);
		groupComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		final GridLayout gridLayout = new GridLayout(2,false);
		gridLayout.marginWidth = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		groupComposite.setLayout(gridLayout);
		return groupComposite;
	}
	
	
	
	public static Composite createPersonFamiliyState(Composite personComposite, FormToolkit toolkit){
		//final SashForm personSashForm = new SashForm(sashForm, SWT.VERTICAL);
	final Composite groupComposite = new Composite(personComposite, SWT.NONE);
	groupComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
	final GridLayout gridLayout = new GridLayout(6,false);
	gridLayout.marginWidth = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;
	groupComposite.setLayout(gridLayout);
	
	
	
	
	
	
	
	//Composite compositeFamilyState = WidgetFactory.createPersonFamiliyState(grpPersonAngaben);
	toolkit.adapt(groupComposite, true, true);
	
	
	Label lblLedig = new Label(groupComposite, SWT.NONE);
	toolkit.adapt(lblLedig, true, true);
	lblLedig.setText("Ledig");

	Button ledig = new Button(groupComposite, SWT.RADIO);
	toolkit.adapt(ledig, true, true);

	Label lblNewLabel_3 = new Label(groupComposite, SWT.NONE);
	toolkit.adapt(lblNewLabel_3, true, true);
	lblNewLabel_3.setText("Verheiratet");

	Button verheiratet = new Button(groupComposite, SWT.RADIO);
	toolkit.adapt(verheiratet, true, true);

	Label lblGeschieden = new Label(groupComposite, SWT.NONE);
	toolkit.adapt(lblGeschieden, true, true);
	lblGeschieden.setText("Geschieden");

	Button devorced = new Button(groupComposite, SWT.RADIO);
	toolkit.adapt(devorced, true, true);

	Label lblVerwitwet = new Label(groupComposite, SWT.NONE);
	toolkit.adapt(lblVerwitwet, true, true);
	lblVerwitwet.setText("Verwitwet");

	Button verwitwet = new Button(groupComposite, SWT.RADIO);
	toolkit.adapt(verwitwet, true, true);

	Label lblUnbekannt = new Label(groupComposite, SWT.NONE);
	toolkit.adapt(lblUnbekannt, true, true);
	lblUnbekannt.setText("Unbekannt");
	Button unknowed = new Button(groupComposite, SWT.RADIO);
	toolkit.adapt(unknowed, true, true);
	
	
	
	
	return groupComposite;
	

	
	}

}
