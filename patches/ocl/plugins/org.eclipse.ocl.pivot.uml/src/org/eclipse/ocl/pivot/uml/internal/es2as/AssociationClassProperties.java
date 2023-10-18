/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.es2as;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * AssociationClassProperties manages the AS properties for an AS AssociationClass, supporting random access
 * by UML source/target property in order to workaround OMG BUG UMLR-677 whereby association redifinitions do
 * not respect memberEnds ordering.
 */
class AssociationClassProperties
{
	private final @NonNull List<org.eclipse.uml2.uml.@NonNull Property> umlMemberEnds;
	private final Property[][] properties;		// [0][x] is from AC, [x][0] is to AC, [0][0] is null, 

	public AssociationClassProperties(@NonNull List<org.eclipse.uml2.uml.@NonNull Property> umlMemberEnds) {
		this.umlMemberEnds = umlMemberEnds;
		int size = umlMemberEnds.size();
		properties = new Property[size+1][size];
		for (int i = 0; i < size; i++) {
			properties[i] = new Property[size];
		}
	}

	public Property get(org.eclipse.uml2.uml.@Nullable Property umlFromProperty, org.eclipse.uml2.uml.@Nullable Property umlToProperty) {
		int fromIndex = getIndex(umlFromProperty);
		int toIndex = getIndex(umlToProperty);
		assert fromIndex != toIndex;
		return properties[fromIndex][toIndex > fromIndex ? toIndex-1 : toIndex];
	}

	private int getIndex(org.eclipse.uml2.uml.@Nullable Property umlProperty) {
		if (umlProperty == null) {
			return 0;
		}
		int index = umlMemberEnds.indexOf(umlProperty);
/*		if (index < 0) {
			for (org.eclipse.uml2.uml.Property umlRedefinedProperty : umlProperty.getRedefinedProperties()) {
				index = umlMemberEnds.indexOf(umlRedefinedProperty);
				if (index >= 0) {
					break;
				}
			}
			if (index < 0) {
				for (org.eclipse.uml2.uml.Property umlSubsettedProperty : umlProperty.getSubsettedProperties()) {
					index = umlMemberEnds.indexOf(umlSubsettedProperty);
					if (index >= 0) {
						break;
					}
				}
				if (index < 0) {
					int searchIndex = 0;
					String name = umlProperty.getName();
					for (org.eclipse.uml2.uml.Property umlNamedProperty : umlMemberEnds) {
						if (ClassUtil.safeEquals(name, umlNamedProperty.getName())) {
							break;
						}
						searchIndex++;
					}
					if (searchIndex < umlMemberEnds.size()) {
						index = searchIndex;
					}
				}
			}
		} */
		assert index >= 0;
		return index + 1;
	}

