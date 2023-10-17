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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;

import com.google.common.collect.Lists;

public class EcoreExecutorPackage extends ExecutorPackage
{
	protected final EPackage ePackage;
	private ExecutorStandardLibrary standardLibrary = null;
	private @NonNull ExecutorType[] types = null;
	private @Nullable List<org.eclipse.ocl.pivot.Package> packages = null;

	public EcoreExecutorPackage(/*@NonNull*/ EPackage ePackage) {
		super(ClassUtil.nonNullEMF(ePackage.getName()), ePackage.getNsPrefix(), ePackage.getNsURI(), IdManager.getPackageId(ePackage));
		this.ePackage = ePackage;
	}

	public EcoreExecutorPackage(/*@NonNull*/ EPackage ePackage, @NonNull PackageId packageId) {
		super(ClassUtil.nonNullEMF(ePackage.getName()), ePackage.getNsPrefix(), ePackage.getNsURI(), packageId);
		this.ePackage = ePackage;
	}

	@Override
	public final EPackage getEPackage() {
		return ePackage;
	}

	@Override
	public EObject getESObject() {
		return ePackage;
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Package> getOwnedPackages() {
		List<org.eclipse.ocl.pivot.Package> packages2 = packages;
		if (packages2 == null) {
			synchronized (this) {
				packages2 = packages;
				if (packages2 == null) {
					packages2 = packages = new ArrayList<org.eclipse.ocl.pivot.Package>();
					for (EPackage eSubPackage : ePackage.getESubpackages()) {
						assert eSubPackage != null;
						EcoreExecutorPackage subPackage = standardLibrary.getPackage(eSubPackage);
						if (subPackage != null) {
							packages2.add(subPackage);
						}
					}
				}
			}
		}
		return packages2;
	}

	@Override
	public org.eclipse.ocl.pivot.Package getOwningPackage() {
		EPackage eSuperPackage = ePackage.getESuperPackage();
		if (eSuperPackage == null) {
			return null;
		}
		return standardLibrary.getPackage(eSuperPackage);
	}

	@Override
	public @NonNull List<org.eclipse.ocl.pivot.Class> getOwnedClasses() {
		if (types != null) {
			return Lists.<org.eclipse.ocl.pivot.Class>newArrayList(types);
		}
		else {
			return Collections.emptyList();
		}
	}

	@Override
	public @Nullable ExecutorType getOwnedClass(String typeName) {
		int index = Arrays.binarySearch(types, new StringNameable(typeName), NameUtil.NameableComparator.INSTANCE);
		if (index >= 0) {
			return types[index];
		}
		//	Should be sorted, but do linear search just in case
		for (org.eclipse.ocl.pivot.@NonNull Class type : types) {
			if (type.getName().equals(typeName)) {
				return (ExecutorType) type;
			}
		}
		return null;
	}

	public void init(@Nullable ExecutorStandardLibrary standardLibrary, @NonNull ExecutorType @NonNull [] types) {
		assert this.standardLibrary == null;
		assert this.types == null;
		this.standardLibrary = standardLibrary;
		this.types = types;
		if (standardLibrary != null) {
			standardLibrary.addPackage(this, null);
		}
	}

	/*	public void init2(EcoreExecutorPackage execPackage, ExecutorType[] types) {
		ExecutorStandardLibrary standardLibrary = execPackage.standardLibrary;
		assert this.standardLibrary == null;
		assert this.types == null;
		this.standardLibrary = standardLibrary;
		this.types = types;
		if (standardLibrary != null) {
			standardLibrary.addPackage(this, execPackage);
		}
	} */

	//	public ExecutorType lookupType(int classIndex) {
	//		return types[classIndex];
	//	}
}