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
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdHash;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.SingletonScope.AbstractKeyAndValue;
import org.eclipse.ocl.pivot.ids.TypeId;

public class GeneralizedOperationIdImpl extends AbstractGeneralizedIdImpl<@NonNull OperationId> implements OperationId, WeakHashMapOfListOfWeakReference4.MatchableId<Integer, String, ParametersId>
{
	private static class OperationIdValue extends AbstractKeyAndValue<@NonNull OperationId>
	{
		private @NonNull TypeId parentId;
		private int templateParameters;
		private @NonNull String name;
		private @NonNull ParametersId parametersId;

		private OperationIdValue(@NonNull TypeId parentId, int templateParameters, @NonNull String name, @NonNull ParametersId parametersId) {
			super(computeHashCode(parentId, templateParameters, name, parametersId));
			this.parentId = parentId;
			this.templateParameters = templateParameters;
			this.name = name;
			this.parametersId = parametersId;
		}

		@Override
		public @NonNull OperationId createSingleton() {
			return new GeneralizedOperationIdImpl(parentId, templateParameters, name, parametersId);
		}

		@Override
		public boolean equals(@Nullable Object that) {
			if (that instanceof GeneralizedOperationIdImpl) {
				GeneralizedOperationIdImpl singleton = (GeneralizedOperationIdImpl)that;
				return singleton.matches(templateParameters, name, parametersId);
			}
			else {
				return false;
			}
		}
	}

	/**
	 * @since 1.18
	 */
	public static class OperationIdSingletonScope extends AbstractSingletonScope<@NonNull OperationId, @NonNull OperationIdValue>
	{
		public @NonNull OperationId getSingleton(@NonNull TypeId parentId, int templateParameters, @NonNull String name, @NonNull ParametersId parametersId) {
			return getSingletonFor(new OperationIdValue(parentId, templateParameters, name, parametersId));
		}
	}

	private static int computeHashCode(@NonNull ElementId parentId, int templateParameters, @NonNull String name, @NonNull ParametersId parametersId) {
		return IdHash.createChildHash(parentId, name) + parametersId.hashCode();
	}

	protected final @NonNull TypeId parentId;
	protected final @NonNull ParametersId parametersId;

	@Deprecated /* @deprecated use simpler constructor */
	public GeneralizedOperationIdImpl(@NonNull Integer hashCode, @NonNull TypeId parentId, int templateParameters, @NonNull String name, @NonNull ParametersId parametersId) {
		this(parentId, templateParameters, name, parametersId);
		assert hashCode == this.hashCode;
	}

	private GeneralizedOperationIdImpl(@NonNull TypeId parentId, int templateParameters, @NonNull String name, @NonNull ParametersId parametersId) {
		super(computeHashCode(parentId, templateParameters, name, parametersId), templateParameters, name);
		this.parentId = parentId;
		this.parametersId = parametersId;
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitOperationId(this);
	}

	@Override
	protected @NonNull OperationId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedOperationIdImpl(this, templateBindings);
	}

	@Override
	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		s.append(parentId);
		s.append("::");
		s.append(name);
		return s.toString();
	}

	@Override
	public @NonNull OperationId getGeneralizedId() {
		return this;
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return TypeId.OPERATION_NAME;
	}

	@Override
	public @NonNull ParametersId getParametersId() {
		return parametersId;
	}

	@Override
	public @NonNull TypeId getParent() {
		return parentId;
	}

	@Override
	public boolean matches(@NonNull Integer thoseTemplateParameters, @NonNull String thatName, @NonNull ParametersId thatParametersId) {
		if (this.parametersId != thatParametersId) {
			return false;
		}
		if (this.templateParameters != thoseTemplateParameters) {
			return false;
		}
		if (!this.name.equals(thatName)) {
			return false;
		}
		return true;
	}
}