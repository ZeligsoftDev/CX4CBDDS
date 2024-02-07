/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
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


public class NullAttribution extends AbstractAttribution
{
	public static final @NonNull NullAttribution INSTANCE = new NullAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		throw new UnsupportedOperationException("NullAttribution");
	}
}
