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

import java.util.List;

import org.eclipse.emf.mwe.core.debug.model.NameValuePair;
import org.eclipse.emf.mwe.core.debug.model.SyntaxElement;
import org.eclipse.internal.xpand2.ast.ExpandStatement;
import org.eclipse.internal.xpand2.ast.FileStatement;
import org.eclipse.internal.xpand2.ast.Statement;
import org.eclipse.internal.xpand2.ast.TextStatement;
import org.eclipse.internal.xtend.expression.debug.ExpressionElementAdapter;
import org.eclipse.internal.xtend.expression.debug.NoResourceSpecial;

/**
 * The IElementAdapter implementation for Xpand statements.
 * 
 * @author Clemens Kadura (zAJKa)
 */
public class XpandElementAdapter extends ExpressionElementAdapter {

	public static final String TYPE = "xpand";

	// -------------------------------------------------------------------------

	public XpandElementAdapter() {
		super();
		specials.add(new ForEachSpecial());
		specials.add(new ExpandSpecial());
		specials.add(new IfSpecial());
		specials.add(new NoResourceSpecial());
		pres = new XpandModelPresentation(specials);
	}

	// -------------------------------------------------------------------------

	@Override
	public String getAdapterType() {
		return TYPE;
	}

	// -------------------------------------------------------------------------

	@Override
	public boolean canHandle(Object element) {
		if (element instanceof Statement)
			return true;
		
		if (element instanceof org.eclipse.internal.xtend.expression.ast.SyntaxElement)
			return true;

		if (element instanceof SyntaxElement) {
			String fileName = ((SyntaxElement) element).resource;
			if (fileName == null)
				return false;

			return fileName.endsWith(".xpt");
		}

		return false;
	}

	@Override
	public boolean shallHandle(Object element) {
		if (element instanceof ExpandStatement) {
			String fileName = ((ExpandStatement) element).getFileName();
			if (fileName == null || fileName.isEmpty())
				return false;
		}
		if (element instanceof TextStatement)
			return false;
		if (element instanceof Statement)
			return true;
		return super.shallHandle(element);
	}

	@Override
	public boolean isSurroundingElement(Object element) {
		boolean result;
		result = element instanceof FileStatement;
		result |= element instanceof ExpandStatement;
		return result;
	}

	@Override
	public SyntaxElement createEndElementTO(Object element) {
		// Note: is only called with elements of the above mentioned types
		return pres.getEndPresentation((Statement) element, context);
	}

	@Override
	public List<NameValuePair> getVariables(Object element) {

		// Beispiel wie inspect implementiert werden kann (hat hier nichts zu
		// suchen, nur als Gedankenstuetze CK)
		// ExpressionFacade ef = new ExpressionFacade(getCtx());
		// Object evaluate = ef.evaluate("");
		// getAllPropertiesFor(getCtx().getType(evaluate), evaluate);

		if (element instanceof Statement)
			return getAllVisibleVariables();
		return super.getVariables(element);
	}

	@Override
	public Object findElement(SyntaxElement se, Object actual, int flag) {
		if (actual == null)
			return null;
		if (actual instanceof Statement) {
			Statement op = (Statement) actual;
			int start = pres.getStart(op);
			if (se.resource.endsWith(pres.getStringRep(op.getFileName())) && se.start == start)
				return actual;
		}
		return super.findElement(se, actual, flag);
	}

}
