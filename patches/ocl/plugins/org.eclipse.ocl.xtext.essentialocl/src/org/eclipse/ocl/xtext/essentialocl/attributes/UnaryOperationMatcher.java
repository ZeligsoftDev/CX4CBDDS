/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 388529
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.attributes;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;

public class UnaryOperationMatcher extends AbstractOperationMatcher
{
	public UnaryOperationMatcher(@NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Type sourceType, @Nullable Type sourceTypeValue) {
		super(environmentFactory, sourceType, null);
		// assert sourceTypeValue == null;			// Bug 580791 Enforcing redundant argument
	}

	@Override
	public @NonNull OCLExpression getArgument(int i) {
		throw new IllegalStateException();
	}

	@Override
	public int getArgumentCount() {
		return 0;
	}
}