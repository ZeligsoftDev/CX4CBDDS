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

package com.zeligsoft.cx.ui.preferences;

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
import com.zeligsoft.cx.CXActivator;
import com.zeligsoft.cx.preferences.CXPreferenceConstants;
import com.zeligsoft.cx.ui.l10n.Messages;

/**
 * CX modeling preference page.
 * 
 * @author Young-Soo Roh (ysroh)
 */
@SuppressWarnings("deprecation")
public class ModelingPreferencePage
		extends PreferencePage
		implements IWorkbenchPreferencePage {

	private Text cdtProjectSuffixInputField;
	private Button generateIDLComment;

	private Preferences store;

	/*
	 * (non-Javadoc)
	 * 
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
		
		createCDTProjectNameSuffixArea(panel);
		createGenerateIDLCommentArea(panel);
		return panel;
	}
	
	/**
	 * Generate IDL commnet area
	 * 
	 * @param panel
	 */
	private void createGenerateIDLCommentArea(Composite panel) {
		generateIDLComment = new Button(panel, SWT.CHECK);
		generateIDLComment
				.setText(Messages.ModelingPreferencePage_GenerateIDLComment);
		generateIDLComment.setSelection(store
				.getBoolean(CXPreferenceConstants.GENERATE_IDL_COMMENT));
	}

	/**
	 * Creates CDT Project name suffix area
	 * 
	 * @param parent
	 */
	private void createCDTProjectNameSuffixArea(Composite parent) {

		Group group = new Group(parent, SWT.NULL);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		group.setText(Messages.ModelingPreferencePage_CDTProjectSettingLabel);
		group.setLayout(new GridLayout(2, false));

		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));

		Label label = new Label(group, SWT.NULL);
		label
			.setText(Messages.ModelingPreferencePage_CDTProjectNameSuffixInputLabel);

		String defaultString = store
			.getString(CXPreferenceConstants.CDT_PROJECT_SUFFIX);

		cdtProjectSuffixInputField = new Text(group, SWT.BORDER);
		cdtProjectSuffixInputField.setLayoutData(new GridData(
			GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		cdtProjectSuffixInputField.setText(defaultString);

		cdtProjectSuffixInputField.addListener(SWT.Modify,
			new PreferencePageValidStringListener(this, cdtProjectSuffixInputField));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 */
	@Override
	public boolean performOk() {

		// CDT project suffix
		store.setValue(CXPreferenceConstants.CDT_PROJECT_SUFFIX,
			cdtProjectSuffixInputField.getText());

		store.setValue(CXPreferenceConstants.GENERATE_IDL_COMMENT,
				generateIDLComment.getSelection());
		
		CXActivator.getDefault().savePluginPreferences();
		
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 */
	@Override
	protected void performDefaults() {
		super.performDefaults();

		// CDT project
		cdtProjectSuffixInputField
			.setText(CXPreferenceConstants.DEFAULT_CDT_PROJECT_SUFFIX);
		
		generateIDLComment
				.setSelection(CXPreferenceConstants.GENERATE_IDL_COMMENT_DEFAULT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {
		store = CXActivator.getDefault().getPluginPreferences();
	}
}
