/*******************************************************************************
 * Copyright (c) 2012, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.ParametersId;


/**
 * DomainParameterTypesIterable provides a hashable list of operation
 * parameters suitable for use when indexing operation overloads.
 */
public interface ParameterTypes
{
	@NonNull Type @NonNull [] get();
	@NonNull Type get(int index);
	@NonNull ParametersId getParametersId();
	@NonNull List<Parameter> getParameters();
	int size();
}