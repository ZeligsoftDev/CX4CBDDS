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

package org.eclipse.internal.xtend.type.baseimpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.xtend.typesystem.Callable;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Operation;
import org.eclipse.xtend.typesystem.ParameterizedCallable;
import org.eclipse.xtend.typesystem.Property;
import org.eclipse.xtend.typesystem.StaticProperty;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public class PolymorphicResolver {

    public final static Operation getOperation(final Set<? extends Callable> features, final String name, final Type targetType,
            final List<? extends Type> paramTypes) {
        final List<Type> allParams = new ArrayList<Type>();
        allParams.add(targetType);
        allParams.addAll(paramTypes);
        return (Operation) getFeature(features, Operation.class, name, allParams);
    }

    public final static Property getProperty(final Set<? extends Callable> features, final String name, final Type targetType) {
        final List<Type> allParams = new ArrayList<Type>();
        allParams.add(targetType);
        return (Property) getFeature(features, Property.class, name, allParams);
    }

    public static StaticProperty getStaticProperty(final Set<? extends Callable> features, final String name, final Type targetType) {
        final List<Type> allParams = new ArrayList<Type>();
        allParams.add(targetType);
        return (StaticProperty) getFeature(features, StaticProperty.class, name, allParams);
    }

    public final static Extension getExtension(final Set<? extends Callable> features, final String name, final List<Type> paramTypes) {
        return (Extension) getFeature(features, Extension.class, name, paramTypes);
    }

    public final static Callable getCallable(final Set<? extends Callable> callables, final String name, final List<Type> paramTypes) {
        return getFeature(callables, Callable.class, name, paramTypes);
    }

    @SuppressWarnings("unchecked")
	public static <T> Set<T> select(final Set<? extends Callable> features, final Class<T> type) {
        final Set<T> result = new HashSet<T>();
        for (Callable callable : features) {
            if (type.isInstance(callable)) {
                result.add((T) callable);
            }
        }
        return result;
    }

	public final static Callable getFeature(final Set<? extends Callable> features, final Class<?> type, final String name,
            final List<? extends Type> paramTypes) {
        final List<Callable> possFeatures = new ArrayList<Callable>();
        for (Callable feature : features) {
            if (type.isInstance(feature) && feature.getName().equals(name)) {
                final List<? extends Type> featureParamTypes = getParamTypes(feature);
                if (featureParamTypes.size() == paramTypes.size() && typesComparator.compare(featureParamTypes, paramTypes) >= 0) {
                    possFeatures.add(feature);
                }
            }
        }

        if (possFeatures.size() == 1)
            return possFeatures.get(0);
        else if (possFeatures.isEmpty())
            return null;
        else {
            // remove assignable features
        	for (int c1 = 0; c1 < possFeatures.size() - 1; ++c1) {
        		Callable feature1 = possFeatures.get(c1);
            	for (int c2 = c1 + 1; c2 < possFeatures.size(); ++c2) {
            		Callable feature2 = possFeatures.get(c2);
            		if (paramFeatureComparator.compare(feature2, feature1) > 0) {
            			possFeatures.remove(c2);
            			--c2;
            		} else if (paramFeatureComparator.compare(feature1, feature2) > 0) {
            			possFeatures.remove(c1);
            			--c1;
            			break;
            		}
            	}
            }

        	if (possFeatures.size() == 1)
                return possFeatures.get(0);

            for (Callable callable : possFeatures) {
                if (callable instanceof Extension) {
                    throw new RuntimeException("Ambiguous operations " + possFeatures.get(0).toString() + " and " + possFeatures.get(1).toString()
                            + " for param types " + paramTypes);
                }
            }
            return possFeatures.get(0);

        }
    }

    private static final Comparator<Callable> paramFeatureComparator = new Comparator<Callable>() {

        public int compare(Callable o1, Callable o2) {
            return typesComparator.compare(getParamTypes(o1), getParamTypes(o2));
        }
    };

    static List<? extends Type> getParamTypes(final Callable feature) {
        final List<Type> result = new ArrayList<Type>();
        if (feature instanceof Feature) {
            result.add(((Feature) feature).getOwner());
        }
        if (feature instanceof ParameterizedCallable) {
            result.addAll(((ParameterizedCallable) feature).getParameterTypes());
        }
        return result;
    }

    public final static Comparator<List<? extends Type>> typesComparator = new TypesComparator();

}
