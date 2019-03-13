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
package com.zeligsoft.base.zdl.staticapi.core;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public interface ZObject {
    /**
     * @return the raw eObject that is be wrapped
     */
    EObject eObject();
    
    /**
     * @return the wrapped eContainer of the object if it can be wrapped
     * otherwise the raw eContainer result
     */
    Object zContainer();
}
