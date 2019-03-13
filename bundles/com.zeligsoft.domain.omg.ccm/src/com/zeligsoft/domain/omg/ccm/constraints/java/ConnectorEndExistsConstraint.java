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
package com.zeligsoft.domain.omg.ccm.constraints.java;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Verifies if assembly contains connector end.
 * 
 * @author parmvirs
 * 
 */
public class ConnectorEndExistsConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();

		if (ZDLUtil.isZDLConcept(objToVerify, CCMNames.CCMCONNECTOR)) {
			@SuppressWarnings("unchecked")
			List<EObject> ends = (List<EObject>) ZDLUtil.getValue(objToVerify,
					ZMLMMNames.ASSEMBLY_CONNECTOR,
					ZMLMMNames.ASSEMBLY_CONNECTOR__END);
			EObject connectorContainer = objToVerify.eContainer();
			if (ends.size() == 2
					&& ZDLUtil.isZDLConcept(connectorContainer,
							CCMNames.ASSEMBLY_IMPLEMENTATION)) {
				@SuppressWarnings("unchecked")
				List<EObject> ownedParts = (List<EObject>) ZDLUtil.getValue(
						connectorContainer, ZMLMMNames.STRUCTURAL_REALIZATION,
						ZMLMMNames.STRUCTURAL_REALIZATION__PART);
				for (EObject end : ends) {
					EObject part = (EObject) ZDLUtil.getValue(end,
							ZMLMMNames.CONNECTOR_END,
							ZMLMMNames.CONNECTOR_END__PART_WITH_PORT);
					if (part != null && !ownedParts.contains(part)) {
						return ctx.createFailureStatus();
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
