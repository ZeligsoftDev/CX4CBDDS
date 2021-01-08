/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.ui.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderedShapeEditPart;
import org.eclipse.papyrus.infra.gmfdiag.canonical.internal.provider.PapyrusCanonicalEditPolicyProvider;

import com.zeligsoft.domain.dds4ccm.ui.editpolicies.DDS4CCMCanonicalEditPolicy;

/**
 * Override Papyrus canonical edit policy to install DDS4CCM canonical edit policy.
 * This is necessary in oder to support Geometric shapes in Papyrus diagram
 */
public class DDS4CCMCanonicalEditPolicyProvider extends PapyrusCanonicalEditPolicyProvider {

	@Override
	public void createEditPolicies(EditPart editPart) {
		if (supportsCanonical(editPart)) {
			if (editPart instanceof DiagramEditPart || editPart instanceof CompartmentEditPart || editPart instanceof IBorderedShapeEditPart) {
				editPart.installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new DDS4CCMCanonicalEditPolicy());
			}
		}
	}
}
