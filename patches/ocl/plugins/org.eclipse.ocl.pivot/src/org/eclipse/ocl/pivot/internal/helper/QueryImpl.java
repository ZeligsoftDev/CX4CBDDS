/*******************************************************************************
 * Copyright (c) 2010, 2021 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Radek Dvorak - Bug 261128
 *******************************************************************************/

package org.eclipse.ocl.pivot.internal.helper;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.utilities.OCL;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 */
@Deprecated /* @deprecated Use BasicQueryImpl without getOCL() */
public class QueryImpl extends BasicQueryImpl
{
	private final @NonNull OCL ocl;

	public QueryImpl(@NonNull OCL ocl, @NonNull ExpressionInOCL query) {
		super(ocl.getEnvironmentFactory(), query);
		this.ocl = ocl;
	}

	@Override
	public @NonNull OCL getOCL() {
		return ocl;
	}
}
