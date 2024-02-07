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

package org.eclipse.internal.xtend.xtend.parser;

import java.util.List;

import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.expression.parser.ExpressionFactory;
import org.eclipse.internal.xtend.xtend.ast.Around;
import org.eclipse.internal.xtend.xtend.ast.Check;
import org.eclipse.internal.xtend.xtend.ast.CreateExtensionStatement;
import org.eclipse.internal.xtend.xtend.ast.ExpressionExtensionStatement;
import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.internal.xtend.xtend.ast.ExtensionFile;
import org.eclipse.internal.xtend.xtend.ast.ExtensionImportStatement;
import org.eclipse.internal.xtend.xtend.ast.JavaExtensionStatement;
import org.eclipse.internal.xtend.xtend.ast.NamespaceImportStatement;

public class ExtensionFactory extends ExpressionFactory {

	public ExtensionFactory() {
		super("nofile");
	}

	public ExtensionFactory(final String string) {
		super(string);
	}

	public ExtensionFile createExtensionFile(final List<NamespaceImportStatement> nsimports, final List<ExtensionImportStatement> extimports,
			final List<Extension> extensions, final List<Around> arounds, final List<Check> checks) {
		return (ExtensionFile) handle(new ExtensionFile(nsimports, extimports, extensions, arounds, checks));
	}

	public NamespaceImportStatement createNsImport(final Identifier t) {
		return handle(new NamespaceImportStatement(t));
	}

	public ExtensionImportStatement createExtensionFileImport(final Identifier t, final Identifier exported) {
		return handle(new ExtensionImportStatement(t, exported != null));
	}

	public JavaExtensionStatement createJavaExtension(final Identifier name, final Identifier type, final List<DeclaredParameter> params,
			final Identifier typeName, final Identifier methodName, final List<Identifier> javaParamTypes, final Identifier cached,
			final Identifier priv) {
		return handle(new JavaExtensionStatement(name, params, type, typeName, methodName, javaParamTypes, cached != null, priv != null));
	}

	public ExpressionExtensionStatement createExpressionExtension(final Identifier name, final Identifier returnType,
			final List<DeclaredParameter> params, final Expression expr, final Identifier cached, final Identifier priv) {
		return handle(new ExpressionExtensionStatement(name, returnType, params, expr, cached != null, priv != null));
	}

	public Extension createCreateExtension(final Identifier create, final Identifier returnType, final Identifier rtn, final Identifier name,
			final List<DeclaredParameter> params, final Expression expr, final Identifier priv) {
		return handle(new CreateExtensionStatement(name, returnType, rtn != null ? rtn : null, params, expr, priv != null));
	}

	public Around createAround(final Identifier pointcut, final List<DeclaredParameter> p, final boolean wildparams, final Expression expr) {
		return handle(new Around(pointcut, p, wildparams, expr));
	}

	public Check createCheck(final Identifier t, final Identifier f, final Expression guard, final boolean errorSev, final Expression msg,
			final Expression expr) {
		return handle(new Check(t, f, guard, errorSev, msg, expr));
	}

}
