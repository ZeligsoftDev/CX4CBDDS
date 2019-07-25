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
package com.zeligsoft.domain.idl3plus.ui.listeners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.workspace.EMFOperationCommand;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.deployment.ui.commands.DeleteDeploymentPartCommand;
import com.zeligsoft.domain.idl3plus.ui.commands.IDL3PlusAddModelElementCommand;
import com.zeligsoft.domain.idl3plus.ui.commands.IDL3PlusRemoveInstanceSpecification;
import com.zeligsoft.domain.idl3plus.ui.commands.IDL3PlusSetPortTypeCommand;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * 
 * @author parmvirs
 *
 */
public class IDL3PlusDeploymentListener extends ResourceSetListenerImpl {

	@Override
	public boolean isPrecommitOnly() {
		return true;
	}

	public static IDL3PlusDeploymentListener getInstance() {
		return new IDL3PlusDeploymentListener();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {
		CompoundCommand returnCommand = new CompoundCommand(
				"IDL3PlusDeploymentPartCommand"); //$NON-NLS-1$
		for (Notification notification : event.getNotifications()) {
			if (notification.getNotifier() instanceof EObject) {
				EObject notifier = (EObject) notification.getNotifier();
				if ((ZDLUtil.isZDLConcept(notifier, CCMNames.INTERFACE_PORT) || ZDLUtil
						.isZDLConcept(notifier, CCMNames.EVENT_PORT))
						&& notifier instanceof Port) {
					
					final List<Object> deployments = getAvailableDeployments(notifier);
					for (Object obj : deployments) {
						if (obj instanceof EObject
								&& ZDLUtil.isZDLConcept((EObject) obj,
										CCMNames.DEPLOYMENT_PLAN)) {
							Component deployment = (Component) obj;
							if (notification.getOldValue() instanceof EObject
									&& notification.getNewValue() instanceof EObject
									&& ZDLUtil.isZDLConcept(
											(EObject) notification
													.getOldValue(),
											ZMLMMNames.PORT_TYPEABLE)
									&& ZDLUtil.isZDLConcept(
											(EObject) notification
													.getNewValue(),
											ZMLMMNames.PORT_TYPEABLE)) {
								EObject newPortType = (EObject) notification
										.getNewValue();
								List<Property> parts = ZDeploymentUtil
										.getDeploymentPartForModelElement(
												deployment, (Port) notifier);
								if (!parts.isEmpty()) {
									EMFOperationCommand command = new EMFOperationCommand(
											event.getEditingDomain(),
											new IDL3PlusSetPortTypeCommand(
													parts, (Type) newPortType,
													"Set Port Type")); //$NON-NLS-1$
									returnCommand.append(command);
								}
							} else if (notification.getNewValue() instanceof EObject
									&& ZDLUtil.isZDLConcept(
											(EObject) notification
													.getNewValue(),
											ZMLMMNames.PORT_TYPEABLE)
									&& notification.getOldValue() == null) {
								EObject newPortType = (EObject) notification
										.getNewValue();
								List<Property> parts = ZDeploymentUtil
										.getDeploymentPartForModelElement(
												deployment, (Port) notifier);
								if (!parts.isEmpty()) {
									EMFOperationCommand command = new EMFOperationCommand(
											event.getEditingDomain(),
											new IDL3PlusSetPortTypeCommand(
													parts, (Type) newPortType,
													"Set Port Type")); //$NON-NLS-1$
									returnCommand.append(command);
								} else {
									EMFOperationCommand command = new EMFOperationCommand(
											event.getEditingDomain(),
											new IDL3PlusAddModelElementCommand(
													deployment,
													(Port) notifier,
													(Component) ((Property) notifier)
															.eContainer(),
													null, "Add Part")); //$NON-NLS-1$
									returnCommand.append(command);
								}
							} else if (notification.getOldValue() instanceof EObject
									&& ZDLUtil.isZDLConcept(
											(EObject) notification
													.getOldValue(),
											ZMLMMNames.PORT_TYPEABLE)
									&& notification.getNewValue() == null) {
								List<Property> parts = ZDeploymentUtil
										.getDeploymentPartForModelElement(
												deployment, (Port) notifier);
								if (!parts.isEmpty()) {
									EMFOperationCommand command = new EMFOperationCommand(
											event.getEditingDomain(),
											new DeleteDeploymentPartCommand(
													deployment, parts,
													"Remove part")); //$NON-NLS-1$
									returnCommand.append(command);
								}
							}
						}
					}
				} else if (ZDLUtil.isZDLConcept(notifier,
						CCMNames.DEPLOYMENT_PLAN)) {
					if (notification.getNewValue() instanceof EObject
							&& ZDLUtil.isZDLConcept(
									(EObject) notification.getNewValue(),
									ZMLMMNames.COMPONENT_DEPLOYMENT_PART)) {
						Property parentPart = (Property) notification
								.getNewValue();
						EObject modelElement = ZDeploymentUtil
								.getModelComponent(parentPart);
						if (ZDLUtil.isZDLConcept(modelElement,
								CCMNames.CCMCOMPONENT)) {
							List<Port> ownedPorts = (List<Port>) ZDLUtil
									.getValue(
											modelElement,
											ZMLMMNames.COMPONENT_INTERFACE,
											ZMLMMNames.COMPONENT_INTERFACE__OWNED_PORT);
							for (Port port : ownedPorts) {
								EMFOperationCommand command = new EMFOperationCommand(
										event.getEditingDomain(),
										new IDL3PlusAddModelElementCommand(
												(Component) notifier, port,
												parentPart, null, "Add Part")); //$NON-NLS-1$
								returnCommand.append(command);

							}
						}
					}
				} else if (ZDLUtil
						.isZDLConcept(notifier, CCMNames.CCMCONNECTOR)
						&& notification.getEventType() == Notification.ADD) {
					List<EObject> ends = (List<EObject>) ZDLUtil.getValue(
							notifier, ZMLMMNames.ASSEMBLY_CONNECTOR,
							ZMLMMNames.ASSEMBLY_CONNECTOR__END);
					Port port = null;
					Property dataSpace = null;
					for (EObject end : ends) {
						if (ZDLUtil.isZDLConcept(end, ZMLMMNames.CONNECTOR_END)) {
							if (port == null) {
								port = (Port) ZDLUtil.getValue(end,
										ZMLMMNames.CONNECTOR_END,
										ZMLMMNames.CONNECTOR_END__PORT);
							}
							if (dataSpace == null) {
								dataSpace = (Property) ZDLUtil.getValue(end,
										ZMLMMNames.CONNECTOR_END,
										ZMLMMNames.CONNECTOR_END__PART);
							}
						}
					}
					if (port != null && dataSpace != null) {
						List<Object> deployments = (List<Object>) ZDeploymentUtil
								.getDeploymentsForModel(port.getModel());
						for (Object obj : deployments) {
							if (obj instanceof EObject
									&& ZDLUtil.isZDLConcept((EObject) obj,
											CCMNames.DEPLOYMENT_PLAN)) {
								List<Property> perPorts = ZDeploymentUtil
										.getDeploymentPartForModelElement(
												(Component) obj, port);
								for (Property perPort : perPorts) {
									if (perPort.getDefaultValue() != null) {
									InstanceSpecification instance = ((InstanceValue) perPort
											.getDefaultValue()).getInstance();
									if (!instance.getClassifiers().contains(dataSpace.getType())) {
										EMFOperationCommand command = new EMFOperationCommand(
												event.getEditingDomain(),
												new IDL3PlusRemoveInstanceSpecification(
														instance, perPort,
														"Remove Instance")); //$NON-NLS-1$
										returnCommand.append(command);
									}
								}}
							}
						}
					}
				}
			}
		}
		return returnCommand;
	}

	/**
	 * Find all deployments that could possibly reference this notifier.
	 * @param notifier an EObject
	 * @return
	 */
	private List<Object> getAvailableDeployments(EObject notifier) {
		final ResourceSet resourceSet = notifier.eResource().getResourceSet();
		final List<Model> models = new ArrayList<Model>();
		for(Resource resource: resourceSet.getResources()) {
			final List<EObject> contents = resource.getContents();
			if(contents.size() > 0 && contents.get(0) instanceof Model) {
				models.add((Model)contents.get(0));
			}
		}
		final List<Object> deployments = new ArrayList<Object>();
		for (Model model : models) {
			deployments.addAll(ZDeploymentUtil.getDeploymentsForModel(model));
		}
		return deployments;
	}

}
