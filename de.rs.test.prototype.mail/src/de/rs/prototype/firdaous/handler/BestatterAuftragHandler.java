package de.rs.prototype.firdaous.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import de.rs.prototype.firdaous.editor.BestatterAuftragEditor;
import de.rs.prototype.firdaous.editor.BestatterAuftragEditorInput;

public class BestatterAuftragHandler extends AbstractHandler {

	
	public static final String id = "de.rs.rcp.editor.BestatterAuftragHandler";
	
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		BestatterAuftragEditorInput input = new BestatterAuftragEditorInput(System.currentTimeMillis());

		try {
			IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);

			IWorkbenchPage page = window.getActivePage();

			page.openEditor(input, BestatterAuftragEditor.ID);

		} catch (PartInitException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

}
