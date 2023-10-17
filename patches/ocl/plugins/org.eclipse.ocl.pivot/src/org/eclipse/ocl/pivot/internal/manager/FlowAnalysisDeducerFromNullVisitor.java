/**
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 */
package org.eclipse.ocl.pivot.internal.manager;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis.AbstractDeducer;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * @since 1.7
 */
public class FlowAnalysisDeducerFromNullVisitor extends AbstractDeducer
{
	protected final boolean isNull;

	public FlowAnalysisDeducerFromNullVisitor(@NonNull FlowAnalysis flowAnalysis, boolean isNull) {
		super(flowAnalysis);
		this.isNull = isNull;
	}

	@Override
	public @Nullable Boolean visitCallExp(@NonNull CallExp object) {
		return context.setCallPath(object, isNull);
	}

	@Override
	public @Nullable Boolean visitNullLiteralExp(@NonNull NullLiteralExp object) {
		return isNull;
	}

	@Override
	public @Nullable Boolean visitVariableExp(@NonNull VariableExp object) {
		VariableDeclaration variable = PivotUtil.getReferredVariable(object);
		return context.setVariable(variable, isNull);
	}
}