	/**
	 * Workaround UMLR-677 so that we can accommodate mismatching memberEnds.
	 */
	public @NonNull Map<org.eclipse.uml2.uml.@NonNull Property, org.eclipse.uml2.uml.@NonNull Property> getPropertyToRedefinedPropertyMapping(@NonNull AssociationClassProperties asRedefinedAssociationClassProperties) {
		List<org.eclipse.uml2.uml.@NonNull Property> redefiningMemberEnds = new ArrayList<org.eclipse.uml2.uml.@NonNull Property>(umlMemberEnds);
		List<org.eclipse.uml2.uml.@NonNull Property> redefinedMemberEnds = new ArrayList<org.eclipse.uml2.uml.@NonNull Property>(asRedefinedAssociationClassProperties.umlMemberEnds);
		Map<org.eclipse.uml2.uml.@NonNull Property, org.eclipse.uml2.uml.@NonNull Property> propertyToRedefinedPropertyMapping = new HashMap<org.eclipse.uml2.uml.@NonNull Property, org.eclipse.uml2.uml.@NonNull Property>();
		//
		//	Align explicit redefinitions
		//
		for (org.eclipse.uml2.uml.Property redefiningProperty : redefiningMemberEnds) {
			for (org.eclipse.uml2.uml.Property redefinedProperty : redefiningProperty.getRedefinedProperties()) {
				if ((redefinedProperty != null) && redefinedMemberEnds.contains(redefinedProperty)) {
					org.eclipse.uml2.uml.Property oldProperty = propertyToRedefinedPropertyMapping.put(redefiningProperty, redefinedProperty);
					assert oldProperty == null;
					break;
				}
			}
		}
		redefiningMemberEnds.removeAll(propertyToRedefinedPropertyMapping.keySet());
		redefinedMemberEnds.removeAll(propertyToRedefinedPropertyMapping.values());
		if (redefiningMemberEnds.size() > 1) {
			//
			//	Align subsetted properties
			//
			for (org.eclipse.uml2.uml.Property redefiningProperty : redefiningMemberEnds) {
				for (org.eclipse.uml2.uml.Property subsettedProperty : redefiningProperty.getSubsettedProperties()) {
					if ((subsettedProperty != null) && redefinedMemberEnds.contains(subsettedProperty)) {
						org.eclipse.uml2.uml.Property oldProperty = propertyToRedefinedPropertyMapping.put(redefiningProperty, subsettedProperty);
						assert oldProperty == null;
						break;
					}
				}
			}
			redefiningMemberEnds.removeAll(propertyToRedefinedPropertyMapping.keySet());
			redefinedMemberEnds.removeAll(propertyToRedefinedPropertyMapping.values());
			if (redefiningMemberEnds.size() > 1) {
				//
				//	Align same-named properties
				//
				for (org.eclipse.uml2.uml.Property redefiningProperty : redefiningMemberEnds) {
					String name = redefiningProperty.getName();
					for (org.eclipse.uml2.uml.Property redefinedProperty : redefinedMemberEnds) {
						if (ClassUtil.safeEquals(name, redefinedProperty.getName())) {
							org.eclipse.uml2.uml.Property oldProperty = propertyToRedefinedPropertyMapping.put(redefiningProperty, redefinedProperty);
							assert oldProperty == null;
							break;
						}
					}
				}
				redefiningMemberEnds.removeAll(propertyToRedefinedPropertyMapping.keySet());
				redefinedMemberEnds.removeAll(propertyToRedefinedPropertyMapping.values());
			}
		}
		if ((redefiningMemberEnds.size() == 1) && (redefinedMemberEnds.size() == 1)) {
			//
			//	Align a single last property
			//
			org.eclipse.uml2.uml.Property oldProperty = propertyToRedefinedPropertyMapping.put(redefiningMemberEnds.remove(0), redefinedMemberEnds.remove(0));
			assert oldProperty == null;
		}
		assert redefiningMemberEnds.size() == 0;
/*		Debug for UMLR-677
		for (org.eclipse.uml2.uml.Property redefiningProperty : propertyToRedefinedPropertyMapping.keySet()) {
			org.eclipse.uml2.uml.Property redefinedProperty = propertyToRedefinedPropertyMapping.get(redefiningProperty);
			int iRedefining = umlMemberEnds.indexOf(redefiningProperty);
			int iRedefined = asRedefinedAssociationClassProperties.umlMemberEnds.indexOf(redefinedProperty);
			assert (iRedefining >= 0) && (iRedefined >= 0);
			if (iRedefining != iRedefined) {
				System.out.println("Inconsistent " + redefiningProperty.getAssociation().getName());
			}
		} */
		return propertyToRedefinedPropertyMapping;
	}

	public void put(org.eclipse.uml2.uml.@Nullable Property umlFromProperty, org.eclipse.uml2.uml.@Nullable Property umlToProperty, @NonNull Property asFrom2ToProperty) {
		int fromIndex = getIndex(umlFromProperty);
		int toIndex = getIndex(umlToProperty);
		assert fromIndex != toIndex;
		properties[fromIndex][toIndex > fromIndex ? toIndex-1 : toIndex] = asFrom2ToProperty;
	}
}
