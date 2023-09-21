/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xpand2.ast;

import java.util.Set;

import org.eclipse.internal.xpand2.pr.ProtectedRegion;
import org.eclipse.internal.xpand2.pr.ProtectedRegionSyntaxException;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.EvaluationException;

/**
 * *
 * 
 * @author Sven Efftinge (http://www.efftinge.de) *
 */
public class ProtectStatement extends StatementWithBody {

	private final Expression commentStart;

	private final Expression commentEnd;

	private final Expression id;

	private final boolean disable;

	public ProtectStatement(final Expression commentStart, final Expression commentEnd, final Statement[] body,
			final Expression id, final boolean disable) {
		super(body);
		this.commentStart = commentStart;
		this.commentEnd = commentEnd;
		this.id = id;
		this.disable = disable;
	}

	public Expression getCommentEnd() {
		return commentEnd;
	}

	public Expression getCommentStart() {
		return commentStart;
	}

	public Expression getId() {
		return id;
	}

	public boolean getDisable() {
		return disable;
	}

	@Override
	public void analyzeInternal(final XpandExecutionContext ctx, final Set<AnalysationIssue> issues) {
		getCommentStart().analyze(ctx, issues);
		getCommentEnd().analyze(ctx, issues);
		getId().analyze(ctx, issues);

		for (final Statement element : body) {
			element.analyze(ctx, issues);
		}
	}

	@Override
	public void evaluateInternal(final XpandExecutionContext ctx) {
		final String cStart = nullSafe(getCommentStart().evaluate(ctx));
		if (cStart == null)
			throw new EvaluationException("NullEvaluation!", getCommentStart(), ctx);
		final String cEnd = nullSafe(getCommentEnd().evaluate(ctx));
		if (cEnd == null)
			throw new EvaluationException("NullEvaluation!", getCommentEnd(), ctx);
		final String id = nullSafe(getId().evaluate(ctx));
		if (id == null)
			throw new EvaluationException("NullEvaluation!", getId(), ctx);

		ProtectedRegion region = null;
		if (ctx.getProtectedRegionResolver() != null) {
			region = ctx.getProtectedRegionResolver().getProtectedRegion(id.toString());
		}
		else
			throw new EvaluationException("No protected region resolver configured!", this, ctx);

		if (region == null) {
			region = ctx.getProtectedRegionResolver().createProtectedRegion(id, disable);
			ctx.getOutput().write(region.getStartString(cStart, cEnd));
			for (final Statement element : body) {
				element.evaluate(ctx);
			}
			ctx.getOutput().write(region.getEndString(cStart, cEnd));
		}
		else {
			ctx.getOutput().write(region.getStartString(cStart, cEnd));
			try {
				ctx.getOutput().write(region.getBody(cStart, cEnd));
			}
			catch (final ProtectedRegionSyntaxException e) {
				throw new EvaluationException(e.getMessage(), getId(), ctx);
			}
			ctx.getOutput().write(region.getEndString(cStart, cEnd));
		}

	}

	private String nullSafe(final Object string) {
		return string != null ? string.toString() : "";
	}

}
