/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html Contributors: committers of
 * openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xpand2.ast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.internal.xpand2.XpandTokens;
import org.eclipse.internal.xpand2.XpandUtil;
import org.eclipse.internal.xpand2.model.XpandDefinition;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.xpand2.XpandCompilerIssue;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.output.InsertionPointSupport;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.EvaluationException;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.ParameterizedType;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Karsten Thoms
 */
public class ExpandStatement extends Statement {

  private static final Expression[] NO_EXPRESSION = new Expression[0];
  private boolean foreach = false;

  private Expression[] parameters = NO_EXPRESSION;

  private Expression separator = null;

  private Expression target = null;

  private final Identifier definition;

  private boolean onFileClose = false;

  private boolean deferredToFileClose = false;

  private String targetNamespace;

  public ExpandStatement(final Identifier definition, final Expression target, final Expression separator,
      final Expression[] parameters, final boolean foreach, final boolean onFileClose) {
    this.definition = definition;
    this.target = target;
    this.separator = separator;
    this.parameters = (parameters != null) && (parameters.length > 0) ? parameters : NO_EXPRESSION;
    this.foreach = foreach;
    this.onFileClose = onFileClose;
  }

  public Identifier getDefinition() {
    return this.definition;
  }

  public boolean isForeach() {
    return this.foreach;
  }

  public Expression[] getParameters() {
    return this.parameters;
  }

  public List<Expression> getParametersAsList() {
    return Arrays.asList(this.parameters);
  }

  public Expression getSeparator() {
    return this.separator;
  }

  public Expression getTarget() {
    return this.target;
  }

  public boolean isOnFileClose() {
    return this.onFileClose;
  }

  /**
   * Retrieves the namespace of the target definition(s). This method requires that either analyzeInternal() or
   * evaluateInternal() was invoked before, otherwise result will be null.
   * 
   * @since 1.0.0 M5
   */
  public String getTargetNamespace() {
    return this.targetNamespace;
  }

