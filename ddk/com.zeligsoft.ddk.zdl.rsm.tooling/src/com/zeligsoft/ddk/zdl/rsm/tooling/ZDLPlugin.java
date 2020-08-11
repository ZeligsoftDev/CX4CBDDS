/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.rsm.tooling;

import com.zeligsoft.base.ui.ZeligsoftAbstractUIPlugin;

/**
 * @generated
 */
public class ZDLPlugin
        extends ZeligsoftAbstractUIPlugin {

    /**
     * @generated
     */
    public static final String ID = "com.zeligsoft.ddk.zdl.rsm.tooling"; //$NON-NLS-1$

    /**
     * @generated
     */
    private static ZDLPlugin instance;

    /**
     * @generated
     */
    public ZDLPlugin() {
        instance = this;
    }

    /**
     * @generated
     */
    public static ZDLPlugin getDefault() {
        return instance;
    }

}