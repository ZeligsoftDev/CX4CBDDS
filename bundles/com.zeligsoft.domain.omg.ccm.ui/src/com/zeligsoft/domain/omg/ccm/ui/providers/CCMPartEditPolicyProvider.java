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

package com.zeligsoft.domain.omg.ccm.ui.providers;

import java.util.Collection;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * PartEditPolicyProvider adds double click functionality for a part
 * which will switch focus to associated AssemblyImplementations structure
 * diagram
 *  
 * @author mtate
 */

public class CCMPartEditPolicyProvider
		extends AbstractProvider
		implements IEditPolicyProvider {

	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(EditPolicyRoles.OPEN_ROLE, new CCMPartEditPolicy());
	}

	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation) {
			CreateEditPoliciesOperation op = (CreateEditPoliciesOperation) operation;
			Object o = op.getEditPart();
			if (o instanceof GraphicalEditPart && o instanceof IPrimaryEditPart) {
				Element element = (Element) ((GraphicalEditPart) o)
					.getAdapter(Element.class);
				if (element != null) {
					Collection<Profile> profiles = ZDLUtil.getZDLProfiles(element);
					if (!profiles.isEmpty()) {
						return ZDLUtil.isZDLConcept(element,
							CCMNames.CCMPART);
					}
				}
			}
		}
		return false;
	}
}