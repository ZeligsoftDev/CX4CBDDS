
package com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.figures.DeploymentPartPropertyFigure;

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