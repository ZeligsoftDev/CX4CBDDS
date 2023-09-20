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
package org.eclipse.internal.xtend.expression.ast;

import org.eclipse.xtend.expression.ExecutionContext;

public interface ISyntaxElement {
	public int getLine();

	public int getEnd();

	public int getStart();

	public String getFileName();
	
	public String getNameString(ExecutionContext context);

	public Object accept(final AbstractVisitor visitor);
}
