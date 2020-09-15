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
package com.zeligsoft.domain.omg.ccm.descriptorgenerator.utils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtend.util.stdlib.ExtIssueReporter;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;

/**
 * @author Laura Li
 * 
 */
public class CDPXtendUtils {

	private CDPXtendUtils() {
		// no state
	}

	public static void debug(Object obj) {
		System.out.println("****** DEBUG ******");
		System.out.println(obj);
		System.out.println("****** END DEBUG ******");
	}

	public static void printTime(String id) {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		System.out.println(id + ": " + t);
	}

	public static List<PackageableElement> packagedElement(NamedElement element) {
		if (element instanceof org.eclipse.uml2.uml.Package) {
			return ((org.eclipse.uml2.uml.Package) element)
					.getPackagedElements();
		}

		return Collections.emptyList();
	}

	public static Type getCCMPartType(Property comp) {

		return comp.getType();
	}

	public static void JavaSetAttribute(EObject e, String attributeName,
			String attributeValue) {
		for (EAttribute eattr : e.eClass().getEAllAttributes()) {
			if (eattr.getName().equals(attributeName)) {
				e.eSet(eattr, attributeValue);
			}
		}
	}

	public static Object JavaGetAttribute(EObject e, String attributeName) {
		if (e != null) {
			for (EAttribute eattr : e.eClass().getEAllAttributes()) {
				if (eattr.getName().equals(attributeName)) {
					return e.eGet(eattr);
				}
			}
		}
		return null;
	}

	public static String getObjectNameWithId(EObject e, String id) {
		if (e != null) {
			while (e.eContainer() != null) {
				e = e.eContainer();
			}

			// go through all the children and see if we can find it
			TreeIterator<EObject> tIterator = e.eAllContents();
			EObject node = null;
			while (tIterator.hasNext()) {
				node = (EObject) tIterator.next();
				String nodeId = (String) JavaGetAttribute(node, "id");
				if (nodeId != null && nodeId.equals(id)) {
					Object result = JavaGetAttribute(node, "name");
					return result.toString();
				}
			}
		}
		return "";
	}

	public static String getUUID() {
		return "_" + UUID.randomUUID().toString();
	}

	public static String getScopedName(NamedElement element) {
		return getScopedName(element, false);
	}

	public static String getCorbaScopedName(NamedElement element) {
		if (ZDLUtil.isZDLConcept(element, CXDomainNames.CXNAMED_ELEMENT)
				|| ZDLUtil.isZDLConcept(element,
						CCMNames.MONOLITHIC_IMPLEMENTATION)) {
			return getScopedName(element, true).replaceAll("\\.", "_");
		} else {
			return getScopedName(element, false).replaceAll("\\.", "_");
		}
	}

	public static String getModifiedCorbaScopedName(NamedElement element, String prefix) {
		final boolean restrictToCX = ZDLUtil.isZDLConcept(element, CXDomainNames.CXNAMED_ELEMENT)
				|| ZDLUtil.isZDLConcept(element, CCMNames.MONOLITHIC_IMPLEMENTATION);
		
		final String parentName = element.getOwner() instanceof NamedElement ?
				getScopedName((NamedElement)(element.getOwner()), restrictToCX).replaceAll("\\.", "_")
				: "";
		final StringBuilder buffer = new StringBuilder();
		if(!parentName.isEmpty()) {
			buffer.append(parentName).append('_');
		}
		buffer.append(prefix).append(element.getName());
		return buffer.toString();
	}

	private static String getScopedName(NamedElement element,
			boolean restrictToCX) {

		StringBuilder retVal = new StringBuilder();

		NamedElement iterator = element;

		while (iterator != null) {

			if (restrictToCX == false
					|| (restrictToCX == true
							&& (ZDLUtil.isZDLConcept(iterator,
									CXDomainNames.CXNAMED_ELEMENT)) || ZDLUtil
							.isZDLConcept(iterator,
									CCMNames.MONOLITHIC_IMPLEMENTATION))) {
				if (retVal.length() > 0) {
					retVal.insert(0, ".");
				}
				retVal.insert(0, iterator.getName());
			}

			if (iterator.getOwner() instanceof NamedElement) {
				iterator = (NamedElement) iterator.getOwner();
			} else {
				return retVal.toString();
			}

		}

		return retVal.toString();
	}

