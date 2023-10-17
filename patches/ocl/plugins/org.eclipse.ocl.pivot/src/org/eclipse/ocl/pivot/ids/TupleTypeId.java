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
import org.eclipse.jdt.annotation.Nullable;

/**
 * A TupleTypeid provides a unique hierarchical identifier a Tuple such as Tuple{first:String,second:Integer}.
 */
public interface TupleTypeId extends TypeId
{
	@NonNull String getName();
	@Nullable TuplePartId getPartId(@NonNull String name);
	@NonNull TuplePartId @NonNull [] getPartIds();
}