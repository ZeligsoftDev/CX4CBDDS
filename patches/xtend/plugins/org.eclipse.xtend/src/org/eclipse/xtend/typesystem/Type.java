/*******************************************************************************
 * Copyright (c) 2005-2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem;

import java.util.Set;

import org.eclipse.xtend.expression.TypeSystem;


/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public interface Type {
    TypeSystem getTypeSystem();

    boolean isAssignableFrom(Type t);

    boolean isInstance(Object o);

    boolean isAbstract();

    String getName();

    Object newInstance();

    Set<? extends Type> getSuperTypes();

    /**
     * finds a static property with the given name
     * 
     * @param name
     * @return
     */
    StaticProperty getStaticProperty(String name);

    /**
     * finds a property with the given name
     * 
     * @param name
     * @return
     */
    Property getProperty(String name);

    /**
     * finds an operation with the given name on the given type with respect to
     * the given parametertypes this method handles polymorphistic resolution
     * for parameter types
     * 
     * @param type
     * @param name
     * @param paramTypes
     * @return
     */
    Operation getOperation(String name, Type[] parameterTypes);

    /**
     * finds a feature with the given name on the given type with respect to the
     * given parametertypes this method handles polymorphistic resolution for
     * parameter types
     * 
     * @param type
     * @param name
     * @param paramTypes
     * @return
     */
    Callable getFeature(String name, Type[] parameterTypes);

    Set<? extends StaticProperty> getAllStaticProperties();

    Set<? extends Property> getAllProperties();

    Set<? extends Operation> getAllOperations();

    Set<? extends Callable> getAllFeatures();

    /**
     * converts the given Object to an instance of the given Class, if this type
     * is responsible for java objects of the given Class and the given Object
     * 
     * @param src
     * @param targetType
     * @return
     */
    Object convert(Object src, Class<?> targetType);

    public String getDocumentation();
}
