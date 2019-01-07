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

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;

import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AllocationDependencyEditPart
        extends ConnectionNodeEditPart {

    /**
     * @generated
     */
    public AllocationDependencyEditPart(View view) {
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