
package com.zeligsoft.ce.deployment.rsm.profile.tooling.types;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;

import org.eclipse.uml2.uml.Element;

/**
 * @generated
 */
public class AllocationAssociationMatcher
        implements IElementMatcher {
    
    /**
     * @generated
     */
    public boolean matches(EObject eObject) {
        return  ZDLDeploymentElementTypes._ALLOCATION__ASSOCIATION.getEClass() == eObject.eClass() &&
                ((Element)eObject).getAppliedStereotype(ZDLDeploymentElementTypes._ALLOCATION__ASSOCIATION.getStereotypeName()) != null;
    }
}