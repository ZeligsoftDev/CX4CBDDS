/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.zdl.staticapi.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * @author prismtech
 * 
 */
public abstract class AbstractBaseZDLFactory implements ZDLFactory {
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.zeligsoft.base.zdl.staticapi.util.ZDLFactory#create(java.lang.String,
     * org.eclipse.emf.ecore.EObject, java.lang.Class)
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T create(String concept, EObject arg, Class<T> returnType)
    throws SecurityException, NoSuchMethodException,
    IllegalArgumentException, InstantiationException,
    IllegalAccessException, InvocationTargetException {
        final Class<?> typeToCreate = getRegistry().get(concept);
        
        T newInstance = null;
        if(typeToCreate != null) {
            final Constructor<?> cons = typeToCreate
            .getConstructor(org.eclipse.emf.ecore.EObject.class);
            newInstance = (T) cons.newInstance(arg);
        } 
        return newInstance;
    }

    protected abstract Map<String, Class<?>> getRegistry();
}
