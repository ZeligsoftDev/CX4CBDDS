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
package com.zeligsoft.domain.idl3plus.ui.providers;

import java.util.Collection;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;

import com.ibm.xtools.uml.ui.diagrams.structure.internal.editparts.StructureCompartmentEditPart;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.providers.StructureEditPolicy;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.ui.internal.editparts.IDL3PlusStructureDropEditPolicy;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * EditPolicyProvider which removes the EditPolicy registered against the
 * <code>EditPolicyRoles.OPEN_ROLE</code> for all components in the DDS4CCM
 * domain.
 * 
 * @author ysroh
 * 
 */
public class IDL3PlusStructureEditPolicyProvider extends StructureEditPolicy {

	public static final String DROP_ROLE_KEY = "DragDropPolicy"; //$NON-NLS-1$

	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation) {
			CreateEditPoliciesOperation op = (CreateEditPoliciesOperation) operation;
			Object o = op.getEditPart();
			if (System.getProperty("os.name").startsWith("Linux") //$NON-NLS-1$ //$NON-NLS-2$
					&& o instanceof StructureCompartmentEditPart) {
				((StructureCompartmentEditPart) o)
						.removeEditPolicy(DROP_ROLE_KEY);
				((StructureCompartmentEditPart) o).installEditPolicy(
						DROP_ROLE_KEY, new IDL3PlusStructureDropEditPolicy());
			}
			if (o != null && o instanceof GraphicalEditPart
					&& o instanceof IPrimaryEditPart) {

				Element element = (Element) ((GraphicalEditPart) o)
						.getAdapter(Element.class);
				if (element == null) {
					return false;
				}
				Collection<Profile> profiles = ZDLUtil.getZDLProfiles(element);
				if (!profiles.isEmpty()) {
					return ZDLUtil.isZDLConcept(element,
							CCMNames.MONOLITHIC_IMPLEMENTATION)
							|| ZDLUtil.isZDLConcept(element,
									IDL3PlusNames.CONNECTOR_IMPLEMENTATION)
							|| ZDLUtil.isZDLConcept(element,
									IDL3PlusNames.FRAGMENT_IMPLEMENTATION);
				}
			}
		}
		return false;
	}

}
