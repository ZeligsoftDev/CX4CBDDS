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
package org.eclipse.internal.xtend.xtend.ast;

import java.util.List;

import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.expression.ast.Identifier;

public abstract class AbstractExtensionDefinition extends AbstractExtension{
	
	public AbstractExtensionDefinition(final Identifier name, final Identifier returnType, final List<DeclaredParameter> formalParameters,
			final boolean cached, final boolean isPrivate) {
		super(name, returnType, formalParameters, cached, isPrivate);
	}
	
	abstract public Expression getExpression();
}
