
package com.zeligsoft.ce.deployment.rsm.profile.tooling.providers;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts.AllocationAssociationEditPart;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts.AllocationAssociationLabelEditPart;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts.AllocationAssociationTextEditPart;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts.ConnectorDeploymentPartPropertyEditPart;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts.ConnectorDeploymentPartPropertyTextEditPart;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts.DeploymentComponentEditPart;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts.DeploymentComponentTextEditPart;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts.DeploymentPartPropertyEditPart;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts.DeploymentPartPropertyTextEditPart;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts.PartDeploymentPartPropertyEditPart;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts.PartDeploymentPartPropertyTextEditPart;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts.PortDeploymentPartPropertyEditPart;
import com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts.PortDeploymentPartPropertyTextEditPart;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.types.ZDLDeploymentElementTypes;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.utils.ZDLDeploymentSemanticHints;

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
public class ZDLDeploymentEditPartProvider
        extends AbstractEditPartProvider {

    /**
     * @generated
     */
    private static Map nodeMap = new HashMap();
    
    /**
     * @generated
     */
    static {
        nodeMap.put(ZDLDeploymentElementTypes._PORTDEPLOYMENTPART__PROPERTY, PortDeploymentPartPropertyEditPart.class);
        nodeMap.put(ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTPORTDEPLOYMENTPARTPROPERTYTEXTEDITPART, PortDeploymentPartPropertyTextEditPart.class);
        nodeMap.put(ZDLDeploymentElementTypes._DEPLOYMENT__COMPONENT, DeploymentComponentEditPart.class);
        nodeMap.put(ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTDEPLOYMENTCOMPONENTTEXTEDITPART, DeploymentComponentTextEditPart.class);
        nodeMap.put(ZDLDeploymentElementTypes._CONNECTORDEPLOYMENTPART__PROPERTY, ConnectorDeploymentPartPropertyEditPart.class);
        nodeMap.put(ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTCONNECTORDEPLOYMENTPARTPROPERTYTEXTEDITPART, ConnectorDeploymentPartPropertyTextEditPart.class);
        nodeMap.put(ZDLDeploymentElementTypes._DEPLOYMENTPART__PROPERTY, DeploymentPartPropertyEditPart.class);
        nodeMap.put(ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTDEPLOYMENTPARTPROPERTYTEXTEDITPART, DeploymentPartPropertyTextEditPart.class);
        nodeMap.put(ZDLDeploymentElementTypes._PARTDEPLOYMENTPART__PROPERTY, PartDeploymentPartPropertyEditPart.class);
        nodeMap.put(ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTPARTDEPLOYMENTPARTPROPERTYTEXTEDITPART, PartDeploymentPartPropertyTextEditPart.class);
        nodeMap.put(ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTALLOCATIONASSOCIATIONLABELEDITPART, AllocationAssociationLabelEditPart.class);
        nodeMap.put(ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTALLOCATIONASSOCIATIONTEXTEDITPART, AllocationAssociationTextEditPart.class);
    }
    
    /**
     * @generated
     */
    private static Map edgeMap = new HashMap();
    
    /**
     * @generated
     */
    static {
        edgeMap.put(ZDLDeploymentElementTypes._ALLOCATION__ASSOCIATION, AllocationAssociationEditPart.class);
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
            for (int i = 0; i < ZDLDeploymentElementTypes.NODE_TYPES.length; ++i) {
                IElementType elementType = ZDLDeploymentElementTypes.NODE_TYPES[i];
                if (elementType instanceof ISpecializationType) {
                    if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                        return (Class) nodeMap.get(elementType);
                    }
                }
            }
            // next check metamodel type matches
            for (int i = 0; i < ZDLDeploymentElementTypes.NODE_TYPES.length; ++i) {
                IElementType elementType = ZDLDeploymentElementTypes.NODE_TYPES[i];
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
            for (int i = 0; i < ZDLDeploymentElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                IElementType elementType = ZDLDeploymentElementTypes.RELATIONSHIP_TYPES[i];
                if (elementType instanceof ISpecializationType) {
                    if (((ISpecializationType)elementType).getMatcher().matches(eObject)) {
                        return (Class) edgeMap.get(elementType);
                    }
                }
            }
            // next check metamodel type matches
            for (int i = 0; i < ZDLDeploymentElementTypes.RELATIONSHIP_TYPES.length; ++i) {
                IElementType elementType = ZDLDeploymentElementTypes.RELATIONSHIP_TYPES[i];
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