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
import org.eclipse.ocl.pivot.library.AbstractSimpleTernaryOperation;
import org.eclipse.ocl.pivot.values.SequenceValue;

/**
 * SequenceSubSequenceOperation realises the OrderedSet::subSequence() library operation.
 */
public class SequenceSubSequenceOperation extends AbstractSimpleTernaryOperation
{
	public static final @NonNull SequenceSubSequenceOperation INSTANCE = new SequenceSubSequenceOperation();

	@Override
	public @NonNull SequenceValue evaluate(@Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		SequenceValue selfValue = asSequenceValue(sourceValue);
		Integer fromValue = asInteger(firstArgumentValue);
		Integer toValue = asInteger(secondArgumentValue);
		return selfValue.subSequence(fromValue, toValue);
	}
}
