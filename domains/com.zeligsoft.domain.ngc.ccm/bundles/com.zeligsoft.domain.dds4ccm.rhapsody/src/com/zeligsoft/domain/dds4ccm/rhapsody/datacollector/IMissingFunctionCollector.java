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
package com.zeligsoft.domain.dds4ccm.rhapsody.datacollector;

import java.util.Map;
import java.util.Set;

public interface IMissingFunctionCollector {
	
	/**
	 * @param metaClass the Rhapsody meta-class, i.e. the interface name with the IRP prefix removed.
	 * @param fullPathName the Rhapsody full path of the object.
	 * @param methodName the method name
	 */
	public void recordMissingGetter(String metaClass, String fullPathName, String methodName);
	
	public void recordMissing1ArgMethod(String metaClass, String fullPathName, String methodName, String argValue);
	
	public Set<String> getCollectedTypeNames();
	
	public Set<String> getCollectedElements();
	
	public Set<String> getCollectedGetters(String metaType);
	
	public Map<String, Set<String>> getCollected1ArgMethods(String metaType);
	
	public void reset();

	public Map<String, Set<String>> getAllMissingGetters();

	public Map<String, Map<String, Set<String>>> getAllMissing1ArgMethods();

}
