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

package com.zeligsoft.domain.dds4ccm.ui.preferences;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
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
import org.osgi.service.prefs.BackingStoreException;

import com.zeligsoft.cx.CXActivator;
import com.zeligsoft.cx.preferences.CXPreferenceConstants;
import com.zeligsoft.domain.dds4ccm.Activator;
import com.zeligsoft.domain.dds4ccm.DDS4CCMPreferenceConstants;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;

/**
 * DDS4CCM Domain preference page.
 * 
 * @author Young-Soo Roh (ysroh)
 */
public class DDS4CCMPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private Text fixedHeader;

	private Text fixedFooter;

	private Text locationPrefix;
	
	private Button generateIDLComment;

	private IEclipsePreferences store;

	private IEclipsePreferences cxStore;

	@Override
	public void init(IWorkbench workbench) {
		store = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
		cxStore = InstanceScope.INSTANCE.getNode(CXActivator.PLUGIN_ID);
	}

	@Override
	protected Control createContents(Composite parent) {

		Composite panel = new Composite(parent, SWT.NONE);

		GridLayout grid = new GridLayout(2, false);
		grid.verticalSpacing = 10;
		panel.setLayout(grid);

		GridData data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		panel.setLayoutData(data);

		createGenerateIDLCommentArea(panel);

		createIDLGenerationArea(panel);

		createLocationPrefixArea(panel);

		return panel;
	}
	
	
	/**
	 * Generate IDL commnet area
	 * 
	 * @param panel
	 */
	private void createGenerateIDLCommentArea(Composite panel) {
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 2;
		generateIDLComment = new Button(panel, SWT.CHECK);
		generateIDLComment.setLayoutData(data);
		generateIDLComment
				.setText(com.zeligsoft.cx.ui.l10n.Messages.ModelingPreferencePage_GenerateIDLComment);
		generateIDLComment.setSelection(cxStore.getBoolean(CXPreferenceConstants.GENERATE_IDL_COMMENT,
				CXPreferenceConstants.GENERATE_IDL_COMMENT_DEFAULT));
	}

	/**
	 * Codegen util area
	 * 
	 * @param panel
	 */
	private void createLocationPrefixArea(Composite parent) {
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;

		Group group = new Group(parent, SWT.NULL);
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(data);
		group.setText(Messages.DDS4CCMPreferencePage_DescriptorSettingsLabel);

		Label label = new Label(group, SWT.NULL);
		label.setText(Messages.DDS4CCMPreferencePage_GlobalPrefixLabel);
		locationPrefix = new Text(group, SWT.BORDER);
		locationPrefix.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		locationPrefix.setText(store.get(
				DDS4CCMPreferenceConstants.GLOBAL_LOCATION_PREFIX,
				DDS4CCMPreferenceConstants.DEFAULT_GLOBAL_LOCATION_PREFIX));
	}

	private void createIDLGenerationArea(Composite parent) {
		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 2;

		Group group = new Group(parent, SWT.NULL);
		group.setLayout(new GridLayout(1, false));
		group.setLayoutData(data);
		group.setText(Messages.DDS4CCMPreferencePage_IDLGenerationGroupTitle);

		Group headerGroup = new Group(group, SWT.NULL);
		headerGroup.setLayout(new GridLayout(1, false));
		headerGroup.setLayoutData(data);
		headerGroup.setText(Messages.DDS4CCMPreferencePage_FixedHeader);
		fixedHeader = new Text(headerGroup, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		GridData data1 = new GridData(GridData.FILL_BOTH);
		fixedHeader.setLayoutData(data1);
		fixedHeader.setText(store.get(
				DDS4CCMPreferenceConstants.IDL_FIXED_HEADER,
				DDS4CCMPreferenceConstants.DEFAULT_IDL_FIXED_HEADER));

		Group footerGroup = new Group(group, SWT.NULL);
		footerGroup.setLayout(new GridLayout(1, false));
		footerGroup.setLayoutData(data);
		footerGroup.setText(Messages.DDS4CCMPreferencePage_FixedFooter);
		fixedFooter = new Text(footerGroup, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		fixedFooter.setLayoutData(data1);
		fixedFooter.setText(store.get(
				DDS4CCMPreferenceConstants.IDL_FIXED_FOOTER,
				DDS4CCMPreferenceConstants.DEFAULT_IDL_FIXED_FOOTER));
	}

	@Override
	protected void performDefaults() {
		fixedHeader
				.setText(DDS4CCMPreferenceConstants.DEFAULT_IDL_FIXED_HEADER);
		fixedFooter
				.setText(DDS4CCMPreferenceConstants.DEFAULT_IDL_FIXED_FOOTER);
		locationPrefix
				.setText(DDS4CCMPreferenceConstants.DEFAULT_GLOBAL_LOCATION_PREFIX);
		generateIDLComment
				.setSelection(CXPreferenceConstants.GENERATE_IDL_COMMENT_DEFAULT);

	}

	@Override
	public boolean performOk() {
		store.put(DDS4CCMPreferenceConstants.IDL_FIXED_HEADER,
				fixedHeader.getText());
		store.put(DDS4CCMPreferenceConstants.IDL_FIXED_FOOTER,
				fixedFooter.getText());
		store.put(DDS4CCMPreferenceConstants.GLOBAL_LOCATION_PREFIX,
				locationPrefix.getText());
		cxStore.putBoolean(CXPreferenceConstants.GENERATE_IDL_COMMENT,
				generateIDLComment.getSelection());
		try {
			store.flush();
			cxStore.flush();
		} catch (BackingStoreException e) {
			com.zeligsoft.domain.dds4ccm.ui.Activator.getDefault().error(
					"Error saving preference value", e); //$NON-NLS-1$
		}
		return true;
	}
}