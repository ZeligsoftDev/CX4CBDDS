/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.elements.AbstractExecutorClass;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * JavaType supports the usage of Java Class to define the type of an object.
 */
public class JavaType extends AbstractExecutorClass
{
	protected final @NonNull Class<?> javaClass;
	
	public JavaType(@NonNull Class<?> javaClass) {
		super(ClassUtil.nonNullState(javaClass.getName()), 0);
		this.javaClass = javaClass;
	}

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type thatType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getCommonType(@NonNull IdResolver idResolver, @NonNull Type type) {
		if (this == type) {
			return this;
		}
		if (!(type instanceof JavaType)) {
			return idResolver.getStandardLibrary().getOclAnyType();
		}
		Class<?> commonClass = getCommonClass1(javaClass, ((JavaType)type).javaClass);
		if (commonClass != null) {
			return idResolver.getJavaType(commonClass);
		}
		else {
			return idResolver.getStandardLibrary().getOclAnyType();
		}
	}
	private static @Nullable Class<?> getCommonClass1(@NonNull Class<?> thisClass, @NonNull Class<?> thatClass) {
		Class<?> commonClass = getCommonClass2(thisClass, thatClass);
		if (commonClass != null) {
			return commonClass;
		}
		Class<?> superclass = thisClass.getSuperclass();
		if (superclass != null) {
			commonClass = getCommonClass1(superclass, thatClass);
			if (commonClass != null) {
				return commonClass;
			}
		}
		for (Class<?> superInterface : thisClass.getInterfaces()) {
			if (superInterface != null) {
				commonClass = getCommonClass1(superInterface, thatClass);
				if (commonClass != null) {
					return commonClass;
				}
			}
		}
		return null;
	}
	private static @Nullable Class<?> getCommonClass2(@NonNull Class<?> thisClass, @NonNull Class<?> thatClass) {
		if (thisClass == thatClass) {
			return thisClass;
		}
		Class<?> superclass = thatClass.getSuperclass();
		if (superclass != null) {
			Class<?> commonClass = getCommonClass2(thisClass, superclass);
			if (commonClass != null) {
				return commonClass;
			}
		}
		for (Class<?> superInterface : thatClass.getInterfaces()) {
			if (superInterface != null) {
				Class<?> commonClass = getCommonClass2(thisClass, superInterface);
				if (commonClass != null) {
					return commonClass;
				}
			}
		}
		return null;
	}
	
	@Override
	public @NonNull CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary) {
		if (Comparable.class.isAssignableFrom(javaClass)) {
			return standardLibrary.getOclComparableType().getInheritance(standardLibrary);
		}
		else {
			return standardLibrary.getOclAnyType().getInheritance(standardLibrary);
		}
	}

	@Override
	@NonNull
	public TypeId getTypeId() {
		throw new UnsupportedOperationException();
//		return TypeId.OCL_VOID;
	}

	@Override
	public boolean isEqualTo(@NonNull StandardLibrary standardLibrary, @NonNull Type thatType) {
		return this == thatType;
	}

	@Override
	public @NonNull Operation lookupActualOperation(@NonNull StandardLibrary standardLibrary, @NonNull Operation apparentOperation) {
		CompleteInheritance inheritance = getInheritance(standardLibrary);
		return inheritance.lookupActualOperation(standardLibrary, apparentOperation);
	}

	@Override
	@NonNull
	public LibraryFeature lookupImplementation(@NonNull StandardLibrary standardLibrary, @NonNull Operation apparentOperation) {
		CompleteInheritance inheritance = standardLibrary.getInheritance(standardLibrary.getOclAnyType());
		return inheritance.lookupImplementation(standardLibrary, apparentOperation);
	}

	@Override
	public String toString() {
		return getName();
	}
}
