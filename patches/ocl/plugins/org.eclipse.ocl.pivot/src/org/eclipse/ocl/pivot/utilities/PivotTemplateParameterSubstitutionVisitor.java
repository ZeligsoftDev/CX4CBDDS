/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;

/**
 * @since 1.1
 * @noextend This class is not intended to be subclassed by clients. It is part of the hierarchy for auto-generated visitors.
 */
public class PivotTemplateParameterSubstitutionVisitor extends TemplateParameterSubstitutionVisitor {

	public PivotTemplateParameterSubstitutionVisitor(@NonNull EnvironmentFactoryInternal environmentFactory, @Nullable Type selfType, @Nullable Type selfTypeValue) {
		super(environmentFactory, selfType, null);
		// assert selfTypeValue == null;			// Bug 580791 Enforcing redundant argument
	}
}
