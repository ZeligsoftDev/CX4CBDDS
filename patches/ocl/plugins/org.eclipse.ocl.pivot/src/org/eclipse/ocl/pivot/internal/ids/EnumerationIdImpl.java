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
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.EnumerationLiteralId;
import org.eclipse.ocl.pivot.ids.IdHash;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.SingletonScope.AbstractKeyAndValue;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ids.EnumerationLiteralIdImpl.EnumerationLiteralIdSingletonScope;

public class EnumerationIdImpl extends AbstractTypeId implements EnumerationId
{
	private static class EnumerationIdValue extends AbstractKeyAndValue<@NonNull EnumerationId>
	{
		private final @NonNull PackageId parentId;
		private final @NonNull String value;

		private EnumerationIdValue(@NonNull PackageId parentId, @NonNull String value) {
			super(computeHashCode(parentId, value));
			this.parentId = parentId;
			this.value = value;
		}

		@Override
		public @NonNull EnumerationId createSingleton() {
			return new EnumerationIdImpl(parentId, value);
		}

		@Override
		public boolean equals(@Nullable Object that) {
			if (that instanceof EnumerationIdImpl) {
				EnumerationIdImpl singleton = (EnumerationIdImpl)that;
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
	public static class EnumerationIdSingletonScope extends AbstractSingletonScope<@NonNull EnumerationId, @NonNull String>
	{
		public @NonNull EnumerationId getSingleton(@NonNull PackageId parentId, @NonNull String value) {
			return getSingletonFor(new EnumerationIdValue(parentId, value));
		}
	}

	private static int computeHashCode(@NonNull ElementId parentId, @NonNull String name) {
		return IdHash.createChildHash(parentId, name);
	}

	protected final @NonNull PackageId parent;
	protected final @NonNull String name;
	protected final int hashCode;

	/**
	 * Map from a nested type name to the corresponding EnumerationLiteralId.
	 */
	private @Nullable EnumerationLiteralIdSingletonScope memberEnumerationLiterals = null;

	public EnumerationIdImpl(@NonNull PackageId parentId, @NonNull String name) {
		this.parent = parentId;
		this.name = name;
		this.hashCode = computeHashCode(parentId, name);
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitEnumerationId(this);
	}

	@Override
	public @NonNull String getDisplayName() {
		if (parent instanceof NsURIPackageId) {
			return name;
		}
		else {
			return parent + "::" + name;
		}
	}

	@Override
	public @NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull String name) {
		EnumerationLiteralIdSingletonScope memberEnumerationLiterals2 = memberEnumerationLiterals;
		if (memberEnumerationLiterals2 == null) {
			synchronized (this) {
				memberEnumerationLiterals2 = memberEnumerationLiterals;
				if (memberEnumerationLiterals2 == null) {
					memberEnumerationLiterals = memberEnumerationLiterals2 = new EnumerationLiteralIdSingletonScope();
				}
			}
		}
		return memberEnumerationLiterals2.getSingleton(this, name);
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return TypeId.ENUMERATION_NAME;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public @NonNull PackageId getParent() {
		return parent;
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}

	@Override
	public String toString() {
		return parent + "::" + name;
	}
}