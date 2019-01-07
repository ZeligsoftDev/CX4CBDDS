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

import com.zeligsoft.domain.zml.rsm.tooling.utils.ZMLSemanticHints;

import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.ComponentInterfacerealizationStructuralRealizationLabelViewFactory;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.ComponentInterfacerealizationStructuralRealizationTextViewFactory;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.ComponentInterfacerealizationStructuralRealizationViewFactory;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.StructuralRealizationimplementationImplementationLabelViewFactory;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.StructuralRealizationimplementationImplementationTextViewFactory;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.StructuralRealizationimplementationImplementationViewFactory;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.WorkerFunctionreceivingPortMessagePortLabelViewFactory;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.WorkerFunctionreceivingPortMessagePortTextViewFactory;
import com.zeligsoft.domain.zml.rsm.tooling.viewfactories.WorkerFunctionreceivingPortMessagePortViewFactory;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ZMLViewProvider
        extends AbstractViewProvider {
    
    /**
     * @generated
     */
    private static Map nodeMap = new HashMap();
    
    /**
     * @generated
     */
    static {
        nodeMap.put(ZMLSemanticHints.SH_ZMLSTRUCTURALREALIZATIONIMPLEMENTATIONIMPLEMENTATIONLABELEDITPART, StructuralRealizationimplementationImplementationLabelViewFactory.class);
        nodeMap.put(ZMLSemanticHints.SH_ZMLSTRUCTURALREALIZATIONIMPLEMENTATIONIMPLEMENTATIONTEXTEDITPART, StructuralRealizationimplementationImplementationTextViewFactory.class);
        nodeMap.put(ZMLSemanticHints.SH_ZMLCOMPONENTINTERFACEREALIZATIONSTRUCTURALREALIZATIONLABELEDITPART, ComponentInterfacerealizationStructuralRealizationLabelViewFactory.class);
        nodeMap.put(ZMLSemanticHints.SH_ZMLCOMPONENTINTERFACEREALIZATIONSTRUCTURALREALIZATIONTEXTEDITPART, ComponentInterfacerealizationStructuralRealizationTextViewFactory.class);
        nodeMap.put(ZMLSemanticHints.SH_ZMLWORKERFUNCTIONRECEIVINGPORTMESSAGEPORTLABELEDITPART, WorkerFunctionreceivingPortMessagePortLabelViewFactory.class);
        nodeMap.put(ZMLSemanticHints.SH_ZMLWORKERFUNCTIONRECEIVINGPORTMESSAGEPORTTEXTEDITPART, WorkerFunctionreceivingPortMessagePortTextViewFactory.class);
    }
    
    /**
     * @generated
     */
    private static Map edgeMap = new HashMap();
    
    /**
     * @generated
     */
    static {
        edgeMap.put(ZMLSemanticHints.SH_ZMLSTRUCTURALREALIZATIONIMPLEMENTATIONIMPLEMENTATIONEDITPART, StructuralRealizationimplementationImplementationViewFactory.class);
        edgeMap.put(ZMLElementTypes.STRUCTURALREALIZATION_IMPLEMENTATION, StructuralRealizationimplementationImplementationViewFactory.class);
        edgeMap.put(ZMLSemanticHints.SH_ZMLCOMPONENTINTERFACEREALIZATIONSTRUCTURALREALIZATIONEDITPART, ComponentInterfacerealizationStructuralRealizationViewFactory.class);
        edgeMap.put(ZMLElementTypes.COMPONENTINTERFACE_REALIZATION, ComponentInterfacerealizationStructuralRealizationViewFactory.class);
        edgeMap.put(ZMLSemanticHints.SH_ZMLWORKERFUNCTIONRECEIVINGPORTMESSAGEPORTEDITPART, WorkerFunctionreceivingPortMessagePortViewFactory.class);
        edgeMap.put(ZMLElementTypes.WORKERFUNCTION_RECEIVINGPORT, WorkerFunctionreceivingPortMessagePortViewFactory.class);
    }

    /**
     * @generated
     */
    protected Class getNodeViewClass(IAdaptable semanticAdapter,
            View containerView, String semanticHint) {
        if (semanticHint != null && semanticHint.length() > 0) {
            return (Class)nodeMap.get(semanticHint);
        }
        IElementType elementType = (IElementType)semanticAdapter.getAdapter(IElementType.class);
        if (elementType != null) {
            return (Class)nodeMap.get(elementType);
        } else {
            EObject eObject = getSemanticElement(semanticAdapter);
            if (eObject != null) {
                // first check specialization type matches
                for (int i = 0; i < ZMLElementTypes.NODE_TYPES.length; ++i) {
                    elementType = ZMLElementTypes.NODE_TYPES[i];
                    if (elementType instanceof ISpecializationType) {
                        if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                            return (Class) nodeMap.get(elementType);
                        }
                    }
                }
                // next check metamodel type matches
                for (int i = 0; i < ZMLElementTypes.NODE_TYPES.length; ++i) {
                    elementType = ZMLElementTypes.NODE_TYPES[i];
                    if (elementType instanceof IMetamodelType) {
                        if (eObject.eClass() == elementType.getEClass()) {
                            return (Class) nodeMap.get(elementType);
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
    protected Class getEdgeViewClass(IAdaptable semanticAdapter,
            View containerView, String semanticHint) {
        if (semanticHint != null && semanticHint.length() > 0) {
            return (Class)edgeMap.get(semanticHint);
        }
        IElementType elementType = (IElementType)semanticAdapter.getAdapter(IElementType.class);
        if (elementType != null) {
            return (Class)edgeMap.get(elementType);
        } else {
            EObject eObject = getSemanticElement(semanticAdapter);
            if (eObject != null) {
                // first check specialization type matches
                for (int i = 0; i < ZMLElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                    elementType = ZMLElementTypes.RELATIONSHIP_TYPES[i];
                    if (elementType instanceof ISpecializationType) {
                        if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                            return (Class) edgeMap.get(elementType);
                        }
                    }
                }
                // next check metamodel type matches
                for (int i = 0; i < ZMLElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                    elementType = ZMLElementTypes.RELATIONSHIP_TYPES[i];
                    if (elementType instanceof IMetamodelType) {
                        if (eObject.eClass() == elementType.getEClass()) {
                            return (Class) edgeMap.get(elementType);
                        }
                    }
                }
            }
        }
        return null;       
    }

}