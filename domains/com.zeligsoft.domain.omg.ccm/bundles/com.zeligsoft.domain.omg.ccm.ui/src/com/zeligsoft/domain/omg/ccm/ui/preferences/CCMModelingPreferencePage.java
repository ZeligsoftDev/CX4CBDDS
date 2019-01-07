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

package com.zeligsoft.domain.omg.ccm.ui.preferences;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.zeligsoft.base.ui.utils.PreferencePageValidStringListener;
import com.zeligsoft.domain.omg.ccm.preferences.CCMPreferenceConstants;
import com.zeligsoft.domain.omg.ccm.ui.l10n.Messages;

/**
 * CCM modeling preference page.
 * 
 * @author Young-Soo Roh (ysroh)
 */
@SuppressWarnings("deprecation")
public class CCMModelingPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private Text asmImplSuffixField;
	
	private Text monoImplSuffixField;

	private Text pkgSuffixField;
	
	private Text diagSuffixField;
	
	private Text subpackageNameField;

	private Button autoTypeSelectionDialogButton;

	private Preferences preferenceStore;

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse
	 * .swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {

		Composite panel = new Composite(parent, SWT.NONE);

		GridLayout grid = new GridLayout(1, false);
		panel.setLayout(grid);

		GridData data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		panel.setLayoutData(data);

		createComponentArea(panel);

		createSelectionDialogArea(panel);

		loadComponentDefault();

		return panel;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.DialogPage#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 */
	@Override
	public boolean performOk() {

		preferenceStore.setValue(CCMPreferenceConstants.ASSEMBLY_IMPLEMENTATION_SUFFIX,
				asmImplSuffixField.getText());
		preferenceStore.setValue(CCMPreferenceConstants.MONOLITHIC_IMPLEMENTATION_SUFFIX,
				monoImplSuffixField.getText());
		preferenceStore.setValue(CCMPreferenceConstants.PACKAGE_SUFFIX, pkgSuffixField
				.getText());
		preferenceStore.setValue(CCMPreferenceConstants.DIAGRAM_SUFFIX, diagSuffixField
				.getText());
		preferenceStore.setValue(CCMPreferenceConstants.AUTO_TYPE_SELECTION_DIALOG,
				autoTypeSelectionDialogButton.getSelection());	
				
		String subpackageText = subpackageNameField.getText();
		if (!subpackageText.isEmpty()){
			preferenceStore.setValue(CCMPreferenceConstants.SUBPACKAGE_NAME_CONSTANT, 
					subpackageText);
		}
		else{
			subpackageNameField.setText(CCMPreferenceConstants.DEFAULT_SUBPACKAGE_NAME_CONSTANT);
		}
		
		com.zeligsoft.domain.omg.ccm.Activator.getDefault().savePluginPreferences();
		
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 */
	@Override
	protected void performDefaults() {
		super.performDefaults();

		// component wizard
		asmImplSuffixField.setText(CCMPreferenceConstants.DEFAULT_ASSEMBLY_IMPLEMENTATION_SUFFIX);
		monoImplSuffixField.setText(CCMPreferenceConstants.DEFAULT_MONOLITHIC_IMPLEMENTATION_SUFFIX);
		pkgSuffixField.setText(CCMPreferenceConstants.DEFAULT_PACKAGE_SUFFIX);
		diagSuffixField.setText(CCMPreferenceConstants.DEFAULT_DIAGRAM_SUFFIX);
		autoTypeSelectionDialogButton
				.setSelection(CCMPreferenceConstants.DEFAULT_AUTO_TYPE_SELECTION_DIALOG);
		subpackageNameField.setText(CCMPreferenceConstants.DEFAULT_SUBPACKAGE_NAME_CONSTANT);
		
	}

	public void init(IWorkbench workbench) {
		preferenceStore = com.zeligsoft.domain.omg.ccm.Activator.getDefault()
				.getPluginPreferences();
	}

	/**
	 * Creates Component Area
	 * 
	 * @param parent
	 */
	private void createComponentArea(Composite parent) {
		
		Group parentGroup = new Group(parent, SWT.NULL);
		parentGroup.setLayout(new GridLayout());
		parentGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		parentGroup.setText(Messages.CCMModelingPreferencePage_ComponentWizardSettingGroupLabel);
		
		//Suffixes group
		Group suffixGroup = new Group(parentGroup, SWT.NULL);
		suffixGroup.setLayout(new GridLayout(2, false));
		suffixGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		suffixGroup.setText(Messages.CCMModelingPreferencePage_Suffixes);

		GridData data = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);

		Label label = new Label(suffixGroup, SWT.NULL);
		label.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		label.setText(Messages.CCMModelingPreferencePage_AssemblySuffixLabel);

		asmImplSuffixField = new Text(suffixGroup, SWT.BORDER);
		asmImplSuffixField.setLayoutData(data);

		asmImplSuffixField.addListener(SWT.Modify, new PreferencePageValidStringListener(
				this, asmImplSuffixField));
		
		label = new Label(suffixGroup, SWT.NULL);
		label.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		label.setText(Messages.CCMModelingPreferencePage_MonolithicSuffixLabel);

		monoImplSuffixField = new Text(suffixGroup, SWT.BORDER);
		monoImplSuffixField.setLayoutData(data);

		monoImplSuffixField.addListener(SWT.Modify, new PreferencePageValidStringListener(
				this, monoImplSuffixField));

		label = new Label(suffixGroup, SWT.NULL);
		label.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		label.setText(Messages.CCMModelingPreferencePage_PackageSuffixLabel);

		pkgSuffixField = new Text(suffixGroup, SWT.BORDER);
		pkgSuffixField.setLayoutData(data);

		pkgSuffixField.addListener(SWT.Modify, new PreferencePageValidStringListener(
				this, pkgSuffixField));

		label = new Label(suffixGroup, SWT.NULL);
		label.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		label.setText(Messages.CCMModelingPreferencePage_DiagramSuffixLabel);

		diagSuffixField = new Text(suffixGroup, SWT.BORDER);
		diagSuffixField.setLayoutData(data);

		diagSuffixField.addListener(SWT.Modify, new PreferencePageValidStringListener(
				this, diagSuffixField));
				
		//Monolithic Implementation defaults	
		Group monoGroup = new Group(parentGroup, SWT.SHADOW_IN);
		monoGroup.setText(Messages.CCMModelingPreferencePage_MonoImpl);
		monoGroup.setLayout(new GridLayout(2, false));
		monoGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
	    
		Label subpackageLabel = new Label(monoGroup, SWT.NULL);
		subpackageLabel.setText(Messages.CCMModelingPreferencePage_SubpackageName);
	    
	    subpackageNameField = new Text(monoGroup, SWT.BORDER);
	    GridData gd = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
	    gd.grabExcessHorizontalSpace=true;
	    subpackageNameField.setLayoutData(gd);	    	    
	}

	private void createSelectionDialogArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);

		GridLayout grid = new GridLayout(1, false);
		composite.setLayout(grid);

		GridData data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		composite.setLayoutData(data);

		autoTypeSelectionDialogButton = new Button(composite, SWT.CHECK);
		autoTypeSelectionDialogButton
				.setText(Messages.CCMModelingPreferencePage_TypeSelectionDialogButtonLabel);
		autoTypeSelectionDialogButton.setSelection(preferenceStore
				.getBoolean(CCMPreferenceConstants.AUTO_TYPE_SELECTION_DIALOG));
	}

	/**
	 * Load defaults for Component fields
	 */
	private void loadComponentDefault() {

		String asmImplSuffix = preferenceStore
				.getString(CCMPreferenceConstants.ASSEMBLY_IMPLEMENTATION_SUFFIX);
		String monoImplSuffix = preferenceStore
				.getString(CCMPreferenceConstants.MONOLITHIC_IMPLEMENTATION_SUFFIX);
		String pkgSuffix = preferenceStore
				.getString(CCMPreferenceConstants.PACKAGE_SUFFIX);
		String diagSuffix = preferenceStore
				.getString(CCMPreferenceConstants.DIAGRAM_SUFFIX);
		boolean autoTypeSelectionDialog = preferenceStore
				.getBoolean(CCMPreferenceConstants.AUTO_TYPE_SELECTION_DIALOG);
		String packageNameConstant = preferenceStore
				.getString(CCMPreferenceConstants.SUBPACKAGE_NAME_CONSTANT);
		
		asmImplSuffixField.setText(asmImplSuffix);
		monoImplSuffixField.setText(monoImplSuffix);
		pkgSuffixField.setText(pkgSuffix);
		diagSuffixField.setText(diagSuffix);
		autoTypeSelectionDialogButton.setSelection(autoTypeSelectionDialog);
		subpackageNameField.setText(packageNameConstant);
	}
}
