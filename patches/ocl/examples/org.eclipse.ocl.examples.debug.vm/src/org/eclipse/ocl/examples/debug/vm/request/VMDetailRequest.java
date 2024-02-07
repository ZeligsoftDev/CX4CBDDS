/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.request;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;

public class VMDetailRequest extends VMRequest
{
	private static final long serialVersionUID = 2420598264493472446L;

	private final @NonNull String fVariableURI;
	
	@SuppressWarnings("null")
	public VMDetailRequest(@NonNull URI variableURI) {
		fVariableURI = variableURI.toString();
	}

	public @NonNull URI getVariableURI() {
		return URI.createURI(fVariableURI);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + fVariableURI + ")"; //$NON-NLS-1$
	}
}
