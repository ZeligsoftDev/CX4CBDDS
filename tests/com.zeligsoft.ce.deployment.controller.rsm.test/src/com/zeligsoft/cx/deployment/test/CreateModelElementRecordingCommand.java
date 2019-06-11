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

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Command that uses a write transaction to create a component part.
 * This is needed to modify an RSM model in a legal way.
 * 
 * @author smcfee
 *
 */
public class CreateModelElementRecordingCommand extends AbstractTransactionalCommand {

	private Component containerComponent;
	
	private NamedElement partComponent;
	
	private String name;

	public CreateModelElementRecordingCommand(TransactionalEditingDomain editingDomain,
			Component container, NamedElement prop, String name) {
		
		super(TransactionUtil.getEditingDomain(container), "Create Model Element", //$NON-NLS-1$
				Collections.EMPTY_MAP, null);
		
		this.containerComponent = container;
		this.partComponent = prop;
		this.name = name;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {

		if( partComponent instanceof Component )
		{
			// if this is a component interface, don't add substructure to me, add it to my structural realization
			if (ZDLUtil.isZDLConcept(containerComponent, ZMLMMNames.COMPONENT_INTERFACE))
			{
				ArrayList<Component> srList = ZDeploymentUtil.getStructuralRealizations(containerComponent);
				if (srList.size() > 0)
				{
					srList.get(0).createOwnedAttribute(name, (Component)partComponent);					
				}				
			}
			else
			{
				// I'm not a component interface, so add substructure to me
				containerComponent.createOwnedAttribute(name, (Component)partComponent);
			}
		}
		// dirty but this is JUnit helper code.
		else if( partComponent == null )
		{
			containerComponent.createOwnedConnector(name);
		}
		
		return CommandResult.newOKCommandResult(partComponent);
	}
}