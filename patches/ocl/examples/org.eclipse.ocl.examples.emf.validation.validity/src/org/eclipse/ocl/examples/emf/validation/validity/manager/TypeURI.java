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
 * A TypeURI provides the unique identity of a type which is a unique concept for type checking.
 * The most common but not only form of a type is an EClass. Since we may also have UML
 * Classes and Pivot Classes and user defined types, we use a TYpeURI to provide the flexibility.
 * <p>
 * The TypeURI is computed from the namespace URI.
 */
public final class TypeURI implements Comparable<TypeURI>
{
	protected final @NonNull URI uri;
	
	public TypeURI(@NonNull URI uri) {
		this.uri = uri;
	}

	@Override
	public int compareTo(TypeURI o) {
		return uri.toString().compareTo(o.toString());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TypeURI)) {
			return false;
		}
		return uri.equals(((TypeURI)obj).uri);
	}

	@Override
	public int hashCode() {
		return uri.hashCode();
	}

	public String toString() {
		return uri.toString();
	}
}