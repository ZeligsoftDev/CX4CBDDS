/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 * how and when to use it
 *
 */
public class BaseScopeProvider extends AbstractDeclarativeScopeProvider
{
	public static final @NonNull TracingOption LOOKUP = new TracingOption("org.eclipse.ocl.xtext.base", "lookup"); //$NON-NLS-1$//$NON-NLS-2$

	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (reference == null) {
			return IScope.NULLSCOPE;
		}
		if (!(context instanceof ElementCS)) {
			return IScope.NULLSCOPE;
		}
		Resource csResource = context.eResource();
		if (!(csResource instanceof BaseCSResource)) {
			return IScope.NULLSCOPE;
		}
		CS2AS cs2as = ((BaseCSResource)csResource).getCS2AS();
		EnvironmentFactoryInternal environmentFactory = cs2as.getEnvironmentFactory();
		return BaseScopeView.getScopeView(environmentFactory, (ElementCS) context, reference);
	}
}
