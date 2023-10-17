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
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.SingletonScope.AbstractKeyAndValue;

public class RootPackageIdImpl extends AbstractPackageIdImpl implements RootPackageId
{
	private static class RootPackageIdValue extends AbstractKeyAndValue<@NonNull RootPackageId>
	{
		private final @NonNull IdManager idManager;
		private final @NonNull String value;

		public RootPackageIdValue(@NonNull IdManager idManager, @NonNull String value) {
			super(computeHashCode(value));
			this.idManager = idManager;
			this.value = value;
		}

		@Override
		public @NonNull RootPackageId createSingleton() {
			return new RootPackageIdImpl(idManager, value);
		}

		@Override
		public boolean equals(@Nullable Object that) {
			if (that instanceof RootPackageIdImpl) {
				RootPackageIdImpl singleton = (RootPackageIdImpl)that;
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
	public static class RootPackageIdSingletonScope extends AbstractSingletonScope<@NonNull RootPackageId, @NonNull String>
	{
		public @NonNull RootPackageId getSingleton(@NonNull IdManager idManager, @NonNull String value) {
			return getSingletonFor(new RootPackageIdValue(idManager, value));
		}
	}

	private static int computeHashCode(@NonNull String name) {
		return IdHash.createGlobalHash(RootPackageId.class, name);
	}

	protected final @NonNull String name;

	public RootPackageIdImpl(@NonNull IdManager idManager, @NonNull String name) {
		super(computeHashCode(name));
		this.name = name;
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitRootPackageId(this);
	}

	@Override
	public @NonNull String getDisplayName() {
		return name;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}
}