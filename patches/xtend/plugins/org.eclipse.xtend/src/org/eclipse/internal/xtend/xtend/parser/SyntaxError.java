/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.internal.xtend.xtend.parser;

public class SyntaxError implements XtendError {
	private final int start, end, line;
	private final String message;

	public SyntaxError(final int start, final int end, final int line, final String message) {
		super();
		this.start = start;
		this.end = end;
		this.line = line;
		this.message = message;
	}

	public int getEnd() {
		return end;
	}

	public int getLine() {
		return line;
	}

	public String getMessage() {
		return message;
	}

	public int getStart() {
		return start;
	}

	@Override
	public String toString() {
		return getMessage() + " on line " + line;
	}
}
