/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.library.AbstractIteration;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.IterableValue;

/**
 * ClosureIteration realizes the Collection::closure() library iteration.
 */
public class ClosureIteration extends AbstractIteration
{
	public static final @NonNull ClosureIteration INSTANCE = new ClosureIteration();

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
	 *	Special case processing for closure() that deduces nullFree both source and argument.
	 *
	 * @since 1.15
	 */
	@Override
	public @Nullable Type resolveReturnType(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp, @Nullable Type returnType) {
		if (returnType instanceof CollectionType) {
			OCLExpression ownedSource = callExp.getOwnedSource();
			if (ownedSource != null) {
				Type sourceType = ownedSource.getType();
				if (sourceType instanceof CollectionType) {
					CollectionType sourceCollectionType = (CollectionType)sourceType;
					OCLExpression body = ((LoopExp)callExp).getOwnedBody();
					Type bodyType = body.getType();
					if (bodyType instanceof CollectionType) {
						CollectionType argumentCollectionType = (CollectionType)bodyType;
						boolean isNullFree = sourceCollectionType.isIsNullFree() && argumentCollectionType.isIsNullFree();
						CollectionType returnCollectionType = (CollectionType)returnType;
						if (returnCollectionType.isIsNullFree() != isNullFree) {
							@SuppressWarnings("null")@NonNull Type elementType = returnCollectionType.getElementType();
							PivotMetamodelManager metamodelManager = (PivotMetamodelManager)environmentFactory.getMetamodelManager();
							returnType = metamodelManager.getCollectionType(returnCollectionType.isOrdered(), returnCollectionType.isUnique(),
								elementType, isNullFree, returnCollectionType.getLowerValue(), returnCollectionType.getUpperValue());
						}
					}
				}
			}
		}
		return returnType;
	}

	/**
	 * Recursively evaluates the iterator body expression.
	 */
	@Override
	protected @Nullable Object updateAccumulator(@NonNull IterationManager iterationManager) {
		IterationManager.IterationManagerExtension2 iterationManager2 = (IterationManager.IterationManagerExtension2)iterationManager;
		// The parent is the iterator
		Object value = iterationManager.get();
		CollectionValue.Accumulator accumulatorValue = (CollectionValue.Accumulator)iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;
		if (!accumulatorValue.add(value)) {
			return CARRY_ON;
		}
		Object bodyVal = iterationManager.evaluateBody();
		if (bodyVal instanceof InvalidValueException) {
			throw (InvalidValueException)bodyVal;				// FIXME Analyze away
		}
		if (bodyVal == null) {
			return iterationManager.getAccumulatorValue();		// Null body is termination
		}
		IterableValue collectionValue;
		if (bodyVal instanceof CollectionValue) {
			collectionValue = (CollectionValue) bodyVal;
		}
		else {
			Executor executor = iterationManager2.getExecutor();
			Type elementType = executor.getStaticTypeOfValue(null, bodyVal);
			CollectionTypeId sequenceId = TypeId.SEQUENCE.getSpecializedId(elementType.getTypeId());
			collectionValue = executor.getIdResolver().createSequenceOfEach(sequenceId, bodyVal);
		}
		evaluateIteration(iterationManager2.createNestedIterationManager(collectionValue));
		return CARRY_ON;
	}
}