  @Override
  public void analyzeInternal(final XpandExecutionContext ctx, final Set<AnalysationIssue> issues) {
    final Type[] paramTypes = new Type[getParameters().length];
    // analyze parameters
    for (int i = 0; i < getParameters().length; i++) {
      paramTypes[i] = getParameters()[i].analyze(ctx, issues);
    }
    Type targetType = null;
    if (isForeach()) {
      targetType = this.target.analyze(ctx, issues);
      if (ctx.getCollectionType(ctx.getObjectType()).isAssignableFrom(targetType)) {
        if (targetType instanceof ParameterizedType) {
          targetType = ((ParameterizedType) targetType).getInnerType();
        }
        else {
          targetType = ctx.getObjectType();
        }
      }
      else {
        issues.add(new AnalysationIssue(AnalysationIssue.INCOMPATIBLE_TYPES, "Collection type expected!", this.target));
        return;
      }
    }
    else {
      final Variable var = ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);
      if (var == null) {
        issues.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, "No implicit variable 'this' could be found!",
            this.target));
        return;
      }
      targetType = (Type) var.getValue();
      if (this.target != null) {
        targetType = this.target.analyze(ctx, issues);
      }
    }
    if (targetType == null) {
      return;
    }
    final String definitionName = getDefinition().toString();
    final XpandDefinition def = ctx.findDefinition(definitionName, targetType, paramTypes);
    if (def == null) {
      issues.add(new AnalysationIssue(XpandCompilerIssue.DEFINITION_NOT_FOUND, "Couldn't find definition " +
          definitionName + getParamTypeString(paramTypes) + " for type " + targetType.getName(), this));
    }
    else {
      this.targetNamespace = XpandUtil.withoutLastSegment(def.getOwner().getFullyQualifiedName());
    }
  }

  @Override
  public void evaluateInternal(XpandExecutionContext ctx) {
    final String defName = getDefinition().toString();
    final String sep = (String) (this.separator != null ? this.separator.evaluate(ctx) : null);

    if (this.onFileClose && !this.deferredToFileClose) {
      if (!(ctx.getOutput() instanceof InsertionPointSupport)) {
        throw new EvaluationException("Output implementation must implement InsertionPointSupport when using " +
            XpandTokens.ONFILECLOSE, this, ctx);
      }
      ctx = ((XpandExecutionContextImpl) ctx).cloneWithStatement(this);
      ((InsertionPointSupport) ctx.getOutput()).registerInsertionPoint(this);
      this.deferredToFileClose = true;
      return;
    }
    // reset here, otherwise we would need a try-finally block
    this.deferredToFileClose = false;

    Object targetObject = null;
    if (isForeach()) {
      targetObject = this.target.evaluate(ctx);
      if (targetObject != null) {
        if (!(targetObject instanceof Collection<?>)) {
          throw new EvaluationException("Collection expected!", this.target, ctx);
        }

        final Collection<?> col = (Collection<?>) targetObject;
        for (final Iterator<?> iter = col.iterator(); iter.hasNext();) {
          final Object targetObj = iter.next();
          final Object[] params = new Object[getParameters().length];
          for (int i = 0; i < getParameters().length; i++) {
            params[i] = getParameters()[i].evaluate(ctx);
          }
          final Type[] paramTypes = new Type[params.length];
          for (int i = 0; i < params.length; i++) {
            paramTypes[i] = ctx.getType(params[i]);
          }
          ctx.preTask(this);
          invokeDefinition(defName, targetObj, params, paramTypes, ctx);
          ctx.postTask(this);
          if ((sep != null) && iter.hasNext()) {
            if (this.onFileClose && (ctx.getOutput() instanceof InsertionPointSupport)) {
              ((InsertionPointSupport) ctx.getOutput()).activateInsertionPoint(this);
            }
            try {
              ctx.getOutput().write(sep);
            }
            finally {
              if (this.onFileClose && (ctx.getOutput() instanceof InsertionPointSupport)) {
                ((InsertionPointSupport) ctx.getOutput()).deactivateInsertionPoint(this);
              }
            }
          }
        }
      }

    }
    else {
      final Object[] params = new Object[getParameters().length];
      for (int i = 0; i < getParameters().length; i++) {
        params[i] = getParameters()[i].evaluate(ctx);
      }
      final Type[] paramTypes = new Type[params.length];
      for (int i = 0; i < params.length; i++) {
        paramTypes[i] = ctx.getType(params[i]);
      }
      if (this.target != null) {
        targetObject = this.target.evaluate(ctx);
      }
      else {
        final Variable var = ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);
        targetObject = var.getValue();
      }
      if (targetObject != null) {
        invokeDefinition(defName, targetObject, params, paramTypes, ctx);
      }
    }
  }

  private void invokeDefinition(final String defName, final Object targetObj, final Object[] params,
      final Type[] paramTypes, final XpandExecutionContext ctx) {
    final Type t = ctx.getType(targetObj);
    final XpandDefinition def = ctx.findDefinition(defName, t, paramTypes);
    if (def == null) {
      String errorMsg =
          "No Definition '" + defName + getParamTypeString(paramTypes) + " for " + t.getName() + "' found!";
      if (t.getTypeSystem().getObjectType().equals(t)) {
        errorMsg += " Maybe your forgot to configure the correct meta model in the workflow?";
      }
      throw new EvaluationException(errorMsg, this, ctx);
    }
    this.targetNamespace = XpandUtil.withoutLastSegment(def.getOwner().getFullyQualifiedName());

    try {
      def.evaluate((XpandExecutionContext) ctx.cloneWithoutVariables(), targetObj, params);
    }
    catch (EvaluationException e) {
      e.addStackElement(this, ctx);
      throw e;
    }
  }

  private String getParamTypeString(final Type[] paramTypes) {
    if (paramTypes.length == 0) {
      return "";
    }
    final StringBuffer buff = new StringBuffer("(");
    for (int i = 0; i < paramTypes.length; i++) {
      final Type type = paramTypes[i];
      buff.append(type.getName());
      if ((i + 1) < paramTypes.length) {
        buff.append(", ");
      }
    }
    return buff.append(")").toString();
  }

  private String getParamString(final Expression[] paramTypes) {
    if (paramTypes.length == 0) {
      return "";
    }
    final StringBuffer buff = new StringBuffer("(");
    for (int i = 0; i < paramTypes.length; i++) {
      final Expression type = paramTypes[i];
      buff.append(type);
      if ((i + 1) < paramTypes.length) {
        buff.append(", ");
      }
    }
    return buff.append(")").toString();
  }

  @Override
  public String toString() {
    return "EXPAND " + this.definition + getParamString(getParameters()) +
        (this.target != null ? (isForeach() ? " FOREACH " : " FOR ") + this.target : "") +
        (this.separator != null ? " SEPARATOR " + this.separator : "") + (this.onFileClose ? " ONFILECLOSE " : "");
  }

  @Override
  public String getNameString(final ExecutionContext context) {
    return XpandTokens.EXPAND;
  }

}
