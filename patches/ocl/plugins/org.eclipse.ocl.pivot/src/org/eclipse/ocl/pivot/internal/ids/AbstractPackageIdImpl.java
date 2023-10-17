/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.NestedPackageId;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ids.EnumerationIdImpl.EnumerationIdSingletonScope;
import org.eclipse.ocl.pivot.internal.ids.GeneralizedClassIdImpl.ClassIdSingletonScope;
import org.eclipse.ocl.pivot.internal.ids.GeneralizedDataTypeIdImpl.DataTypeIdSingletonScope;
import org.eclipse.ocl.pivot.internal.ids.NestedPackageIdImpl.NestedPackageIdSingletonScope;

public abstract class AbstractPackageIdImpl extends AbstractElementId implements PackageId
{
	protected final @NonNull Integer hashCode;		// FIXME int

	/**
	 * Map from a nested class name to the corresponding ClassId.
	 */
	private @Nullable ClassIdSingletonScope classes = null;

	/**
	 * Map from a nested datatype name to the corresponding DataTypeId.
	 */
	private @Nullable DataTypeIdSingletonScope dataTypes = null;

	/**
	 * Map from a nested type name to the corresponding NestedTypeId.
	 */
	private @Nullable EnumerationIdSingletonScope enumerations = null;

	/**
	 * Map from a nested package name to the corresponding Nested PackageId.
	 */
	private @Nullable NestedPackageIdSingletonScope packages = null;

	protected AbstractPackageIdImpl(@NonNull Integer hashCode) {
		this.hashCode = hashCode;
	}

	/**
	 * @since 1.18
	 */
	protected AbstractPackageIdImpl(int hashCode) {
		this.hashCode = hashCode;
	}

	@Override
	public @NonNull ClassId getClassId(@NonNull String name, int templateParameters) {
		GeneralizedClassIdImpl.ClassIdSingletonScope classes2 = classes;
		if (classes2 == null) {
			synchronized (this) {
				classes2 = classes;
				if (classes2 == null) {
					classes = classes2 = new ClassIdSingletonScope();
				}
			}
		}
		return classes2.getSingleton(this, name, templateParameters);
	}

	@Override
	public @NonNull DataTypeId getDataTypeId(@NonNull String name, int templateParameters) {
		GeneralizedDataTypeIdImpl.DataTypeIdSingletonScope dataTypes2 = dataTypes;
		if (dataTypes2 == null) {
			synchronized (this) {
				dataTypes2 = dataTypes;
				if (dataTypes2 == null) {
					dataTypes = dataTypes2 = new DataTypeIdSingletonScope();
				}
			}
		}
		return dataTypes2.getSingleton(this, name, templateParameters);
	}

	@Override
	public @NonNull EnumerationId getEnumerationId(@NonNull String name) {
		EnumerationIdSingletonScope enumerations2 = enumerations;
		if (enumerations2 == null) {
			synchronized (this) {
				enumerations2 = enumerations;
				if (enumerations2 == null) {
					enumerations = enumerations2 = new EnumerationIdSingletonScope();
				}
			}
		}
		return enumerations2.getSingleton(this, name);
	}

	public @NonNull String getMetaTypeName() {
		return TypeId.CLASS_NAME;
	}

	@Override
	public @NonNull NestedPackageId getNestedPackageId(@NonNull String name) {
		NestedPackageIdSingletonScope packages2 = packages;
		if (packages2 == null) {
			synchronized (this) {
				packages2 = packages;
				if (packages2 == null) {
					packages = packages2 = new NestedPackageIdSingletonScope();
				}
			}
		}
		return packages2.getSingleton(this, name);
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}
}