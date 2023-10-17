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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigationRole;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;

public class OperationMatcher extends AbstractOperationMatcher
{
	private @Nullable List<@NonNull OCLExpression> asArguments = null;

	public OperationMatcher(@NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Type sourceType, @Nullable Type sourceTypeValue) {
		super(environmentFactory, sourceType, null);
		// assert sourceTypeValue == null;			// Bug 580791 Enforcing redundant argument
	}

	@Override
	public @NonNull OCLExpression getArgument(int i) {
		assert asArguments != null;
		return asArguments.get(i);
	}

	@Override
	public int getArgumentCount() {
		assert asArguments != null;
		return asArguments.size();
	}

	public boolean init(@NonNull RoundBracketedClauseCS csRoundBracketedClause) {
		List<@NonNull OCLExpression> asArguments = new ArrayList<>();
		for (NavigatingArgCS csNavigatingArg : csRoundBracketedClause.getOwnedArguments()) {
			if (csNavigatingArg.getRole() == NavigationRole.EXPRESSION) {
				OCLExpression asArgument = PivotUtil.getPivot(OCLExpression.class, csNavigatingArg);
				if (asArgument == null) {
					return false;
				}
				asArguments.add(asArgument);
			}
		}
		this.asArguments = asArguments;
		return true;
	}
}