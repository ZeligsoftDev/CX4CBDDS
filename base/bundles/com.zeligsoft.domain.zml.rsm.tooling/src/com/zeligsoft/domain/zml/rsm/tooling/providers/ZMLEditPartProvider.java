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

import com.zeligsoft.domain.zml.rsm.tooling.editparts.ComponentInterfacerealizationStructuralRealizationEditPart;
import com.zeligsoft.domain.zml.rsm.tooling.editparts.ComponentInterfacerealizationStructuralRealizationLabelEditPart;
import com.zeligsoft.domain.zml.rsm.tooling.editparts.ComponentInterfacerealizationStructuralRealizationTextEditPart;
import com.zeligsoft.domain.zml.rsm.tooling.editparts.StructuralRealizationimplementationImplementationEditPart;
import com.zeligsoft.domain.zml.rsm.tooling.editparts.StructuralRealizationimplementationImplementationLabelEditPart;
import com.zeligsoft.domain.zml.rsm.tooling.editparts.StructuralRealizationimplementationImplementationTextEditPart;
import com.zeligsoft.domain.zml.rsm.tooling.editparts.WorkerFunctionreceivingPortMessagePortEditPart;
import com.zeligsoft.domain.zml.rsm.tooling.editparts.WorkerFunctionreceivingPortMessagePortLabelEditPart;
import com.zeligsoft.domain.zml.rsm.tooling.editparts.WorkerFunctionreceivingPortMessagePortTextEditPart;

import com.zeligsoft.domain.zml.rsm.tooling.types.ZMLElementTypes;

import com.zeligsoft.domain.zml.rsm.tooling.utils.ZMLSemanticHints;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ZMLEditPartProvider
        extends AbstractEditPartProvider {

    /**
     * @generated
     */
    private static Map nodeMap = new HashMap();
    
    /**
     * @generated
     */
    static {
        nodeMap.put(ZMLSemanticHints.SH_ZMLSTRUCTURALREALIZATIONIMPLEMENTATIONIMPLEMENTATIONLABELEDITPART, StructuralRealizationimplementationImplementationLabelEditPart.class);
        nodeMap.put(ZMLSemanticHints.SH_ZMLSTRUCTURALREALIZATIONIMPLEMENTATIONIMPLEMENTATIONTEXTEDITPART, StructuralRealizationimplementationImplementationTextEditPart.class);
        nodeMap.put(ZMLSemanticHints.SH_ZMLCOMPONENTINTERFACEREALIZATIONSTRUCTURALREALIZATIONLABELEDITPART, ComponentInterfacerealizationStructuralRealizationLabelEditPart.class);
        nodeMap.put(ZMLSemanticHints.SH_ZMLCOMPONENTINTERFACEREALIZATIONSTRUCTURALREALIZATIONTEXTEDITPART, ComponentInterfacerealizationStructuralRealizationTextEditPart.class);
        nodeMap.put(ZMLSemanticHints.SH_ZMLWORKERFUNCTIONRECEIVINGPORTMESSAGEPORTLABELEDITPART, WorkerFunctionreceivingPortMessagePortLabelEditPart.class);
        nodeMap.put(ZMLSemanticHints.SH_ZMLWORKERFUNCTIONRECEIVINGPORTMESSAGEPORTTEXTEDITPART, WorkerFunctionreceivingPortMessagePortTextEditPart.class);
    }
    
    /**
     * @generated
     */
    private static Map edgeMap = new HashMap();
    
    /**
     * @generated
     */
    static {
        edgeMap.put(ZMLSemanticHints.SH_ZMLSTRUCTURALREALIZATIONIMPLEMENTATIONIMPLEMENTATIONEDITPART, StructuralRealizationimplementationImplementationEditPart.class);
        edgeMap.put(ZMLElementTypes.STRUCTURALREALIZATION_IMPLEMENTATION, StructuralRealizationimplementationImplementationEditPart.class);
        edgeMap.put(ZMLSemanticHints.SH_ZMLCOMPONENTINTERFACEREALIZATIONSTRUCTURALREALIZATIONEDITPART, ComponentInterfacerealizationStructuralRealizationEditPart.class);
        edgeMap.put(ZMLElementTypes.COMPONENTINTERFACE_REALIZATION, ComponentInterfacerealizationStructuralRealizationEditPart.class);
        edgeMap.put(ZMLSemanticHints.SH_ZMLWORKERFUNCTIONRECEIVINGPORTMESSAGEPORTEDITPART, WorkerFunctionreceivingPortMessagePortEditPart.class);
        edgeMap.put(ZMLElementTypes.WORKERFUNCTION_RECEIVINGPORT, WorkerFunctionreceivingPortMessagePortEditPart.class);
    }
    
    /**
     * @generated
     */
    protected Class getNodeEditPartClass(View view) {
        String type = view.getType();
        if (type != null && type.length() > 0) {
            return (Class) nodeMap.get(view.getType());
        }
        EObject eObject = view.getElement();
        if (eObject != null) {
            // first check specialization type matches
            for (int i = 0; i < ZMLElementTypes.NODE_TYPES.length; ++i) {
                IElementType elementType = ZMLElementTypes.NODE_TYPES[i];
                if (elementType instanceof ISpecializationType) {
                    if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                        return (Class) nodeMap.get(elementType);
                    }
                }
            }
            // next check metamodel type matches
            for (int i = 0; i < ZMLElementTypes.NODE_TYPES.length; ++i) {
                IElementType elementType = ZMLElementTypes.NODE_TYPES[i];
                if (elementType instanceof IMetamodelType) {
                    if (eObject.eClass() == elementType.getEClass()) {
                        return (Class) nodeMap.get(elementType);
                    }
                }
            }
        }
        return null;
    }

    /**
     * @generated
     */
    protected Class getEdgeEditPartClass(View view) {
        String type = view.getType();
        if (type != null && type.length() > 0) {
            return (Class) edgeMap.get(view.getType());
        }
        EObject eObject = view.getElement();
        if (eObject != null) {
            // first check specialization type matches
            for (int i = 0; i < ZMLElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                IElementType elementType = ZMLElementTypes.RELATIONSHIP_TYPES[i];
                if (elementType instanceof ISpecializationType) {
                    if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                        return (Class) edgeMap.get(elementType);
                    }
                }
            }
            // next check metamodel type matches
            for (int i = 0; i < ZMLElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                IElementType elementType = ZMLElementTypes.RELATIONSHIP_TYPES[i];
                if (elementType instanceof IMetamodelType) {
                    if (eObject.eClass() == elementType.getEClass()) {
                        return (Class) edgeMap.get(elementType);
                    }
                }
            }
        }
        return null;
    }
}