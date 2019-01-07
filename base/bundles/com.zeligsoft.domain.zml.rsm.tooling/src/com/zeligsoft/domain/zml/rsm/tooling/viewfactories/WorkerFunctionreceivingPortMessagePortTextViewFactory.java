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
package com.zeligsoft.domain.zml.rsm.tooling.viewfactories;

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
public class WorkerFunctionreceivingPortMessagePortTextViewFactory
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