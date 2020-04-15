/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.ui.queries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.uml.modelexplorer.queries.GetVisibleUMLReferencesQuery;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Model explorer UML customization facet query
 * @author Young-Soo Roh
 *
 */
public class CXGetVisibleUMLReferencesQuery extends GetVisibleUMLReferencesQuery {
	/**
	 * EReferences that should always be hidden
	 */
	private static final Set<EReference> moreExcludedReferences = getMoreExcludedReferences();

	private static final Set<EReference> getMoreExcludedReferences() {
		Set<EReference> result = new HashSet<>();
		result.add(UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT);
		result.add(UMLPackage.Literals.COMPONENT__PACKAGED_ELEMENT);
		result.add(UMLPackage.Literals.CLASS__NESTED_CLASSIFIER);
		result.add(UMLPackage.Literals.INTERFACE__NESTED_CLASSIFIER);
		return result;
	}

	/**
	 * @see org.eclipse.papyrus.views.modelexplorer.queries.GetVisibleReferencesQuery#evaluate(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2,
	 *      org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager)
	 *
	 * @param source
	 * @param parameterValues
	 * @param facetManager
	 * @return
	 * @throws DerivedTypedElementException
	 */
	@Override
	public List<EReference> evaluate(EObject source, IParameterValueList2 parameterValues, IFacetManager facetManager)
			throws DerivedTypedElementException {

		List<EReference> result = new ArrayList<EReference>(super.evaluate(source, parameterValues, facetManager));
		if (source instanceof NamedElement) {
			result.add(UMLPackage.Literals.NAMED_ELEMENT__CLIENT_DEPENDENCY);
		}
		result.removeAll(moreExcludedReferences);
		return result;
	}
}