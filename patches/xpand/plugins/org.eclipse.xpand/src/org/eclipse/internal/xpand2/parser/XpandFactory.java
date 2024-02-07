/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html Contributors: committers of
 * openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xpand2.parser;

import java.util.List;

import org.eclipse.internal.xpand2.XpandTokens;
import org.eclipse.internal.xpand2.ast.Advice;
import org.eclipse.internal.xpand2.ast.Definition;
import org.eclipse.internal.xpand2.ast.ErrorStatement;
import org.eclipse.internal.xpand2.ast.ExpandStatement;
import org.eclipse.internal.xpand2.ast.ExpressionStatement;
import org.eclipse.internal.xpand2.ast.ExtensionImportDeclaration;
import org.eclipse.internal.xpand2.ast.FileStatement;
import org.eclipse.internal.xpand2.ast.ForEachStatement;
import org.eclipse.internal.xpand2.ast.IfStatement;
import org.eclipse.internal.xpand2.ast.ImportDeclaration;
import org.eclipse.internal.xpand2.ast.LetStatement;
import org.eclipse.internal.xpand2.ast.ProtectStatement;
import org.eclipse.internal.xpand2.ast.Statement;
import org.eclipse.internal.xpand2.ast.Template;
import org.eclipse.internal.xpand2.ast.TextStatement;
import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.expression.parser.ExpressionFactory;

/**
 * Factory for Xpand AST elements.
 * 
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Karsten Thoms - Bug#401282
 */
public class XpandFactory extends ExpressionFactory {

  private static final ImportDeclaration[] EMPTY_IMPORTDECLARATIONS = new ImportDeclaration[0];
  private static final ExtensionImportDeclaration[] EMPTY_EXTENSIONIMPORTDECLARATIONS =
      new ExtensionImportDeclaration[0];
  private static final Definition[] EMPTY_DEFINITIONS = new Definition[0];
  private static final Advice[] EMPTY_ADVICES = new Advice[0];
  private static final DeclaredParameter[] EMPTY_DECLAREDPARAMETERS = new DeclaredParameter[0];
  private static final Statement[] EMPTY_STATEMENTS = new Statement[0];
  private static final Expression[] EMPTY_EXPRESSIONS = new Expression[0];

  public XpandFactory(final String fileName) {
    super(fileName);
  }

  public Template createTemplate(final List<ImportDeclaration> imports,
      final List<ExtensionImportDeclaration> extensions, final List<Definition> defines, final List<Advice> advices) {
    final ImportDeclaration[] i = toArray(imports, EMPTY_IMPORTDECLARATIONS);
    final ExtensionImportDeclaration[] ext = toArray(extensions, EMPTY_EXTENSIONIMPORTDECLARATIONS);

    final Definition[] d = toArray(defines, EMPTY_DEFINITIONS);
    final Advice[] a = toArray(advices, EMPTY_ADVICES);
    final Template t = new Template(i, ext, d, a);
    return handle(t);
  }

  public Definition createDefinition(final Identifier name, final List<DeclaredParameter> p, final Identifier type,
      final List<Statement> s) {
    final DeclaredParameter[] params = toArray(p, EMPTY_DECLAREDPARAMETERS);
    final Statement[] body = toArray(s, EMPTY_STATEMENTS);
    Definition def = new Definition(name, type, params, body);
    for (Statement element : body) {
      element.setContainingDefinition(def);
    }
    return handle(def);
  }

  public TextStatement createTextStatement(final Identifier t, final Identifier identifier) {
    String txt = t.toString();
    if (txt.startsWith(XpandTokens.RT) && txt.endsWith(XpandTokens.LT)) {
      txt = txt.substring(1, txt.length() - 1);
    }
    return handle(new TextStatement(txt, identifier != null));
  }

  public ForEachStatement createForEachStatement(final Expression e, final Identifier v, final Expression sep,
      final Identifier iter, final List<Statement> s) {
    final Statement[] body = toArray(s, EMPTY_STATEMENTS);
    return handle(new ForEachStatement(v, e, body, sep, iter));
  }

  public IfStatement createIfStatement(final Expression condition, final List<Statement> s) {
    final Statement[] body = toArray(s, EMPTY_STATEMENTS);
    return handle(new IfStatement(condition, body));
  }

  public LetStatement createLetStatement(final Expression e, final Identifier name, final List<Statement> s) {
    final Statement[] body = toArray(s, EMPTY_STATEMENTS);
    return handle(new LetStatement(name, e, body));
  }

  public ErrorStatement createErrorStatement(final Expression expr) {
    return handle(new ErrorStatement(expr));
  }

  public ExpressionStatement createExpressionStatement(final Expression e) {
    return handle(new ExpressionStatement(e));
  }

  public FileStatement createFileStatement(final Expression fileName, final Identifier option, final List<Statement> s) {
    final Statement[] body = toArray(s, EMPTY_STATEMENTS);
    return handle(new FileStatement(fileName, body, option));
  }

  public ProtectStatement createProtectStatement(final Expression startC, final Expression endC, final Expression id,
      final boolean disabled, final List<Statement> s) {
    final Statement[] body = toArray(s, EMPTY_STATEMENTS);
    return handle(new ProtectStatement(startC, endC, body, id, disabled));
  }

  public ExpandStatement createExpandStatement(final Identifier definition, final List<Expression> parameters,
      final Expression target, final boolean foreach, final Expression sep, final boolean onFileClose) {
    final Expression[] params = toArray(parameters, EMPTY_EXPRESSIONS);
    return handle(new ExpandStatement(definition, target, sep, params, foreach, onFileClose));
  }

  public ImportDeclaration createImportDeclaration(final Identifier namespace) {
    return handle(new ImportDeclaration(namespace));
  }

  public ExtensionImportDeclaration createExtensionImportDeclaration(final Identifier namespace) {
    return handle(new ExtensionImportDeclaration(namespace));
  }

  public Advice createAround(final Identifier n, final List<DeclaredParameter> p, final boolean wildparams,
      final Identifier t, final List<Statement> s) {
    final DeclaredParameter[] params = toArray(p, EMPTY_DECLAREDPARAMETERS);
    final Statement[] body = toArray(s, EMPTY_STATEMENTS);
    final Advice a = new Advice(n, t, params, wildparams, body);
    for (Statement element : body) {
      element.setContainingDefinition(a);
    }
    return handle(a);
  }

}
