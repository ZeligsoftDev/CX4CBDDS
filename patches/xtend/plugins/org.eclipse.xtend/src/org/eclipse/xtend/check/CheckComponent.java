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

package org.eclipse.xtend.check;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.ExpressionFacade;

public class CheckComponent extends AbstractExpressionsUsingWorkflowComponent {

	private static final String COMPONENT_NAME = "Check component";

	private String expression = null;

	private final List<String> checkFiles = new ArrayList<String>();

	private boolean abortOnError = true;

	private boolean warnIfNothingChecked = false;

	private String emfAllChildrenSlot;

	/**
	 * Sets if execution should be aborted on error.
	 * 
	 * @param abortOnError
	 *            If <code>true</code>, the execution is aborted on error, otherwise, the execution is continued normally.
	 */
	public void setAbortOnError(final boolean abortOnError) {
		this.abortOnError = abortOnError;
	}

	/**
	 * @since 1.4
	 */
	public boolean isAbortOnError() {
		return abortOnError;
	}

	/**
	 * Adds a check file.
	 * 
	 * @param checkFile
	 *            the check file
	 */
	public void addCheckFile(final String checkFile) {
		checkFiles.add(checkFile);
	}

	/**
	 * @since 1.4
	 */
	public List<String> getCheckFiles() {
		return Collections.unmodifiableList(checkFiles);
	}

	/**
	 * Sets the expression to check. This property only works for non-EMF based models. For EMF based models, use
	 * <code>setEmfAllChildrenSlot(String)</code>.
	 * 
	 * @param expression
	 *            the expression to check
	 */
	public void setExpression(final String expression) {
		this.expression = expression;
	}

	/**
	 * @since 1.4
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * Sets if a warning should be issued if nothing has been checked.
	 * 
	 * @param warn
	 *            If <code>true</code>, a warning is issued in case nothing has been checked, otherwise no warning is issued.
	 */
	public void setWarnIfNothingChecked(final boolean warn) {
		warnIfNothingChecked = warn;
	}

	/**
	 * @since 1.4
	 */
	public boolean isWarnIfNothingChecked() {
		return warnIfNothingChecked;
	}

	/**
	 * Sets the expression for the <code>emfAllChildren</code> property. This property only works for EMF based models. For all other kinds of models
	 * use <code>setExpression(String)</code>.
	 * 
	 * @param childExpression
	 *            the expression
	 */
	public void setEmfAllChildrenSlot(final String childExpression) {
		emfAllChildrenSlot = childExpression;
	}

	/**
	 * @since 1.4
	 */
	public String getEmfAllChildrenSlot() {
		return emfAllChildrenSlot;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLogMessage() {
		StringBuilder b = new StringBuilder();
		if (emfAllChildrenSlot != null) {
			b.append("slot " + emfAllChildrenSlot + " ");
		} else {
			b.append("expression " + expression + " ");
		}
		b.append("check file(s): ");
		for (String f : checkFiles) {
			b.append(f + " ");
		}
		return b.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}

	@Override
	protected void invokeInternal2(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
		final ExecutionContextImpl executionContext = getExecutionContext(ctx);
		if (monitor != null) {
			executionContext.setMonitor(monitor);
		}

		final Collection<?> model = getExpressionResult(executionContext, ctx, getExpression());

		for (String checkFile : getCheckFiles()) {
			CheckFacade.checkAll(checkFile, model, executionContext, issues, isWarnIfNothingChecked());
		}

		if (isAbortOnError() && issues.hasErrors()) {
			throw new WorkflowInterruptedException("Errors during validation.");
		}
	}

	@Override
	protected void checkConfigurationInternal(final Issues issues) {
		super.checkConfigurationInternal(issues);

		if ((getExpression() == null) && (getEmfAllChildrenSlot() != null)) {
			setExpression(getEmfAllChildrenSlot() + ".eAllContents.union( {" + getEmfAllChildrenSlot() + "} )");
		} else if ((getExpression() != null) && (getEmfAllChildrenSlot() == null)) {
			// ok - do nothing, expression already has a reasonable value
		} else {
			issues.addError(this, "You have to set one of the properties 'expression' and 'emfAllChildrenSlot'!");
		}
		if (getCheckFiles().isEmpty()) {
			issues.addError(this, "Property 'checkFile' not set!");
		}
	}

	/**
	 * @since 1.4
	 */
	protected Collection<?> getExpressionResult(final ExecutionContext exeCtx, final WorkflowContext context, final String expression2) {
		final ExpressionFacade f = new ExpressionFacade(exeCtx);
		final Map<String, Object> ctx = new HashMap<String, Object>();
		final String[] names = context.getSlotNames();
		for (final String name : names) {
			ctx.put(name, context.get(name));
		}
		final Object result = f.evaluate(expression2, ctx);
		if (result instanceof Collection) {
			return (Collection<?>) result;
		} else if (result == null) {
			return Collections.EMPTY_SET;
		} else {
			return Collections.singleton(result);
		}

	}
}
