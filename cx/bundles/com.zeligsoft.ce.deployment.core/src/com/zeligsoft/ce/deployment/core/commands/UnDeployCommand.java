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

import java.util.Collection;

import org.eclipse.emf.common.command.Command;

import com.zeligsoft.ce.deployment.Allocation;
import com.zeligsoft.ce.deployment.DeploymentPart;

/**
 * Command that undeploys a part. Takes the source part to undeploy. Stores the former deployment
 * target for undo purposes. 
 * 
 * @author smcfee
 *
 */
public class UnDeployCommand implements Command {

	
	private DeploymentPart sourcePart;
	private DeploymentPart formerTargetPart;
	private Allocation formerAllocation;

	public UnDeployCommand(DeploymentPart sourcePart) {
		this.sourcePart = sourcePart;
	}

	public boolean canExecute() {
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

	public void execute() {

		if( sourcePart.getSourceAllocation() == null )
			return;
		
		formerTargetPart = sourcePart.getSourceAllocation().getTargetPart();
		formerAllocation = sourcePart.getSourceAllocation();
		
		formerAllocation.setSourcePart(null);
		formerAllocation.setTargetPart(null);
		formerAllocation.setDeployment(null);

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
		execute();
	}

	public void undo() {

		formerAllocation.setSourcePart(sourcePart);
		formerAllocation.setTargetPart(formerTargetPart);
		formerAllocation.setDeployment(sourcePart.getContainingDeployment());

	}

}
