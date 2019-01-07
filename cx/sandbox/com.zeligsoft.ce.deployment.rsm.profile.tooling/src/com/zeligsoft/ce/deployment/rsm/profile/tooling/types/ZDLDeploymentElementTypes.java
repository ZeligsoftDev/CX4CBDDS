
package com.zeligsoft.ce.deployment.rsm.profile.tooling.types;

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
public class ZDLDeploymentElementTypes extends AbstractElementTypeEnumerator {

    /**
     * @generated
     */
    public static final IStereotypedElementType _PORTDEPLOYMENTPART__PROPERTY = (IStereotypedElementType)getElementType("com.zeligsoft.ce.deployment.rsm.profile.tooling.PortDeploymentPartProperty"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _DEPLOYMENT__COMPONENT = (IStereotypedElementType)getElementType("com.zeligsoft.ce.deployment.rsm.profile.tooling.DeploymentComponent"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _CONNECTORDEPLOYMENTPART__PROPERTY = (IStereotypedElementType)getElementType("com.zeligsoft.ce.deployment.rsm.profile.tooling.ConnectorDeploymentPartProperty"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _DEPLOYMENTPART__PROPERTY = (IStereotypedElementType)getElementType("com.zeligsoft.ce.deployment.rsm.profile.tooling.DeploymentPartProperty"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _PARTDEPLOYMENTPART__PROPERTY = (IStereotypedElementType)getElementType("com.zeligsoft.ce.deployment.rsm.profile.tooling.PartDeploymentPartProperty"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IStereotypedElementType _ALLOCATION__ASSOCIATION = (IStereotypedElementType)getElementType("com.zeligsoft.ce.deployment.rsm.profile.tooling.AllocationAssociation"); //$NON-NLS-1$

    /**
     * @generated
     */
    public static final IElementType[] NODE_TYPES = {
            _PORTDEPLOYMENTPART__PROPERTY,
            _DEPLOYMENT__COMPONENT,
            _CONNECTORDEPLOYMENTPART__PROPERTY,
            _DEPLOYMENTPART__PROPERTY,
            _PARTDEPLOYMENTPART__PROPERTY
        };

    /**
     * @generated
     */
    public static final IElementType[] RELATIONSHIP_TYPES = {
            _ALLOCATION__ASSOCIATION
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
            sources.put(ZDLDeploymentElementTypes._ALLOCATION__ASSOCIATION, types);
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
            targets.put(ZDLDeploymentElementTypes._ALLOCATION__ASSOCIATION, types);
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