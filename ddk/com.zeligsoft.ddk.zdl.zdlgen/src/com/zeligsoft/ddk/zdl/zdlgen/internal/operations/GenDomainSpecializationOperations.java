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

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.uml2.common.util.UnionEObjectEList;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.ddk.zdl.zdlgen.GenAllDomainCassifiersMode;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * <!-- begin-user-doc --> A static utility class that provides operations
 * related to '<em><b>Gen Domain Specialization</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getUniqueName(com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier) <em>Get Unique Name</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#allClassifiers() <em>All Classifiers</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#isExcluded(com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem) <em>Is Excluded</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainConcepts() <em>Get Domain Concepts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainSpecializationOperations extends GenDomainNamedElementOperations {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainSpecializationOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static EList<GenDomainConcept> getDomainConcepts(GenDomainSpecialization genDomainSpecialization) {

		UniqueEList<GenDomainConcept> domainConcepts = new UniqueEList.FastCompare<GenDomainConcept>();
		for (GenDomainClassifier gdc : genDomainSpecialization.allClassifiers()) {
			if ((gdc instanceof GenDomainConcept) && !domainConcepts.contains(gdc)) {
				domainConcepts.add((GenDomainConcept) gdc);
			}
		}

		return new UnionEObjectEList<GenDomainConcept>((InternalEObject) genDomainSpecialization,
				ZDLGenPackage.Literals.GEN_DOMAIN_SPECIALIZATION__DOMAIN_CONCEPT, domainConcepts.size(),
				domainConcepts.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static String getUniqueName(GenDomainSpecialization genDomainSpecialization,
			GenDomainClassifier classifier) {

		String result = classifier.getName();

		if (result != null) {
			EList<GenDomainClassifier> all = genDomainSpecialization.allClassifiers();

			for (GenDomainClassifier other : all) {
				if ((other != classifier) && result.equals(other.getName())) {
					// need to qualify the name
					result = classifier.getDomainElement().getQualifiedName();

					if (result != null) {
						result = result.replace(NamedElement.SEPARATOR, "_"); //$NON-NLS-1$
					}

					break;
				}
			}
		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static EList<GenDomainClassifier> allClassifiers(GenDomainSpecialization genDomainSpecialization) {

		UniqueEList<GenDomainClassifier> result = new UniqueEList.FastCompare<GenDomainClassifier>();
		for (GenDomainBlockReference gdbr : genDomainSpecialization.getDomainBlocks()) {
			for (GenDomainClassifier gdc : gdbr.getTarget()
					.allClassifiers(GenAllDomainCassifiersMode.MERGE_AND_IMPORT)) {
				result.add(gdc);
			}
		}

		return ECollections.unmodifiableEList(result);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static boolean isExcluded(GenDomainSpecialization genDomainSpecialization, GenPaletteItem item) {

		return genDomainSpecialization.getExcludedPaletteItems().contains(item);
	}

} // GenDomainSpecializationOperations
