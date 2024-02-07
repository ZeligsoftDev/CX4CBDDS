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
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdHash;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.SingletonScope;
import org.eclipse.ocl.pivot.ids.TypeId;

public abstract class AbstractElementId implements ElementId
{
	@Deprecated /* @deprecated no longer used */
	protected static final class OperationIdsMap extends WeakHashMapOfListOfWeakReference4<Integer, Integer, String, ParametersId, GeneralizedOperationIdImpl>
	{
		protected final @NonNull TypeId parentId;

		public OperationIdsMap(@NonNull TypeId parentId) {
			this.parentId = parentId;
		}

		@Override
		protected @NonNull GeneralizedOperationIdImpl newId(@NonNull Integer hashCode, @NonNull Integer templateParameters, @NonNull String name, @NonNull ParametersId parametersId) {
			return new GeneralizedOperationIdImpl(hashCode, parentId, templateParameters, name, parametersId);
		}

		public @NonNull OperationId getId(int templateParameters, @NonNull String name, @NonNull ParametersId parametersId) {
			int hashCode = IdHash.createChildHash(parentId, name) + parametersId.hashCode();
			return getId(hashCode, templateParameters, name, parametersId);
		}
	}

	@Deprecated /* @deprecated no longer used */
	protected static final class PropertyIdsMap extends WeakHashMapOfWeakReference<String, PropertyIdImpl>
	{
		protected final @NonNull TypeId parentId;

		public PropertyIdsMap(@NonNull TypeId parentId) {
			this.parentId = parentId;
		}

		@Override
		protected @NonNull PropertyIdImpl newId(@NonNull String name) {
			return new PropertyIdImpl(parentId, name);
		}
	}

	@Override
	public final boolean equals(Object that) {
		if (that instanceof SingletonScope.KeyAndValue) {	// A SingletonScope.Key may be used to lookup a singleton
			return that.equals(this);
		}
		else {										// But normally ElementId instances are singletons
			return this == that;
		}
	}

	public @Nullable String getLiteralName() {
		return null;
	}

	@Override
	public abstract int hashCode();

	@Override
	public String toString() {
		return getDisplayName();
	}
}