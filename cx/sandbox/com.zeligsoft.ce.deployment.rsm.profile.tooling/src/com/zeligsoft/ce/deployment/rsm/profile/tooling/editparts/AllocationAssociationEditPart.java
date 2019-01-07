
package com.zeligsoft.ce.deployment.rsm.profile.tooling.editparts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;

import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AllocationAssociationEditPart
        extends ConnectionNodeEditPart {

    /**
     * @generated
     */
    public AllocationAssociationEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected Connection createConnectionFigure() {
        PolylineConnectionEx connection = new PolylineConnectionEx();
        PolylineDecoration targetDecoration = new PolylineDecoration();
        IMapMode mm = getMapMode();
        targetDecoration.setScale(mm.DPtoLP(10),mm.DPtoLP(5));
        connection.setTargetDecoration(targetDecoration);
        return connection;
    }
}