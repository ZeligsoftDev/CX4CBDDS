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
package com.zeligsoft.cx.deployment.ui.commands;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Command to add a model element to a deployment. This command is capable of
 * adding both a "top-level" model element (Component) or a part (e.g. Property)
 * 
 * @author smcfee
 * 
 */
public class AddModelElementCommand
		extends AbstractTransactionalCommand {

	/**
	 * The deployment.
	 */
	private Component deployment = null;

	/**
	 * The model element that is being added.
	 */
	private NamedElement addedElement = null;

	/**
	 * The (non-deployment) model element corresponding to the logical parent of
	 * the part to be created in the deployment. When a top-level part is being
	 * created this will be null.
	 */
	private NamedElement modelElementParent = null;

	/**
	 * the structural realization of this element if it is a component
	 * interface. unused if not component interface
	 */
	private NamedElement structuralRealization = null;

	/**
	 * Constructor.
	 * 
	 * @param deployment
	 * @param addedElement
	 * @param modelElementParent
	 * @param structuralRealization
	 * @param label
	 * 
	 */
	public AddModelElementCommand(Component deployment,
			NamedElement addedElement, NamedElement modelElementParent,
			NamedElement structuralRealization, String label) {
		super(TransactionUtil.getEditingDomain(deployment), label,
			Collections.EMPTY_MAP, getWorkspaceFiles(deployment));

		this.deployment = deployment;
		this.addedElement = addedElement;
		this.modelElementParent = modelElementParent;
		this.structuralRealization = structuralRealization;

		assert (addedElement != null);
		assert (deployment != null);
		assert (ZDLUtil.isZDLConcept(deployment, ZMLMMNames.DEPLOYMENT));
		assert (!ZDLUtil.isZDLConcept(addedElement, ZMLMMNames.DEPLOYMENT));
	}

	/**
	 * Creates a deployment part including relevant substructure out of the
	 * passed model component.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info)
			throws ExecutionException {
		
		Property newProperty = ZDeploymentUtil
			.buildDeploymentPartFromModelElement(addedElement, deployment,
				modelElementParent, structuralRealization);
		if (newProperty != null) {
			return CommandResult.newOKCommandResult(newProperty);
		}
		return CommandResult.newOKCommandResult();
	}
}
