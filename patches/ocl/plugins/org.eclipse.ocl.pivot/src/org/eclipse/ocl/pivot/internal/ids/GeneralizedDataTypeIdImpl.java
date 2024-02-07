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
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdHash;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.SingletonScope.AbstractKeyAndValue;
import org.eclipse.ocl.pivot.ids.TemplateableTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;

public class GeneralizedDataTypeIdImpl extends GeneralizedNestedTypeIdImpl implements DataTypeId
{
	private static class DataTypeIdValue extends AbstractKeyAndValue<@NonNull DataTypeId>
	{
		private @NonNull PackageId packageId;
		private @NonNull String name;
		private int templateParameters;

		private DataTypeIdValue(@NonNull PackageId packageId, @NonNull String name, int templateParameters) {
			super(computeHashCode(packageId, templateParameters, name));
			this.packageId = packageId;
			this.name = name;
			this.templateParameters = templateParameters;
		}

		@Override
		public @NonNull DataTypeId createSingleton() {
			return new GeneralizedDataTypeIdImpl(packageId, templateParameters, name);
		}

		@Override
		public boolean equals(@Nullable Object that) {
			if (that instanceof GeneralizedDataTypeIdImpl) {
				GeneralizedDataTypeIdImpl singleton = (GeneralizedDataTypeIdImpl)that;
				return name.equals(singleton.getName()) && (templateParameters == singleton.getTemplateParameters());
			}
			else {
				return false;
			}
		}
	}

	/**
	 * @since 1.18
	 */
	public static class DataTypeIdSingletonScope extends AbstractSingletonScope<@NonNull DataTypeId, @NonNull DataTypeIdValue>
	{
		public @NonNull DataTypeId getSingleton(@NonNull PackageId packageId, @NonNull String name, int templateParameters) {
			return getSingletonFor(new DataTypeIdValue(packageId, name, templateParameters));
		}
	}

	/**
	 * @since 1.18
	 */
	private static int computeHashCode(@NonNull ElementId parentId, int templateParameters, @NonNull String name) {
		return IdHash.createChildHash(parentId, name) + 11 * templateParameters;
	}

	public GeneralizedDataTypeIdImpl(@NonNull PackageId parentId, int templateParameters, @NonNull String name) {
		super(computeHashCode(parentId, templateParameters,name), parentId, templateParameters, name);
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitDataTypeId(this);
	}

	@Override
	protected @NonNull TemplateableTypeId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedDataTypeIdImpl(this, templateBindings);
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return TypeId.DATA_TYPE_NAME;
	}
}