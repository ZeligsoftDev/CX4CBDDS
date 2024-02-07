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
package org.eclipse.ocl.pivot.library;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.StandardLibrary;

/**
 * The LibraryValidator defines the behaviour of library-feature-specific validators. An
 * implementation is typically constructed reflectively and return by the library-feature
 * implementation class. Reflective construction is used to avoid the need for evaluation
 * code to depend on the analysis time pivot support.
 */
public interface LibraryValidator
{
	@Nullable Diagnostic validate(@NonNull StandardLibrary standardLibrary, @NonNull CallExp callExp);
}
