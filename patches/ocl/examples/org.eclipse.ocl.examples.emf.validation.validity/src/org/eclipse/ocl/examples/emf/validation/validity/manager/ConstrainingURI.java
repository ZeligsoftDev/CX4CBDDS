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
 * A ConstrainingURI provides the unique identity of a Constraining Node, which is a meta-model node
 * and which typically forms the basis of a distinct tree node in the RH pane of the Validity View. 
 * <p>
 * Duplicate nodes such as multiple same-named contexts in CompleteOCL may be merged.
 */
public final class ConstrainingURI implements Comparable<ConstrainingURI>
{
	/**
	 * It is possible to have multiple "identical" contexts defined in an OCL file :
	 * <pre>
	 * context EClass
	 *   inv invariant1 : not name.oclIsUndefined()
	 * 
	 * context EClass
	 *   inv invariant2 : if interface then name.startsWith('I') else true endif;
	 * </pre>
	 * 
	 * In such a case, the URI of the first will be <code>http://www.eclipse.org/emf/2002/Ecore#//EClass</code> while the URI of the second will be <code>http://www.eclipse.org/emf/2002/Ecore#//EClass.1</code>. We wish to "regroup" both invariants
	 * under the same context in the validity results.
	 *
	private @NonNull static URI trimDuplicateContextSuffix(@NonNull URI uri) {
		String fragment = uri.fragment();
		// This should always be called on types, so we should be able to safely remove the trailing ".1" from the fragment
		if (fragment.matches(".*\\.[0-9]+$")){
			String trimmedFragment = fragment.replaceFirst("\\.[0-9]+$", "");
			URI trimmedURI = uri.trimFragment().appendFragment(trimmedFragment);
			assert trimmedURI != null;
			return trimmedURI;
		}
		return uri;
	} */

	protected final @NonNull URI uri;
	
	public ConstrainingURI(@NonNull URI uri) {
		this.uri = uri; //trimDuplicateContextSuffix(uri);			// FIXME should not be needed
	}

	@Override
	public int compareTo(ConstrainingURI o) {
		String n1 = toString();
		String n2 = o.toString();
		return n1.compareTo(n2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ConstrainingURI)) {
			return false;
		}
		return uri.equals(((ConstrainingURI)obj).uri);
	}

	@Override
	public int hashCode() {
		return uri.hashCode();
	}

	public String toString() {
		return uri.toString();
	}
}