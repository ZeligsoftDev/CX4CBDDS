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
package com.zeligsoft.base.licensing.ui.internal.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.actions.ActionDelegate;

import com.zeligsoft.base.licensing.ui.internal.dialogs.ManageLicensesDialog;


/**
 * Action delegate for the "Manage Zeligsoft Licenses" action.
 *
 * @author Christian W. Damus (cdamus)
 */
public class ManageLicensesActionDelegate
		extends ActionDelegate implements IWorkbenchWindowActionDelegate {

	private IWorkbenchWindow window;
	
	/**
	 * Initializes me.
	 */
	public ManageLicensesActionDelegate() {
		super();
	}

	@Override
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
	
	@Override
	public void run(IAction action) {
		int code = new ManageLicensesDialog(window.getShell(), true).open();
		
		if (code == ManageLicensesDialog.EXIT_WORKBENCH_ID) {
			window.getWorkbench().close();
		} else if (code == ManageLicensesDialog.RESTART_WORKBENCH_ID) {
			window.getWorkbench().restart();
		}
	}
}
