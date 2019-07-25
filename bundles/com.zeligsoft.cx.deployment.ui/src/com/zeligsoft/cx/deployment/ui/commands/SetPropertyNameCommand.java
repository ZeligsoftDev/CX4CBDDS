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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.cx.deployment.ui.l10n.ZDeploymentMessages;

/**
 * Simple command to set the property name.
 * 
 * @author schafe
 *
 */
public class SetPropertyNameCommand extends AbstractTransactionalCommand {

	private Property property;
	String newName;

	/**
	 * Constructor
	 * @param TransactionalEditingDomain domain
	 * @param Property property
	 * @param String newName
	 */
	public SetPropertyNameCommand(TransactionalEditingDomain domain,
			Property property, String newName) {

		super(domain, ZDeploymentMessages.SetPropertyNameCommand_Label,
				Collections.EMPTY_MAP, null);
		this.property = property;
		this.newName = newName;

	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		property.setName(newName);
		return CommandResult.newOKCommandResult(property);
	}

}
