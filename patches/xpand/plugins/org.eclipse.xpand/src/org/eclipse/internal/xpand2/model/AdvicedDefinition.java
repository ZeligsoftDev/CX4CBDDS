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
package org.eclipse.internal.xpand2.model;

import java.util.Set;

import org.eclipse.internal.xpand2.ast.Advice;
import org.eclipse.internal.xpand2.type.XpandDefinitionImpl;
import org.eclipse.internal.xtend.expression.ast.AbstractVisitor;
import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Variable;

public class AdvicedDefinition implements XpandDefinition {

	private XpandAdvice advice;

	private XpandDefinition definition;

	public AdvicedDefinition(final XpandAdvice adv, final XpandDefinition def) {
		advice = adv;
		definition = def;
	}

	public XpandResource getOwner() {
		return definition.getOwner();
	}

	public DeclaredParameter[] getParams() {
		return definition.getParams();
	}

	public String getTargetType() {
		return definition.getTargetType();
	}

	public String getName() {
		return "AROUND " + definition.getName();
	}

	public String getQualifiedName() {
		return definition.getQualifiedName();
	}

	public String getParamString(boolean typesOnly) {
		return definition.getParamString(typesOnly);
	}

	public void analyze(XpandExecutionContext ctx, Set<AnalysationIssue> issues) {
		// not used, since a static analysis will never have AOP
	}

	public void evaluate(final XpandExecutionContext ctx, Object _this, Object...params) {
		XpandExecutionContext ctx1 = (XpandExecutionContext) ctx.cloneWithoutVariables().cloneWithVariable(new Variable(
				Advice.DEF_VAR_NAME, new XpandDefinitionImpl(definition, ctx, _this, params)));
		advice.evaluate(ctx1, _this, params);
	}

	public int getLine() {
		return advice.getLine();
	}

	public int getEnd() {
		return advice.getEnd();
	}

	public int getStart() {
		return advice.getStart();
	}

	public String getFileName() {
		return advice.getFileName();
	}

	public String getNameString(ExecutionContext context){
		return advice.getNameString(context);
	}

	@Override
	public String toString() {
		return definition.toString() + " adviced by " + advice.toString();
	}

	public final Object accept(final AbstractVisitor visitor) {
		return visitor.visit(this);
	}
}
