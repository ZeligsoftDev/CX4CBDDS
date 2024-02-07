/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Operation;

public class DomainReflectiveFragment extends ReflectiveFragment
{
//	protected final EClassifier eClassifier;

	public DomainReflectiveFragment(@NonNull DomainReflectiveType derivedInheritance, @NonNull CompleteInheritance baseInheritance) {
		super(derivedInheritance, baseInheritance);
//		this.eClassifier = derivedInheritance.getEClassifier();		
	}

//	public final EClassifier getEClassifier() {
//		return eClassifier;
//	}

	@Override
	public @Nullable Operation getLocalOperation(@NonNull Operation baseOperation) {
		throw new UnsupportedOperationException();		// FIXME
	}
}