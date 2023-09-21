/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xpand2.ast;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.internal.xpand2.XpandTokens;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.TypeNameUtil;
import org.eclipse.xtend.typesystem.Type;

/**
 * 
 * 
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Karsten Thoms
 */
public class ImportDeclaration extends SyntaxElement implements XpandAnalyzable {

    private Identifier importString;

    public ImportDeclaration(final Identifier importString) {
        this.importString = importString;
    }

    public Identifier getImportString() {
        return importString;
    }

	public void analyze(XpandExecutionContext ctx, Set<AnalysationIssue> issues) {
		try {
			if (ctx.getCallback() != null)
				if (!ctx.getCallback().pre(this, ctx))
					return;
			boolean knownNamespace = false;
			final String importStringValue = importString.toString();
			if (!ctx.getNamespaces().contains(importStringValue)) {
				for (Type t : ctx.getAllTypes()) {
					if (importStringValue.equals(TypeNameUtil.withoutLastSegment(t.getName()))) {
						knownNamespace = true;
						break;
					}
				}
			} else {
				knownNamespace = true;
			}
			if (!knownNamespace) {
				Template tpl = (Template) ctx.currentResource();
		    	final Set<String> targetNamespaces = new HashSet<String>();
		    	for (AbstractDefinition def : tpl.getAllDefinitions()) {
		    		def.accept(new AbstractXpandVisitor() {
		    			@Override
		    			protected Object visitExpandStatement(ExpandStatement node) {
		    				if (node.getTargetNamespace() != null) {
		    					targetNamespaces.add(node.getTargetNamespace());
		    				}
		    				return super.visitExpandStatement(node);
		    			}
		    		});
		    	}
				for (String namespace : targetNamespaces) {
					if (importStringValue.equals(namespace)) {
						knownNamespace = true;
						break;
					}
				}
			}
			if (!knownNamespace) {
				final String msg = "Namespace " + importStringValue + " is unknown or unused.";
				issues.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, msg, this, true));
			}
		}
		finally {
			if (ctx.getCallback() != null)
				ctx.getCallback().post(this, ctx, null);
		}
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
			.append(XpandTokens.LT)
			.append(XpandTokens.IMPORT)
			.append(" ")
			.append(importString)
			.append(XpandTokens.RT)
			.append(" (")
			.append(this.getFileName())
			.append('@')
			.append(getLine())
			.append(':')
			.append(getStart())
			.append('-')
			.append(getEnd())
			.append(")")
			.toString();
	}
}
