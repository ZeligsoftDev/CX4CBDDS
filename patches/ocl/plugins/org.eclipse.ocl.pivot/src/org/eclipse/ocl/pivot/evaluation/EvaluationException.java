/*******************************************************************************
 * Copyright (c) 2014, 2018 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors: 
 *   E.D.Willink (CEA LIST) - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.osgi.util.NLS;

/**
 * Exception indicating a failure to evaluate an OCL constraint or expression.
 */
public class EvaluationException extends RuntimeException
{
	private static final long serialVersionUID = -887131032132664080L;

	public EvaluationException(String message) {
		super(message);
	}

	public EvaluationException(/*@NonNull*/ String messageTemplate, Object... bindings) {
		super(NLS.bind(messageTemplate, bindings));
	}

	public EvaluationException(@NonNull Throwable e, String message) {
		super(message, e);
	}

	public EvaluationException(@NonNull Throwable e, /*@NonNull*/ String messageTemplate, Object... bindings) {
		super(NLS.bind(messageTemplate, bindings), e);
	}
}
