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
import java.util.Arrays;
import java.util.List;

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
import com.zeligsoft.domain.dds4ccm.DDS4CCMPreferenceConstants;
import com.zeligsoft.domain.dds4ccm.tools.Activator;
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

	private CheckboxTableViewer table;
	
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

					// reset all suppressed mapping details
					String suppressed = store.get(DDS4CCMPreferenceConstants.WARNING_SUPPRESSED_PATHMAP,
							DDS4CCMPreferenceConstants.DEFAULT_WARNING_SUPPRESSED_PATHMAP);
					List<String> suppressedPathmaps = Arrays.asList(suppressed.split("\\s*,\\s*")); //$NON-NLS-1$
					for (String pathmap : suppressedPathmaps) {
						String key = DDS4CCMPreferenceConstants.WARNING_SUPPRESSED_PATHMAP + pathmap;
						store.remove(key);
					}

					// reset all suppressed pathmaps
					store.remove(DDS4CCMPreferenceConstants.WARNING_SUPPRESSED_PATHMAP);

					try {
						store.flush();
					} catch (BackingStoreException e1) {
						// do nothing
					}
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
				List<CXPathmapDescriptor> pathmaps = CXDynamicURIConverter.getPathmaps();
				table.setInput(pathmaps);
				List<CXPathmapDescriptor> selected = CXDynamicURIConverter.getEnabledPathmaps();
				table.setCheckedElements(selected.toArray());
			}
		});
	}


	@Override
	public void init(IWorkbench workbench) {
		// do nothing
	}
}
