/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.databinding;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 *
 * This class provides methods to set the owner for UML Association
 *
 */
public class OwnedAttributeHelper {

	/**
	 *
	 * @param type
	 *            a UML type
	 * @return
	 * 		the owned attribute feature for the given type, or <code>null</code> when not found
	 * @since 4.1
	 */
	public static final EStructuralFeature getOwnedAttributeFeatureForType(final Type type) {
		if (null == type) {
			Activator.log.warn("The type is null!"); //$NON-NLS-1$
		}

		if (type instanceof StructuredClassifier) {
			return UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute();
		}
		if (type instanceof Interface) {
			return UMLPackage.eINSTANCE.getInterface_OwnedAttribute();
		}
		if (type instanceof DataType) {
			return UMLPackage.eINSTANCE.getDataType_OwnedAttribute();
		}
		if (type instanceof Artifact) {
			return UMLPackage.eINSTANCE.getArtifact_OwnedAttribute();
		}
		if (type instanceof Signal) {
			return UMLPackage.eINSTANCE.getSignal_OwnedAttribute();
		}


		// Unknown type : we try to find the feature reflexively
		final String eClassName = type.eClass().getName();
		Activator.log.warn(String.format("Unknown type : %s", eClassName)); //$NON-NLS-1$
		EStructuralFeature feature = type.eClass().getEStructuralFeature("ownedAttribute"); //$NON-NLS-1$
		if (feature == null) {
			Activator.log.warn(String.format("Cannot find a valid feature for type %s.", eClassName)); //$NON-NLS-1$
		}
		return feature;
	}

	/**
	 *
	 * @param type
	 *            a UML type
	 * @return
	 * 		the owned attribute feature for the given type, or <code>null</code> when not found
	 *
	 * @deprecated since 4.1
	 *             use org.eclipse.papyrus.uml.tools.databinding.OwnedAttributeHelper.getOwnedAttributeFeatureForType(Type) API instead
	 *             This method will be removed in Papyrus 5.0, see bug 540875
	 */
	@Deprecated
	public static EStructuralFeature getFeatureForType(Type type) {
		return getOwnedAttributeFeatureForType(type);
	}

	/**
	 *
	 * @param association
	 *            an association
	 * @param memberEnd
	 *            the member end of the association
	 * @return
	 * 		the command to use to set the owner of the association
	 */
	public static ICommand getSetTypeOwnerForAssociationAttributeCommand(Association association, Property memberEnd) {
		ICommand command = null;
		Type ownerType;
		List<Type> ownerList = association.getEndTypes();

		if (ownerList.get(0).equals(memberEnd.getType()) && ownerList.size() > 1) {
			ownerType = ownerList.get(1);
		} else {
			ownerType = ownerList.get(0);
		}

		EStructuralFeature ownedAttributeFeature = getOwnedAttributeFeatureForType(ownerType);
		if (ownedAttributeFeature != null) {

			List<Property> attributeList = new ArrayList<>();
			attributeList.addAll((EList<Property>) ownerType.eGet(ownedAttributeFeature));
			attributeList.add(memberEnd);

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(ownerType);
			if (provider != null) {
				SetRequest request = new SetRequest(ownerType, ownedAttributeFeature, memberEnd);

				command = provider.getEditCommand(request);
			}
		}
		return command;
	}
}
