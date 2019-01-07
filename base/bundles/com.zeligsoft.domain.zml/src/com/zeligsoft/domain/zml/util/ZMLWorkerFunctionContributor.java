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
package com.zeligsoft.domain.zml.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.workerfunctioncontributor.WorkerFunctionContributor;
import com.zeligsoft.domain.zml.workerfunctioncontributor.WorkerFunctionInfo;

/**
 * 
 * Contributor of worker functions based on ZML Message Ports and supported interfaces.
 * 
 * Note: Even though this class is in ZML, it is actually only called from SCA
 * 
 * @author smcfee
 *
 */
public class ZMLWorkerFunctionContributor implements WorkerFunctionContributor {
	final private static String EMPTY = "";

	@Override
	public void buildTargetMap(Component structuralRealization,
			Map<Port, List<WorkerFunctionInfo>> target) {

		Component componentInterface = ZMLUtil
		.getComponentInterface(structuralRealization);
		
		if( componentInterface != null ) {
			@SuppressWarnings("unchecked")
			List<Port> componentInterfacePorts = (List<Port>) ZDLUtil.getValue(
				componentInterface, ZMLMMNames.COMPONENT_INTERFACE,
				ZMLMMNames.COMPONENT_INTERFACE__OWNED_PORT);
	
			for (Port thisPort : componentInterfacePorts) {
				for (Interface thisInterface : thisPort.getProvideds()) {
					if(ZDLUtil.getValue(thisPort, ZMLMMNames.CONJUGATED_PORT, ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED) == Boolean.TRUE) {
						continue;
					}
					if (ZDLUtil.isZDLConcept(thisInterface, ZMLMMNames.INTERFACE)) {
						List<Operation> allOperations = thisInterface
							.getAllOperations();
						List<WorkerFunctionInfo> portOpsList = new LinkedList<WorkerFunctionInfo>();
						for (Operation thisOperation : allOperations) {
							if (ZDLUtil.isZDLConcept(thisOperation,
								ZMLMMNames.OPERATION)) {
								portOpsList.add(new WorkerFunctionInfo(thisOperation));
							}
						}
						if (!portOpsList.isEmpty()) {
							// the provide port is used and will have a name
							// that is non empty for the component interface provides ports.
							target.put(thisPort, portOpsList);
						}
					}
				}
			}
	
			// Bug 14977: use a single collection to gather unique operations across all
			// of the component's interface realizations
			Set<WorkerFunctionInfo> interfaceOps = new LinkedHashSet<WorkerFunctionInfo>();
			for (InterfaceRealization thisInterfaceRealization : componentInterface.getInterfaceRealizations()) {
				Interface thisInterface = thisInterfaceRealization.getContract();
				if (ZDLUtil.isZDLConcept(thisInterface, ZMLMMNames.INTERFACE)) {
					List<Operation> allOperations = thisInterface.getAllOperations();
					for (Operation thisOperation : allOperations)
						if (ZDLUtil.isZDLConcept(thisOperation, ZMLMMNames.OPERATION))
							interfaceOps.add(new WorkerFunctionInfo(thisOperation));
				}
			}
			
			// the null port is used to identify worker function operations
			// based on supports interfaces
			target.put(null, new ArrayList<WorkerFunctionInfo>(interfaceOps));
		}
		
	}

	@Override
	public void filterPruneList(Component structuralRealization,
			Map<Port, List<WorkerFunctionInfo>> target, List<Operation> toRemove) {
		
		@SuppressWarnings("unchecked")
		List<Operation> existingWorkerFunctions = (List<Operation>) ZDLUtil
			.getValue(structuralRealization, ZMLMMNames.STRUCTURAL_REALIZATION,
				ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);

		for (Operation thisWorkerFunction : existingWorkerFunctions) {

			Port thisPort = (Port) ZDLUtil.getValue(thisWorkerFunction,
				ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT);
			Operation thisOperation = (Operation) ZDLUtil.getValue(
				thisWorkerFunction, ZMLMMNames.WORKER_FUNCTION,
				ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION);

			if( thisPort == null || ZDLUtil.isZDLConcept(thisPort, ZMLMMNames.MESSAGE_PORT)) {
				
				boolean found = false;
				
				List<WorkerFunctionInfo> operations = target.get(thisPort);
				if (operations != null) {
					Iterator<WorkerFunctionInfo> iter = operations.iterator();
					
					while (iter.hasNext()) {
						WorkerFunctionInfo op = iter.next();
						if (op.getOperation() == thisOperation
							&& target.get(thisPort).contains(op)) {
							found = true;
							break;
						}
					}						
				} 
				
				if (found) {
					toRemove.remove(thisWorkerFunction);
				}
				
			}
		}
	}

	@Override
	public void filterGrowList(Component structuralRealization,
			Map<Port, List<WorkerFunctionInfo>> target, Map<Port, List<WorkerFunctionInfo>> toAdd) {

		@SuppressWarnings("unchecked")
		List<Operation> existingWorkerFunctions = (List<Operation>) ZDLUtil
			.getValue(structuralRealization, ZMLMMNames.STRUCTURAL_REALIZATION,
				ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);

		// we only care about the targetMap where the port == null
		// (supportsInterface) or the port name is not "" (provides port)
		for (Port thisPort : target.keySet()) {
			if(thisPort == null || !EMPTY.equals(thisPort.getName())) {
				for (WorkerFunctionInfo thisOperation : target.get(thisPort)) {
					Iterator<Operation> iter = existingWorkerFunctions.iterator();
					boolean found = false;
					while (iter.hasNext()) {
						Operation thisExistingOperation = iter.next();
						Operation wfOperation = (Operation) ZDLUtil.getValue(
								thisExistingOperation, ZMLMMNames.WORKER_FUNCTION,
								ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION);
						if (thisOperation.getOperation() == wfOperation) {
							Port wfPort = (Port) ZDLUtil.getValue(
									thisExistingOperation,
									ZMLMMNames.WORKER_FUNCTION,
									ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT);
							if (thisPort == wfPort) {
								found = true;
								break;
							}
						}
					}
					if (found) {
						toAdd.get(thisPort).remove(thisOperation);
						if (toAdd.get(thisPort).isEmpty()) {
							toAdd.remove(thisPort);
						}
					}
				}
			}
		}
	}
}
