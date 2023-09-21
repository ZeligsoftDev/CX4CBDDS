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
package org.eclipse.internal.xpand2.debug;

import org.eclipse.emf.mwe.core.debug.model.SyntaxElement;
import org.eclipse.internal.xpand2.ast.ForEachStatement;
import org.eclipse.internal.xtend.expression.debug.BaseSpecialTreatment;
import org.eclipse.xtend.expression.ExecutionContext;

/**
 * Adapter to handle FOREACH statement special stuff.
 * 
 * @author Clemens Kadura (zAJKa)
 * @author Jan Koehnlein
 */
public class ForEachSpecial extends BaseSpecialTreatment {

	private ForEachStatement lastForEachInAdaptSyntaxElementTO;
	private ForEachStatement lastForEachInShallSuspend;
	int iterationCounter;

	/**
	 * A ForEachStatement calls monitor.preTask() always twice. First time for
	 * the (outer) statement and 2nd time for each loop. We disable suspension
	 * the first time.
	 * 
	 * @see org.eclipse.internal.xtend.expression.debug.BaseSpecialTreatment#shallNotSuspend(java.lang.Object,
	 *      int,ExecutionContext)
	 */
	@Override
	public boolean shallNotSuspend(Object element, int flag, ExecutionContext ctx) {
		if (element instanceof ForEachStatement) {
			if (element.equals(lastForEachInShallSuspend))
				return false;
			lastForEachInShallSuspend = (ForEachStatement) element;
			iterationCounter = 0;
			return true;
		}
		return false;
	}

	/**
	 * Don't show frame in Launch view, if the ForEachStatement is the 1st time
	 * in the stack.
	 * 
	 * @see org.eclipse.internal.xtend.expression.debug.BaseSpecialTreatment#adaptSyntaxElement(org.eclipse.emf.mwe.core.debug.model.SyntaxElement,
	 *      java.lang.Object)
	 */
	@Override
	public void adaptSyntaxElement(SyntaxElement to, Object element) {
		if (element instanceof ForEachStatement) {
			if (!element.equals(lastForEachInAdaptSyntaxElementTO)) {
				to.visible = false;
				lastForEachInAdaptSyntaxElementTO = (ForEachStatement) element;
			}
			else {
				to.elementName = to.elementName + " #" + (iterationCounter++);
			}
		}
	}

}
