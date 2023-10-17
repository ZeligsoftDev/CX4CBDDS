/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.labels;

import org.eclipse.jdt.annotation.NonNull;

public abstract class AbstractLabelGenerator<T> implements ILabelGenerator<T>
{
	protected final @NonNull Class<? extends T> labelledClass;
	
	protected AbstractLabelGenerator(@NonNull Class<? extends T> labelledClass) {
		this.labelledClass = labelledClass;
	}

	public @NonNull Class<? extends T> getLabelledClass() {
		return labelledClass;
	}
}