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

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;

/**
 * Adapts the deprecated {@link Callback} interface to the new {@link VetoableCallback} interface.
 * @author Achim Demelt
 */
@SuppressWarnings("deprecation")
public class VetoableCallbackAdapter implements VetoableCallback {
	private Callback callback;

	public VetoableCallbackAdapter(Callback oldCallback) {
		this.callback = oldCallback;
	}
	
	public void initialize(WorkflowContext workflowContext, Issues issues) {
		// TODO remove this later
	}

	public void post(SyntaxElement ele, ExecutionContext ctx,
			Object expressionResult) {
		callback.post(expressionResult);
	}

	public boolean pre(SyntaxElement ele, ExecutionContext ctx) {
		callback.pre(ele, ctx);
		return true;
	}
}
