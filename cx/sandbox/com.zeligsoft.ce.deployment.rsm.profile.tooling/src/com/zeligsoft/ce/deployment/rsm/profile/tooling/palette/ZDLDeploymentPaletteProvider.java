
package com.zeligsoft.ce.deployment.rsm.profile.tooling.palette;

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
public class ZDLDeploymentPaletteProvider
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
        
        new ZDLDeploymentPaletteFactory((DiagramEditor)editor).fillPalette(root);
    }

    /**
     * @generated
     */
    public void setContributions(IConfigurationElement configElement) {
        //do nothing
    }

}