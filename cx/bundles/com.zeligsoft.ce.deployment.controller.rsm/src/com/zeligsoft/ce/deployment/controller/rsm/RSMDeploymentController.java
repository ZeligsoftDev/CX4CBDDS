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
package com.zeligsoft.ce.deployment.controller.rsm;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.EMFOperationCommand;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.zeligsoft.deployment.rsm.tooling.ext.commands.AddModelElementCommand;
import com.zeligsoft.deployment.rsm.tooling.ext.commands.DeleteDeploymentPartCommand;
import com.zeligsoft.deployment.rsm.tooling.ext.utils.ZDeploymentUtil;

/**
 * RSM controller class, containing RSM-specific aspects of deployment controller functionality that
 * we would not want the base UML controller to contain.
 * 
 * @author smcfee
 *
 */
public class RSMDeploymentController implements ResourceSetListener {

	public RSMDeploymentController(Component deployment)
	{
		TransactionUtil.getEditingDomain(deployment).addResourceSetListener(this);	
		setDeployment(deployment); 
		
	}	

	public EditingDomain getEditingDomain() {
		return UMLModeler.getEditingDomain();
	}

	/**
	 * The deployment we are controlling. This is returned as the result by the model reader
	 * (RunnableWithResult interface) and used by the resource set listener.
	 */
	private Component deployment;
	
	public IStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStatus(IStatus status) {
		// TODO Auto-generated method stub
		
	}

	public NotificationFilter getFilter() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAggregatePrecommitListener() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPostcommitOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPrecommitOnly() {

		return true;
	}

	public void resourceSetChanged(ResourceSetChangeEvent event) {		
	}

	@SuppressWarnings("unchecked")
	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {


		Command returnCommand = null;
		
		for (Iterator iter = event.getNotifications().iterator(); iter.hasNext();) {
			Notification notification = (Notification) iter.next();
			Object notifier = notification.getNotifier();

			if (notifier instanceof EObject) {
				// only respond to changes to structural features of the object		
								
				if (notification.getFeature() instanceof EStructuralFeature) 
				{
					EStructuralFeature feature = (EStructuralFeature) notification.getFeature();
					
					if( feature.equals(UMLPackage.Literals.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE))
					{
						if( notification.getOldValue() == null && notification.getNewValue() != null )
						{
							if( notification.getNewValue() instanceof Property )
							{
								Property newChild = (Property)notification.getNewValue();
								if( ZDeploymentUtil.isDeploymentPart(newChild) == false)
								{
									EMFOperationCommand command = new EMFOperationCommand(TransactionUtil.getEditingDomain(deployment), 
											new AddModelElementCommand(deployment, newChild, (Component)notifier, "Add Part"));
									returnCommand = command;
								}
							}
						}
					}
					else if( feature.equals(UMLPackage.Literals.STRUCTURED_CLASSIFIER__OWNED_CONNECTOR))
					{
						if( notification.getOldValue() == null && notification.getNewValue() != null )
						{
							if( notification.getNewValue() instanceof Connector )
							{
								Connector newChild = (Connector)notification.getNewValue();
								EMFOperationCommand command = new EMFOperationCommand(TransactionUtil.getEditingDomain(deployment), 
										new AddModelElementCommand(deployment, newChild, (Component)notifier, "Add Part"));
								returnCommand = command;
							}
						}
					}					
					else if( feature.equals(UMLPackage.Literals.TYPED_ELEMENT__TYPE))
					{ 
						if( notifier instanceof Property && notification.getOldValue() instanceof Component && notification.getNewValue() == null )
						{
							Property part = (Property)notifier;
							if( ZDeploymentUtil.isDeploymentPart(part))
							{
								EMFOperationCommand command = new EMFOperationCommand(TransactionUtil.getEditingDomain(deployment), 
									new DeleteDeploymentPartCommand(deployment, part, "Delete Part"));
								returnCommand = command;
							}
						} 
					}
					else if( feature.getName().equals("modelElement") )
					{
						if( ZDeploymentUtil.isDeploymentPart((Property)UMLUtil.getBaseElement((EObject)notifier)) )
						{
							if( notification.getOldValue() != null && notification.getNewValue() == null )
							{
								EMFOperationCommand command = new EMFOperationCommand(TransactionUtil.getEditingDomain(deployment), 
										new DeleteDeploymentPartCommand(deployment, (Property)UMLUtil.getBaseElement((EObject)notifier), "Delete Part"));
								if( returnCommand != null )
								{
									returnCommand = returnCommand.chain(command);
								}
								else
								{
									returnCommand = command;
								}
							}
						}
						
					}
				}
			}
		}
		
		return returnCommand;
	}

	public Component getDeployment() {
		return deployment;
	}

	public void setDeployment(Component deployment) {
		this.deployment = deployment;
	}
	
	public void save() {		
	}
		
	public boolean isDirty()
	{
		return ((BasicCommandStack)getEditingDomain().getCommandStack()).isSaveNeeded();
	}	

}
