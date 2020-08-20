/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.rsm.ui.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.zeligsoft.ddk.rsm.ui.Activator;
import com.zeligsoft.ddk.rsm.ui.DomainDevelopmentConstants;
import com.zeligsoft.ddk.rsm.ui.l10n.Messages;

/**
 * Preference page for the Domain Development specific content.
 * 
 * @author jcorchis
 * 
 */
public class DomainDevelopmentPreferencePage
		extends PreferencePage
		implements IWorkbenchPreferencePage {

	// Input field
	private Text namesPackageFilter;

	@Override
	protected Control createContents(Composite parent) {
		Composite panel = new Composite(parent, SWT.NONE);

		GridLayout grid = new GridLayout(1, false);
		panel.setLayout(grid);

		GridData data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		panel.setLayoutData(data);

		createNameGenerationPrefArea(panel);

		return panel;
	}
	
	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		IPreferenceStore store = Activator.getDefault()
		.getPreferenceStore();
		return store;
	}

	private void createNameGenerationPrefArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);

		composite.setLayout(new GridLayout(3, false));

		GridData data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		composite.setLayoutData(data);

		Label namesPackageFilterLabel = new Label(composite, SWT.NULL);
		namesPackageFilterLabel
			.setText(Messages.ZDLConstantsGenerationActionDelegate_namesPackageFilterLabel);

		String defaultString = getPreferenceStore()
			.getString(DomainDevelopmentConstants.NAMES_PACKAGE_FILTER);

		data = new GridData();
		data.widthHint = 100;
		namesPackageFilter = new Text(composite, SWT.BORDER);
		namesPackageFilter.setLayoutData(data);
		namesPackageFilter.setText(defaultString);
	}

	@Override
	public boolean performOk() {
		
		IPreferenceStore store = getPreferenceStore();

		// Save preference values
		store.setValue(DomainDevelopmentConstants.NAMES_PACKAGE_FILTER,
			namesPackageFilter.getText());

		return true;
	}

	@Override
	public void init(IWorkbench workbench) {
		//	
	}

}
