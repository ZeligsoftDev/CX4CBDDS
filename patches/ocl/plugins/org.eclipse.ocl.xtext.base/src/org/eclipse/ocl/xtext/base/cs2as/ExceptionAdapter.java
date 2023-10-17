/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.cs2as;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * An ExceptionAdapter may be attached to a CS Element to capture an exception
 * for diagnosis of an unresolved proxy.
 */
public class ExceptionAdapter extends AdapterImpl
{
	private final Exception exception;

	public ExceptionAdapter(Exception exception) {
		this.exception = exception;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == ExceptionAdapter.class;
	}

	public String getErrorMessage() {
		return exception.getLocalizedMessage();
	}
}
