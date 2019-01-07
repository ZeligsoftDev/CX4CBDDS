
package com.zeligsoft.ce.deployment.rsm.profile.tooling.edithelpers;

import com.ibm.xtools.uml.type.EditRequestParameters;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.types.ZDLDeploymentElementTypes;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.common.core.command.ICommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * @generated
 */
public class DeploymentComponentEditHelperAdvice extends
        ZDLDeploymentBaseEditHelperAdvice {
    
    /**
     * @generated
     */
    protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {
        final String stereotypeName = (String) request
            .getParameter(EditRequestParameters.APPLIED_STEREOTYPE_PARAM_NAME);
        if (stereotypeName != null) {
            final EObject eObject = request.getElementToConfigure();
            if (eObject instanceof Element && 
                    ((Element)eObject).getAppliedStereotype(stereotypeName) != null) {
                request.setParameter(
                    EditRequestParameters.APPLIED_STEREOTYPE_PARAM_NAME, null);
            }
        }
        return super.getBeforeConfigureCommand(request);
    }
    
    /**
     * @generated
     */
    protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {
        final String stereotypeName = (String) request
            .getParameter(EditRequestParameters.APPLIED_STEREOTYPE_PARAM_NAME);
        if (stereotypeName != null) {
            final EObject eObject = request.getElementToConfigure();
            if (eObject instanceof Element && 
                    ((Element)eObject).getAppliedStereotype(stereotypeName) != null) {
                request.setParameter(
                    EditRequestParameters.APPLIED_STEREOTYPE_PARAM_NAME, null);
            }
        }
        return super.getAfterConfigureCommand(request);
    }

    /**
     * @generated
     */
    protected String getLocalizedName(EObject eObject) {
        Element element = (Element)eObject;
        Stereotype stereotype = element.getAppliedStereotype(ZDLDeploymentElementTypes._DEPLOYMENT__COMPONENT.getStereotypeName());
        EObject stereotypeApp = element.getStereotypeApplication(stereotype);
        return super.getLocalizedName(stereotypeApp) + super.getLocalizedName(eObject);
    }
}
