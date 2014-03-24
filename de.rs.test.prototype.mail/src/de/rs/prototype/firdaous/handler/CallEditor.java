package de.rs.prototype.firdaous.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import de.rs.prototype.firdaous.editor.WorkOrderEditor;
import de.rs.prototype.firdaous.editor.WorkOrderEditorInput;
import de.rs.prototype.firdaous.model.PresentationWorkOrder;
import de.rs.prototype.firdaous.model.WorkOrder;
import de.rs.test.prototype.mail.RowsView;

public class CallEditor extends AbstractHandler {

	public static final String id = "de.vogella.rcp.editor.example.openEditor";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		System.out.println("called");
		// get the view
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);

		IWorkbenchPage page = window.getActivePage();
		

		RowsView view = (RowsView) page.findView(RowsView.ID);
		// get the selection
		ISelection selection = view.getSite().getSelectionProvider().getSelection();
		if (selection != null && selection instanceof IStructuredSelection) {
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			// // if we had a selection lets open the editor
			// if (obj != null) {

			PresentationWorkOrder presentationModel = PresentationWorkOrder.getInstance();

			List<Entry<Long, WorkOrder>> entryList = new ArrayList<Map.Entry<Long, WorkOrder>>(presentationModel.getOrders().entrySet());
			// entryList.get(entryList.size() - 1);

			WorkOrder order = (WorkOrder) obj;
			int entryListSie = entryList.size();
			int index = entryList.size() - 1;
			WorkOrder o = (WorkOrder) entryList.get(index).getValue();
			order = (WorkOrder) (order != null ? (WorkOrder) order : new WorkOrder());
			presentationModel.getOrders().put(order.projectId, order);

			int size = presentationModel.getOrders().size();
			presentationModel.getOrders();

			WorkOrderEditorInput input = new WorkOrderEditorInput(order.getProjectId());

			try {

				page.openEditor(input, WorkOrderEditor.ID);

			} catch (PartInitException e) {
				throw new RuntimeException(e);
			}
		}
		// }
		// }

		return null;
	}

	//
	// private void openFile() throws PartInitException{
	// //IFile workspaceFile = IFile."resources/test.pdf");
	// //java.io.File externalFile;
	//
	// //PDF in workspace
	// IEditorInput input ;//= new FileEditorInput(workspaceFile);
	// //or external
	// IFileSystem fs = org.eclipse.core.filesystem.EFS.getLocalFileSystem();
	// File f = new File("c:\\test.pdf");
	// IFileStore fileStore = fs.fromLocalFile(f);
	// input = new FileStoreEditorInput(fileStore);
	//
	// IWorkbenchPage page =
	// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	// page.openEditor(input, //IEditorRegistry.SYSTEM_EXTERNAL_EDITOR_ID);
	// }

}