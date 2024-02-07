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
package org.eclipse.xtend.util.stdlib;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Java helper class for Stdlib extension
 * <tt>org::eclipse::xtend::util::stdlib::issues</tt>.
 */
public class ExtIssueReporter extends AbstractWorkflowComponent2 {
	private static final String ERROR_CONFIGURE = "You must run the org.eclipse.xtend.util.stdlib.ExtIssueReporter component before using the issue reporting utilities.";

	private static final String COMPONENT_NAME = "External Issue Reporter";

	static ThreadLocal<Issues> tl = new ThreadLocal<Issues>();

	@Override
	protected void checkConfigurationInternal(Issues arg0) {
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor mon, Issues issues) {
		tl.set(issues);
	}

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getLogMessage()
	 */
	@Override
	public String getLogMessage() {
		return "setting up issue logging from within .ext and .xpt files";
	}

	/**
	 * Reports an error.
	 * 
	 * @param message
	 *            the error message
	 * @return the passed in error message
	 */
	public static String reportError(String message) {
		getIssues().addError(message);
		return message;
	}

	private static Issues getIssues() {
		Issues issues = tl.get();
		if (issues == null)
			throw new WorkflowInterruptedException(ERROR_CONFIGURE);
		return issues;
	}

	/**
	 * Reports a warning.
	 * 
	 * @param message
	 *            the warning message
	 * @return the passed in warning message
	 */
	public static String reportWarning(String message) {
		getIssues().addWarning(message);
		return message;
	}

	/**
	 * Reports an error.
	 * 
	 * @param qfn
	 *            a qualified filename
	 * @param message
	 *            the error message
	 * @return the passed in error message
	 */
	public static String reportError(String qfn, String message) {
		if (tl.get() == null) {
			System.err.println(ERROR_CONFIGURE);
		}
		getIssues().addError("[" + qfn + "] " + message);
		return message;
	}

	/**
	 * Reports a warning.
	 * 
	 * @param qfn
	 *            a qualified filename
	 * @param message
	 *            the warning message
	 * @return the passed in warning message
	 */
	public static String reportWarning(String qfn, String message) {
		if (tl.get() == null) {
			System.err.println(ERROR_CONFIGURE);
		}
		getIssues().addWarning("[" + qfn + "] " + message);
		return message;
	}

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getComponentName()
	 */
	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}

}
