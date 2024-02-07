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

import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.xtend.expression.ExecutionContext;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 */
public class Definition extends AbstractDefinition {
	
	public Definition(final Identifier name, final Identifier type, final DeclaredParameter[] params, final Statement[] body) {
		super(name, type, params, body);
	}

	@Override
	public String getNameString(ExecutionContext context) {
		return "DEFINE";
	}

}
