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
package com.zeligsoft.base.deployment.rsm.tooling.providers;

import com.zeligsoft.base.deployment.rsm.tooling.editparts.AllocationDependencyEditPart;
import com.zeligsoft.base.deployment.rsm.tooling.editparts.AllocationDependencyLabelEditPart;
import com.zeligsoft.base.deployment.rsm.tooling.editparts.AllocationDependencyTextEditPart;
import com.zeligsoft.base.deployment.rsm.tooling.editparts.ComponentDeploymentPartPropertyEditPart;
import com.zeligsoft.base.deployment.rsm.tooling.editparts.ComponentDeploymentPartPropertyTextEditPart;
import com.zeligsoft.base.deployment.rsm.tooling.editparts.DeploymentPartPropertyEditPart;
import com.zeligsoft.base.deployment.rsm.tooling.editparts.DeploymentPartPropertyTextEditPart;

import com.zeligsoft.base.deployment.rsm.tooling.types.ZeligsoftDeploymentElementTypes;

import com.zeligsoft.base.deployment.rsm.tooling.utils.ZeligsoftDeploymentSemanticHints;

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
public class ZeligsoftDeploymentEditPartProvider
        extends AbstractEditPartProvider {

    /**
     * @generated
     */
    private static Map nodeMap = new HashMap();
    
    /**
     * @generated
     */
    static {
        nodeMap.put(ZeligsoftDeploymentElementTypes._DEPLOYMENTPART__PROPERTY, DeploymentPartPropertyEditPart.class);
        nodeMap.put(ZeligsoftDeploymentSemanticHints.SH_ZELIGSOFTDEPLOYMENTDEPLOYMENTPARTPROPERTYTEXTEDITPART, DeploymentPartPropertyTextEditPart.class);
        nodeMap.put(ZeligsoftDeploymentSemanticHints.SH_ZELIGSOFTDEPLOYMENTALLOCATIONDEPENDENCYLABELEDITPART, AllocationDependencyLabelEditPart.class);
        nodeMap.put(ZeligsoftDeploymentSemanticHints.SH_ZELIGSOFTDEPLOYMENTALLOCATIONDEPENDENCYTEXTEDITPART, AllocationDependencyTextEditPart.class);
        nodeMap.put(ZeligsoftDeploymentElementTypes._DEPLOYMENTPART__PROPERTY, ComponentDeploymentPartPropertyEditPart.class);
        nodeMap.put(ZeligsoftDeploymentSemanticHints.SH_ZELIGSOFTDEPLOYMENTCOMPONENTDEPLOYMENTPARTPROPERTYTEXTEDITPART, ComponentDeploymentPartPropertyTextEditPart.class);
    }
    
    /**
     * @generated
     */
    private static Map edgeMap = new HashMap();
    
    /**
     * @generated
     */
    static {
        edgeMap.put(ZeligsoftDeploymentElementTypes._ALLOCATION__DEPENDENCY, AllocationDependencyEditPart.class);
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
            for (int i = 0; i < ZeligsoftDeploymentElementTypes.NODE_TYPES.length; ++i) {
                IElementType elementType = ZeligsoftDeploymentElementTypes.NODE_TYPES[i];
                if (elementType instanceof ISpecializationType) {
                    if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                        return (Class) nodeMap.get(elementType);
                    }
                }
            }
            // next check metamodel type matches
            for (int i = 0; i < ZeligsoftDeploymentElementTypes.NODE_TYPES.length; ++i) {
                IElementType elementType = ZeligsoftDeploymentElementTypes.NODE_TYPES[i];
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
            for (int i = 0; i < ZeligsoftDeploymentElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                IElementType elementType = ZeligsoftDeploymentElementTypes.RELATIONSHIP_TYPES[i];
                if (elementType instanceof ISpecializationType) {
                    if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                        return (Class) edgeMap.get(elementType);
                    }
                }
            }
            // next check metamodel type matches
            for (int i = 0; i < ZeligsoftDeploymentElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                IElementType elementType = ZeligsoftDeploymentElementTypes.RELATIONSHIP_TYPES[i];
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