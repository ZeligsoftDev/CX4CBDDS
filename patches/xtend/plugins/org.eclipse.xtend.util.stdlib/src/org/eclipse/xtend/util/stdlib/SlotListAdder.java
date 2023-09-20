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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * This component copies an element from one slot to a list contained in another
 * slot.
 *
 * <h2>Properties</h2>
 * <table border="1">
 * <tr>
 * <th>Property</th>
 * <th>Type</th>
 * <th>Mandatory</th>
 * <th>Description</th>
 * </tr>
 * <td><tt>modelSlot</tt></td>
 * <td>String</td>
 * <td>yes</td>
 * <td>Source slot name.</td>
 * </tr>
 * <tr>
 * <td><tt>listSlot</tt></td>
 * <td>String</td>
 * <td>yes</td>
 * <td>Target slot name. This slot contains a list of elements.</td>
 * </tr>
 * <tr>
 * <tr>
 * <td><tt>uniqueNames</tt></td>
 * <td>boolean</td>
 * <td>no</td>
 * <td>If <code>true</code>, names have to be unique, otherwise not. Requires
 * that <tt>modelSlot</tt> contains an <tt>EObject</tt>.</td>
 * </tr>
 * </table>
 */
public class SlotListAdder extends AbstractWorkflowComponent2 {

	private static final String COMPONENT_NAME = "Slot List Adder";

	private String modelSlot;
	private String listSlot;
	private Set<String> nameSet = new HashSet<String>();
	private boolean uniqueNames;

	/**
	 * Sets the list slot.
	 *
	 * @param listSlot
	 *            name of slot
	 */
	public void setListSlot(String listSlot) {
		this.listSlot = listSlot;
	}

	/**
	 * Sets the model slot.
	 *
	 * @param modelSlot
	 *            name of slot
	 */
	public void setModelSlot(String modelSlot) {
		this.modelSlot = modelSlot;
	}

	/**
	 * Sets if names have to be unique.
	 *
	 * @param uniqueNames
	 *            If <code>true</code>, names have to be unique, otherwise not.
	 */
	public void setUniqueNames(boolean uniqueNames) {
		this.uniqueNames = uniqueNames;
	}

	@Override
	protected void checkConfigurationInternal(Issues issues) {
		if (modelSlot == null) {
			issues.addError(this, "no modelSlot specified.");
		}
		if (listSlot == null) {
			issues.addError(this, "no listSlot specified.");
		}
	}

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getLogMessage()
	 */
	@Override
	public String getLogMessage() {
		return "adding contents of slot '" + modelSlot + "' to the list of stuff in '" + listSlot + "'";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor mon, Issues issues) {
		Object listContent = ctx.get(listSlot);
		if (listContent == null) {
			issues.addWarning("'" + listSlot + "' is empty, creating a new list.", this);
			listContent = new ArrayList<Object>();
			ctx.set(listSlot, listContent);
		}
		if (!(listContent instanceof Collection)) {
			issues.addError("contents of '" + listSlot + "' slot is not a collection, but rather a '"
					+ listSlot.getClass().getName() + "'", this);
			return;
		}
		Object modelContent = ctx.get(modelSlot);
		if (modelContent == null) {
			issues
					.addWarning("'" + modelSlot + "' is empty; not adding anything to the '" + listSlot + "' slot.",
							this);
			return;
		}
		if (uniqueNames) {
			EObject eo = (EObject) modelContent;
			DynamicEcoreHelper h = new DynamicEcoreHelper(eo);
			String name = h.getName(eo);
			if (!nameSet.contains(name)) {
				((Collection) listContent).add(modelContent);
				nameSet.add(name);
			}
		}
		else {
			((Collection) listContent).add(modelContent);
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
