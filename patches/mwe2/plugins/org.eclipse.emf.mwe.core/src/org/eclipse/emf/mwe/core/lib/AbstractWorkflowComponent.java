/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.mwe.core.lib;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.mwe.core.WorkflowComponentWithID;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.internal.core.ast.parser.Location;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

/**
 * Base class useful for implementing custom WorkflowComponents.
 * 
 */
public abstract class AbstractWorkflowComponent implements WorkflowComponentWithID, IWorkflowComponent {

	private static final Logger log = LogManager.getLogger(AbstractWorkflowComponent.class);

	/** The component's id */
	private String componentID;

	private boolean skipOnErrors = false;

	/** Container component */
	private CompositeComponent container;

	private Location location;

	/**
	 * Utility method that can be used in method <code>checkConfiguration</code>
	 * to check required properties. If <code>configPropertyValue</code> is
	 * <code>null</code> or a blank string then this method will add an error
	 * issue.
	 * 
	 * @param configPropertyName
	 *            Name of the checked config property.
	 * @param configPropertyValue
	 *            The config property value.
	 * @param issues
	 *            The Issues instance.
	 */
	public void checkRequiredConfigProperty(final String configPropertyName, final Object configPropertyValue,
			final Issues issues) {
		boolean isError = false;
		if (configPropertyValue == null) {
			isError = true;
		}
		else if ((configPropertyValue instanceof String) && isBlank(configPropertyValue.toString())) {
			isError = true;
		}

		if (isError) {
			issues.addError("'" + configPropertyName + "' not specified.");
		}
	}

	/**
	 * Returns the component's name.
	 * 
	 * Overridable by custom components.
	 * 
	 * @return simple class name by default
	 * @since 4.3.1
	 */
	@Override
	public String getComponentName() {
		return getClass().getSimpleName();
	}

	/**
	 * @return The containing component if any
	 */
	@Override
	public CompositeComponent getContainer() {
		return container;
	}

	/**
	 * @see org.eclipse.emf.mwe.core.WorkflowComponentWithID#getId()
	 */
	@Override
	public String getId() {
		return componentID;
	}

	/**
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#getLocation()
	 */
	@Override
	public Location getLocation() {
		return location;
	}

	/**
	 * @see org.eclipse.emf.mwe.core.WorkflowComponentWithID#getLogMessage()
	 */
	@Override
	public String getLogMessage() {
		return null;
	}

	/**
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#invoke(org.eclipse.emf.mwe.core.WorkflowContext,
	 *      org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 *      org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	public final void invoke(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
		if (monitor != null) {
			if (monitor.isCanceled())
				return;
			monitor.beginTask("Running " + getComponentName() + "...", ProgressMonitor.UNKNOWN);
		}
		try {
			if (skipOnErrors && issues.hasErrors()) {
				log.info("execution skipped, since there are errors and skipOnErrors is set.");
				return;
			}
			invokeInternal(ctx, monitor, issues);
		} finally {
			if (monitor != null) {
				monitor.done();
			}
		}
		
	}

	/**
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#setContainer(org.eclipse.emf.mwe.core.container.CompositeComponent)
	 */
	@Override
	public void setContainer(final CompositeComponent container) {
		this.container = container;
	}

	/**
	 * @see org.eclipse.emf.mwe.core.WorkflowComponentWithID#setId(java.lang.String)
	 */
	@Override
	public void setId(final String id) {
		componentID = id;
	}

	/**
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#setLocation(org.eclipse.emf.mwe.internal.core.ast.parser.Location)
	 */
	@Override
	public void setLocation(final Location location) {
		this.location = location;
	}

	/**
	 * Sets if the current component should be skipped if previous components
	 * caused errors.
	 * 
	 * @param skipOnErrors
	 *            if <code>true</code>, the current component is skipped if
	 *            errors have occurred, if <code>false</code>, the component is
	 *            not skipped.
	 */
	public void setSkipOnErrors(final boolean skipOnErrors) {
		this.skipOnErrors = skipOnErrors;
	}

	/**
	 * Internal method for component execution.
	 * 
	 * @param ctx
	 *            the workflow context
	 * @param monitor
	 *            the progress monitor
	 * @param issues
	 *            container of execution issues
	 */
	protected abstract void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues);

	private boolean isBlank(final String string) {
		if ((string == null) || string.trim().equals(""))
			return true;

		return false;
	}
	
	private Mwe2Bridge bridge;
	
	protected Mwe2Bridge getBridge() {
		if (bridge == null)
			bridge = new Mwe2Bridge(this);
		return bridge;
	}
	
	@Override
	public void preInvoke() {
		getBridge().preInvoke();
	}
	
	@Override
	public void invoke(final IWorkflowContext ctx) {
		getBridge().invoke(ctx);
	}

	@Override
	public void postInvoke() {
		getBridge().postInvoke();
	}
}
