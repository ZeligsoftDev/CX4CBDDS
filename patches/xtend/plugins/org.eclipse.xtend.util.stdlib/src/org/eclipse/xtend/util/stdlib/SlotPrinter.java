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

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * This component prints a workflow context slot content to the log. <h2>
 * Properties</h2>
 * <table border="1">
 * <tr>
 * <th>Property</th>
 * <th>Type</th>
 * <th>Mandatory</th>
 * <th>Description</th>
 * </tr>
 * <tr>
 * <td><tt>slotName</tt></td>
 * <td>String</td>
 * <td>yes</td>
 * <td>The name of a slot whose content should be dumped.</td>
 * </tr>
 * <tr>
 * <td><tt>message</tt></td>
 * <td>String</td>
 * <td>no</td>
 * <td>An optional message that will be prefixed to the log output.</td>
 * </tr>
 * <tr>
 * <td><tt>level</tt></td>
 * <td>String</td>
 * <td>no</td>
 * <td>The log level for the message. Valid values are
 * <tt>TRACE, DEBUG, INFO, WARN</tt>.</td>
 * </tr>
 * </table>
 */
public class SlotPrinter extends AbstractWorkflowComponent2 {
	private static final Logger LOG = LogManager.getLogger(SlotPrinter.class);
	private static final int TRACE = 0;
	private static final int DEBUG = 1;
	private static final int INFO = 2;
	private static final int WARN = 3;
	private static final String[] LEVELS = { "TRACE", "DEBUG", "INFO", "WARN" };

	private static final String COMPONENT_NAME = "Slot Printer";

	private String slotName;
	private String message;
	private int level = INFO;

	/**
	 * Sets the message.
	 * 
	 * @param msg
	 *            the message
	 */
	public void setMessage(String msg) {
		this.message = msg;
	}

	/**
	 * Sets the slot name.
	 * 
	 * @param name
	 *            name of slot
	 */
	public void setSlotName(String name) {
		this.slotName = name;
	}

	/**
	 * Sets the log level
	 * 
	 * @param lvl
	 *            The log level (TRACE, DEBUG, INFO, WARN, ERROR, FATAL).
	 */
	public void setLevel(String lvl) {
		int i = Arrays.binarySearch(LEVELS, lvl);
		if (i == -1)
			throw new IllegalArgumentException(lvl);
		level = i;
	}

	@Override
	protected void checkConfigurationInternal(Issues issues) {
		if (slotName == null) {
			issues.addError(this, "slotName not specified");
		}
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		StringBuffer b = new StringBuffer();
		if (message != null) {
			b.append(message + ": ");
		}
		b.append("(slot: " + slotName + ")");
		b.append(ctx.get(slotName));

		switch (level) {
			case TRACE:
				LOG.trace(b);
				break;
			case DEBUG:
				LOG.debug(b);
				break;
			case INFO:
				LOG.info(b);
				break;
			case WARN:
				LOG.warn(b);
				break;
		}
	}

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getComponentName()
	 */
	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}
}
