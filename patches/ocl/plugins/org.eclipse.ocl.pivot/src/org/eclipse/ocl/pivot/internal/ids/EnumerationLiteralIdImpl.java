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
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.EnumerationLiteralId;
import org.eclipse.ocl.pivot.ids.IdHash;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.SingletonScope.AbstractKeyAndValue;
import org.eclipse.ocl.pivot.ids.TypeId;

public class EnumerationLiteralIdImpl extends UnscopedId implements EnumerationLiteralId
{
	private static class EnumerationLiteralIdValue extends AbstractKeyAndValue<@NonNull EnumerationLiteralId>
	{
		private final @NonNull EnumerationId parentId;
		private final @NonNull String value;

		private EnumerationLiteralIdValue(@NonNull EnumerationId parentId, @NonNull String value) {
			super(EnumerationLiteralIdImpl.computeHashCode(parentId, value));
			this.parentId = parentId;
			this.value = value;
		}

		@Override
		public @NonNull EnumerationLiteralId createSingleton() {
			return new EnumerationLiteralIdImpl(parentId, value);
		}

		@Override
		public boolean equals(@Nullable Object that) {
			if (that instanceof EnumerationLiteralIdImpl) {
				EnumerationLiteralIdImpl singleton = (EnumerationLiteralIdImpl)that;
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
	public static class EnumerationLiteralIdSingletonScope extends AbstractSingletonScope<@NonNull EnumerationLiteralId, @NonNull String>
	{
		public @NonNull EnumerationLiteralId getSingleton(@NonNull EnumerationId parentId, @NonNull String value) {
			return getSingletonFor(new EnumerationLiteralIdValue(parentId, value));
		}
	}

	private static int computeHashCode(@NonNull EnumerationId parentId, @NonNull String name) {
		return IdHash.createChildHash(parentId, name);
	}

	protected final @NonNull EnumerationId parentId;

	public EnumerationLiteralIdImpl(@NonNull EnumerationId parentId, @NonNull String name) {
		super(computeHashCode(parentId, name), name);
		this.parentId = parentId;
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitEnumerationLiteralId(this);
	}

	@Override
	public @NonNull String getDisplayName() {
		return parentId + "::" + name;
	}

	@Override public @NonNull String getMetaTypeName() {
		return TypeId.ENUMERATION_NAME;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public @NonNull EnumerationId getParentId() {
		return parentId;
	}
}