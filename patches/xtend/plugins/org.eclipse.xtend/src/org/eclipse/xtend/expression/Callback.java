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
package org.eclipse.xtend.expression;

import org.eclipse.internal.xtend.expression.ast.SyntaxElement;

/**
 * an instance of this interface can be injected into the execution context. It is notified before and after analyzation/evaluation of each AST node.
 * 
 * @author Sven Efftinge
 * @deprecated Use {@link VetoableCallback} instead
 */
@Deprecated
public interface Callback {
	/**
	 * @param ele
	 * @param ctx
	 */
	void pre(SyntaxElement ele, ExecutionContext ctx);

	/**
	 * @param expressionResult
	 *            the result of the evaluation (an instance of {@link org.eclipse.xtend.typesystem.Type} in analyzation phase) if syntax element was
	 *            an instance of {@link org.eclipse.internal.xtend.expression.ast.Expression}
	 */
	void post(Object expressionResult);
}
