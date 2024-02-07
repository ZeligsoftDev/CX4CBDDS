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
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.ids.AbstractSingletonScope;
import org.eclipse.ocl.pivot.ids.BindingsId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdHash;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.SingletonScope.AbstractKeyAndValue;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TemplateableId;
import org.eclipse.ocl.pivot.ids.TypeId;

public class TemplateParameterIdImpl extends AbstractElementId implements TemplateParameterId
{
	private static class TemplateParameterIdValue extends AbstractKeyAndValue<@NonNull TemplateParameterId>
	{
		private final @NonNull TemplateableId generalizedId;
		private final int index;
		private final @NonNull String name;

		private TemplateParameterIdValue(@NonNull TemplateableId generalizedId, int index, @NonNull String name) {
			super(computeHashCode(generalizedId, name));
			this.generalizedId = generalizedId;
			this.index = index;
			this.name = name;
		}

		@Override
		public @NonNull TemplateParameterId createSingleton() {
			return new TemplateParameterIdImpl(generalizedId, index, name);
		}

		@Override
		public boolean equals(@Nullable Object that) {
			if (that instanceof TemplateParameterIdImpl) {
				TemplateParameterIdImpl singleton = (TemplateParameterIdImpl)that;
				return name.equals(singleton.getName());
			}
			else {
				return false;
			}
		}
	}

	/**
	 * @since 1.18
	 */
	public static class TemplateParameterIdSingletonScope extends AbstractSingletonScope<@NonNull TemplateParameterId, @NonNull TemplateParameter>
	{
		public @NonNull TemplateParameterId getSingleton(@NonNull TemplateableId generalizedId, int index, @NonNull String name) {
			return getSingletonFor(new TemplateParameterIdValue(generalizedId, index, name));
		}
	}

	private static int computeHashCode(@NonNull TemplateableId generalizedId, @NonNull String name) {
		return IdHash.createChildHash(generalizedId, name);
	}

	private final @Nullable TemplateableId templateableId;

	private final int index;
	private final @NonNull String name;
	private final int hashCode;

	@Deprecated /* @deprecated normalization no longer used for TemplateParameterId */
	public TemplateParameterIdImpl(@NonNull IdManager idManager, int index) {
		//		System.out.println("create " + ClassUtil.debugFullName(this));
		this.templateableId = null;
		this.index = index;
		this.name = "$" + Integer.toString(index);
		this.hashCode = TemplateParameterIdImpl.class.hashCode() + name.hashCode();
	}

	/**
	 * @since 1.18
	 */
	public TemplateParameterIdImpl(@NonNull TemplateableId templateableId, int index, @NonNull String name) {
		//		System.out.println("create " + ClassUtil.debugFullName(this));
		this.templateableId = templateableId;
		this.index = index;
		this.name = name;
		this.hashCode = computeHashCode(templateableId, name);
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTemplateParameterId(this);
	}

	@Override
	public @NonNull String getDisplayName() {
		return name;
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @Nullable TemplateableId getTemplateableId() {
		return templateableId;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Deprecated /* @deprecated no longer used */
	@Override
	public @Nullable String getLiteralName() {
		if (this == TypeId.T_1) {
			return "T_1";
		}
		else if (this == TypeId.T_2) {
			return "T_2";
		}
		else if (this == TypeId.T_3) {
			return "T_3";
		}
		else {
			return null;
		}
	}

	@Override
	public @NonNull String getMetaTypeName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public @NonNull OperationId getOperationId(int templateParameters, @NonNull String name, @NonNull ParametersId parametersId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull PropertyId getPropertyId(@NonNull String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull TemplateParameterId getTemplateParameterId(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getTemplateParameters() {
		throw new UnsupportedOperationException();
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}

	/**
	 * @since 1.7
	 */
	@Override
	public boolean isTemplated() {
		return true;
	}

	@Override
	public @NonNull ElementId specialize(@NonNull BindingsId templateBindings) {
		ElementId elementId = templateBindings.getElementId(index);
		assert elementId != null;
		return elementId;
	}

	@Override
	public String toString() {
		if (templateableId != null) {
			return templateableId.getDisplayName() + "::" + getDisplayName();
		}
		else {
			return getDisplayName();
		}
	}
}