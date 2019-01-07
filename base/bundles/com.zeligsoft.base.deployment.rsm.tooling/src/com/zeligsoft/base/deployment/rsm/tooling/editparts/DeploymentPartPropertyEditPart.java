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

import com.zeligsoft.base.deployment.rsm.tooling.figures.DeploymentPartPropertyFigure;

import org.eclipse.draw2d.StackLayout;

import org.eclipse.gef.EditPart;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;

import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;

import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class DeploymentPartPropertyEditPart
        extends ShapeNodeEditPart {
    
    private DeploymentPartPropertyFigure mainFigure = null;

    /**
     * @generated
     */
    public DeploymentPartPropertyEditPart(View view) {
        super(view);
    }

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model
     * so you may safely remove <i>generated</i> tag and modify it.
     * 
     * @generated
     */
    protected NodeFigure createNodeFigure() {
        NodeFigure figure = new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode()
            .DPtoLP(40));
        figure.setLayoutManager(new StackLayout());
        mainFigure = new DeploymentPartPropertyFigure();

        ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
        layout.setSpacing(getMapMode().DPtoLP(5));
        mainFigure.setLayoutManager(layout);
        
        figure.add(mainFigure);
        return figure;
    }

    /**
     * @generated
     */
    protected void addChildVisual(EditPart child, int index) {
        if (child instanceof DeploymentPartPropertyTextEditPart) {
            ((DeploymentPartPropertyTextEditPart) child).setFigure(mainFigure.getNameFigure());
        } else {
            super.addChildVisual(child, index);
        }
    }

}