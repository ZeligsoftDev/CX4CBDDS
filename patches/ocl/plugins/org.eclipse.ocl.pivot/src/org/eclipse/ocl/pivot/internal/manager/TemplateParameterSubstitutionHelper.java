/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.manager;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.library.LibraryFeature;

/**
 * TemplateParameterSubstitutionHelper instances support irregular TemplateParameterSubstitution deduction for difficult to
 * model operations such as flatten().
 * <p>
 * The TemplateParameterSubstitutionHelper maintains a registry of helpers indexed by their implementation class.
 */
@Deprecated /* @deprecated all functionality moved to LibraryOperation */
public abstract class TemplateParameterSubstitutionHelper
{
	/**
	 * Add any templateParameter substitutions to templateParameterSubstitutions that the regular library modeling omits.
	 *
	 * THe default implementation adds nothing. The intended usage for flatten where the input/output types are irregular.
	 */
	public void resolveUnmodeledTemplateParameterSubstitutions(@NonNull TemplateParameterSubstitutionVisitor templateParameterSubstitutions, @NonNull CallExp callExp) {}

	/**
	 * Return the actual type of te body of callExp for which the regular library modeling suggests bodyType.
	 *
	 * The default implementation just returns bodyType.
	 */
	public @Nullable Type resolveBodyType(@NonNull PivotMetamodelManager metamodelManager, @NonNull CallExp callExp, @Nullable Type bodyType) {
		return bodyType;
	}

	/**
	 * Return the actual return nullity of callExp for which the regular library modeling suggests returnIsRequired.
	 *
	 * The default implementation just returns returnIsRequired.
	 * @since 1.3
	 */
	public boolean resolveReturnNullity(@NonNull PivotMetamodelManager metamodelManager, @NonNull CallExp callExp, boolean returnIsRequired) {
		return returnIsRequired;
	}

	/**
	 * Return the actual return type of callExp for which the regular library modeling suggests returnType.
	 *
	 * The default implementation just returns returnType.
	 */
	public @Nullable Type resolveReturnType(@NonNull PivotMetamodelManager metamodelManager, @NonNull CallExp callExp, @Nullable Type returnType) {
		return returnType;
	}

	public static void addHelper(@NonNull Class<? extends LibraryFeature> className, @NonNull TemplateParameterSubstitutionHelper helper) {
	}

	public static @Nullable TemplateParameterSubstitutionHelper getHelper(@NonNull Class<? extends LibraryFeature> className) {
		return null;
	}
}