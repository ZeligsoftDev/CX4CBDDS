/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.profile.definition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <p>
 * this class is used to manage the redefinition of profiles:
 * </p>
 * The normal definition in UML is like this:
 * <ul>
 * <li>Stereotype-->Eclass</li>
 * <li>Enumeration-->EEnumeration :local copy
 * <li>Datatype-->EClass</li>
 * <li>Property--> EReference or EAttribute with ref on local copy</li>
 * <li>PrimitiveType-> Edatatype : local copy</li>
 * </ul>
 * In papyrus:
 * <ul>
 * <li>Stereotype-->Eclass
 * <li>Enumeration-->EEnumeration:local copy
 * <li>Datatype-->EClass
 * <li>Property--> EReference or EAttribute with ref on direct definition
 * <li>PrimitiveType-> Edatatype : local copy
 * </ul>
 */
public class ProfileRedefinition {

	/**
	 * This method is used to redefine profile even if it contains subpackages
	 * or subprofiles
	 *
	 * @param thepackage
	 *            the given profile that we want to define
	 * @param definitionAnnotation
	 *            the definition annotation that is used to create the version
	 *            annotation
	 */
	public static void redefineProfile(Package thepackage, PapyrusDefinitionAnnotation definitionAnnotation) {
		// Handle Profile element
		if (thepackage instanceof Profile) {
			Profile profile = (Profile) thepackage;

			// Get profile definition
			EPackage profileDefinition = profile.getDefinition();

			Iterator<EClassifier> definitionClassifiersIterator = profileDefinition.getEClassifiers().iterator();
			while (definitionClassifiersIterator.hasNext()) {
				EClassifier eclassifier = definitionClassifiersIterator.next();
				if (eclassifier instanceof EClass) {
					// Redefine Eclass
					redefineEclass((EClass) eclassifier);
				}
			}

			// Add profile definition annotation
			if (definitionAnnotation != null) {
				profile.getDefinition().getEAnnotations().add(definitionAnnotation.convertToEAnnotation());
			}
		}

		// Explore all nested packages
		Iterator<Package> nestedPackagesIterator = thepackage.getNestedPackages().iterator();
		while (nestedPackagesIterator.hasNext()) {
			Package nextPackage = nestedPackagesIterator.next();
			ProfileRedefinition.redefineProfile(nextPackage, definitionAnnotation);
		}
	}

	/**
	 * Redefine only real definition or do nothing
	 *
	 * @param eclass
	 *            the given eclass that we want to redefine
	 */
	public static void redefineEclass(EClass eclass) {
		if (isADirectDefinition(eclass)) {

			// 1. redefine inheritances
			EList<EClass> eSuperTypes = eclass.getESuperTypes();

			/* copy in order to avoid concurrent access */
			List<EClass> superTypesList = new ArrayList<EClass>();
			superTypesList.addAll(eSuperTypes);

			// for each super types :we test if this is a direct definition
			// if not we remove the local copy and replace by direct definition
			Iterator<EClass> superIter = superTypesList.iterator();
			while (superIter.hasNext()) {
				EClass currentSuperClass = superIter.next();
				if (!isADirectDefinition(currentSuperClass)) {
					EClass directSuperClass = (EClass) lookForDirectDefinitionFrom(currentSuperClass);
					eclass.getESuperTypes().remove(currentSuperClass);
					eclass.getESuperTypes().add(directSuperClass);
				}
			}

			// 2.redefine eReferences
			Iterator<EReference> referencesIterator = eclass.getEReferences().iterator();
			while (referencesIterator.hasNext()) {
				redefineEReference(referencesIterator.next(), eclass.getEPackage());
			}

		}
	}

	/**
	 * this class is used to redefine EReference with direct definition
	 *
	 * @param eReference
	 *            the given EReference that we want to redefine
	 */
	public static void redefineEReference(EReference eReference, EPackage profileDefinition) {
		EReference oldEOpposite = eReference.getEOpposite();
		EClassifier oldType = eReference.getEType();

		// 2.1 the type is an EClass
		if (oldType instanceof EClass) {
			// redefine type
			eReference.setEType(lookForDirectDefinitionFrom(oldType));
			// redefine the Opposite
			if (oldEOpposite != null) {
				eReference.setEOpposite(lookForEquivalentEreference((EClass) eReference.getEType(), oldEOpposite));
			}
		}
	}


