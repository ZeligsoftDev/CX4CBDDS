
package com.zeligsoft.ce.deployment.rsm.profile.tooling.types;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;

import org.eclipse.uml2.uml.Element;

/**
 * @generated
 */
public class DeploymentComponentMatcher
        implements IElementMatcher {
    
    /**
     * @generated
     */
    public boolean matches(EObject eObject) {
        return ZDLDeploymentElementTypes._DEPLOYMENT__COMPONENT.getEClass() == eObject.eClass() &&
                ((Element)eObject).getAppliedStereotype(ZDLDeploymentElementTypes._DEPLOYMENT__COMPONENT.getStereotypeName()) != null;
    }
}