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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Validates a user attempts to connect a normal or delegated extended (pub-sub)
 * port on a monolithic or assembly component to more than one connector
 * instance (dot) of the same type on an assembly Structure diagram
 * 
 * @author ysroh
 * 
 */
public class ExtendedPortConnectionConstraint extends AbstractModelConstraint {

	private EObject objToVerify;

	/**
	 * Public constructor.
	 */
	public ExtendedPortConnectionConstraint() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		objToVerify = ctx.getTarget();

		if (!ZDLUtil.isZDLConcept(objToVerify, CCMNames.CCMCONNECTOR)) {
			return null;
		}

		if (((Connector) objToVerify).getEnds().size() != 2) {
			return null;
		}

		List<EObject> visitedConnector = new ArrayList<EObject>();
		visitedConnector.add(objToVerify);

		// handle when user creates delegation connector
		if (((Connector) objToVerify).getKind().equals(
				ConnectorKind.DELEGATION_LITERAL)) {

			EObject port1 = ZDLUtil.getEValue(((Connector) objToVerify)
					.getEnds().get(0), ZMLMMNames.CONNECTOR_END,
					ZMLMMNames.CONNECTOR_END__PORT);
			EObject port1Part = ZDLUtil.getEValue(((Connector) objToVerify)
					.getEnds().get(0), ZMLMMNames.CONNECTOR_END,
					ZMLMMNames.CONNECTOR_END__PART_WITH_PORT);
			EObject port2 = ZDLUtil.getEValue(((Connector) objToVerify)
					.getEnds().get(1), ZMLMMNames.CONNECTOR_END,
					ZMLMMNames.CONNECTOR_END__PORT);
			EObject port2Part = ZDLUtil.getEValue(((Connector) objToVerify)
					.getEnds().get(1), ZMLMMNames.CONNECTOR_END,
					ZMLMMNames.CONNECTOR_END__PART_WITH_PORT);

			if (isConnectedToConnectorInstance(port1, port1Part,
					visitedConnector)
					&& isConnectedToConnectorInstance(port2, port2Part,
							visitedConnector)) {
				return ctx.createFailureStatus();
			}
			return null;
		}

		EObject dataSpace = null;
		EObject port = null;
		EObject portPart = null;
		for (ConnectorEnd end : ((Connector) objToVerify).getEnds()) {
			EObject part = ZDLUtil.getEValue(end, ZMLMMNames.CONNECTOR_END,
					ZMLMMNames.CONNECTOR_END__PART);
			EObject endPort = ZDLUtil.getEValue(end, ZMLMMNames.CONNECTOR_END,
					ZMLMMNames.CONNECTOR_END__PORT);
			if (part == null && endPort == null) {
				break;
			}
			if (part != null
					&& ZDLUtil.isZDLConcept(part, IDL3PlusNames.DATA_SPACE)) {
				dataSpace = part;
			} else if (ZDLUtil.isZDLConcept(endPort, CCMNames.INTERFACE_PORT)) {
				EObject type = ZDLUtil.getEValue(endPort,
						CCMNames.INTERFACE_PORT, ZMLMMNames.PORT__PORTTYPE);
				if (type != null
						&& ZDLUtil.isZDLConcept(type,
								IDL3PlusNames.EXTENDED_PORT_TYPE)) {
					portPart = ZDLUtil.getEValue(end, ZMLMMNames.CONNECTOR_END,
							ZMLMMNames.CONNECTOR_END__PART_WITH_PORT);
					port = endPort;
				}
			}
		}

		if (dataSpace == null || port == null || portPart == null) {
			return null;
		}

		if (isConnectedToConnectorInstance(port, portPart, visitedConnector)) {
			return ctx.createFailureStatus();
		}
		return null;
	}

	/**
	 * Check if port is connected to a DataSpace
	 * 
	 * @param port
	 * @param portPart
	 *            part with port
	 * @param visitedConnector
	 *            connectors to ignore
	 * @return
	 */
	private boolean isConnectedToConnectorInstance(EObject port,
			EObject portPart, List<EObject> visitedConnector) {
		for (Setting setting : UMLUtil.getInverseReferences(port)) {
			if (setting.getEObject() instanceof ConnectorEnd
					&& ZDLUtil.isZDLConcept(setting.getEObject().eContainer(),
							CCMNames.CCMCONNECTOR)
					&& !visitedConnector.contains(setting.getEObject()
							.eContainer())) {
				Connector conn = (Connector) setting.getEObject().eContainer();
				visitedConnector.add(conn);
				if (conn.getEnds().size() == 2) {
					ConnectorEnd otherEnd = null;
					ConnectorEnd thisEnd = null;
					if (conn.getEnds().get(0) == setting.getEObject()) {
						thisEnd = conn.getEnds().get(0);
						otherEnd = conn.getEnds().get(1);
					} else {
						otherEnd = conn.getEnds().get(0);
						thisEnd = conn.getEnds().get(1);
					}

					EObject otherEndPort = ZDLUtil.getEValue(otherEnd,
							ZMLMMNames.CONNECTOR_END,
							ZMLMMNames.CONNECTOR_END__PORT);
					EObject otherEndPortPart = ZDLUtil.getEValue(otherEnd,
							ZMLMMNames.CONNECTOR_END,
							ZMLMMNames.CONNECTOR_END__PART_WITH_PORT);
					EObject otherEndPart = ZDLUtil.getEValue(otherEnd,
							ZMLMMNames.CONNECTOR_END,
							ZMLMMNames.CONNECTOR_END__PART);
					EObject thisEndPortPart = ZDLUtil.getEValue(thisEnd,
							ZMLMMNames.CONNECTOR_END,
							ZMLMMNames.CONNECTOR_END__PART_WITH_PORT);
					if (portPart != null && portPart != thisEndPortPart) {
						// ignore any reference to this port of different part
						continue;
					}
					// Check the other end if this is delegation connector
					if (conn.getKind().equals(ConnectorKind.DELEGATION_LITERAL)
							&& otherEndPort != null) {
						if (isConnectedToConnectorInstance(otherEndPort,
								otherEndPortPart, visitedConnector)) {
							return true;
						}
					}

					// check if the other end is connected to a Dataspace
					if ((portPart == thisEndPortPart || portPart == null)
							&& otherEndPart != null
							&& ZDLUtil.isZDLConcept(otherEndPart,
									IDL3PlusNames.DATA_SPACE)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
