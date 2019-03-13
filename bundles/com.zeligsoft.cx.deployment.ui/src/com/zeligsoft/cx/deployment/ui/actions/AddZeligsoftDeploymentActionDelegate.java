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

package com.zeligsoft.cx.deployment.ui.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.ui.actions.AbstractZeligsoftActionDelegate;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.deployment.ui.l10n.ZDeploymentMessages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Action Delegate to support the creation of Zeligsoft Deployment element.
 * 
 * @author jcorchis
 * 
 */
public class AddZeligsoftDeploymentActionDelegate
		extends AbstractZeligsoftActionDelegate {

	@Override
	protected ICommand getCommand() {
		final EObject owner = getSelectedElement();

		return new AbstractTransactionalCommand(getEditingDomain(), getLabel(),
			null) {

			@Override
			public boolean canExecute() {
				return (owner instanceof Package && ZDLUtil
					.canCreateZDLConceptIn(owner, ZMLMMNames.DEPLOYMENT));
			}

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				EObject result = BaseUIUtil.createZDLModelElement(owner,
						ZMLMMNames.DEPLOYMENT);

				if (result != null) {
					if (result.eContainer() == owner) {
						// successfully attached
						return CommandResult.newOKCommandResult(result);
					} else {
						// not attached. Destroy it
						DestroyElementCommand.destroy(result);
					}
				}

				return CommandResult.newErrorCommandResult(NLS.bind(
					ZDeploymentMessages.Deployment_create_failure, EMFCoreUtil
						.getQualifiedName(owner, true)));
			}

		};
	}

	@Override
	public void selectionChanged(IAction act, ISelection selection) {
		super.selectionChanged(act, selection);
		if (getSelectedElement() == null) {
			return;
		}
		if ((getEditingDomain().isReadOnly(getSelectedElement().eResource()))
			|| !(getSelectedElement() instanceof Package)) {
			act.setEnabled(false);
		} else {
			act.setEnabled(true);
		}
	}

}
