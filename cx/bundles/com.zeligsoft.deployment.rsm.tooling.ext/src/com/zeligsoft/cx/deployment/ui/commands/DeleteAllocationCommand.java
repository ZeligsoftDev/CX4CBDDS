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
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.deployment.ui.l10n.ZDeploymentMessages;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Command to delete an allocation.
 * 
 * @author smcfee
 *
 */
public class DeleteAllocationCommand
		extends AbstractTransactionalCommand {

	/**
	 * The source part of the allocation to be removed. 
	 */
	private Property source = null;

	/**
	 * Deletes the allocation in which this part is the source.
	 * 
	 * @param source
	 *            Part to be undeployed.
	 * @param label
	 *            textual label for the command
	 */
	public DeleteAllocationCommand(Property source, String label) {

		super(TransactionUtil.getEditingDomain(source), label,
			Collections.EMPTY_MAP, getWorkspaceFiles(source));

		this.source = source;
		
		assert(source != null);
		
		assert(ZDLUtil.isZDLConcept(source, ZMLMMNames.DEPLOYMENT_PART));
	}

	/**
	 * Finds the allocation in which the member part is the source and destroys it.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info)
			throws ExecutionException {

		Dependency allocation = ZDeploymentUtil.getAllocationForSourcePart(source);
		
		if (allocation != null) {
					
			DestroyElementCommand.destroy(allocation);
			
			return CommandResult.newOKCommandResult();
		}
		return CommandResult
			.newErrorCommandResult(NLS.bind(ZDeploymentMessages.Allocation_Deletion_failed, null));
	}
}
