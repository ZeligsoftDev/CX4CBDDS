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
package org.eclipse.ocl.pivot.library.iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.IterationManager;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.AbstractIteration;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;

/**
 * CollectIteration realizes the Collection::collect() library iteration.
 */
public class CollectIteration extends AbstractIteration
{
	public static final @NonNull CollectIteration INSTANCE = new CollectIteration();

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public CollectionValue.@NonNull Accumulator createAccumulatorValue(@NonNull Evaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return createAccumulatorValue(ValueUtil.getExecutor(evaluator), accumulatorTypeId, bodyTypeId);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public CollectionValue.@NonNull Accumulator createAccumulatorValue(@NonNull Executor executor, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return createCollectionAccumulatorValue((CollectionTypeId) accumulatorTypeId);
	}

	/**
	 *	Special case processing for collect() body type.
	 *
	 * @since 1.12
	 */
	@Override
	public @Nullable Type resolveBodyType(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp, @Nullable Type returnType) {
		LoopExp loopExp = (LoopExp)callExp;
		OCLExpression body = loopExp.getOwnedBody();
		Type asType = body != null ? body.getType() : null;
		Type bodyType = asType != null ? PivotUtilInternal.getNonLambdaType(asType) : null;
		if (bodyType != null) {
			@NonNull Type elementType = bodyType;
			//				if (bodyType instanceof CollectionType) {
			while (elementType instanceof CollectionType) {
				Type elementType2 = ((CollectionType)elementType).getElementType();
				if (elementType2 != null) {
					elementType = elementType2;
				}
			}
			//				}
			return elementType;
		}
		return returnType;
	}

	/**
	 *	Special case processing for collect() return type.
	 *
	 * @since 1.12
	 */
	@Override
	public @Nullable Type resolveReturnType(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp, @Nullable Type returnType) {
		LoopExp loopExp = (LoopExp)callExp;
		OCLExpression body = loopExp.getOwnedBody();
		Type asType = body != null ? body.getType() : null;
		Type bodyType = asType != null ? PivotUtilInternal.getNonLambdaType(asType) : null;
		if (bodyType != null) {
			@NonNull Type elementType = bodyType;
			//				if (bodyType instanceof CollectionType) {
			while (elementType instanceof CollectionType) {
				Type elementType2 = ((CollectionType)elementType).getElementType();
				if (elementType2 != null) {
					elementType = elementType2;
				}
			}
			//				}
			boolean isOrdered = (returnType instanceof CollectionType) && ((CollectionType)returnType).isOrdered();
			boolean isNullFree = asType instanceof CollectionType && ((CollectionType)asType).isIsNullFree();
			boolean isRequired = !(asType instanceof CollectionType) && (body != null) && body.isIsRequired();
			PivotMetamodelManager metamodelManager = (PivotMetamodelManager)environmentFactory.getMetamodelManager();
			returnType = metamodelManager.getCollectionType(isOrdered, false, elementType, isNullFree || isRequired, null, null);	// FIXME null, null
		}
		return returnType;
	}

	@Override
    protected @Nullable Object updateAccumulator(@NonNull IterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();
		CollectionValue.Accumulator accumulatorValue = (CollectionValue.Accumulator)iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;
		if (bodyVal == null) {
			accumulatorValue.add(bodyVal);
		}
		else if (bodyVal instanceof CollectionValue) {
			CollectionValue bodyColl = (CollectionValue) bodyVal;
//			try {
				for (Object value : bodyColl.flatten().iterable()) {
					if (value != null) {
						accumulatorValue.add(value);
					}
				}
//			} catch (InvalidValueException e) {
//				iterationManager.throwInvalidEvaluation(e);
//			}
		}
		else
			accumulatorValue.add(bodyVal);
		return CARRY_ON;								// Carry on
	}
}
