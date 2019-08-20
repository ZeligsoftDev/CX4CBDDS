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
package com.zeligsoft.domain.omg.ccm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;
import com.zeligsoft.domain.zml.util.ZMLUtil;
import com.zeligsoft.domain.zml.workerfunctioncontributor.WorkerFunctionContributor;
import com.zeligsoft.domain.zml.workerfunctioncontributor.WorkerFunctionInfo;

/**
 * 
 * Contributor of CCM worker functions based on Consumes ports.
 * 
 * @author smcfee
 *
 */
public class CCMWorkerFunctionContributor implements WorkerFunctionContributor {

	public void buildTargetMap(Component structuralRealization,
			Map<Port, List<WorkerFunctionInfo>> target) {

		Component componentInterface = ZMLUtil
				.getComponentInterface(structuralRealization);

		if (componentInterface != null) {
			@SuppressWarnings("unchecked")
			List<Port> componentInterfacePorts = (List<Port>) ZDLUtil.getValue(
					componentInterface, ZMLMMNames.COMPONENT_INTERFACE,
					ZMLMMNames.COMPONENT_INTERFACE__OWNED_PORT);

			for (Port thisPort : componentInterfacePorts) {

				// We are interested in Consumes ports, which are Event Ports with Port Types that use an Event.
				if (ZDLUtil.isZDLConcept(thisPort, CCMNames.EVENT_PORT)) {					
					Object portType = ZDLUtil.getValue(thisPort, ZMLMMNames.TYPED_ELEMENT, ZMLMMNames.TYPED_ELEMENT__TYPE);
					if( portType != null && ZDLUtil.isZDLConcept((EObject)portType, ZMLMMNames.PORT_TYPE)) {
						if(((org.eclipse.uml2.uml.Class)portType).getUsedInterfaces().size() > 0 ) {
							if( ZDLUtil.isZDLConcept(((org.eclipse.uml2.uml.Class)portType).getUsedInterfaces().get(0), CCMNames.EVENT)) {
								target.put(thisPort, new ArrayList<WorkerFunctionInfo>());	
							}									
						}
					}					
				}
			}
		}

	}

	public void filterPruneList(Component structuralRealization,
			Map<Port, List<WorkerFunctionInfo>> target, List<Operation> toRemove) {

		@SuppressWarnings("unchecked")
		List<Operation> existingWorkerFunctions = (List<Operation>) ZDLUtil
			.getValue(structuralRealization, ZMLMMNames.STRUCTURAL_REALIZATION,
				ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);

		Component componentInterface = ZMLUtil
		.getComponentInterface(structuralRealization);
		
		if( componentInterface != null ) {
			
			@SuppressWarnings("unchecked")
			List<Port> componentInterfacePorts = (List<Port>) ZDLUtil.getValue(
				componentInterface, ZMLMMNames.COMPONENT_INTERFACE,
				ZMLMMNames.COMPONENT_INTERFACE__OWNED_PORT);
			
			
			for (Operation thisWorkerFunction : existingWorkerFunctions) {
				
				boolean found = false;
				
				Port thisPort = (Port) ZDLUtil.getValue(thisWorkerFunction,
					ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT);
				Operation thisOperation = (Operation) ZDLUtil.getValue(
					thisWorkerFunction, ZMLMMNames.WORKER_FUNCTION,
					ZMLMMNames.WORKER_FUNCTION__PORT_OPERATION);
					
				for (Port port : componentInterfacePorts) {					
					if( ZDLUtil.isZDLConcept(port, CCMNames.EVENT_PORT)) {
						
						if( thisOperation == null && thisPort == port) {
							Object portType = ZDLUtil.getValue(thisPort, ZMLMMNames.TYPED_ELEMENT, ZMLMMNames.TYPED_ELEMENT__TYPE);
							if( portType != null && ZDLUtil.isZDLConcept((EObject)portType, ZMLMMNames.PORT_TYPE)) {
								if(((org.eclipse.uml2.uml.Class)portType).getUsedInterfaces().size() > 0 ) {
									if( ZDLUtil.isZDLConcept(((org.eclipse.uml2.uml.Class)portType).getUsedInterfaces().get(0), CCMNames.EVENT)) {
										found = true;
									}									
								}
							}	
						}
						
//						if( thisOperation == null && 
//							thisPort == port) {
//							found = true;
//						}
					}
				}	
				if (found) {
					toRemove.remove(thisWorkerFunction);
				}
			}
		}	
	}

	public void filterGrowList(Component structuralRealization,
			Map<Port, List<WorkerFunctionInfo>> target, Map<Port, List<WorkerFunctionInfo>> toAdd) {
		
		@SuppressWarnings("unchecked")
		List<Operation> existingWorkerFunctions = (List<Operation>) ZDLUtil
			.getValue(structuralRealization, ZMLMMNames.STRUCTURAL_REALIZATION,
				ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
		
		Component componentInterface = ZMLUtil
		.getComponentInterface(structuralRealization);
		
		if( componentInterface != null ) {
			
			@SuppressWarnings("unchecked")
			List<Port> componentInterfacePorts = (List<Port>) ZDLUtil.getValue(
				componentInterface, ZMLMMNames.COMPONENT_INTERFACE,
				ZMLMMNames.COMPONENT_INTERFACE__OWNED_PORT);
			
			for( Port port : componentInterfacePorts ) {
				if( ZDLUtil.isZDLConcept(port, CCMNames.EVENT_PORT)) {
					
					boolean found = false;
					
					for( Operation workerFunction : existingWorkerFunctions ) {
						if( ZDLUtil.getValue(workerFunction, ZMLMMNames.WORKER_FUNCTION, ZMLMMNames.WORKER_FUNCTION__RECEIVING_PORT) == port ) {
							found = true;
						}
					}
					if( found && toAdd.containsKey(port)) {
						toAdd.remove(port);						
					}					
				}
			}
		}
		
	}
}
