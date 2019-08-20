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
package com.zeligsoft.cx.deployment.ui.listeners;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.EMFOperationCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.validation.util.ValidationUtil;
import com.zeligsoft.base.zdl.LinkConstraintContext;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.deployment.ui.commands.AddModelElementCommand;
import com.zeligsoft.cx.deployment.ui.commands.DeleteDeploymentPartCommand;
import com.zeligsoft.cx.deployment.ui.commands.SetPropertyNameCommand;
import com.zeligsoft.cx.deployment.ui.l10n.ZDeploymentMessages;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * RSM controller class, containing RSM-specific aspects of deployment
 * controller functionality that we would not want the base UML controller to
 * contain.
 * 
 * @author smcfee
 * 
 */
public class DeploymentListener
		extends ResourceSetListenerImpl {

	private TransactionalEditingDomain initialDomain;
	
	/**
	 * Creates a resource set listener which synchronize the given deployment
	 * when the underlying model changes.
	 * 
	 * @param deployment
	 */
	public DeploymentListener(Component deployment) {
		this.deployment = deployment;
		initialDomain = getEditingDomain();
	}

	public TransactionalEditingDomain getInitialDomain() {
		return this.initialDomain;
	}

	public TransactionalEditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(deployment);
	}

	/**
	 * The deployment we are controlling. This is returned as the result by the
	 * model reader (RunnableWithResult interface) and used by the resource set
	 * listener.
	 */
	private Component deployment;

	@Override
	public boolean isPrecommitOnly() {
		return true;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {

		if (getEditingDomain() == null)
			return null;

		CompoundCommand returnCommand = new CompoundCommand("DeploymentPartCommand"); //$NON-NLS-1$

		for (Iterator iter = event.getNotifications().iterator(); iter
			.hasNext();) {
			Notification notification = (Notification) iter.next();
			Object notifier = notification.getNotifier();

			if (notifier instanceof EObject) {
				// only respond to changes to structural features of the object

				if (notification.getFeature() instanceof EStructuralFeature) {
					EStructuralFeature feature = (EStructuralFeature) notification
						.getFeature();

					if (feature
							.equals(UMLPackage.Literals.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE)) {
						if (notification.getOldValue() == null
								&& notification.getNewValue() != null
								&& notification.getEventType() == Notification.ADD) {
							if (notification.getNewValue() instanceof Property) {
								Property newChild = (Property) notification
										.getNewValue();
								// We normally do not need to add deployment
								// part when new property is added rather we add
								// the deployment part when property type
								// is set.
								// However, if the property is created by
								// duplicate or copy-paste function or by moving
								// then no
								// notification with
								// UMLPackage.Literals.TYPED_ELEMENT__TYPE
								// feature is caught so we have to add
								// deployment part here. bug#16305

								boolean isValidDeploymentPart = false;
								if (newChild.getType() != null) {
									EObject source = newChild.getType();
									EObject target = (EObject) notifier;
										if( ZDLUtil.isZDLConcept(target, ZMLMMNames.STRUCTURAL_REALIZATION)) {
											target = (EObject)ZDLUtil.getValue(target, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE);
									}
										isValidDeploymentPart = isValidDeploymentPart(source, target);
								}
								if (isValidDeploymentPart) {
									EMFOperationCommand command = new EMFOperationCommand(
											getEditingDomain(),
											new AddModelElementCommand(
													deployment,
													newChild,
													(Component) notifier,
													null,
													ZDeploymentMessages.Add__Deployment_Part));
									returnCommand.append(command);
								}
							}
						} else if (ZDLUtil.isZDLConcept((EObject) notification.getOldValue(), ZMLMMNames.PART)
								&& notification.getOldValue() instanceof EObject
								&& notification.getNewValue() == null
								&& notification.getEventType() == Notification.REMOVE) {
							// when part is moved from one assembly to another
							// we need to delete its
							// deployment part as well
							final List<Property> deploymentParts = ZDeploymentUtil
									.getDeploymentPartForModelElement(
											getDeployment(),
											(Property) notification
													.getOldValue());
							if (!deploymentParts.isEmpty()) {
								EMFOperationCommand command = new EMFOperationCommand(
										getEditingDomain(),
										new DeleteDeploymentPartCommand(
												deployment,
												deploymentParts,
												ZDeploymentMessages.Delete__Deployment_Part));
								returnCommand.append(command);
							}
						}
					}
					else if (feature
							.equals(UMLPackage.Literals.STRUCTURED_CLASSIFIER__OWNED_CONNECTOR)) {
						if (notification.getOldValue() == null
								&& notification.getNewValue() != null) {
							if (notification.getNewValue() instanceof Connector) {
								boolean isValidDeploymentPart = isValidDeploymentPart(
										(EObject) notification.getNewValue(),
										(EObject) notifier);
								if (isValidDeploymentPart) {
									Connector newChild = (Connector) notification
											.getNewValue();
									EMFOperationCommand command = new EMFOperationCommand(
											getEditingDomain(),
											new AddModelElementCommand(
													deployment,
													newChild,
													(Component) notifier,
													null,
													ZDeploymentMessages.Add__Deployment_Part));
									returnCommand.append(command);
								}
							}
						}
					} 
					else if (feature.equals(UMLPackage.Literals.NAMED_ELEMENT__NAME)
							&& (notifier instanceof Property)) {
						
						if (!ZDLUtil.isZDLConcept((EObject) notifier,
								ZMLMMNames.DEPLOYMENT_PART)) {

							// If a property name has changed, we need to update
							// any deployment part that
							// have that property as a model element.

							String newName = (String) notification
									.getNewValue();
							List<Property> list = ZDeploymentUtil
									.getDeploymentPartForModelElement(
											deployment, (NamedElement) notifier);

							for (int i = 0; i < list.size(); i++) {
								Property property = list.get(i);
								Object oldValue = notification.getOldValue();
								if (oldValue == null
										|| !(oldValue instanceof String))
									continue;
								// Do an extra check, if the user has changed
								// the deployment part property
								// name, we will leave, and not synchronize
								if (property.getName().equals(oldValue)) {
									ICommand setCommand = new SetPropertyNameCommand(
											getEditingDomain(), property,
											newName);
									returnCommand
											.append(new EMFOperationCommand(
													getEditingDomain(),
													setCommand));
								}
							}
						}
					} 					
					else if (feature
						.equals(UMLPackage.Literals.TYPED_ELEMENT__TYPE)) {
						if (notifier instanceof Property
								&& notification.getOldValue() instanceof Class 
								&& !ZDLUtil.isZDLConcept((Property)notifier, ZMLMMNames.PORT)) {
							// type is removed from the part
							Property property = (Property) notifier;
							List<Property> parts = ZDeploymentUtil
									.getDeploymentPartForModelElement(
											deployment, property);
							if (!parts.isEmpty()) {
								EMFOperationCommand command = new EMFOperationCommand(
										getEditingDomain(),
										new DeleteDeploymentPartCommand(
												deployment,
												parts,
												ZDeploymentMessages.Delete__Deployment_Part));
								returnCommand.append(command);
							}
						}
						if (notifier instanceof Property
								&& notification.getNewValue() instanceof Class) {
							// new type is set to the part
							Property property = (Property) notifier;
							if (ZDeploymentUtil.isDeploymentPart(property) == false
									&& property.getType() != null) {
								boolean isValidDeploymentPart = false;
								EObject source = property.getType();
								EObject target = ((Property) notifier)
										.eContainer();
								if (property.eContainer() instanceof Component) {

									if (ZDLUtil.isZDLConcept(target,
											ZMLMMNames.STRUCTURAL_REALIZATION)) {
										target = (EObject) ZDLUtil
												.getValue(
														target,
														ZMLMMNames.STRUCTURAL_REALIZATION,
														ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE);
									}
								}
								isValidDeploymentPart = isValidDeploymentPart(
										source, target);
								if (isValidDeploymentPart) {
									EMFOperationCommand command = new EMFOperationCommand(
											getEditingDomain(),
											new AddModelElementCommand(
													deployment,
													property,
													(Component) ((Property) notifier)
															.eContainer(),
													null,
													ZDeploymentMessages.Add__Deployment_Part));
									returnCommand.append(command);
								}
							}
						}
					} else if (feature.getName().equals(
						ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT)) {
						Element baseElement = UMLUtil
							.getBaseElement((EObject) notifier);
						if (baseElement instanceof Property
							&& ZDeploymentUtil
								.isDeploymentPart((Property) baseElement)) {
							if (notification.getOldValue() != null
								&& notification.getNewValue() == null) {
								EMFOperationCommand command = new EMFOperationCommand(
									getEditingDomain(),
									new DeleteDeploymentPartCommand(
												deployment,
												Collections
														.singletonList((Property) UMLUtil
																.getBaseElement((EObject) notifier)),
												ZDeploymentMessages.Delete__Deployment_Part));
								returnCommand.append(command);
							}
						}
					}
				}
			}
		}

		return returnCommand;
	}
	
	/**
	 * Returns true if the source is a valid 
	 * contained deployment part in target. 
	 * 
	 * @param EObject source
	 * @param EObject target
	 * @return boolean isValidDeploymentPart
	 */
	protected boolean isValidDeploymentPart(EObject source, EObject target){
		if(source == null || target == null){
			return false;
		}
		return ValidationUtil.canLink(
				LinkConstraintContext.DEPLOYMENT_PART,
				source,
				target);
	}

	public Component getDeployment() {
		return deployment;
	}
}
