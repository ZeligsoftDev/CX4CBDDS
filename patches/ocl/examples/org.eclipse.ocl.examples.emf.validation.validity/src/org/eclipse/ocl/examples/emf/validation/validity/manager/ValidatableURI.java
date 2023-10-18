/*******************************************************************************
 * Copyright (c) 2014, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.manager;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A ValidatableURI provides the unique identity of a Validatable Node which is a model node
 * and which typically forms the basis of a distinct tree node in the LH pane of the Validity View.
 * <p>
 * The ValidatableURI is simply computed by EcoreUtil.getURI(eObject), but it is convenient to
 * maintain a wrapper on the URI to reduce confusion between model and meta-model object spaces.
 */
public final class ValidatableURI
{
	protected final @NonNull URI uri;
	
	public ValidatableURI(@NonNull URI uri) {
		this.uri = uri;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ValidatableURI)) {
			return false;
		}
		return uri.equals(((ValidatableURI)obj).uri);
	}

	@Override
	public int hashCode() {
		return uri.hashCode();
	}

	public String toString() {
		return uri.toString();
	}
}