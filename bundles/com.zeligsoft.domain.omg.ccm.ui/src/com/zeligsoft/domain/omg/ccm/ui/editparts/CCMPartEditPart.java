/*******************************************************************************
 * Copyright (c) 2022 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/

package com.zeligsoft.domain.omg.ccm.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.SideAffixedNodesCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PropertyPartEditPartCN;

/**
 * CCM edit part to implement workarounds
 * 
 * @author Young-Soo Roh
 *
 */
public class CCMPartEditPart extends PropertyPartEditPartCN {

	public CCMPartEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CREATION_ROLE);
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new SideAffixedNodesCreationEditPolicy());
	}

	@Override
	protected IFigure createNodeShape() {
		primaryShape = new CCMPropertyPartFigure();
		return primaryShape;
	}

}
