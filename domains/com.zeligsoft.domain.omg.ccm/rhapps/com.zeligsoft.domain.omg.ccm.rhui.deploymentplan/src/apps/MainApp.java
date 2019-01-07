package apps;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;

import aaa.dialog.mockups.deployment.DeploymentPlanComposite;

import com.ibm.rhapsody.apps.apps.UIApp;
import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPModelElement;


public class MainApp extends UIApp {
	
	private DeploymentPlanController controller;
	private DeploymentPlanComposite planComposite;

	@Override
	protected void initialize() {
		super.initialize();
		
		// TODO: Rename controls to create a dialog according to your needs
		
		sShell.setText("Edit Deployment Plan");
		buttonOK.setText("Close");
//		buttonCancel.setText("Cancel");
	}
	
	@Override
	protected void createSShell() {
		sShell = new Shell(SWT.ON_TOP | SWT.SHELL_TRIM);
		sShell.setText("Edit Deployment Plan");
		GridLayout shellLayout = new GridLayout(1, false);
		sShell.setLayout(shellLayout);
		
		controller = new DeploymentPlanController(rhapsody);
		planComposite = new DeploymentPlanComposite(sShell, 0, controller);
		GridData planData = new GridData();
		planData.grabExcessHorizontalSpace = true;
		planData.grabExcessVerticalSpace = true;
		planData.horizontalAlignment = SWT.FILL;
		planData.verticalAlignment = SWT.FILL;
		planComposite.setLayoutData(planData);
		
		buttonOK = new Button(sShell, SWT.NONE);
		buttonOK.setText("Close");
		GridData okData = new GridData();
		okData.horizontalAlignment = SWT.RIGHT;
		okData.grabExcessHorizontalSpace = true;
		buttonOK.setLayoutData(okData);
		buttonOK.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				onOK();
			}
		});
		
		super.createSShell();
	}
	/*
	* This method is called on invoking an app inside Rhapsody.
	* rhapsody - Instance of an active Rhapsody application 
	* selected - Selected element in Rhapsody
	* value1   - First input in dialog
	* value2   - Second input in dialog	
	*/
	public void execute(IRPApplication rhapsody, IRPModelElement selected, String value1,  String value2) {
		// TODO: Place your code here
	}	
	
    /*
     *  Debug app by launching it as "Java Application" is Eclipse.
	 *  Note: Select an element in Rhapsody in order to simulate launching app on a selected element in the browser.
     */		
	public static void main(String[] args) {
		MainApp app = new MainApp();
		app.invokeFromMain();
	}
}
