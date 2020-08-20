/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen.internal.operations;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.common.util.UnionEObjectEList;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Gen Domain Concept</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#allGenerals() <em>All Generals</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#allSpecifics() <em>All Specifics</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getGenerals() <em>Get Generals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainConceptOperations extends GenDomainNamedElementOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainConceptOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static EList<GenDomainConcept> getGenerals(GenDomainConcept genDomainConcept) {
		EList<GenDomainConcept> result = new UniqueEList.FastCompare<GenDomainConcept>();

		for (GenDomainGeneralization generalization : genDomainConcept.getGeneralizations()) {
			if (generalization.getGeneral() != null) {
				result.add(generalization.getGeneral());
			}
		}

		return new UnionEObjectEList<GenDomainConcept>((InternalEObject) genDomainConcept,
				ZDLGenPackage.Literals.GEN_DOMAIN_CONCEPT__GENERAL, result.size(), result.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static EList<GenDomainConcept> allGenerals(GenDomainConcept genDomainConcept) {
		Set<GenDomainConcept> result = new LinkedHashSet<GenDomainConcept>();

		allGeneralsHelper(genDomainConcept, result);

		return new BasicEList.UnmodifiableEList<GenDomainConcept>(result.size(), result.toArray());
	}

	/**
	 * Recursive helper operation for {@link #allGenerals(GenDomainConcept)}.
	 * 
	 * @param genDomainConcept a domain concept
	 * @param result the accumulator of all generals
	 */
	private static void allGeneralsHelper(GenDomainConcept genDomainConcept, Set<GenDomainConcept> result) {

		for (GenDomainConcept general : genDomainConcept.getGenerals()) {
			if (result.add(general)) {
				allGeneralsHelper(general, result);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static EList<GenDomainConcept> allSpecifics(GenDomainConcept genDomainConcept) {

		Set<GenDomainConcept> result = new LinkedHashSet<GenDomainConcept>();

		allSpecificsHelper(genDomainConcept, result);

		return new BasicEList.UnmodifiableEList<GenDomainConcept>(result.size(), result.toArray());
	}

	/**
	 * Recursive helper operation for {@link #allSpecifics(GenDomainConcept)}.
	 * 
	 * @param genDomainConcept a domain concept
	 * @param result the accumulator of all specifics
	 */
	private static void allSpecificsHelper(GenDomainConcept genDomainConcept, Set<GenDomainConcept> result) {

		Set<GenDomainConcept> specifics = new java.util.HashSet<GenDomainConcept>();
		for (EStructuralFeature.Setting setting : UML2Util.getNonNavigableInverseReferences(genDomainConcept)) {
			if (setting.getEStructuralFeature() == ZDLGenPackage.Literals.GEN_DOMAIN_GENERALIZATION__GENERAL) {
				GenDomainGeneralization generalization = (GenDomainGeneralization) setting.getEObject();
				if (generalization.getSpecific() != null) {
					specifics.add(generalization.getSpecific());
				}
			}
		}

		for (GenDomainConcept specific : specifics) {
			if (result.add(specific)) {
				allSpecificsHelper(specific, result);
			}
		}
	}

} // GenDomainConceptOperations