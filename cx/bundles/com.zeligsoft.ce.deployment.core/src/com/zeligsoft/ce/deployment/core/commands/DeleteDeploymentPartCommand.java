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
package com.zeligsoft.ce.deployment.core.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.ce.deployment.Allocation;
import com.zeligsoft.ce.deployment.Deployment;
import com.zeligsoft.ce.deployment.DeploymentPart;

/**
 * Command to delete a deployment part.
 * 
 * @author smcfee
 *
 */
public class DeleteDeploymentPartCommand implements Command {

	private NamedElement modelElement;
	private Deployment deployment;
	
	private ArrayList<EObject> modelElements;
	
	private ArrayList<DeploymentPart> deletedParts;
	private ArrayList<EObject> deletedModelReferences;
	private ArrayList<Deployment> deletedDeploymentReferences;
	private ArrayList<DeploymentPart> deletedParentPartReferences;
	
	private ArrayList<Allocation> deletedAllocations;
	private ArrayList<DeploymentPart> allocationSourcePartReferences;
	private ArrayList<DeploymentPart> allocationTargetPartReferences;

	public DeleteDeploymentPartCommand(NamedElement modelElement, Deployment deployment) {
		this.modelElement = modelElement;
		this.modelElements = new ArrayList<EObject>();
		this.modelElements.add(this.modelElement);
		
		this.deployment = deployment;
		
		deletedParts = new ArrayList<DeploymentPart>();
		deletedModelReferences = new ArrayList<EObject>();
		deletedDeploymentReferences = new ArrayList<Deployment>();
		deletedParentPartReferences = new ArrayList<DeploymentPart>();
		
		deletedAllocations = new ArrayList<Allocation>();
		allocationSourcePartReferences = new ArrayList<DeploymentPart>();
		allocationTargetPartReferences = new ArrayList<DeploymentPart>();
		
		preProcessDeployment(modelElement);
	}

	private void preProcessDeployment(NamedElement modelElement)
	{
		ArrayList<DeploymentPart> deploymentParts = deployment.getDeploymentParts();
		for( Iterator<DeploymentPart> dpit = deploymentParts.iterator(); dpit.hasNext(); )
		{
			DeploymentPart dp = (DeploymentPart)dpit.next();
			if( dp.getModelElement() == modelElement || dp.getModelElement() == null )
			{	
				if( deletedParts.contains(dp) == false )
				{
					deletedParts.add(dp);
					if( dp.getModelElement() != null )
					{
						deletedModelReferences.add(dp.getModelElement());
					}
					else
					{
						deletedModelReferences.add(dp.getOldModelElement());
					}
					deletedDeploymentReferences.add(dp.getDeployment());
					deletedParentPartReferences.add(dp.getParentPart());
				}
			}
		}
	}
	
	public boolean canExecute() {
		return true;
	}

	public boolean canUndo() {
		return true;
	}

	public Command chain(Command command) {
		if( command instanceof DeleteDeploymentPartCommand )
		{
			if( this.modelElements.contains(((DeleteDeploymentPartCommand)command).modelElement) == false )
			{
				this.modelElements.add(((DeleteDeploymentPartCommand)command).modelElement);
				preProcessDeployment(((DeleteDeploymentPartCommand)command).modelElement);
			}
		}		
		return this;
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void execute() 
	{
		for( Iterator<DeploymentPart> dpit = deletedParts.iterator(); dpit.hasNext(); )
		{
			DeploymentPart dp = (DeploymentPart)dpit.next();
					
			dp.setDeployment(null);
			dp.setModelElement(null);
			dp.setParentPart(null);
			
			// can iterate through the allocations and find out if a source or target has an
			// ancestor in the deleted part, which should do it.
			Object[] allocationList = deployment.getAllocation().toArray();
			for( int i = 0; i < allocationList.length; i++ )
			{					
				Allocation allocation = (Allocation)allocationList[i];
				if( hasAncestor(allocation.getSourcePart(), dp) || hasAncestor(allocation.getTargetPart(), dp) )
				{
					deletedAllocations.add(allocation);						
					allocationSourcePartReferences.add(allocation.getSourcePart());
					allocationTargetPartReferences.add(allocation.getTargetPart());
					allocation.setDeployment(null);
					allocation.setSourcePart(null);
					allocation.setTargetPart(null);						
				}					
			}			
		}
	}
	
	//TODO move into deployment metamodel
	private boolean hasAncestor(DeploymentPart part, DeploymentPart possibleAncestor)
	{
		DeploymentPart iterator = part;
		
		while( iterator != null )
		{
			if( iterator == possibleAncestor )
				return true;
			iterator = iterator.getParentPart();
		}
		
		return false;
	}

	public Collection<?> getAffectedObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<?> getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	public void redo() {
		for( int i = 0; i < deletedParts.size(); i++ )
		{
			DeploymentPart dp = deletedParts.get(i);
			dp.setDeployment(null);
			dp.setParentPart(null);
			dp.setModelElement(null);
		}
		for( int i = 0; i < deletedAllocations.size(); i++ )
		{
			Allocation a = deletedAllocations.get(i);
			a.setDeployment(null);
			a.setSourcePart(null);
			a.setTargetPart(null);
		}

	}

	public void undo() {
		
		for( int i = 0; i < deletedParts.size(); i++ )
		{
			DeploymentPart dp = deletedParts.get(i);
			dp.setDeployment(deletedDeploymentReferences.get(i));
			if( dp.getDeployment() == null )
			{
				dp.setParentPart(deletedParentPartReferences.get(i));
			}
			dp.setModelElement(deletedModelReferences.get(i));
		}
		for( int i = 0; i < deletedAllocations.size(); i++ )
		{
			Allocation a = deletedAllocations.get(i);
			a.setDeployment(deployment);
			a.setSourcePart(allocationSourcePartReferences.get(i));
			a.setTargetPart(allocationTargetPartReferences.get(i));
		}		
	}

}
