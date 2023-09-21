/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html Contributors: committers of
 * openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xpand2.ast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.internal.xpand2.model.XpandDefinition;
import org.eclipse.internal.xpand2.model.XpandResource;
import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.Type;

public abstract class AbstractDefinition extends SyntaxElement implements XpandDefinition {

  private static final DeclaredParameter[] NO_PARAM = new DeclaredParameter[0];
  private Template owner = null;

  private final DeclaredParameter[] params;

  private final Identifier name;

  private final Identifier type;

  private final Statement[] body;

  protected String _stringRepresentation = null;

  protected boolean wildParams = false;

  public AbstractDefinition(final Identifier name, final Identifier type, final DeclaredParameter[] params,
      final Statement[] body) {
    this.name = name;
    this.type = type;
    this.params = (params != null) && (params.length > 0) ? params : NO_PARAM;
    this.body = body;
  }

  public XpandResource getOwner() {
    return this.owner;
  }

  public void setOwner(final Template owner) {
    this.owner = owner;
  }

  public DeclaredParameter[] getParams() {
    return this.params;
  }

  public List<DeclaredParameter> getParamsAsList() {
    return Arrays.asList(this.params);
  }

  public Identifier getType() {
    return this.type;
  }

  public String getTargetType() {
    return this.type.toString();
  }

  public Identifier getDefName() {
    return this.name;
  }

  public String getName() {
    return this.name.toString();
  }

  public String getQualifiedName() {
    if (getFileName() != null) {
      String prefix = getFileName().replaceAll("/", "::");
      prefix = prefix.substring(0, prefix.length() - 4);
      return prefix + "::" + getName();
    }
    return getName();
  }

  public String getParamString(final boolean typesOnly) {
    if ((this.params == null) || (this.params.length == 0)) {
      return this.wildParams ? "(*)" : "";
    }
    final StringBuilder buff = new StringBuilder("(");
    for (int i = 0; i < this.params.length; i++) {
      final DeclaredParameter p = this.params[i];
      buff.append(p.getType().toString());
      if (!typesOnly) {
        buff.append(" ").append(p.getName().toString());
      }
      if ((i + 1) < this.params.length) {
        buff.append(",");
      }
    }
    if (this.wildParams) {
      buff.append(",*");
    }
    return buff.append(")").toString();
  }

  public Statement[] getBody() {
    return this.body;
  }

  public List<Statement> getBodyAsList() {
    return Arrays.asList(this.body);
  }

  public void analyze(XpandExecutionContext ctx, final Set<AnalysationIssue> issues) {
    try {
      if (ctx.getCallback() != null) {
        if (!ctx.getCallback().pre(this, ctx)) {
          return;
        }
      }
      final String typeValue = getType().toString();
      final Type thisType = ctx.getTypeForName(typeValue); 
      if (thisType == null) {
        issues.add(new AnalysationIssue(AnalysationIssue.TYPE_NOT_FOUND, "Couldn't find " + typeValue,
            getType()));
      }
      ctx = (XpandExecutionContext) ctx.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, thisType));
      for (final DeclaredParameter param : this.params) {
        final String paramTypeValue = param.getType().toString();
        Type paramType = ctx.getTypeForName(paramTypeValue);
        if (paramType == null) {
          issues.add(new AnalysationIssue(AnalysationIssue.TYPE_NOT_FOUND, "Couldn't find " +
              paramTypeValue, param.getType()));
          paramType = ctx.getObjectType();
        }
        final String name = param.getName().toString();
        ctx = (XpandExecutionContext) ctx.cloneWithVariable(new Variable(name, paramType));
      }
      for (int i = 0; i < getBody().length; i++) {
        Statement stmt = getBody()[i];
        try {
          stmt.analyze(ctx, issues);
        }
        catch (RuntimeException ex) {
          Map<String, Object> info = new HashMap<String, Object>();
          info.put("body", stmt);
          ctx.handleRuntimeException(ex, this, info);
        }
      }
    }
    finally {
      if (ctx.getCallback() != null) {
        ctx.getCallback().post(this, ctx, null);
      }
    }
  }

  public void evaluate(XpandExecutionContext ctx, final Object _this, final Object... params) {
    try {
      ctx = (XpandExecutionContext) ctx.cloneWithResource(getOwner());
      ctx = prepareDeclaredParameters(_this, ctx, params);
      if (ctx.getCallback() != null) {
        if (!ctx.getCallback().pre(this, ctx)) {
          return;
        }
      }
      for (int i = 0; i < getBody().length; i++) {
        Statement stmt = getBody()[i];
        try {
          stmt.evaluate(ctx);
        }
        catch (RuntimeException ex) {
          Map<String, Object> info = new HashMap<String, Object>();
          info.put("body", stmt);
          ctx.handleRuntimeException(ex, this, info);
        }
      }
    }
    finally {
      if (ctx.getCallback() != null) {
        ctx.getCallback().post(this, ctx, null);
      }
    }
  }

  protected XpandExecutionContext prepareDeclaredParameters(final Object _this, XpandExecutionContext context,
      final Object... params) {
    if (_this != null) {
      context =
          (XpandExecutionContext) context.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, _this));
    }
    if (params != null) {
      DeclaredParameter[] params2 = getParams();
      for (int i = 0, x = params2.length; i < x; i++) {
        final Object o = params[i];
        final String name = params2[i].getName().toString();
        context = (XpandExecutionContext) context.cloneWithVariable(new Variable(name, o));
      }
    }
    return context;
  }

  @Override
  public String toString() {
    if (this._stringRepresentation == null) {
      this._stringRepresentation = this.name.toString() + getParamString(false) + " : " + getType().toString();
    }

    return this._stringRepresentation;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((toString() == null) ? 0 : toString().hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }

    if ((obj == null) || (toString() == null)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    AbstractDefinition other = (AbstractDefinition) obj;
    return toString().equals(other.toString());
  }
}
