/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

@SuppressWarnings("serial")
public class IllegalLibraryException extends IllegalStateException
{
	public IllegalLibraryException(String string) {
		super(string);
	}
	
	public IllegalLibraryException(String string, Throwable e) {
		super(string, e);
	}
}