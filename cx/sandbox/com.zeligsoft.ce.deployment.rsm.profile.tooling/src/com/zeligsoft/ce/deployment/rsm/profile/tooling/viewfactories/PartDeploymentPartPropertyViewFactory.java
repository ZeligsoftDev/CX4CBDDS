
package com.zeligsoft.ce.deployment.rsm.profile.tooling.viewfactories;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.utils.ZDLDeploymentSemanticHints;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;

import org.eclipse.gmf.runtime.notation.DescriptionStyle;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class PartDeploymentPartPropertyViewFactory
        extends AbstractShapeViewFactory {

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
		EClass descriptionstyleEClass = NotationPackage.Literals.DESCRIPTION_STYLE;
		DescriptionStyle descriptionstyle = (DescriptionStyle)view.getStyle(descriptionstyleEClass);
		if(descriptionstyle == null) {
			descriptionstyle = (DescriptionStyle)notationEFactory.createDescriptionStyle();
			view.getStyles().add(descriptionstyle);
		}	
		EClass fillstyleEClass = NotationPackage.Literals.FILL_STYLE;
		FillStyle fillstyle = (FillStyle)view.getStyle(fillstyleEClass);
		if(fillstyle == null) {
			fillstyle = (FillStyle)notationEFactory.createFillStyle();
			view.getStyles().add(fillstyle);
		}	
		EClass linestyleEClass = NotationPackage.Literals.LINE_STYLE;
		LineStyle linestyle = (LineStyle)view.getStyle(linestyleEClass);
		if(linestyle == null) {
			linestyle = (LineStyle)notationEFactory.createLineStyle();
			view.getStyles().add(linestyle);
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
            ZDLDeploymentSemanticHints.SH_ZDLDEPLOYMENTPARTDEPLOYMENTPARTPROPERTYTEXTEDITPART,
            ViewUtil.APPEND, true, getPreferencesHint());
    }

}