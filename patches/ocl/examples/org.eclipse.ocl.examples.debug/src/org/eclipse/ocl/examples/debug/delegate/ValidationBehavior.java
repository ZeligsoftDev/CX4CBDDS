/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.delegate;

import org.eclipse.jdt.annotation.NonNull;

public class ValidationBehavior extends org.eclipse.ocl.pivot.internal.delegate.ValidationBehavior
{
	public static final @NonNull ValidationBehavior INSTANCE = new ValidationBehavior();
}