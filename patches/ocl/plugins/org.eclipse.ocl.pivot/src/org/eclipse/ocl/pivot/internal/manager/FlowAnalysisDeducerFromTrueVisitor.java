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
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis.AbstractDeducer;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * @since 1.7
 */
public class FlowAnalysisDeducerFromTrueVisitor extends AbstractDeducer
{
	public FlowAnalysisDeducerFromTrueVisitor(@NonNull FlowAnalysis flowAnalysis) {
		super(flowAnalysis);
	}

	@Override
	public @Nullable Boolean visitBooleanLiteralExp(@NonNull BooleanLiteralExp object) {
		return object.isBooleanSymbol();
	}

	@Override
	public @Nullable Boolean visitOperationCallExp(@NonNull OperationCallExp object) {
		OperationId operationId = PivotUtil.getReferredOperation(object).getOperationId();
		if (PivotUtil.isSameOperation(operationId, OperationId.BOOLEAN_AND)) {
			context.addTrueExpression(PivotUtil.getOwnedSource(object));
			context.addTrueExpression(PivotUtil.getOwnedArgument(object, 0));
			return Boolean.TRUE;
		}
		else if (PivotUtil.isSameOperation(operationId, OperationId.BOOLEAN_IMPLIES)) {
			context.addTrueExpression(PivotUtil.getOwnedSource(object));
			context.addFalseExpression(PivotUtil.getOwnedArgument(object, 0));
			return Boolean.TRUE;
		}
		else if (PivotUtil.isSameOperation(operationId, OperationId.BOOLEAN_NOT)) {
			context.addFalseExpression(PivotUtil.getOwnedSource(object));
			return Boolean.TRUE;
		}
		else if (PivotUtil.isSameOperation(operationId, OperationId.OCLANY_EQUALS)) {
			OCLExpression ownedSource = PivotUtil.getOwnedSource(object);
			OCLExpression ownedArgument = PivotUtil.getOwnedArgument(object, 0);
			if (isAlreadyNull(ownedSource)) {
				context.addNullExpression(ownedArgument);
				return Boolean.TRUE;
			}
			else if (isAlreadyNonNull(ownedSource)) {
				context.addNonNullExpression(ownedArgument);
				return Boolean.TRUE;
			}
			else if (isAlreadyNull(ownedArgument)) {
				context.addNullExpression(ownedSource);
				return Boolean.TRUE;
			}
			else if (isAlreadyNonNull(ownedArgument)) {
				context.addNonNullExpression(ownedSource);
				return Boolean.TRUE;
			}
			// if isFutureNull ...
		}
		else if (PivotUtil.isSameOperation(operationId, OperationId.OCLANY_NOT_EQUALS)) {
			OCLExpression ownedSource = PivotUtil.getOwnedSource(object);
			OCLExpression ownedArgument = PivotUtil.getOwnedArgument(object, 0);
			if (isAlreadyNull(ownedSource)) {
				context.addNonNullExpression(ownedArgument);
				return Boolean.TRUE;
			}
			else if (isAlreadyNull(ownedArgument)) {
				context.addNonNullExpression(ownedSource);
				return Boolean.TRUE;
			}
			// if isFutureNull ...
		}
		return super.visitOperationCallExp(object);
	}
}