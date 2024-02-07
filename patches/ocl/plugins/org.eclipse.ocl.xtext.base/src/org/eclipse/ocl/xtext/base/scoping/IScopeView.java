/*******************************************************************************
 * Copyright (c) 2012, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.scoping;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.xtext.scoping.IScope;

/**
 * An IScopeView merges the Pivot ScopeView access with the Xtext IScope access to provide
 * an Xtext compliant scope that has the required access-from context for pivot
 * resolution.
 */
public interface IScopeView extends ScopeView, IScope
{
	@Override
	@NonNull IScopeView getParent();

	@Override
	@NonNull IScopeView getRoot();
}