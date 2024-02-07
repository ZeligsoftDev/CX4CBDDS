/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.internal.xtend.xtend.ast;

import java.util.Set;

import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.TypeNameUtil;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Karsten Thoms - Initial contribution and API
 */
public class NamespaceImportStatement extends SyntaxElement {

	private final Identifier importedId;

	public NamespaceImportStatement(final Identifier importedID) {
		importedId = importedID;
	}

	public Identifier getImportedId() {
		return importedId;
	}

	public void analyze(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		try {
			if (ctx.getCallback() != null) {
				if (!ctx.getCallback().pre(this, ctx)) {
					return;
				}
			}
			boolean knownNamespace = false;
			final String importedIdValue = importedId.toString();
			if (!ctx.getNamespaces().contains(importedIdValue)) {
				for (Type t : ctx.getAllTypes()) {
					if (importedIdValue.equals(TypeNameUtil.withoutLastSegment(t.getName()))) {
						knownNamespace = true;
						break;
					}
				}
			} else {
				knownNamespace = true;
			}
			if (!knownNamespace) {
				final String msg = "Namespace " + importedIdValue + " is unknown or unused.";
				issues.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, msg, this, true));
			}
		} finally {
			if (ctx.getCallback() != null) {
				ctx.getCallback().post(this, ctx, null);
			}
		}
	}

}
