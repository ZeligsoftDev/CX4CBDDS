/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.omg.ccm.ui.wizards;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.domain.omg.ccm.preferences.CCMPreferenceConstants;
import com.zeligsoft.domain.omg.ccm.ui.Activator;
import com.zeligsoft.domain.omg.ccm.ui.l10n.Messages;

/**
 * CCM Component Wizard Page
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings("deprecation")
public class CCMComponentWizardPage extends WizardPage {

	protected EObject context;

	protected Text nameField;

	protected Button autoPkgButton;

	protected Button useDefaultPkgButton;

	protected Text packageNameField;

	protected Button autoDiagButton;

	protected Button useDefaultDiagButton;

	protected Text diagramNameField;

	protected Button useDefaultStructureDiagButton;
	
	protected Button isCreateImplementationButton;
	
	protected Group implementationOptionGroup;
	
	protected Text implementationNameField;
	
	protected Button useDefaultImplNameButton;
	
	protected Button structureDiagramButton;
	
	protected Button useDefaultStructureDiagramButton;
	
	protected Text structureDiagramNameField;
	
	protected Label implDiagramLabel;
	
	protected Label nameLabel;
	
	protected Button assemblyButton;
	
	protected Button monolithicButton;
	
	protected Group radioGroup;
	
	protected Label packageLabel;
	
	protected Label diagramLabel;
	
	protected Button newSubPackageButton;
	
	protected Label subpackageLabel;
	
	protected Text subpackageNameField;
	

	protected IDialogSettings dialogSetting = Activator.getDefault().getDialogSettings();
	
	//remember user selections

	private static final String CREATE_IMPL_KEY = "componentWizard_createImpl";  //$NON-NLS-1$
	
	private static final String CREATE_IMPL_TYPE_ASM_KEY = "componentWizard_createImplTypeAsm"; //$NON-NLS-1$

	private static final String CREATE_PACKAGE_KEY = "componentWizard_createNewPackage"; //$NON-NLS-1$

	private static final String CREATE_COMPONENT_DIAGRAM_KEY = "componentWizard_diagram"; //$NON-NLS-1$

	private static final String CREATE_STRUCTURE_DIAGRAM_KEY = "componentWizard_createStructure"; //$NON-NLS-1$
	
	private static final String CREATE_SUBPACKAGE_KEY = "componentWizard_createSubpackage";  //$NON-NLS-1$

	// preference store
	private Preferences preferenceStore = com.zeligsoft.domain.omg.ccm.Activator
			.getDefault().getPluginPreferences();

	protected CCMComponentWizardPage(EObject context) {
		super("CCMComponentWizard"); //$NON-NLS-1$
		setTitle(Messages.CCMComponentWizardPage_Title);
		setDescription(Messages.CCMComponentWizardPage_Description);
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createNameControl(composite);

		addSeparator(composite);

		createOptionControl(composite);

		createImplementationOptionControl(composite);

		setControl(composite);

		setPageComplete(false);
	}

	private Composite createComposite(Composite parent, int numColumns) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout compositeLayout = new GridLayout();
		compositeLayout.numColumns = numColumns;
		compositeLayout.marginHeight = 5;
		compositeLayout.marginWidth = 5;

		GridData compositeLData = new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL);
		compositeLData.horizontalIndent = 2;

		composite.setLayoutData(compositeLData);
		composite.setLayout(compositeLayout);
		return composite;
	}

	private void createNameControl(Composite parent) {
		Composite composite = createComposite(parent, 2);

		Label nameLabel = new Label(composite, SWT.NULL);
		nameLabel.setText(Messages.CCMComponentWizardPage_ComponentNameLabel);
		nameLabel.setLayoutData(new GridData());

		nameField = new Text(composite, SWT.BORDER);
		nameField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		nameField.addListener(SWT.Modify, new Listener() {

			public void handleEvent(Event e) {
				if (useDefaultPkgButton.getSelection()) {
					packageNameField
							.setText(calculatePackageName());
				}

				if (useDefaultDiagButton.getSelection()) {
					diagramNameField
							.setText(calculateDefaultName(
									nameField.getText(),
									preferenceStore
											.getString(CCMPreferenceConstants.DIAGRAM_SUFFIX)));
				}

				if (useDefaultImplNameButton.getSelection()) {
					
					String suffix;
					if (assemblyButton.getSelection()){
						suffix = preferenceStore
									.getString(CCMPreferenceConstants.ASSEMBLY_IMPLEMENTATION_SUFFIX);
					}
					else{
						suffix = preferenceStore
									.getString(CCMPreferenceConstants.MONOLITHIC_IMPLEMENTATION_SUFFIX);
					}
					
					implementationNameField
							.setText(calculateDefaultName(
									nameField.getText(),
									suffix));
				}
				
				if (useDefaultStructureDiagramButton.getSelection()) {
					structureDiagramNameField.setText(calculateDefaultName(nameField
							.getText(), preferenceStore
									.getString(CCMPreferenceConstants.DIAGRAM_SUFFIX)));
				}
				validate();
			}
		});
		
		Composite composite2 = createComposite(parent, 1);
		
		isCreateImplementationButton = new Button(composite2, SWT.CHECK);
		isCreateImplementationButton.setText(Messages.CCMComponentWizardPage_CreateImplementationButtonLabel);
		if (dialogSetting.get(CREATE_IMPL_KEY) != null) {
			isCreateImplementationButton.setSelection(dialogSetting.getBoolean(CREATE_IMPL_KEY));
		} else {
			isCreateImplementationButton.setSelection(true);
		}
				
		isCreateImplementationButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean isSelected = isCreateImplementationButton.getSelection();
				dialogSetting.put(CREATE_IMPL_KEY, isSelected);
				enableImplementationGroup(isSelected);
				if (isSelected){
					implementationTypeChange();
				}
			}
		});
	}
	
	private String calculatePackageName(){	
		String packageName;	
		packageName = calculateDefaultName(
					nameField.getText(),
					preferenceStore
							.getString(CCMPreferenceConstants.PACKAGE_SUFFIX));
		return packageName;	
	}

	private void createOptionControl(Composite parent) {
		Group group = new Group(parent, SWT.NULL);
		group.setLayout(new GridLayout(3, false));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		group.setText(Messages.CCMComponentWizardPage_CreateOptionGroupLabel);

		{
			// create auto package button
			autoPkgButton = new Button(group, SWT.CHECK);
			autoPkgButton
					.setText(Messages.CCMComponentWizardPage_AutoCreatePkgButtonLabel);
			if (dialogSetting.get(CREATE_PACKAGE_KEY) != null) {
				autoPkgButton.setSelection(dialogSetting.getBoolean(CREATE_PACKAGE_KEY));
			} else {
				autoPkgButton.setSelection(true);
			}
			GridData data = new GridData();
			data.horizontalSpan = 3;
			data.verticalIndent = 5;
			autoPkgButton.setLayoutData(data);
			autoPkgButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					useDefaultPkgButton.setEnabled(autoPkgButton.getSelection());
					packageLabel.setEnabled(autoPkgButton.getSelection());
					packageNameField.setEnabled(autoPkgButton.getSelection());
					dialogSetting.put(CREATE_PACKAGE_KEY, autoPkgButton.getSelection());
					validate();
				}
			});

			// create label
			packageLabel = new Label(group, SWT.NULL);
			GridData gd1 = new GridData();
			gd1.horizontalIndent = 20;
			packageLabel.setLayoutData(gd1);
			packageLabel.setText(Messages.CCMComponentWizardPage_PackageNameLabel);
			packageLabel.setEnabled(autoPkgButton.getSelection());

			// create input field
			packageNameField = new Text(group, SWT.BORDER);
			packageNameField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
					| GridData.GRAB_HORIZONTAL));
			packageNameField.setEditable(false);
			packageNameField.setEnabled(autoPkgButton.getSelection());
			packageNameField.setText(calculatePackageName());
			packageNameField.addListener(SWT.Modify, new Listener() {

				public void handleEvent(Event e) {
					validate();
				}
			});

			// create use default button
			useDefaultPkgButton = new Button(group, SWT.CHECK);
			useDefaultPkgButton.setLayoutData(new GridData());
			useDefaultPkgButton
					.setText(Messages.CCMComponentWizardPage_UseDefaultButtonLabel);
			useDefaultPkgButton.setSelection(true);
			useDefaultPkgButton.setEnabled(autoPkgButton.getSelection());
			useDefaultPkgButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					if (useDefaultPkgButton.getSelection()) {
						packageNameField.setText(calculatePackageName());
					}
					packageNameField.setEditable(!useDefaultPkgButton.getSelection());
					validate();
				}
			});
		}

		{
			// diagram options
			autoDiagButton = new Button(group, SWT.CHECK);
			autoDiagButton
					.setText(Messages.CCMComponentWizardPage_AutoDiagramButtonLabel);
			if (dialogSetting.get(CREATE_COMPONENT_DIAGRAM_KEY) != null) {
				autoDiagButton.setSelection(dialogSetting
						.getBoolean(CREATE_COMPONENT_DIAGRAM_KEY));
			} else {
				autoDiagButton.setSelection(false);
			}
			GridData data = new GridData();
			data.horizontalSpan = 3;
			data.verticalIndent = 0;
			autoDiagButton.setLayoutData(data);
			
			autoDiagButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					createComponentDiagramToggled();
					validate();
				}
			});

			diagramLabel = new Label(group, SWT.NULL);
			GridData gd1 = new GridData();
			gd1.horizontalIndent = 20;
			diagramLabel.setLayoutData(gd1);
			diagramLabel.setText(Messages.CCMComponentWizardPage_DiagramNameLabel);
			diagramLabel.setEnabled(autoDiagButton.getSelection());

			diagramNameField = new Text(group, SWT.BORDER);
			diagramNameField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
					| GridData.GRAB_HORIZONTAL));
			diagramNameField.setEditable(false);
			diagramNameField.setEnabled(autoDiagButton.getSelection());
			diagramNameField.addListener(SWT.Modify, new Listener() {

				public void handleEvent(Event e) {
					validate();
				}
			});

			useDefaultDiagButton = new Button(group, SWT.CHECK);
			useDefaultDiagButton.setLayoutData(new GridData());
			useDefaultDiagButton
					.setText(Messages.CCMComponentWizardPage_UseDefaultButtonLabel);
			useDefaultDiagButton.setSelection(true);
			useDefaultDiagButton.setEnabled(autoDiagButton.getSelection());
			useDefaultDiagButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					if (useDefaultDiagButton.getSelection()) {
						diagramNameField
								.setText(calculateDefaultName(
										nameField.getText(),
										preferenceStore
												.getString(CCMPreferenceConstants.DIAGRAM_SUFFIX)));

					}
					diagramNameField.setEditable(!useDefaultDiagButton.getSelection());
					validate();
				}
			});
		}
		createComponentDiagramToggled();

	}
	
	private void createComponentDiagramToggled(){
		useDefaultDiagButton.setEnabled(autoDiagButton.getSelection());
		diagramLabel.setEnabled(autoDiagButton.getSelection());
		diagramNameField.setEnabled(autoDiagButton.getSelection());
		dialogSetting.put(CREATE_COMPONENT_DIAGRAM_KEY, 
				autoDiagButton.getSelection());
	}

	/**
	 * Calculate default name with given suffix
	 * 
	 * @return
	 */
	private String calculateDefaultName(String name, String suffix) {
		if (name == null || name.equals(UML2Util.EMPTY_STRING)) {
			return UML2Util.EMPTY_STRING;
		}
		return name + suffix;
	}

	protected boolean validate() {

		if (nameField.getText().equals(UML2Util.EMPTY_STRING)) {
			this.setErrorMessage(Messages.CCMComponentWizardPage_NameErrorMsg);
			setPageComplete(false);
			return false;
		}

		if (isCreateImplementation() 
				&& implementationNameField.getText().equals(UML2Util.EMPTY_STRING)) {
			this.setErrorMessage(Messages.CCMComponentWizardPage_ImplNameErrorMsg);
			setPageComplete(false);
			return false;
		}

		if (autoPkgButton.getSelection()
				&& packageNameField.getText().equals(UML2Util.EMPTY_STRING)) {
			setErrorMessage(Messages.CCMComponentWizardPage_PackageNameErrorMsg);
			setPageComplete(false);
			return false;
		}

		if (autoDiagButton.getSelection()
				&& diagramNameField.getText().equals(UML2Util.EMPTY_STRING)) {
			setErrorMessage(Messages.CCMComponentWizardPage_DiagramNameErrorMsg);
			setPageComplete(false);
			return false;
		}

		if (structureDiagramButton.getSelection()
				&& structureDiagramNameField.getText().equals(UML2Util.EMPTY_STRING)) {
			setErrorMessage(Messages.CCMComponentWizardPage_StructureDiagramNameErrorMsg);
			setPageComplete(false);
			return false;
		}
		
		if (newSubPackageButton.getSelection()
				&& subpackageNameField.getText().equals(UML2Util.EMPTY_STRING)) {
			setErrorMessage(Messages.CCMComponentWizardPage_SubpackageNameErrorMsg);
			setPageComplete(false);
			return false;
		}

		setPageComplete(true);
		this.setErrorMessage(null);
		return true;
	}

	/**
	 * Adds a separator to the given composite.
	 * 
	 * @param composite
	 */
	private void addSeparator(Composite composite) {

		Label label1 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData label1LData = new GridData(GridData.FILL_HORIZONTAL);
		label1LData.grabExcessHorizontalSpace = true;
		label1LData.verticalIndent = 0;
		label1.setLayoutData(label1LData);
	}

	public String getComponentName() {
		return nameField.getText();
	}

	public Boolean isCreateImplementation(){
		return this.isCreateImplementationButton.getSelection();
	}
	
	public Boolean isAssemblyType(){
		return assemblyButton.getSelection();
	}
	
	public Boolean isMonolithicType(){
		return monolithicButton.getSelection();
	}

	public String getImplementationName(){
		return implementationNameField.getText();
	}

	public boolean isCreatePkg() {
		return autoPkgButton.getSelection();
	}

	public String getPkgName() {
		return packageNameField.getText();
	}

	public boolean isCreateComponentDiagram() {
		return autoDiagButton.getSelection();
	}

	public String getComponentDiagramName() {
		return diagramNameField.getText();
	}

	public boolean isCreateStructureDiagram() {
		return structureDiagramButton.getSelection();
	}

	public String getStructureDiagramName() {
		return structureDiagramNameField.getText();
	}
	
	public boolean isAddIntoSubpackage(){
		return newSubPackageButton.getSelection();
	}
	
	public String getSubpackageName(){
		return subpackageNameField.getText();
	}
	
	private void enableImplementationGroup(boolean isEnabled){
		implementationOptionGroup.setEnabled(isEnabled);
		implementationNameField.setEnabled(isEnabled);
		useDefaultImplNameButton.setEnabled(isEnabled);
		
		nameLabel.setEnabled(isEnabled);
		radioGroup.setEnabled(isEnabled);
		assemblyButton.setEnabled(isEnabled);
		monolithicButton.setEnabled(isEnabled);
		
		if (isEnabled){
			if (assemblyButton.getSelection()){
				structureDiagramButton.setEnabled(isEnabled);
				enableAssemblyDiagram(structureDiagramButton.getSelection());	
					
				//disable all monolithic
				newSubPackageButton.setEnabled(!isEnabled);
				enableMonolithicSubpackage(!isEnabled);
			}
			else if (monolithicButton.getSelection()){
				newSubPackageButton.setEnabled(isEnabled);
				enableMonolithicSubpackage(newSubPackageButton.getSelection());
				
				//disable all assembly
				structureDiagramButton.setEnabled(!isEnabled);
				enableAssemblyDiagram(!isEnabled);
			}			
		}
		else{   //disable everything
			structureDiagramButton.setEnabled(isEnabled);
			enableAssemblyDiagram(isEnabled);
			
			newSubPackageButton.setEnabled(isEnabled);
			enableMonolithicSubpackage(isEnabled);
		}
	}
	
	private void enableAssemblyDiagram(boolean isEnabled){
		useDefaultStructureDiagramButton.setEnabled(isEnabled);
		structureDiagramNameField.setEnabled(isEnabled);
		implDiagramLabel.setEnabled(isEnabled);
	}
	
	private void enableMonolithicSubpackage(boolean isEnabled){
		subpackageLabel.setEnabled(isEnabled);
		subpackageNameField.setEnabled(isEnabled);
	}
	
	private void createImplementationOptionControl(Composite parent) {
		
		implementationOptionGroup = new Group(parent, SWT.NULL);
		implementationOptionGroup.setLayout(new GridLayout(3, false));
		implementationOptionGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		implementationOptionGroup
				.setText(Messages.CCMComponentWizardPage_ImplOptionGroupLabel);
		
		{
			// create label
			nameLabel = new Label(implementationOptionGroup, SWT.NULL);
			nameLabel.setLayoutData(new GridData());
			nameLabel.setText(Messages.CCMComponentWizardPage_ImplNameLabel);

			// create input field
			implementationNameField = new Text(implementationOptionGroup, SWT.BORDER);
			implementationNameField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
					| GridData.GRAB_HORIZONTAL));
			implementationNameField.setEditable(false);
			implementationNameField.addListener(SWT.Modify, new Listener() {

				public void handleEvent(Event e) {
					validate();
				}
			});

			// create use default button
			useDefaultImplNameButton = new Button(implementationOptionGroup, SWT.CHECK);
			useDefaultImplNameButton.setLayoutData(new GridData());
			useDefaultImplNameButton.setText(Messages.CCMComponentWizardPage_UseDefaultButtonLabel);
			useDefaultImplNameButton.setSelection(true);
			useDefaultImplNameButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					if (useDefaultImplNameButton.getSelection()) {
						String suffix;
						if (assemblyButton.getSelection()){
							suffix = preferenceStore
										.getString(CCMPreferenceConstants.ASSEMBLY_IMPLEMENTATION_SUFFIX);
						}
						else{
							suffix = preferenceStore
										.getString(CCMPreferenceConstants.MONOLITHIC_IMPLEMENTATION_SUFFIX);
						}
						implementationNameField
								.setText(calculateDefaultName(
										nameField.getText(),
										suffix));

					}
					implementationNameField.setEditable(!useDefaultImplNameButton.getSelection());
					validate();
				}
			});
		}
		
		radioGroup = new Group(implementationOptionGroup, SWT.SHADOW_IN);
		radioGroup.setText(Messages.CCMComponentWizardPage_kind);
		radioGroup.setLayout(new GridLayout(3, false));
		GridData gd = new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL);
		gd.horizontalSpan=3;
		gd.grabExcessHorizontalSpace=true;
		radioGroup.setLayoutData(gd);
		
		GridData buttonGD = new GridData();
		buttonGD.horizontalSpan=3;
		
	    assemblyButton = new Button(radioGroup, SWT.RADIO);
	    assemblyButton.setText(Messages.CCMComponentWizardPage_assembly);
	    assemblyButton.setLayoutData(buttonGD);
	    
	    assemblyButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean isSelected = assemblyButton.getSelection();
				
				dialogSetting.put(CREATE_IMPL_TYPE_ASM_KEY, isSelected);
				structureDiagramButton.setEnabled(isSelected);
				
				if(!structureDiagramButton.getSelection()){
					enableAssemblyDiagram(false);
				}
				else{
					enableAssemblyDiagram(isSelected);
				}
				implementationTypeChange();		
			}
		});
	    
	    //add assembly widgets
	    {
			structureDiagramButton = new Button(radioGroup, SWT.CHECK);
			structureDiagramButton
					.setText(Messages.CCMComponentWizardPage_AutoStructureDiagramButtonLabel);
			if (dialogSetting.get(CREATE_STRUCTURE_DIAGRAM_KEY) != null) {
				structureDiagramButton.setSelection(dialogSetting
						.getBoolean(CREATE_STRUCTURE_DIAGRAM_KEY));
			} else {
				structureDiagramButton.setSelection(true);
			}
			GridData data = new GridData();
			data.horizontalSpan = 3;
			data.verticalIndent = 5;
			data.horizontalIndent = 20;
			structureDiagramButton.setLayoutData(data);
			structureDiagramButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					boolean isEnabled = structureDiagramButton.getSelection();
					useDefaultStructureDiagramButton.setEnabled(isEnabled);
					implDiagramLabel.setEnabled(isEnabled);
					structureDiagramNameField.setEnabled(isEnabled);
					dialogSetting.put(CREATE_STRUCTURE_DIAGRAM_KEY,
							structureDiagramButton.getSelection());
					validate();
				}
			});

			// create label
			implDiagramLabel = new Label(radioGroup, SWT.NULL);
			GridData gd2 = new GridData();
			gd2.horizontalIndent = 40;
			implDiagramLabel.setLayoutData(gd2);
			implDiagramLabel.setText(Messages.CCMComponentWizardPage_DiagramNameLabel);

			// create input field
			structureDiagramNameField = new Text(radioGroup, SWT.BORDER);
			structureDiagramNameField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
					| GridData.GRAB_HORIZONTAL));
			structureDiagramNameField.setEditable(false);
			structureDiagramNameField.addListener(SWT.Modify, new Listener() {

				public void handleEvent(Event e) {
					validate();
				}
			});

			// create use default button
			useDefaultStructureDiagramButton = new Button(radioGroup, SWT.CHECK);
			useDefaultStructureDiagramButton.setLayoutData(new GridData());
			useDefaultStructureDiagramButton
					.setText(Messages.CCMComponentWizardPage_UseDefaultButtonLabel);
			useDefaultStructureDiagramButton.setSelection(true);
			useDefaultStructureDiagramButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					if (useDefaultStructureDiagramButton.getSelection()) {
						structureDiagramNameField
								.setText(calculateDefaultName(
										nameField.getText(),
										preferenceStore
												.getString(CCMPreferenceConstants.DIAGRAM_SUFFIX)));

					}
					structureDiagramNameField.setEditable(
							 !useDefaultStructureDiagramButton.getSelection());
					validate();
				}
			});
		}
	    
	    monolithicButton = new Button(radioGroup, SWT.RADIO);
	    monolithicButton.setText(Messages.CCMComponentWizardPage_monolithic);
	    monolithicButton.setLayoutData(buttonGD);    
	    
	    monolithicButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean isSelected = monolithicButton.getSelection();
				
				newSubPackageButton.setEnabled(isSelected);
				
				if(!newSubPackageButton.getSelection()){
					enableMonolithicSubpackage(false);
				}
				else{
					enableMonolithicSubpackage(isSelected);
				}
				implementationTypeChange();		
			}
		});
	    
	    //add monolithic widgets	    
	    {
			newSubPackageButton = new Button(radioGroup, SWT.CHECK);
			newSubPackageButton.setText(Messages.CCMComponentWizardPage_addSubpackage);
			
			GridData data = new GridData();
			data.horizontalSpan = 3;
			data.verticalIndent = 5;
			data.horizontalIndent = 20;
			newSubPackageButton.setLayoutData(data);
			newSubPackageButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					subpackageLabel.setEnabled(newSubPackageButton.getSelection());
					subpackageNameField.setEnabled(newSubPackageButton.getSelection());
					dialogSetting.put(CREATE_SUBPACKAGE_KEY,
							newSubPackageButton.getSelection());
					validate();
				}
			});

			// create label
			subpackageLabel = new Label(radioGroup, SWT.NULL);
			GridData gd2 = new GridData();
			gd2.horizontalIndent = 40;
			subpackageLabel.setLayoutData(gd2);
			subpackageLabel.setText(Messages.CCMComponentWizardPage_subpackageName);

			// create input field
			subpackageNameField = new Text(radioGroup, SWT.BORDER);
			subpackageNameField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
					| GridData.GRAB_HORIZONTAL));
			String subpackageName = preferenceStore
					.getString(CCMPreferenceConstants.SUBPACKAGE_NAME_CONSTANT);
			subpackageNameField.setText(subpackageName);
			
			subpackageNameField.addListener(SWT.Modify, new Listener() {
				public void handleEvent(Event e) {
					validate();
				}
			});
		}
	    
	    if (dialogSetting.get(CREATE_SUBPACKAGE_KEY) != null) {
			newSubPackageButton.setSelection(dialogSetting
					.getBoolean(CREATE_SUBPACKAGE_KEY));
		} else {
			newSubPackageButton.setSelection(true);
		}
		
		if (dialogSetting.get(CREATE_IMPL_TYPE_ASM_KEY) == null) {
			dialogSetting.put(CREATE_IMPL_TYPE_ASM_KEY, true);
		}
		boolean isAssemblyTypeSelected = dialogSetting.getBoolean(CREATE_IMPL_TYPE_ASM_KEY);
		assemblyButton.setSelection(isAssemblyTypeSelected);
		monolithicButton.setSelection(!isAssemblyTypeSelected);
				
		enableImplementationGroup(isCreateImplementationButton.getSelection());
	}
	
	private void implementationTypeChange(){
		String suffix;
		
		//on implementation kind change, we need to update implementation name field
		if (assemblyButton.getSelection()){
			suffix = preferenceStore
						.getString(CCMPreferenceConstants.ASSEMBLY_IMPLEMENTATION_SUFFIX);
		}
		else{
			suffix = preferenceStore
						.getString(CCMPreferenceConstants.MONOLITHIC_IMPLEMENTATION_SUFFIX);
		}
		implementationNameField
				.setText(calculateDefaultName(
						nameField.getText(),
						suffix));
		validate();
	}

}
