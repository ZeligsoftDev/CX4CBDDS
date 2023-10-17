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
package org.eclipse.ocl.pivot.library.string;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.pivot.values.SequenceValue;

/**
 * StringCharactersOperation realises the String::characters() library operation.
 */
public class StringCharactersOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull StringCharactersOperation INSTANCE = new StringCharactersOperation();
	public static final @NonNull CollectionTypeId SEQ_STRING = TypeId.SEQUENCE.getSpecializedId(TypeId.STRING);

	@Override
	public @NonNull SequenceValue evaluate(@Nullable Object sourceVal) {
		String sourceString = asString(sourceVal);
		List<Object> results = new ArrayList<Object>(sourceString.length());
		for (int i = 0; i < sourceString.length(); i++) {
			@NonNull String s = sourceString.substring(i, i+1);
			results.add(s);
		}
		return createSequenceValue(SEQ_STRING, results);
	}
}
