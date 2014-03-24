package de.rs.prototype.firdaous.editor;

import java.beans.EventSetDescriptor;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.OleControlSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.ole.win32.Variant;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.EditorPart;
import org.osgi.framework.Bundle;
import org.xml.sax.SAXException;

import de.rs.auxiliary.PdfReaderUtils;
import de.rs.prototype.firdaous.handler.CallEditor;
import de.rs.test.prototype.mail.Activator;

public class BestatterAuftragEditor extends EditorPart {

	public static String ID = "de.rs.rcp.editor.BestatterAuftragEditor";

	private BestatterAuftragEditorInput input;

	private Browser browser;

	// String fileName = "./resources/Anlage zum Sterbefall.pdf";

	String fileName = "C:\\Users\\r.sahili\\Java Development\\MyDevelopment\\Workspace Firdaous 4\\test.rcp.pdf.oleframe\\Anlage zum Sterbefall.pdf";

	OleAutomation oleAutomation;

	OleClientSite clientSite;
	OleFrame oleFrame;
	boolean createClientSite = true;
	OleAutomation automation;
	File file = new File(fileName);
	private Variant result;

	private class ActionNewEntry extends Action {
		public ActionNewEntry() {
			setImageDescriptor(Activator.getImageDescriptor("/icons/sample2.gif"));

		}

