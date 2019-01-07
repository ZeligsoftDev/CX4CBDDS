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

import com.zeligsoft.ce.deployment.Allocation;
import com.zeligsoft.ce.deployment.DeploymentPart;
import com.zeligsoft.ce.deployment.impl.DeploymentFactoryImpl;

/**
 * Simple deployment command.
 * 
 * @author smcfee
 *
 */
public class DeployCommand implements Command {

	private DeploymentPart sourcePart;
	private String targetPartId;
	private DeploymentPart formerTargetPart;
	
	public DeployCommand(DeploymentPart sourcePart, String targetPartId) {
		this.sourcePart = sourcePart;
		this.targetPartId = targetPartId;
		this.formerTargetPart = null;
	}
	
	public boolean canExecute() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean canUndo() {
		// TODO Auto-generated method stub
		return true;
	}

	public Command chain(Command command) {
		// TODO Auto-generated method stub
		return null;
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	/**
	 * Deployment function.
	 * Store the former target part (which will be null in the case of an initial deployment). That
	 * way if we are undoing a redeployment we know what target part we should revert to.
	 */
	public void execute() {
		Allocation allocation = sourcePart.getSourceAllocation();
		if( allocation == null )
		{
			allocation = DeploymentFactoryImpl.eINSTANCE.createAllocation();
		}
		else
		{
			formerTargetPart = sourcePart.getPartDeployedOn();
		}
		
		DeploymentPart targetPart = null;
		for( Iterator<DeploymentPart> deploymentPartIterator = sourcePart.getContainingDeployment().getDeploymentParts().iterator(); deploymentPartIterator.hasNext(); )
		{
			DeploymentPart part = deploymentPartIterator.next();
			
			if( part.getId() == targetPartId )
			{
				targetPart = part;
				break;
			}
			
		}
		
		allocation.setSourcePart(sourcePart);
		allocation.setTargetPart(targetPart);
		allocation.setDeployment(sourcePart.getContainingDeployment());

	}

	public Collection<?> getAffectedObjects() {
		// TODO Auto-generated method stub
		ArrayList<Object> retVal = new ArrayList<Object>();
		retVal.add(sourcePart.getDeployment());
		return retVal;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return "Deploys one part on another.";
	}

	public String getLabel() {
		// TODO Auto-generated method stub
		return "Deploy";
	}

	public Collection<?> getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Because undo stores the former target part we can just re-execute the operation in the forward
	 * direction.
	 */
	public void redo() {
		execute();
	}

	/**
	 * Revert the target part to what it was previously. If we are undoing an initial deployment
	 * we will also disassociate the allocation with the deployment because it is no longer meaningful.
	 * If the user continually deploys and hits "undo" they will create some extra allocation objects
	 * but the performance price of this is negligible and users generally won't do this.
	 */
	public void undo() {
		Allocation allocation = sourcePart.getSourceAllocation();
		
		// formerTargetPart will be null if this is undoing an initial deployment as opposed to 
		// a redeployment.
		if( formerTargetPart == null)
		{
			allocation.setSourcePart(null);			
			allocation.setDeployment(null);
		}
		allocation.setTargetPart(formerTargetPart);
		
	}

}
