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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.types.AbstractFragment;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

import com.google.common.collect.Lists;

/**
 * An ExecutorFragment provides the description of the properties and operations defined by some class when accessed by the same
 * or another class. The descriptions are normally built by direct static construction from auto-generated code, with instnaces defined
 * in isolation during construction then cross-references defined later by calls to init().
 */
public class ExecutorFragment extends AbstractFragment
{
	private @NonNull ExecutorOperation[] operations;
	private @NonNull ExecutorProperty[] properties;

	public ExecutorFragment(@NonNull ExecutorType derivedInheritance, @NonNull CompleteInheritance baseInheritance) {
		super(derivedInheritance, baseInheritance);
		this.operations = null;
		this.properties = null;
	}

	@Override
	public @NonNull LibraryFeature getImplementation(@NonNull Operation staticOperation) {
		int index = staticOperation.getIndex();
		if (index >= 0) {
			return ClassUtil.nonNullState(operations[index].implementation);
		}
		else {
			throw new UnsupportedOperationException();		// WIP
		}
	}

	@Override
	public @Nullable Operation getLocalOperation(@NonNull Operation staticOperation) {
		int index = staticOperation.getIndex();
		if (index >= 0) {
			return operations[index];
		}
		else {
			return null;
		}
	}

	@Override
	public @NonNull List<@NonNull Operation> getLocalOperations() {
		assert operations != null;
		return Lists.<@NonNull Operation>newArrayList(operations);
	}

	@Override
	public @NonNull List<@NonNull Property> getLocalProperties() {
		assert properties != null;
		return Lists.<@NonNull Property>newArrayList(properties);
	}

	public @NonNull List<org.eclipse.ocl.pivot.@NonNull Class> getSuperClasses() {
		throw new UnsupportedOperationException();		// WIP
	}

	public void initOperations(@NonNull ExecutorOperation @NonNull [] operations) {
		assert this.operations == null;
		this.operations = operations;
	}

	public void initProperties(@NonNull ExecutorProperty @NonNull [] properties) {
		assert this.properties == null;
		this.properties = properties;
	}
}