/**
 * <copyright>
 *
 * Copyright (c) 2005-2009 Sven Efftinge (http://www.efftinge.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge (http://www.efftinge.de) - Initial API and implementation
 *     QNX Software Systems - EDataTypeTypes do not conform to Object
 *
 * </copyright>
 */
package org.eclipse.xtend.typesystem.emf;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

public class EDataTypeType extends AbstractTypeImpl {

    private EDataType dataType;

    public EDataTypeType(final EmfRegistryMetaModel model, final String fullyQualifiedName, final EDataType datatype) {
        super(model.getTypeSystem(), fullyQualifiedName);
        dataType = datatype;
    }

    @Override
    public Feature[] getContributedFeatures() {
        return new Feature[0];
    }

    public boolean isInstance(final Object o) {
        return dataType.isInstance(o);
    }

    public Object newInstance() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Set<? extends Type> internalGetSuperTypes() {
    	// must have Object.isAssignableFrom(<data-type>) be true because
    	// Object.isInstance(<value-of-data-type>) is true
 		return Collections.singleton(getTypeSystem().getObjectType());
	}

}
