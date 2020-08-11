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

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.ddk.zdl.zdlgen.GenModel;

/**
 * <!-- begin-user-doc --> A static utility class that provides operations
 * related to '<em><b>Gen Model</b></em>' model objects. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following operations are supported:
 * <ul>
 * <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenModel#findUsedDomainModels(org.eclipse.uml2.uml.Model) <em>Find Used Domain Models</em>}</li>
 * <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenModel#getDomainModels(org.eclipse.emf.common.util.EList) <em>Get Domain Models</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GenModelOperations extends GenDomainObjectOperations {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected GenModelOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static EList<Model> findUsedDomainModels(GenModel genModel, Model model) {

		// initial set of models to crawl, looking for external cross-references
		Set<Model> initialModels = Collections.singleton(model);

		@SuppressWarnings("serial")
		class ModelCrossReferencer extends EcoreUtil.CrossReferencer {

			private Set<Model> initialModels;

			private Set<Model> allModels;

			private Set<Model> newModels;

			ModelCrossReferencer(Set<Model> initialModels, Set<Model> allModels) {
				super(initialModels);

				this.initialModels = initialModels;
				this.allModels = allModels;
				this.newModels = new java.util.HashSet<Model>(initialModels);
			}

			Set<Model> findReferencedModels() {
				crossReference();
				done();

				newModels.removeAll(initialModels);
				return newModels;
			}

			@Override
			protected boolean crossReference(EObject object, EReference reference, EObject crossReferencedEObject) {

				EObject root = EcoreUtil.getRootContainer(crossReferencedEObject);
				if ((root instanceof Model) && !allModels.contains(root)) {
					newModels.add((Model) root);
				}

				return false;
			}
		}

		final Set<Model> result = new java.util.HashSet<Model>(initialModels);
		Set<Model> newModels = new java.util.HashSet<Model>(initialModels);

		do {
			newModels = new ModelCrossReferencer(newModels, result).findReferencedModels();
			result.addAll(newModels);
		} while (!newModels.isEmpty());

		result.removeAll(initialModels); // these are my own models, not referenced

		return new BasicEList.UnmodifiableEList<Model>(result.size(), result.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static EList<Model> getDomainModels(GenModel genModel, EList<String> uris) {

		Set<Model> result = new java.util.LinkedHashSet<Model>(); // ordered

		Resource resource = genModel.eResource();
		if (resource != null) {
			ResourceSet rset = resource.getResourceSet();

			if (rset != null) {
				for (String uriString : uris) {
					URI uri = URI.createURI(uriString);
					EObject obj = rset.getEObject(uri, true);
					if (obj instanceof Model) {
						result.add((Model) obj);
					}
				}
			}
		}

		return new BasicEList.UnmodifiableEList<Model>(result.size(), result.toArray());
	}

} // GenModelOperations
