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
package com.zeligsoft.cx.deployment.test;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Command that uses a write transaction to delete a component (or part)
 * This is needed to modify an RSM model in a legal way.
 * 
 * @author smcfee
 *
 */
public class DeleteModelElementRecordingCommand extends AbstractTransactionalCommand {

	private NamedElement partToDie = null;
	
	public DeleteModelElementRecordingCommand(TransactionalEditingDomain editingDomain,
			NamedElement partToDie) {
		
		super(TransactionUtil.getEditingDomain(partToDie), "Delete Model Element", //$NON-NLS-1$
				Collections.EMPTY_MAP, null);
		
		this.partToDie = partToDie;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		
		DestroyElementCommand.destroy(partToDie);
		
		return CommandResult.newOKCommandResult(partToDie);
		
	}
	
}
