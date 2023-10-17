/*******************************************************************************
 * Copyright (c) 2010, 2018 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.utilities;


/**
 * Exception indicating a semantic error in parsing or validating OCL
 * expressions.
 * 
 * @author Christian Vogt (cvogt)
 */
public class SemanticException extends ParserException
{
	private static final long serialVersionUID = -7995837682564930748L;

    /**
     * Initializes me with a user-friendly message describing the nature of
     * the parse failure.
     * 
     * @param msg the exception message
     */
	public SemanticException(String msg) {
		super(msg);
	}
	public SemanticException(String messageTemplate, Object... bindings) {
		super(null, StringUtil.bind(messageTemplate, bindings));
	}
}
