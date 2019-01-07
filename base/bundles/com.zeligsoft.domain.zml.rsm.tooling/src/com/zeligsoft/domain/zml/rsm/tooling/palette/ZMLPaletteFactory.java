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
package com.zeligsoft.domain.zml.rsm.tooling.palette;

import com.zeligsoft.domain.zml.rsm.tooling.l10n.ZMLMessages;

import com.zeligsoft.domain.zml.rsm.tooling.types.ZMLElementTypes;

import com.zeligsoft.domain.zml.rsm.tooling.utils.ZMLUtil;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.gef.Tool;

import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gef.palette.ToolEntry;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;

import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.jface.resource.ImageDescriptor;

/**
 * @generated
 */
public class ZMLPaletteFactory {

    /**
     * @generated
     */
    private ResourceSet resourceSet;
    
    /**
     * @generated
     */
    public ZMLPaletteFactory(DiagramEditor editor) {
        this.resourceSet = editor.getEditingDomain().getResourceSet();
    }
    
    /**
     * @generated
     */
    public void fillPalette(PaletteRoot paletteRoot) {
        paletteRoot.add(createZeligsoft_Application_ComponentsDrawer());
        paletteRoot.add(createZeligsoft_Software_PlatformDrawer());
        paletteRoot.add(createZeligsoft_Hardware_PlatformDrawer());
        paletteRoot.add(createZeligsoft_ConfigurationsDrawer());
    }

    /**
     * @generated
     */
    private PaletteDrawer createZeligsoft_Application_ComponentsDrawer() {
        PaletteDrawer paletteDrawer = new PaletteDrawer(ZMLMessages.PaletteDrawer_Zeligsoft_Application_Components_name);
        paletteDrawer.setId("Zeligsoft_Application_Components"); //$NON-NLS-1$
        paletteDrawer.setDescription(ZMLMessages.PaletteDrawer_Zeligsoft_Application_Components_description);
        paletteDrawer.add(createComponentsStack());
        paletteDrawer.add(createPartCreationTool());
        paletteDrawer.add(createPortsStack());
        paletteDrawer.add(createAssembly_ConnectorCreationTool());
        paletteDrawer.add(createRealizationCreationTool());
        paletteDrawer.add(createImplementationCreationTool());
        paletteDrawer.add(createWorker_FunctionCreationTool());
        paletteDrawer.add(createReceiverCreationTool());
        return paletteDrawer;
    }

    /**
     * @generated
     */
    private PaletteStack createComponentsStack() {
        ImageDescriptor smallImage = null;
        ImageDescriptor largeImage = ZMLUtil.getImageDescriptor(""); //$NON-NLS-1$
        PaletteStack paletteStack = new PaletteStack(ZMLMessages.PaletteStack_Components_name, ZMLMessages.PaletteStack_Components_description, smallImage);
        paletteStack.setId("Zeligsoft_Application_Components.ComponentStack"); //$NON-NLS-1$

        paletteStack.setLargeIcon(largeImage);
        paletteStack.add(createComponent_InterfaceCreationTool());
        paletteStack.add(createStructural_RealizationCreationTool());
        paletteStack.add(createComponent_ImplementationCreationTool());
        return paletteStack;
    }

