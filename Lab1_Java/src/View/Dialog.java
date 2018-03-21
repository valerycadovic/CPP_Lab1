package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
/**
 * <h1>Error Message Class</h1>
 * 
 * @author Valery Chadovich
 * 
 */
public class Dialog {
	/**
	 * <h1>Error dialog</h1>
	 * <p>Shows Error dialog with specified string</p>
	 * @param display
	 * 			System binding parameter
	 * @param message 
	 * 			Dialog Message
	 */
	public static void errorDialog (Display display, String message) {
		MessageBox m = new MessageBox(new Shell(display, SWT.ICON_ERROR));
		m.setText("Error");
		m.setMessage(message);
		m.open();
	}
}
