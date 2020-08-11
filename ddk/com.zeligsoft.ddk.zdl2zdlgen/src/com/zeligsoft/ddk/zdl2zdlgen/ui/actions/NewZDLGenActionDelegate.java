/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl2zdlgen.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionDelegate;

import com.zeligsoft.ddk.zdl2zdlgen.ui.wizards.ImportZDLModelWizard;

/**
 * TODO: Comment
 * 
 * @author Christian W. Damus (cdamus)
 */
public class NewZDLGenActionDelegate
		extends ActionDelegate
		implements IObjectActionDelegate {

	private Shell parentShell;

	private IWorkbenchPart part;

	private IFile file;

	/**
	 * Initializes me.
	 */
	public NewZDLGenActionDelegate() {
		super();
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		parentShell = (targetPart == null)
			? null
			: targetPart.getSite().getShell();
		part = targetPart;
	}

	@Override
	public void run(IAction action) {
		ImportZDLModelWizard wizard = new ImportZDLModelWizard();
		wizard.init(part.getSite().getWorkbenchWindow().getWorkbench(),
			new StructuredSelection(file));
		WizardDialog dlg = new WizardDialog(parentShell, wizard);
		dlg.open();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		file = null;

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;

			if (!ssel.isEmpty()) {
				Object first = ssel.getFirstElement();
				if (first instanceof IFile) {
					file = (IFile) first;
				} else if (first instanceof IAdaptable) {
					IResource res = (IResource) ((IAdaptable) first)
						.getAdapter(IResource.class);
					if (res instanceof IFile) {
						file = (IFile) res;
					}
				}
			}
		}
		
		action.setEnabled(file != null);
	}
}
