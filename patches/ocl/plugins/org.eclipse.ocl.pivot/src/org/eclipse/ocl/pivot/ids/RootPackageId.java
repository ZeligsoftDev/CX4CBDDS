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
 * A RootPackageId provides a possibly unique hierarchical identifier for an unnested package which has a name but no nsURI.
 * <p>
 * Packages should have nsURIs, so this is just a compatibility fall-back for simple lazy applications. Hopefully names are unique
 * in such simple situations.
 */
public interface RootPackageId extends PackageId
{
	@NonNull String getName();
}