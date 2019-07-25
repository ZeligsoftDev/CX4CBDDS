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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.xtools.uml.ui.diagrams.structure.internal.editpolicies.StructureGraphicalNodeEditPolicy;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * GraphicalNodeEditPolicy for DDS4CCM DataSpace
 * 
 * @author ysroh
 * 
 */
public class IDL3PlusGraphicalNodeEditPolicy extends
		StructureGraphicalNodeEditPolicy {

	@Override
	protected Command getConnectionAndRelationshipCompleteCommand(
			CreateConnectionViewAndElementRequest request) {

		EditPart source = request.getSourceEditPart();
		IGraphicalEditPart target = (IGraphicalEditPart) getConnectionCompleteEditPart(request);
		if ((target == null) || (source == null)) {
			return null;
		}

		EObject sourceElement = internalResolveSemanticElement(source);
		EObject targetElement = internalResolveSemanticElement(target);
		if (sourceElement == null || targetElement == null) {
			return null;
		}
		if (ZDLUtil.isZDLConcept(sourceElement, CCMNames.INTERFACE_PORT)) {
			// Only port can connect to DDS4CCM Connector
			return super.getConnectionAndRelationshipCompleteCommand(request);
		}
		return null;
	}

	@Override
	protected boolean isOkToTargetBorder(Request request) {
		return false;
	}

	@Override
	public void showTargetFeedback(Request request) {
		return;

	}

	private static EObject internalResolveSemanticElement(EditPart editPart) {

		View view = (View) editPart.getAdapter(View.class);
		if (view == null) {
			return null;
		}
		return ViewUtil.resolveSemanticElement(view);
	}
}
