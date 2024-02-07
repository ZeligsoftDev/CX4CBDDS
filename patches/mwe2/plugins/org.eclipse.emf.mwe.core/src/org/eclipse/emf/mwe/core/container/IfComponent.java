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
package org.eclipse.emf.mwe.core.container;

public class IfComponent extends ConditionalComponent {

	public IfComponent() {
		super("if");
	}

	private String condition = null;

	/**
	 * Sets the condition.
	 * 
	 * @param condition
	 *            the condition
	 */
	public void setCond(final String condition) {
		this.condition = condition;
	}

	/**
	 * @see org.eclipse.emf.mwe.core.container.WorkflowConditional#evaluate()
	 */
	@Override
	public boolean evaluate() {
		return Boolean.valueOf(condition).booleanValue();
	}

	/**
	 * @see org.eclipse.emf.mwe.core.container.CompositeComponent#getLogMessage()
	 */
	@Override
	public String getLogMessage() {
		return "if ( " + condition + " ): " + evaluate();
	}
}
