package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import Model.Triangle;

/**
 * <h1>Simple Triangle Calculator</h1>
 * <p>Provides 2 functions: perimeter and area of random triangle with 3 sides known</p>
 * @author Valery Chadovich
 * @version 1.0
 * @since 21.03.2018
 *
 */
public class Program {
	
	/**
	 * <h1>Shell Config</h1>
	 * <p>Sets location of GUI elements</p>
	 * @param display
	 * 			System binding parameter
	 * @return returns
	 * 			Configured shell
	 */
	public static Shell ConfigureShell(Display display) {
		Shell shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE));
		shell.setText("Triangle Calculator");
		shell.setSize(350, 150);


		shell.setLayout(new GridLayout(4, true));
		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_FILL;
		gridData.minimumHeight = 20;
		gridData.grabExcessHorizontalSpace = true;
		
		new Label(shell, SWT.LEFT).setText("Size 1");
		
		Text fldSize1 = new Text(shell, SWT.BORDER);
		fldSize1.setLayoutData(gridData);
		
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		new Label(shell, SWT.LEFT).setText("Size 2");
		
		Text fldSize2 = new Text(shell, SWT.BORDER);
		fldSize2.setLayoutData(gridData);
		
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		new Label(shell, SWT.LEFT).setText("Size 3");
		
		Text fldSize3 = new Text(shell, SWT.BORDER);
		fldSize3.setLayoutData(gridData);
		
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		
		Button btnPerimeter = new Button(shell, SWT.LEFT);
		btnPerimeter.setText("Perimeter");
		btnPerimeter.setLayoutData(gridData);
				
		Label lblPerimeter = new Label(shell, SWT.NONE);
		lblPerimeter.setText("         ");
		
		Button btnArea = new Button(shell, SWT.LEFT);
		btnArea.setText("Area");
		btnArea.setLayoutData(gridData);
		
		Label lblArea = new Label(shell, SWT.NONE);
		lblArea.setText("         ");
	
		
		
		btnPerimeter.addListener(SWT.Selection, ev -> {
			Double a, b, c;
			try {
				a = Double.parseDouble(fldSize1.getText());
				b = Double.parseDouble(fldSize2.getText());
				c = Double.parseDouble(fldSize3.getText());
			} catch (Exception ex) {
				Dialog.errorDialog(display, "Wrong parameters");
				return;
			}
			
			Double perimeter;
			
			try {
				perimeter = Triangle.getPerimeter(a, b, c);
			} catch (Exception ex) {
				Dialog.errorDialog(display, ex.getMessage());
				return;
			}
			lblPerimeter.setText(perimeter.toString());
		});

	
		btnArea.addListener(SWT.Selection, ev -> {
			Double a, b, c;
			try {
				a = Double.parseDouble(fldSize1.getText());
				b = Double.parseDouble(fldSize2.getText());
				c = Double.parseDouble(fldSize3.getText());
			} catch (Exception ex) {
				Dialog.errorDialog(display, "Wrong parameters");
				return;
			}
			
			Double area;
			
			try {
				area = Triangle.getArea(a, b, c);
			} catch (Exception ex) {
				Dialog.errorDialog(display, ex.getMessage());
				return;
			}lblArea.setText(area.toString());
		});
		
		return shell;

	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = ConfigureShell(display);
		shell.open();


		while (!shell.isDisposed()) {

			if (!display.readAndDispatch())
				display.sleep();
		
		}

	}
}