package de.rs.test.prototype.mail;

import java.io.IOException;
import java.util.Calendar;

import javax.xml.bind.JAXBException;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import de.rs.firdaous.xml.service.IXMLService;
import de.rs.firdaous.xml.service.ProjectList;
import de.rs.firdaous.xml.service.XMLService;
import de.rs.prototype.firdaous.model.Address;
import de.rs.prototype.firdaous.model.Clinic;
import de.rs.prototype.firdaous.model.Country;
import de.rs.prototype.firdaous.model.FamillyState;
import de.rs.prototype.firdaous.model.Pair;
import de.rs.prototype.firdaous.model.PersonData;
import de.rs.prototype.firdaous.model.PhoneNumber;
import de.rs.prototype.firdaous.model.Police;
import de.rs.prototype.firdaous.model.PresentationWorkOrder;
import de.rs.prototype.firdaous.model.WorkOrder;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	
	
	
	// The plug-in ID
	public static final String PLUGIN_ID = "de.rs.test.prototype.mail"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	IXMLService xmlService = XMLService.getxmlService();
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		//bindingContext = new DataBindingContext();
		initData();
	}

	private void initData() {
		
		PresentationWorkOrder order = PresentationWorkOrder.getInstance();
	
	try {
		
		ProjectList list = xmlService.loadProjectList();
		for(WorkOrder workOrder : list.getProjectList()){
			
			order.getOrders().put(workOrder.projectId, workOrder);
		}
	} catch (IOException e) {
		
		e.printStackTrace();
	} catch (JAXBException e) {
		
		e.printStackTrace();
	}
	
		
		
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
	
}
