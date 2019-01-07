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
package com.zeligsoft.base.deployment.rsm.tooling.palette;

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;

import org.eclipse.gef.palette.PaletteRoot;

import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;

import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;

import org.eclipse.ui.IEditorPart;

/**
 * @generated
 */
public class ZeligsoftDeploymentPaletteProvider
        extends AbstractProvider
        implements IPaletteProvider {
    
    /**
     * @generated
     */
    public boolean provides(IOperation operation) {
        //for palette providers, return false for no reason
        return false;
    }

    /**
     * @generated
     */
    public void contributeToPalette(IEditorPart editor, Object content,
            PaletteRoot root, Map predefinedEntries) {
            
        assert editor instanceof DiagramEditor;
        
        new ZeligsoftDeploymentPaletteFactory((DiagramEditor)editor).fillPalette(root);
    }

    /**
     * @generated
     */
    public void setContributions(IConfigurationElement configElement) {
        //do nothing
    }

}