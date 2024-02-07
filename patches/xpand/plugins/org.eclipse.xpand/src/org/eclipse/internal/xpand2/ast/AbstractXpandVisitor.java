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

import java.util.Arrays;
import java.util.List;

import org.eclipse.internal.xtend.expression.ast.AbstractVisitor;
import org.eclipse.internal.xtend.expression.ast.ISyntaxElement;

public class AbstractXpandVisitor extends AbstractVisitor{

	@Override
	public final Object visit(final ISyntaxElement ele) {
		Object result = null;

		if (ele instanceof Advice) {
			result = visitAdvice((Advice) ele);
		}
		if (result == null && ele instanceof Definition) {
			result = visitDefinition((Definition) ele);
		}
		if (result == null && ele instanceof ErrorStatement) {
			result = visitErrorStatement((ErrorStatement) ele);
		}
		if (result == null && ele instanceof ExpandStatement) {
			result = visitExpandStatement((ExpandStatement) ele);
		}
		if (result == null && ele instanceof ExpressionStatement) {
			result = visitExpressionStatement((ExpressionStatement) ele);
		}
		if (result == null && ele instanceof ExtensionImportDeclaration) {
			result = visitExtensionImportDeclaration((ExtensionImportDeclaration) ele);
		}
		if (result == null && ele instanceof FileStatement) {
			result = visitFileStatement((FileStatement) ele);
		}
		if (result == null && ele instanceof ForEachStatement) {
			result = visitForEachStatement((ForEachStatement) ele);
		}
		if (result == null && ele instanceof IfStatement) {
			result = visitIfStatement((IfStatement) ele);
		}
		if (result == null && ele instanceof ImportDeclaration) {
			result = visitImportDeclaration((ImportDeclaration) ele);
		}
		if (result == null && ele instanceof LetStatement) {
			result = visitLetStatement((LetStatement) ele);
		}
		if (result == null && ele instanceof ProtectStatement) {
			result = visitProtectStatement((ProtectStatement) ele);
		}
		if (result == null && ele instanceof Template) {
			result = visitTemplate((Template) ele);
		}
		if (result == null && ele instanceof TextStatement) {
			result = visitTextStatement((TextStatement) ele);
		}
		return result;
	}

	protected void visitChild(final ISyntaxElement child){
		if(child != null)
			child.accept(this);
		}

	protected void visitChildren(final List<? extends ISyntaxElement> children){
		if (children != null) {
			for (ISyntaxElement child : children) {
				visitChild(child);
			}
		}
	}

	protected Object visitAdvice(Advice node){
		visitChildren(node.getBodyAsList());
		return node;
	}

	protected Object visitDefinition(Definition node){
		visitChildren(node.getBodyAsList());
		return node;
	}

	protected Object visitErrorStatement(ErrorStatement node){
		return node;
	}

	protected Object visitExpandStatement(ExpandStatement node){
		return node;
	}

	protected Object visitExpressionStatement(ExpressionStatement node){
		return node;
	}

	protected Object visitExtensionImportDeclaration(ExtensionImportDeclaration node){
		return node;
	}

	protected Object visitFileStatement(FileStatement node){
		visitChildren(node.getBodyAsList());
		return node;
	}

	protected Object visitForEachStatement(ForEachStatement node){
		visitChildren(node.getBodyAsList());
		return node;
	}

	protected Object visitIfStatement(IfStatement node){
		visitChildren(node.getBodyAsList());
		visitChild(node.getElseIf());
		return node;
	}

	protected Object visitImportDeclaration(ImportDeclaration node){
		return node;
	}

	protected Object visitLetStatement(LetStatement node){
		visitChildren(node.getBodyAsList());
		return node;
	}

	protected Object visitProtectStatement(ProtectStatement node){
		visitChildren(node.getBodyAsList());
		return node;
	}

	protected Object visitTemplate(Template node){
		visitChildren(Arrays.asList(node.getExtensions()));
		visitChildren(Arrays.asList(node.getImports()));
		visitChildren(Arrays.asList(node.getAllDefinitions()));
		return node;
	}

	protected Object visitTextStatement(TextStatement node){
		return node;
	}
}
