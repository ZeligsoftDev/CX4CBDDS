package apps.ccm.wizard;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class NewCCMComponentComposite extends Composite {
	private Text txtComponentName;
	private Text txtComponentPackageName;
	private Text txtCompDiagramName;
	private Text txtAssemblyName;
	private Text txtStructDiagramName;
	private Group grpAssemblyOptions;
	private Button btnCreateAssembly;
	protected INewCCMComponentCompositeController controller;
	private Button btnAssyNameUseDefault;
	private Button btnCreateStructDiag;
	private Button btnStructDiagUseDefault;
	private Button btnCreateComponentIn;
	private Button btnCompPkgUseDefault;
	private Button btnCompDiagUseDefault;
	private Button btnAddComponentTo;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public NewCCMComponentComposite(Composite parent, int style, INewCCMComponentCompositeController theController) {
		super(parent, style);
		this.controller = theController;
		
		setLayout(new GridLayout(1, false));
		
		Composite compositeComponentName = new Composite(this, SWT.NONE);
		compositeComponentName.setLayout(new GridLayout(2, false));
		compositeComponentName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblComponentName = new Label(compositeComponentName, SWT.NONE);
		lblComponentName.setBounds(0, 0, 55, 15);
		lblComponentName.setText("Component Name:");
		
		txtComponentName = new Text(compositeComponentName, SWT.BORDER);
		txtComponentName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				final String text= txtComponentName.getText();
				if(btnCompPkgUseDefault.getSelection()) {
					txtComponentPackageName.setText(controller.computeDefaultPackageName(text));
				}
				if(btnCompDiagUseDefault.getSelection()) {
					txtCompDiagramName.setText(controller.computeDefaultComponentDiagramName(text));
				}
				if(btnAssyNameUseDefault.getSelection()) {
					txtAssemblyName.setText(controller.computeDefaultAssemblyName(text));
				}
				if(btnStructDiagUseDefault.getSelection()) {
					txtStructDiagramName.setText(controller.computeDefaultStructureDiagramName(text));
				}
			}
		});
		txtComponentName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		txtComponentName.setBounds(0, 0, 76, 21);
		new Label(compositeComponentName, SWT.NONE);
		
		btnCreateAssembly = new Button(compositeComponentName, SWT.CHECK);
		btnCreateAssembly.setSelection(true);
		btnCreateAssembly.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setAssemblyOptionsEnablement(btnCreateAssembly.getSelection());			}
		});
		btnCreateAssembly.setBounds(0, 0, 93, 16);
		btnCreateAssembly.setText("Create Assembly");
		
		Label separator = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Group grpComponentOptions = new Group(this, SWT.NONE);
		grpComponentOptions.setLayout(new GridLayout(3, false));
		grpComponentOptions.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		grpComponentOptions.setText("Component Options");
		
		btnCreateComponentIn = new Button(grpComponentOptions, SWT.CHECK);
		btnCreateComponentIn.setSelection(true);
		btnCreateComponentIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtComponentPackageName.setEnabled(btnCreateComponentIn.getSelection() && !btnCompPkgUseDefault.getSelection());
				btnCompPkgUseDefault.setEnabled(btnCreateComponentIn.getSelection());
			}
		});
		btnCreateComponentIn.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		btnCreateComponentIn.setBounds(0, 0, 93, 16);
		btnCreateComponentIn.setText("Create Component in new package");
		
		Label lblComponentPackageName = new Label(grpComponentOptions, SWT.NONE);
		lblComponentPackageName.setBounds(0, 0, 55, 15);
		lblComponentPackageName.setText("Package name:");
		
		txtComponentPackageName = new Text(grpComponentOptions, SWT.BORDER);
		txtComponentPackageName.setEnabled(false);
		GridData gd_txtComponentPackageName = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtComponentPackageName.minimumWidth = 250;
		txtComponentPackageName.setLayoutData(gd_txtComponentPackageName);
		txtComponentPackageName.setBounds(0, 0, 76, 21);
		
		btnCompPkgUseDefault = new Button(grpComponentOptions, SWT.CHECK);
		btnCompPkgUseDefault.setSelection(true);
		btnCompPkgUseDefault.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtComponentPackageName.setEnabled(!btnCompPkgUseDefault.getSelection());
				if(btnCompPkgUseDefault.getSelection()) {
					txtComponentPackageName.setText(controller.computeDefaultPackageName(txtAssemblyName.getText()));
				}
			}
		});
		btnCompPkgUseDefault.setText("Use default");
		
		btnAddComponentTo = new Button(grpComponentOptions, SWT.CHECK);
		btnAddComponentTo.setSelection(true);
		btnAddComponentTo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtCompDiagramName.setEnabled(btnAddComponentTo.getSelection() && !btnCompDiagUseDefault.getSelection());
				btnCompDiagUseDefault.setEnabled(btnAddComponentTo.getSelection());
			}
		});
		btnAddComponentTo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		btnAddComponentTo.setBounds(0, 0, 93, 16);
		btnAddComponentTo.setText("Add component to a new diagram");
		
		Label lblComponentDiagramName = new Label(grpComponentOptions, SWT.NONE);
		lblComponentDiagramName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblComponentDiagramName.setText("Diagram name:");
		
		txtCompDiagramName = new Text(grpComponentOptions, SWT.BORDER);
		txtCompDiagramName.setEnabled(false);
		txtCompDiagramName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnCompDiagUseDefault = new Button(grpComponentOptions, SWT.CHECK);
		btnCompDiagUseDefault.setSelection(true);
		btnCompDiagUseDefault.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtCompDiagramName.setEnabled(!btnCompDiagUseDefault.getSelection());
				if(btnCompDiagUseDefault.getSelection()) {
					txtCompDiagramName.setText(controller.computeDefaultComponentDiagramName(txtAssemblyName.getText()));
				}
			}
		});
		btnCompDiagUseDefault.setText("Use default");
		
		grpAssemblyOptions = new Group(this, SWT.NONE);
		grpAssemblyOptions.setLayout(new GridLayout(3, false));
		grpAssemblyOptions.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		grpAssemblyOptions.setText("Assembly Options");
		
		Label lblAssemblyName = new Label(grpAssemblyOptions, SWT.NONE);
		lblAssemblyName.setText("Assembly name:");
		
		txtAssemblyName = new Text(grpAssemblyOptions, SWT.BORDER);
		txtAssemblyName.setEnabled(false);
		txtAssemblyName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		txtAssemblyName.setBounds(0, 0, 76, 21);
		
		btnAssyNameUseDefault = new Button(grpAssemblyOptions, SWT.CHECK);
		btnAssyNameUseDefault.setSelection(true);
		btnAssyNameUseDefault.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtAssemblyName.setEnabled(!btnAssyNameUseDefault.getSelection());
				if(btnAssyNameUseDefault.getSelection()) {
					txtAssemblyName.setText(controller.computeDefaultAssemblyName(txtAssemblyName.getText()));
				}
			}
		});
		btnAssyNameUseDefault.setText("Use default");
		
		btnCreateStructDiag = new Button(grpAssemblyOptions, SWT.CHECK);
		btnCreateStructDiag.setSelection(true);
		btnCreateStructDiag.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtStructDiagramName.setEnabled(btnCreateStructDiag.getSelection() && !btnStructDiagUseDefault.getSelection());
				btnStructDiagUseDefault.setEnabled(btnCreateStructDiag.getSelection());
			}
		});
		btnCreateStructDiag.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		btnCreateStructDiag.setBounds(0, 0, 93, 16);
		btnCreateStructDiag.setText("Create a new structure diagram");
		
		Label lblStructDiagramName = new Label(grpAssemblyOptions, SWT.NONE);
		lblStructDiagramName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStructDiagramName.setText("Diagram name:");
		
		txtStructDiagramName = new Text(grpAssemblyOptions, SWT.BORDER);
		txtStructDiagramName.setEnabled(false);
		txtStructDiagramName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
		btnStructDiagUseDefault = new Button(grpAssemblyOptions, SWT.CHECK);
		btnStructDiagUseDefault.setSelection(true);
		btnStructDiagUseDefault.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtStructDiagramName.setEnabled(!btnStructDiagUseDefault.getSelection());
				if(btnStructDiagUseDefault.getSelection()) {
					txtStructDiagramName.setText(controller.computeDefaultStructureDiagramName(txtAssemblyName.getText()));
				}
			}
		});
		btnStructDiagUseDefault.setText("Use default");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	protected void setAssemblyOptionsEnablement(boolean enabled) {
		txtAssemblyName.setEnabled(enabled && !btnAssyNameUseDefault.getSelection());
		btnAssyNameUseDefault.setEnabled(enabled);
		btnCreateStructDiag.setEnabled(enabled);
		txtStructDiagramName.setEnabled(enabled && btnCreateStructDiag.getSelection() && !btnStructDiagUseDefault.getSelection());
		btnStructDiagUseDefault.setEnabled(enabled && btnCreateStructDiag.getSelection());
	}
	
	public Button getBtnAssyNameUseDefault() {
		return btnAssyNameUseDefault;
	}
	public Button getBtnCreateStructDiag() {
		return btnCreateStructDiag;
	}
	public Button getBtnStructDiagUseDefault() {
		return btnStructDiagUseDefault;
	}
	public Button getBtnCreateComponentIn() {
		return btnCreateComponentIn;
	}
	public Button getBtnCompPkgUseDefault() {
		return btnCompPkgUseDefault;
	}
	public Button getBtnCompDiagUseDefault() {
		return btnCompDiagUseDefault;
	}
	public Button getBtnAddComponentTo() {
		return btnAddComponentTo;
	}
	public Text getTxtComponentPackageName() {
		return txtComponentPackageName;
	}
	public Text getTxtCompDiagramName() {
		return txtCompDiagramName;
	}
	public Text getTxtAssemblyName() {
		return txtAssemblyName;
	}
	public Text getTxtStructDiagramName() {
		return txtStructDiagramName;
	}
	
	public void onComplete() {
		final String componentName = txtComponentName.getText();
		final String componentPackageName = btnCreateComponentIn.getSelection() ? txtComponentPackageName.getText() : null;
		final String componentDiagramName = btnAddComponentTo.getSelection() ? txtCompDiagramName.getText() : null;
		final String assemblyName = btnCreateAssembly.getSelection() ? txtAssemblyName.getText() : null;
		final String structureDiagramName = btnCreateAssembly.getSelection() && btnCreateStructDiag.getSelection() ?
				txtStructDiagramName.getText() : null;
		controller.onComplete(componentName,
				componentPackageName,
				componentDiagramName,
				assemblyName,
				structureDiagramName);
				
				
	}
}
