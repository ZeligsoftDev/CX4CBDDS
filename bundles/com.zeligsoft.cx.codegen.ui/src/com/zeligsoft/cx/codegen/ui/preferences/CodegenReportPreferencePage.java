/**
 * Copyright 2021 Zeligsoft.
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

package com.zeligsoft.cx.codegen.ui.preferences;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.service.prefs.BackingStoreException;

import com.zeligsoft.base.Activator;
import com.zeligsoft.cx.CXActivator;
import com.zeligsoft.cx.preferences.CXPreferenceConstants;
import com.zeligsoft.cx.codegen.ui.l10n.Messages;

/**
 * CX codegen report preference page.
 * 
 * @author Ernesto Posse
 */
public class CodegenReportPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	private static final IPreferencesService PREFERENCE_SERVICE = Platform.getPreferencesService();

	private static final IEclipsePreferences WORKSPACE_PREFERENCES = InstanceScope.INSTANCE
			.getNode(CXActivator.PLUGIN_ID);

	private static final IEclipsePreferences CONFIGURATION_PREFERENCES = ConfigurationScope.INSTANCE
			.getNode(CXActivator.PLUGIN_ID);

	private enum FilesSet {
		ADDED, CHANGED, REMOVED, UNCHANGED, BEFORE, AFTER
	}

	// Stores the preference value when the page is opened, in case Cancel is
	// clicked.
	private Map<FilesSet, Boolean> currentValue = new HashMap<FilesSet, Boolean>();

	private Map<FilesSet, Button> includeFilesSetCheckbox = new HashMap<FilesSet, Button>();
	private static Map<FilesSet, String> filesSetCheckboxLabel = new HashMap<FilesSet, String>();
	private static Map<FilesSet, String> checkBoxPreferenceKey = new HashMap<FilesSet, String>();
	private static Map<FilesSet, Boolean> checkBoxPreferenceDefault = new HashMap<FilesSet, Boolean>();

	static {
		filesSetCheckboxLabel.put(FilesSet.ADDED, Messages.CXCodegenPreferencePage_FilesAddedCheckbox);
		filesSetCheckboxLabel.put(FilesSet.CHANGED, Messages.CXCodegenPreferencePage_FilesChangedCheckbox);
		filesSetCheckboxLabel.put(FilesSet.REMOVED, Messages.CXCodegenPreferencePage_FilesRemovedCheckbox);
		filesSetCheckboxLabel.put(FilesSet.UNCHANGED, Messages.CXCodegenPreferencePage_FilesUnchangedCheckbox);
		filesSetCheckboxLabel.put(FilesSet.BEFORE, Messages.CXCodegenPreferencePage_FilesBeforeCheckbox);
		filesSetCheckboxLabel.put(FilesSet.AFTER, Messages.CXCodegenPreferencePage_FilesAfterCheckbox);
		checkBoxPreferenceKey.put(FilesSet.ADDED, CXPreferenceConstants.FILE_COLLECTOR_FILES_ADDED);
		checkBoxPreferenceKey.put(FilesSet.CHANGED, CXPreferenceConstants.FILE_COLLECTOR_FILES_CHANGED);
		checkBoxPreferenceKey.put(FilesSet.REMOVED, CXPreferenceConstants.FILE_COLLECTOR_FILES_REMOVED);
		checkBoxPreferenceKey.put(FilesSet.UNCHANGED, CXPreferenceConstants.FILE_COLLECTOR_FILES_UNCHANGED);
		checkBoxPreferenceKey.put(FilesSet.BEFORE, CXPreferenceConstants.FILE_COLLECTOR_FILES_BEFORE);
		checkBoxPreferenceKey.put(FilesSet.AFTER, CXPreferenceConstants.FILE_COLLECTOR_FILES_AFTER);
		checkBoxPreferenceDefault.put(FilesSet.ADDED, CXPreferenceConstants.FILE_COLLECTOR_FILES_ADDED_DEFAULT);
		checkBoxPreferenceDefault.put(FilesSet.CHANGED, CXPreferenceConstants.FILE_COLLECTOR_FILES_CHANGED_DEFAULT);
		checkBoxPreferenceDefault.put(FilesSet.REMOVED, CXPreferenceConstants.FILE_COLLECTOR_FILES_REMOVED_DEFAULT);
		checkBoxPreferenceDefault.put(FilesSet.UNCHANGED, CXPreferenceConstants.FILE_COLLECTOR_FILES_UNCHANGED_DEFAULT);
		checkBoxPreferenceDefault.put(FilesSet.BEFORE, CXPreferenceConstants.FILE_COLLECTOR_FILES_BEFORE_DEFAULT);
		checkBoxPreferenceDefault.put(FilesSet.AFTER, CXPreferenceConstants.FILE_COLLECTOR_FILES_AFTER_DEFAULT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Activator.getDefault().error("Error saving preferences", e);
	 * 
	 * org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse
	 * .swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {

		final Composite panel = new Composite(parent, SWT.NONE);

		final GridLayout layout = new GridLayout(1, false);
		panel.setLayout(layout);

		final GridData data = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		panel.setLayoutData(data);

		createFileCollectorGroup(panel);

		panel.addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				data.widthHint = panel.getClientArea().width - 2 * layout.marginWidth;
				panel.layout(true);
			}
		});
		panel.layout(true);
		return panel;
	}

	private void createFileCollectorGroup(Composite panel) {
		Group group = new Group(panel, SWT.NULL);
		group.setLayout(new GridLayout(1, false));
		final GridData data = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		group.setLayoutData(data);
		group.setText(Messages.CXCodegenPreferencePage_FileCollectorGroup);

		createFileCollectorQuestion(group);
		createFilesSetCheckbox(group, FilesSet.ADDED);
		createFilesSetCheckbox(group, FilesSet.CHANGED);
		createFilesSetCheckbox(group, FilesSet.REMOVED);
		createFilesSetCheckbox(group, FilesSet.UNCHANGED);
		createFilesSetCheckbox(group, FilesSet.BEFORE);
		createFilesSetCheckbox(group, FilesSet.AFTER);
		group.layout(true);
	}

	private void createFileCollectorQuestion(Composite group) {
		Label label = new Label(group, SWT.WRAP | SWT.LEFT);
		final GridData data = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		data.widthHint = 400;
		label.setLayoutData(data);

		label.setText(Messages.CXCodegenPreferencePage_FileCollectorQuestion);
	}

	private void createFilesSetCheckbox(Composite group, FilesSet filesSet) {
		includeFilesSetCheckbox.put(filesSet, new Button(group, SWT.CHECK));
		includeFilesSetCheckbox.get(filesSet).setText(filesSetCheckboxLabel.get(filesSet));
		includeFilesSetCheckbox.get(filesSet).setSelection(PREFERENCE_SERVICE.getBoolean(CXActivator.PLUGIN_ID,
				checkBoxPreferenceKey.get(filesSet), checkBoxPreferenceDefault.get(filesSet), null));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performApply()
	 */
	@Override
	protected void performApply() {
		for (FilesSet filesSet : FilesSet.values()) {
			boolean checkBoxValue = includeFilesSetCheckbox.get(filesSet).getSelection();
			WORKSPACE_PREFERENCES.putBoolean(checkBoxPreferenceKey.get(filesSet), checkBoxValue);
		}
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performCancel()
	 */
	@Override
	public boolean performCancel() {
		Activator.getDefault().info("Cancelling change to preference. ");
		for (FilesSet filesSet : FilesSet.values()) {
			WORKSPACE_PREFERENCES.putBoolean(checkBoxPreferenceKey.get(filesSet), currentValue.get(filesSet));
		}
		try {
			WORKSPACE_PREFERENCES.flush();
		} catch (BackingStoreException e) {
			Activator.getDefault().error("Error saving preferences", e);
			e.printStackTrace();
		}
		return true;
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 */
	@Override
	public boolean performOk() {
		performApply();
		try {
			Activator.getDefault().info("Saving CX Code generator preferences. ");
			WORKSPACE_PREFERENCES.flush();
		} catch (BackingStoreException e) {
			Activator.getDefault().error("Error saving preferences", e);
			e.printStackTrace();
		}

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
		for (FilesSet filesSet : FilesSet.values()) {
			boolean cfgValue = CONFIGURATION_PREFERENCES.getBoolean(checkBoxPreferenceKey.get(filesSet),
					checkBoxPreferenceDefault.get(filesSet));

			WORKSPACE_PREFERENCES.putBoolean(checkBoxPreferenceKey.get(filesSet), cfgValue);

			includeFilesSetCheckbox.get(filesSet).setSelection(cfgValue);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {
		for (FilesSet filesSet : FilesSet.values()) {
			currentValue.put(filesSet, PREFERENCE_SERVICE.getBoolean(CXActivator.PLUGIN_ID,
					checkBoxPreferenceKey.get(filesSet), checkBoxPreferenceDefault.get(filesSet), null));
		}
	}
}
