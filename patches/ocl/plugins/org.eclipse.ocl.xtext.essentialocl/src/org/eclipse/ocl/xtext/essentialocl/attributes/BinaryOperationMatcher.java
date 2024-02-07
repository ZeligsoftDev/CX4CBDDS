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
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;

public class BinaryOperationMatcher extends AbstractOperationMatcher
{
	protected final @NonNull OCLExpression asArgument;

	public BinaryOperationMatcher(@NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Type sourceType, @Nullable Type sourceTypeValue, @Nullable ExpCS csArgument) {
		super(environmentFactory, sourceType, null);
		this.asArgument = ClassUtil.nonNullState(PivotUtil.getPivot(OCLExpression.class, csArgument));
		// assert sourceTypeValue == null;			// Bug 580791 Enforcing redundant argument
	}

	@Override
	public @NonNull OCLExpression getArgument(int i) {
		if (i != 0) {
			throw new IllegalStateException();
		}
		return asArgument;
	}

	@Override
	public int getArgumentCount() {
		return 1;
	}
}