	public static String getScopedNameForDeploymentPart(Property part) {
		return getScopedNameForDeploymentPart(part, ".");
	}

	public static String getScopedNameForDeploymentPart(Property part,
			String delimiter) {
		String retVal = ZDeploymentUtil.getQualifiedName(part);

		retVal = retVal.replaceAll(" :: ", delimiter);

		return retVal;
	}

	public static String literalName(EnumerationLiteral literal) {
		return literal.getName();
	}

	public static String literalNameHelper(Object literal) {
		return literal.toString();
	}

	public static float getFloatValue(String value) {
		return Float.parseFloat(value);
	}

	public static long getLongValue(String value) {
		return Long.parseLong(value);
	}

	public static int getIntValue(String value) {
		return Integer.parseInt(value);
	}

	public static short getShortValue(String value) {
		return Short.parseShort(value);
	}

	public static double getDoubleValue(String value) {
		return Double.parseDouble(value);
	}

	/**
	 * 
	 * Takes a comma separated list of values and returns a list containing the
	 * values.
	 * 
	 * @param valueList
	 *            , a list of string values separated by commas.
	 * @param o
	 *            , a dummy object used to prevent caching by the oAW dispatch
	 *            mechanism.
	 * 
	 * @return
	 */
	public static List<String> getSequenceValues(String valueList, Object o) {

		ArrayList<String> retVal = new ArrayList<String>();

		String[] fragments = valueList.split(",");

		for (String fragment : fragments) {
			retVal.add(fragment.replaceAll("\"", ""));
		}

		return retVal;

	}

	public static String xmlSanitize(String value) {
		return (value == null) ? "" : value.replace("&", "zcxamp;")
				.replace("<", "zcxlt;").replace(">", "zcxgt;")
				.replace("'", "zcxapos;").replace("\"", "zcxquot;");
	}

	public static String replaceLast(String string, String replace,
			String replaceWith) {
		int index = string.lastIndexOf(replace);
		return string.substring(0, index) + replaceWith
				+ string.substring(index + replace.length(), string.length());
	}

	public static void reportWarning(String string) {
		ExtIssueReporter.reportWarning(string);
	}

	private static Set<String> nameSet = new HashSet<String>();

	public static void resetNameSet() {
		nameSet.clear();
	}

	public static void checkName(String value) {
		if (nameSet.contains(value)) {
			reportWarning("Duplicate name: " + value);
		} else {
			nameSet.add(value);
		}
	}

	/**
	 * Find slot for given property from the default instance value tree
	 * 
	 * @param defaultRootSlots
	 * @param property
	 * @param ancesterSlotFeatures
	 * @return
	 */
	public static Slot getDefaultSlotForProperty(List<Slot> defaultRootSlots,
			Property property, final List<EObject> ancesterSlotFeatures) {
		Slot result = null;
		List<EObject> newList = new ArrayList<EObject>();
		newList.addAll(ancesterSlotFeatures);
		Collections.reverse(newList);
		for (Slot rootSlot : defaultRootSlots) {
			result = CCMUtil.getInstanceSlotForProperty(
					(InstanceSpecification) rootSlot.eContainer(), property,
					newList);
			if (result != null) {
				return result;
			}
		}
		return result;
	}

	/**
	 * Queries the default value for the given property from the default
	 * instance value tree
	 * 
	 * @param defaultRootSlots
	 * @param property
	 * @param ancesterSlotFeatures
	 * @return
	 */
	public static String getDefaultValueForProperty(
			List<Slot> defaultRootSlots, Object property,
			final List<EObject> ancesterSlotFeatures) {
		if (property instanceof EObject) {
			List<EObject> newList = new ArrayList<EObject>();
			newList.addAll(ancesterSlotFeatures);
			Collections.reverse(newList);
			for (Slot rootSlot : defaultRootSlots) {
				String result = CCMUtil.getInstanceValueForEntry(
						(InstanceSpecification) rootSlot.eContainer(),
						(EObject) property, newList);
				if (!UML2Util.isEmpty(result)) {
					return result;
				}
			}
		}
		return UML2Util.EMPTY_STRING;
	}
}