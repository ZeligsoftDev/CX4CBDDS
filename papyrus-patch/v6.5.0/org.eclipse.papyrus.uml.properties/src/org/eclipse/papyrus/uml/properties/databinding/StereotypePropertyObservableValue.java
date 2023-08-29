/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.databinding;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.GMFObservableValue;
import org.eclipse.papyrus.uml.types.core.requests.SetStereotypeValueRequest;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The observable value for the stereotype property.
 */
public class StereotypePropertyObservableValue extends GMFObservableValue {

	/**
	 * The stereotype of the stereotype application to edit.
	 */
	private Stereotype stereotype;

	/**
	 * Boolean to determinate if the command is managed by a SetStereotypeRequest or not.
	 */
	private boolean isSetStereotypeRequest;

	/**
	 * Constructor.
	 *
	 * @param eObject
	 *            The EObject to edit.
	 * @param eStructuralFeature
	 *            The structural feature to edit.
	 * @param domain
	 *            The editing domain on which the commands will be executed.
	 * @param stereotype
	 *            The stereotype applied to edit.
	 */
	public StereotypePropertyObservableValue(final EObject eObject, final EStructuralFeature eStructuralFeature, final EditingDomain domain, final Stereotype stereotype) {
		super(eObject, eStructuralFeature, domain);
		this.stereotype = stereotype;
		this.isSetStereotypeRequest = false;
	}

	/**
	 * Constructor.
	 *
	 * @param realm
	 *            The realm.
	 * @param eObject
	 *            The EObject to edit.
	 * @param eStructuralFeature
	 *            The structural feature to edit.
	 * @param domain
	 *            The editing domain on which the commands will be executed.
	 * @param stereotype
	 *            The stereotype applied to edit.
	 */
	public StereotypePropertyObservableValue(final Realm realm, final EObject eObject, final EStructuralFeature eStructuralFeature, final EditingDomain domain, final Stereotype stereotype) {
		super(realm, eObject, eStructuralFeature, domain);
		this.stereotype = stereotype;
		this.isSetStereotypeRequest = false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.infra.services.edit.ui.databinding.PapyrusObservableValue#createSetRequest(org.eclipse.emf.transaction.TransactionalEditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
	 */
	@Override
	protected IEditCommandRequest createSetRequest(final TransactionalEditingDomain domain, final EObject owner, final EStructuralFeature feature, final Object value) {
		if (owner instanceof Element) {
			this.isSetStereotypeRequest = true;
			return new SetStereotypeValueRequest(domain, stereotype, (Element) owner, feature.getName(), value);
		}
		return super.createSetRequest(domain, owner, feature, value);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.infra.services.edit.ui.databinding.PapyrusObservableValue#doSetValue(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void doSetValue(final Object value) {
		this.isSetStereotypeRequest = false;
		super.doSetValue(value);
		if (isSetStereotypeRequest) {
			// If the SetStereotypeRequest is used, the command to set value is not set by emf eSet method, so the listener is not managed
			fireValueChange(null);
			this.isSetStereotypeRequest = false;
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.databinding.EObjectObservableValue#doGetValue()
	 */
	@Override
	protected Object doGetValue() {
		if (eObject instanceof Element) {
			final EObject stereotypeApplication = ((Element) eObject).getStereotypeApplication(stereotype);
			if (null != stereotypeApplication) {
				return stereotypeApplication.eGet(eStructuralFeature);
			}
		}
		return super.doGetValue();
	}

}
