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

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * This component copies an element from one slot to another. The slot content
 * is <i>not cloned</i>. <h2>Properties</h2>
 * <table border="1">
 * <tr>
 * <th>Property</th>
 * <th>Type</th>
 * <th>Mandatory</th>
 * <th>Description</th>
 * </tr>
 * <tr>
 * <td><tt>fromSlot</tt></td>
 * <td>String</td>
 * <td>yes</td>
 * <td>Source slot name.</td>
 * </tr>
 * <tr>
 * <td><tt>toSlot</tt></td>
 * <td>String</td>
 * <td>yes</td>
 * <td>Destination slot name.</td>
 * </tr>
 * <tr>
 * <td><tt>removeTopLevelList</tt></td>
 * <td>boolean</td>
 * <td>no</td>
 * <td>If <code>true</code> the source slot must contain a list and the top
 * level list is removed (i.e. the first element from the list is copied to the
 * destination slot), otherwise it is not removed.</td>
 * </tr>
 * </table>
 */
public class SlotCopier extends AbstractWorkflowComponent2 {

	private static final String COMPONENT_NAME = "Slot Copier";

	private String fromSlot;
	private String toSlot;
	private boolean removeTopLevelList = false;

	private Logger log = LogManager.getLogger(getClass());

	@Override
	protected void checkConfigurationInternal(Issues issues) {
		if ((fromSlot == null) || fromSlot.trim().equals("")) {
			issues.addError(this, "fromSlot not specified");
		}
		if ((toSlot == null) || toSlot.trim().equals("")) {
			issues.addError(this, "toSlot not specified");
		}
	}

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getLogMessage()
	 */
	@Override
	public String getLogMessage() {
		return "slot '" + fromSlot + "' -> slot '" + toSlot + "'";
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor mon, Issues issues) {
		Object content = ctx.get(fromSlot);
		if (content == null) {
			issues.addWarning(this, "fromSlot is null!");
		}
		else {
			if ((content instanceof List) && removeTopLevelList) {
				log.info("copying first element of " + content + " [" + content.getClass().getName() + "]");
				ctx.set(toSlot, ((List<?>) content).get(0));
			}
			else {
				log.info("copying " + content + " [" + content.getClass().getName() + "]");
				ctx.set(toSlot, content);
			}
		}
	}

	/**
	 * Sets the source slot.
	 *
	 * @param fromSlot
	 *            name of slot
	 */
	public void setFromSlot(String fromSlot) {
		this.fromSlot = fromSlot;
	}

	/**
	 * Sets the destination slot.
	 *
	 * @param toSlot
	 *            name of slot
	 */
	public void setToSlot(String toSlot) {
		this.toSlot = toSlot;
	}

	/**
	 * Enables or disables the removal of the top level list.
	 *
	 * @param removeTopLevelList
	 *            If <code>true</code>, the top level list is removed, otherwise
	 *            it is not removed.
	 */
	public void setRemoveTopLevelList(boolean removeTopLevelList) {
		this.removeTopLevelList = removeTopLevelList;
	}

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getComponentName()
	 */
	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}
}
