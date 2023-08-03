/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.queries;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;

/**
 * this query is used to return false, if the given object is a references that is not containment or if it is a attribute.
 * it return true if the the feature is also a facetReferences
 *
 * @deprecated Since Papyrus 1.2.0 (Bug 485539), the isVisible query is not used for Features anymore.
 *             Use {@link GetVisibleReferencesQuery} instead
 *
 */
@Deprecated
public class IsContainmentStructuralFeature implements IJavaQuery2<EObject, Boolean> {

	@Override
	public Boolean evaluate(final EObject context, final IParameterValueList2 parameterValues, final IFacetManager facetManager) throws DerivedTypedElementException {
		ParameterValue parameterValue = parameterValues.getParameterValueByName("eStructuralFeature");
		EStructuralFeature eStructuralFeature = (EStructuralFeature) parameterValue.getValue();
		// if eStructural feature ==null this is root model explorer.
		// border effect of this kind of queries
		if (eStructuralFeature == null) {
			return true;
		}
		// This is a UML element?
		if (context instanceof EObject) {
			// the eStructure is a containmentReference or Facet Reference?
			if (eStructuralFeature instanceof EReference) {
				if (eStructuralFeature == EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS) {
					return false;
				}

				return ((EReference) eStructuralFeature).isContainment() || eStructuralFeature instanceof FacetReference;
			}
			// this is not a ref like EAttribute
			else {
				return false;
			}
		}
		// this is not a UML element
		return false;
	}
}
