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
package com.zeligsoft.domain.idl3plus.ui.internal.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.RoundedRectangleNodePlateFigure;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AffixedNodeAlignmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.QualifiedNameDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideRelatedContentsEditPolicy;
import org.eclipse.papyrus.uml.diagram.composite.custom.figures.PropertyPartFigure;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PropertyPartEditPartCN;

/**
 * DDS4CCM DataSpace edit part
 * 
 * @author ysroh
 * 
 */
public class ConnectorPartEditPart extends PropertyPartEditPartCN {

	public ConnectorPartEditPart(View view) {
		super(view);

	}

	@Override
	public PropertyPartFigure getPrimaryShape() {
		return (PropertyPartFigure) primaryShape;
	}

	@Override
	protected IFigure createNodeShape() {
		primaryShape = new ConnectorPartCustomFigure();
		primaryShape.setToolTip(new Label(EMFCoreUtil.getName(resolveSemanticElement())));
		return primaryShape;
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(QualifiedNameDisplayEditPolicy.QUALIFIED_NAME_POLICY);
		removeEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY);
		removeEditPolicy(ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY);
		removeEditPolicy(AffixedNodeAlignmentEditPolicy.AFFIXED_CHILD_ALIGNMENT_ROLE);
		removeEditPolicy(ShowHideRelatedContentsEditPolicy.SHOW_HIDE_RELATED_CONTENTS_POLICY);
		removeEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		removeEditPolicy(EditPolicyRoles.CREATION_ROLE);

	}

	@Override
	protected NodeFigure createNodePlate() {
		RoundedRectangleNodePlateFigure result = new RoundedRectangleNodePlateFigure(5, 5);
		return result;
	}

	@Override
	public EditPolicy getPrimaryDragEditPolicy() {
		return new NonResizableEditPolicyEx();
	}

	@Override
	protected void refreshChildren() {
		return;
	}
}
