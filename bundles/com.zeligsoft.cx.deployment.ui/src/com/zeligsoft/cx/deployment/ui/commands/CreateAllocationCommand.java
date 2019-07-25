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
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.deployment.ui.l10n.ZDeploymentMessages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Command to create a Zeligsoft Allocation element. All Allocations must be
 * owned by a <code>Component</code> stereotyped as
 * ZeligsoftDeploymentUtil.QUALIFIED_DEPLOYMENT_STEREOTYPE_NAME.
 * 
 * @author jcorchis
 * 
 */
public class CreateAllocationCommand
		extends AbstractTransactionalCommand {

	/**
	 * The UML component stereotyped as  ZeligsoftDeploymentUtil.QUALIFIED_DEPLOYMENT_STEREOTYPE_NAME
	 * that will own the Allocation
	 */
	private Component deployment = null;

	private Property source = null;

	private Property target = null;

	/**
	 * Creates and Allocation that will be owned by the given deployment.
	 * 
	 * @param deployment
	 *            <code>Component</code> that will own the Allocation
	 * @param source
	 *            source <code>Property</code> of the Allocation
	 * @param target
	 *            target <code>Property</code> of the Allocation
	 * @param label
	 *            textual label for the Allocation command
	 */
	public CreateAllocationCommand(Component deployment, Property source,
			Property target, String label) {

		super(TransactionUtil.getEditingDomain(source), label,
			Collections.EMPTY_MAP, getWorkspaceFiles(deployment));

		this.deployment = deployment;
		this.source = source;
		this.target = target;

		assert(source != null);
		assert(target != null);
		assert(deployment != null);

		assert(ZDLUtil.isZDLConcept(deployment, ZMLMMNames.DEPLOYMENT));
	}

	/**
	 * Creates an Allocation whose ends are the <code>Type</code>s of the
	 * source/target properties in order to remove any knowledge of Deployment
	 * from a Part/Port.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info)
			throws ExecutionException {

		
		Dependency allocation = UMLFactory.eINSTANCE.createDependency();
		deployment.getPackagedElements().add(allocation);
		if (allocation != null)
		{
			allocation.getClients().add(source);
			allocation.getSuppliers().add(target);
			
			ZDLUtil.addZDLConcept(allocation, ZMLMMNames.ALLOCATION);
			
			return CommandResult.newOKCommandResult(allocation);
		}
		
		return CommandResult
			.newErrorCommandResult(NLS.bind(ZDeploymentMessages.Allocation_Creation_failed, null));
	}

	/**
	 * Checks that both the <code>source</code> and <code>target</code> can
	 * support the Allocation.
	 * 
	 */
	@Override
	public boolean canExecute() {
		return internalCanExecute() && super.canExecute();
	}

	private boolean internalCanExecute() {

		return !(source.equals(target));
	}

}
