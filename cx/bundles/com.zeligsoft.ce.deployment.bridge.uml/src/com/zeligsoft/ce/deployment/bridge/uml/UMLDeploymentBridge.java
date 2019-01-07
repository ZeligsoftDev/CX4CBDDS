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
package com.zeligsoft.ce.deployment.bridge.uml;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.ce.deployment.Deployment;
import com.zeligsoft.ce.deployment.DeploymentComponentPart;
import com.zeligsoft.ce.deployment.DeploymentConnectorPart;
import com.zeligsoft.ce.deployment.DeploymentPart;
import com.zeligsoft.ce.deployment.impl.DeploymentFactoryImpl;

/**
 * Class for working with UML models and deployments.
 * The deployment metamodel knows nothing about UML, so this class is used to interact with UML models.
 *  * 
 * @author smcfee
 *
 */
public class UMLDeploymentBridge {
	
	/**
	 * Builds and returns a deployment based on a UML model.
	 * 
	 * @param model - the model out of which the deployment is built.
	 * @return
	 */
	public static Deployment buildDeploymentFromModel(Model model)
	{
		Deployment deployment = DeploymentFactoryImpl.eINSTANCE.createDeployment();
			
		EList<Element> elements = model.getOwnedElements();
		
		//System.out.println("=== Model contents ===");
		
		for( Iterator<Element> elementIterator = elements.iterator(); elementIterator.hasNext(); )
		{
			Element element = elementIterator.next();
			
			if( element instanceof PackageImport )
			{
				//System.out.println("Package import" );
			}
			else if( element instanceof org.eclipse.uml2.uml.Package )
			{
				//System.out.println("Package");
			}
			else if( element instanceof Component )
			{
				Component component = (Component)element;					
				
				//System.out.println("Component");
				DeploymentComponentPart dpc = DeploymentFactoryImpl.eINSTANCE.createDeploymentComponentPart();					
				dpc.setName(component.getName());
				dpc.setModelElement(element);
				dpc.setDeployment(deployment);
				
				UMLDeploymentBridge.buildDeploymentSubstructureBasedOnComponent( component, dpc );
			}
			else if( element instanceof ProfileApplication )
			{
				//System.out.println("Profile Application");
			}
			else
			{
				//System.out.println("Something else");
			}
		}	
		
		return deployment;
		
	}
	
	/**
	 * Recursive function to create deployment substructure to reflect a UML component.
	 * @param component - the component we are building substructure for.
	 * @param parentPart - the parent part for any new deployment parts created in this method. 
	 */
	public static void buildDeploymentSubstructureBasedOnComponent( Component component, DeploymentPart parentPart ) 
	{
		for( Iterator<Element> substructureIterator = component.getOwnedElements().iterator(); substructureIterator.hasNext(); )
		{
			Element substructureElement = substructureIterator.next();
			
			if( substructureElement instanceof Property && ((org.eclipse.uml2.uml.Property)substructureElement).getType() instanceof Component)
			{
				DeploymentComponentPart sc1 = DeploymentFactoryImpl.eINSTANCE.createDeploymentComponentPart();
				sc1.setName(((org.eclipse.uml2.uml.Property)substructureElement).getName());		
				sc1.setModelElement(substructureElement);
				sc1.setParentPart(parentPart);
				buildDeploymentSubstructureBasedOnComponent((Component)((org.eclipse.uml2.uml.Property)substructureElement).getType(), sc1);
			}			
		}
		for( Iterator<Connector> substructureIterator = component.getOwnedConnectors().iterator(); substructureIterator.hasNext(); )
		{
			Element substructureElement = substructureIterator.next();
						
			DeploymentConnectorPart sc1 = DeploymentFactoryImpl.eINSTANCE.createDeploymentConnectorPart();
			sc1.setName(((org.eclipse.uml2.uml.Connector)substructureElement).getName());		
			sc1.setModelElement(substructureElement);
			sc1.setParentPart(parentPart);							
		}
	}
	
	/**
	 * Given a deployment part, make sure that the deployment is synchronized with the part.
	 * This means that wherever this part's model element is used in the UML model, there is a 
	 * corresponding deployment part (where applicable) in the deployment.
	 * @param deploymentPart - the part we are synchronizing 
	 */
	public static void synchronizeDeploymentParts( DeploymentPart deploymentPart )
	{
		DeploymentPart parentPart = deploymentPart.getParentPart();
		
		if( parentPart == null ) return;
		
		Deployment deployment = deploymentPart.getContainingDeployment();
		
		for( Iterator<DeploymentPart> deploymentPartIterator = deployment.getDeploymentParts().iterator(); deploymentPartIterator.hasNext(); )
		{
			DeploymentPart candidatePart = deploymentPartIterator.next();
			
			Component deploymentPartComponent = getModelComponent(parentPart);
			Component candidatePartComponent = getModelComponent(candidatePart);
			
			if( deploymentPartComponent == candidatePartComponent )
			{
				// we must add a child corresponding to deployment part if it does not yet exist.
				boolean found = false;
				
				for( Iterator<DeploymentPart> candidatePartChildrenIterator = candidatePart.getChildPart().iterator(); candidatePartChildrenIterator.hasNext(); )
				{
					DeploymentPart candidatePartChild = candidatePartChildrenIterator.next();
					
					if( candidatePartChild.getModelElement() == deploymentPart.getModelElement() )
					{
						found = true;
					}
				}
				
				if( !found )
				{
					DeploymentPart partToCreate = null;
					if( deploymentPart instanceof DeploymentConnectorPart )
					{
						partToCreate = DeploymentFactoryImpl.eINSTANCE.createDeploymentConnectorPart();	
					}
					else if( deploymentPart instanceof DeploymentComponentPart )
					{
						partToCreate = DeploymentFactoryImpl.eINSTANCE.createDeploymentComponentPart();
					}
					partToCreate.setName(deploymentPart.getName());		
					partToCreate.setModelElement(deploymentPart.getModelElement());
					partToCreate.setParentPart(candidatePart);
					if( partToCreate instanceof DeploymentComponentPart )
					{
						buildDeploymentSubstructureBasedOnComponent((Component)((Property)partToCreate.getModelElement()).getType(), partToCreate);
					}
				}
			}
		}		
	}
	
	/**
	 * Gets the deployment part's corresponding model component. If the model element is a "part" instead of a "definition" retrieve the definition.
	 * 
	 * @param deploymentPart - The part we are querying.
	 * @return
	 */
	private static Component getModelComponent( DeploymentPart deploymentPart )
	{
		Component retVal = null;
		
		if( deploymentPart.getModelElement() instanceof Property )
		{
			retVal = ((Component)((Property)deploymentPart.getModelElement()).getType());
		}
		else if( deploymentPart.getModelElement() instanceof Connector )
		{
			retVal = ((Component)((Connector)deploymentPart.getModelElement()).getType());
		}
		else
		{
			assert(deploymentPart.getModelElement() instanceof Component );
			retVal = ((Component)deploymentPart.getModelElement());
		}
		
		return retVal;
	}

}
