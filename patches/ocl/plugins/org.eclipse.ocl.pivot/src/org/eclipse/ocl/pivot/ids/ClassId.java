/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
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

/**
 * A ClassId provides a unique hierarchical identifier for a class which is nested by unique name in a parent package.
 */
public interface ClassId extends NestedTypeId
{
	/**
	 * @since 1.18
	 */
	@NonNull TemplateableId getSpecializedId(@NonNull BindingsId bindingsId);
}