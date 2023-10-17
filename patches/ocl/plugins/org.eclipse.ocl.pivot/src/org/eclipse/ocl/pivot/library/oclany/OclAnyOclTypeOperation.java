/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.library.AbstractUntypedUnaryOperation;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * OclAnyOclTypeOperation realises the OclAny::oclType() library operation.
 */
public class OclAnyOclTypeOperation extends AbstractUntypedUnaryOperation
{
	public static final @NonNull OclAnyOclTypeOperation INSTANCE = new OclAnyOclTypeOperation();

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @NonNull Type evaluate(@NonNull Evaluator evaluator, @Nullable Object sourceValue) {
		return evaluate(getExecutor(evaluator), sourceValue);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull Type evaluate(@NonNull Executor executor, @Nullable Object sourceVal) {
//		return executor.getStaticTypeOf(sourceVal);
		return executor.getIdResolver().getDynamicTypeOf(sourceVal);
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @Nullable Type resolveReturnType(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp, @Nullable Type returnType) {
		assert returnType != null;
		OCLExpression source = PivotUtil.getOwnedSource(callExp);
		Type sourceType = PivotUtil.getType(source);
	//	if (sourceType.eClass() == PivotPackage.Literals.CLASS) {
		if ((sourceType instanceof AnyType) || (sourceType instanceof InvalidType) || (sourceType instanceof VoidType)) {	// Irregular super/sub-meta-type conformance
			return environmentFactory.getStandardLibrary().getClassType();	// Suppress the irregularity ?? Class<OclAny> rather than Class<Class>
		}
	//	if (sourceType instanceof DataType) {	// collections, maps, lambdas, tuples, enumerations
			return environmentFactory.getIdResolver().getStaticTypeOfValue(null, sourceType);
	//	}
	//	else {
	//		return environmentFactory.getStandardLibrary().getClassType();	// FIXME could be common type of all possible metatypes
	//	}
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @Nullable Object resolveReturnValue(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp) {
		OCLExpression source = PivotUtil.getOwnedSource(callExp);
		return PivotUtil.getType(source);
	}
}
