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
package com.zeligsoft.domain.idl3plus.constraints.java;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * No connection is allowed from a dataSapce to an external port
 * 
 * @author ysroh
 * 
 */
public class ConnectorNoDelegationConstraint extends AbstractModelConstraint {

	/**
	 * Public constructor.
	 */
	public ConnectorNoDelegationConstraint() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject objToVerify = ctx.getTarget();

		if (ZDLUtil.isZDLConcept(objToVerify, CCMNames.CCMCONNECTOR)) {

			final Connector connector = (Connector) objToVerify;
			Port ddsPort = null;
			Property dataSpace = null;
			Property part = null;
			for (ConnectorEnd end : connector.getEnds()) {
				EObject role = end.getRole();
				if (ZDLUtil.isZDLConcept(role, IDL3PlusNames.DATA_SPACE)) {
					dataSpace = (Property) role;
				} else if (ZDLUtil.isZDLConcept(role, CCMNames.INTERFACE_PORT)) {
					ddsPort = (Port) role;
					part = end.getPartWithPort();
				}
			}
			if (ddsPort == null || dataSpace == null) {
				return ctx.createSuccessStatus();
			}
			if (part == null
					&& (Boolean) ZDLUtil.getValue(ddsPort,
							CCMNames.INTERFACE_PORT,
							ZMLMMNames.PORT__IS_EXTERNAL)) {
				return ctx.createFailureStatus();
			}
		}
		return null;
	}
}
