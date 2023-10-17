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
import org.eclipse.ocl.pivot.ids.IdHash;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.NestedPackageId;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.SingletonScope.AbstractKeyAndValue;

public class NestedPackageIdImpl extends AbstractPackageIdImpl implements NestedPackageId
{
	private static class NestedPackageIdValue extends AbstractKeyAndValue<@NonNull NestedPackageId>
	{
		private final @NonNull PackageId parentId;
		private final @NonNull String value;

		private NestedPackageIdValue(@NonNull PackageId parentId, @NonNull String value) {
			super(computeHashCode(parentId, value));
			this.parentId = parentId;
			this.value = value;
		}

		@Override
		public @NonNull NestedPackageId createSingleton() {
			return new NestedPackageIdImpl(parentId, value);
		}

		@Override
		public boolean equals(@Nullable Object that) {
			if (that instanceof NestedPackageIdImpl) {
				NestedPackageIdImpl singleton = (NestedPackageIdImpl)that;
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
	public static class NestedPackageIdSingletonScope extends AbstractSingletonScope<@NonNull NestedPackageId, @NonNull String>
	{
		public @NonNull NestedPackageId getSingleton(@NonNull PackageId parentId, @NonNull String value) {
			return getSingletonFor(new NestedPackageIdValue(parentId, value));
		}
	}

	private static int computeHashCode(@NonNull ElementId parentId, @NonNull String name) {
		return IdHash.createChildHash(parentId, name);
	}

	protected final @NonNull PackageId parent;
	protected final @NonNull String name;

	/**
	 * @since 1.18
	 */
	public NestedPackageIdImpl(@NonNull PackageId parent, @NonNull String name) {
		super(computeHashCode(parent, name));
		this.parent = parent;
		this.name = name;
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitNestedPackageId(this);
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
	public @NonNull String getName() {
		return name;
	}

	@Override
	public @NonNull PackageId getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return parent + "::" + name;
	}
}