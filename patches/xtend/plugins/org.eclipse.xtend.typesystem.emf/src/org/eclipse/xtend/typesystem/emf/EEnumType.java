/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *     QNX Software Systems - EEnumTypes do not conform to Object
 *******************************************************************************/

package org.eclipse.xtend.typesystem.emf;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.internal.xtend.type.baseimpl.StaticPropertyImpl;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

public class EEnumType extends AbstractTypeImpl {

    private EEnum eEnum;

    public EEnumType(final EmfRegistryMetaModel model, final String name, final EEnum eEnum) {
        super(model.getTypeSystem(), name);
        this.eEnum = eEnum;
    }

    @Override
    public Feature[] getContributedFeatures() {
        final Set<StaticPropertyImpl> result = new HashSet<StaticPropertyImpl>();
        final List<EEnumLiteral> enumLiterals = eEnum.getELiterals();
        for (final Iterator<EEnumLiteral> iter = enumLiterals.iterator(); iter.hasNext();) {
            final EEnumLiteral lit = iter.next();
            result.add(new StaticPropertyImpl(this, lit.getName(), this) {
                public Object get() {
                    return lit.getInstance();
                }
            });
        }
        return result.toArray(new Feature[result.size()]);
    }

    public boolean isInstance(final Object o) {
        return eEnum.isInstance(o);
    }

    public Object newInstance() {
        throw new UnsupportedOperationException("Enums are static!");
    }

    @Override
    protected Set<? extends Type> internalGetSuperTypes() {
    	// must have Object.isAssignableFrom(<enum-type>) be true because
    	// Object.isInstance(<literal-of-enum-type>) is true
 		return Collections.singleton(getTypeSystem().getObjectType());
	}

}
