/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractTernaryOperation;

/**
 * StringReplaceAllOperation realises the String::replaceAll() library operation.
 */
public class StringReplaceAllOperation extends AbstractTernaryOperation
{
	public static final @NonNull StringReplaceAllOperation INSTANCE = new StringReplaceAllOperation();
	
	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable String evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceValue, firstArgumentValue, secondArgumentValue); 
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull String evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		String sourceString = asString(sourceValue);
		String regex = asString(firstArgumentValue);
		String replacement = asString(secondArgumentValue);
		Pattern pattern = executor.getRegexPattern(regex);
		Matcher matcher = pattern.matcher(sourceString);
		@SuppressWarnings("null")@NonNull String result = matcher.replaceAll(replacement);
		return result;
	}
}
