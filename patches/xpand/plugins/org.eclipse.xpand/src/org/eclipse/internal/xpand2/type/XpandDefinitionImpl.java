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
package org.eclipse.internal.xpand2.type;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.internal.xpand2.model.XpandDefinition;
import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtend.typesystem.Type;

public class XpandDefinitionImpl {

    private final XpandDefinition def;

    private final XpandExecutionContext ctx;

	private Object this1;

	private Object[] params;

    public XpandDefinitionImpl(final XpandDefinition def, final XpandExecutionContext ctx, Object this1, Object[] params) {
        this.def = def;
        this.ctx = ctx;
        this.this1 = this1;
        this.params = params;
    }

    public String getName() {
        return def.getName();
    }

    public Type getTargetType() {
        return ctx.getTypeForName(def.getTargetType());
    }

    public List<Type> getParamTypes() {
        final DeclaredParameter[] p = def.getParams();
        final List<Type> result = new ArrayList<Type>();
        for (int i = 0; i < p.length; i++) {
            result.add(ctx.getTypeForName(p[i].getType().toString()));
        }
        return result;
    }

    public List<String> getParamNames() {
        final DeclaredParameter[] p = def.getParams();
        final List<String> result = new ArrayList<String>();
        for (int i = 0; i < p.length; i++) {
            result.add(p[i].getName().toString());
        }
        return result;
    }

    public void proceed() {
    	def.evaluate((XpandExecutionContext) ctx.cloneWithoutVariables(),this.this1,this.params);
    }
    
    public void proceed(Object _this, Object...parameters) {
        def.evaluate((XpandExecutionContext) ctx.cloneWithoutVariables(),_this,parameters);
    }

    @Override
    public String toString() {
        return def.toString();
    }

}
