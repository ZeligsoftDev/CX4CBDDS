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

package com.zeligsoft.domain.idl3plus.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Utilities for DDS4CCM descriptor generation.
 * 
 * @author smcfee
 * 
 */
public class IDL3PlusXtendUtils {

	/**
	 * Find the slot for the default value of a property if it exists.
	 * 
	 * @param property
	 *            The property to find the default value for.
	 * @param port
	 *            Optional parameter indicating the port to use in the case of a
	 *            DataSpace
	 * @param componentDef
	 *            The component on which to look for the slot.
	 * @param connectorDeploymentPart
	 *            The deploymentPart where the property is contained, if
	 *            applicable. This is usually specified but may be null in the
	 *            case of a struct property on a component.
	 * @return
	 */
	private static List<Slot> findDefaultSlot(Property property, Property port,
			Component componentDef, Property connectorDeploymentPart) {

		List<Slot> results = new ArrayList<Slot>();

		if (connectorDeploymentPart != null
				&& ZDLUtil.isZDLConcept(componentDef,
						IDL3PlusNames.CONNECTOR_DEF)) {

			List<EObject> ancestorList = new ArrayList<EObject>();
			if (port != null) {
				ancestorList.add(port);
			}

			Property instanceProperty = componentDef.getOwnedAttribute(
					CCMUtil.DEFAULT_PROPERTY_INSTANCE_NAME, null);
			if (componentDef != null && instanceProperty != null) {
				// try to get default value from the connector definition
				if (instanceProperty.getDefaultValue() != null
						&& instanceProperty.getDefaultValue() instanceof InstanceValue) {
					Slot result = CCMUtil
							.getInstanceSlotForProperty(
									((InstanceValue) instanceProperty
											.getDefaultValue()).getInstance(),
									property, ancestorList);
					if (result != null) {
						results.add(result);
					}
				}
			}

			EObject binding = IDL3PlusUtil.findConnectorDefaultValueBinding(
					connectorDeploymentPart, componentDef);

			if (binding == null) {
				return results;
			}

			Property actualProperty = IDL3PlusUtil
					.getOriginalPropertyForInstantiatedProperty(property,
							binding);
			if (actualProperty == null) {
				actualProperty = property;
			}
			List<EObject> actualAncestorList = new ArrayList<EObject>();
			if (port != null) {
				Property actualPort = IDL3PlusUtil
						.getOriginalPropertyForInstantiatedProperty(port,
								binding);
				if (actualPort != null) {
					ancestorList.add(actualPort);
				} else {
					ancestorList.add(port);
				}
			}

			if (binding != null) {

				InstanceSpecification instance = (InstanceSpecification) ZDLUtil
						.getValue(
								binding,
								IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING,
								IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING__CONNECTOR_INSTANCE);

				Slot result = CCMUtil.getInstanceSlotForProperty(instance,
						actualProperty, actualAncestorList);
				if (result != null) {
					results.add(result);
				}
			}
		} else if (ZDLUtil.isZDLConcept(componentDef, CCMNames.CCMCOMPONENT)
				|| ZDLUtil.isZDLConcept(componentDef,
						CCMNames.CONTAINER_PROCESS)) {
			for (TreeIterator<?> iter = componentDef.eAllContents(); iter
					.hasNext();) {
				Object next = iter.next();
				if (next instanceof Slot) {
					if (((Slot) next).getDefiningFeature() == property) {
						results.add((Slot) next);
						break;
					}
				}
			}
		}

		return results;
	}

	/**
	 * Called to get the default value for a property on a connectordef, passing
	 * in the port where the property is defined.
	 * 
	 * @param property
	 * @param port
	 * @param connectorDeploymentPart
	 * @return
	 */
	public static List<Slot> findDefaultSlot(Property property, Property port,
			Property connectorDeploymentPart) {
		return findDefaultSlot(property, port,
				(Component) connectorDeploymentPart.getType(),
				connectorDeploymentPart);
	}

