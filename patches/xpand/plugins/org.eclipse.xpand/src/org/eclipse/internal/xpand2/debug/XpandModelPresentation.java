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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.mwe.core.debug.model.SyntaxElement;
import org.eclipse.internal.xpand2.ast.Definition;
import org.eclipse.internal.xpand2.ast.ErrorStatement;
import org.eclipse.internal.xpand2.ast.ExpandStatement;
import org.eclipse.internal.xpand2.ast.FileStatement;
import org.eclipse.internal.xpand2.ast.ForEachStatement;
import org.eclipse.internal.xpand2.ast.IfStatement;
import org.eclipse.internal.xpand2.ast.LetStatement;
import org.eclipse.internal.xpand2.ast.ProtectStatement;
import org.eclipse.internal.xpand2.ast.Statement;
import org.eclipse.internal.xpand2.model.AdvicedDefinition;
import org.eclipse.internal.xpand2.model.XpandDefinition;
import org.eclipse.internal.xtend.expression.ast.ISyntaxElement;
import org.eclipse.internal.xtend.expression.debug.BaseSpecialTreatment;
import org.eclipse.internal.xtend.expression.debug.ExpressionModelPresentation;
import org.eclipse.xtend.expression.ExecutionContext;

/**
 * This class is responsible for all presentation topics for Xpand statements in
 * the debugger views.
 * 
 * @author Clemens Kadura (zAJKa)
 * @author Karsten Thoms - maintenance
 * @author Aykut Kilic (itemis) - Bug#480646
 */
public class XpandModelPresentation extends ExpressionModelPresentation {

	public class ElementRepresentation {
		String startName;

		String endName;

		public ElementRepresentation(String startName, String endName) {
			this.startName = startName;
			this.endName = endName;
		}
	}

	public static Map<Class<? extends ISyntaxElement>, ElementRepresentation> eReps = new HashMap<Class<? extends ISyntaxElement>, ElementRepresentation>();

	{
		eReps.put(FileStatement.class, new ElementRepresentation("FILE", "ENDFILE"));
		eReps.put(ExpandStatement.class, new ElementRepresentation("EXPAND", "ENDDEFINE"));
		eReps.put(Definition.class, new ElementRepresentation("DEFINE", "ENDDEFINE"));
		eReps.put(AdvicedDefinition.class, new ElementRepresentation("AROUND", "ENDAROUND"));

		eReps.put(ForEachStatement.class, new ElementRepresentation("FOREACH", "ENDFOREACH"));
		eReps.put(IfStatement.class, new ElementRepresentation("IF", "ENDIF"));
		eReps.put(LetStatement.class, new ElementRepresentation("LET", "ENDLET"));
		eReps.put(ProtectStatement.class, new ElementRepresentation("PROTECT", "ENDPROTECT"));

		eReps.put(ErrorStatement.class, new ElementRepresentation("ERROR", ""));
	}

	// -------------------------------------------------------------------------

	public XpandModelPresentation(Set<BaseSpecialTreatment> specials) {
		super(specials);
	}

	// -------------------------------------------------------------------------

	@Override
	public SyntaxElement getStartPresentation(ISyntaxElement stmt, ExecutionContext context) {
		SyntaxElement to = new SyntaxElement();
		to.containerName = getContainerName(stmt);
		to.elementName = getStartingElementName(stmt, context);
		to.resource = getResource(stmt);
		to.start = stmt.getStart();
		to.end = getStartingEndPosition(stmt);
		to.line = stmt.getLine();
		return to;
	}

	@Override
	public SyntaxElement getEndPresentation(ISyntaxElement element, ExecutionContext context) {
		SyntaxElement to = new SyntaxElement();

		// Hint: for the end presentation we have to deal with types Statement
		// and AbstractDefinition what is not a Statement !!
		ISyntaxElement se = getEndSyntaxElement(element);
		to.containerName = getContainerName(se);
		to.elementName = getEndElementName(se);
		to.resource = getResource(se);
		to.start = getEndStartPosition(se);
		to.end = se.getEnd();
		to.line = se.getLine();// TODO: Known issue: "last line" is not stored.
								// How to calculate it?
		return to;
	}

	// -------------------------------------------------------------------------
	// containerName

	@Override
	protected String getContainerName(ISyntaxElement se) {
		XpandDefinition def;
		
		if (se instanceof XpandDefinition) {
			def = (XpandDefinition) se;
		} else if( se instanceof Statement) {
			def = ((Statement) se).getContainingDefinition();
		} else {
			def = null;
		}

		if (def != null) 
			return getTemplateName(se) + "::" + getDefinitionName(def);

		return "";
	}

	private String getDefinitionName(XpandDefinition def) {
		return def.getName() + def.getParamString(true) + " FOR " + def.getTargetType();
	}

	// -------------------------------------------------------------------------
	// elementName

	private String getStartingElementName(ISyntaxElement se, ExecutionContext context) {
		return se.getNameString(context);
		// TODO: CK: to be finished for 4.2 final
		// ElementRepresentation rep = eReps.get(se.getClass());
		// StringBuilder name = new StringBuilder();
		// for (BaseSpecialTreatment special : specials)
		// name.append(special.adaptElementName(se, context));
		//
		// if (name.length() == 0 && rep != null)
		// name.append(rep.startName);
		//
		// if (name.length() == 0)
		// name.append(se.toString());
		//
		// return name.toString();
	}

	private String getEndElementName(ISyntaxElement se) {
		ElementRepresentation rep = eReps.get(se.getClass());
		return (rep != null) ? rep.endName : ((Statement) se).getContainingDefinition().toString();
	}

	// -------------------------------------------------------------------------
	// start

	private int getEndStartPosition(ISyntaxElement se) {
		ElementRepresentation rep = eReps.get(se.getClass());
		return (rep != null) ? se.getEnd() - rep.endName.length() : se.getStart();
	}

	// -------------------------------------------------------------------------
	// end

	@Override
	public int getStartingEndPosition(ISyntaxElement stmt) {
		ElementRepresentation rep = eReps.get(stmt.getClass());
		int startLength = (rep != null ? rep.startName.length() : 0);
		for (BaseSpecialTreatment special : specials) {
			int length = special.getElementNameLength(stmt);
			if (length != -1) {
				startLength = length;
				break;
			}
		}
		return (rep != null && startLength > 0) ? stmt.getStart() + startLength : stmt.getEnd();
	}

	// -------------------------------------------------------------------------

	private ISyntaxElement getEndSyntaxElement(ISyntaxElement stmt) {
		for (BaseSpecialTreatment special : specials) {
			ISyntaxElement se = special.getSpecialEndSyntaxElement(stmt);
			if (se != null)
				return se;
		}
		return stmt;
	}

}
