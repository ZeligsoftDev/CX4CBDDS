/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.ids.IdHash;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.LambdaTypeId;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.SingletonScope.AbstractKeyAndValue;
import org.eclipse.ocl.pivot.ids.TypeId;

public class GeneralizedLambdaTypeIdImpl extends AbstractGeneralizedIdImpl<@NonNull LambdaTypeId> implements LambdaTypeId, WeakHashMapOfListOfWeakReference3.MatchableId<String, ParametersId>
{
	private static class LambdaTypeIdValue extends AbstractKeyAndValue<@NonNull LambdaTypeId>
	{
		private final @NonNull IdManager idManager;
		private @NonNull String name;
		private @NonNull ParametersId parametersId;

		private LambdaTypeIdValue(@NonNull IdManager idManager, @NonNull String name, @NonNull ParametersId parametersId) {
			super(computeHashCode(name, parametersId));
			this.idManager = idManager;
			this.name = name;
			this.parametersId = parametersId;
		}

		@Override
		public @NonNull LambdaTypeId createSingleton() {
			return new GeneralizedLambdaTypeIdImpl(idManager, name, parametersId);
		}

		@Override
		public boolean equals(@Nullable Object that) {
			if (that instanceof GeneralizedLambdaTypeIdImpl) {
				GeneralizedLambdaTypeIdImpl singleton = (GeneralizedLambdaTypeIdImpl)that;
				return name.equals(singleton.getName()) && (parametersId == singleton.getParametersId());
			}
			else {
				return false;
			}
		}
	}

	/**
	 * @since 1.18
	 */
	public static class LambdaTypeIdSingletonScope extends AbstractSingletonScope<@NonNull LambdaTypeId, @NonNull LambdaTypeIdValue>
	{
		public @NonNull LambdaTypeId getSingleton(@NonNull IdManager idManager, @NonNull String name, @NonNull ParametersId parametersId) {
			return getSingletonFor(new LambdaTypeIdValue(idManager, name, parametersId));
		}
	}

	private static int computeHashCode(@NonNull String name, @NonNull ParametersId parametersId) {
		return IdHash.createGlobalHash(LambdaTypeId.class, name) + parametersId.hashCode();
	}

	protected final @NonNull ParametersId parametersId;

	@Deprecated /* @deprecated use simpler constructor */
	public GeneralizedLambdaTypeIdImpl(@NonNull Integer hashCode, @NonNull String name, @NonNull ParametersId parametersId) {
		super(hashCode, 0, name);
		this.parametersId = parametersId;
		assert this.hashCode == computeHashCode(name, parametersId);
	}

	private GeneralizedLambdaTypeIdImpl(@NonNull IdManager idManager, @NonNull String name, @NonNull ParametersId parametersId) {
		super(computeHashCode(name, parametersId), 0, name);
		this.parametersId = parametersId;
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitLambdaTypeId(this);
	}

	@Override
	protected @NonNull LambdaTypeId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedLambdaTypeIdImpl(this, templateBindings);
	}

	@Override
	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		//		if (templateParameters > 0) {
		//			s.append("<");
		//			s.append(templateParameters);
		//			s.append(">");
		//		}
		s.append(name);
		for (int i = 0; i < parametersId.size(); i++) {
			TypeId parameterId = parametersId.get(i);
			assert parameterId != null;
			if (i == 0) {
				s.append(' ');
				s.append(parameterId.toString());
				s.append('(');
			}
			else if (i == 1) {
			}
			else if (i == 2) {
				s.append(parameterId.toString());
			}
			else {
				s.append(',');
				s.append(parameterId.toString());
			}
		}
		s.append(") : ");
		if (parametersId.size() > 1) {
			TypeId parameterId = parametersId.get(1);
			assert parameterId != null;
			s.append(parameterId.toString());
		}
		else {
			s.append("?");
		}
		return s.toString();
	}

	@Override
	public @NonNull LambdaTypeId getGeneralizedId() {
		return this;
	}

	/**
	 * @since 1.7
	 */
	@Override
	public boolean isTemplated() {
		for (TypeId typeId : parametersId) {
			if (typeId.isTemplated()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return TypeId.LAMBDA_TYPE_NAME;
	}

	@Override
	public @NonNull ParametersId getParametersId() {
		return parametersId;
	}

	@Override
	public boolean matches(@NonNull String thatName, @NonNull ParametersId thatParametersId) {
		if (parametersId != thatParametersId) {
			return false;
		}
		if (!this.name.equals(thatName)) {
			return false;
		}
		return true;
	}

	@Override
	public @NonNull LambdaTypeId specialize(@NonNull BindingsId templateBindings) {
		return createSpecializedId(templateBindings);
	}
}