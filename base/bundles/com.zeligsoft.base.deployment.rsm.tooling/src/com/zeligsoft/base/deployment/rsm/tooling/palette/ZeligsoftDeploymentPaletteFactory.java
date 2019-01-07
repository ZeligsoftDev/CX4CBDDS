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

import com.zeligsoft.base.deployment.rsm.tooling.l10n.ZeligsoftDeploymentMessages;

import com.zeligsoft.base.deployment.rsm.tooling.types.ZeligsoftDeploymentElementTypes;

import com.zeligsoft.base.deployment.rsm.tooling.utils.ZeligsoftDeploymentUtil;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.gef.Tool;

import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;

import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.jface.resource.ImageDescriptor;

/**
 * @generated
 */
public class ZeligsoftDeploymentPaletteFactory {

    /**
     * @generated
     */
    private ResourceSet resourceSet;
    
    /**
     * @generated
     */
    public ZeligsoftDeploymentPaletteFactory(DiagramEditor editor) {
        this.resourceSet = editor.getEditingDomain().getResourceSet();
    }
    
    /**
     * @generated
     */
    public void fillPalette(PaletteRoot paletteRoot) {
        paletteRoot.add(createZeligsoft_DeploymentDrawer());
    }

    /**
     * @generated
     */
    private PaletteDrawer createZeligsoft_DeploymentDrawer() {
        PaletteDrawer paletteDrawer = new PaletteDrawer(ZeligsoftDeploymentMessages.PaletteDrawer_Zeligsoft_Deployment_name);
        paletteDrawer.setId("Zeligsoft_Deployment"); //$NON-NLS-1$
        paletteDrawer.setDescription(ZeligsoftDeploymentMessages.PaletteDrawer_Zeligsoft_Deployment_description);
        paletteDrawer.add(createAllocationCreationTool());
        paletteDrawer.add(createDeployment_PartCreationTool());
        paletteDrawer.add(createComponent_Deployment_PartCreationTool());
        return paletteDrawer;
    }

    /**
     * @generated
     */
    private ToolEntry createAllocationCreationTool() {
        ImageDescriptor smallImage = ZeligsoftDeploymentUtil.getSmallImage(ZeligsoftDeploymentElementTypes._ALLOCATION__DEPENDENCY, resourceSet);
        ImageDescriptor largeImage = ZeligsoftDeploymentUtil.getImageDescriptor(""); //$NON-NLS-1$    
    
        return new ConnectionToolEntry(
                "Zeligsoft_Deployment.Allocation", //$NON-NLS-1$
                ZeligsoftDeploymentMessages.PaletteTool_Allocation_name,
                ZeligsoftDeploymentMessages.PaletteTool_Allocation_description,
                smallImage,
                largeImage,
                ZeligsoftDeploymentElementTypes._ALLOCATION__DEPENDENCY);
    }

    /**
     * @generated
     */
    private ToolEntry createDeployment_PartCreationTool() {
        ImageDescriptor smallImage = ZeligsoftDeploymentUtil.getSmallImage(ZeligsoftDeploymentElementTypes._DEPLOYMENTPART__PROPERTY, resourceSet);
        ImageDescriptor largeImage = ZeligsoftDeploymentUtil.getLargeImage(ZeligsoftDeploymentElementTypes._DEPLOYMENTPART__PROPERTY, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Deployment.Deployment_Part", //$NON-NLS-1$
                ZeligsoftDeploymentMessages.PaletteTool_Deployment_Part_name,
                ZeligsoftDeploymentMessages.PaletteTool_Deployment_Part_description,
                smallImage,
                largeImage,
                ZeligsoftDeploymentElementTypes._DEPLOYMENTPART__PROPERTY);
    }      

    /**
     * @generated
     */
    private ToolEntry createComponent_Deployment_PartCreationTool() {
        ImageDescriptor smallImage = ZeligsoftDeploymentUtil.getSmallImage(ZeligsoftDeploymentElementTypes._COMPONENTDEPLOYMENTPART__PROPERTY, resourceSet);
        ImageDescriptor largeImage = ZeligsoftDeploymentUtil.getLargeImage(ZeligsoftDeploymentElementTypes._COMPONENTDEPLOYMENTPART__PROPERTY, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Deployment.Component_Deployment_Part", //$NON-NLS-1$
                ZeligsoftDeploymentMessages.PaletteTool_Component_Deployment_Part_name,
                ZeligsoftDeploymentMessages.PaletteTool_Component_Deployment_Part_description,
                smallImage,
                largeImage,
                ZeligsoftDeploymentElementTypes._COMPONENTDEPLOYMENTPART__PROPERTY);
    }

    /**
     * @generated
     */
    private static class NodeToolEntry
        extends ToolEntry {

        /**
         * @generated
         */
        private final IElementType elementType;

        /**
         * @generated
         */
        private NodeToolEntry(String id, String title, String description,
                ImageDescriptor smallIcon, ImageDescriptor largeIcon,
                IElementType elementType) {
            super(title, description, smallIcon, largeIcon);
            setId(id);
            this.elementType = elementType;
        }

        /**
         * @generated
         */
        public Tool createTool() {
            Tool tool = new CreationTool(elementType);
            return tool;
        }
        
    }

    /**
     * @generated
     */
    private static class ConnectionToolEntry
        extends ToolEntry {

        /**
         * @generated
         */
        private final IElementType elementType;

        /**
         * @generated
         */
        private ConnectionToolEntry(String id, String title, String description,
                ImageDescriptor smallIcon, ImageDescriptor largeIcon,
                IElementType elementType) {
            super(title, description, smallIcon, largeIcon);
            setId(id);
            this.elementType = elementType;
        }

        /**
         * @generated
         */
        public Tool createTool() {
            Tool tool = new ConnectionCreationTool(elementType);
            tool.setProperties(getToolProperties());
            return tool;
        }
    }
}