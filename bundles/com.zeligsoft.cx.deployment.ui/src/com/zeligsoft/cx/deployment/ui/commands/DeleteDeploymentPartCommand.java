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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.domain.zml.util.ZDeploymentUtil;

/**
 * 
 * @author smcfee
 *
 */
public class DeleteDeploymentPartCommand
		extends AbstractTransactionalCommand {

	/**
	 * The deployment.
	 */
	private Component deployment = null;

	/**
	 * The deployment part being deleted.
	 */
	private List<Property> deletedElements = new ArrayList<Property>();
	

	/**
	 * Constructor
	 * 
	 * @param deployment
	 * @param deletedElement
	 * @param label
	 */
	public DeleteDeploymentPartCommand(Component deployment, List<Property> deletedElement, String label) {

		super(TransactionUtil.getEditingDomain(deployment), label,
			Collections.EMPTY_MAP, getWorkspaceFiles(deployment));

		this.deployment = deployment;
		this.deletedElements = deletedElement;
	}

	/**
	 * Deletes a deployment part.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException
	{
		for (Property property : deletedElements) {
			if (property.eContainer() != null) {
				for (Property part : ZDeploymentUtil.getDeploymentParts(deployment)) {
					if (part.getOwner() != null
							&& ZDeploymentUtil.getModelElement(part) instanceof Property
							&& part.getType() == null) {
						ZDeploymentUtil.deleteDeploymentPart(part);
					}
				}
				if (property.getOwner() != null)
					ZDeploymentUtil.deleteDeploymentPart(property);
			}
		}
		return CommandResult.newOKCommandResult();		
	}
	
	@Override
	public boolean canExecute()
	{
		return ( !deletedElements.isEmpty());
	}
}
