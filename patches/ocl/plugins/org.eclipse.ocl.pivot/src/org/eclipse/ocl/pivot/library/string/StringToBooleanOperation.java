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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.library.AbstractSimpleUnaryOperation;

/**
 * StringToBooleanOperation realises the String::toBoolean() library operation.
 */
public class StringToBooleanOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull StringToBooleanOperation INSTANCE = new StringToBooleanOperation();

	@Override
	public @Nullable Boolean evaluate(@Nullable Object sourceVal) {
		String sourceString = asString(sourceVal);
		if ("true".equals(sourceString)) { //$NON-NLS-1$
			return Boolean.TRUE;
		}
		else if ("false".equals(sourceString)) { //$NON-NLS-1$
			return Boolean.FALSE;
		}
		else {
			return null;
		}
	}
}
