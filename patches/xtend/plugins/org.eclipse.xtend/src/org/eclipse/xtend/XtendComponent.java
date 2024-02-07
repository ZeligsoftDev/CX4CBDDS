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
package org.eclipse.xtend;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.ExpressionFacade;
import org.eclipse.xtend.expression.Resource;
import org.eclipse.xtend.expression.Variable;

public class XtendComponent extends AbstractExpressionsUsingWorkflowComponent {
	private static final String COMPONENT_NAME = "Xtend Component";

	private String extensionFile = null;

	private final List<String> extensionAdvices = new ArrayList<String>();

	/** Stores the value of the 'invoke' property. Needed for error analysis. */
	private String invokeExpression;

	private String expression = null;

	private String outputSlot = WorkflowContext.DEFAULT_SLOT;

	/**
	 * Adds an extension advice.
	 * 
	 * @param extensionAdvice
	 *            the advice
	 */
	@Override
	public void addExtensionAdvice(final String extensionAdvice) {
		if (!extensionAdvices.contains(extensionAdvice)) {
			extensionAdvices.add(extensionAdvice);
		}
	}

	/**
	 * @since 1.4
	 */
	protected List<String> getExtensionAdvices() {
		return Collections.unmodifiableList(extensionAdvices);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void checkConfigurationInternal(final Issues issues) {
		super.checkConfigurationInternal(issues);

		// Try to create detailed error message (see Bug#172567)
		final String compPrefix = getId() != null ? getId() + ": " : "";

		if ((getInvoke() == null) || (getInvoke().trim().length() == 0)) {
			issues.addError(compPrefix + "Property 'invoke' not specified.");
			return;
		}
		if (getExtensionFile() == null) {
			issues.addError(compPrefix + "Error parsing property 'invoke': Could not extract name of the extension file.");
			return;
		}

		final InputStream in = ResourceLoaderFactory.createResourceLoader().getResourceAsStream(getExtensionFile().replace("::", "/") + ".ext");
		if ((in == null) || (getExpression() == null)) {
			issues.addError(compPrefix + "Property 'invoke' not specified properly. AbstractExtension file '" + getExtensionFile() + "' not found.");
			return;
		}

		try {
			in.close();
		} catch (final IOException e) {
			log.error("I/O exception", e);
		}

		if (getExpression() == null) {
			issues.addError(compPrefix + "Error parsing property 'invoke': Could not extract the expression to invoke in extension file '"
					+ getExtensionFile() + "'.");
			return;
		}

	}

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getLogMessage()
	 */
	@Override
	public String getLogMessage() {
		return "executing '" + getExtensionFile() + "'";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void invokeInternal2(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {

		final InputStream in = ResourceLoaderFactory.createResourceLoader().getResourceAsStream(getExtensionFile().replace("::", "/") + ".ext");
		if (in == null) {
			issues.addError("Cannot find extension file: " + getExtensionFile());
			return;
		}
		try {
			in.close();
		} catch (final IOException e) {
			log.error("I/O exception", e);
		}

		ExecutionContextImpl ec = getExecutionContext(ctx);

		for (final String advice : getExtensionAdvices()) {
			final String[] allAdvices = advice.split(",");
			for (final String string : allAdvices) {
				ec.registerExtensionAdvices(string.trim());
			}
		}

		ec = (ExecutionContextImpl) ec.cloneWithResource(new Resource() {
			private String name = "noName";

			public String getFullyQualifiedName() {
				return name;
			}

			public String[] getImportedExtensions() {
				return new String[] { getExtensionFile() };
			}

			public String[] getImportedNamespaces() {
				return new String[0];
			}

			public void setFullyQualifiedName(final String fqn) {
				name = fqn;
			}
		});
		final String[] slots = ctx.getSlotNames();
		for (final String slot : slots) {
			ec = (ExecutionContextImpl) ec.cloneWithVariable(new Variable(slot, ctx.get(slot)));
		}

		if (monitor != null) {
			ec.setMonitor(monitor);
		}

		final Object result = new ExpressionFacade(ec).evaluate(getExpression());
		ctx.set(getOutputSlot(), result);
	}

	/**
	 * Sets the invoke expression.
	 * 
	 * @param invokeExpr
	 *            the invoke expression
	 */
	public void setInvoke(final String invokeExpr) {
		invokeExpression = invokeExpr;
		final int i = invokeExpr.lastIndexOf("::");
		if (i != -1) {
			extensionFile = invokeExpr.substring(0, i);
			expression = invokeExpr.substring(i + 2);
		} else {
			expression = invokeExpr;
		}
	}

	/**
	 * @since 1.4
	 */
	protected String getInvoke() {
		return invokeExpression;
	}

	/**
	 * @since 1.4
	 */
	protected String getExtensionFile() {
		return extensionFile;
	}

	/**
	 * @since 1.4
	 */
	protected String getExpression() {
		return expression;
	}

	/**
	 * Sets the output slot.
	 * 
	 * @param outputSlot
	 *            the output slot
	 */
	public void setOutputSlot(final String outputSlot) {
		this.outputSlot = outputSlot;
	}

	/**
	 * @since 1.4
	 */
	protected String getOutputSlot() {
		return outputSlot;
	}

	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}

}
