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
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.ce.deployment.Deployment;
import com.zeligsoft.ce.deployment.DeploymentComponentPart;
import com.zeligsoft.ce.deployment.DeploymentPart;
import com.zeligsoft.ce.deployment.bridge.uml.UMLDeploymentBridge;
import com.zeligsoft.ce.deployment.impl.DeploymentFactoryImpl;

/**
 * This command creates a new deployment part.
 * 
 * @author smcfee
 *
 */
public class CreateDeploymentPartCommand implements Command {

	private NamedElement modelElement;
	private Deployment deployment;
	private EObject modelElementParent;
	private ArrayList<DeploymentPart> deletedParts;
	private ArrayList<Deployment> deletedDeploymentReferences;
	private ArrayList<DeploymentPart> deletedParentPartReferences;
	
	public CreateDeploymentPartCommand(NamedElement modelElement, Deployment deployment, EObject modelElementParent) {
		this.modelElement = modelElement;
		this.deployment = deployment;
		this.modelElementParent = modelElementParent;
		deletedParts = new ArrayList<DeploymentPart>();
		deletedDeploymentReferences = new ArrayList<Deployment>();
		deletedParentPartReferences = new ArrayList<DeploymentPart>();
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

	/**
	 * Creates the deployment part out of the relevant UML model element. 
	 * Makes sure that any other deployment parts that should be created also get created.
	 * Creates substructure for any new deployment parts. 
	 */
	public void execute() {
		
								
		DeploymentPart partToCreate = null;
		if( modelElement instanceof Property )
		{
			partToCreate = DeploymentFactoryImpl.eINSTANCE.createDeploymentComponentPart();		
		}
		else if( modelElement instanceof Connector )
		{
			partToCreate = DeploymentFactoryImpl.eINSTANCE.createDeploymentConnectorPart();
		}
		partToCreate.setModelElement(modelElement);
		partToCreate.setName(modelElement.getName());
		
		for( Iterator<DeploymentPart> dpit = deployment.getDeploymentParts().iterator(); dpit.hasNext(); )
		{
			DeploymentPart dp = (DeploymentPart)dpit.next();
			if( dp.getModelElement() == modelElementParent )
			{
				partToCreate.setParentPart(dp);
			}								
		}
		
		UMLDeploymentBridge.synchronizeDeploymentParts(partToCreate);
		
		if( partToCreate instanceof DeploymentComponentPart )
		{
			UMLDeploymentBridge.buildDeploymentSubstructureBasedOnComponent( (Component)((Property)modelElement).getType(), partToCreate );
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
		// TODO Auto-generated method stub
		for( int i = 0; i < deletedParts.size(); i++ )
		{
			DeploymentPart dp = deletedParts.get(i);
			dp.setDeployment(deletedDeploymentReferences.get(i));
			dp.setParentPart(deletedParentPartReferences.get(i));
		}
	}

	public void undo() {
		
		// this is essentially invoking DeleteDeploymentPart functionality, so it would be nice to combine the logic.
		
		ArrayList<DeploymentPart> deploymentParts = deployment.getDeploymentParts();
		for( Iterator<DeploymentPart> dpit = deploymentParts.iterator(); dpit.hasNext(); )
		{
			DeploymentPart dp = (DeploymentPart)dpit.next();
			if( dp.getModelElement() == modelElement || dp.getModelElement() == null )
			{	
				deletedParts.add(dp);
				deletedDeploymentReferences.add(dp.getDeployment());
				deletedParentPartReferences.add(dp.getParentPart());
				dp.setDeployment(null);
				dp.setParentPart(null);
				// no need to clean up allocations in this case.
			}
		}
	}

}
