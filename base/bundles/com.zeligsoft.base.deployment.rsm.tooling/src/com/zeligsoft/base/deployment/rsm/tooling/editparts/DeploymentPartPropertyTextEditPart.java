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
package com.zeligsoft.base.deployment.rsm.tooling.editparts;

import com.zeligsoft.base.deployment.rsm.tooling.l10n.ZeligsoftDeploymentMessages;

import org.eclipse.draw2d.IFigure;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;

import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.uml2.uml.NamedElement;

/**
 * @generated
 */
public class DeploymentPartPropertyTextEditPart
        extends TextCompartmentEditPart {

    /**
     * @generated
     */
    public DeploymentPartPropertyTextEditPart(View view) {
        super(view);
    }
    
    /**
     * @generated
     */
    protected String getLabelText() {
        assert getModel() instanceof View;
        EObject eObj = (((View) getModel()).getElement());
        if (eObj instanceof NamedElement) {
            return ((NamedElement) eObj).getName();
        }
        return ZeligsoftDeploymentMessages.UnnamedElement;
    }
    
    /**
     * @generated
     */
    public void setFigure(IFigure figure) {
        super.setFigure(figure);
    }
}