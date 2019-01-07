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
package com.zeligsoft.base.licensing.ui.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.zeligsoft.base.licensing.LicenseAdapter;
import com.zeligsoft.base.licensing.ui.internal.dialogs.LicenseFailedDialog;
import com.zeligsoft.base.licensing.ui.internal.dialogs.LicenseInfoDialog;
import com.zeligsoft.base.licensing.ui.internal.l10n.Messages;

/**
 * A license listener that informs the user of a situation when something significant has happened with licensing.
 * 
 * @author Christian W. Damus (cdamus)
 */
public final class UILicenseListener
		extends LicenseAdapter {

	/**
	 * Initializes me.
	 */
	public UILicenseListener() {
		super();
	}

	@Override
	public void licenseFailed(final String bundleName,
			final IStatus status, final String errorMessage) {
		final IWorkbench wb = PlatformUI.getWorkbench();

		wb.getDisplay().asyncExec(new Runnable() {

			@Override
			public void run() {
				new LicenseFailedDialog(wb.getActiveWorkbenchWindow()
					.getShell(), (errorMessage == null) ? 
							NLS.bind(Messages.UILicenseListener_1,	bundleName) : 
								NLS.bind(errorMessage,	bundleName), 
							status).open();
			}
		});
	}
	
	@Override
	public void licenseImportFailed(final String errorMessage) {
		
		final IWorkbench wb = PlatformUI.getWorkbench();

		wb.getDisplay().asyncExec(new Runnable() {

			@Override
			public void run() {
				MessageDialog.openError(wb.getActiveWorkbenchWindow().getShell(), 
						Messages.ManageLicensesDialog_licenseImportFailed, errorMessage);
			}
		});
	}

	@Override
	public void licenseInfo(final String bundleName,
			final IStatus status, final String infoMessage) {
		final IWorkbench wb = PlatformUI.getWorkbench();
		
		wb.getDisplay().asyncExec(new Runnable() {

			@Override
			public void run() {
				new LicenseInfoDialog(wb.getActiveWorkbenchWindow()
					.getShell(), (infoMessage == null) ? 
							NLS.bind(Messages.UILicenseListener_TrialLicense, bundleName) :
								NLS.bind(infoMessage,	bundleName),
								status).open();
			}
		});
	}
}
