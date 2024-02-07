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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.types.TemplateParametersImpl;


/**
 * TemplateParameters provides a list of type parameters suitable for use when indexing specializations.
 */
public interface TemplateParameters
{
	public static final @NonNull TemplateParametersImpl EMPTY_LIST = new TemplateParametersImpl();

	@NonNull Type get(int i);
	int parametersSize();
}
