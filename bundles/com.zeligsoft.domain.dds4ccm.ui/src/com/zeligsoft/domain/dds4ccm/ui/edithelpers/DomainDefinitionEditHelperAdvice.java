/*
 * Copyright 2022 Zeligsoft Limited.
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
package com.zeligsoft.domain.dds4ccm.ui.edithelpers;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.VisibilityKind;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.dialogs.ZDLElementSelectionDialog;
import com.zeligsoft.cx.ui.filters.ElementSelectionFilter;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.preferences.CCMPreferenceConstants;
import com.zeligsoft.domain.omg.ccm.ui.l10n.Messages;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

import dds4ccm.BridgeInstance;
import dds4ccm.DomainDefinition;
import dds4ccm.DomainDeployment;
import dds4ccm.InterconnectInstance;
import dds4ccm.NodeInstance;

/**
 * @author eposse
 */
public class DomainDefinitionEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		final CreateElementRequest editRequest = request;

		return new AbstractTransactionalCommand(TransactionUtil.getEditingDomain(request.getContainer()),
				Messages.CommandLabel_SCAComponentPartEditHelperAdvice_getAfterCreateCommand, null) {

			CreateElementRequest _editRequest = editRequest;
			
			@SuppressWarnings("unchecked")
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EObject newEObject = editRequest.getNewElement();
				if (newEObject == null) {
					return null;
				}
				
				if (isDomainDeployment(newEObject)) {
					return configureDomainDeployment(newEObject);
				} else if (isNodeInstance(newEObject)
						|| isBridgeInstance(newEObject)
						|| isInterconnectInstance(newEObject)) {
					return configureDomainPart(newEObject);
				}
				
				return CommandResult.newOKCommandResult();
			}

			private boolean isDomainDeployment(EObject newEObject) {
				return newEObject instanceof Component
						&& ZDLUtil.isZDLConcept(newEObject, DDS4CCMNames.DOMAIN_DEPLOYMENT);
			}

			private boolean isNodeInstance(EObject newEObject) {
				return newEObject instanceof Property
						&& ZDLUtil.isZDLConcept(newEObject, CCMNames.NODE_INSTANCE);
			}

			private boolean isBridgeInstance(EObject newEObject) {
				return newEObject instanceof Property
						&& ZDLUtil.isZDLConcept(newEObject, CCMNames.BRIDGE_INSTANCE);
			}

			private boolean isInterconnectInstance(EObject newEObject) {
				return newEObject instanceof Property
						&& ZDLUtil.isZDLConcept(newEObject, CCMNames.INTERCONNECT_INSTANCE);
			}

			/**
			 * Configures the new domain deployment by creating the deployment parts corresponding to 
			 * the domain definition properties (Node instances, Bridge Instances and Interconnect instances).
			 * 
			 * @param newEObject - An {@link EObject} which is assumed to be a UML {@link Component} and 
			 * 						whose ZDL concept is DOMAIN_DEPLOYMENT.
			 * @return A {@link CommandResult}
			 */
			private CommandResult configureDomainDeployment(EObject newEObject) {
				Component domainDeployment = (Component) newEObject;
				IStatus status = createDeploymentParts(domainDeployment);
				
				if (status.isOK()) {
					return CommandResult.newOKCommandResult(domainDeployment);
				}
				return CommandResult.newErrorCommandResult("Error creating deployment parts. See Error Log.");
			}

			/**
			 * Configures the new domain definition property setting its aggregation to COMPOSITE,
			 * its visibility to PRIVATE, asks the user to select its type, and creates the corresponding
			 * parts in all domain deployments in the domain definition.
			 * 
			 * @param newEObject - An {@link EObject} which is assumed to be a UML {@link Property} with
			 * 						ZDL concept being one of: NODE_INSTANCE, BRIDGE_INSTANCE or INTERCONNECT_INSTANCE
			 * @return A {@link CommandResult}
			 */
			private CommandResult configureDomainPart(EObject newEObject) {
				Property newProperty = (Property) newEObject;
				newProperty.setAggregation(AggregationKind.COMPOSITE_LITERAL);
				newProperty.setVisibility(VisibilityKind.PRIVATE_LITERAL);
			
				Type propertyType = newProperty.getType();
				if (editRequest.getParameter("type") == null && propertyType == null) {
					setPropertyType(newProperty.eContainer(), newProperty);
				}
				
				IStatus status = createDeploymentPartInAllDeployments(newProperty);
				
				if (status.isOK()) {
					return CommandResult.newOKCommandResult(newProperty);
				}
				return CommandResult.newErrorCommandResult("Error creating deployment parts. See Error Log.");
			}

			/**
			 * Sets the type of the property by poping up a dialog and asking the user to select the relevant type.
			 * 
			 * @param container
			 * @param newProperty
			 * @return
			 */
			private void setPropertyType(EObject container, Property newProperty) {
				if (InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID)
						.getBoolean(CCMPreferenceConstants.AUTO_TYPE_SELECTION_DIALOG, true)) {
					ZDLElementSelectionDialog dialog = new ZDLElementSelectionDialog(
							Display.getCurrent().getActiveShell(), container, Collections.EMPTY_LIST, true, true);

					if (ZDLUtil.isZDLConcept(newProperty, CCMNames.NODE_INSTANCE)) {
						dialog.setElementFilter(
								new ElementSelectionFilter(CCMNames.NODE_INSTANCE, CCMNames.NODE_INSTANCE__TYPE));
					} else if (ZDLUtil.isZDLConcept(newProperty, CCMNames.BRIDGE_INSTANCE)) {
						dialog.setElementFilter(new ElementSelectionFilter(CCMNames.BRIDGE_INSTANCE,
								CCMNames.BRIDGE_INSTANCE__TYPE));
					} else if (ZDLUtil.isZDLConcept(newProperty, CCMNames.INTERCONNECT_INSTANCE)) {
						dialog.setElementFilter(new ElementSelectionFilter(CCMNames.INTERCONNECT_INSTANCE,
								CCMNames.INTERCONNECT_INSTANCE__TYPE));
					} else {
						return;
					}
					if (dialog.open() == Window.OK) {
						if (!dialog.getSelectedElements().isEmpty()
								&& dialog.getSelectedElements().getFirstElement() != null) {
							newProperty.setType((Type) dialog.getSelectedElements().getFirstElement());
						}
					}
				}
			}

			/**
			 * Creates the deployment parts corresponding to domain definition properties
			 * in all domain deployments of the given domain definition. It avoids creating parts that already exist.
			 * 
			 * <p>Note that this is different than {@link #createDeploymentPartInAllDeployments(Property)} in that
			 * this method will create *all* parts of the domain definition in all deployments, if they don't already
			 * exist in a deployment, while the {@link #createDeploymentPartInAllDeployments(Property)} method will 
			 * create *only* the *single* part corresponding to the property.
			 * 
			 * @param domainDefinitionProperty	- A UML {@link Property}; it must be a property of a {@link DomainDefinition}.
			 * @return An {@link ICommand} that creates the structure in all the deployments of the domain definition.
			 */
			private IStatus createDeploymentPartsInAllDeployments(Property domainDefinitionProperty) {
				MultiStatus multiStatus = new MultiStatus(Activator.PLUGIN_ID, IStatus.INFO, "Create deployment parts in all deployments");
				Component domainDefinition = (Component) domainDefinitionProperty.getOwner();
				for (Element element : domainDefinition.getPackagedElements()) { 
					if (element instanceof Component && ZDLUtil.isZDLConcept(element, DDS4CCMNames.DOMAIN_DEPLOYMENT)) {
						Component domainDeployment = (Component)element;
						IStatus status = createDeploymentParts(domainDeployment);
						multiStatus.add(status);
					}
				}
				return multiStatus;
			}

			/**
			 * Creates the deployment part corresponding to the given domain definition property
			 * in all domain deployments of the given domain definition. It avoids creating parts that already exist.
			 * 
			 * <p> Note that this is different than {@link #createDeploymentPartsInAllDeployments(Property)} in that
			 * this method will create *only* a part corresponding to the given domain definition property in all
			 * deployments, while the {@link #createDeploymentPartsInAllDeployments(Property)} method will create
			 * *all* parts for all domain definition properties.
			 * 
			 * @param domainDefinitionProperty	- A UML {@link Property}; it must be a property of a {@link DomainDefinition}.
			 * @return An {@link ICommand} that creates the structure in all the deployments of the domain definition.
			 */
			private IStatus createDeploymentPartInAllDeployments(Property domainDefinitionProperty) {
				MultiStatus multiStatus = new MultiStatus(Activator.PLUGIN_ID, IStatus.INFO, "Create deployment part in all deployments");
				Component domainDefinition = (Component) domainDefinitionProperty.getOwner();
				for (Element element : domainDefinition.getPackagedElements()) { 
					if (element instanceof Component && ZDLUtil.isZDLConcept(element, DDS4CCMNames.DOMAIN_DEPLOYMENT)) {
						Component domainDeployment = (Component)element;
						IStatus status = createDeploymentPartForDomainProperty(domainDeployment, domainDefinitionProperty);
						multiStatus.add(status);
					}
				}
				return multiStatus;
			}

			/**
			 * Creates the deployment parts corresponding to domain definition properties
			 * in a given domain deployment. It avoids creating parts that already exist.
			 * 
			 * @param domainDeployment	- A UML {@link Component}; it must be a {@link DomainDeployment}; it must be contained in a domain definition.
			 * @return An {@link ICommand} that creates the structure in the deployment.
			 */
			private IStatus createDeploymentParts(Component domainDeployment) {
				MultiStatus multiStatus = new MultiStatus(Activator.PLUGIN_ID, IStatus.INFO, "Create deployment parts");
				Component domainDefinition = (Component) domainDeployment.getOwner();
				for (Property domainDefinitionProperty : domainDefinition.allAttributes()) {
					if (ZDLUtil.isZDLConcept(domainDefinitionProperty, CCMNames.NODE_INSTANCE)) {
						IStatus status = createDeploymentPartForDomainProperty(domainDeployment, domainDefinitionProperty);
						multiStatus.add(status);
					}
				}
				return multiStatus;
			}
			
			/**
			 * Creates a (deployment) property (such as a Node Instance, Bridge Instance or Interconnect instance) in a DomainDeployment,
			 * but only if one with the same name and type is already present.
			 * 
			 * @param domainDeployment			- A UML {@link Component}; it must be a {@link DomainDeployment}.
			 * @param domainDefinitionProperty	- A UML {@link Property} of the {@link DomainDefinition} that contains the domainDeployment; 
			 * 										it must be e {@link NodeInstance}, {@link BridgeInstance} or a {@link InterconnectInstance}.
			 * @return an {@link ICommand} that creates the property and the required substructure in the domainDeployment.
			 */
			private IStatus createDeploymentPartForDomainProperty(Component domainDeployment, Property domainDefinitionProperty) {
				boolean deploymentHasProperty = hasDomainDefinitionProperty(domainDeployment, domainDefinitionProperty);
				if (!deploymentHasProperty) {
					try {
						Property deploymentPart = ZDeploymentUtil.buildDeploymentPartFromModelElement(domainDefinitionProperty, domainDeployment,
								null, null);

						if (deploymentPart != null) {
							ZDLUtil.addZDLConcept(deploymentPart, DDS4CCMNames.DOMAIN_DEPLOYMENT_PART);
							@SuppressWarnings("unchecked")
							EList<EObject> parts = (EList<EObject>) ZDLUtil.getValue(domainDeployment,
									DDS4CCMNames.DOMAIN_DEPLOYMENT,
									DDS4CCMNames.DOMAIN_DEPLOYMENT__PARTS);
							parts.add(deploymentPart);
							return Status.OK_STATUS;
						}
					} catch (Exception e) {
						// We may get an NPE if the domainDefinitionProperty has no type
						e.printStackTrace();
					}
				}
				return Status.CANCEL_STATUS;
			}

			/**
			 * Determines whether the given domain deployment has a deployment part corresponding to the given domain definition property.
			 * 
			 * @param domainDeployment			- A UML {@link Component}; it must be a {@link DomainDeployment}.
			 * @param domainDefinitionProperty	- A UML {@link Property} of the {@link DomainDefinition} that contains the domainDeployment; 
			 * 										it must be e {@link NodeInstance}, {@link BridgeInstance} or a {@link InterconnectInstance}.
			 * @return {@code true} iff domainDeployment contains a property which is an ZDLConcept Deployment Part.
			 */
			private boolean hasDomainDefinitionProperty(Component domainDeployment, Property domainDefinitionProperty) {
				boolean deploymentHasProperty = false;
				for (Property domainDeploymentProperty: domainDeployment.allAttributes()) {
					boolean isDeploymentPart = false;
					if (ZDLUtil.isZDLConcept(domainDeploymentProperty, ZMLMMNames.DEPLOYMENT__PART)) {
						isDeploymentPart = true;
					} else if (ZDLUtil.isZDLConcept(domainDeploymentProperty, ZMLMMNames.DEPLOYMENT_PART)) {
						isDeploymentPart = true;
					}
					if (isDeploymentPart && domainDeploymentProperty.getName().equals(domainDefinitionProperty.getName())) {
						deploymentHasProperty = true;
					}
				}
				return deploymentHasProperty;
			}

		};
	}

}
