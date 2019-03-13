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
import org.eclipse.xtext.xbase.lib.Functions.Function1;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public final class TypeSelectPredicate<T extends ZObject> implements Function1<Object, Boolean> {
    private final String zdlType;
    private final Class<T> wrapperType;
    
    public TypeSelectPredicate(String type, Class<T> wrapperType) {
        zdlType = type;
        this.wrapperType = wrapperType;
    }
    
    @Override
    public Boolean apply(Object p) {
        if(p instanceof EObject &&
                ZDLUtil.isZDLConcept((EObject) p, zdlType)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Class<T> getWrapperType() {
        return wrapperType;
    }
}
