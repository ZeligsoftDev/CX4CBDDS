
package com.zeligsoft.ce.deployment.rsm.profile.tooling.figures;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.l10n.ZDLDeploymentMessages;

import org.eclipse.draw2d.RectangleFigure;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;

/**
 * @generated
 */
public class DeploymentPartPropertyFigure
        extends RectangleFigure {
    
    /**
     * @generated
     */
    private WrapLabel mainFigure, nameFigure;
    
    /**
     * @generated
     */
    public DeploymentPartPropertyFigure() {
        createContents();
    }

    /**
     * @generated
     */
    private void createContents() {
        mainFigure = new WrapLabel();
        mainFigure.setText(ZDLDeploymentMessages.DeploymentPartPropertyFigure_text);
        this.add(mainFigure, null);

        nameFigure = new WrapLabel();
        this.add(nameFigure, null);
    }

    /**
     * @generated
     */
    public WrapLabel getMainFigure() {
        return mainFigure;
    }

    /**
     * @generated
     */
    public WrapLabel getNameFigure() {
        return nameFigure;
    }

}