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
package com.zeligsoft.domain.zml.rsm.tooling.edithelpers;

import com.ibm.xtools.uml.type.EditRequestParameters;

import com.zeligsoft.domain.zml.rsm.tooling.types.ZMLElementTypes;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.common.core.command.ICommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * @generated
 */
public class AssemblyConnectorConnectorEditHelperAdvice extends
        ZMLBaseEditHelperAdvice {
    
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
        Stereotype stereotype = element.getAppliedStereotype(ZMLElementTypes._ASSEMBLYCONNECTOR__CONNECTOR.getStereotypeName());
        EObject stereotypeApp = element.getStereotypeApplication(stereotype);
        return super.getLocalizedName(stereotypeApp) + super.getLocalizedName(eObject);
    }
}
