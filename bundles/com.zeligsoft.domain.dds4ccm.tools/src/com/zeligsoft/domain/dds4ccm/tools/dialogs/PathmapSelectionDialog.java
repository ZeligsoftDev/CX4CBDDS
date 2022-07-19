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
package com.zeligsoft.domain.dds4ccm.tools.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.prefs.BackingStoreException;

import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.cx.ui.pathmap.CXPathmapDescriptor;
import com.zeligsoft.domain.dds4ccm.DDS4CCMPreferenceConstants;
import com.zeligsoft.domain.dds4ccm.tools.Activator;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;

/**
 * Pathmap conflict dialog.
 * 
 * @author Young-Soo Roh
 *
 */
public class PathmapSelectionDialog extends TrayDialog {

	protected String message;
	protected String preferenceLink;
	protected IEclipsePreferences store;
	protected boolean warningSuppressed = false;
	public static boolean dialogInUse = false;

	public PathmapSelectionDialog(Shell shell, String message, String preferenceLink) {
		super(shell);
		this.preferenceLink = preferenceLink;
		this.message = message;
		store = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
	}

	@Override
	public void create() {
		super.create();
		Shell shell = getShell();
		shell.setText(Messages.PathmapSelectionDialog_DialogTitle);
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createMessageArea(composite);

		createButtonArea(composite);

		return composite;

	}

	private void createMessageArea(Composite parent) {
		Composite browseComposite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		browseComposite.setLayout(layout);
		browseComposite
				.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));

		Label label = new Label(browseComposite, SWT.NONE);
		label.setText(message);
		label.setBackground(browseComposite.getBackground());

		new PathmapSelectionComposite(true).createContents(browseComposite);

	}

	private void createButtonArea(Composite composite) {
		Composite barComposite = new Composite(composite, SWT.NULL);
		GridLayout compositeLayout = new GridLayout();
		compositeLayout = new GridLayout();
		compositeLayout.numColumns = 2;
		GridData compositeLData = new GridData(
				GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_END);
		barComposite.setLayoutData(compositeLData);
		barComposite.setLayout(compositeLayout);

		Button suppressWarningButton = new Button(barComposite, SWT.CHECK);
		suppressWarningButton.setText(Messages.PathmapConflictDialog_SuppressWarnings);
		suppressWarningButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				warningSuppressed = suppressWarningButton.getSelection();
			}
		});

		GridData buttonData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		buttonData.widthHint = 70;

		Button okButton = createButton(barComposite, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);

		okButton.setLayoutData(buttonData);
		okButton.setEnabled(true);
		okButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (warningSuppressed == false) {
					return;
				}
				for (URI pathmap : CXDynamicURIConverter.getNewConflictPathmaps()) {
					// suppress future warnings for this pathmap state
					String prefConstant = DDS4CCMPreferenceConstants.WARNING_SUPPRESSED_PATHMAP + pathmap.toString();
					String suppressedMappings = store.get(prefConstant,
							DDS4CCMPreferenceConstants.DEFAULT_WARNING_SUPPRESSED_PATHMAP);
					List<String> mappings = new ArrayList<String>();
					mappings.addAll(Arrays.asList(suppressedMappings.split("\\s*,\\s*"))); //$NON-NLS-1$

					List<CXPathmapDescriptor> descs = CXDynamicURIConverter.getPathmapDescriptors(pathmap);
					for (CXPathmapDescriptor desc : descs) {
						if (!mappings.contains(desc.getMapping().toString())) {
							mappings.add(desc.getMapping().toString());
						}
					}
					store.put(prefConstant, String.join(",", mappings)); //$NON-NLS-1$

					String suppressedPathmaps = store.get(DDS4CCMPreferenceConstants.WARNING_SUPPRESSED_PATHMAP,
							DDS4CCMPreferenceConstants.DEFAULT_WARNING_SUPPRESSED_PATHMAP);
					List<String> pathmaps = new ArrayList<String>();
					pathmaps.addAll(Arrays.asList(suppressedPathmaps.split("\\s*,\\s*"))); //$NON-NLS-1$
					if (!pathmaps.contains(pathmap.toString())) {
						pathmaps.add(pathmap.toString());
						store.put(DDS4CCMPreferenceConstants.WARNING_SUPPRESSED_PATHMAP, String.join(",", pathmaps)); //$NON-NLS-1$
					}
				}

				try {
					store.flush();
				} catch (BackingStoreException e1) {
					// pass
				}
			}
		});
	}

	@Override
	public int open() {
		int result = Dialog.OK;
		if (dialogInUse != true) {
			dialogInUse = true;
			result = super.open();
			dialogInUse = false;
			CXDynamicURIConverter.clearNewConflictPathmaps();
		}
		return result;
	}
}
