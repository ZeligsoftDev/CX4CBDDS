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
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.BindingsId;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.TemplateableId;
import org.eclipse.ocl.pivot.ids.UnspecifiedId;
import org.eclipse.ocl.pivot.utilities.NameUtil;

public class UnspecifiedIdImpl extends AbstractTypeId implements UnspecifiedId, ClassId, DataTypeId
{
	protected final @NonNull Type type;

	public UnspecifiedIdImpl(@NonNull IdManager idManager, @NonNull Type type) {
		this.type = type;
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitUnspecifiedId(this);
	}

	@Override
	public @NonNull String getDisplayName() {
		return NameUtil.getSafeName(type);
	}

	@Override
	public @NonNull String getName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull PackageId getParent() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull TemplateableId getSpecializedId(@NonNull BindingsId bindingsId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Object getSpecifier() {
		return type;
	}

	@Override
	public int hashCode() {
		return type.hashCode();
	}
}