	/**
	 * Called to get the default value for a struct property on a component.
	 * 
	 * @param property
	 * @param component
	 * @return
	 */
	public static List<Slot> findDefaultSlot(Property property,
			Component component) {
		return findDefaultSlot(property, null, component, null);
	}

	/**
	 * Called to get the default value for a property on a component /
	 * connectordef without need for a port for context.
	 * 
	 * @param property
	 * @param connectorDeploymentPart
	 * @return
	 */
	public static List<Slot> findDefaultSlot(Property property,
			Property connectorDeploymentPart) {
		return findDefaultSlot(property, null, connectorDeploymentPart);
	}

	/**
	 * Find the deployment part that points to a given model element. Takes in a
	 * deployment part for an assembly whose nested parts make up the search
	 * space.
	 * 
	 * @param modelElement
	 * @param asmDeploymentPart
	 * @return
	 */
	public static List<Property> findPartWithPortDP(Property modelElement,
			Property asmDeploymentPart) {

		ArrayList<Property> retVal = new ArrayList<Property>();

		for (Property dp : ZDeploymentUtil.getDescendants(asmDeploymentPart)) {
			if (ZDeploymentUtil.getModelElement(dp) == modelElement) {
				retVal.add(dp);
			}
		}

		return retVal;

	}

	/**
	 * This method, passed a deploymentPart pointing to a dataSpace and a
	 * deploymentPart pointing to a component, returns "true" if the two
	 * deployment parts are located in the same nested assembly.
	 * 
	 * @param dataSpace
	 * @param componentDeploymentPart
	 * @return
	 */
	public static boolean sameLocalAssembly(Property dataSpaceDeploymentPart,
			Property componentDeploymentPart) {

		Property asmDeploymentPart = ZDeploymentUtil
				.getParentPart(dataSpaceDeploymentPart);
		if (ZDeploymentUtil.getParentPart(asmDeploymentPart) == null) {
			return true; // not a nested assembly so ambiguity is not possible.
		}

		for (Property dp : ZDeploymentUtil.getDescendants(asmDeploymentPart)) {
			if (dp == componentDeploymentPart) {
				return true; // same local assembly
			}
		}

		return false;
	}

	/**
	 * Returns whether the passed in component is managed by a home.
	 * 
	 * @param comp
	 * @return
	 */
	public static EObject getHome(Component comp) {

		for (Setting s : UML2Util.getInverseReferences(comp)) {
			if (s.getEObject() != null
					&& ZDLUtil.isZDLConcept(s.getEObject(), CCMNames.MANAGES)) {
				return (EObject) ZDLUtil.getValue(s.getEObject(),
						CCMNames.MANAGES, CCMNames.MANAGES__HOME);
			}
		}
		return null;
	}
	
	public static Property getPerPortDP(Property part, Property dataSpace,
			Component deployment) {
		if (ZDLUtil.isZDLConcept(part, ZMLMMNames.DEPLOYMENT_PART)
				&& ZDLUtil.isZDLConcept(dataSpace, IDL3PlusNames.DATA_SPACE)) {
			Property ccmPart = (Property) ZDLUtil.getValue(part,
					ZMLMMNames.DEPLOYMENT_PART,
					ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
			if (ZDLUtil.isZDLConcept(ccmPart, CCMNames.CCMPART)) {
				@SuppressWarnings("unchecked")
				List<EObject> nestedParts = (List<EObject>) ZDLUtil.getValue(
						part, ZMLMMNames.DEPLOYMENT_PART,
						ZMLMMNames.DEPLOYMENT_PART__NESTED_PART);
				for (EObject nestedPart : nestedParts) {
					Port port = (Port) ZDLUtil.getValue(nestedPart,
							ZMLMMNames.DEPLOYMENT_PART,
							ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
					if (dataSpace == IDL3PlusUtil.getDataSpaceFromPerPort(port,
							ccmPart)) {
						return (Property) nestedPart;
					}
				}
			}
		}
		return null;
	}
}
