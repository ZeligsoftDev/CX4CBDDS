package com.zeligsoft.domain.omg.ccm.ui.editparts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.SideAffixedNodesCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PropertyPartEditPartCN;

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
}
