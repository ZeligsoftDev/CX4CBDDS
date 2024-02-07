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
package org.eclipse.ocl.pivot.internal.delegate;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface DelegatedBehavior<E, R, F>
{
	@Nullable F getDefaultFactory();
	
	@NonNull R getDefaultRegistry();
	
	@NonNull EPackage getEPackage(@NonNull E eObject);
	
	@NonNull List<F> getFactories(@NonNull E eObject);
	
	@Nullable F getFactory(@NonNull E eObject);
	
	@NonNull Class<? extends F> getFactoryClass();

	@NonNull String getName();
	
	@NonNull Class<? extends R> getRegistryClass();

	void setDelegates(@NonNull EPackage ePackage, @NonNull List<String> delegateURIs);
}