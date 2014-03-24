package de.rs.prototype.firdaous.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import de.rs.prototype.firdaous.editor.IPersonEditorInput;
import de.rs.prototype.firdaous.editor.PersonEditor;
import de.rs.prototype.utils.TableUtils;

public class PersonEditorHandler extends AbstractHandler {

	public final static String ID = "de.vogella.rcp.editor.example.handler.PersonEditorHandler";
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("called");
	    // get the view
	    IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
	    IWorkbenchPage page = window.getActivePage();
		
	    
	   IPersonEditorInput input = new IPersonEditorInput(""+TableUtils.getCurrentProjectId(window));
	   
        try {
          page.openEditor(input, PersonEditor.ID);
          
          
          
          
          
         
        } catch (PartInitException e) {
          throw new RuntimeException(e);
        }
		return null;
	}

}
