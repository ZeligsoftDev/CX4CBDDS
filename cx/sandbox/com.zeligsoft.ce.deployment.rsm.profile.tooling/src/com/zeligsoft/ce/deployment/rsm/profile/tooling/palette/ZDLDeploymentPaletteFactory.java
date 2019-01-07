
package com.zeligsoft.ce.deployment.rsm.profile.tooling.palette;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.l10n.ZDLDeploymentMessages;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.types.ZDLDeploymentElementTypes;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.utils.ZDLDeploymentUtil;

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
public class ZDLDeploymentPaletteFactory {

    /**
     * @generated
     */
    private ResourceSet resourceSet;
    
    /**
     * @generated
     */
    public ZDLDeploymentPaletteFactory(DiagramEditor editor) {
        this.resourceSet = editor.getEditingDomain().getResourceSet();
    }
    
    /**
     * @generated
     */
    public void fillPalette(PaletteRoot paletteRoot) {
        paletteRoot.add(createZeligsoft_DeploymentsDrawer());
    }

    /**
     * @generated
     */
    private PaletteDrawer createZeligsoft_DeploymentsDrawer() {
        PaletteDrawer paletteDrawer = new PaletteDrawer(ZDLDeploymentMessages.PaletteDrawer_Zeligsoft_Deployments_name);
        paletteDrawer.setId("Zeligsoft_Deployments"); //$NON-NLS-1$
        paletteDrawer.setDescription(ZDLDeploymentMessages.PaletteDrawer_Zeligsoft_Deployments_description);
        paletteDrawer.add(createDeploymentCreationTool());
        paletteDrawer.add(createAllocationCreationTool());
        paletteDrawer.add(createPart_DeploymentCreationTool());
        paletteDrawer.add(createComponent_DeploymentCreationTool());
        paletteDrawer.add(createPort_DeploymentCreationTool());
        paletteDrawer.add(createConnector_DeploymentCreationTool());
        return paletteDrawer;
    }

    /**
     * @generated
     */
    private ToolEntry createDeploymentCreationTool() {
        ImageDescriptor smallImage = ZDLDeploymentUtil.getSmallImage(ZDLDeploymentElementTypes._DEPLOYMENT__COMPONENT, resourceSet);
        ImageDescriptor largeImage = ZDLDeploymentUtil.getLargeImage(ZDLDeploymentElementTypes._DEPLOYMENT__COMPONENT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Deployments.Deployment", //$NON-NLS-1$
                ZDLDeploymentMessages.PaletteTool_Deployment_name,
                ZDLDeploymentMessages.PaletteTool_Deployment_description,
                smallImage,
                largeImage,
                ZDLDeploymentElementTypes._DEPLOYMENT__COMPONENT);
    }

    /**
     * @generated
     */
    private ToolEntry createAllocationCreationTool() {
        ImageDescriptor smallImage = ZDLDeploymentUtil.getSmallImage(ZDLDeploymentElementTypes._ALLOCATION__ASSOCIATION, resourceSet);
        ImageDescriptor largeImage = ZDLDeploymentUtil.getLargeImage(ZDLDeploymentElementTypes._ALLOCATION__ASSOCIATION, resourceSet);    
    
        return new ConnectionToolEntry(
                "Zeligsoft_Deployments.Allocation", //$NON-NLS-1$
                ZDLDeploymentMessages.PaletteTool_Allocation_name,
                ZDLDeploymentMessages.PaletteTool_Allocation_description,
                smallImage,
                largeImage,
                ZDLDeploymentElementTypes._ALLOCATION__ASSOCIATION);
    }

    /**
     * @generated
     */
    private ToolEntry createPart_DeploymentCreationTool() {
        ImageDescriptor smallImage = ZDLDeploymentUtil.getSmallImage(ZDLDeploymentElementTypes._PARTDEPLOYMENTPART__PROPERTY, resourceSet);
        ImageDescriptor largeImage = ZDLDeploymentUtil.getLargeImage(ZDLDeploymentElementTypes._PARTDEPLOYMENTPART__PROPERTY, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Deployments.Part_Deployment", //$NON-NLS-1$
                ZDLDeploymentMessages.PaletteTool_Part_Deployment_name,
                ZDLDeploymentMessages.PaletteTool_Part_Deployment_description,
                smallImage,
                largeImage,
                ZDLDeploymentElementTypes._PARTDEPLOYMENTPART__PROPERTY);
    }

    /**
     * @generated
     */
    private ToolEntry createComponent_DeploymentCreationTool() {
        ImageDescriptor smallImage = ZDLDeploymentUtil.getSmallImage(ZDLDeploymentElementTypes._DEPLOYMENTPART__PROPERTY, resourceSet);
        ImageDescriptor largeImage = ZDLDeploymentUtil.getLargeImage(ZDLDeploymentElementTypes._DEPLOYMENTPART__PROPERTY, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Deployments.Component_Deployment", //$NON-NLS-1$
                ZDLDeploymentMessages.PaletteTool_Component_Deployment_name,
                ZDLDeploymentMessages.PaletteTool_Component_Deployment_description,
                smallImage,
                largeImage,
                ZDLDeploymentElementTypes._DEPLOYMENTPART__PROPERTY);
    }

    /**
     * @generated
     */
    private ToolEntry createPort_DeploymentCreationTool() {
        ImageDescriptor smallImage = ZDLDeploymentUtil.getSmallImage(ZDLDeploymentElementTypes._PORTDEPLOYMENTPART__PROPERTY, resourceSet);
        ImageDescriptor largeImage = ZDLDeploymentUtil.getLargeImage(ZDLDeploymentElementTypes._PORTDEPLOYMENTPART__PROPERTY, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Deployments.Port_Deployment", //$NON-NLS-1$
                ZDLDeploymentMessages.PaletteTool_Port_Deployment_name,
                ZDLDeploymentMessages.PaletteTool_Port_Deployment_description,
                smallImage,
                largeImage,
                ZDLDeploymentElementTypes._PORTDEPLOYMENTPART__PROPERTY);
    }

    /**
     * @generated
     */
    private ToolEntry createConnector_DeploymentCreationTool() {
        ImageDescriptor smallImage = ZDLDeploymentUtil.getSmallImage(ZDLDeploymentElementTypes._CONNECTORDEPLOYMENTPART__PROPERTY, resourceSet);
        ImageDescriptor largeImage = ZDLDeploymentUtil.getLargeImage(ZDLDeploymentElementTypes._CONNECTORDEPLOYMENTPART__PROPERTY, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Deployments.Connector_Deployment", //$NON-NLS-1$
                ZDLDeploymentMessages.PaletteTool_Connector_Deployment_name,
                ZDLDeploymentMessages.PaletteTool_Connector_Deployment_description,
                smallImage,
                largeImage,
                ZDLDeploymentElementTypes._CONNECTORDEPLOYMENTPART__PROPERTY);
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