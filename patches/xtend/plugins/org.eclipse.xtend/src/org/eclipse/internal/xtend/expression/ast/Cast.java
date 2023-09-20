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

import java.util.Set;

import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.typesystem.ParameterizedType;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 * @author Bernd Kolb
 * 
 */
public class Cast extends Expression {

	private final Identifier type;

	private final Expression target;

	public Cast(final Identifier type, final Expression target) {
		this.type = type;
		this.target = target;
	}

	public Expression getTarget() {
		return target;
	}

	public Identifier getType() {
		return type;
	}

	@Override
	public Object evaluateInternal(final ExecutionContext ctx) {
		return getTarget().evaluate(ctx);
	}

	@Override
	public Type analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		final Type t = getTarget().analyze(ctx, issues);

		final Type toCast = findType(getType(), ctx, issues);
		if (toCast == null) {
			issues.add(new AnalysationIssue(AnalysationIssue.TYPE_NOT_FOUND, "Couldn't find type " + getType().toString(), getType()));
			return null;
		}
		if (t == null) {
			return null;
		}
		if ((t instanceof ParameterizedType) && (toCast instanceof ParameterizedType)) {
			if (t.isAssignableFrom(toCast)) {
				final Type innerType = getCastedType(((ParameterizedType) t).getInnerType(), ((ParameterizedType) toCast).getInnerType(),
						ctx.getObjectType());
				if (innerType == null) {
					issues.add(new AnalysationIssue(AnalysationIssue.INCOMPATIBLE_TYPES, "cannot cast from " + t.toString() + " to "
							+ toCast.toString(), this));
					return null;
				}
				return ((ParameterizedType) toCast).cloneWithInnerType(innerType);
			} else if (toCast.isAssignableFrom(t)) {
				final Type innerType = getCastedType(((ParameterizedType) t).getInnerType(), ((ParameterizedType) toCast).getInnerType(),
						ctx.getObjectType());
				if (innerType == null) {
					issues.add(new AnalysationIssue(AnalysationIssue.INCOMPATIBLE_TYPES, "cannot cast from " + t.toString() + " to "
							+ toCast.toString(), this));
					return null;
				}
				return ((ParameterizedType) t).cloneWithInnerType(innerType);
			} else {
				issues.add(new AnalysationIssue(AnalysationIssue.INCOMPATIBLE_TYPES, "cannot cast from " + t.toString() + " to " + toCast.toString(),
						this));
				return null;
			}
		}

		final Type rt = getCastedType(t, toCast, ctx.getObjectType());
		if (rt == null) {
			issues.add(new AnalysationIssue(AnalysationIssue.INCOMPATIBLE_TYPES, "cannot cast from " + t.toString() + " to " + toCast.toString(),
					this));
		}
		return rt;
	}

	private Type getCastedType(final Type typeA, final Type typeB, final Type objType) {
		final Type _typeA = typeA != null ? typeA : objType;
		final Type _typeB = typeB != null ? typeB : objType;

		if (_typeA.isAssignableFrom(_typeB)) {
			return _typeB;
		} else if (_typeB.isAssignableFrom(_typeA)) {
			return _typeA;
		}
		return null;
	}

	@Override
	protected String toStringInternal() {
		return "(" + type.toString() + ")" + target.toString();
	}

}
