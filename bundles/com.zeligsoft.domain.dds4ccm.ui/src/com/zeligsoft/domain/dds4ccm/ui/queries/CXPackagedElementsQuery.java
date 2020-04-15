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

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * Packaged element query
 * @author Young-Soo Roh
 *
 */
public class CXPackagedElementsQuery implements IJavaQuery2<Namespace, List<PackageableElement>> {
	/**
	 * @see org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2#evaluate(org.eclipse.emf.ecore.EObject,
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
	public List<PackageableElement> evaluate(Namespace source, IParameterValueList2 parameterValues,
			IFacetManager facetManager) throws DerivedTypedElementException {
		List<PackageableElement> packageableElements;
		if (source instanceof Package) {
			packageableElements = ((Package) source).getPackagedElements();
		} else if (source instanceof Component) {
			packageableElements = ((Component) source).getPackagedElements();
		} else {
			return Collections.emptyList();
		}
		List<PackageableElement> result = packageableElements.stream().filter(e -> !(e instanceof Dependency)) //
				.collect(Collectors.toList());
		return result;
	}
}