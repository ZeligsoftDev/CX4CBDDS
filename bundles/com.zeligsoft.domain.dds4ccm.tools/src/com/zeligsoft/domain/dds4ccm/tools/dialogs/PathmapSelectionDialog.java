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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.osgi.service.prefs.BackingStoreException;

import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.cx.ui.pathmap.CXPathmapDescriptor;
import com.zeligsoft.domain.dds4ccm.tools.Activator;
import com.zeligsoft.domain.dds4ccm.tools.PreferenceConstants;
import com.zeligsoft.domain.dds4ccm.tools.internal.emf.DDS4CCMDynamicURIMapHandler;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;

/**
 * Pathmap selection dialog for conflict pathmaps.
 * 
 * @author Young-Soo Roh
 *
 */
public class PathmapSelectionDialog extends TrayDialog {

	protected String message;
	protected String preferenceLink;
	protected IEclipsePreferences store;
	protected boolean warningSuppressed = false;
	protected Set<URI> pathmaps = new HashSet<URI>();
	private PathmapSelectionComposite pathmapSelectionComposite;
	private static final Lock lock = new ReentrantLock();
	private static boolean dialogInUse = false;

	public PathmapSelectionDialog(Shell shell) {
		super(shell);
		this.preferenceLink = "com.zeligsoft.domain.dds4ccm.tools.uriMappings"; //$NON-NLS-1$
		this.message = Messages.PathmapSelectionDialog_ConflictErrorMessage;
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
		Composite selectionComposite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		selectionComposite.setLayout(layout);
		GridData data = new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL);
		data.heightHint = 300;
				
		selectionComposite.setLayoutData(data);

		Label label = new Label(selectionComposite, SWT.NONE);
		label.setText(message);
		label.setBackground(selectionComposite.getBackground());

		pathmapSelectionComposite = new PathmapSelectionComposite(pathmaps);
		pathmapSelectionComposite.createContents(selectionComposite);

		Link link = new Link(selectionComposite, SWT.NONE);
		link.setText(Messages.PathmapSelectionDialog_PreferenceLink);
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(getShell(), preferenceLink,
						new String[] { preferenceLink }, null);
				dialog.open();
				close();
			}
		});

	}

	private void createButtonArea(Composite composite) {
		Composite barComposite = new Composite(composite, SWT.NULL);
		GridLayout compositeLayout = new GridLayout();
		compositeLayout = new GridLayout();
		compositeLayout.numColumns = 2;
		compositeLayout.horizontalSpacing = 20;
		GridData compositeLData = new GridData(
				GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_END);
		barComposite.setLayoutData(compositeLData);
		barComposite.setLayout(compositeLayout);

		Button suppressWarningButton = new Button(barComposite, SWT.CHECK);
		suppressWarningButton.setText(Messages.PathmapConflictDialog_SuppressWarnings);
		suppressWarningButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean warningSuppressed = suppressWarningButton.getSelection();
				if (warningSuppressed) {
					for (URI pathmap : pathmaps) {
						// suppress future warnings for the pathmap state
						String prefConstant = PreferenceConstants.WARNING_SUPPRESSED_PATHMAP + pathmap.toString();
						String suppressedMappings = store.get(prefConstant,
								PreferenceConstants.DEFAULT_WARNING_SUPPRESSED_PATHMAP);
						List<String> mappings = new ArrayList<String>();
						mappings.addAll(Arrays.asList(suppressedMappings.split("\\s*,\\s*"))); //$NON-NLS-1$

						List<CXPathmapDescriptor> descs = CXDynamicURIConverter.getPathmapDescriptors(pathmap);
						for (CXPathmapDescriptor desc : descs) {
							if (!mappings.contains(desc.getMapping().toString())) {
								mappings.add(desc.getMapping().toString());
							}
						}
						store.put(prefConstant, String.join(",", mappings)); //$NON-NLS-1$
					}
				} else {
					for (URI pathmap : pathmaps) {
						// suppress future warnings for the pathmap state
						String prefConstant = PreferenceConstants.WARNING_SUPPRESSED_PATHMAP + pathmap.toString();
						store.remove(prefConstant);
					}
				}
				try {
					store.flush();
				} catch (BackingStoreException e1) {
					// pass
				}
				
				Object[] checked = pathmapSelectionComposite.getViewer().getCheckedElements();
				pathmapSelectionComposite.getViewer().setInput(pathmaps);
				pathmapSelectionComposite.getViewer().setCheckedElements(checked);
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

			}
		});
	}

	@Override
	public int open() {
		int result = Dialog.OK;
		boolean openDialog = false;
		lock.lock();
		try {
			if (!dialogInUse) {
				dialogInUse = true;
				openDialog = true;
			}
		} finally {
			lock.unlock();
		}
		
		if (openDialog) {
			try {
				// delay one second to collect all possible pathmap changes from the single
				// workspace event sequence
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// do nothing
			}
			Set<URI> conflicts = DDS4CCMDynamicURIMapHandler.getAndClearNewConflictPathmaps();
			while (true) {
				try {
					// delay one second to collect all possible pathmap changes from the single
					// workspace event sequence
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// do nothing
				}
				Set<URI> newConflicts = DDS4CCMDynamicURIMapHandler.getAndClearNewConflictPathmaps();
				if (newConflicts.isEmpty()) {
					break;
				}
				conflicts.addAll(newConflicts);
			}
			
			pathmaps.clear();
			for(URI pathmap: conflicts) {
				if(CXDynamicURIConverter.getPathmapDescriptors(pathmap).size() > 0) {
					pathmaps.add(pathmap);
				}
			}
			
			// open pathmap selection dialog if new changes are found
			result = super.open();
			
			lock.lock();
			try {
				dialogInUse = false;
			} finally {
				lock.unlock();
			}
		}
		
		return result;
	}
}
