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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.internal.elements.AbstractExecutorPackage;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;

public abstract class ExecutorPackage extends AbstractExecutorPackage
{
	public static final class StringNameable
	implements Nameable {

private final String typeName;

public StringNameable(String typeName) {
	this.typeName = typeName;
}

@Override
public String getName() {
	return typeName;
}
}

	protected final @Nullable String nsPrefix;
	protected final @Nullable String nsURI;
	protected final @NonNull PackageId packageId;

	protected ExecutorPackage(@NonNull String name, @Nullable String nsPrefix, @Nullable String nsURI, @NonNull PackageId packageId) {
		super(name);
		this.nsPrefix = nsPrefix;
		this.nsURI = nsURI;
		this.packageId = packageId;
	}

	@Override
	public @Nullable EPackage getEPackage() {
		return null;
	}

	public @NonNull ElementId getElementId() {
		return packageId;
	}

	@Override
	public final @Nullable String getNsPrefix() {
		return nsPrefix;
	}

	@Override
	public final @Nullable String getURI() {
		return nsURI;
	}

	@Override
	public @NonNull List<Constraint> getOwnedConstraints() {
		throw new UnsupportedOperationException();			// FIXME
	}
	
	@Override
	public abstract @NonNull List<org.eclipse.ocl.pivot.Class> getOwnedClasses();

	@Override
	public @NonNull PackageId getPackageId() {
		return packageId;
	}

	@Override
	public org.eclipse.ocl.pivot.@Nullable Class getOwnedClass(String typeName) {
		List<org.eclipse.ocl.pivot.Class> ownedClasses = getOwnedClasses();
		int index = Collections.binarySearch(ownedClasses, new StringNameable(typeName), NameUtil.NameableComparator.INSTANCE);
		if (index >= 0) {
			return ownedClasses.get(index);
		}
		//	Should be sorted, but do linear search just in case
		for (org.eclipse.ocl.pivot.Class type : ownedClasses) {
			if (type.getName().equals(typeName)) {
				return type;
			}
		}
		return null;
	}

//	public org.eclipse.ocl.pivot.Class getType(String typeName) {
//		for (org.eclipse.ocl.pivot.Class type: getOwnedClasses()) {
//			if (type.getName().equals(typeName)) {
//				return type;
//			}
//		}
//		return null;
//	}

	@Override
	public String toString() {
		return name;
	}
}