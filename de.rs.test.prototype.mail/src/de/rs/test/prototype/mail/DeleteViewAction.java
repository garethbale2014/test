package de.rs.test.prototype.mail;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;

public class DeleteViewAction extends Action {

	private final IWorkbenchWindow window;
	private int instanceNum = 0;
	private final String viewId;
	public DeleteViewAction( IWorkbenchWindow window, String label, String viewId) {
		this.window = window;
		this.viewId = viewId;
        setText(label);
        // The id is used to refer to the action in a menu or toolbar
		setId(ICommandIds.CMD_OPEN);
        // Associate the action with a pre-defined command, to allow key bindings.
		setActionDefinitionId(ICommandIds.CMD_OPEN);
		setImageDescriptor(de.rs.test.prototype.mail.Activator.getImageDescriptor("/icons/delete.ico"));
	
	}

}
