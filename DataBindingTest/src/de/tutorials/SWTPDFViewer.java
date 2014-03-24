package de.tutorials;
 
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.ole.win32.Variant;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
 
/**
 * @author Administrator
 * 
 */
public class SWTPDFViewer {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
 
        shell.setText("SWTPDFViewer");
        shell.setLayout(new FillLayout());
 
        OleFrame frm = new OleFrame(shell, SWT.NONE);
 
        OleClientSite site = new OleClientSite(frm, SWT.NONE, "PDF.PdfCtrl.6");
        OleAutomation auto = new OleAutomation(site);
 
        shell.open();
 
        int[] rgdispid = auto.getIDsOfNames(new String[] { "LoadFile" });
        int dispIdMember = rgdispid[0];
 
        Variant[] rgvarg = new Variant[1];
        rgvarg[0] = new Variant(
                "./resources/Unbenannt.pdf");
 
        Variant pVarResult = auto.invoke(dispIdMember, rgvarg);
 
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
 
        int[] rgdispReleaseId = auto.getIDsOfNames(new String[] { "Release" });
        int dispIdMemberRelease = rgdispReleaseId[0];
 
        System.out.println(auto.invoke(dispIdMemberRelease));
 
        auto.dispose();
 
        frm.dispose();
 
        site.deactivateInPlaceClient();
        site.dispose();
 
    }
}