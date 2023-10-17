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
package org.eclipse.ocl.pivot.internal.library.executor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * A ReflectivePackage builds a dispatch table representative of a model package at run-time using a minimal reflective API.
 */
public abstract class ReflectivePackage extends ExecutorPackage
{
	protected @Nullable Map<org.eclipse.ocl.pivot.Class, CompleteInheritance> class2inheritance = null;

	public ReflectivePackage(@NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId) {
		super(name, nsPrefix, nsURI, packageId);
	}
	
	protected synchronized @NonNull Map<org.eclipse.ocl.pivot.Class, CompleteInheritance> computeClasses() {
		Map<org.eclipse.ocl.pivot.Class, CompleteInheritance> class2inheritance2 = class2inheritance = new HashMap<org.eclipse.ocl.pivot.Class, CompleteInheritance>();
		for (org.eclipse.ocl.pivot.Class domainClass : getDomainClasses()) {
			if (domainClass != null) {
				CompleteInheritance executorType = createInheritance(domainClass);
				class2inheritance2.put(domainClass, executorType);
			}
		}
		return class2inheritance2;
	}

	protected abstract @NonNull CompleteInheritance createInheritance(org.eclipse.ocl.pivot.@NonNull Class domainClass);

	protected abstract @NonNull List<org.eclipse.ocl.pivot.Class> getDomainClasses();

	public @NonNull CompleteInheritance getInheritance(org.eclipse.ocl.pivot.@NonNull Class domainClass) {
		Map<org.eclipse.ocl.pivot.Class, CompleteInheritance> class2inheritance2 = class2inheritance;
		if (class2inheritance2 == null) {
			class2inheritance2 = computeClasses();
		}
		return ClassUtil.nonNullState(class2inheritance2.get(domainClass));
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Class> getOwnedClasses() {
/*		Map<org.eclipse.ocl.pivot.Class, DomainInheritance> types2 = class2inheritance;
		if (types2 == null) {
			types2 = computeClasses();
		}
		List<DomainInheritance> values2 = new ArrayList<DomainInheritance>(types2.values());
		return values2; */
		return getDomainClasses();
	}

	protected abstract @NonNull StandardLibrary getStandardLibrary();
}