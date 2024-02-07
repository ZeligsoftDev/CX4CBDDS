/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xtend.xtend.ast;

import java.util.Set;

import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.internal.xtend.xtend.XtendFile;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;

public class ExtensionImportStatement extends SyntaxElement {

    private Identifier importedId;

    private boolean exported;

    public ExtensionImportStatement(final Identifier importedID,
            final boolean exported) {
        importedId = importedID;
        this.exported = exported;
    }

    public Identifier getImportedId() {
        return importedId;
    }

    public boolean isExported() {
        return exported;
    }

	public void analyze(ExecutionContext ctx, Set<AnalysationIssue> issues) {
		try {
			if (ctx.getCallback() != null)
				if (!ctx.getCallback().pre(this, ctx))
					return;
			final XtendFile xf = (XtendFile) ctx.getResourceManager().loadResource(this.getImportedId().toString(),
					XtendFile.FILE_EXTENSION);
			if (xf == null) {
				final String msg = "Error while importing extension: File " + this.getImportedId().toString() + " not found.";
				issues.add(new AnalysationIssue(AnalysationIssue.RESOURCE_NOT_FOUND, msg, this));
			}
		} finally {
			if (ctx.getCallback() != null)
				ctx.getCallback().post(this, ctx, null);
		}
	}

}
