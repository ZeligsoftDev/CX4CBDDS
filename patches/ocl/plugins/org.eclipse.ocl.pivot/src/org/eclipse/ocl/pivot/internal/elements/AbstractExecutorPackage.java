/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.elements;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.InstanceSpecification;
import org.eclipse.ocl.pivot.ProfileApplication;
import org.eclipse.ocl.pivot.ids.PackageId;

public abstract class AbstractExecutorPackage extends AbstractExecutorNamedElement implements org.eclipse.ocl.pivot.Package
{
	public AbstractExecutorPackage(@NonNull String name) {
		super(name);
	}

	@Override
	@NonNull
	public List<Constraint> getOwnedConstraints() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<org.eclipse.ocl.pivot.Package> getOwnedPackages() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getNsPrefix() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setNsPrefix(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getURI() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setURI(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<InstanceSpecification> getOwnedInstances() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<org.eclipse.ocl.pivot.Package> getImportedPackages() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<org.eclipse.ocl.pivot.Class> getOwnedClasses() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<ProfileApplication> getOwnedProfileApplications() {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.Package getOwningPackage() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwningPackage(org.eclipse.ocl.pivot.Package value) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Nullable
	public EPackage getEPackage() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public PackageId getPackageId() {
		throw new UnsupportedOperationException();
	}
}