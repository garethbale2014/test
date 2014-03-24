package de.rs.test.prototype.mail;

import java.util.ArrayList;


import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;

import de.rs.prototype.firdaous.handler.BestatterAuftragHandler;
import de.rs.prototype.firdaous.handler.CallEditor;
import de.rs.prototype.firdaous.handler.DataLoaderHandler;
import de.rs.prototype.firdaous.handler.PersonEditorHandler;

public class NavigationView extends ViewPart {
	public static final String ID = "de.rs.test.prototype.mail.navigationView";
	private TreeViewer viewer;

	class TreeObject {
		private String name;
		private TreeParent parent;

		public TreeObject(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setParent(TreeParent parent) {
			this.parent = parent;
		}

		public TreeParent getParent() {
			return parent;
		}

		public String toString() {
			return getName();
		}
	}

	class TreeParent extends TreeObject {
		private ArrayList children;

		public TreeParent(String name) {
			super(name);
			children = new ArrayList();
		}

		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}

		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}

		public TreeObject[] getChildren() {
			return (TreeObject[]) children.toArray(new TreeObject[children.size()]);
		}

		public boolean hasChildren() {
			return children.size() > 0;
		}
	}

	class ViewContentProvider implements IStructuredContentProvider, ITreeContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			return getChildren(parent);
		}

		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject) child).getParent();
			}
			return null;
		}

		public Object[] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent) parent).getChildren();
			}
			return new Object[0];
		}

		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent) parent).hasChildren();
			return false;
		}
	}

	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			return obj.toString();
		}

		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof TreeParent) {
				if (String.valueOf(obj).equals("Behörden")) {
					String userIcon = "icons/Hopstarter-Scrap-Library.ico";
					return Activator.getImageDescriptor(userIcon).createImage();
				} else if (String.valueOf(obj).equals("Sterbeurkunde Formulare")) {
					String userIcon = "icons/Awicons-Vista-Artistic-Office-building.ico";
					return Activator.getImageDescriptor(userIcon).createImage();
				}
				if (String.valueOf(obj).equals("Geplannte Features")) {
					// String userIcon = "/icons/forms.ico";
					return Activator.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK).createImage();

				}
				if (String.valueOf(obj).equals("Personen Daten")) {
					String userIcon = "icons/users.ico";
					return Activator.getImageDescriptor(userIcon).createImage();

				}

				imageKey = ISharedImages.IMG_OBJ_FOLDER;
				return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
			} else {

				if (String.valueOf(obj).equals("Standesamt Formular")) {
					String userIcon = "icons/box_red.ico";
					return Activator.getImageDescriptor(userIcon).createImage();

				}
				if (String.valueOf(obj).equals("Daten Bestand")) {
					String userIcon = "icons/gameboard.gif";
					return Activator.getImageDescriptor(userIcon).createImage();

				}
				

				if (String.valueOf(obj).equals("Personen Ansicht")) {
					String userIcon = "icons/users.ico";
					return Activator.getImageDescriptor(userIcon).createImage();

				}
				if (String.valueOf(obj).equals("Anlage zum Sterbefall")) {
					String userIcon = "icons/attachment_48_48.ico";
					return Activator.getImageDescriptor(userIcon).createImage();

				} else if (String.valueOf(obj).equals("Bestattungsauftrag")) {
					String userIcon = "icons/BestatterAuftrag.ico";
					return Activator.getImageDescriptor(userIcon).createImage();

				} else if (String.valueOf(obj).equals("Behörden")) {
					String userIcon = "icons/Hopstarter-Scrap-Library.ico";
					return Activator.getImageDescriptor(userIcon).createImage();

				}
			}
			if (String.valueOf(obj).equals("Krankenhaus")) {
				String userIcon = "icons/clinic.ico";
				return Activator.getImageDescriptor(userIcon).createImage();

			}
			if (String.valueOf(obj).equals("Polizei")) {
				String userIcon = "icons/police.ico";
				return Activator.getImageDescriptor(userIcon).createImage();

			}
			if (String.valueOf(obj).equals("Sozialamt")) {
				String userIcon = "icons/gnome_applications_office.ico";
				return Activator.getImageDescriptor(userIcon).createImage();

			}
			if (String.valueOf(obj).equals("Friedhöfe")) {
				String userIcon = "icons/1392047579_cemetery.png";
				return Activator.getImageDescriptor(userIcon).createImage();

			}
			if (String.valueOf(obj).equals("BehördenFormulareImportieren")) {
				String userIcon = "/icons/forms.ico";
				return Activator.getImageDescriptor(userIcon).createImage();

			}

			return null;

		}
	}

	/**
	 * We will set up a dummy model to initialize tree heararchy. In real code,
	 * you will connect to a real model and expose its hierarchy.
	 */
	private TreeObject createDummyModel() {

		TreeParent formulare = new TreeParent("Sterbeurkunde Formulare");

		TreeObject decedeNodeForm = new TreeObject("Anlage zum Sterbefall");
		TreeObject bestatterAuftragForm = new TreeObject("Bestattungsauftrag");
		TreeObject standesamtForm = new TreeObject("Standesamt Formular");
		TreeObject databaseRows = new TreeObject("Daten Bestand");
		//TreeObject personNode = new TreeObject("Personendaten Erfassen");
		TreeParent pesonen = new TreeParent("Personen Daten");
		//pesonen.addChild(personNode);

		formulare.addChild(databaseRows);
		formulare.addChild(decedeNodeForm);
		formulare.addChild(bestatterAuftragForm);
		formulare.addChild(standesamtForm);
		formulare.addChild(pesonen);

		TreeParent offices = new TreeParent("Behörden");

		TreeObject K = new TreeObject("Krankenhaus");
		TreeObject P = new TreeObject("Polizei");
		TreeObject S = new TreeObject("Sozialamt");
		TreeObject F = new TreeObject("Friedhöfe");

		offices.addChild(K);
		offices.addChild(P);
		offices.addChild(S);
		offices.addChild(F);

		TreeParent additionalFeatues = new TreeParent("Geplannte Features");
		TreeObject behoerdenFormulareImportieren = new TreeObject("BehördenFormulareImportieren");
		additionalFeatues.addChild(behoerdenFormulareImportieren);

		TreeParent root = new TreeParent("");
		root.addChild(formulare);
		root.addChild(offices);
		root.addChild(additionalFeatues);
		return root;
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setInput(createDummyModel());

		viewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
				TreeObject treeObject = (TreeObject) selection.getFirstElement();
				if (treeObject.getParent() != null && treeObject.getName().equals("Personen Daten")) {
					IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
					String commandID = PersonEditorHandler.ID;
					try {
						handlerService.executeCommand(commandID, null);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else if (treeObject.getParent() != null && treeObject.getName().equals("Bestattungsauftrag")) {
					IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
					String commandID = BestatterAuftragHandler.id;
					try {
						handlerService.executeCommand(commandID, null);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					
				
				}
				else if (treeObject.getParent() != null && treeObject.getName().equals("Daten Bestand")) {
					IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
					String commandID = DataLoaderHandler.id;
					try {
						handlerService.executeCommand(commandID, null);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

				else {
					IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
					String commandID = CallEditor.id;
					try {
						handlerService.executeCommand(commandID, null);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}
		});
		
		viewer.expandAll();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}