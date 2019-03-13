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

package com.zeligsoft.cx.deployment.treeeditor.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.deployment.treeeditor.DeploymentEditorInput;
import com.zeligsoft.cx.deployment.treeeditor.l10n.DeploymentEditorMessages;
import com.zeligsoft.cx.deployment.treeeditor.ui.Activator;
import com.zeligsoft.cx.deployment.treeeditor.ui.DeploymentTreeEditor;

/**
 * This class implements the action to call the deployment tree editor with the
 * correct deployment input. It is called from the popup menu.
 * 
 * @author sduchesneau
 */
public class DeploymentCreationPopupAction
		implements IObjectActionDelegate {

	IWorkbenchPart workbenchPart;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IWorkbenchPart)
	 */
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		workbenchPart = targetPart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		IWorkbenchPartSite site = workbenchPart.getSite();

		// we need selection provider to find the name of the deployment
		ISelectionProvider selectionProvider = site.getSelectionProvider();

		Object selObject = BaseUIUtil.getEObjectFromSelection(selectionProvider
			.getSelection());

		if (selObject instanceof Component) {
			Component element = (Component) selObject;

			// we set the input of the deployment table tec
			DeploymentEditorInput input = new DeploymentEditorInput();
			input.setName(element.getName());
			input.setToolTipText(element.getName());
			input.setDeployment(element);

			// we find the workbench window, then the right page, then we open
			// the tec.
			IWorkbenchWindow window = site.getWorkbenchWindow();
			IWorkbenchPage workbenchPage = window.getActivePage();

			try {
				workbenchPage.openEditor(input,
					DeploymentTreeEditor.DEPLOYMENT_TREE_EDITOR_ID);
			} catch (Exception e) {
				Activator
					.getDefault()
					.error(
						DeploymentEditorMessages.DeploymentCreationPopupAction_OpenEditorErrorMsg,
						e);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
