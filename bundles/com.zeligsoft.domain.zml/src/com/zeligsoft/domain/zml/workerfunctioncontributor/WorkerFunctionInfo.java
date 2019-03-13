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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.uml2.uml.Operation;

/**
 * The information about a worker function to be created in the context of some
 * component. It encapsulates the operation that the worker function should be based
 * on and provides a mechanism for including additional information which can be
 * used by the optional configurator.
 * 
 * @author Toby McClean
 * 
 */
public class WorkerFunctionInfo {
	final private Operation operation;
	final private Map<String, Object> data;
	final private WorkerFunctionConfigurator configurator;
	final private String uuid;
	
	
	/**
	 * @param operation
	 */
	public WorkerFunctionInfo(Operation operation) {
		this(operation, new HashMap<String, Object>(), null, null);
	}
	
	public WorkerFunctionInfo(Operation operation, String uuid) {
		this(operation, new HashMap<String, Object>(), null, uuid);
	}

	/**
	 * @param operation
	 * @param data
	 */
	public WorkerFunctionInfo(Operation operation, Map<String, Object> data) {
		this(operation, data, null, null);
	}
	
	
	/**
	 * @param operation
	 * @param data
	 * @param configurator
	 */
	public WorkerFunctionInfo(Operation operation, Map<String, Object> data,
			WorkerFunctionConfigurator configurator) {
		this(operation, data, configurator, null);
	}
	
	/**
	 * 
	 * @param operation
	 * @param data
	 * @param configurator
	 * @param uuid
	 */
	public WorkerFunctionInfo(Operation operation, Map<String, Object> data,
			WorkerFunctionConfigurator configurator, String uuid) {
		this.operation = operation;
		this.data = data;
		this.configurator = configurator;
		this.uuid = uuid;
	}

	public String getUuid(){
		return uuid;
	}

	/**
	 * Provide access to the underlying operation used for
	 * creating a worker function.
	 */
	public Operation getOperation() {
		return operation;
	}
	
	/**
	 * Provide access to the additional data which can be used
	 * by a configurator or the creator of the worker function.
	 */
	public <T> T getData(final String key, final Class<T> type) {
		final Object value = data.get(key);
		T result = null;
		if(type.isInstance(value)) {
			result = type.cast(value);
		}
		return result;
	}
	
	private boolean hasConfigurator() {
		return configurator != null;
	}
	
	/**
	 * Will configure the worker function that has been created if the worker function
	 * has an associated callback to configure it.
	 */
	public void configure(Operation workerFunction) {
		if(hasConfigurator()) {
			configurator.configure(workerFunction, this);
		}
	}
}
