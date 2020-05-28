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
package com.zeligsoft.domain.omg.ccm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

import com.zeligsoft.base.util.BaseUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class CCMUtil {

	public static final String DEFAULT_PROPERTY_INSTANCE_NAME = "_defaultInstance"; //$NON-NLS-1$

	/**
	 * Given an instance specification and a property, recursively find the slot
	 * whose defining feature is the property. The recursive call's purpose is
	 * to find slots for struct fields, etc.
	 * 
	 * @param instance
	 * @param property
	 * @param definingFeaturesForAncestorSlots
	 *            defining features of ancestor slots of the given property.
	 * 
	 * @return
	 */
	public static Slot getInstanceSlotForProperty(
			InstanceSpecification instance, Property property,
			List<EObject> definingFeaturesForAncestorSlots) {
		Map<NamedElement, Slot> slotMap = getFeatureSlotMap(instance);
		Slot slot = slotMap.get(property);

		if (slot != null
				&& (CORBADomainNames.CORBASTRUCT__MEMBERS.equals(property
						.getName())
						|| "member".equals(property.getName()) //$NON-NLS-1$
						|| ZDLUtil.isZDLConcept(slot.getDefiningFeature(),
								CORBADomainNames.CORBAATTRIBUTE)
						|| ZDLUtil.isZDLConcept(slot.getDefiningFeature(),
								CORBADomainNames.CORBAFIELD)
						|| ZDLUtil.isZDLConcept(slot.getDefiningFeature(),
								CCMNames.SATISFIER_PROPERTY) || ZDLUtil
						.isZDLConcept(slot.getDefiningFeature(),
								CCMNames.PROPERTY))) {
			Type type = property.getType();
			if (type == null) {
				return null;
			}

			if (!slot.getValues().isEmpty()) {
				return slot;
			}
		} else {
			if (!ZDLUtil.isZDLConcept(property.eContainer(),
					CORBADomainNames.CORBASTRUCT)
					&& !ZDLUtil.isZDLConcept(property.eContainer(),
							CORBADomainNames.CORBASEQUENCE)
					&& !ZDLUtil.isZDLConcept(property.eContainer(),
							CCMNames.RESOURCE)
					&& !ZDLUtil.isZDLConcept(property.eContainer(),
							ZMLMMNames.PORT_TYPE)
					&& !ZDLUtil.isZDLConcept(property.eContainer(),
							CORBADomainNames.CORBAARRAY)) {
				return null;
			}
			Iterator<Slot> itor = slotMap.values().iterator();
			while (itor.hasNext()) {
				Slot aSlot = itor.next();
				Type type = aSlot.getDefiningFeature().getType();
				if (ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBASTRUCT)
						|| ZDLUtil.isZDLConcept(type,
								CORBADomainNames.CORBASEQUENCE)
						|| ZDLUtil.isZDLConcept(type, CCMNames.RESOURCE)
						|| ZDLUtil.isZDLConcept(type, ZMLMMNames.PORT_TYPE)
						|| ZDLUtil.isZDLConcept(type,
								CORBADomainNames.CORBAARRAY)) {
					if (definingFeaturesForAncestorSlots == null
							|| definingFeaturesForAncestorSlots.isEmpty()) {
						continue;
					}
					if (aSlot.getDefiningFeature() != definingFeaturesForAncestorSlots
							.get(definingFeaturesForAncestorSlots.size() - 1)) {
						continue;
					}
					definingFeaturesForAncestorSlots
							.remove(definingFeaturesForAncestorSlots.size() - 1);
					if (aSlot.getValues().isEmpty()) {
						return null;
					}
					ValueSpecification value = aSlot.getValues().get(0);
					if (!definingFeaturesForAncestorSlots.isEmpty()
							&& definingFeaturesForAncestorSlots
									.get(definingFeaturesForAncestorSlots
											.size() - 1) instanceof InstanceValue) {
						ValueSpecification tempVal = (ValueSpecification) definingFeaturesForAncestorSlots
								.remove(definingFeaturesForAncestorSlots.size() - 1);
						int index = 0;
						for (ValueSpecification aVal : ((Slot) tempVal
								.eContainer()).getValues()) {
							if (aVal == tempVal) {
								break;
							}
							index++;
						}
						if (index < aSlot.getValues().size()) {
							value = aSlot.getValues().get(index);
						} else {
							value = null;
						}
					}
					if (value instanceof InstanceValue) {
						InstanceSpecification propertyInstance = ((InstanceValue) value)
								.getInstance();
						if (propertyInstance != null) {
							return getInstanceSlotForProperty(propertyInstance,
									property, definingFeaturesForAncestorSlots);
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Get the value of the given entry from the instance. The entry should be
	 * either Property or InstanceValue
	 * 
	 * @param instance
	 * @param entry
	 * @param definingFeaturesForAncestorSlots
	 * @return
	 */
	public static String getInstanceValueForEntry(
			InstanceSpecification instance, EObject entry,
			List<EObject> definingFeaturesForAncestorSlots) {

		if (entry instanceof InstanceValue) {
			Property memberProperty = (Property) ((Slot) entry.eContainer())
					.getDefiningFeature();
			Slot aSlot = getInstanceSlotForProperty(instance, memberProperty,
					definingFeaturesForAncestorSlots);

			if (aSlot == null || aSlot.getValues().isEmpty()) {
				return null;
			}
			// Remove members from the ancestor slot list
			definingFeaturesForAncestorSlots
					.remove(definingFeaturesForAncestorSlots.size() - 1);

			ValueSpecification value = aSlot.getValues().get(0);
			if (!definingFeaturesForAncestorSlots.isEmpty()
					&& definingFeaturesForAncestorSlots
							.get(definingFeaturesForAncestorSlots.size() - 1) instanceof InstanceValue) {
				ValueSpecification tempVal = (ValueSpecification) definingFeaturesForAncestorSlots
						.remove(definingFeaturesForAncestorSlots.size() - 1);
				int index = 0;
				for (ValueSpecification aVal : ((Slot) tempVal.eContainer())
						.getValues()) {
					if (aVal == tempVal) {
						break;
					}
					index++;
				}
				if (index < aSlot.getValues().size()) {
					value = aSlot.getValues().get(index);
				} else {
					value = null;
				}
				return getValueFromValueSpecification(value);
			}
		} else if (entry instanceof Property) {
			Slot aSlot = getInstanceSlotForProperty(instance, (Property) entry,
					definingFeaturesForAncestorSlots);
			if (aSlot != null) {
				return getValueFromValueSpecification(aSlot.getValues().get(0));
			}
		}
		return null;
	}

	/**
	 * Creates map where key is the defining feature of the slot and value is
	 * the slot itself. We should move it to BaseUtil
	 * 
	 * @return
	 */
	public static Map<NamedElement, Slot> getFeatureSlotMap(
			InstanceSpecification instance) {

		Map<NamedElement, Slot> map = new HashMap<NamedElement, Slot>();
		if (instance != null) {
			Iterator<Slot> itor = instance.getSlots().iterator();
			while (itor.hasNext()) {
				Slot slot = itor.next();
				if (slot.getDefiningFeature() != null) {
					map.put(slot.getDefiningFeature(), slot);
				}
			}
		}
		return map;
	}

	public static List<EObject> getMonolithicImplementationsForComponent(
			EObject component) {

		List<EObject> retVal = new ArrayList<EObject>();

		if (ZDLUtil.isZDLConcept(component, CCMNames.CCMCOMPONENT)) {
			for (Setting s : UML2Util.getInverseReferences(component)) {
				if (s.getEObject() instanceof Generalization) {
					if (ZDLUtil.isZDLConcept(s.getEObject().eContainer(),
							CCMNames.MONOLITHIC_IMPLEMENTATION)) {
						retVal.add(s.getEObject().eContainer());
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * Queries the string value of value specification
	 * 
	 * @param value
	 * @return string value or null if no specification exist
	 */
	public static String getValueFromValueSpecification(ValueSpecification value) {
		ValueSpecification realValue = value;
		if (value instanceof InstanceValue) {
			InstanceSpecification instance = ((InstanceValue) value)
					.getInstance();
			realValue = instance.getSpecification();
		}
		if (realValue == null) {
			return null;
		}
		if (realValue instanceof LiteralString) {
			return ((LiteralString) realValue).getValue();
		} else if (realValue instanceof OpaqueExpression) {
			return ((OpaqueExpression) realValue).getBodies().get(0);
		}
		return null;
	}

	/**
	 * Find member attribute from DataType
	 * 
	 * @param type
	 * @return property named members
	 */
	public static Property getMembersAttribute(DataType type) {
		Property member = type.getOwnedAttribute(
				CORBADomainNames.CORBASTRUCT__MEMBERS, null);
		if (member == null) {
			member = type.getOwnedAttribute("member", null); //$NON-NLS-1$
		}
		return member;
	}

	/**
	 * Queries if the given component is an assembly.
	 * 
	 * @param component
	 * @return
	 */
	public static boolean isAssemblyComponent(EObject component) {

		if (!ZDLUtil.isZDLConcept(component, CCMNames.CCMCOMPONENT)) {
			return false;
		}
		for (Setting s : UML2Util.getInverseReferences(component)) {
			EObject ref = s.getEObject();
			if (ref instanceof Generalization) {
				if (!ZDLUtil.isZDLConcept(ref.eContainer(),
						CCMNames.ASSEMBLY_IMPLEMENTATION)) {
					continue;
				}
				if (((Generalization) ref).getGeneral() == component) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Queries if the given part is an assembly part
	 * 
	 * @param part
	 * @return
	 */
	public static boolean isAssemblyPart(EObject part) {
		if (!ZDLUtil.isZDLConcept(part, CCMNames.CCMPART)) {
			return false;
		}
		EObject type = ZDLUtil.getEValue(part, CCMNames.CCMPART,
				ZMLMMNames.PART__DEFINITION);
		if (type != null && isAssemblyComponent(type)) {
			return true;
		}
		return false;
	}

	/**
	 * Queries the boolean value of ZCX annotation detail
	 * 
	 * @param context
	 * @param detail
	 * @param defaultValue
	 * @return
	 */
	public static String getZCXAnnotationDetail(Element context, String detail,
			String defaultValue) {
		return BaseUtil.getZCXAnnotationDetail(context, detail, defaultValue);
	}

	/**
	 * puts the boolean value of ZCX annotation detail
	 * 
	 * @param context
	 * @param detail
	 * @param value
	 */
	public static void putZCXAnnotationDetail(Element context, String detail,
			String value) {
		BaseUtil.putZCXAnnotationDetail(context, detail, value);
	}

	/**
	 * returns assembly if a component has assembly else returns null
	 * 
	 * @param component
	 * @return assembly
	 */
	public static EObject getAssemblyFromComponent(EObject component) {

		if (!ZDLUtil.isZDLConcept(component, CCMNames.CCMCOMPONENT)) {
			return null;
		}
		for (Setting s : UML2Util.getInverseReferences(component)) {
			EObject ref = s.getEObject();
			if (ref instanceof Generalization) {
				if (!ZDLUtil.isZDLConcept(ref.eContainer(),
						CCMNames.ASSEMBLY_IMPLEMENTATION)) {
					continue;
				}
				if (((Generalization) ref).getGeneral() == component) {
					return ref.eContainer();
				}
			}
		}
		return null;
	}
}
