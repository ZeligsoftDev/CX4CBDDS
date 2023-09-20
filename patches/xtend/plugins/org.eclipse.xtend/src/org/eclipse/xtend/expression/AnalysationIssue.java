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
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public class AnalysationIssue {

	private enum AnalysationIssueSeverity {
		WARNING, ERROR
	}

	public final static class AnalysationIssueType {
		String name;

		public AnalysationIssueType(final String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}

	}

	public final static AnalysationIssueType INCOMPATIBLE_TYPES = new AnalysationIssueType("Incompatible types");

	public final static AnalysationIssueType UNNECESSARY_CAST = new AnalysationIssueType("Unnecessary cast");

	public final static AnalysationIssueType FEATURE_NOT_FOUND = new AnalysationIssueType("Callable not found");

	public static final AnalysationIssueType TYPE_NOT_FOUND = new AnalysationIssueType("AnalysationIssueType not found");

	public static final AnalysationIssueType INTERNAL_ERROR = new AnalysationIssueType("Internal error");

	public static final AnalysationIssueType JAVA_TYPE_NOT_FOUND = new AnalysationIssueType("Java AnalysationIssueType not found");

	public static final AnalysationIssueType SYNTAX_ERROR = new AnalysationIssueType("Syntax error");

	public static final AnalysationIssueType RESOURCE_NOT_FOUND = new AnalysationIssueType("Resource not found");

	private final AnalysationIssueType analysationIssueType;

	private final String message;

	private final SyntaxElement element;

	private final AnalysationIssueSeverity severity;

	private int onLine;

	public AnalysationIssue(final AnalysationIssueType analysationIssueType, final String message, final SyntaxElement element) {
		this(analysationIssueType, message, element, false);
	}

	public AnalysationIssue(final AnalysationIssueType analysationIssueType, final String message, final SyntaxElement element, final boolean warning) {
		if ((analysationIssueType == null) || (message == null) || (message.length() == 0) || (element == null)) {
			throw new IllegalArgumentException();
		}

		this.analysationIssueType = analysationIssueType;
		this.message = message;
		this.element = element;
		if (warning) {
			severity = AnalysationIssueSeverity.WARNING;
		} else {
			severity = AnalysationIssueSeverity.ERROR;
		}
	}

	public AnalysationIssue(final AnalysationIssueType analysationIssueType, final String message, final SyntaxElement element,
			final boolean warning, final int onLine) {
		if ((analysationIssueType == null) || (message == null) || (message.length() == 0) || (element == null)) {
			throw new IllegalArgumentException();
		}

		this.analysationIssueType = analysationIssueType;
		this.message = message;
		this.element = element;
		if (warning) {
			severity = AnalysationIssueSeverity.WARNING;
		} else {
			severity = AnalysationIssueSeverity.ERROR;
		}
		this.onLine = onLine;
	}

	public SyntaxElement getElement() {
		return element;
	}

	public String getMessage() {
		return message;
	}

	public AnalysationIssueType getType() {
		return analysationIssueType;
	}

	public boolean isError() {
		return severity == AnalysationIssueSeverity.ERROR;
	}

	public boolean isWarning() {
		return severity == AnalysationIssueSeverity.WARNING;
	}

	public int getOnLine() {
		return onLine;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("[").append(analysationIssueType.name).append("] - ").append(message).append(" : ").append(element)
				.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((analysationIssueType == null) ? 0 : analysationIssueType.hashCode());
		result = (prime * result) + ((element == null) ? 0 : element.hashCode());
		result = (prime * result) + ((message == null) ? 0 : message.hashCode());
		result = (prime * result) + onLine;
		result = (prime * result) + ((severity == null) ? 0 : severity.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AnalysationIssue other = (AnalysationIssue) obj;
		if (analysationIssueType != other.analysationIssueType) {
			return false;
		}
		if (onLine != other.onLine) {
			return false;
		}
		if (severity != other.severity) {
			return false;
		}
		if (element == null ? other.element == null : element != other.element) {
			return false;
		}
		if (message == null ? other.message != null : !message.equals(other.message)) {
			return false;
		}
		return true;
	}
}
