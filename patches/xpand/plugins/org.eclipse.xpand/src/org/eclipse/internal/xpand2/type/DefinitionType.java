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

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;
import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

public class DefinitionType extends AbstractTypeImpl {

    public DefinitionType(final TypeSystem ts) {
        super(ts, TYPE_NAME);
    }

    public final static String TYPE_NAME = "xpand2::Definition";

    @Override
    public Feature[] getContributedFeatures() {
        return new Feature[] {
                new PropertyImpl(this, "name", getTypeSystem().getStringType()) {

                    public Object get(final Object target) {
                        return ((XpandDefinitionImpl) target).getName();
                    }
                },
                new PropertyImpl(this, "targetType", getTypeSystem().getTypeType()) {

                    public Object get(final Object target) {
                        return ((XpandDefinitionImpl) target).getTargetType();
                    }
                },
                new PropertyImpl(this, "paramTypes", getTypeSystem().getListType(getTypeSystem().getTypeType())) {

                    public Object get(final Object target) {
                        return ((XpandDefinitionImpl) target).getParamTypes();
                    }
                },
                new PropertyImpl(this, "paramNames", getTypeSystem().getListType(getTypeSystem().getStringType())) {

                    public Object get(final Object target) {
                        return ((XpandDefinitionImpl) target).getParamNames();
                    }
                },
                new OperationImpl(this, "proceed", getTypeSystem().getVoidType()) {

                    @Override
                    protected Object evaluateInternal(final Object target, final Object[] params) {
                        ((XpandDefinitionImpl) target).proceed();
                        return null;
                    }

                },
                new OperationImpl(this, "proceed", getTypeSystem().getVoidType(), new Type[] {
                        getTypeSystem().getObjectType(), getTypeSystem().getListType(getTypeSystem().getObjectType()) }) {

                    @Override
                    protected Object evaluateInternal(final Object target, final Object[] params) {
                        ((XpandDefinitionImpl) target).proceed(params[0], (List<?>) params[1]);
                        return null;
                    }

                }, new OperationImpl(this, "toString", getTypeSystem().getStringType()) {

                    @Override
                    protected Object evaluateInternal(final Object target, final Object[] params) {
                        return target.toString();
                    }

                }

        };
    }

    public boolean isInstance(final Object o) {
        return o instanceof XpandDefinitionImpl;
    }

    public Object newInstance() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Type> getSuperTypes() {
        return Collections.singleton(getTypeSystem().getObjectType());
    }
}