		@Override
		public void run() {
			Bundle plugin = Activator.getDefault().getBundle();
			IPath relativePagePath = new Path("./resources/BestattungsauftragLeistungsnachweis.pdf");
			file = relativePagePath.toFile();
			URL fileInPlugin = FileLocator.find(plugin, relativePagePath, null);
			URL pageUrl;
			try {
				pageUrl = FileLocator.toFileURL(fileInPlugin);

				scanFields(fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}

			IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
			String commandID = CallEditor.id;
			try {
				handlerService.executeCommand(commandID, null);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private class ActionSave extends Action {
		public ActionSave() {
			setImageDescriptor(Activator.getImageDescriptor("/icons/save.ico"));

		}

		@Override
		public void run() {
			Bundle plugin = Activator.getDefault().getBundle();
			// IPath relativePagePath = new
			// Path("./resources/BestattungsauftragLeistungsnachweis.pdf");
			IPath relativePagePath = new Path("./resources/Anlage zum Sterbefall.pdf");
			URL fileInPlugin = FileLocator.find(plugin, relativePagePath, null);
			URL pageUrl;
			try {

				pageUrl = FileLocator.toFileURL(fileInPlugin);

				OleAutomation automation = new OleAutomation(clientSite);

				// looks up the ID for method Select.

				if (clientSite.isDirty()) {
					File tempFile = new File(file.getAbsolutePath() + ".tmp");
					boolean saveIsOk = clientSite.save(file, true);
					file.renameTo(tempFile);

					if (clientSite.save(file, true)) {
						// save was successful so discard the backup
						tempFile.delete();
					} else {
						// save failed so restore the backup
						tempFile.renameTo(file);
					}
				}

				scanFields(pageUrl.getFile());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private FormToolkit toolkit;

	private ScrolledForm form;

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		if (!(input instanceof BestatterAuftragEditorInput)) {
			throw new RuntimeException("Wrong input");
		}
		this.input = (BestatterAuftragEditorInput) input;
		setSite(site);
		setInput(input);
		setPartName("Bestattungsauftrag / Leistungsnachweis.pdf");

	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {

		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		form = toolkit.createScrolledForm(parent);
		form.getToolBarManager().add(new ActionNewEntry());
		form.getToolBarManager().add(new ActionSave());
		form.getToolBarManager().update(true);

		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.horizontalSpacing = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginBottom = 0;
		form.getBody().setLayout(layout);
		form.setText("Erfassung der Auftragangaben");

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

		openBrowserSWT();

		// openOleFramePDF(parent);

	}

	private void openBrowserSWT() {
		Bundle plugin = Activator.getDefault().getBundle(); // Where Activator
		// is my
		// org.eclipse.core.runtime.Plugin

		IPath relativePagePath = new Path("./resources/Anlage zum Sterbefall.pdf");
		URL fileInPlugin = FileLocator.find(plugin, relativePagePath, null);
		URL pageUrl;
		try {
			pageUrl = FileLocator.toFileURL(fileInPlugin);

			if (clientSite == null) {
				try {
					Composite editorComposite = form.getBody();
					// final SashForm sashForm = new SashForm(editorComposite, SWT.HORIZONTAL);
					final GridLayout gridLayout = new GridLayout();
					gridLayout.marginWidth = 0;
					gridLayout.verticalSpacing = 0;
					gridLayout.marginHeight = 0;
					gridLayout.marginBottom = 0;
					editorComposite.setLayout(new FillLayout());
					Composite personCenter = new Composite(editorComposite, SWT.FILL);
					personCenter.setLayout(new FillLayout());
					oleFrame = new OleFrame(personCenter, SWT.NONE);
					clientSite = createSite(oleFrame, "Shell.Explorer");

					OleAutomation explorer = new OleAutomation(clientSite);

					int[] navigate = explorer.getIDsOfNames(new String[] { "Navigate" });

					if (navigate != null) {
						result = explorer.invoke(navigate[0], new Variant[] { new Variant(fileName) });
						if (result == null)
							disposeClient();
						else
							result.dispose();
					} else {
						disposeClient();
					}
					explorer.dispose();
				} catch (SWTException error2) {
					disposeClient();
				}
			}

			if (clientSite != null) {
				clientSite.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void dispose() {
		automation.dispose();
		automation = null;
		super.dispose();
	}

	// other methods omitted here

	// private void openOleFramePDF(Composite parent){
	// Composite editorComposite = form.getBody();
	// final SashForm sashForm = new SashForm(editorComposite, SWT.HORIZONTAL);
	// final GridLayout gridLayout = new GridLayout();
	// gridLayout.marginWidth = 0;
	// gridLayout.verticalSpacing = 0;
	// gridLayout.marginHeight = 0;
	// gridLayout.marginBottom = 0;
	// editorComposite.setLayout(new FillLayout());
	//
	// //final SashForm personSashForm = new SashForm(sashForm, SWT.VERTICAL);
	//
	// Bundle plugin = Activator.getDefault().getBundle();
	// IPath relativePagePath = new Path("./resources/test.xlsx");
	// URL fileInPlugin = FileLocator.find(plugin, relativePagePath, null);
	// URL pageUrl;
	// try {
	// pageUrl = FileLocator.toFileURL(fileInPlugin);
	//
	//
	// // final Composite personCenter = new Composite(editorComposite,
	// SWT.FILL);
	// // personCenter.setLayout(new GridLayout());
	// //Button excelButton = new Button(personCenter, SWT.RADIO);
	//
	// //Composite parent = new Composite(editorComposite, SWT.NONE);
	// // Composite displayArea = new Composite(parent, SWT.BORDER);
	// // displayArea.setLayout(new FillLayout());
	// // displayArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
	// 3, 1));
	//
	// //oleFrame = new OleFrame(displayArea, SWT.NONE);
	//
	//
	//
	// oleFrame = new OleFrame(parent , SWT.NONE);
	// clientSite = new OleControlSite(oleFrame, SWT.NONE, "Excel.Sheet");
	// clientSite.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);
	//
	// // try {
	// // clientSite = createSite(oleFrame, "Excel.Sheet");
	// // clientSite.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);
	// // OleAutomation pdf = new OleAutomation (clientSite);
	// // int loadFile[] = pdf.getIDsOfNames (new String [] {"LoadFile"});
	// // if (loadFile != null) {
	// // Variant result = pdf.invoke(loadFile[0], new Variant[] {new
	// Variant(pageUrl.getFile())});
	// // if (result == null)
	// // disposeClient();
	// // else
	// // result.dispose();
	// // } else {
	// // disposeClient();
	// // }
	// // pdf.dispose();
	// // } catch (SWTException error2) {
	// // error2.printStackTrace();
	// // disposeClient();
	// // }
	//
	// if (clientSite == null) {
	// try {
	// clientSite = createSite(oleFrame, "PDF.PdfCtrl.5");
	//
	// OleAutomation explorer = new OleAutomation(clientSite);
	//
	// int[] navigate = explorer.getIDsOfNames(new String[]{"Navigate"});
	//
	// if (navigate != null) {
	// Variant result = explorer.invoke(navigate[0], new Variant[] {new
	// Variant(pageUrl.getFile())});
	// if (result == null)
	// disposeClient();
	// else
	// result.dispose();
	// } else {
	// disposeClient();
	// }
	// explorer.dispose();
	// } catch (SWTException error2) {
	// error2.printStackTrace();
	// disposeClient();
	// }
	// }
	//
	//
	//
	// }catch (Exception e) {
	//
	// e.printStackTrace();
	// }
	//
	//
	//
	//
	// if (clientSite != null){
	// clientSite.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);
	// }
	// }

	private void openBrowser() throws ParserConfigurationException, SAXException {
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

		browser = new Browser(personCenter, SWT.NONE);

		Bundle plugin = Activator.getDefault().getBundle(); // Where Activator
															// is my
															// org.eclipse.core.runtime.Plugin

		IPath relativePagePath = new Path("./resources/Anlage zum Sterbefall.pdf");
		URL fileInPlugin = FileLocator.find(plugin, relativePagePath, null);
		URL pageUrl;
		try {
			pageUrl = FileLocator.toFileURL(fileInPlugin);

			browser.setUrl(pageUrl.toString());

			// scanFields(pageUrl.getFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	OleClientSite createSite(OleFrame frame, String progID) {
		if (createClientSite) {
			return new OleClientSite(frame, SWT.NONE, progID);
		} else {
			return new OleControlSite(frame, SWT.NONE, progID);
		}
	}

	void disposeClient() {
		if (clientSite != null)
			clientSite.dispose();
		clientSite = null;
	}

	public static void scanFields(String path) throws IOException, ParserConfigurationException, SAXException {
		PdfReaderUtils.scanFields(path);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
