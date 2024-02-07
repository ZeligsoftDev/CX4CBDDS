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

import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;

import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.internal.xtend.util.Pair;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public class EvaluationException extends RuntimeException {

	private static final long serialVersionUID = 3781834199930386623L;

	private List<Pair<SyntaxElement, ExecutionContext>> xtendStackTrace = new Stack<Pair<SyntaxElement, ExecutionContext>>();

	public EvaluationException(final String msg, final SyntaxElement element,
			final ExecutionContext ctx) {
		super(msg);
		addStackElement(element, ctx);
	}

	public EvaluationException(final Throwable ex, final SyntaxElement element,
			final ExecutionContext ctx) {
		super((ex.getMessage() == null ? ex.getClass().getName() : ex
				.getMessage()), ex);
		addStackElement(element, ctx);
	}

	public void addStackElement(SyntaxElement ele, ExecutionContext ctx) {
		this.xtendStackTrace.add(new Pair<SyntaxElement, ExecutionContext>(ele,
				ctx));
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer("EvaluationException : "
				+ getMessage() + "\n");
		for (Pair<SyntaxElement, ExecutionContext> ele : xtendStackTrace) {
			result.append(getLocationString(ele.getFirst())).append("\n");
		}
		return result.toString();
	}

	public List<Pair<SyntaxElement, ExecutionContext>> getXtendStackTrace() {
		return xtendStackTrace;
	}

	static String getLocationString(SyntaxElement element) {
		StringBuffer b = new StringBuffer("\t");
		if (element != null) {
			if (element.getFileName() != null) {
				b.append(element.getFileName().replaceAll("/", "::"));
			}
			b.append("[" + element.getStart() + ","
					+ (element.getEnd() - element.getStart()) + "] on line "
					+ element.getLine() + " '" + element + "'");
		} else {
			b.append("Internal error : element was null");
		}
		return b.toString();
	}

	public final static java.util.regex.Pattern P = java.util.regex.Pattern
			.compile("([\\w::]+)\\.(\\w+)\\[(\\d+),(\\d+)\\]");

	public static String getExtXptNamespace(String extXptId) {
		Matcher m = P.matcher(extXptId);
		m.find();
		return m.group(1);
	}

	public static String getExtXptExtension(String extXptId) {
		Matcher m = P.matcher(extXptId);
		m.find();
		return m.group(2);
	}

	public static Integer getOffSet(String extXptId) {
		Matcher m = P.matcher(extXptId);
		m.find();
		return Integer.valueOf(m.group(3));
	}

	public static Integer getLength(String extXptId) {
		Matcher m = P.matcher(extXptId);
		m.find();
		return Integer.valueOf(m.group(4));
	}

}
