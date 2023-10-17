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
package org.eclipse.ocl.pivot.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.pivot.values.CollectionValue;

/**
 * CollectionFlattenOperation realises the Collection::flatten() library operation.
 */
public class CollectionFlattenOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull CollectionFlattenOperation INSTANCE = new CollectionFlattenOperation();

	@Override
	public @NonNull CollectionValue evaluate(@Nullable Object argument) {
		CollectionValue collectionValue = asCollectionValue(argument);
		return collectionValue.flatten();
	}

	/**
	 *	Special case processing for flatten() that flattens nested types.
	 *
	 * @since 1.18
	 */
	@Override
	public void resolveUnmodeledTemplateParameterSubstitutions(@NonNull TemplateParameterSubstitutionVisitor templateParameterSubstitutions, @NonNull CallExp callExp) {
		Type elementType = callExp.getOwnedSource().getType();
		while (elementType instanceof CollectionType) {
			elementType = ((CollectionType)elementType).getElementType();
		}
		templateParameterSubstitutions.put(1, elementType);
	}
}
