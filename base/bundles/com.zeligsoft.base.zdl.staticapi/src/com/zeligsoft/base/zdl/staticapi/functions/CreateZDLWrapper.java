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
package com.zeligsoft.base.zdl.staticapi.functions;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Function;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

/**
 * @author Toby McClean (tmcclean)
 * @param <T>
 * 
 */
public class CreateZDLWrapper<T> implements Function<Object, T> {

    final private Class<T> type;

    protected CreateZDLWrapper(final Class<T> concept) {
        this.type = concept;
    }

    @Override
    public T apply(Object input) {
        T result = null;
        if(input instanceof EObject) {
            result = ZDLFactoryRegistry.INSTANCE.create((EObject) input, type);
        }
        return result;
    }

    /**
     * @param <V>
     * @param zdlWrapperType
     * @return
     */
    public static <V> CreateZDLWrapper<V> create(final Class<V> zdlWrapperType) {
        return new CreateZDLWrapper<V>(zdlWrapperType);
    }
}
