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
package com.zeligsoft.cx.ui.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.cx.ui.wizard.PortTypeCreationWizard;

/**
 * Edit port type action delegate
 * 
 * @author ysroh
 * 
 */
public class EditPortTypeActionDelegate implements IObjectActionDelegate {

	private ISelection selection;

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(IAction action) {
		EObject eo = BaseUIUtil.getEObjectFromSelection(selection);
		if (eo == null || !(eo instanceof Element)) {
			return;
		}
		PortTypeCreationWizard wizard = new PortTypeCreationWizard((Element) eo);
		wizard.setWindowTitle(Messages.EditPortTypeActionDelegate_DialogTitle);
		WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell(),
				wizard);
		dialog.open();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
