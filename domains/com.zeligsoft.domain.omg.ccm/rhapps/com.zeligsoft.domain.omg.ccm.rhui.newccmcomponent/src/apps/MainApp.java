package apps;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;

import com.ibm.rhapsody.apps.apps.UIApp;
import com.ibm.rhapsody.apps.utils.Reporter;
import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPPackage;
import com.zeligsoft.domain.omg.ccm.rhui.newccmcomponent.INewCCMComponentCompositeController;
import com.zeligsoft.domain.omg.ccm.rhui.newccmcomponent.NewCCMComponentComposite;


public class MainApp extends UIApp {
	 
	
	public class ComponentController implements
			INewCCMComponentCompositeController {

		@Override
		public String computeDefaultPackageName(String text) {
			return text;
		}

		@Override
		public String computeDefaultComponentDiagramName(String text) {
			return text + "_diag";
		}

		@Override
		public String computeDefaultAssemblyName(String text) {
			return text + "_asm";
		}

		@Override
		public String computeDefaultStructureDiagramName(String text) {
			return text + "_diag";

		}

		@Override
		public void onComplete(String componentName,
				String componentPackageName, String componentDiagramName,
				String assemblyName, String structureDiagramName) {
			MainApp.this.componentName = componentName;
			MainApp.this.componentPackageName = componentPackageName;
			MainApp.this.componentDiagramName = componentDiagramName;
			MainApp.this.assemblyName = assemblyName;
			MainApp.this.structureDiagramName = structureDiagramName;
		}

	}

	protected String componentName;
	protected String componentPackageName;
	protected String componentDiagramName;
	protected String assemblyName;
	protected String structureDiagramName;

	@Override
	protected void initialize() {
		Reporter.report("initialize");
		super.initialize();

		sShell.setText("Create CCM Component");
		buttonOK.setText("OK");
		buttonCancel.setText("Cancel");
	}
	
	@Override
	protected void createSShell() {
		Reporter.report("createSShell");
		sShell = new Shell(SWT.ON_TOP | SWT.SHELL_TRIM);
		GridLayout shellLayout = new GridLayout(2, false);
		sShell.setLayout(shellLayout);
		
		final INewCCMComponentCompositeController controller = new ComponentController();
		final NewCCMComponentComposite composite = new NewCCMComponentComposite(sShell, 0, controller);
		GridData planData = new GridData();
		planData.grabExcessHorizontalSpace = true;
		planData.grabExcessVerticalSpace = true;
		planData.horizontalAlignment = SWT.FILL;
		planData.verticalAlignment = SWT.FILL;
		planData.horizontalSpan = 2;
		composite.setLayoutData(planData);
		
		buttonOK = new Button(sShell, SWT.NONE);
		GridData okData = new GridData();
		okData.horizontalAlignment = SWT.RIGHT;
		okData.grabExcessHorizontalSpace = true;
		buttonOK.setLayoutData(okData);
		buttonOK.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				composite.onComplete();
				onOK();
			}
		});
		buttonCancel = new Button(sShell, SWT.NONE);
		GridData cancelData = new GridData();
		cancelData.horizontalAlignment = SWT.RIGHT;
		buttonCancel.setLayoutData(cancelData);
		buttonCancel.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				onCancel();
			}
		});
		

		super.createSShell();
	}

	/*
	* This method is called on invoking an app inside Rhapsody.
	* rhapsody - Instance of an active Rhapsody application 
	* selected - Selected element in Rhapsody
	*/
	public void execute(IRPApplication rhapsody, IRPModelElement selected) {
		Reporter.report("execute");
		final IRPPackage pkg = (IRPPackage) selected;
		final IRPPackage contentPackage = componentPackageName != null ? 
			pkg.addNestedPackage(componentPackageName) : pkg;

		final IRPClass component = (IRPClass) contentPackage.addNewAggr("CCMComponent", componentName);
		if(componentDiagramName != null) {
			contentPackage.addComponentDiagram(componentDiagramName);
		}
		if(assemblyName != null) {
			final IRPClass assembly = (IRPClass) contentPackage.addNewAggr("AssemblyImplementation", assemblyName);
			assembly.addGeneralization(component);
			if(structureDiagramName != null) {
				assembly.addNewAggr("StructureDiagram", structureDiagramName);
			}
		}
	}
	
	@Override
	public void invoke(IRPModelElement selected) {
		Reporter.report("invoke");
		super.invoke(selected);
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
