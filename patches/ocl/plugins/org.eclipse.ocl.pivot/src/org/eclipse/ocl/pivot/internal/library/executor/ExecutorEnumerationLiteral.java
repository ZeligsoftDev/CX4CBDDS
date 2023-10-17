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
package org.eclipse.ocl.pivot.internal.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.ids.EnumerationLiteralId;
import org.eclipse.ocl.pivot.internal.elements.AbstractExecutorEnumerationLiteral;

public abstract class ExecutorEnumerationLiteral extends AbstractExecutorEnumerationLiteral
{
	protected final @NonNull Enumeration enumeration;
	protected final int ordinal;
	
	public ExecutorEnumerationLiteral(@NonNull String name, @NonNull Enumeration enumeration, int ordinal) {
		super(name);
		this.enumeration = enumeration;
		this.ordinal = ordinal;
	}

	@Override
	public @NonNull Enumeration getOwningEnumeration() {
		return enumeration;
	}

	@Override
	public @NonNull EnumerationLiteralId getEnumerationLiteralId() {
		return enumeration.getEnumerationId().getEnumerationLiteralId(name);
	}
	
	@Override
	public String toString() {
		return String.valueOf(enumeration) + "::" + String.valueOf(name); //$NON-NLS-1$
	}
}