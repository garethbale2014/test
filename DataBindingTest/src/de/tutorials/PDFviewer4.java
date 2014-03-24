package de.tutorials;
import java.io.File;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.browser.Browser;

public class PDFviewer4
{
    public static void main(String[] args)
    {
        Shell shell = new Shell();

        shell.setSize(500,500);
        shell.setLayout(new FillLayout());

        Label label = new Label(shell, SWT.BORDER);
        label.setText("This is a label.");

        //=======================================
        // TWO WAYS TO DISPLAY A PDF FILE
        //=======================================
        if (args.length > 0)
        {
            // Use a Browser
            Browser browser = new Browser(shell, SWT.NONE);
            browser.setUrl("file://h:/test.pdf");
        }
        else
        {
            // Use OLE 
            OleFrame frame = new OleFrame(shell, SWT.BORDER);
            OleClientSite site;
            site = new OleClientSite(frame, SWT.BORDER, new File("./resources/Unbenannt.pdf"));            
            //site.doVerb(OLE.OLEIVERB_HIDE);    // hide the external PDF window
        }

        shell.open();

        while (shell != null && !shell.isDisposed())
        {
            if (!shell.getDisplay().readAndDispatch())
            {
                shell.getDisplay().sleep();
            }
        }
    }
}