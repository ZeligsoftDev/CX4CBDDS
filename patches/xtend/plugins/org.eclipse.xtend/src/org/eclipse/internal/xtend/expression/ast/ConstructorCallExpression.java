/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.internal.xtend.expression.ast;

import java.util.Set;

import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.EvaluationException;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Bernd Kolb
 * @author Karsten Thoms
 */
public class ConstructorCallExpression extends Expression {

	private final Identifier type;

	public ConstructorCallExpression(final Identifier type) {
		this.type = type;
	}

	public Identifier getType() {
		return type;
	}

	public String getTypeName() {
		return type.toString();
	}

	@Override
	protected Object evaluateInternal(final ExecutionContext ctx) {
		final Type t = ctx.getTypeForName(type.toString());
		if (t != null) {
			return t.newInstance();
		}
		throw new EvaluationException("Couldn't find type " + type, this, ctx);
	}

	@Override
	public Type analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		final Type t = ctx.getTypeForName(type.toString());
		if (t == null) {
			issues.add(new AnalysationIssue(AnalysationIssue.TYPE_NOT_FOUND, "Type not found : " + type, type));
		}
		// TODO add isAbstract to Type and check it here!
		return t;
	}

	@Override
	protected String toStringInternal() {
		return "new " + getTypeName();
	}

}