    /**
     * @generated
     */
    private ToolEntry createComponent_InterfaceCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._COMPONENTINTERFACE__COMPONENT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._COMPONENTINTERFACE__COMPONENT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Application_Components.Component_Interface", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Component_Interface_name,
                ZMLMessages.PaletteTool_Component_Interface_description,
                smallImage,
                largeImage,
                ZMLElementTypes._COMPONENTINTERFACE__COMPONENT);
    }

    /**
     * @generated
     */
    private ToolEntry createStructural_RealizationCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._STRUCTURALREALIZATION__COMPONENT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._STRUCTURALREALIZATION__COMPONENT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Application_Components.Structural_Realization", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Structural_Realization_name,
                ZMLMessages.PaletteTool_Structural_Realization_description,
                smallImage,
                largeImage,
                ZMLElementTypes._STRUCTURALREALIZATION__COMPONENT);
    }

    /**
     * @generated
     */
    private ToolEntry createComponent_ImplementationCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._IMPLEMENTATION__ARTIFACT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._IMPLEMENTATION__ARTIFACT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Application_Components.Component_Implementation", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Component_Implementation_name,
                ZMLMessages.PaletteTool_Component_Implementation_description,
                smallImage,
                largeImage,
                ZMLElementTypes._IMPLEMENTATION__ARTIFACT);
    }

    /**
     * @generated
     */
    private ToolEntry createPartCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._PART__PROPERTY, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._PART__PROPERTY, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Application_Components.Part", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Part_name,
                ZMLMessages.PaletteTool_Part_description,
                smallImage,
                largeImage,
                ZMLElementTypes._PART__PROPERTY);
    }

    /**
     * @generated
     */
    private PaletteStack createPortsStack() {
        ImageDescriptor smallImage = null;
        ImageDescriptor largeImage = null;
        PaletteStack paletteStack = new PaletteStack(ZMLMessages.PaletteStack_Ports_name, ZMLMessages.PaletteStack_Ports_description, smallImage);
        paletteStack.setId("Zeligsoft_Application_Components.PortStack"); //$NON-NLS-1$

        paletteStack.setLargeIcon(largeImage);
        paletteStack.add(createMessage_PortCreationTool());
        paletteStack.add(createFlow_PortCreationTool());
        paletteStack.add(createInterfaceCreationTool());
        return paletteStack;
    }

    /**
     * @generated
     */
    private ToolEntry createMessage_PortCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._MESSAGEPORT__PORT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._MESSAGEPORT__PORT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Application_Components.Message_Port", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Message_Port_name,
                ZMLMessages.PaletteTool_Message_Port_description,
                smallImage,
                largeImage,
                ZMLElementTypes._MESSAGEPORT__PORT);
    }

    /**
     * @generated
     */
    private ToolEntry createFlow_PortCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._FLOWPORT__PORT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._FLOWPORT__PORT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Application_Components.Flow_Port", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Flow_Port_name,
                ZMLMessages.PaletteTool_Flow_Port_description,
                smallImage,
                largeImage,
                ZMLElementTypes._FLOWPORT__PORT);
    }

    /**
     * @generated
     */
    private ToolEntry createInterfaceCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._INTERFACE__INTERFACE, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._INTERFACE__INTERFACE, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Application_Components.Interface", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Interface_name,
                ZMLMessages.PaletteTool_Interface_description,
                smallImage,
                largeImage,
                ZMLElementTypes._INTERFACE__INTERFACE);
    }

    /**
     * @generated
     */
    private ToolEntry createAssembly_ConnectorCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._ASSEMBLYCONNECTOR__CONNECTOR, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._ASSEMBLYCONNECTOR__CONNECTOR, resourceSet);    
    
        return new ConnectionToolEntry(
                "Zeligsoft_Application_Components.Assembly_Connector", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Assembly_Connector_name,
                ZMLMessages.PaletteTool_Assembly_Connector_description,
                smallImage,
                largeImage,
                ZMLElementTypes._ASSEMBLYCONNECTOR__CONNECTOR);
    }

    /**
     * @generated
     */
    private ToolEntry createRealizationCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes.COMPONENTINTERFACE_REALIZATION, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes.COMPONENTINTERFACE_REALIZATION, resourceSet);    
    
        return new ConnectionToolEntry(
                "Zeligsoft_Application_Components.Realization", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Realization_name,
                ZMLMessages.PaletteTool_Realization_description,
                smallImage,
                largeImage,
                ZMLElementTypes.COMPONENTINTERFACE_REALIZATION);
    }

    /**
     * @generated
     */
    private ToolEntry createImplementationCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes.STRUCTURALREALIZATION_IMPLEMENTATION, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes.STRUCTURALREALIZATION_IMPLEMENTATION, resourceSet);    
    
        return new ConnectionToolEntry(
                "Zeligsoft_Application_Components.Implementation", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Implementation_name,
                ZMLMessages.PaletteTool_Implementation_description,
                smallImage,
                largeImage,
                ZMLElementTypes.STRUCTURALREALIZATION_IMPLEMENTATION);
    }

    /**
     * @generated
     */
    private ToolEntry createWorker_FunctionCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._WORKERFUNCTION__OPERATION, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._WORKERFUNCTION__OPERATION, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Application_Components.Worker_Function", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Worker_Function_name,
                ZMLMessages.PaletteTool_Worker_Function_description,
                smallImage,
                largeImage,
                ZMLElementTypes._WORKERFUNCTION__OPERATION);
    }

    /**
     * @generated
     */
    private ToolEntry createReceiverCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes.WORKERFUNCTION_RECEIVINGPORT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes.WORKERFUNCTION_RECEIVINGPORT, resourceSet);    
    
        return new ConnectionToolEntry(
                "Zeligsoft_Application_Components.Receiver", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Receiver_name,
                ZMLMessages.PaletteTool_Receiver_description,
                smallImage,
                largeImage,
                ZMLElementTypes.WORKERFUNCTION_RECEIVINGPORT);
    }

    /**
     * @generated
     */
    private PaletteDrawer createZeligsoft_Software_PlatformDrawer() {
        PaletteDrawer paletteDrawer = new PaletteDrawer(ZMLMessages.PaletteDrawer_Zeligsoft_Software_Platform_name);
        paletteDrawer.setId("Zeligsoft_Software_Platform"); //$NON-NLS-1$
        paletteDrawer.setDescription(ZMLMessages.PaletteDrawer_Zeligsoft_Software_Platform_description);
        paletteDrawer.add(createSoftware_PlatformCreationTool());
        paletteDrawer.add(createOperating_SystemCreationTool());
        paletteDrawer.add(createSchedulable_ResourceCreationTool());
        paletteDrawer.add(createPart___Software_PlatformCreationTool());
        paletteDrawer.add(createPort___Software_PlatformCreationTool());
        paletteDrawer.add(createConnector___Software_PlatformCreationTool());
        paletteDrawer.add(createBus___Software_PlatformCreationTool());
        return paletteDrawer;
    }

    /**
     * @generated
     */
    private ToolEntry createSoftware_PlatformCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._SWPLATFORM__COMPONENT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._SWPLATFORM__COMPONENT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Software_Platform.Software_Platform", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Software_Platform_name,
                ZMLMessages.PaletteTool_Software_Platform_description,
                smallImage,
                largeImage,
                ZMLElementTypes._SWPLATFORM__COMPONENT);
    }

    /**
     * @generated
     */
    private ToolEntry createOperating_SystemCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._SWOPERATINGSYSTEM__COMPONENT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._SWOPERATINGSYSTEM__COMPONENT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Software_Platform.Operating_System", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Operating_System_name,
                ZMLMessages.PaletteTool_Operating_System_description,
                smallImage,
                largeImage,
                ZMLElementTypes._SWOPERATINGSYSTEM__COMPONENT);
    }

    /**
     * @generated
     */
    private ToolEntry createSchedulable_ResourceCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._SWSCHEDULABLERESOURCE__COMPONENT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._SWSCHEDULABLERESOURCE__COMPONENT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Software_Platform.Schedulable_Resource", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Schedulable_Resource_name,
                ZMLMessages.PaletteTool_Schedulable_Resource_description,
                smallImage,
                largeImage,
                ZMLElementTypes._SWSCHEDULABLERESOURCE__COMPONENT);
    }

    /**
     * @generated
     */
    private ToolEntry createPart___Software_PlatformCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._SWPART__PROPERTY, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._SWPART__PROPERTY, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Software_Platform.Part___Software_Platform", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Part___Software_Platform_name,
                ZMLMessages.PaletteTool_Part___Software_Platform_description,
                smallImage,
                largeImage,
                ZMLElementTypes._SWPART__PROPERTY);
    }

    /**
     * @generated
     */
    private ToolEntry createPort___Software_PlatformCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._SWPORT__PORT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._SWPORT__PORT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Software_Platform.Port___Software_Platform", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Port___Software_Platform_name,
                ZMLMessages.PaletteTool_Port___Software_Platform_description,
                smallImage,
                largeImage,
                ZMLElementTypes._SWPORT__PORT);
    }

    /**
     * @generated
     */
    private ToolEntry createConnector___Software_PlatformCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._SWCONNECTOR__CONNECTOR, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._SWCONNECTOR__CONNECTOR, resourceSet);    
    
        return new ConnectionToolEntry(
                "Zeligsoft_Software_Platform.Connector___Software_Platform", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Connector___Software_Platform_name,
                ZMLMessages.PaletteTool_Connector___Software_Platform_description,
                smallImage,
                largeImage,
                ZMLElementTypes._SWCONNECTOR__CONNECTOR);
    }

    /**
     * @generated
     */
    private ToolEntry createBus___Software_PlatformCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._SWBUS__COMPONENT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._SWBUS__COMPONENT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Software_Platform.Bus___Software_Platform", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Bus___Software_Platform_name,
                ZMLMessages.PaletteTool_Bus___Software_Platform_description,
                smallImage,
                largeImage,
                ZMLElementTypes._SWBUS__COMPONENT);
    }

    /**
     * @generated
     */
    private PaletteDrawer createZeligsoft_Hardware_PlatformDrawer() {
        PaletteDrawer paletteDrawer = new PaletteDrawer(ZMLMessages.PaletteDrawer_Zeligsoft_Hardware_Platform_name);
        paletteDrawer.setId("Zeligsoft_Hardware_Platform"); //$NON-NLS-1$
        paletteDrawer.setDescription(ZMLMessages.PaletteDrawer_Zeligsoft_Hardware_Platform_description);
        paletteDrawer.add(createCardCreationTool());
        paletteDrawer.add(createProcessorCreationTool());
        paletteDrawer.add(createCoreCreationTool());
        paletteDrawer.add(createPart___Hardware_PlatformCreationTool());
        paletteDrawer.add(createPort___Hardware_PlatformCreationTool());
        paletteDrawer.add(createBus___Hardware_PlatformCreationTool());
        paletteDrawer.add(createConnector___Hardware_PlatformCreationTool());
        return paletteDrawer;
    }

    /**
     * @generated
     */
    private ToolEntry createCardCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._HWCARD__COMPONENT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._HWCARD__COMPONENT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Hardware_Platform.Card", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Card_name,
                ZMLMessages.PaletteTool_Card_description,
                smallImage,
                largeImage,
                ZMLElementTypes._HWCARD__COMPONENT);
    }

    /**
     * @generated
     */
    private ToolEntry createProcessorCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._HWPROCESSOR__COMPONENT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._HWPROCESSOR__COMPONENT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Hardware_Platform.Processor", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Processor_name,
                ZMLMessages.PaletteTool_Processor_description,
                smallImage,
                largeImage,
                ZMLElementTypes._HWPROCESSOR__COMPONENT);
    }

    /**
     * @generated
     */
    private ToolEntry createCoreCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._HWCORE__COMPONENT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._HWCORE__COMPONENT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Hardware_Platform.Core", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Core_name,
                ZMLMessages.PaletteTool_Core_description,
                smallImage,
                largeImage,
                ZMLElementTypes._HWCORE__COMPONENT);
    }

    /**
     * @generated
     */
    private ToolEntry createPart___Hardware_PlatformCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._HWPART__PROPERTY, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._HWPART__PROPERTY, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Hardware_Platform.Part___Hardware_Platform", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Part___Hardware_Platform_name,
                ZMLMessages.PaletteTool_Part___Hardware_Platform_description,
                smallImage,
                largeImage,
                ZMLElementTypes._HWPART__PROPERTY);
    }

    /**
     * @generated
     */
    private ToolEntry createPort___Hardware_PlatformCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._HWPORT__PORT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._HWPORT__PORT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Hardware_Platform.Port___Hardware_Platform", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Port___Hardware_Platform_name,
                ZMLMessages.PaletteTool_Port___Hardware_Platform_description,
                smallImage,
                largeImage,
                ZMLElementTypes._HWPORT__PORT);
    }

    /**
     * @generated
     */
    private ToolEntry createBus___Hardware_PlatformCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._HWBUS__COMPONENT, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._HWBUS__COMPONENT, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Hardware_Platform.Bus___Hardware_Platform", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Bus___Hardware_Platform_name,
                ZMLMessages.PaletteTool_Bus___Hardware_Platform_description,
                smallImage,
                largeImage,
                ZMLElementTypes._HWBUS__COMPONENT);
    }

    /**
     * @generated
     */
    private ToolEntry createConnector___Hardware_PlatformCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._HWCONNECTOR__CONNECTOR, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._HWCONNECTOR__CONNECTOR, resourceSet);    
    
        return new ConnectionToolEntry(
                "Zeligsoft_Hardware_Platform.Connector___Hardware_Platform", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Connector___Hardware_Platform_name,
                ZMLMessages.PaletteTool_Connector___Hardware_Platform_description,
                smallImage,
                largeImage,
                ZMLElementTypes._HWCONNECTOR__CONNECTOR);
    }

    /**
     * @generated
     */
    private PaletteDrawer createZeligsoft_ConfigurationsDrawer() {
        PaletteDrawer paletteDrawer = new PaletteDrawer(ZMLMessages.PaletteDrawer_Zeligsoft_Configurations_name);
        paletteDrawer.setId("Zeligsoft_Configurations"); //$NON-NLS-1$
        paletteDrawer.setDescription(ZMLMessages.PaletteDrawer_Zeligsoft_Configurations_description);
        paletteDrawer.add(createConfigurationCreationTool());
        paletteDrawer.add(createConfiguration_TypeCreationTool());
        paletteDrawer.add(createBuild_ConfigurationCreationTool());
        paletteDrawer.add(createBuild_Configuration_TypeCreationTool());
        return paletteDrawer;
    }

    /**
     * @generated
     */
    private ToolEntry createConfigurationCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._CONFIGURATION__INSTANCESPECIFICATION, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._CONFIGURATION__INSTANCESPECIFICATION, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Configurations.Configuration", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Configuration_name,
                ZMLMessages.PaletteTool_Configuration_description,
                smallImage,
                largeImage,
                ZMLElementTypes._CONFIGURATION__INSTANCESPECIFICATION);
    }

    /**
     * @generated
     */
    private ToolEntry createConfiguration_TypeCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._CONFIGURATION__CLASS, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._CONFIGURATION__CLASS, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Configurations.Configuration_Type", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Configuration_Type_name,
                ZMLMessages.PaletteTool_Configuration_Type_description,
                smallImage,
                largeImage,
                ZMLElementTypes._CONFIGURATION__CLASS);
    }

    /**
     * @generated
     */
    private ToolEntry createBuild_ConfigurationCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._BUILDCONFIGURATION__INSTANCESPECIFICATION, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._BUILDCONFIGURATION__INSTANCESPECIFICATION, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Configurations.Build_Configuration", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Build_Configuration_name,
                ZMLMessages.PaletteTool_Build_Configuration_description,
                smallImage,
                largeImage,
                ZMLElementTypes._BUILDCONFIGURATION__INSTANCESPECIFICATION);
    }

    /**
     * @generated
     */
    private ToolEntry createBuild_Configuration_TypeCreationTool() {
        ImageDescriptor smallImage = ZMLUtil.getSmallImage(ZMLElementTypes._BUILDCONFIGURATION__CLASS, resourceSet);
        ImageDescriptor largeImage = ZMLUtil.getLargeImage(ZMLElementTypes._BUILDCONFIGURATION__CLASS, resourceSet);    
    
        return new NodeToolEntry(
                "Zeligsoft_Configurations.Build_Configuration_Type", //$NON-NLS-1$
                ZMLMessages.PaletteTool_Build_Configuration_Type_name,
                ZMLMessages.PaletteTool_Build_Configuration_Type_description,
                smallImage,
                largeImage,
                ZMLElementTypes._BUILDCONFIGURATION__CLASS);
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