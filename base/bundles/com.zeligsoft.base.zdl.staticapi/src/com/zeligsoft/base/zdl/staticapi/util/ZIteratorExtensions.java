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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.CreateZDLWrapper;
import com.zeligsoft.base.zdl.staticapi.predicate.IsZDLConcept;

public class ZIteratorExtensions {
    public static final <T extends ZObject> Iterator<T> typeSelect(Iterator<?> unfiltered, Class<T> type) {
        
        try {
            Method getConceptMethod = type.getMethod("getConcept", null);
            if(getConceptMethod != null) {
                String concept = (String) getConceptMethod.invoke(null);
                UnmodifiableIterator<?> filtered = Iterators.filter(unfiltered, new IsZDLConcept(concept));
                return Iterators.transform(filtered, CreateZDLWrapper.create(type));
            }
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return Iterators.emptyIterator();
    }
}
