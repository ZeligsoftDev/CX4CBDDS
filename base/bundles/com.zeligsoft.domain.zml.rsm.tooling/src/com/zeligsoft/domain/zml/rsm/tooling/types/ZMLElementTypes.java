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
package com.zeligsoft.domain.zml.rsm.tooling.types;

import com.ibm.xtools.uml.type.IStereotypedElementType;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;

/**
 * @generated
 */
public class ZMLElementTypes extends AbstractElementTypeEnumerator {

    /**
     * @generated
     */
    public static final IStereotypedElementType _BUILDCONFIGURATION__CLASS = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.BuildConfigurationClass"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _CONFIGURATION__CLASS = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.ConfigurationClass"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _SWBUS__COMPONENT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.SwBusComponent"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _SWPORT__PORT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.SwPortPort"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _HWCARD__COMPONENT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.HwCardComponent"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _HWPORT__PORT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.HwPortPort"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _FLOWPORT__PORT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.FlowPortPort"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _SWSCHEDULABLERESOURCE__COMPONENT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.SwSchedulableResourceComponent"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _HWPROCESSOR__COMPONENT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.HwProcessorComponent"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _IMPLEMENTATION__ARTIFACT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.ImplementationArtifact"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _STRUCTURALREALIZATION__COMPONENT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.StructuralRealizationComponent"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _HWCORE__COMPONENT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.HwCoreComponent"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _HWBUS__COMPONENT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.HwBusComponent"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _COMPONENTINTERFACE__COMPONENT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.ComponentInterfaceComponent"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _PART__PROPERTY = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.PartProperty"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _INTERFACE__INTERFACE = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.InterfaceInterface"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _CONFIGURATION__INSTANCESPECIFICATION = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.ConfigurationInstanceSpecification"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _SWPLATFORM__COMPONENT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.SwPlatformComponent"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _MESSAGEPORT__PORT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.MessagePortPort"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _BUILDCONFIGURATION__INSTANCESPECIFICATION = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.BuildConfigurationInstanceSpecification"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _SWPART__PROPERTY = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.SwPartProperty"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _WORKERFUNCTION__OPERATION = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.WorkerFunctionOperation"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _HWPART__PROPERTY = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.HwPartProperty"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _SWOPERATINGSYSTEM__COMPONENT = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.SwOperatingSystemComponent"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _ASSEMBLYCONNECTOR__CONNECTOR = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.AssemblyConnectorConnector"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _SWCONNECTOR__CONNECTOR = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.SwConnectorConnector"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _HWCONNECTOR__CONNECTOR = (IStereotypedElementType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.HwConnectorConnector"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final ISpecializationType STRUCTURALREALIZATION_IMPLEMENTATION = (ISpecializationType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.StructuralRealizationimplementationImplementation"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final ISpecializationType COMPONENTINTERFACE_REALIZATION = (ISpecializationType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.ComponentInterfacerealizationStructuralRealization"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final ISpecializationType WORKERFUNCTION_RECEIVINGPORT = (ISpecializationType)getElementType("com.zeligsoft.domain.zml.rsm.tooling.WorkerFunctionreceivingPortMessagePort"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType[] NODE_TYPES = {
            _BUILDCONFIGURATION__CLASS,
            _CONFIGURATION__CLASS,
            _SWBUS__COMPONENT,
            _SWPORT__PORT,
            _HWCARD__COMPONENT,
            _HWPORT__PORT,
            _FLOWPORT__PORT,
            _SWSCHEDULABLERESOURCE__COMPONENT,
            _HWPROCESSOR__COMPONENT,
            _IMPLEMENTATION__ARTIFACT,
            _STRUCTURALREALIZATION__COMPONENT,
            _HWCORE__COMPONENT,
            _HWBUS__COMPONENT,
            _COMPONENTINTERFACE__COMPONENT,
            _PART__PROPERTY,
            _INTERFACE__INTERFACE,
            _CONFIGURATION__INSTANCESPECIFICATION,
            _SWPLATFORM__COMPONENT,
            _MESSAGEPORT__PORT,
            _BUILDCONFIGURATION__INSTANCESPECIFICATION,
            _SWPART__PROPERTY,
            _WORKERFUNCTION__OPERATION,
            _HWPART__PROPERTY,
            _SWOPERATINGSYSTEM__COMPONENT
        };

    /**
     * @generated
     */
    public static final IElementType[] RELATIONSHIP_TYPES = {
            _ASSEMBLYCONNECTOR__CONNECTOR,
            _SWCONNECTOR__CONNECTOR,
            _HWCONNECTOR__CONNECTOR,
            STRUCTURALREALIZATION_IMPLEMENTATION,
            COMPONENTINTERFACE_REALIZATION,
            WORKERFUNCTION_RECEIVINGPORT
        };
    
    /**
     * @generated
     */
    private static Map sources = new HashMap();
    
    /**
     * @generated
     */
    static {
            IElementType[] types = new IElementType[0];
            sources.put(ZMLElementTypes._ASSEMBLYCONNECTOR__CONNECTOR, types);
            types = new IElementType[0];
            sources.put(ZMLElementTypes._SWCONNECTOR__CONNECTOR, types);
            types = new IElementType[0];
            sources.put(ZMLElementTypes._HWCONNECTOR__CONNECTOR, types);
            types = new IElementType[1];
            types[0] = ZMLElementTypes._STRUCTURALREALIZATION__COMPONENT;
            sources.put(ZMLElementTypes.STRUCTURALREALIZATION_IMPLEMENTATION, types);
            types = new IElementType[1];
            types[0] = ZMLElementTypes._COMPONENTINTERFACE__COMPONENT;
            sources.put(ZMLElementTypes.COMPONENTINTERFACE_REALIZATION, types);
            types = new IElementType[1];
            types[0] = ZMLElementTypes._WORKERFUNCTION__OPERATION;
            sources.put(ZMLElementTypes.WORKERFUNCTION_RECEIVINGPORT, types);
        };
    
    /**
     * @generated
     */
    private static Map targets = new HashMap();
    
    /**
     * @generated
     */
    static {
            IElementType[] types = new IElementType[0];
            targets.put(ZMLElementTypes._ASSEMBLYCONNECTOR__CONNECTOR, types);
            types = new IElementType[0];
            targets.put(ZMLElementTypes._SWCONNECTOR__CONNECTOR, types);
            types = new IElementType[0];
            targets.put(ZMLElementTypes._HWCONNECTOR__CONNECTOR, types);
            types = new IElementType[1];
            types[0] = ZMLElementTypes._IMPLEMENTATION__ARTIFACT;
            targets.put(ZMLElementTypes.STRUCTURALREALIZATION_IMPLEMENTATION, types);
            types = new IElementType[1];
            types[0] = ZMLElementTypes._STRUCTURALREALIZATION__COMPONENT;
            targets.put(ZMLElementTypes.COMPONENTINTERFACE_REALIZATION, types);
            types = new IElementType[2];
            types[0] = ZMLElementTypes._MESSAGEPORT__PORT;
            types[1] = ZMLElementTypes._FLOWPORT__PORT;
            targets.put(ZMLElementTypes.WORKERFUNCTION_RECEIVINGPORT, types);
        };
    
    /**
     * @generated
     */
    public static final IElementType[] getSources(IElementType elementType) {
        return (IElementType[])sources.get(elementType);
    }
    
    /**
     * @generated
     */
    public static final IElementType[] getTargets(IElementType elementType) {
        return (IElementType[])targets.get(elementType);
    }
    
    /**
     * @generated
     */
    public static IElementType getMatchingSource(IElementType elementType, EObject source) {
        return matches(getSources(elementType), source);
    }
    
    /**
     * @generated
     */
    public static IElementType getMatchingTarget(IElementType elementType, EObject target) {
        return matches(getTargets(elementType), target);
    }
    
    /**
     * @generated
     */
    public static boolean matchesSource(IElementType elementType, EObject source) {
        IElementType[] sourceTypes = getSources(elementType);
        if (sourceTypes != null && sourceTypes.length == 0) {
            return true;
        }
        return matches(sourceTypes, source) != null;
    }
    
    /**
     * @generated
     */
    public static boolean matchesTarget(IElementType elementType, EObject target) {
        IElementType[] targetTypes = getTargets(elementType);
        if (targetTypes != null && targetTypes.length == 0) {
            return true;
        }
        return matches(targetTypes, target) != null;
    }
    
    /**
     * @generated
     */
    private static IElementType matches(IElementType[] elementTypes, EObject eObject) {
        if (elementTypes == null) {
            return null;
        }
        for (int i = 0; i < elementTypes.length; ++i) {
            IElementType elementType = elementTypes[i];
            if (elementType instanceof ISpecializationType) {
                if (((ISpecializationType)elementType).getMatcher() != null &&
                        ((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                    return elementType;
                }
            } 
        }
        for (int i = 0; i < elementTypes.length; ++i) {
            IElementType elementType = elementTypes[i];
            if (elementType instanceof ISpecializationType) {
                if (((ISpecializationType)elementType).getMatcher() == null &&
                        elementType.getEClass().isSuperTypeOf(eObject.eClass())) {
                    return elementType;
                }
            } else if (elementType instanceof IMetamodelType) {
                if (elementType.getEClass().isSuperTypeOf(eObject.eClass())) {
                    return elementType;
                }
            }
        }
        return null;
    }
}