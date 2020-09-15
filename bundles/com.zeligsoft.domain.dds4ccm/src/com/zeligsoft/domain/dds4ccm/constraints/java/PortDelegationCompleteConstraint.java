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
package com.zeligsoft.domain.dds4ccm.constraints.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.service.ConstraintRegistry;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;

/**
 * In a complete model, if a source port has delegation connectors to a set of
 * delegated target ports, then the union of the interfaces of these target
 * ports must be signature compatible with the interface that types the source
 * port.
 * 
 * @author ysroh
 * 
 */
public class PortDelegationCompleteConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();

		if (!hasDelegations((Port) objToVerify)) {
			return ctx.createSuccessStatus();
		}

		boolean result = isDelegationCompleteForPort((Port) objToVerify);
		if (result == false) {
			ctx.addResult(objToVerify);
			return ctx.createFailureStatus(objToVerify);
		}

		return ctx.createSuccessStatus();
	}

	/**
	 * Helper method to find out if the given port has delegation
	 * 
	 * @param port
	 * @return
	 */
	private static boolean hasDelegations(Port port) {
		boolean result = false;

		for (ConnectorEnd end : port.getEnds()) {

			if (!(end.getOwner() instanceof Connector)) {
				continue;
			}
			Connector connector = (Connector) end.getOwner();

			ConnectorEnd otherEnd = null;
			for (ConnectorEnd anEnd : connector.getEnds()) {
				if (anEnd != end) {
					otherEnd = anEnd;
					break;
				}
			}

			if (otherEnd.getRole() instanceof Port
					&& connector.getKind() == ConnectorKind.DELEGATION_LITERAL) {
				return true;
			}
		}

		return result;
	}

	/**
	 * Queries if the given port is delegation complete
	 * 
	 * @param port
	 * @return
	 */
	private boolean isDelegationCompleteForPort(Port port) {
		if (port.getType() == null) {
			return true;
		}

		ArrayList<Connector> connections = new ArrayList<Connector>();
		for (ConnectorEnd end : port.getEnds()) {
			if (!(end.getOwner() instanceof Connector)) {
				continue;
			}
			connections.add((Connector) end.getOwner());
		}
		Set<Interface> sourceRequireds = new HashSet<Interface>();
		Set<Interface> sourceProvideds = new HashSet<Interface>();
		for (Connector connector : connections) {
			if (!connector.getKind().equals(ConnectorKind.DELEGATION_LITERAL)) {
				continue;
			}
			if (connector.getEnds().size() != 2) {
				continue;
			}
			EObject sourcePort = null;
			if (connector.getEnds().get(0).getRole().equals(port)) {
				sourcePort = connector.getEnds().get(1).getRole();
			} else if (connector.getEnds().get(1).getRole().equals(port)) {
				sourcePort = connector.getEnds().get(0).getRole();
			}
			if (sourcePort != null && sourcePort instanceof Port) {
				sourceRequireds.addAll(((Port) sourcePort).getRequireds());
				sourceProvideds.addAll(((Port) sourcePort).getProvideds());
			}
		}

		if (!sourceRequireds.containsAll(port.getRequireds())) {
			return false;
		}
		if (!sourceProvideds.containsAll(port.getProvideds())) {
			return false;
		}

		return true;
	}

}
