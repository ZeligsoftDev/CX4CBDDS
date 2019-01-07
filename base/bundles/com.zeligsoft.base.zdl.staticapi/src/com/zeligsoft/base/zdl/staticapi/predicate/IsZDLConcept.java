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
package com.zeligsoft.base.zdl.staticapi.predicate;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Predicate;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * @author Toby McClean (tmcclean)
 * 
 */
public class IsZDLConcept implements Predicate<Object> {
    private final String zdlType;

    /**
     * @param concept
     */
    public IsZDLConcept(final String concept) {
        this.zdlType = concept;
    }

    @Override
    public boolean apply(Object input) {
        if(input instanceof EObject) {
            return ZDLUtil.isZDLConcept((EObject) input, zdlType);
        } else {
            return false;
        }
    }
}
