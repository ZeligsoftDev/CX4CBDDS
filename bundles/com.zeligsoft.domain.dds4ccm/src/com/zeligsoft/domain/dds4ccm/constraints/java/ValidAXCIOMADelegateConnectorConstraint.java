/**
 * Copyright 2023 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.constraints.java;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ConnectorEnd;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.ConnectorType;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.constraints.java.ValidDelegateConnectorConstraint;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * @author eposse
 *
 */
public class ValidAXCIOMADelegateConnectorConstraint extends ValidDelegateConnectorConstraint {

	public ValidAXCIOMADelegateConnectorConstraint() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();

		if (ZDLUtil.isZDLConcept(objToVerify, CCMNames.CCMCONNECTOR)) {
			@SuppressWarnings("unchecked")
			List<ConnectorEnd> ends = (List<ConnectorEnd>) ZDLUtil.getValue(objToVerify, ZMLMMNames.ASSEMBLY_CONNECTOR,
					ZMLMMNames.ASSEMBLY_CONNECTOR__END);
			EObject connectorContainer = objToVerify.eContainer();
			if (ends.size() == 2 && ZDLUtil.isZDLConcept(connectorContainer, CCMNames.ASSEMBLY_IMPLEMENTATION)) {
				ConnectorEnd end1 = ends.get(0);
				ConnectorEnd end2 = ends.get(1);
				EObject port1 = end1.getRole();
				EObject port2 = end2.getRole();
				if (port1 != null && ZDLUtil.isZDLConcept(port1, CCMNames.INTERFACE_PORT) && port2 != null
						&& ZDLUtil.isZDLConcept(port2, CCMNames.INTERFACE_PORT)) {
					if (!hasAMI4CCMConnectorType(port1) && !hasCORBA4CCMConnectorType(port1)
							&& !hasAMI4CCMConnectorType(port2) && !hasCORBA4CCMConnectorType(port2)) {
						return super.validate(ctx);
					}
					if (!validConnectorTypeEnds(end1, end2) && !validConnectorTypeEnds(end2, end1)) {
						return ctx.createFailureStatus("Invalid AXCIOMA connector ends");
					}
				}
			}
		}

		return ctx.createSuccessStatus();
	}

	protected static boolean validConnectorTypeEnds(ConnectorEnd connectorEnd1, ConnectorEnd connectorEnd2) {
		EObject port1 = connectorEnd1.getRole();
		EObject port2 = connectorEnd2.getRole();
		if (!isDelegateConnectorEnd(connectorEnd1)) {
			if (!isDelegateConnectorEnd(connectorEnd2)) {
				if (isReceptacle(port1) && isFacet(port2) 
						&& (hasAMI4CCMConnectorType(port1) || hasCORBA4CCMConnectorType(port1))
						&& hasCORBA4CCMConnectorType(port2))
					return true;
			} else {
				if (isReceptacle(port1) && isReceptacle(port2)) {
					if (hasAMI4CCMConnectorType(port1) && hasAMI4CCMConnectorType(port2))
						return true;
					if (hasCORBA4CCMConnectorType(port1) && hasCORBA4CCMConnectorType(port2))
						return true;
				} else if (isFacet(port1) && isFacet(port2)) {
					if (hasCORBA4CCMConnectorType(port1) && hasCORBA4CCMConnectorType(port2))
						return true;
				}
			}
		}
		return false;
	}

	protected static boolean isDelegateConnectorEnd(ConnectorEnd connectorEnd) {
		return connectorEnd.getPartWithPort() == null;
	}

	protected static boolean isReceptacle(EObject port) {
		return (Boolean) ZDLUtil.getValue(port, ZMLMMNames.CONJUGATED_PORT, ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED);
	}

	protected static boolean isFacet(EObject port) {
		return !isReceptacle(port);
	}

	protected static boolean hasConnectorType(EObject port, ConnectorType connectorType) {
		EObject portConnectorType = (EObject) ZDLUtil.getValue(port, CCMNames.INTERFACE_PORT,
				CCMNames.INTERFACE_PORT__CONNECTOR_TYPE);
		if (portConnectorType instanceof Component) {
			Component portConnectorTypeComponent = (Component) portConnectorType;
			return connectorType.name().equals(portConnectorTypeComponent.getName());
		}
		return false;
	}

	protected static boolean hasAMI4CCMConnectorType(EObject port) {
		return hasConnectorType(port, ConnectorType.AMI4CCM_Connector);
	}

	protected static boolean hasCORBA4CCMConnectorType(EObject port) {
		return hasConnectorType(port, ConnectorType.CORBA4CCM_Connector);
	}

}
