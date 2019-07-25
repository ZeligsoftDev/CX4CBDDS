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

package com.zeligsoft.domain.zml.edithelpers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * <tt>StructuralRealization</tt> edit helper advice which applies the
 * {@link ZMLMMNames#STRUCTURAL_REALIZATION} concept. Among possibly other
 * advice that it implements, it prevents deletion of worker functions directly
 * from <tt>StructuralRealization</tt>s (they are deleted automatically by
 * manipulation of ports, interface operations, and invocations of the repair
 * action).
 * 
 * @author Christian W. Damus (cdamus)
 */
public class StructuralRealizationEditHelperAdvice
		extends AbstractEditHelperAdvice {

	/**
	 * Advises the destruction of a worker function by returning an unexecutable
	 * command, effectively disabling the operation.
	 */
	@Override
	protected ICommand getBeforeDestroyElementCommand(
			DestroyElementRequest request) {

		EObject toDestroy = request.getElementToDestroy();

		// are we trying to destroy a WorkerFunction of a StructuralRealization?
		if (ZDLUtil.isZDLConcept(toDestroy, ZMLMMNames.WORKER_FUNCTION)
			&& ZDLUtil.isZDLConcept(toDestroy.eContainer(),
				ZMLMMNames.STRUCTURAL_REALIZATION)) {

			Port port = (Port) ZDLUtil.getValue(toDestroy,
				ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT);

			Component ci = (Component) ZDLUtil.getValue(toDestroy.eContainer(),
				ZMLMMNames.STRUCTURAL_REALIZATION,
				ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE);

			Operation operation = (Operation) ZDLUtil.getValue(toDestroy,
				ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION);

			if ((ci != null) && (operation != null)) {
				// check whether it is still a valid worker function of a port
				// of the SR's interface
				if ((port != null)
					&& ci.getAllAttributes().contains(port)
					&& isOperationOfAnyInterface(port.getProvideds(), operation)) {
					
					// disallow deletion
					return UnexecutableCommand.INSTANCE;
				}

				// or, maybe it's an worker function for an operation of some
				// interface provided directly by the component interface?
				if (isOperationOfAnyInterface(ci.getProvideds(), operation)) {
					// disallow deletion
					return UnexecutableCommand.INSTANCE;
				}
			}
		}

		return super.getBeforeDestroyElementCommand(request);
	}

	private boolean isOperationOfAnyInterface(List<Interface> interfaces,
			Operation operation) {

		boolean result = false;

		for (Interface next : interfaces) {
			if (next.getAllOperations().contains(operation)) {
				result = true;
				break;
			}
		}

		return result;
	}

}
