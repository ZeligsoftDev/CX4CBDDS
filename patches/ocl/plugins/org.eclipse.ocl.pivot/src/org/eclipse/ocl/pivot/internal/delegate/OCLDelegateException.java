/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   C.Damus - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.delegate;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.EvaluationException;


/**
 * An OCLDelegateException wraps an exception that explains a problem that occurred during delegated evaluation.
 * <p>
 * For simple problems this class was once used directly rather than as a wrapper requiring the handler to
 * determine whether a direct or wrapped exception was involved. It is intended that this should only be a wrapper
 * consequently constructors permitting a non-null message are deprecated.
 * <p>
 * Code supporting the Classic LPG evaluator must be prepared to handle unwrapped exceptions.
 */
public class OCLDelegateException extends org.eclipse.ocl.common.internal.delegate.OCLDelegateException
{
	private static String computeMessage(Exception cause) {
		String message = cause.getLocalizedMessage();
		Throwable nestedException = cause.getCause();
		if ((nestedException != null) && !(cause instanceof EvaluationException)) {		// Make caller more regular
			message = message + "\n - " + nestedException.getLocalizedMessage();
		}
		return message; //.replace("\n", " ");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OCLDelegateException(String message) {
		super(message, null);
	}

	public OCLDelegateException(String message, Exception cause) {
		super(message, cause);
	}

	public OCLDelegateException(@NonNull Exception cause) {
		super(computeMessage(cause), cause);
	}
}
