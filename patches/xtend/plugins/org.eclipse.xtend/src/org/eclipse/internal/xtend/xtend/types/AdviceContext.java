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
package org.eclipse.internal.xtend.xtend.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.typesystem.Type;

public class AdviceContext {

    private final Extension ext;

    private final ExecutionContext ctx;

	private Object[] parameters;


    public AdviceContext(final Extension ext, final ExecutionContext ctx, Object[] parameters2) {
		super();
		this.ext = ext;
		this.ctx = ctx;
		this.parameters = parameters2;
	}

	public String getName() {
        return ext.getName();
    }

    public List<Type> getParamTypes() {
        return ext.getParameterTypes();
    }

    public List<String> getParamNames() {
        return ext.getParameterNames();
    }
    public List<Object> getParamValues() {
    	return new ArrayList<Object>(Arrays.asList(parameters));
    }

    public Object proceed() {
        return ext.evaluate(parameters,ctx);
    }

    public Object proceed(final Object[] params) {
        return ext.evaluate(params,ctx);
    }

    @Override
    public String toString() {
        return ext.toString();
    }
}
