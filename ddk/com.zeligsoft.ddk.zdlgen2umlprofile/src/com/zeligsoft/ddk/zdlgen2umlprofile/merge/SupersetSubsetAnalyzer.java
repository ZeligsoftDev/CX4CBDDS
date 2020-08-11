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
package com.zeligsoft.ddk.zdlgen2umlprofile.merge;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A specialized cross-referencer that indexes superset/subset relationships
 * between properties in the UML metamodel and can answer useful queries about
 * them.
 * 
 * @author Christian W. Damus (cdamus)
 */
class SupersetSubsetAnalyzer
		extends EcoreUtil.CrossReferencer {

	private static final long serialVersionUID = 4004842940651790113L;

	private static final String SUBSETS_ANNOTATION = "subsets"; //$NON-NLS-1$

	private static SupersetSubsetAnalyzer INSTANCE = new SupersetSubsetAnalyzer();
	static {
		INSTANCE.crossReference();
		INSTANCE.done();
	}

	/** Cache of the supersets of a reference (contains empty sets). */
	private Map<EReference, Set<EReference>> supersets = new java.util.HashMap<EReference, Set<EReference>>();

	/** Cache of the subsets of a reference (contains empty sets). */
	private Map<EReference, Set<EReference>> subsets = new java.util.HashMap<EReference, Set<EReference>>();

	/**
	 * Initializes me.
	 */
	private SupersetSubsetAnalyzer() {
		super(UMLPackage.eINSTANCE);
	}

	/**
	 * Obtains the analyzer.
	 * 
	 * @return the analyzer
	 */
	static SupersetSubsetAnalyzer getInstance() {
		return INSTANCE;
	}

	@Override
	protected boolean crossReference(EObject object, EReference reference,
			EObject crossReferencedEObject) {

		return (reference == EcorePackage.Literals.EANNOTATION__REFERENCES)
			&& SUBSETS_ANNOTATION.equals(((EAnnotation) object).getSource());
	}

	/**
	 * Queries whether the specified reference is a superset of or a subset of
	 * any reference that is a containment or a container reference, implicitly
	 * or explicitly.
	 * 
	 * @param ref
	 *            a reference
	 * @return whether it is a superset or a subset of a containment or
	 *         container reference
	 */
	boolean isSupersetOrSubsetOfContainerOrContainment(EReference ref) {
		return isSupersetOfContainerOrContainment(ref)
			|| isSubsetOfContainerOrContainment(ref);
	}

	/**
	 * Queries whether the specified reference is a superset of some other
	 * reference that is either a container or a containment, whether implicitly
	 * or explicitly.
	 * 
	 * @param ref
	 *            a reference
	 * @return whether it is a superset of a container or containment reference
	 */
	boolean isSupersetOfContainerOrContainment(EReference ref) {
		return isSupersetOfContainerOrContainment(ref, ref.getEOpposite());
	}

	private boolean isSupersetOfContainerOrContainment(EReference ref,
			EReference eOpposite) {

		boolean result = false;
		Set<EReference> allSubsets = getAllSubsets(ref);

		if (!allSubsets.isEmpty()) {
			for (EReference subset : allSubsets) {
				if (subset.isContainer() || subset.isContainment()) {
					result = true;
					break;
				}
			}
		}

		if (!result && (eOpposite != null)) {
			result = isSupersetOfContainerOrContainment(eOpposite, null);
		}

		return result;
	}

	/**
	 * Queries whether the specified reference is a subsets of some other
	 * reference that is either a container or a containment, whether implicitly
	 * or explicitly.
	 * 
	 * @param ref
	 *            a reference
	 * @return whether it is a subsets of a container or containment reference
	 */
	boolean isSubsetOfContainerOrContainment(EReference ref) {
		return isSubsetOfContainerOrContainment(ref, ref.getEOpposite());
	}

	private boolean isSubsetOfContainerOrContainment(EReference ref,
			EReference eOpposite) {

		boolean result = false;
		Set<EReference> allSupersets = getAllSupersets(ref);

		if (!allSupersets.isEmpty()) {
			for (EReference subset : allSupersets) {
				if (subset.isContainer() || subset.isContainment()) {
					result = true;
					break;
				}
			}
		}

		if (!result && (eOpposite != null)) {
			result = isSubsetOfContainerOrContainment(eOpposite, null);
		}

		return result;
	}

	/**
	 * Obtains all of the supersets of the specified reference, that is, all of
	 * the references that it subsets (recursively).
	 * 
	 * @param ref
	 *            a reference
	 * @return all of its supersets, recursively
	 */
	Set<EReference> getAllSupersets(EReference ref) {
		Set<EReference> result = supersets.get(ref);

		if (result == null) {
			EAnnotation annot = ref.getEAnnotation(SUBSETS_ANNOTATION);

			if (annot == null) {
				result = Collections.emptySet();
				supersets.put(ref, result);
			} else {
				result = new java.util.HashSet<EReference>();
				supersets.put(ref, result); // beat recursion by caching first

				for (EObject next : annot.getReferences()) {
					if (next instanceof EReference) {
						EReference superset = (EReference) next;

						if (result.add(superset)) {
							result.addAll(getAllSupersets(superset));
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * Obtains all of the subsets of the specified reference, that is, all of
	 * the references subset it (recursively).
	 * 
	 * @param ref
	 *            a reference
	 * @return all of its subsets, recursively
	 */
	Set<EReference> getAllSubsets(EReference ref) {
		Set<EReference> result = subsets.get(ref);

		if (result == null) {
			Collection<EStructuralFeature.Setting> settings = get(ref);

			if ((settings == null) || settings.isEmpty()) {
				result = Collections.emptySet();
				subsets.put(ref, result);
			} else {
				result = new java.util.HashSet<EReference>();
				subsets.put(ref, result); // beat recursion by caching first

				for (EStructuralFeature.Setting next : settings) {
					if (next.getEObject() instanceof EAnnotation) {
						EObject owner = ((EAnnotation) next.getEObject())
							.getEModelElement();

						if (owner instanceof EReference) {
							EReference subset = (EReference) owner;

							if (result.add(subset)) {
								result.addAll(getAllSubsets(subset));
							}
						}
					}
				}
			}
		}

		return result;
	}
}
