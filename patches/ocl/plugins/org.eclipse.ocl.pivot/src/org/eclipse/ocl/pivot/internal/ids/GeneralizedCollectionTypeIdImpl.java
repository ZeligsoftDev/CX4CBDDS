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
import org.eclipse.ocl.pivot.ids.BindingsId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdHash;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.SingletonScope.AbstractKeyAndValue;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

public class GeneralizedCollectionTypeIdImpl extends GeneralizedTypeIdImpl<@NonNull CollectionTypeId> implements CollectionTypeId
{
	private static class CollectionTypeIdValue extends AbstractKeyAndValue<@NonNull CollectionTypeId>
	{
		private final @NonNull IdManager idManager;
		private final @NonNull String value;

		public CollectionTypeIdValue(@NonNull IdManager idManager, @NonNull String value) {
			super(computeHashCode(value));
			this.idManager = idManager;
			this.value = value;
		}

		@Override
		public @NonNull CollectionTypeId createSingleton() {
			return new GeneralizedCollectionTypeIdImpl(idManager, value);
		}

		@Override
		public boolean equals(@Nullable Object that) {
			if (that instanceof GeneralizedCollectionTypeIdImpl) {
				GeneralizedCollectionTypeIdImpl singleton = (GeneralizedCollectionTypeIdImpl)that;
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
	public static class CollectionTypeIdSingletonScope extends AbstractSingletonScope<@NonNull CollectionTypeId, @NonNull String>
	{
		public @NonNull CollectionTypeId getSingleton(@NonNull IdManager idManager, @NonNull String value) {
			return getSingletonFor(new CollectionTypeIdValue(idManager, value));
		}
	}

	private static int computeHashCode(@NonNull String name) {
		return IdHash.createGlobalHash(CollectionTypeId.class, name);
	}

	public GeneralizedCollectionTypeIdImpl(@NonNull IdManager idManager, @NonNull String name) {
		super(computeHashCode(name), 1, name);
		assert !MAP_NAME.equals(name);
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitCollectionTypeId(this);
	}

	@Override
	protected @NonNull CollectionTypeId createSpecializedId(@NonNull BindingsId bindingsId) {
		return new SpecializedCollectionTypeIdImpl(this, bindingsId);
	}

	@Override
	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		s.append(name);
	//	s.append(IdManager.getParametersId(CollectionTypeId.T_1));
		return s.toString();
	}

	@Override
	public @NonNull TemplateParameterId getElementTypeId() {
		return TypeId.T_1;
	}

	@Override
	public @NonNull CollectionTypeId getGeneralizedId() {
		return this;
	}

	@Override
	public @Nullable String getLiteralName() {
		if (this == TypeId.BAG) {
			return "BAG";
		}
		else if (this == TypeId.COLLECTION) {
			return "COLLECTION";
		}
		else if (this == TypeId.ORDERED_SET) {
			return "ORDERED_SET";
		}
		else if (this == TypeId.SEQUENCE) {
			return "SEQUENCE";
		}
		else if (this == TypeId.SET) {
			return "SET";
		}
		else if (this == TypeId.UNIQUE_COLLECTION) {
			return "UNIQUE_COLLECTION";
		}
		else {
			return null;
		}
	}

	@Override
	public @NonNull IntegerValue getLowerValue() {
		return ValueUtil.ZERO_VALUE;
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return name + "Type";
	}

	@Override
	public @NonNull UnlimitedNaturalValue getUpperValue() {
		return ValueUtil.UNLIMITED_VALUE;
	}

	@Override
	public boolean isNullFree() {
		return false;
	}

	@Override
	public @NonNull CollectionTypeId specialize(@NonNull BindingsId templateBindings) {
		return getSpecializedId(templateBindings);
	}
}