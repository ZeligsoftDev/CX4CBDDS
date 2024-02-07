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
package org.eclipse.xpand.util.stdlib;

import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.util.stdlib.TraceComponent;

public class TracingOutput extends OutputImpl {

	/**
	 * @see org.eclipse.xpand2.output.OutputImpl#pushStatement(org.eclipse.internal.xtend.expression.ast.SyntaxElement,
	 *      org.eclipse.xpand2.XpandExecutionContext)
	 */
	@Override
	public void pushStatement(SyntaxElement stmt, XpandExecutionContext ctx) {
		super.pushStatement(stmt, ctx);
	}

	/**
	 * @see org.eclipse.xpand2.output.OutputImpl#openFile(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void openFile(String path, String outletName) {
		super.openFile(path, outletName);
		TraceComponent.reportFileOpen(path);
	}

	/**
	 * @see org.eclipse.xpand2.output.OutputImpl#closeFile()
	 */
	@Override
	public void closeFile() {
		super.closeFile();
		TraceComponent.reportFileClose();
	}

}
