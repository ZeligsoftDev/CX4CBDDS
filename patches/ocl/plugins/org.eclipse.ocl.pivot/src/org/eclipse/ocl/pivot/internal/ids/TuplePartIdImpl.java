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
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.SingletonScope.AbstractKeyAndValue;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TypeId;

public class TuplePartIdImpl implements TuplePartId, WeakHashMapOfListOfWeakReference4.MatchableId<Integer, String, TypeId>
{
	private static class TuplePartIdValue extends AbstractKeyAndValue<@NonNull TuplePartId>
	{
		private @NonNull IdManager idManager;
		private int index;
		private @NonNull String name;
		private @NonNull TypeId typeId;

		private TuplePartIdValue(@NonNull IdManager idManager, int index, @NonNull String name, @NonNull TypeId typeId) {
			super(computeHashCode(index, name, typeId));
			this.idManager = idManager;
			this.index = index;
			this.name = name;
			this.typeId = typeId;
		}

		@Override
		public @NonNull TuplePartId createSingleton() {
			return new TuplePartIdImpl(idManager, index, name, typeId);
		}

		@Override
		public boolean equals(@Nullable Object that) {
			if (that instanceof TuplePartIdImpl) {
				TuplePartIdImpl singleton = (TuplePartIdImpl)that;
				return (index == singleton.getIndex()) && name.equals(singleton.getName()) && (typeId == singleton.getTypeId());
			}
			else {
				return false;
			}
		}
	}

	/**
	 * @since 1.18
	 */
	public static class TuplePartIdSingletonScope extends AbstractSingletonScope<@NonNull TuplePartId, @NonNull TuplePartIdValue>
	{
		public @NonNull TuplePartId getSingleton(@NonNull IdManager idManager, int index, @NonNull String name, @NonNull TypeId typeId) {
			return getSingletonFor(new TuplePartIdValue(idManager, index, name, typeId));
		}
	}

	private static int computeHashCode(int index, @NonNull String name, @NonNull TypeId typeId) {
		return name.hashCode() + 7 * typeId.hashCode() + 989 * index;
	}

	protected final @NonNull Integer hashCode;
	protected final int index;
	protected final @NonNull String name;
	protected final @NonNull TypeId typeId;

	@Deprecated /* @deprecated use simpler constructor */
	public TuplePartIdImpl(@NonNull IdManager idManager, @NonNull Integer hashCode, int index, @NonNull String name, @NonNull TypeId typeId) {
		this(idManager, index, name, typeId);
	}

	/**
	 * @since 1.18
	 */
	private TuplePartIdImpl(@NonNull IdManager idManager, int index, @NonNull String name, @NonNull TypeId typeId) {
		this.index = index;
		this.name = name;
		this.typeId = typeId;
		this.hashCode = computeHashCode(index, name, typeId);
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTuplePartId(this);
	}

	@Override
	public int compareTo(TuplePartId o) {
		String n1 = name;
		String n2 = o.getName();
		if (n1 == n2) {
			return 0;
		}
		return n1.compareTo(n2);
	}

	@Override
	public final boolean equals(Object obj) {
		if (obj instanceof org.eclipse.ocl.pivot.ids.SingletonScope.KeyAndValue) {
			return obj.equals(this);
		}
		else {
			return this == obj;
		}
	}

	@Override
	public @NonNull String getDisplayName() {
		return String.valueOf(name) + " : " + String.valueOf(typeId);
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return typeId;
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
	public boolean matches(@NonNull Integer thatIndex, @NonNull String thatName, @NonNull TypeId thatTypeid) {
		if (this.typeId != thatTypeid) {
			return false;
		}
		if (this.index != thatIndex) {
			return false;
		}
		if (!this.name.equals(thatName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(name) + " : " + String.valueOf(typeId);
	}
}