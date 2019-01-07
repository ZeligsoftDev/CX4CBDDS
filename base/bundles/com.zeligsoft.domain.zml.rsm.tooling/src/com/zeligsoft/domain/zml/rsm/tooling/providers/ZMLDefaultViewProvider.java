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
package com.zeligsoft.domain.zml.rsm.tooling.providers;

import com.zeligsoft.domain.zml.rsm.tooling.types.ZMLElementTypes;

import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.AssemblyConnectorConnectorViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.BuildConfigurationClassViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.BuildConfigurationInstanceSpecificationViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.ComponentInterfaceComponentViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.ConfigurationClassViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.ConfigurationInstanceSpecificationViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.FlowPortPortViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.HwBusComponentViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.HwCardComponentViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.HwConnectorConnectorViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.HwCoreComponentViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.HwPartPropertyViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.HwPortPortViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.HwProcessorComponentViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.ImplementationArtifactViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.InterfaceInterfaceViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.MessagePortPortViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.PartPropertyViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.StructuralRealizationComponentViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.SwBusComponentViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.SwConnectorConnectorViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.SwOperatingSystemComponentViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.SwPartPropertyViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.SwPlatformComponentViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.SwPortPortViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.SwSchedulableResourceComponentViewCustomizer;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.WorkerFunctionOperationViewCustomizer;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.gmf.runtime.common.core.service.IOperation;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;


import org.eclipse.gmf.runtime.diagram.core.services.ViewService;

import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;

import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import com.zeligsoft.base.rsm.tooling.providers.CustomizerViewProvider;
import com.zeligsoft.base.rsm.tooling.providers.IViewCustomizer;
import com.zeligsoft.base.rsm.tooling.providers.WrapperAdaptable;

/**
 * @generated NOT
 */
