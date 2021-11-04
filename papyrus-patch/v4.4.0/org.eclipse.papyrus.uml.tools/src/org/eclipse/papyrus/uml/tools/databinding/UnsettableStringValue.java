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
 *   Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - bug 447698
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.databinding;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.emf.requests.UnsetRequest;


/**
 * A specialized observable for string-valued attributes that are "unsettable" in the EMF sense, having a distinct unset state.
 * For string features that have a {@code null} default, instead of accepting the empty string, the feature is simply unset so
 * that it will be {@code null}.
 *
 * @deprecated since 4.3
 *             use {@link org.eclipe.papyrus.uml.properties.databinding.UnsettableStringObservableValue} API,instead
 *
 *             This class Will be removed in Papyrus 5.0, see bug 540829
 *
 */
@Deprecated
public class UnsettableStringValue extends PapyrusObservableValue {

	public UnsettableStringValue(EObject eObject, EStructuralFeature eStructuralFeature, EditingDomain domain) {
		super(eObject, eStructuralFeature, domain);
	}

	public UnsettableStringValue(Realm realm, EObject eObject, EStructuralFeature eStructuralFeature, EditingDomain domain) {
		super(realm, eObject, eStructuralFeature, domain);
	}


	@Override
	protected IEditCommandRequest createSetRequest(TransactionalEditingDomain domain, EObject owner, EStructuralFeature feature, Object value) {

		// Bug 447698 : It doesn't necessary to create UnsetRequest if the value is already null
		if ("".equals(value)) {//$NON-NLS-1$

			if ((feature.getDefaultValue() == null) && owner.eGet(eStructuralFeature) != null) {
				// Unset the string attribute instead of making it an empty string
				return new UnsetRequest(owner, feature);
			}

		} else {
			return super.createSetRequest(domain, owner, feature, value);
		}

		return null;
	}
}
