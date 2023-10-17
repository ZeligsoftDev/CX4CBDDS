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
 * A PackageId provides a unique hierarchical semantic identifier for a package.
 * <p>
 * Logically merged packages may have different NsURIs but the same PackageId.
 *
 * @see NestedPackageId
 * @see NsURIPackageId
 * @see RootPackageId
 */
public interface PackageId extends ElementId
{
 	/**
	 * Return the classId for the named child of this packageId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have nested types.
	 */
	@NonNull ClassId getClassId(@NonNull String name, int templateParameters);

 	/**
	 * Return the dataTypeId for the named child of this packageId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have nested types.
	 */
	@NonNull DataTypeId getDataTypeId(@NonNull String name, int templateParameters);

 	/**
	 * Return the enumerationId for the named child of this packageId.
	 * <p>
	 * Throws UnsupportedException for typeIds such as Primitive Types that may not have nested types.
	 */
	@NonNull EnumerationId getEnumerationId(@NonNull String name);
	@NonNull NestedPackageId getNestedPackageId(@NonNull String name);
}