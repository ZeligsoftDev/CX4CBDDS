/*******************************************************************************
 * Copyright (c) 2011, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.ecore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPackage;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class EcoreReflectivePackage extends ExecutorPackage
{
	protected final @NonNull IdResolver idResolver;
//	protected final @NonNull ExecutorStandardLibrary standardLibrary;
	protected final EPackage ePackage;
	protected @Nullable Map<EClassifier, org.eclipse.ocl.pivot.Class> types = null;
	protected @Nullable Map<String, EcoreReflectivePackage> nestedPackages = null;

	public EcoreReflectivePackage(@NonNull EPackage ePackage, @NonNull IdResolver idResolver, @NonNull PackageId packageId) {
		super(ClassUtil.nonNullEMF(ePackage.getName()), ePackage.getNsPrefix(), ePackage.getNsURI(), packageId);
		this.idResolver = idResolver;
//		this.standardLibrary = idResolver.getStandardLibrary();
		this.ePackage = ePackage;
	}

	protected synchronized @NonNull Map<EClassifier, org.eclipse.ocl.pivot.Class> computeClasses() {
		Map<EClassifier, org.eclipse.ocl.pivot.Class> types2 = types = new HashMap<EClassifier, org.eclipse.ocl.pivot.Class>();
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier != null) {
				org.eclipse.ocl.pivot.Class executorType;
				if (eClassifier instanceof EEnum) {
					executorType = new EcoreReflectiveEnumeration(this, 0, (EEnum)eClassifier);
				}
				else {
					executorType = new EcoreReflectiveType(this, 0, eClassifier);
				}
				types2.put(eClassifier, executorType);
			}
		}
		return types2;
	}

//	@Override
//	protected @NonNull DomainInheritance createExecutorType(@NonNull DomainType domainType) {
//		throw new UnsupportedOperationException();		// FIXME
//	}

//	@Override
//	protected @NonNull Iterable<? extends DomainType> getDomainTypes() {
//		throw new UnsupportedOperationException();		// FIXME
//	}

	@Override
	public EObject getESObject() {
		return ePackage;
	}

	public @NonNull IdResolver getIdResolver() {
		return idResolver;
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Package> getOwnedPackages() {
		Map<String, EcoreReflectivePackage> nestedPackages2 = nestedPackages;
		if (nestedPackages2 == null) {
			nestedPackages = nestedPackages2 = new HashMap<String, EcoreReflectivePackage>();
			for (EPackage eSubPackage : ePackage.getESubpackages()) {
				if (eSubPackage != null) {
					PackageId subPackageId = IdManager.getPackageId(eSubPackage);
					EcoreReflectivePackage executorPackage = new EcoreReflectivePackage(eSubPackage, idResolver, subPackageId);
					nestedPackages2.put(eSubPackage.getName(), executorPackage);
				}
			}
		}
		return new ArrayList<org.eclipse.ocl.pivot.Package>(nestedPackages2.values());
	}

	@Override
	public org.eclipse.ocl.pivot.Package getOwningPackage() {
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Class> getOwnedClasses() {
		Map<EClassifier, org.eclipse.ocl.pivot.Class> types2 = types;
		if (types2 == null) {
			types2 = computeClasses();
		}
		List<org.eclipse.ocl.pivot.Class> values2 = new ArrayList<org.eclipse.ocl.pivot.Class>(types2.values());
		return values2;
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return idResolver.getStandardLibrary();
	}
}
