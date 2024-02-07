/*******************************************************************************
 * Copyright (c) 2005 - 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.internal.xtend.expression.debug;

import org.eclipse.emf.mwe.core.debug.model.SyntaxElement;
import org.eclipse.emf.mwe.core.debug.processing.EventHandler;
import org.eclipse.xtend.expression.ExecutionContext;

/**
 * Adapter to handle statements that don't have an associated resource. (mainly the initial one)
 * 
 * @author Clemens Kadura (zAJKa)
 * @author Aykut Kilic (itemis) - Bug#465802
 */
public class NoResourceSpecial extends BaseSpecialTreatment {

	/**
	 * Don't suspend for normal frame, if the element has no resource (virtual ones)
	 * 
	 * @see org.eclipse.internal.xtend.expression.debug.BaseSpecialTreatment#shallNotSuspend(java.lang.Object, int,
	 *      org.eclipse.xtend.expression.ExecutionContext)
	 */
	@Override
	public boolean shallNotSuspend(final Object element, final int flag, final ExecutionContext ctx) {
		return (flag == EventHandler.NORMAL_FRAME) && !hasResource(element);
	}

	/**
	 * Don't show frame in Launch view, if the element has no resource (virtual ones)
	 * 
	 * @see org.eclipse.internal.xtend.expression.debug.BaseSpecialTreatment#adaptSyntaxElement(SyntaxElement, java.lang.Object)
	 */
	@Override
	public void adaptSyntaxElement(final SyntaxElement to, final Object element) {
		if (!hasResource(element)) {
			to.visible = false;
		}
	}

	// -------------------------------------------------------------------------

	private boolean hasResource(final Object element) {
		// return getClass().getResource("/" + ((org.eclipse.internal.xtend.expression.ast.SyntaxElement) element).getFileName()) != null;
		return true;
	}

}