	/**
	 * return id this Eclass is the real Definition
	 *
	 * @param eclass
	 *            the eclass that we want to test
	 * @return true if this is the real definition or not is this is a local
	 *         copy
	 */
	public static boolean isADirectDefinition(EClass eclass) {
		if (eclass.getEAnnotations().size() > 0) {
			EAnnotation eAnnotation = eclass.getEAnnotation(UMLUtil.UML2_UML_PACKAGE_2_0_NS_URI);
			if (eAnnotation.getReferences().size() > 0) {
				if (!(eAnnotation.getReferences().get(0) instanceof org.eclipse.uml2.uml.Classifier)) {
					String errMsg = "Problem because of the definition of " + eclass.getName() + " in " + eclass.getEPackage().getNsURI();
					Activator.log.error(errMsg, null);
				}
				org.eclipse.uml2.uml.Classifier theClassifier = (org.eclipse.uml2.uml.Classifier) eAnnotation.getReferences().get(0);
				Package nearestPackage = theClassifier.getNearestPackage();

				if (nearestPackage instanceof Profile) {
					if (eclass.equals(((Profile) nearestPackage).getDefinition(theClassifier))) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * look for the real definition of the stereotype where the EClass may be
	 * the definition
	 *
	 * @param eclass
	 *            that maybe the real definition (maybe a local copy of
	 *            definition)
	 * @return the real definition or the itself
	 */
	public static EClassifier lookForDirectDefinitionFrom(EClassifier eClassifier) {
		if (eClassifier.getEAnnotations().size() > 0) {
			EAnnotation eAnnotation = eClassifier.getEAnnotations().get(0);
			if (eAnnotation.getReferences().size() > 0) {
				org.eclipse.uml2.uml.Classifier theClassifier = (org.eclipse.uml2.uml.Classifier) eAnnotation.getReferences().get(0);
				Package nearestPackage = theClassifier.getNearestPackage();
				if (nearestPackage instanceof Profile) {
					return (EClassifier) ((Profile) nearestPackage).getDefinition(theClassifier);
				}
				return eClassifier;
			}
		}
		return eClassifier;
	}

	/**
	 * this method is used to look for an EReference equivalent to a given
	 * EReference same name and type
	 *
	 * @param eclass
	 *            the given EClass where we look for the equivalent EReference
	 * @param eReference
	 *            the given EReference
	 * @return the return EReference or null
	 */
	private static EReference lookForEquivalentEreference(EClass eclass, EReference eReference) {
		Iterator<EReference> refIterator = eclass.getEReferences().iterator();
		while (refIterator.hasNext()) {
			EReference currentEReference = refIterator.next();
			if (currentEReference.getName().equals(eReference.getName())) {
				if (currentEReference.getEType().getName().endsWith(eReference.getEType().getName())) {
					return currentEReference;
				}
			}
		}
		return null;
	}

	/**
	 * this method is used to suppress all local copy of EClass in each Profile.
	 *
	 * @param thePackage
	 *            that we want to clean
	 */
	public static void cleanProfile(Package thePackage) {
		if (thePackage instanceof Profile) {
			Profile profile = (Profile) thePackage;
			// get profile definition
			EPackage profileDefinition = profile.getDefinition();

			// collect all EClassifier of the definition
			List<EClassifier> tempList = new ArrayList<EClassifier>();
			for (int i = 0; i < profileDefinition.getEClassifiers().size(); i++) {
				tempList.add(profileDefinition.getEClassifiers().get(i));
			}

			// for all EClass
			Iterator<EClassifier> eClassIter = tempList.iterator();
			while (eClassIter.hasNext()) {
				EClassifier eclassifier = eClassIter.next();

				if (eclassifier instanceof EClass) {

					// this is a direct Definition?
					if (!isADirectDefinition((EClass) eclassifier)) {
						// no, so it is removed
						profileDefinition.getEClassifiers().remove(eclassifier);
					}

				}
			}
		}
		Iterator<Package> it = thePackage.getNestedPackages().iterator();
		while (it.hasNext()) {
			Package p = it.next();
			ProfileRedefinition.cleanProfile(p);
		}
	}


	/**
	 * this method is used to created an EAttribute from an Ereference
	 *
	 * @param container
	 *            the Eclass that will contain the eattribute
	 * @param eReference
	 *            from this, the eattribute will be created
	 * @return the created Eattribute
	 */
	public static EAttribute createEAttribute(EClass container, EReference eReference) {

		EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		eAttribute.setEType(eReference.getEType());
		eAttribute.setName(eReference.getName());
		eAttribute.setChangeable(eReference.isChangeable());
		eAttribute.setLowerBound(eReference.getLowerBound());
		eAttribute.setUpperBound(eReference.getUpperBound());
		eAttribute.setOrdered(eReference.isOrdered());
		eAttribute.setDerived(eReference.isDerived());
		eAttribute.setTransient(eReference.isTransient());
		eAttribute.setUnique(eReference.isUnique());
		eAttribute.setUnsettable(eReference.isUnsettable());
		eAttribute.setVolatile(eReference.isVolatile());
		container.getEStructuralFeatures().add(eAttribute);
		return eAttribute;
	}



	/**
	 * this method is used to obtain the classifier from its definition
	 *
	 * @param eclass
	 *            that is a definition
	 * @return the classifier that produce this definition
	 */
	public static Classifier getUMLClassifierFromDefinition(EClassifier eclass) {
		if (eclass.getEAnnotations().size() > 0) {
			EAnnotation eAnnotation = eclass.getEAnnotations().get(0);
			if (eAnnotation.getReferences().size() > 0) {
				org.eclipse.uml2.uml.Classifier theClassifier = (org.eclipse.uml2.uml.Classifier) eAnnotation.getReferences().get(0);
				return theClassifier;
			}
		}
		return null;
	}

	/**
	 * Removes the undefined version.
	 *
	 * @param profile
	 *            The profile.
	 * @since 4.1
	 */
	public static void removeUndefinedVersion(Package packageElement) {
		if (packageElement instanceof Profile) {
			EAnnotation umlAnnotation = ((Profile) packageElement).getEAnnotation(UMLUtil.UML2_UML_PACKAGE_2_0_NS_URI);
			if (null != umlAnnotation) {
				EAnnotation firstAnnotation = umlAnnotation.getEAnnotation(IPapyrusVersionConstants.PAPYRUS_EANNOTATION_SOURCE);
				if (null != firstAnnotation ) {
					PapyrusDefinitionAnnotation tagVersion = PapyrusDefinitionAnnotation.parseEAnnotation(firstAnnotation);
					if (PapyrusDefinitionAnnotation.UNDEFINED_ANNOTATION.equals(tagVersion)) {
						umlAnnotation.getEAnnotations().remove(firstAnnotation);
					}
				}
			}
		}

	}
}
