/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.collection;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.values.CollectionValue;

/**
 * CollectionIncludingAllOperation realises the Collection::includingAll() library operation.
 */
public class CollectionIncludingAllOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull CollectionIncludingAllOperation INSTANCE = new CollectionIncludingAllOperation();

	@Override
	public @NonNull CollectionValue evaluate(@Nullable Object left, @Nullable Object right) {
		CollectionValue leftCollectionValue = asCollectionValue(left);
		CollectionValue rightCollectionValue = asCollectionValue(right);
		return leftCollectionValue.includingAll(rightCollectionValue);
	}

	/**
	 *	Special case processing for includingAll() that deduces nullFree both source and argument.
	 *
	 * @since 1.18
	 */
	@Override
	public @Nullable Type resolveReturnType(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp, @Nullable Type returnType) {
		if (returnType instanceof CollectionType) {
			OCLExpression ownedSource = callExp.getOwnedSource();
			if (ownedSource != null) {
				Type sourceType = ownedSource.getType();
				if (sourceType instanceof CollectionType) {
					CollectionType sourceCollectionType = (CollectionType)sourceType;
					List<OCLExpression> arguments = ((OperationCallExp)callExp).getOwnedArguments();
					if (arguments.size() > 0) {
						OCLExpression ownedArgument = arguments.get(0);
						if (ownedArgument != null) {
							Type argumentType = ownedArgument.getType();
							if (argumentType instanceof CollectionType) {
								CollectionType argumentCollectionType = (CollectionType)argumentType;
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
			}
		}
		return returnType;
	}
}
