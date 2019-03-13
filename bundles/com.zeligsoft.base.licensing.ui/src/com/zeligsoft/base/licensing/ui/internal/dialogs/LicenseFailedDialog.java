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
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.zeligsoft.base.licensing.ui.internal.l10n.Messages;

/**
 * A dialog indicating failure to find a valid license for the software.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class LicenseFailedDialog
		extends ErrorDialog {

	protected static final int MANAGE_LICENSES_ID = IDialogConstants.CLIENT_ID + 2;

	/**
	 * Initializes me with my parent shell, message, and details.
	 * 
	 * @param parentShell
	 *            my parent shell
	 * @param message
	 *            a user-friendly message specific to the particular license
	 *            that could not be obtained
	 * @param status
	 *            the detailed reason why the license could not be obtained
	 */
	public LicenseFailedDialog(Shell parentShell, String message, IStatus status) {
		super(parentShell, NLS.bind(Messages.UILicenseListener_0, Platform
			.getProduct().getName()), null, new MultiStatus(status.getPlugin(),
			status.getCode(), new IStatus[]{status}, message, null),
			IStatus.ERROR | IStatus.CANCEL);
	}
	
	public LicenseFailedDialog(Shell parentShell, String message, IStatus status, int displayMask) {
		super(parentShell, NLS.bind(Messages.UILicenseListener_0, Platform
				.getProduct().getName()), null, new MultiStatus(status.getPlugin(),
				status.getCode(), new IStatus[]{status}, message, null),
				displayMask);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createDetailsButton(parent);
		createButton(parent, MANAGE_LICENSES_ID, Messages.UILicenseListener_2,
			false);
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	@Override
	protected boolean shouldShowDetailsButton() {
		return true;
	}

	@Override
	protected void buttonPressed(int id) {
		if (id == MANAGE_LICENSES_ID) {
			manageLicenses();
		} else {
			super.buttonPressed(id);
		}
	}

	protected void manageLicenses() {
		IWorkbench wb = PlatformUI.getWorkbench();
		Shell parent = getParentShell();
		
		close();
		
		int code = new ManageLicensesDialog(parent).open();
		
		if (code == ManageLicensesDialog.RESTART_WORKBENCH_ID) {
			wb.restart();
		} else {
			wb.close();
		}
	}

}
