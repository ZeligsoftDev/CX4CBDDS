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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Stereotype;

/**
 * Ann AbstractAttribution provides the basic behaviour for a family of derived
 * classes that provide additional scope/environment behaviour for corresponding
 * CS elements.
 */
public abstract class AbstractAttribution implements Attribution
{
	/**
	 * @since 1.18
	 */
	public static final @NonNull ScopeFilter NOT_STATIC_SCOPE_FILTER = new ScopeFilter()
	{
		@Override
		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			return (object instanceof Feature) && !((Feature)object).isIsStatic();
		}
	};

	/**
	 * @since 1.5
	 */
	protected static final @NonNull ScopeFilter STATIC_SCOPE_FILTER = new ScopeFilter()
	{
		@Override
		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			return (object instanceof Feature) && ((Feature)object).isIsStatic();
		}
	};

	/**
	 * @since 1.18
	 */
	public static final @NonNull ScopeFilter EXTENSION_SCOPE_FILTER = new ScopeFilter()
	{
		@Override
		public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
			return (object instanceof Property) && (((Property)object).getType() instanceof Stereotype);
		}
	};

	@Override
	public @Nullable ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		return scopeView.getParent();
	}
}
