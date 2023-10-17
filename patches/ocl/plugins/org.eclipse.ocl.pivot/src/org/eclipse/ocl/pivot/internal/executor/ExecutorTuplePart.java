/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.elements.AbstractExecutorTypedElement;

public class ExecutorTuplePart extends AbstractExecutorTypedElement
{
	public ExecutorTuplePart(@NonNull Type type, @NonNull String name) {
		super(name, type);
	}

	@Override
	public String toString() {
		return String.valueOf(name) + " : " + String.valueOf(type); //$NON-NLS-1$
	}
}