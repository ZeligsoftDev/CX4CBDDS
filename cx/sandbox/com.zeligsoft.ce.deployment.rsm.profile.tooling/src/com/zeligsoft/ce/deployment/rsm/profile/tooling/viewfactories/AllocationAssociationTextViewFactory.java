
package com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;

import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AllocationAssociationTextViewFactory
        extends AbstractLabelViewFactory  {

    /**
     * @generated
     */
    protected void decorateView(View containerView, View view,
            IAdaptable semanticAdapter, String semanticHint, int index,
            boolean persisted) {
        super.decorateView(containerView, view, semanticAdapter, semanticHint, index,
                persisted);
        
        LayoutConstraint layoutConstraint = ((Node) view).getLayoutConstraint();
        if (layoutConstraint instanceof Location) {
            Location location = (Location) layoutConstraint;
            location.setX(MapModeUtil.getMapMode().DPtoLP(0));
            location.setY(MapModeUtil.getMapMode().DPtoLP(-1));
        }
    }
    
}