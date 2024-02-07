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
import org.eclipse.ocl.pivot.ids.BindingsId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NestedTypeId;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.TemplateableTypeId;

public abstract class GeneralizedNestedTypeIdImpl extends GeneralizedTypeIdImpl<@NonNull TemplateableTypeId> implements NestedTypeId, TemplateableTypeId
{
	protected final @NonNull PackageId parent;

	@Deprecated
	protected GeneralizedNestedTypeIdImpl(@NonNull PackageId parent, int templateParameters, @NonNull String name) {
		this(name.hashCode(), parent, templateParameters, name);
	}

	/**
	 * @since 1.18
	 */
	protected GeneralizedNestedTypeIdImpl(int hashCode, @NonNull PackageId parent, int templateParameters, @NonNull String name) {
		super(hashCode, templateParameters, name);
		this.parent = parent;
	}

	@Override
	protected @NonNull TemplateableTypeId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedTypeIdImpl(this, templateBindings);
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
	public @NonNull TemplateableTypeId getGeneralizedId() {
		return this;
	}

	@Override
	public @NonNull PackageId getParent() {
		return parent;
	}

    @Override
	public @NonNull TemplateableTypeId specialize(@NonNull BindingsId templateBindings) {
    	return createSpecializedId(templateBindings);
	}

	@Override
	public String toString() {
		if (parent != IdManager.METAMODEL) {
			return parent + "::" + name;
		}
		else {
			return name;
		}
	}

}