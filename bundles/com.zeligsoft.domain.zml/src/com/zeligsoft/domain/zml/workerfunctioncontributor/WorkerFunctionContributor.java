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
package com.zeligsoft.domain.zml.workerfunctioncontributor;

import java.util.List;
import java.util.Map;

import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;

/**
 * Interface for all worker function contributors.
 * 
 * @author smcfee
 *
 */
public interface WorkerFunctionContributor {

	/**
	 * Method called by WorkerFunctionRepair to identify worker functions contributed by this
	 * contributor that already exist and do not need to be created.
	 * 
	 * @param structuralRealization
	 * @param target
	 * @param toAdd
	 */
	abstract public void filterGrowList(Component structuralRealization, Map<Port, List<WorkerFunctionInfo>> target, Map<Port, List<WorkerFunctionInfo>> toAdd);
	
	/**
	 * Method called by WorkerFunctionRepair to identify worker functions contributed by this
	 * contributor that should exist and do not need to be pruned.
	 * 
	 * @param structuralRealization
	 * @param target
	 * @param toRemove
	 */
	abstract public void filterPruneList(Component structuralRealization, Map<Port, List<WorkerFunctionInfo>> target, List<Operation> toRemove);
	
	/**
	 * Method called by WorkerFunctionRepair to list what worker functions should exist on a
	 * structural realization that has had worker functions contributed by this contributor. Adds
	 * to the "target" map that is passed in.
	 * 
	 * @param structuralRealization
	 * @param localTarget
	 */
	abstract public void buildTargetMap(Component structuralRealization, Map<Port, List<WorkerFunctionInfo>> localTarget);
}
