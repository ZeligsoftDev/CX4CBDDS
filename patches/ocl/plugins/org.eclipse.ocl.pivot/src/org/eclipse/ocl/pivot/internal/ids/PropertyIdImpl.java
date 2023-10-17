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
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.SingletonScope.AbstractKeyAndValue;
import org.eclipse.ocl.pivot.ids.TypeId;

public class PropertyIdImpl extends AbstractElementId implements PropertyId
{
	private static class PropertyIdValue extends AbstractKeyAndValue<@NonNull PropertyId>
	{
		private final @NonNull TypeId parentId;
		private final @NonNull String value;

		private PropertyIdValue(@NonNull TypeId parentId, @NonNull String value) {
			super(computeHashCode(parentId, value));
			this.parentId = parentId;
			this.value = value;
		}

		@Override
		public @NonNull PropertyId createSingleton() {
			return new PropertyIdImpl(parentId, value);
		}

		@Override
		public boolean equals(@Nullable Object that) {
			if (that instanceof PropertyIdImpl) {
				PropertyIdImpl singleton = (PropertyIdImpl)that;
				return value.equals(singleton.getName());
			}
			else {
				return false;
			}
		}
	}

	/**
	 * @since 1.18
	 */
	public static class PropertyIdSingletonScope extends AbstractSingletonScope<@NonNull PropertyId, @NonNull String>
	{
		public @NonNull PropertyId getSingleton(@NonNull TypeId parentId, @NonNull String value) {
			return getSingletonFor(new PropertyIdValue(parentId, value));
		}
	}

	private static int computeHashCode(@NonNull ElementId parentId, @NonNull String name) {
		return IdHash.createChildHash(parentId, name);
	}

	protected final @NonNull TypeId parentId;
	protected final @NonNull String name;
	protected final @NonNull Integer hashCode;		// FIXME use int
//	protected final @Nullable EStructuralFeature eFeature;

	public PropertyIdImpl(@NonNull TypeId parentId, @NonNull String name/*, @Nullable EStructuralFeature eFeature*/) {
		this.parentId = parentId;
		this.name = name;
		this.hashCode = computeHashCode(parentId, name);
//		this.eFeature = eFeature;
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitPropertyId(this);
	}

	@Override
	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		s.append(parentId);
		s.append("::");
		s.append(name);
		return s.toString();
	}

//	public @Nullable EStructuralFeature getEFeature() {
//		return eFeature;
//	}

	public @NonNull String getMetaTypeName() {
		return TypeId.PROPERTY_NAME;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public @NonNull TypeId getParent() {
		return parentId;
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}
}