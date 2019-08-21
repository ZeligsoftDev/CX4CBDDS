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
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Command to "redeploy" a part by changing the supplier of the dependency.
 * 
 * @author smcfee
 *
 */
public class ReallocateCommand
		extends AbstractTransactionalCommand {

	/**
	 * The source part that will be redeployed.
	 */
	private Property source = null;

	/**
	 * The target to which the source part will be redeployed.
	 */
	private Property target = null;
	
	/**
	 * The target to which the source part is deployed prior to the redeployment.
	 */
	private Property formerlyDeployedOn = null;

	/**
	 * Constructor
	 * 
	 * @param source
	 * 		The part that will be redeployed.
	 * @param target
	 * 		The part where it will be redeployed.
	 * @param label
	 * 		A label.
	 */
	public ReallocateCommand(Property source, Property target, String label)
	{
		super(TransactionUtil.getEditingDomain(source), label,
			Collections.EMPTY_MAP, getWorkspaceFiles(source));

		this.source = source;
		assert(source != null);
		assert(ZDLUtil.isZDLConcept(source, ZMLMMNames.DEPLOYMENT_PART));
		
		this.target = target;
		assert(target != null);
		assert(ZDLUtil.isZDLConcept(target, ZMLMMNames.DEPLOYMENT_PART));
		
		this.formerlyDeployedOn = ZDeploymentUtil.getDeploymentTargetPart(source);
		assert(formerlyDeployedOn != null);
		assert(ZDLUtil.isZDLConcept(formerlyDeployedOn, ZMLMMNames.DEPLOYMENT_PART));
		
		Dependency allocation = ZDeploymentUtil.getAllocationForSourcePart(source);
		assert(ZDLUtil.isZDLConcept(allocation, ZMLMMNames.ALLOCATION));		

	}

	/**
	 * Execute the command.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info)
			throws ExecutionException {
		
		Dependency allocation = ZDeploymentUtil.getAllocationForSourcePart(source);
		
		allocation.getSuppliers().remove(0);
		allocation.getSuppliers().add(target);
				
		return CommandResult.newOKCommandResult(allocation);
	}

	@Override
	public boolean canExecute() {
		return internalCanExecute() && super.canExecute();
	}

	private boolean internalCanExecute() {

		return 
			!(source.equals(target)) && !(target.equals(formerlyDeployedOn));
	}

}
