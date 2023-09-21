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
import java.util.Set;

import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

public class IteratorType extends AbstractTypeImpl {

    public IteratorType(final TypeSystem ts) {
        super(ts, TYPE_NAME);
    }

    public final static String TYPE_NAME = "xpand2::Iterator";

    @Override
    public Feature[] getContributedFeatures() {
        //TODO [arno] these features should now be obsolete because getters were added to XpandIterator - remove after 4.2 to reduce risk
        return new Feature[] { new PropertyImpl(this, "counter0", getTypeSystem().getIntegerType()) {

            public Object get(final Object target) {
                return ((XpandIterator) target).counter();
            }
        }, new PropertyImpl(this, "counter1", getTypeSystem().getIntegerType()) {

            public Object get(final Object target) {
                return ((XpandIterator) target).counter1();
            }
        }, new PropertyImpl(this, "lastIteration", getTypeSystem().getBooleanType()) {

            public Object get(final Object target) {
                return ((XpandIterator) target).isLastIteration();
            }
        }, new PropertyImpl(this, "firstIteration", getTypeSystem().getBooleanType()) {

            public Object get(final Object target) {
                return ((XpandIterator) target).isFirstIteration();
            }
        }, new PropertyImpl(this, "elements", getTypeSystem().getIntegerType()) {

            public Object get(final Object target) {
                return ((XpandIterator) target).elements();
            }
        }

        };
    }

    public boolean isInstance(final Object o) {
        return o instanceof XpandIterator;
    }

    public Object newInstance() {
        return null;
    }

    @Override
    public Set<Type> getSuperTypes() {
        return Collections.singleton(getTypeSystem().getObjectType());
    }
}
