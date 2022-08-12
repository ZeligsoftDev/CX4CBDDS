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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorReference;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.domain.dds4ccm.tools.internal.emf.DDS4CCMDynamicURIMapHandler;
import com.zeligsoft.domain.dds4ccm.tools.l10n.Messages;

/**
 * Close dependent model warning dialog when an active pathmap is removed
 * 
 * @author Young-Soo Roh
 *
 */
public class CloseDependentModelDialog extends TrayDialog {

	protected boolean shouldCloseDependentModels = false;
	protected Map<URI, Set<URI>> dependentModels = new HashMap<URI, Set<URI>>();
	private static final Lock lock = new ReentrantLock();
	
	public CloseDependentModelDialog(Shell shell) {
		super(shell);
	}

	@Override
	public void create() {
		super.create();
		Shell shell = getShell();
		shell.setText(Messages.DDS4CCMDynamicURIMapHandler_WarningDialogTitle);
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
		selectionComposite
				.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));

		Label label = new Label(selectionComposite, SWT.NONE);

		// found dependent models so do something.
		StringBuffer dependentModelString = new StringBuffer();
		StringBuffer deletedModelString = new StringBuffer();

		for (URI uri : dependentModels.keySet()) {
			deletedModelString.append(uri.toString()).append(System.lineSeparator());
		}

		Set<URI> uniqueUris = new HashSet<URI>();
		for (Set<URI> uris : dependentModels.values()) {
			uniqueUris.addAll(uris);
		}

		for (URI uri : uniqueUris) {
			dependentModelString.append(uri.toString()).append(System.lineSeparator());
		}

		String warning = NLS.bind(Messages.CloseDependentModelDialog_RemovingDynamicModelWarning,
				deletedModelString.toString(), dependentModelString.toString());

		label.setText(warning);
		label.setBackground(selectionComposite.getBackground());

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

		GridData buttonData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		buttonData.widthHint = 70;

		Button okButton = createButton(barComposite, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		okButton.setLayoutData(buttonData);
		Button cancelButton = createButton(barComposite, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL,
				false);
		cancelButton.setLayoutData(buttonData);

	}

	@Override
	public int open() {
		int result = Dialog.CANCEL;
		lock.lock();
		try {
			Map<URI, Set<URI>> modelsToCheck = DDS4CCMDynamicURIMapHandler.getAndClearDependentModelsToClose();
			if (!modelsToCheck.isEmpty()) {
				while (true) {
					try {
						// delay one second to collect all possible pathmap changes from the single
						// workspace event sequence
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// do nothing
					}
					Map<URI, Set<URI>> newChanges = DDS4CCMDynamicURIMapHandler.getAndClearDependentModelsToClose();
					if (newChanges.isEmpty()) {
						break;
					}
					modelsToCheck.putAll(newChanges);
				}
				
				for(URI pathmap: modelsToCheck.keySet()) {
					Set<URI> models = modelsToCheck.get(pathmap);
					for(URI model: models) {
						IEditorReference ref = BaseUIUtil.getEditorReference(model);
						if(ref != null) {
							dependentModels.put(pathmap, models);
						}
					}
				}
				if (!dependentModels.isEmpty()) {
					// open question dialog
					result = super.open();
				}
			}
		} finally {
			lock.unlock();
		}

		return result;
	}

	public Set<URI> getModelsToClose() {
		Set<URI> result = new HashSet<URI>();
		for (Set<URI> uris : dependentModels.values()) {
			result.addAll(uris);
		}
		return result;
	}
}
