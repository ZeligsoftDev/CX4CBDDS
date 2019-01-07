
package com.zeligsoft.ce.deployment.rsm.profile.tooling.providers;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.types.ZDLDeploymentElementTypes;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.utils.ZDLDeploymentSemanticHints;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories.AllocationAssociationLabelViewFactory;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories.AllocationAssociationTextViewFactory;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories.AllocationAssociationViewFactory;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories.ConnectorDeploymentPartPropertyTextViewFactory;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories.ConnectorDeploymentPartPropertyViewFactory;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories.DeploymentComponentTextViewFactory;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories.DeploymentComponentViewFactory;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories.DeploymentPartPropertyTextViewFactory;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories.DeploymentPartPropertyViewFactory;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories.PartDeploymentPartPropertyTextViewFactory;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories.PartDeploymentPartPropertyViewFactory;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories.PortDeploymentPartPropertyTextViewFactory;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories.PortDeploymentPartPropertyViewFactory;

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
public class ZDLDeploymentViewProvider
        extends AbstractViewProvider {
    
    /**
     * @generated
     */
    private static Map nodeMap = new HashMap();
    
    /**
     * @generated
     */
    static {
        nodeMap.put(ZDLDeploymentElementTypes._PORTDEPLOYMENTPART__PROPERTY, PortDeploymentPartPropertyViewFactory.class);
        nodeMap.put(ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTPORTDEPLOYMENTPARTPROPERTYTEXTEDITPART, PortDeploymentPartPropertyTextViewFactory.class);
        nodeMap.put(ZDLDeploymentElementTypes._DEPLOYMENT__COMPONENT, DeploymentComponentViewFactory.class);
        nodeMap.put(ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTDEPLOYMENTCOMPONENTTEXTEDITPART, DeploymentComponentTextViewFactory.class);
        nodeMap.put(ZDLDeploymentElementTypes._CONNECTORDEPLOYMENTPART__PROPERTY, ConnectorDeploymentPartPropertyViewFactory.class);
        nodeMap.put(ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTCONNECTORDEPLOYMENTPARTPROPERTYTEXTEDITPART, ConnectorDeploymentPartPropertyTextViewFactory.class);
        nodeMap.put(ZDLDeploymentElementTypes._DEPLOYMENTPART__PROPERTY, DeploymentPartPropertyViewFactory.class);
        nodeMap.put(ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTDEPLOYMENTPARTPROPERTYTEXTEDITPART, DeploymentPartPropertyTextViewFactory.class);
        nodeMap.put(ZDLDeploymentElementTypes._PARTDEPLOYMENTPART__PROPERTY, PartDeploymentPartPropertyViewFactory.class);
        nodeMap.put(ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTPARTDEPLOYMENTPARTPROPERTYTEXTEDITPART, PartDeploymentPartPropertyTextViewFactory.class);
        nodeMap.put(ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTALLOCATIONASSOCIATIONLABELEDITPART, AllocationAssociationLabelViewFactory.class);
        nodeMap.put(ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTALLOCATIONASSOCIATIONTEXTEDITPART, AllocationAssociationTextViewFactory.class);
    }
    
    /**
     * @generated
     */
    private static Map edgeMap = new HashMap();
    
    /**
     * @generated
     */
    static {
        edgeMap.put(ZDLDeploymentElementTypes._ALLOCATION__ASSOCIATION, AllocationAssociationViewFactory.class);
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
                for (int i = 0; i < ZDLDeploymentElementTypes.NODE_TYPES.length; ++i) {
                    elementType = ZDLDeploymentElementTypes.NODE_TYPES[i];
                    if (elementType instanceof ISpecializationType) {
                        if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                            return (Class) nodeMap.get(elementType);
                        }
                    }
                }
                // next check metamodel type matches
                for (int i = 0; i < ZDLDeploymentElementTypes.NODE_TYPES.length; ++i) {
                    elementType = ZDLDeploymentElementTypes.NODE_TYPES[i];
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
                for (int i = 0; i < ZDLDeploymentElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                    elementType = ZDLDeploymentElementTypes.RELATIONSHIP_TYPES[i];
                    if (elementType instanceof ISpecializationType) {
                        if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                            return (Class) edgeMap.get(elementType);
                        }
                    }
                }
                // next check metamodel type matches
                for (int i = 0; i < ZDLDeploymentElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                    elementType = ZDLDeploymentElementTypes.RELATIONSHIP_TYPES[i];
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