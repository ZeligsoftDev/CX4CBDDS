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

package org.eclipse.internal.xtend.expression.ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 * @author Bernd Kolb
 */
public class ListLiteral extends Expression {
	private static final Expression[] NO_EXPRESSION = new Expression[0];
	private final Expression[] elements;

	public ListLiteral(final Expression[] contents) {
		elements = (contents != null) && (contents.length > 0) ? contents
				: NO_EXPRESSION;
	}

	public Expression[] getElements() {
		return elements;
	}

	public List<Expression> getElementsAsList() {
		return Arrays.asList(elements);
	}

	@Override
	public Object evaluateInternal(final ExecutionContext ctx) {
		final List<Object> col = new ArrayList<Object>();
		final Expression[] params = getElements();
		for (Expression param : params) {
			col.add(param.evaluate(ctx));
		}
		return col;
	}

	@Override
	public Type analyzeInternal(final ExecutionContext ctx,
			final Set<AnalysationIssue> issues) {
		Type t = null;
		for (final Expression element : elements) {
			final Type exprType = element.analyze(ctx, issues);
			if (exprType == null) {
				return null;
			}
			if ((t == null) || exprType.isAssignableFrom(t)) {
				t = exprType;
			}
		}
		return ctx.getListType(t);
	}

	@Override
	protected String toStringInternal() {
		return "{" + expressionsToString() + "}";
	}

	private String expressionsToString() {
		String r = "";
		for (int i = 0; i < elements.length; i++) {
			r += elements[i].toString();
			if ((i + 1) < elements.length) {
				r += ",";
			}

		}
		return r;
	}

}
