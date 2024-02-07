/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.AbstractSingletonScope;
import org.eclipse.ocl.pivot.ids.IdHash;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.PrimitiveTypeId;
import org.eclipse.ocl.pivot.ids.SingletonScope.AbstractKeyAndValue;
import org.eclipse.ocl.pivot.ids.TypeId;

public class PrimitiveTypeIdImpl extends UnscopedId implements PrimitiveTypeId
{
	private static class PrimitiveTypeIdValue extends AbstractKeyAndValue<@NonNull PrimitiveTypeId>
	{
		private final @NonNull IdManager idManager;
		private final @NonNull String value;

		private PrimitiveTypeIdValue(@NonNull IdManager idManager, @NonNull String value) {
			super(computeHashCode(value));
			this.idManager = idManager;
			this.value = value;
		}

		@Override
		public @NonNull PrimitiveTypeId createSingleton() {
			return new PrimitiveTypeIdImpl(idManager, value);
		}

		@Override
		public boolean equals(@Nullable Object that) {
			if (that instanceof PrimitiveTypeIdImpl) {
				PrimitiveTypeIdImpl singleton = (PrimitiveTypeIdImpl)that;
				return singleton.getName().equals(value);
			}
			else {
				return false;
			}
		}
	}

	/**
	 * @since 1.18
	 */
	public static class PrimitiveTypeIdSingletonScope extends AbstractSingletonScope<@NonNull PrimitiveTypeId, @NonNull String>
	{
		public @NonNull PrimitiveTypeId getSingleton(@NonNull IdManager idManager, @NonNull String value) {
			return getSingletonFor(new PrimitiveTypeIdValue(idManager, value));
		}
	}

	private static int computeHashCode(@NonNull String name) {
		return IdHash.createGlobalHash(PrimitiveTypeId.class, name);
	}

	public PrimitiveTypeIdImpl(@NonNull IdManager idManager, @NonNull String name) {
		super(computeHashCode(name), name);
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitPrimitiveTypeId(this);
	}

	@Override
	public @Nullable String getLiteralName() {
		if (this == TypeId.BOOLEAN) {
			return "BOOLEAN";
		}
		else if (this == TypeId.INTEGER) {
			return "INTEGER";
		}
		else if (this == TypeId.INTEGER_RANGE) {
			return "INTEGER_RANGE";
		}
		else if (this == TypeId.OCL_ANY) {
			return "OCL_ANY";
		}
		else if (this == TypeId.OCL_COMPARABLE) {
			return "OCL_COMPARABLE";
		}
		else if (this == TypeId.OCL_ENUMERATION) {
			return "OCL_ENUMERATION";
		}
		else if (this == TypeId.OCL_SELF) {
			return "OCL_SELF";
		}
		else if (this == TypeId.OCL_SUMMABLE) {
			return "OCL_SUMMABLE";
		}
		else if (this == TypeId.REAL) {
			return "REAL";
		}
		else if (this == TypeId.STRING) {
			return "STRING";
		}
		else if (this == TypeId.UNLIMITED_NATURAL) {
			return "UNLIMITED_NATURAL";
		}
		else {
			return null;
		}
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return PRIMITIVE_TYPE_NAME;
	}
}