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

package org.eclipse.internal.xtend.type.impl.oawclassic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.internal.xtend.type.baseimpl.FeatureImpl;
import org.eclipse.internal.xtend.util.StringHelper;
import org.eclipse.xtend.type.impl.java.JavaOperationImpl;
import org.eclipse.xtend.type.impl.java.JavaPropertyImpl;
import org.eclipse.xtend.type.impl.java.JavaTypeStrategy;
import org.eclipse.xtend.type.impl.java.TypeFinder;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public class OAWClassicStrategy implements JavaTypeStrategy {

    private boolean convertPropertiesToLowerCase = true;

    private boolean isOAWClassicGetter(final Method method) {
        if (method.getParameterTypes().length == 0)
            return true;
        return false;
    }

	public Feature[] getFeatures(final TypeFinder typeFinder, final Class<?> clazz, final Type owner) {
        final List<FeatureImpl> result = new ArrayList<FeatureImpl>();
        final Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            final Method method = methods[i];
            if (isOAWClassicGetter(method)) {
                final Method getterMethod = method;
                final Method setterMethod = null;
                String propName = method.getName();
                if (convertPropertiesToLowerCase) {
                    propName = StringHelper.firstLower(propName);
                }
                result.add(new JavaPropertyImpl(owner, propName, typeFinder.builtinAwareGetTypeForClass(clazz),
                        getterMethod, setterMethod));
            } else {
                final Type rt = typeFinder.builtinAwareGetTypeForClass(method.getReturnType());
                if (rt != null) {
                    final Type[] params = new Type[method.getParameterTypes().length];
                    boolean nullParam = false;
                    for (int j = 0; j < params.length && !nullParam; j++) {
                        params[j] = typeFinder.builtinAwareGetTypeForClass(method.getParameterTypes()[j]);
                        nullParam = params[j] == null;
                    }
                    if (!nullParam) {
                        result.add(new JavaOperationImpl(owner, method.getName(), rt, params, method));
                    }
                }
            }

        }
        return result.toArray(new Feature[result.size()]);
    }

    public void setConvertPropertiesToLowerCase(final boolean bool) {
        convertPropertiesToLowerCase = bool;
    }

}
