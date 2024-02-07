/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.internal.xpand2.ast;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.xtend.XtendFile;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtend.expression.AnalysationIssue;

/**
 * @author Karsten Thoms - Initial contribution and API
 * @since 1.0
 */
public class ExtensionImportDeclaration extends ImportDeclaration {
	public ExtensionImportDeclaration(final Identifier importString) {
		super(importString);
	}

	@Override
	public void analyze(XpandExecutionContext ctx, Set<AnalysationIssue> issues) {
		try {
			if (ctx.getCallback() != null)
				if (!ctx.getCallback().pre(this, ctx))
					return;

			final String importStringValue = this.getImportString().toString();
			final XtendFile xf = (XtendFile) ctx.getResourceManager().loadResource(
					importStringValue, XtendFile.FILE_EXTENSION);
			if (xf == null) {
				final String msg = "Error while importing extension: Resource " + importStringValue
						+ " not found.";
				issues.add(new AnalysationIssue(AnalysationIssue.RESOURCE_NOT_FOUND, msg, this));
			} else {
				Set<AnalysationIssue> tempIssues = new HashSet<AnalysationIssue>();
				xf.analyze(ctx, tempIssues);
				boolean noErrors = true;
				for (AnalysationIssue issue : tempIssues){
					if (issue.isError()){
						noErrors = false;
						break;
					}
				}
				if (!noErrors) {
					final String msg = "Imported extension resource " + importStringValue
					+ " has errors.";
					issues.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, msg, this, true));
				}
			}
		}
		finally {
			if (ctx.getCallback() != null)
				ctx.getCallback().post(this, ctx, null);
		}
	}

}
