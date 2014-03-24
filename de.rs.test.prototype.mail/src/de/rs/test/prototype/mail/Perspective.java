package de.rs.test.prototype.mail;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	/**
	 * The ID of the perspective as specified in the extension.
	 */
	public static final String ID = "de.rs.test.prototype.mail.perspective";

	public void createInitialLayout(IPageLayout layout) {
		
		
		
		
		
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		
		//layout.addView(NavigationView.ID,  false, IPageLayout.LEFT, 0.35f, editorArea);
		//layout.addStandaloneView(RowsView.ID,  false, IPageLayout.TOP, 0.35f, editorArea);
		//layout.addStandaloneView(SearchView.ID,  false, IPageLayout.LEFT, 0.65f, editorArea);
		//layout.addStandaloneView(NavigationView.ID,  false, IPageLayout.LEFT, 0.35f, editorArea);
		//layout.addStandaloneView(PersonenView.ID,  false, IPageLayout.TOP, 0.35f, editorArea);
//		IFolderLayout folder = layout.createFolder("Query", IPageLayout.TOP, 0.75f, editorArea);
//		folder.addPlaceholder(View.ID + ":*");
//		folder.addView(SearchView.ID);
		
		layout.addView(NavigationView.ID, IPageLayout.LEFT,
				0.35f, layout.getEditorArea());
		layout.addView(RowsView.ID, IPageLayout.TOP,
				0.70f, layout.getEditorArea());
		layout.addView(SearchView.ID, IPageLayout.RIGHT,
				0.40f, layout.getEditorArea());
		
		layout.getViewLayout(NavigationView.ID).setCloseable(false);
		layout.getViewLayout(RowsView.ID).setCloseable(true);
		layout.getViewLayout(SearchView.ID).setCloseable(true);
		//layout.getViewLayout(PersonenView.ID).setCloseable(false);
		
		
		layout.setFixed(true);
	}
	
	
	
	

}
