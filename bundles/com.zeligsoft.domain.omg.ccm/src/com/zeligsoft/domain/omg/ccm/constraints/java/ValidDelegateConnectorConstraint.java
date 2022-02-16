/**
 * Copyright 2022 Northrop Grumman Systems Corporation.
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
import org.eclipse.uml2.uml.ConnectorEnd;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Validate delegate connector ends are valid
 * 
 * @author Young-soo Roh
 *
 */
public class ValidDelegateConnectorConstraint extends AbstractModelConstraint {

	public ValidDelegateConnectorConstraint() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();

		if (ZDLUtil.isZDLConcept(objToVerify, CCMNames.CCMCONNECTOR)) {
			List<ConnectorEnd> ends = (List<ConnectorEnd>) ZDLUtil.getValue(objToVerify, ZMLMMNames.ASSEMBLY_CONNECTOR,
					ZMLMMNames.ASSEMBLY_CONNECTOR__END);
			EObject connectorContainer = objToVerify.eContainer();
			if (ends.size() == 2 && ZDLUtil.isZDLConcept(connectorContainer, CCMNames.ASSEMBLY_IMPLEMENTATION)) {
				EObject port1 = ends.get(0).getRole();
				EObject port2 = ends.get(1).getRole();
				if (port1 != null && ZDLUtil.isZDLConcept(port1, CCMNames.INTERFACE_PORT) && port2 != null
						&& ZDLUtil.isZDLConcept(port2, CCMNames.INTERFACE_PORT)) {
					boolean port1IsExternal = (Boolean) ZDLUtil.getValue(port1, ZMLMMNames.PORT,
							ZMLMMNames.PORT__IS_EXTERNAL);
					boolean port2IsExternal = (Boolean) ZDLUtil.getValue(port2, ZMLMMNames.PORT,
							ZMLMMNames.PORT__IS_EXTERNAL);
					if (port1IsExternal || port2IsExternal) {
						boolean port1IsAsync = (Boolean) ZDLUtil.getValue(port1, CCMNames.INTERFACE_PORT,
								CCMNames.INTERFACE_PORT__IS_ASYNCHRONOUS);
						boolean port2IsAsync = (Boolean) ZDLUtil.getValue(port2, CCMNames.INTERFACE_PORT,
								CCMNames.INTERFACE_PORT__IS_ASYNCHRONOUS);
						if (port1IsAsync != port2IsAsync) {
							return ctx.createFailureStatus(CCMNames.INTERFACE_PORT__IS_ASYNCHRONOUS);
						}
					}
				}
			}
		}

		return ctx.createSuccessStatus();
	}
}
