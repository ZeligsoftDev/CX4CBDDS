/*******************************************************************************
 * Copyright (c) 2014, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.values;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.Type;

/**
 * TemplateParameterSubstitutions defines the interaction with the matching of formal TemplateParameters and actual types.
 * Formal template parameters are identified by theit integer intexes in a flattened list starting at the outer-most TemplateableElement.
 * The template parameter indexes in Collection(T1)::product(T2)(...)... are therefore 0 for T1, and 1 for T2.
 * <p>
 * A derived TemplateParameterSubstitutionVisitor determines the bindings by recursive analysis of a pair of formal and actual expression/type trees.
 * <p>
 * The EMPTY instance handles the degenerate case of no template parameters.
 */
public interface TemplateParameterSubstitutions
{
	/**
	 * Return the highest common actual type of the formal templateParameter, returning null if unknown.
	 */
	@Nullable Type get(@Nullable TemplateParameter templateParameter);

	/**
	 * Return true if there are no formal TemplateParameters with actual values.
	 */
	boolean isEmpty();

	/**
	 * Install actualType as the resolutions of formalTemplateParameter, returning the highest common type of actualType
	 * and any pre-existing resolution.
	 */
	@NonNull Type put(@NonNull TemplateParameter formalTemplateParameter, @NonNull Type actualType);

	public static final @NonNull TemplateParameterSubstitutions EMPTY = new Empty();

	public static class Empty implements TemplateParameterSubstitutions
	{
		@Override
		public @Nullable Type get(@Nullable TemplateParameter templateParameter) {
			return null;
		}

		@Override
		public boolean isEmpty() {
			return true;
		}

		@Override
		public @NonNull Type put(@NonNull TemplateParameter formalTemplateParameter, @NonNull Type actualType) {
			return actualType;
		}

		@Override
		public String toString() {
			return "{}";
		}
	}
}
