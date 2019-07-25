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
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Constraint verifying that there is a port type in DDS4CCM Connector that
 * matches port type being connected to the other end point of CCM connector
 * 
 * @author ysroh
 * 
 */

public class IDL3PlusConnectorPortTypeConstraint extends AbstractModelConstraint {

	/**
	 * Public constructor.
	 */
	public IDL3PlusConnectorPortTypeConstraint() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject objToVerify = ctx.getTarget();

		if (ZDLUtil.isZDLConcept(objToVerify, CCMNames.CCMCONNECTOR)) {

			// Validate the connection if the connection is between DDS
			// port and data space.
			// Cancel if the connection is not valid and alert to user

			final Connector connector = (Connector) objToVerify;
			Port ddsPort = null;
			Property dataSpace = null;
			Property partWithPort = null;
			if (connector.getEnds().size() != 2) {
				return ctx.createSuccessStatus();
			}
			for (ConnectorEnd end : connector.getEnds()) {
				EObject role = end.getRole();
				if (ZDLUtil.isZDLConcept(role, IDL3PlusNames.DATA_SPACE)) {
					dataSpace = (Property) role;
				} else if (ZDLUtil.isZDLConcept(role, ZMLMMNames.CONJUGATED_PORT)) {
					ddsPort = (Port) role;
					partWithPort = end.getPartWithPort();
				}
			}
			if (ddsPort == null || dataSpace == null || partWithPort == null) {
				return ctx.createSuccessStatus();
			}
			
			Component connectorDef = (Component) dataSpace.getType();
			if (connectorDef == null) {
				return ctx.createFailureStatus(dataSpace.getName(),
						ddsPort.getName());
			}

			for( final NamedElement member : connectorDef.getMembers()) {
				if (!ZDLUtil.isZDLConcept(member, ZMLMMNames.CONJUGATED_PORT)) {
					continue;
				}
				if (ddsPort.getType() == ZDLUtil.getValue(member, ZMLMMNames.TYPED_ELEMENT, ZMLMMNames.TYPED_ELEMENT__TYPE)) {
					if ((Boolean) ZDLUtil.getValue(ddsPort,
							ZMLMMNames.CONJUGATED_PORT,
							ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED)
							^ (Boolean) ZDLUtil.getValue(member,
									ZMLMMNames.CONJUGATED_PORT,
									ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED)) {

						return ctx.createSuccessStatus();
					}
				}
			}
			// no matching port found
			return ctx.createFailureStatus(dataSpace.getName(),
					ddsPort.getName());
		}

		return null;

	}

}
