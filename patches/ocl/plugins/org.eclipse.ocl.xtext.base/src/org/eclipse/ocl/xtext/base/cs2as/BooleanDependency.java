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
package org.eclipse.ocl.xtext.base.cs2as;

import org.eclipse.jdt.annotation.NonNull;

public class BooleanDependency extends AbstractDependency<@NonNull Object>
{
	private Boolean satisfied = false;

	public BooleanDependency(@NonNull String description) {
		super(description);
	}

	@Override
	public boolean canExecute() {
		return satisfied;
	}

	public void setSatisfied() {
		satisfied = true;
	}
}