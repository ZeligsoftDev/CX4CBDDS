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

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Prints a message to the log.
 */
public class MessageLogger extends AbstractWorkflowComponent2 {
	private static final Logger LOG = LogManager.getLogger(MessageLogger.class);

	private static final String COMPONENT_NAME = "Message Logger";

	private String message;

	/**
	 * Sets the message.
	 * 
	 * @param msg
	 *            the message
	 */
	public void setMessage(String msg) {
		message = msg;
	}

	@Override
	protected void checkConfigurationInternal(Issues issues) {
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		LOG.info(message);
	}

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getComponentName()
	 */
	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}
}
