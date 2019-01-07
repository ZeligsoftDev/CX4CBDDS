
package com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.figures.ConnectorDeploymentPartPropertyFigure;

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
public class ConnectorDeploymentPartPropertyEditPart
        extends ShapeNodeEditPart {
    
    private ConnectorDeploymentPartPropertyFigure mainFigure = null;

    /**
     * @generated
     */
    public ConnectorDeploymentPartPropertyEditPart(View view) {
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
        mainFigure = new ConnectorDeploymentPartPropertyFigure();

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
        if (child instanceof ConnectorDeploymentPartPropertyTextEditPart) {
            ((ConnectorDeploymentPartPropertyTextEditPart) child).setFigure(mainFigure.getNameFigure());
        } else {
            super.addChildVisual(child, index);
        }
    }

}