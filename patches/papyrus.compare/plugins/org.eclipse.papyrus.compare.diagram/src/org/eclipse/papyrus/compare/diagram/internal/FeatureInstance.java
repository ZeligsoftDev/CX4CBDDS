/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Instance of a feature for an EObject, designed to be used as a key in a Map.
 * 
 * @author <a href="mailto:laurent.delaigue@obeo.fr">Laurent Delaigue</a>
 */
class FeatureInstance {
	/** The EObject. */
	private final EObject eObject;

	/** The feature. */
	private final EStructuralFeature feature;

	/**
	 * Constructor.
	 * 
	 * @param eObject
	 *            The EObject
	 * @param feature
	 *            The feature
	 */
	FeatureInstance(EObject eObject, EStructuralFeature feature) {
		super();
		this.eObject = eObject;
		this.feature = feature;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// CHECKSTYLE:OFF Code generated by JDT
		result = prime * result + ((eObject == null) ? 0 : eObject.hashCode());
		result = prime * result + ((feature == null) ? 0 : feature.hashCode());
		// CHECKSTYLE:ON
		return result;
	}

	// CHECKSTYLE:OFF Code generated by JDT
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		FeatureInstance other = (FeatureInstance)obj;
		if (eObject != other.eObject) {
			return false;
		}
		if (feature != other.feature) {
			return false;
		}
		return true;
		// CHECKSTYLE:ON
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		if (eObject == null) {
			b.append("<null>."); //$NON-NLS-1$
		} else {
			b.append(eObject.eClass().getName()).append('@');
			b.append(Integer.toHexString(eObject.hashCode())).append('.');
		}
		if (feature == null) {
			b.append("<null>"); //$NON-NLS-1$
		} else {
			b.append(feature.getName());
		}
		return b.toString();
	}
}
