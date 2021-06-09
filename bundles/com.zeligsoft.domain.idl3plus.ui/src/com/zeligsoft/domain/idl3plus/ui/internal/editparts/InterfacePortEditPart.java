package com.zeligsoft.domain.idl3plus.ui.internal.editparts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.parts.ResizablePortEditPart;

import com.zeligsoft.domain.idl3plus.ui.internal.editpolicies.InterfacePortDecorationEditPolicy;

/**
 * Port edit part
 * 
 * @author Young-Soo Roh
 *
 */
public class InterfacePortEditPart extends ResizablePortEditPart {

	public InterfacePortEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		// TODO Auto-generated method stub
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.DECORATION_ROLE);
		installEditPolicy(EditPolicyRoles.DECORATION_ROLE, new InterfacePortDecorationEditPolicy());
	}

}
