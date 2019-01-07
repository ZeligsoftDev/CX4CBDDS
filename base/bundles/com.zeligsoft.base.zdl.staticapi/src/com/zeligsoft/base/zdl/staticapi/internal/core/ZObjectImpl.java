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
package com.zeligsoft.base.zdl.staticapi.internal.core;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public abstract class ZObjectImpl implements ZObject {
    protected EObject element;
    protected Object zContainer;
    
    /**
     * 
     * @param wrappedElement
     */
    protected ZObjectImpl(EObject wrappedElement) {
        this.element = wrappedElement;
        zContainer = null;
    }
    
    @Override
    public Object zContainer() {
        if(zContainer == null) {
            if(element != null) {
                if(element.eContainer() != null) {
                    zContainer = ZDLFactoryRegistry.INSTANCE.create(
                            element.eContainer(), Object.class);
                }
                
                if(zContainer == null) {
                    zContainer = element.eContainer();
                }
            }
        }
        
        
        return zContainer;
    }

    @Override
    public EObject eObject() {
        return element;
    }

}
