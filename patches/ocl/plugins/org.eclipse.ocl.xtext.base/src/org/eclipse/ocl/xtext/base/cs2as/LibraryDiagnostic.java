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
package org.eclipse.ocl.xtext.base.cs2as;

import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;

public class LibraryDiagnostic extends ExceptionDiagnostic
{
	public LibraryDiagnostic(Exception exception) {
		super(exception);
	}

	@Override
	public String getMessage() {
		return getException().getMessage();
	}
}