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

package org.eclipse.internal.xtend.type.baseimpl.types;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;
import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class TypeTypeImpl extends BuiltinBaseType {

    public TypeTypeImpl(final TypeSystem ts, final String name) {
        super(ts, name);
    }

    @Override
    public Set<Type> getSuperTypes() {
        return Collections.singleton(getTypeSystem().getObjectType());
    }

    public boolean isInstance(final Object o) {
        return o instanceof Type;
    }

    public Object newInstance() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isAbstract() {
        return true;
    }

    @Override
    public Feature[] getContributedFeatures() {
        return new Feature[] {
                new PropertyImpl(this, "name", getTypeSystem().getStringType()) {
                    public Object get(final Object target) {
                        final Type t = (Type) target;
                        return t.getName();
                    }

                    @Override
                    public void set(final Object target, final Object val) {
                        throw new UnsupportedOperationException("unsettable!");
                    }

                },

                new PropertyImpl(this, "superTypes", getTypeSystem().getSetType(getTypeSystem().getTypeType())) {
                    public Object get(final Object target) {
                        return ((Type) target).getSuperTypes();
                    }

                    @Override
                    public void set(final Object target, final Object val) {
                        throw new UnsupportedOperationException("unsettable!");
                    }
                },

                new PropertyImpl(this, "allFeatures", getTypeSystem().getSetType(getTypeSystem().getFeatureType())) {
                    public Object get(final Object target) {
                        return ((Type) target).getAllFeatures();
                    }

                    @Override
                    public void set(final Object target, final Object val) {
                        throw new UnsupportedOperationException("unsettable!");
                    }
                },

                new PropertyImpl(this, "allProperties", getTypeSystem().getSetType(getTypeSystem().getPropertyType())) {
                    public Object get(final Object target) {
                        return ((Type) target).getAllProperties();
                    }

                    @Override
                    public void set(final Object target, final Object val) {
                        throw new UnsupportedOperationException("unsettable!");
                    }
                },
                new PropertyImpl(this, "allOperations", getTypeSystem().getSetType(getTypeSystem().getOperationType())) {
                    public Object get(final Object target) {
                        return ((Type) target).getAllOperations();
                    }

                    @Override
                    public void set(final Object target, final Object val) {
                        throw new UnsupportedOperationException("unsettable!");
                    }
                },

                new PropertyImpl(this, "allStaticProperties", getTypeSystem().getSetType(
                        getTypeSystem().getStaticPropertyType())) {
                    public Object get(final Object target) {
                        return ((Type) target).getAllStaticProperties();
                    }

                    @Override
                    public void set(final Object target, final Object val) {
                        throw new UnsupportedOperationException("unsettable!");
                    }
                },
                new OperationImpl(this, "getFeature", getTypeSystem().getFeatureType(), new Type[] {
                        getTypeSystem().getStringType(), getTypeSystem().getListType(null) }) {

                    @Override
                    public Object evaluateInternal(final Object target, final Object[] params) {
                        final List l = (List) params[1];
                        final Type[] ta = (Type[]) l.toArray(new Type[l.size()]);
                        return ((Type) target).getFeature((String) params[0], ta);
                    }
                },

                new OperationImpl(this, "getProperty", getTypeSystem().getPropertyType(), new Type[] { getTypeSystem()
                        .getStringType() }) {
                    @Override
                    public Object evaluateInternal(final Object target, final Object[] params) {
                        return ((Type) target).getProperty((String) params[0]);
                    }
                },

                new OperationImpl(this, "getOperation", getTypeSystem().getOperationType(), new Type[] {
                        getTypeSystem().getStringType(), getTypeSystem().getListType(null) }) {

					@Override
                    public Object evaluateInternal(final Object target, final Object[] params) {
                        final List l = (List) params[1];
                        final Type[] ta = (Type[]) l.toArray(new Type[l.size()]);
                        return ((Type) target).getOperation((String) params[0], ta);
                    }
                },

                new OperationImpl(this, "getStaticProperty", getTypeSystem().getStaticPropertyType(),
                        new Type[] { getTypeSystem().getStringType() }) {
                    @Override
                    public Object evaluateInternal(final Object target, final Object[] params) {
                        return ((Type) target).getStaticProperty((String) params[0]);
                    }
                },

                new OperationImpl(this, "newInstance", getTypeSystem().getObjectType()) {
                    @Override
                    public Object evaluateInternal(final Object target, final Object[] params) {
                        return ((Type) target).newInstance();
                    }
                },
                new OperationImpl(this, "isInstance", getTypeSystem().getBooleanType(), new Type[] { getTypeSystem()
                        .getObjectType() }) {
                    @Override
                    public Object evaluateInternal(final Object target, final Object[] params) {
                        return new Boolean(((Type) target).isInstance(params[0]));
                    }
                }, new OperationImpl(this, "isAssignableFrom", getTypeSystem().getBooleanType(), new Type[] { getTypeSystem()
                    .getTypeType() }) {
                    @Override
                    public Object evaluateInternal(final Object target, final Object[] params) {
                        return ((Type) target).isAssignableFrom((Type) params[0]);
                    }
                }, new PropertyImpl(this, "documentation", getTypeSystem().getStringType()) {

                    public Object get(final Object target) {
                        return ((Type) target).getDocumentation();
                    }
                }

        };
    }
}
