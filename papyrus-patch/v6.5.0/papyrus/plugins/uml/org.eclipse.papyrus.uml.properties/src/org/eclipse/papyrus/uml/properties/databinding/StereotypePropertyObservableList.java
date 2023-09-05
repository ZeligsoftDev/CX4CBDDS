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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.GMFObservableList;
import org.eclipse.papyrus.uml.types.core.requests.SetStereotypeValueRequest;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The observable list for the stereotype property.
 */
public class StereotypePropertyObservableList extends GMFObservableList {

	/**
	 * The stereotype of the stereotype application to edit.
	 */
	private Stereotype stereotype;

	/**
	 *
	 * Constructor.
	 *
	 * @param wrappedList
	 *            The list to be edited when #commit() is called
	 * @param domain
	 *            The editing domain on which the commands will be executed
	 * @param source
	 *            The EObject from which the list will be retrieved
	 * @param feature
	 *            The feature from which the list will be retrieved
	 * @param stereotype
	 *            The stereotype to manage.
	 */
	public StereotypePropertyObservableList(final List<?> wrappedList, final EditingDomain domain, final EObject source, final EStructuralFeature feature, final Stereotype stereotype) {
		super(wrappedList, domain, source, feature);
		this.stereotype = stereotype;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.infra.services.edit.ui.databinding.PapyrusObservableList#getRequests(java.util.List, java.util.Collection)
	 */
	@Override
	protected Collection<? extends IEditCommandRequest> getRequests(List<Object> newValues, Collection<?> removedValues) {
		LinkedList<IEditCommandRequest> requests = new LinkedList<>();

		if (feature instanceof EReference && ((EReference) feature).isContainment() && removedValues != null) {
			for (Object o : removedValues) {
				if (o instanceof EObject) {
					requests.add(new DestroyElementRequest((TransactionalEditingDomain) editingDomain, (EObject) o, false));
				}
			}
		}

		if (source instanceof Element) {
			requests.add(new SetStereotypeValueRequest((TransactionalEditingDomain) editingDomain, stereotype, (Element) source, feature.getName(), newValues));
		} else {
			requests.add(new SetRequest((TransactionalEditingDomain) editingDomain, source, feature, newValues));
		}
		return requests;
	}

}
