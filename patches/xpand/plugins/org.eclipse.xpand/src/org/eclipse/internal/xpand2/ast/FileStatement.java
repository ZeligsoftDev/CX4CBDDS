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

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.util.Pair;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.output.InsertionPointSupport;
import org.eclipse.xpand2.output.VetoException;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.EvaluationException;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.Type;

/**
 * *
 * 
 * @author Sven Efftinge (http://www.efftinge.de) *
 */
public class FileStatement extends StatementWithBody {
	private static final Logger LOG = LogManager.getLogger(FileStatement.class);

	private Expression fileNameExpression;

	private Identifier outletNameIdentifier;

	public FileStatement(final Expression fileName, final Statement[] body, final Identifier mode) {
		super(body);
		this.fileNameExpression = fileName;
		this.outletNameIdentifier = mode;
	}

	public Expression getTargetFileName() {
		return fileNameExpression;
	}

	public Identifier getMode() {
		return outletNameIdentifier;
	}

	public String getOutletName() {
		if (outletNameIdentifier == null)
			return null;
		return outletNameIdentifier.toString();
	}

	@Override
	public void analyzeInternal(XpandExecutionContext ctx, final Set<AnalysationIssue> issues) {
		final Type result = getTargetFileName().analyze(ctx, issues);
		ctx = (XpandExecutionContext) ctx.cloneWithVariable(new Variable("FILENAME", result));
		if (!ctx.getStringType().isAssignableFrom(result)) {
			issues.add(new AnalysationIssue(AnalysationIssue.INCOMPATIBLE_TYPES, "String expected!",
					getTargetFileName()));
		}
		for (int i = 0; i < body.length; i++) {
			body[i].analyze(ctx, issues);
		}
	}

	@Override
	public void evaluateInternal(XpandExecutionContext ctx) {
		final Object result = getFilename(ctx);
		String fileName = result.toString();
		final String outletName = getOutletName();

		ctx = (XpandExecutionContext) ctx.cloneWithVariable(new Variable("FILENAME", result));
		try {
			ctx.getOutput().openFile(fileName, outletName);
			for (int i = 0; i < body.length; i++) {
				body[i].evaluate(ctx);
			}
			for (Pair<XpandExecutionContextImpl,Statement> deferredStatement : ((XpandExecutionContextImpl)ctx).getDeferredStatements()) {
				Statement stmt = deferredStatement.getSecond();
				if (!(ctx.getOutput() instanceof InsertionPointSupport)) {
					throw new IllegalStateException ("Output does not support insertion points.");
				}
				((InsertionPointSupport)ctx.getOutput()).activateInsertionPoint(stmt);
				stmt.evaluate(deferredStatement.getFirst());
				((InsertionPointSupport)ctx.getOutput()).deactivateInsertionPoint(stmt);
			}
			ctx.getOutput().closeFile();
		} catch (VetoException e) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Generation of file '"+fileName+"' on outlet '"+outletName+"' skipped due to veto.");
			}
		}
	}

	@Override
	public String getNameString(ExecutionContext context) {
		return "FILE";
	}

	private Object getFilename(XpandExecutionContext ctx) {
		final Object result = getTargetFileName().evaluate(ctx);
		if (result == null)
			throw new EvaluationException("Nullevaluation", getTargetFileName(), ctx);
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("«FILE ");
		b.append(fileNameExpression);
		if (outletNameIdentifier!=null) {
			b.append(" "+outletNameIdentifier);
		}
		b.append("»...«ENDFILE»");
		return b.toString();
	}

}
