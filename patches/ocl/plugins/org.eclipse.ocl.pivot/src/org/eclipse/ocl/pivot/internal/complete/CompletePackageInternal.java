/**
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.internal.complete;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompletePackage;

public interface CompletePackageInternal extends CompletePackage
{
	@Override
	@NonNull CompleteClassInternal getCompleteClass(org.eclipse.ocl.pivot.@NonNull Class pivotType);
	@NonNull CompleteInheritanceImpl getCompleteInheritance(@NonNull CompleteClassInternal completeClass);
	@Override
	@NonNull CompleteModelInternal getCompleteModel();
	void dispose();
	@Override
	CompleteClassInternal getOwnedCompleteClass(String name);
	@Override
	@Nullable CompletePackageInternal getOwnedCompletePackage(@Nullable String name);
	@Override
	@NonNull PartialPackages getPartialPackages();
	@NonNull CompletePackageInternal getRootCompletePackage();
	void init(String name, @Nullable String nsPrefix, @Nullable String nsURI);
}
