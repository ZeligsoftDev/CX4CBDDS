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
package com.zeligsoft.base.licensing.ui.internal.dialogs;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.zeligsoft.base.licensing.ui.internal.l10n.Messages;

/**
 * A dialog indicating a trial license is in use.
 * 
 * @author mtate
 */
public class LicenseInfoDialog
		extends LicenseFailedDialog {
	
	protected static final int EXIT_WORKBENCH_ID = IDialogConstants.CLIENT_ID + 1;

	/**
	 * Initializes me with my parent shell, message, and details.
	 * 
	 * @param parentShell
	 *            my parent shell
	 * @param message
	 *            a user-friendly message specific info to be conveyed
	 * @param status
	 *            the detailed info
	 */
	public LicenseInfoDialog(Shell parentShell, String message, IStatus status) {
		super(parentShell, message, status, IStatus.CANCEL | IStatus.INFO);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createDetailsButton(parent);
		createButton(parent, MANAGE_LICENSES_ID, Messages.UILicenseListener_2,
			false);

		Button exit = createButton(parent, EXIT_WORKBENCH_ID,
			Messages.UILicenseListener_3, true);
		exit.setFocus();
	}

	@Override
	protected void manageLicenses() {
		IWorkbench wb = PlatformUI.getWorkbench();
		Shell parent = getParentShell();
		
		close();
		
		int code = new ManageLicensesDialog(parent, true).open();
		
		if (code == ManageLicensesDialog.RESTART_WORKBENCH_ID) {
			wb.restart();
		} else {
			//do nothing
		}
	}
	
	@Override
	protected void buttonPressed(int id) {
		if (id == EXIT_WORKBENCH_ID) {
			PlatformUI.getWorkbench().close();
		} else {
			super.buttonPressed(id);
		}
	}
}
