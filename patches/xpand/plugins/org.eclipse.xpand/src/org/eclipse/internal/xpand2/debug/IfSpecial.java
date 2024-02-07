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

import org.eclipse.internal.xpand2.ast.IfStatement;
import org.eclipse.internal.xtend.expression.ast.ISyntaxElement;
import org.eclipse.internal.xtend.expression.debug.BaseSpecialTreatment;
import org.eclipse.xtend.expression.ExecutionContext;

/**
 * Adapter to handle IF statement special stuff.
 * 
 * @author Clemens Kadura (zAJKa)
 */
public class IfSpecial extends BaseSpecialTreatment {
	
	@Override
	public int getElementNameLength(ISyntaxElement se) {
		if (se instanceof IfStatement)
			return adaptElementName(se, null).length();
		return -1;
	}

	@Override
	public String adaptElementName(ISyntaxElement se, ExecutionContext context) {
		if (se instanceof IfStatement) {
			IfStatement iff = (IfStatement) se;
			return (iff.isElseIf() ? "ELSEIF" : (iff.isElse() ? "ELSE" : "IF"));
		}
		return "";
	}

}
