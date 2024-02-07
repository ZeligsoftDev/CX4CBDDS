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


import static org.eclipse.emf.mwe.core.debug.processing.EventHandler.NORMAL_FRAME;

import java.util.Collection;
import java.util.Stack;

import org.eclipse.emf.mwe.core.debug.model.SyntaxElement;
import org.eclipse.internal.xpand2.ast.ExpandStatement;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.expression.ast.ISyntaxElement;
import org.eclipse.internal.xtend.expression.debug.BaseSpecialTreatment;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.typesystem.Type;

/**
 * An ExpandStatement calls monitor.preTask() always twice in case of isForeach. The first call is for the
 * Statement itself and the second for every execution of the included definition.<br>
 * We remember each call on a Stack and use the first entry to store count and number of loops.<br>
 * This (outer) frame is hiddened.<br>
 * <br>
 * We do this whole mechanism (different from the Java behavior) that the user can go over one execution of the
 * EXPAND with Step_Over and go over all loops with Step_Return. In Java this behavior is not possible. There is
 * the Ctrl+R functionality, what is not implemented for our debug model.<br>
 * <br>
 * We can't use an empty iterator as in Foreach, because an expand could be called iteratively.<br>
 * Therefore we remember each 2nd time the statement together with it's target element count.
 * 
 * @author Clemens Kadura (zAJKa)
 */
public class ExpandSpecial extends BaseSpecialTreatment {

	private Stack<Wrapper> stack = new Stack<Wrapper>();

	private Stack<ISyntaxElement> sstack = new Stack<ISyntaxElement>();

	private ISyntaxElement lastSingleDef;

	private int adaptCnt = 0;

	@Override
	public boolean shallNotSuspend(Object element, int flag, ExecutionContext ctx) {
		if (!(element instanceof ExpandStatement))
			return false;
		ExpandStatement stmt = (ExpandStatement) element;

		if (!((ExpandStatement) element).isForeach()) {
			if (flag == NORMAL_FRAME) {
				Expression target = stmt.getTarget();
				Object targetObject = (target != null ? target.evaluate(ctx) : ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE).getValue());
				sstack.push(getEvaluatedDefinition((ExpandStatement) element, targetObject, (XpandExecutionContext) ctx));
			} else
				// we have to remeber this, because it is earlier poped than red
				lastSingleDef = sstack.pop();
			return false;
		}

		if (flag == NORMAL_FRAME) {
			Wrapper current = new Wrapper();
			Wrapper last = (!stack.isEmpty()) ? stack.peek() : null;
			stack.push(current);
			if (stack.size() % 2 != 0) {
				current.target = stmt.getTarget().evaluate(ctx);
				// disable suspension the first time
				return true;
			}
			// 2nd time
			last.def = getEvaluatedDefinition((ExpandStatement) element, ((Collection<?>) last.target).toArray()[last.count],
					(XpandExecutionContext) ctx);
			last.count++;
			return false;
		}
		if (adaptCnt >= stack.size())
			adaptCnt--;
		stack.pop();
		return stack.size() % 2 == 0;
	}

	@Override
	public void adaptSyntaxElement(SyntaxElement to, Object element) {
		if (!(element instanceof ExpandStatement) || !((ExpandStatement) element).isForeach())
			return;
		if (adaptCnt % 2 != 0)
			to.visible = false;
	}

	@Override
	public String adaptElementName(ISyntaxElement se, ExecutionContext context) {
		if (!(se instanceof ExpandStatement) || !((ExpandStatement) se).isForeach())
			return "";
		adaptCnt++;
		if (adaptCnt % 2 == 0) {
			Wrapper last = stack.get(adaptCnt - 2);
			return " " + last.count + " of " + ((Collection<?>) last.target).size();
		}
		return "";
	}

	@Override
	public ISyntaxElement getSpecialEndSyntaxElement(ISyntaxElement se) {
		if (!(se instanceof ExpandStatement))
			return null;
		if (((ExpandStatement) se).isForeach()) {
			return stack.peek().def;
		}
		return lastSingleDef;
	}

	// -------------------------------------------------------------------------

	private ISyntaxElement getEvaluatedDefinition(ExpandStatement stmt, Object targetObject, XpandExecutionContext ctx) {
		Expression[] pex = stmt.getParameters();
		Object[] params = new Object[pex.length];
		for (int i = 0; i < pex.length; i++) {
			params[i] = pex[i].evaluate(ctx);
		}
		Type[] paramTypes = new Type[params.length];
		for (int i = 0; i < params.length; i++) {
			paramTypes[i] = ctx.getType(params[i]);
		}
		String defName = stmt.getDefinition().toString();
		return ctx.findDefinition(defName, ctx.getType(targetObject), paramTypes);
	}

	// -------------------------------------------------------------------------

	class Wrapper {
		public Object target;

		public ISyntaxElement def;

		public int count;
	}

}
