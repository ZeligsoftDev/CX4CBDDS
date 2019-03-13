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
package com.zeligsoft.domain.dds4ccm.ui.edithelpers;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.util.NamingUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.omg.corba.util.CORBAUtil;

/**
 * Edit helper to set or create resource property for CIAO+DAnCE type node.
 * 
 * @author ysroh
 * 
 */
public class TargetNodeEditHelperAdvice extends AbstractEditHelperAdvice {

	private static final String INSTANCE_POSTFIX = "Instance"; //$NON-NLS-1$

	private static final String SATISFIER_PROPERTY_NAME = "edu.vanderbilt.dre.DAnCE.StringIOR"; //$NON-NLS-1$

	private static final String SATISFIER_PROPERTY_VALUE = "corbaloc:iiop:localhost:60070"; //$NON-NLS-1$

	@Override
	protected ICommand getAfterCreateCommand(final CreateElementRequest request) {

		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(request.getContainer()),
				"SetResourceType", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EObject newEObject = request.getNewElement();
				EObject container = request.getContainer();
				if (newEObject == null) {
					return null;
				}

				if (!ZDLUtil.isZDLConcept(newEObject, CCMNames.NODE)) {
					return null;
				}

				Component node = (Component) newEObject;

				EObject resource = findTargetResource(newEObject);
				Property satisfierProperty;
				if (resource != null) {
					satisfierProperty = ((Class) resource).getOwnedAttribute(
							SATISFIER_PROPERTY_NAME, null);
				} else {

					// if no Resource is found then create one
					resource = ((Package) container).createOwnedClass(
							NamingUtil.generateUniqueName("NodeAddress", //$NON-NLS-1$
									container.eContents()), false);
					if (resource == null) {
						return null;
					}
					ZDLUtil.addZDLConcept((Element) resource, CCMNames.RESOURCE);
					satisfierProperty = ((Class) resource)
							.createOwnedAttribute(SATISFIER_PROPERTY_NAME,
									(Type) CORBAUtil.getCORBAPrimitiveType(
											resource, "CORBAString")); //$NON-NLS-1$
					
					@SuppressWarnings("unchecked")
					List<String> resourceTypes = (List<String>)ZDLUtil.getValue(resource, CCMNames.REQUIREMENT_SATISFIER, CCMNames.REQUIREMENT_SATISFIER__RESOURCE_TYPE);
					resourceTypes.add("edu.vanderbilt.dre.DAnCE.NodeAddress");  //$NON-NLS-1$
					ZDLUtil.addZDLConcept(satisfierProperty,
							CCMNames.SATISFIER_PROPERTY);
					
					EnumerationLiteral literal = ZDLUtil.getZDLEnumLiteral(satisfierProperty, CCMNames.SATISFIER_PROPERTY_KIND, CCMNames.SATISFIER_PROPERTY_KIND___ATTRIBUTE);
					ZDLUtil.setValue(satisfierProperty, CCMNames.SATISFIER_PROPERTY, CCMNames.SATISFIER_PROPERTY__KIND, literal);
				}

				// create resource property
				Property resourceProperty = node.createOwnedAttribute(
						"resourceProperty", null); //$NON-NLS-1$
				ZDLUtil.addZDLConcept(resourceProperty,
						CCMNames.RESOURCE_PROPERTY);
				ZDLUtil.setValue(resourceProperty, CCMNames.RESOURCE_PROPERTY,
						CCMNames.RESOURCE_PROPERTY__TYPE, resource);

				
				// create default value
				Package instanceContainer = (Package) node
						.createPackagedElement(
								NamingUtil
										.generateUniqueName(
												"_" + node.getName(), node.getPackagedElements()), UMLPackage.Literals.PACKAGE); //$NON-NLS-1$
				String nodeInstanceName = NamingUtil.generateUniqueName(
						node.getName() + INSTANCE_POSTFIX,
						instanceContainer.getPackagedElements());
				InstanceSpecification nodeInstance = (InstanceSpecification) instanceContainer
						.createPackagedElement(nodeInstanceName,
								UMLPackage.Literals.INSTANCE_SPECIFICATION);
				nodeInstance.getClassifiers().add((Classifier) node);

				Slot nodeSlot = nodeInstance.createSlot();
				nodeSlot.setDefiningFeature((StructuralFeature) ((Classifier) resourceProperty
						.eContainer()).getFeature(resourceProperty.getName()));
				Property defaultInstanceAttr = node.createOwnedAttribute(
						CCMUtil.DEFAULT_PROPERTY_INSTANCE_NAME, null);

				String resourceInstanceName = NamingUtil.generateUniqueName(
						((Class) resource).getName() + INSTANCE_POSTFIX,
						instanceContainer.getPackagedElements());
				InstanceSpecification resourceInstance = (InstanceSpecification) instanceContainer
						.createPackagedElement(resourceInstanceName,
								UMLPackage.Literals.INSTANCE_SPECIFICATION);
				resourceInstance.getClassifiers().add((Classifier)resource);

				InstanceValue value = (InstanceValue) nodeSlot.createValue(
						null, null, UMLPackage.Literals.INSTANCE_VALUE);
				value.setInstance(resourceInstance);

				Slot satisfierSlot = resourceInstance.createSlot();
				satisfierSlot
						.setDefiningFeature((StructuralFeature) ((Classifier) satisfierProperty
								.eContainer()).getFeature(satisfierProperty
								.getName()));

				InstanceSpecification attributeInstance = (InstanceSpecification) instanceContainer
						.createPackagedElement(satisfierProperty.getName()
								+ INSTANCE_POSTFIX,
								UMLPackage.Literals.INSTANCE_SPECIFICATION);

				attributeInstance.getClassifiers().add(
						(Classifier) satisfierProperty.getType());

				LiteralString propertyValue = (LiteralString) attributeInstance
						.createSpecification(null, null,
								UMLPackage.Literals.LITERAL_STRING);

				propertyValue.setValue(SATISFIER_PROPERTY_VALUE);
				InstanceValue slotValue = (InstanceValue) satisfierSlot
						.createValue(null, null,
								UMLPackage.Literals.INSTANCE_VALUE);
				slotValue.setInstance(attributeInstance);

				value = (InstanceValue) defaultInstanceAttr.createDefaultValue(
						null, null, UMLPackage.Literals.INSTANCE_VALUE);

				value.setInstance(nodeInstance);

				return CommandResult.newOKCommandResult(newEObject);
			}
		};
	}

	/**
	 * Find Resource for CIAO+DAnCE node property type
	 * 
	 * @param context
	 * @return
	 */
	private EObject findTargetResource(EObject context) {
		EObject root = EcoreUtil.getRootContainer(context);
		TreeIterator<Object> itor = EcoreUtil.getAllContents(root, true);
		while (itor.hasNext()) {
			Object obj = itor.next();
			if (!(obj instanceof EObject)) {
				continue;
			}
			if (!(obj instanceof Package) && !(obj instanceof Class)) {
				itor.prune();
				continue;
			}
			if (ZDLUtil.isZDLConcept((EObject) obj, CCMNames.RESOURCE)) {
				if (((Class) obj).getOwnedAttribute(SATISFIER_PROPERTY_NAME,
						null) != null) {
					return (EObject) obj;
				}
			}
		}
		return null;
	}
}
