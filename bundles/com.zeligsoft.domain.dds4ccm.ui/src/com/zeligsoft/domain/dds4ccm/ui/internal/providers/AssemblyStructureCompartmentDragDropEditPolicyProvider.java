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
package com.zeligsoft.domain.dds4ccm.ui.internal.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ComponentCompositeEditPart;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * 
 * Edit policy provider for assembly composite structure diagram
 * 
 * @author Young-Soo Roh
 */
public class AssemblyStructureCompartmentDragDropEditPolicyProvider extends AbstractProvider
		implements IEditPolicyProvider {

	private final static String EDIT_POLICY_ROLE = "SetDefaultDropPolicy";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation) operation;

		try {
			ServicesRegistry registry = ServiceUtilsForEditPart.getInstance()
					.getServiceRegistry(epOperation.getEditPart());
			if (registry == null) {
				return false;
			}

			EditPart editPart = epOperation.getEditPart();
			if (!ComponentCompositeEditPart.class.equals(editPart.getClass())) {
				return false;
			}
			EObject eo = editPart.getAdapter(EObject.class);
			if (eo != null && (ZDLUtil.isZDLConcept(eo, CCMNames.ASSEMBLY_IMPLEMENTATION)
					|| ZDLUtil.isZDLConcept(eo, CCMNames.DOMAIN))) {
				return true;
			}
			return false;
		} catch (ServiceException e) {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createEditPolicies(EditPart editPart) {
		EditPolicy editPolicy = new AssemblyStructureCompartmentDragDropEditPolicy();
		editPart.installEditPolicy(EDIT_POLICY_ROLE, editPolicy);
	}
}
