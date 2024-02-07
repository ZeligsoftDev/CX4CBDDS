/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A TypeId provides a unique hierarchical for type which may have many 'actual' type variants.
 * <p>
 * For instance 'Boolean' is a well-understood conceptual, but it may have many 'actual' as a result of Complete OCL
 * definitions merging additional features in to the 'actual' type.
 */
public interface TemplateableId extends ElementId
{
	public static final @NonNull TemplateableId @NonNull [] NULL_TEMPLATEABLE_ID_ARRAY = new @NonNull TemplateableId[0];

	@NonNull TemplateableId getGeneralizedId();
	@Nullable String getLiteralName();
	@NonNull String getMetaTypeName();
	@NonNull String getName();

	/**
	 * Return the typeId for this typeId specialized by bindingsId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not be specialized.
	 */
	@NonNull TemplateableId getSpecializedId(@NonNull BindingsId bindingsId);

	/**
	 * @since 1.18
	 */
	@NonNull TemplateParameterId getTemplateParameterId(int index, @NonNull String name);

	int getTemplateParameters();
}