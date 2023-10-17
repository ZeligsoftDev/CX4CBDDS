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
package org.eclipse.ocl.pivot.internal.scoping;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A ScopeFilter is initially used to reject unwanted name contributions from a scope.
 */
public interface ScopeFilter
{
	/**
	 * Return true if the filter accepts eObject as a candidate for
	 * inclusion in the EnvironmentView.
	 */
	boolean matches(@NonNull EnvironmentView environmentView,  @NonNull Object object);
}
