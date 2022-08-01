/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.tools.ui.internal.preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.service.prefs.BackingStoreException;

import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.cx.ui.pathmap.CXPathmapDescriptor;
import com.zeligsoft.domain.dds4ccm.tools.Activator;
import com.zeligsoft.domain.dds4ccm.tools.PreferenceConstants;
import com.zeligsoft.domain.dds4ccm.tools.dialogs.PathmapSelectionComposite;
import com.zeligsoft.domain.dds4ccm.tools.internal.emf.DDS4CCMDynamicURIMapHandler;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;

/**
 * Dynamic URI mapping preference page.
 * 
 * @author Young-Soo Roh
 *
 */
public class DynamicURIMappingsPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	private CheckboxTableViewer tableViewer;
	
	/**
	 * Initializes me.
	 */
	public DynamicURIMappingsPreferencePage() {
		super();
	}

	@Override
	protected Control createContents(Composite parent) {
		List<URI> pathmapURIs = new ArrayList<URI>();
		for(CXPathmapDescriptor desc: CXDynamicURIConverter.getPathmaps()) {
			pathmapURIs.add(desc.getPathmap());
		}
		PathmapSelectionComposite selectionComposite = new PathmapSelectionComposite();
		Composite result = selectionComposite.createContents(parent);
		tableViewer = selectionComposite.getViewer();

		noDefaultAndApplyButton();
		contributeButtons(result);
		
		Button button = new Button(result, SWT.PUSH);
		button.setText(Messages.DynamicURIMappingsPreferencePage_ResetSuppressedWarningButton);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (MessageDialog.openQuestion(getShell(), Messages.DynamicURIMappingsPreferencePage_ResetWarningsTitle,
						Messages.DynamicURIMappingsPreferencePage_ResetWarningsMsg)) {

					IEclipsePreferences store = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);

					List<String> keysToRemove = new ArrayList<String>();

					try {
						for (String key : store.keys()) {
							if (key.startsWith(PreferenceConstants.WARNING_SUPPRESSED_PATHMAP)) {
								keysToRemove.add(key);
							}
						}
					} catch (BackingStoreException e1) {
						// do nothing
					}

					for (String key : keysToRemove) {
						store.remove(key);
					}

					store.remove(PreferenceConstants.SUPPRESS_PATHMAP_CHANGE_WARNING);
					store.remove(PreferenceConstants.SUPPRESS_PATHMAP_FALLBACK_WARNING);
					try {

						store.flush();
					} catch (BackingStoreException e1) {
						// do nothing
					}
					tableViewer.setInput(tableViewer.getInput());
				}
			}
		});
		
		return result;
	}
	
	@Override
	protected void contributeButtons(Composite parent) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText(Messages.DynamicURIMappingsPreferencePage_RemapLabel);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DDS4CCMDynamicURIMapHandler.remapDynamicURI();
				tableViewer.setInput(tableViewer.getInput());
				List<URI> selected = CXDynamicURIConverter.getEnabledPathmaps().stream().map(d -> d.getPathmap())
						.collect(Collectors.toList());
				tableViewer.setCheckedElements(selected.toArray());
			}
		});
	}


	@Override
	public void init(IWorkbench workbench) {
		// do nothing
	}
}
