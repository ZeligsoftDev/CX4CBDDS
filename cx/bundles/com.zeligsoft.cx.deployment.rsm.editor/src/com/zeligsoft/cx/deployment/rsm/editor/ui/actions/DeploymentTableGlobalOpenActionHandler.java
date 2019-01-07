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

package com.zeligsoft.cx.deployment.rsm.editor.ui.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.OneTimeCommand;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.common.ui.services.action.global.AbstractGlobalActionHandler;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.base.rsm.tooling.utils.BaseUtil;
import com.zeligsoft.cx.deployment.rsm.editor.DeploymentEditorInput;
import com.zeligsoft.cx.deployment.rsm.editor.l10n.DeploymentEditorMessages;
import com.zeligsoft.cx.deployment.rsm.editor.policies.DeploymentTableGlobalActionHandlerPolicy;

/**
 * GlobalOpenActionHandler for Deployment Table Default action for deployment is
 * to open with Deployment Table Editor
 * 
 * @author ysroh
 */

public class DeploymentTableGlobalOpenActionHandler extends
		AbstractGlobalActionHandler {

	private EObject selectedObject;

	public IWorkbenchPartSite site;
	public ISelection selection;

	public boolean canHandle(IGlobalActionContext context) {

		// see DeploymentTableGlobalActionHandlerPolicy for provider policy
		return true;
	}

	public ICommand getCommand(IGlobalActionContext context) {

		/* Create a command */
		ICommand command = null;

		/* Check the action id */
		if (!(context.getActionId()).equals(GlobalActionId.OPEN))
			return command;

		site = context.getActivePart().getSite();
		selectedObject = BaseUtil
				.getObjectFromSelection(context.getSelection());
		String thisAction = DeploymentTableGlobalActionHandlerPolicy.ACTION;

		// Handle global open action for deployment table
		if (thisAction
				.compareTo(DeploymentEditorMessages.DeploymentEditorMessages_OpenDeploymentEditorActionLabel) == 0) {

			command = new OneTimeCommand(
					DeploymentEditorMessages.DeploymentEditorMessages_OpenDeploymentEditorCommandLabel) {

				@Override
				protected CommandResult doExecuteWithResult(
						IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {

					doOpenDeploymentEditor();

					return CommandResult.newOKCommandResult();
				}
			};
		}
		return command;
	}

	/**
	 * Returns component selected
	 * 
	 * @return Component or <code>null</code> if not instance of Component
	 */
	private Component getComponent() {

		if (selectedObject instanceof Component) {
			return (Component) selectedObject;
		}
		return null;
	}

	/**
	 * Opens deployment table editor with given component and site
	 * 
	 */
	private void doOpenDeploymentEditor() {

		Component element = getComponent();
		DeploymentEditorInput input = new DeploymentEditorInput();
		input.setName(element.getName());
		input.setToolTipText(element.getName());
		input.setDeployment(element);

		// we find the workbench window, then the right page,
		// then we open the editor.
		IWorkbenchWindow window = site.getWorkbenchWindow();
		IWorkbenchPage workbenchPage = window.getActivePage();

		try {
			workbenchPage.openEditor(input,
					"com.zeligsoft.cx.deployment.rsm.editor");

		} catch (Exception ex) {
			// I don't care
		}
	}

}
