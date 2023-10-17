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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * DomainExecutorPackage uses the limited Domain interfaces to construct a package description for use
 * in contexts where no explicit ExecutorPackage is available.
 * 
 * This typically occurs when a dynamic Ecore model is used but no MetamodelManager is accessible.
 */
public class DomainReflectivePackage extends ReflectivePackage
{
	protected final @NonNull StandardLibrary standardLibrary;
	protected final org.eclipse.ocl.pivot.@NonNull Package domainPackage;

	public DomainReflectivePackage(@NonNull StandardLibrary standardLibrary, org.eclipse.ocl.pivot.@NonNull Package domainPackage) {
		super(ClassUtil.nonNullPivot(domainPackage.getName()), domainPackage.getNsPrefix(), domainPackage.getURI(), domainPackage.getPackageId());
		this.standardLibrary = standardLibrary;
		this.domainPackage = domainPackage;
	}

	@Override
	protected @NonNull ReflectiveInheritance createInheritance(org.eclipse.ocl.pivot.@NonNull Class domainClass) {
		return new DomainReflectiveType(this, domainClass);
	}

	@Override
	protected @NonNull List<org.eclipse.ocl.pivot.Class> getDomainClasses() {
		return ClassUtil.nonNullPivot(domainPackage.getOwnedClasses());
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Package> getOwnedPackages() {
		return domainPackage.getOwnedPackages();			// FIXME Is this recursive??
	}

	@Override
	public org.eclipse.ocl.pivot.Package getOwningPackage() {
		return domainPackage.getOwningPackage();			// FIXME Is this recursive??
	}

	@Override
	public @NonNull PackageId getPackageId() {
		return domainPackage.getPackageId();
	}
	
	@Override
	protected @NonNull StandardLibrary getStandardLibrary() {
		return standardLibrary;
	}
}