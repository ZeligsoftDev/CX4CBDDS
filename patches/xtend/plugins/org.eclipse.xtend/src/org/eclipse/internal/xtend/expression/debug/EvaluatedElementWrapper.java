/*******************************************************************************
 * Copyright (c) 2005 - 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.internal.xtend.expression.debug;

import org.eclipse.internal.xtend.expression.ast.ISyntaxElement;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;

/**
 * Wrapper for a SyntaxElement to mark it evaluated for breakpoints.
 * 
 * @author Clemens Kadura (zAJKa)
 */
public class EvaluatedElementWrapper extends SyntaxElement {

	private final ISyntaxElement element;

	public EvaluatedElementWrapper(ISyntaxElement element) {
		this.element = element;
	}

	public ISyntaxElement getElement() {
		return element;
	}

	@Override
	public int getLine() {
		return element.getLine();
	}

	@Override
	public int getEnd() {
		return element.getEnd();
	}

	@Override
	public int getStart() {
		return element.getStart();
	}

	@Override
	public String getFileName() {
		return element.getFileName();
	}
	
	@Override
	public String toString() {
		return element.toString();
	}


}
