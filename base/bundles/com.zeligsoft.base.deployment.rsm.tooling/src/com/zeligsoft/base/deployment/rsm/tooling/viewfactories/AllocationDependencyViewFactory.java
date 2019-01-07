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
package com.zeligsoft.base.deployment.rsm.tooling.viewfactories;

import com.zeligsoft.base.deployment.rsm.tooling.utils.ZeligsoftDeploymentSemanticHints;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;

import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AllocationDependencyViewFactory
        extends ConnectionViewFactory {

    /**
     * @generated 
     */
    protected void applyStyles(View view) {
		NotationFactory notationEFactory = NotationFactory.eINSTANCE;
			
		EClass fontstyleEClass = NotationPackage.Literals.FONT_STYLE;
		FontStyle fontstyle = (FontStyle)view.getStyle(fontstyleEClass);
		if(fontstyle == null) {
			fontstyle = (FontStyle)notationEFactory.createFontStyle();
			view.getStyles().add(fontstyle);
		}	
		EClass linestyleEClass = NotationPackage.Literals.LINE_STYLE;
		LineStyle linestyle = (LineStyle)view.getStyle(linestyleEClass);
		if(linestyle == null) {
			linestyle = (LineStyle)notationEFactory.createLineStyle();
			view.getStyles().add(linestyle);
		}	
		EClass routingstyleEClass = NotationPackage.Literals.ROUTING_STYLE;
		RoutingStyle routingstyle = (RoutingStyle)view.getStyle(routingstyleEClass);
		if(routingstyle == null) {
			routingstyle = (RoutingStyle)notationEFactory.createRoutingStyle();
			view.getStyles().add(routingstyle);
		}	
    }

    /**
     * @generated
     */
    protected void decorateView(View containerView, View view,
            IAdaptable semanticAdapter, String semanticHint, int index,
            boolean persisted) {
        super.decorateView(containerView, view, semanticAdapter, semanticHint,
            index, persisted);
        applyStyles(view);

        getViewService().createNode(semanticAdapter, view,
            ZeligsoftDeploymentSemanticHints.SH_ZELIGSOFTDEPLOYMENTALLOCATIONDEPENDENCYLABELEDITPART,
            ViewUtil.APPEND, true, getPreferencesHint());
    }

}