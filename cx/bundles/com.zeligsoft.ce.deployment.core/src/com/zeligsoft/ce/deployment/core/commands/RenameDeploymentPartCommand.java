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
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.ce.deployment.Deployment;
import com.zeligsoft.ce.deployment.DeploymentPart;

/**
 * Command that renames a deployment part. It takes the object being renamed (the notifier), the
 * new name, and the deployment that we will modify.
 * 
 * @author smcfee
 *
 */
public class RenameDeploymentPartCommand implements Command {

	private NamedElement notifier;
	private String newStringValue;
	private String oldStringValue;
	private Deployment deployment;

	public RenameDeploymentPartCommand(NamedElement notifier, String newStringValue, Deployment deployment) {
		this.notifier = notifier;
		this.newStringValue = newStringValue;
		this.deployment = deployment;
	}

	public boolean canExecute() {
		return true;
	}

	public boolean canUndo() {		
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
		ArrayList<DeploymentPart> deploymentParts = deployment.getDeploymentParts();
		for( Iterator<DeploymentPart> dpit = deploymentParts.iterator(); dpit.hasNext(); )
		{
			DeploymentPart dp = (DeploymentPart)dpit.next();
			if( dp.getModelElement() == notifier )
			{
				oldStringValue = dp.getName();
				dp.setName(newStringValue);				
			}
		}

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
		ArrayList<DeploymentPart> deploymentParts = deployment.getDeploymentParts();
		for( Iterator<DeploymentPart> dpit = deploymentParts.iterator(); dpit.hasNext(); )
		{
			DeploymentPart dp = (DeploymentPart)dpit.next();
			if( dp.getModelElement() == notifier )
			{
				dp.setName(oldStringValue);				
			}
		}
	}

}
