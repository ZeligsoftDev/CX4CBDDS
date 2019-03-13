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
package com.zeligsoft.domain.idl3plus.ui.commands;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;

/**
 * 
 * @author parmvirs
 *
 */
public class IDL3PlusRemoveInstanceSpecification extends AbstractTransactionalCommand {
	
	InstanceSpecification instance = null;
	
	Property deplymentPart = null;
	
	public IDL3PlusRemoveInstanceSpecification(InstanceSpecification instance, Property deploymentPart, String label) {
		super(TransactionUtil.getEditingDomain(deploymentPart), label,
				Collections.EMPTY_MAP, getWorkspaceFiles(deploymentPart));
		
		this.deplymentPart = deploymentPart;
		this.instance = instance;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor arg0,
			IAdaptable arg1) throws ExecutionException {
		deplymentPart.setDefaultValue(null);
		EcoreUtil.delete(instance.eContainer(), true);
		
		return CommandResult.newOKCommandResult();
	}

}
