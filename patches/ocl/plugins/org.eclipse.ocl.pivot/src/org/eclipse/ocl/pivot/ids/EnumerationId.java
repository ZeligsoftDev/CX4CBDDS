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


/**
 * A EnumerationId provides a unique hierarchical for an enumeration which may have many 'actual' type variants.
 */
public interface EnumerationId extends NestedTypeId
{
	/**
	 * Return the typeId for anEnumerationLiteral of this typeId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have enumeration literals.
	 */
	@NonNull EnumerationLiteralId getEnumerationLiteralId(@NonNull String name);
}