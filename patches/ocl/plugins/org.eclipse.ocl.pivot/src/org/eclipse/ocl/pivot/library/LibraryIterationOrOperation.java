/*******************************************************************************
 * Copyright (c) 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;

/**
 * @since 1.18
 */
public interface LibraryIterationOrOperation extends LibraryFeature
{
	/**
	 * Return the actual type of te body of callExp for which the regular library modeling suggests bodyType.
	 *
	 * The default implementation just returns bodyType.
	 */
	default @Nullable Type resolveBodyType(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp, @Nullable Type bodyType) {
		return bodyType;
	}

	/**
	 * Return the actual return nullity of callExp for which the regular library modeling suggests returnIsRequired.
	 *
	 * The default implementation just returns returnIsRequired.
	 */
	default boolean resolveReturnNullity(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp, boolean returnIsRequired) {
		return returnIsRequired;
	}

	/**
	 * Return the actual return type of callExp for which the regular library modeling suggests returnType.
	 *
	 * The default implementation just returns returnType.
	 */
	default @Nullable Type resolveReturnType(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp, @Nullable Type returnType) {
		return returnType;
	}

	/**
	 * Return the statically determinate result of callExp or null if unkown or too complicated.
	 * </br>
	 * This is currently used to obsolete the typeof declarations in OCL.2.5.oclstdlib.
	 * </br>
	 * It may evolve to a full constant folder.
	 *
	 * The default implementation just returns null for not known.
	 */
	default @Nullable Object resolveReturnValue(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp) {
		return null;
	}

	/**
	 * Add any templateParameter substitutions to templateParameterSubstitutions that the regular library modeling omits.
	 *
	 * The default implementation adds nothing. The intended usage for flatten where the input/output types are irregular.
	 */
	default void resolveUnmodeledTemplateParameterSubstitutions(@NonNull TemplateParameterSubstitutionVisitor templateParameterSubstitutions, @NonNull CallExp callExp) {}
}
