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

import com.zeligsoft.base.deployment.rsm.tooling.types.ZeligsoftDeploymentElementTypes;

import com.zeligsoft.base.deployment.rsm.tooling.utils.ZeligsoftDeploymentSemanticHints;

import com.zeligsoft.base.deployment.rsm.tooling.viewfactories.AllocationDependencyLabelViewFactory;
import com.zeligsoft.base.deployment.rsm.tooling.viewfactories.AllocationDependencyTextViewFactory;
import com.zeligsoft.base.deployment.rsm.tooling.viewfactories.AllocationDependencyViewFactory;
import com.zeligsoft.base.deployment.rsm.tooling.viewfactories.ComponentDeploymentPartPropertyTextViewFactory;
import com.zeligsoft.base.deployment.rsm.tooling.viewfactories.DeploymentPartPropertyTextViewFactory;
import com.zeligsoft.base.deployment.rsm.tooling.viewfactories.DeploymentPartPropertyViewFactory;

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
public class ZeligsoftDeploymentViewProvider
        extends AbstractViewProvider {
    
    /**
     * @generated
     */
    private static Map nodeMap = new HashMap();
    
    /**
     * @generated
     */
    static {
        nodeMap.put(ZeligsoftDeploymentElementTypes._DEPLOYMENTPART__PROPERTY, DeploymentPartPropertyViewFactory.class);
        nodeMap.put(ZeligsoftDeploymentSemanticHints.SH_ZELIGSOFTDEPLOYMENTDEPLOYMENTPARTPROPERTYTEXTEDITPART, DeploymentPartPropertyTextViewFactory.class);
        nodeMap.put(ZeligsoftDeploymentSemanticHints.SH_ZELIGSOFTDEPLOYMENTALLOCATIONDEPENDENCYLABELEDITPART, AllocationDependencyLabelViewFactory.class);
        nodeMap.put(ZeligsoftDeploymentSemanticHints.SH_ZELIGSOFTDEPLOYMENTALLOCATIONDEPENDENCYTEXTEDITPART, AllocationDependencyTextViewFactory.class);
        nodeMap.put(ZeligsoftDeploymentElementTypes._DEPLOYMENTPART__PROPERTY, DeploymentPartPropertyViewFactory.class);
        nodeMap.put(ZeligsoftDeploymentSemanticHints.SH_ZELIGSOFTDEPLOYMENTCOMPONENTDEPLOYMENTPARTPROPERTYTEXTEDITPART, ComponentDeploymentPartPropertyTextViewFactory.class);
    }
    
    /**
     * @generated
     */
    private static Map edgeMap = new HashMap();
    
    /**
     * @generated
     */
    static {
        edgeMap.put(ZeligsoftDeploymentElementTypes._ALLOCATION__DEPENDENCY, AllocationDependencyViewFactory.class);
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
                for (int i = 0; i < ZeligsoftDeploymentElementTypes.NODE_TYPES.length; ++i) {
                    elementType = ZeligsoftDeploymentElementTypes.NODE_TYPES[i];
                    if (elementType instanceof ISpecializationType) {
                        if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                            return (Class) nodeMap.get(elementType);
                        }
                    }
                }
                // next check metamodel type matches
                for (int i = 0; i < ZeligsoftDeploymentElementTypes.NODE_TYPES.length; ++i) {
                    elementType = ZeligsoftDeploymentElementTypes.NODE_TYPES[i];
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
                for (int i = 0; i < ZeligsoftDeploymentElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                    elementType = ZeligsoftDeploymentElementTypes.RELATIONSHIP_TYPES[i];
                    if (elementType instanceof ISpecializationType) {
                        if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                            return (Class) edgeMap.get(elementType);
                        }
                    }
                }
                // next check metamodel type matches
                for (int i = 0; i < ZeligsoftDeploymentElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                    elementType = ZeligsoftDeploymentElementTypes.RELATIONSHIP_TYPES[i];
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