public class ZMLDefaultViewProvider
	extends CustomizerViewProvider {
	
    /**
     * @generated
     */
    private static Map nodeMap = new HashMap();
    
    /**
     * @generated
     */
    static {
        nodeMap.put(ZMLElementTypes._BUILDCONFIGURATION__CLASS, BuildConfigurationClassViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._CONFIGURATION__CLASS, ConfigurationClassViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._SWBUS__COMPONENT, SwBusComponentViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._SWPORT__PORT, SwPortPortViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._HWCARD__COMPONENT, HwCardComponentViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._HWPORT__PORT, HwPortPortViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._FLOWPORT__PORT, FlowPortPortViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._SWSCHEDULABLERESOURCE__COMPONENT, SwSchedulableResourceComponentViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._HWPROCESSOR__COMPONENT, HwProcessorComponentViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._IMPLEMENTATION__ARTIFACT, ImplementationArtifactViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._STRUCTURALREALIZATION__COMPONENT, StructuralRealizationComponentViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._HWCORE__COMPONENT, HwCoreComponentViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._HWBUS__COMPONENT, HwBusComponentViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._COMPONENTINTERFACE__COMPONENT, ComponentInterfaceComponentViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._PART__PROPERTY, PartPropertyViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._INTERFACE__INTERFACE, InterfaceInterfaceViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._CONFIGURATION__INSTANCESPECIFICATION, ConfigurationInstanceSpecificationViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._SWPLATFORM__COMPONENT, SwPlatformComponentViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._MESSAGEPORT__PORT, MessagePortPortViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._BUILDCONFIGURATION__INSTANCESPECIFICATION, BuildConfigurationInstanceSpecificationViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._SWPART__PROPERTY, SwPartPropertyViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._WORKERFUNCTION__OPERATION, WorkerFunctionOperationViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._HWPART__PROPERTY, HwPartPropertyViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._SWOPERATINGSYSTEM__COMPONENT, SwOperatingSystemComponentViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._ASSEMBLYCONNECTOR__CONNECTOR, AssemblyConnectorConnectorViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._SWCONNECTOR__CONNECTOR, SwConnectorConnectorViewCustomizer.INSTANCE);
        nodeMap.put(ZMLElementTypes._HWCONNECTOR__CONNECTOR, HwConnectorConnectorViewCustomizer.INSTANCE);
    }
    
	/**
	 * @generated
	 */
    public Diagram createDiagram(IAdaptable semanticAdapter,
			String diagramKind, PreferencesHint preferencesHint) {
		return ViewService.getInstance().createDiagram(new WrapperAdaptable(semanticAdapter), diagramKind, preferencesHint);
	}


	/**
	 * @generated
	 */
	public Edge createEdge(IAdaptable semanticAdapter, View containerView,
			String semanticHint, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Edge umlEdge = ViewService.getInstance().createEdge(new WrapperAdaptable(semanticAdapter), containerView, semanticHint, index, persisted, preferencesHint);
		IViewCustomizer customizer = getEdgeViewCustomizer(semanticAdapter, containerView, semanticHint);
		if(customizer != null && umlEdge != null) {
			customizer.customizeView(umlEdge);
		}
		customizeEdgeView(umlEdge);
		return umlEdge;
	}


	/**
	 * @generated
	 */
	public Node createNode(IAdaptable semanticAdapter, View containerView,
			String semanticHint, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node umlNode = ViewService.getInstance().createNode(new WrapperAdaptable(semanticAdapter), containerView, semanticHint, index, persisted, preferencesHint);
		IViewCustomizer customizer = getNodeViewCustomizer(semanticAdapter, containerView, semanticHint);
		if(customizer != null && umlNode != null) {
			customizer.customizeView(umlNode);
		}
		customizeNodeView(umlNode);
		return umlNode;
	}


	/**
	 * @generated
	 */
	@Override
	public boolean provides(IOperation operation) {
		
		/* Make sure it is a view operation */
		assert operation instanceof CreateViewOperation : "operation is not CreateViewOperation in AbstractViewProvider";//$NON-NLS-1$
		
		if (!isZDLProfileApplied((CreateViewOperation)operation)){
			return false;
		}		
		
		/* if this is the CreateViewForKindOperation operation */
		if (operation instanceof CreateViewForKindOperation)
			return provides((CreateViewForKindOperation) operation);		

		/* call the specific provides method */
		if (operation instanceof CreateDiagramViewOperation)
			return provides((CreateDiagramViewOperation) operation);
		else if (operation instanceof CreateEdgeViewOperation)
			return provides((CreateEdgeViewOperation) operation);
		else if (operation instanceof CreateNodeViewOperation)
			return provides((CreateNodeViewOperation) operation);
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateViewForKindOperation op) {
		if (op.getViewKind() == Node.class)
			return getNodeViewCustomizer(op.getSemanticAdapter(), op
				.getContainerView(), op.getSemanticHint()) != null;
		if (op.getViewKind() == Edge.class)
			return getEdgeViewCustomizer(op.getSemanticAdapter(), op
				.getContainerView(), op.getSemanticHint()) != null;
		return true;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation operation) {
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateEdgeViewOperation operation) {
		return (getEdgeViewCustomizer(operation.getSemanticAdapter(), operation
				.getContainerView(), operation.getSemanticHint()) != null);
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateNodeViewOperation operation) {
		return (getNodeViewCustomizer(operation.getSemanticAdapter(), operation
				.getContainerView(), operation.getSemanticHint()) != null);
	}


    /**
     * @generated
     */
    protected IViewCustomizer getNodeViewCustomizer(IAdaptable semanticAdapter,
            View containerView, String semanticHint) {
		if(semanticAdapter instanceof WrapperAdaptable)
			return null;

        if (semanticHint != null && semanticHint.length() > 0) {
            return (IViewCustomizer)nodeMap.get(semanticHint);
        }
        IElementType elementType = (IElementType)semanticAdapter.getAdapter(IElementType.class);
        if (elementType != null) {
            return (IViewCustomizer)nodeMap.get(elementType);
        } else {
            EObject eObject = getSemanticElement(semanticAdapter);
            if (eObject != null) {
                // first check specialization type matches
                for (int i = 0; i < ZMLElementTypes.NODE_TYPES.length; ++i) {
                    elementType = ZMLElementTypes.NODE_TYPES[i];
                    if (elementType instanceof ISpecializationType) {
                        if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                            return (IViewCustomizer) nodeMap.get(elementType);
                        }
                    }
                }
                // next check metamodel type matches
                for (int i = 0; i < ZMLElementTypes.NODE_TYPES.length; ++i) {
                    elementType = ZMLElementTypes.NODE_TYPES[i];
                    if (elementType instanceof IMetamodelType) {
                        if (eObject.eClass() == elementType.getEClass()) {
                            return (IViewCustomizer) nodeMap.get(elementType);
                        }
                    }
                }
            }
        }
        return null;
    }
        

    /**
     * @generated
     */
    protected IViewCustomizer getEdgeViewCustomizer(IAdaptable semanticAdapter,
            View containerView, String semanticHint) {
		if(semanticAdapter instanceof WrapperAdaptable)
			return null;
            
        if (semanticHint != null && semanticHint.length() > 0) {
            return (IViewCustomizer)nodeMap.get(semanticHint);
        }
        IElementType elementType = (IElementType)semanticAdapter.getAdapter(IElementType.class);
        if (elementType != null) {
            return (IViewCustomizer)nodeMap.get(elementType);
        } else {
            EObject eObject = getSemanticElement(semanticAdapter);
            if (eObject != null) {
                // first check specialization type matches
                for (int i = 0; i < ZMLElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                    elementType = ZMLElementTypes.RELATIONSHIP_TYPES[i];
                    if (elementType instanceof ISpecializationType) {
                        if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                            return (IViewCustomizer) nodeMap.get(elementType);
                        }
                    }
                }
                // next check metamodel type matches
                for (int i = 0; i < ZMLElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                    elementType = ZMLElementTypes.RELATIONSHIP_TYPES[i];
                    if (elementType instanceof IMetamodelType) {
                        if (eObject.eClass() == elementType.getEClass()) {
                            return (IViewCustomizer) nodeMap.get(elementType);
                        }
                    }
                }
            }
        }
        return null;       
    }

	/**
	 * @generated
	 */
	protected EObject getSemanticElement(IAdaptable semanticAdapter) {
		if (semanticAdapter == null)
			return null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null)
			return EMFCoreUtil.resolve(TransactionUtil.getEditingDomain(eObject), eObject);
		return null;
	}

	/**
	 * @generated
	 */
	protected EObject getSemanticElement(IAdaptable semanticAdapter,
			TransactionalEditingDomain domain) {
		if (semanticAdapter == null)
			return null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null)
			return EMFCoreUtil.resolve(domain, eObject);
		return null;
	}
}