/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) - vincent.lorenzo@cea.fr - Initial API and implementation
 *   Vincent Lorenzo (CEA LIST) - bug 528097
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.types.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.types.MetamodelTypeConfiguration;
import org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This class provides useful method to manipulate UML element which can be shown as Relationship.
 * 
 * @since 3.0
 *
 */
public class UMLRelationshipHelper {

	/**
	 * the managed relationship represented by their EClass
	 */
	private List<EClass> managedEClasses;

	/**
	 * 
	 * Constructor.
	 *
	 */
	public UMLRelationshipHelper() {
		// public to be extensible if required
		List<EClass> managedEClasses = new ArrayList<EClass>();
		managedEClasses.add(UMLPackage.eINSTANCE.getAbstraction());
		managedEClasses.add(UMLPackage.eINSTANCE.getDependency());
		this.managedEClasses = Collections.unmodifiableList(managedEClasses);
	}

	/**
	 * 
	 * @return
	 * 		the list of managed relationship
	 */
	public List<EClass> getManagedEClass() {
		return this.managedEClasses;
	}

	/**
	 * 
	 * @param relationshipEClass
	 *            an EClass representing a relationship
	 * @return
	 *         <ul>
	 *         <li><code>true</code> when the relationship is managed by this class AND when the relationship can have more than 2 ends</li>
	 *         <li><code>false</code> otherwise</li>
	 *         </ul>
	 */
	public boolean canHaveMoreThan2Ends(final EClass relationshipEClass) {
		if (UMLPackage.eINSTANCE.getAbstraction() == relationshipEClass) {
			return true;
		}
		if (UMLPackage.eINSTANCE.getDependency() == relationshipEClass) {
			return true;
		}

		return false;
	}


	/**
	 * 
	 * @param relationshipEClass
	 *            an EClass representing a relationship
	 * @return
	 *         <ul>
	 *         <li><code>true</code> when the relationship is managed by this class AND when the relationship is a directed relationship</li>
	 *         <li><code>false</code> otherwise</li>
	 *         </ul>
	 */
	public boolean isDirectedRelationship(final EClass relationshipEClass) {
		if (UMLPackage.eINSTANCE.getAbstraction() == relationshipEClass) {
			return true;
		}
		if (UMLPackage.eINSTANCE.getDependency() == relationshipEClass) {
			return true;
		}
		return false;
	}


	/**
	 * 
	 * @param relationshipEClass
	 *            an EClass representing a relationship
	 * @return
	 * 		the feature used as source or <code>null</code> when the relationship is not managed
	 */
	public EStructuralFeature getRelationshipSourceFeature(final EClass relationshipEClass) {
		if (UMLPackage.eINSTANCE.getAbstraction() == relationshipEClass) {
			return UMLPackage.eINSTANCE.getDependency_Client();// an abstraction is a Dependency
		}
		if (UMLPackage.eINSTANCE.getDependency() == relationshipEClass) {
			return UMLPackage.eINSTANCE.getDependency_Client();
		}
		return null;
	}

	/**
	 * 
	 * @param relationshipEClass
	 *            an EClass representing a relationship
	 * @return
	 * 		the feature used as target or <code>null</code> when the relationship is not managed
	 */
	public EStructuralFeature getRelationshipTargetFeature(final EClass relationshipEClass) {
		if (UMLPackage.eINSTANCE.getAbstraction() == relationshipEClass) {
			return UMLPackage.eINSTANCE.getDependency_Supplier();// an abstraction is a Dependency
		}
		if (UMLPackage.eINSTANCE.getDependency() == relationshipEClass) {
			return UMLPackage.eINSTANCE.getDependency_Supplier();
		}
		return null;
	}


	/**
	 * 
	 * @param relationship
	 *            a relationship
	 * @return
	 * 		the sources of this relationship or an empty list when the kind of relationship is not managed
	 */
	public Collection<? extends Element> getSources(final Element relationship) {
		if (relationship instanceof Dependency) {// works for Abstraction too
			return ((Dependency) relationship).getClients();
		}
		return Collections.emptyList();
	}

	/**
	 * 
	 * @param relationship
	 *            a relationship
	 * @return
	 * 		the targets of this relationship or or an empty list when the kind of relationship is not managed
	 */
	public Collection<? extends Element> getTargets(final Element relationship) {
		if (relationship instanceof Dependency) {// works for Abstraction too
			return ((Dependency) relationship).getSuppliers();
		}
		return Collections.emptyList();
	}


	/**
	 * @param elementTypeConfiguration
	 *            an element type configuration
	 * @param source
	 *            the source element for the relationship
	 * @param target
	 *            the target element for the relationship
	 * @param editorContext
	 *            the context of the current editor when available
	 * @return
	 * 		the best owner for the relationship to create or <code>null</code> when the kind of relationship is not managed
	 */
	public Element getBestOwner(final MetamodelTypeConfiguration elementTypeConfiguration, final Element source, final Element target, final Element editorContext) {
		final EClass relationshipToCreate = elementTypeConfiguration.getEClass();
		if (UMLPackage.eINSTANCE.getAbstraction() == relationshipToCreate
				|| UMLPackage.eINSTANCE.getDependency() == relationshipToCreate) {
			if (source instanceof Package || null == source.getOwner()) {
				return source;
			}
			if (null != source.getNearestPackage()) {
				return source.getNearestPackage();
			}
			return source.getOwner();//not sure it is currently use...
		}
		return null;
	}

	/**
	 * @param elementTypeConfiguration
	 *            an element type configuration
	 * @param source
	 *            the source element for the relationship
	 * @param target
	 *            the target element for the relationship
	 * @param editorContext
	 *            the context of the current editor when available
	 * @return
	 * 		the best owner for the relationship to create or <code>null</code> when the kind of relationship is not managed
	 */
	public Element getBestOwner(final ElementTypeConfiguration elementTypeConfiguration, final Element source, final Element target, final Element editorContext) {
		if (elementTypeConfiguration instanceof MetamodelTypeConfiguration) {
			return getBestOwner((MetamodelTypeConfiguration) elementTypeConfiguration, source, target, editorContext);
		}
		if (elementTypeConfiguration instanceof SpecializationTypeConfiguration) {
			return getBestOwner((SpecializationTypeConfiguration) elementTypeConfiguration, source, target, editorContext);

		}
		return null;
	}

	/**
	 * @param elementTypeConfiguration
	 *            an element type configuration
	 * @param source
	 *            the source element for the relationship
	 * @param target
	 *            the target element for the relationship
	 * @param editorContext
	 *            the context of the current editor when available
	 * @return
	 * 		the best owner for the relationship to create or <code>null</code> when the kind of relationship is not managed
	 */
	public Element getBestOwner(final SpecializationTypeConfiguration elementTypeConfiguration, final Element source, final Element target, final Element editorContext) {
		return 1 == elementTypeConfiguration.getSpecializedTypes().size() ? getBestOwner(elementTypeConfiguration.getSpecializedTypes().get(0), source, target, editorContext) : null;
	}

	/**
	 * 
	 * @param relationship
	 *            a relationhip
	 * @return
	 * 		the number of ends for the current relationship or 0 when the relationship is not managed
	 */
	public int getNumberOfEnds(final Element relationship) {
		return getSources(relationship).size() + getTargets(relationship).size();
	}
}
