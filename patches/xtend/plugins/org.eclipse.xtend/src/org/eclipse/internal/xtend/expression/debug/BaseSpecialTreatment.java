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
import org.eclipse.internal.xtend.expression.ast.ISyntaxElement;
import org.eclipse.xtend.expression.ExecutionContext;

/**
 * Base class for all special treatments for element adapters.
 * 
 * @author Clemens Kadura (zAJKa)
 */
public abstract class BaseSpecialTreatment {

	public boolean shallNotSuspend(Object element, int flag, ExecutionContext context) {
		return false;
	}

	public void adaptSyntaxElement(SyntaxElement to, Object element) {
		// empty implementation
	}

	/**
	 * add syntax element specific content to the element name that will be shown in Launch view
	 * @param se the syntax element
	 * @param context the execution context
	 * @return the special text to add to the name
	 */
	public String adaptElementName(ISyntaxElement se, ExecutionContext context){
		return "";
	}

	public ISyntaxElement getSpecialEndSyntaxElement(ISyntaxElement se){
		return null;
	}

	public int getElementNameLength(ISyntaxElement se) {
		return -1;
	}

}
