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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MissingFunctionCollector implements IMissingFunctionCollector {
	
	
	private static IMissingFunctionCollector instance;
	public static synchronized IMissingFunctionCollector getInstance() {
		if(instance == null) {
			instance = new MissingFunctionCollector();
		}
		return instance;
	}

	private Set<String> typeNames = new HashSet<String>();
	private Set<String> elementsMissingFunctions = new HashSet<String>();
	private Map<String, Set<String>> missingGetters = new HashMap<String, Set<String>>();
	private Map<String, Map<String, Set<String>>> missing1ArgMethods = new HashMap<String, Map<String, Set<String>>>();

	@Override
	public void recordMissingGetter(String metaClass, String fullPathName, String methodName) {
		typeNames.add(metaClass);
		elementsMissingFunctions.add(metaClass + "," + fullPathName);
		final Set<String> methodNames = missingGetters.get(metaClass);
		if (methodNames == null) {
			missingGetters.put(metaClass, newSet(methodName));
		} else {
			methodNames.add(methodName);
		}
	}

	@Override
	public void recordMissing1ArgMethod(String metaClass, String fullPathName, String methodName, String argValue) {
		typeNames.add(metaClass);
		elementsMissingFunctions.add(metaClass + "," + fullPathName);
		final Map<String, Set<String>> methodsAndArgs = missing1ArgMethods
				.get(metaClass);
		if (methodsAndArgs == null) {
			missing1ArgMethods.put(metaClass, newMap(methodName, argValue));
		} else {
			final Set<String> methodArgs = methodsAndArgs.get(methodName);
			if (methodArgs == null) {
				methodsAndArgs.put(methodName, newSet(argValue));
			} else {
				methodArgs.add(argValue);
			}
		}
	}

	private Map<String, Set<String>> newMap(String keyValue, String setValue) {
		return new HashMap<String, Set<String>>(
				Collections.singletonMap(keyValue, newSet(setValue)));
	}

	private Set<String> newSet(String argValue) {
		return new HashSet<String>(Collections.singleton(argValue));
	}

	@Override
	public Set<String> getCollectedTypeNames() {
		return new HashSet<String>(typeNames);
	}

	@Override
	public Set<String> getCollectedGetters(String metaType) {
		return missingGetters.containsKey(metaType) 
				? new HashSet<String>(missingGetters.get(metaType)) 
				: Collections.<String>emptySet();
	}

	@Override
	public Map<String, Set<String>> getCollected1ArgMethods(String metaType) {
		return missing1ArgMethods.containsKey(metaType)
				? new HashMap<String, Set<String>>(missing1ArgMethods.get(metaType))
				: Collections.<String, Set<String>>emptyMap();
	}

	@Override
	public void reset() {
		typeNames.clear();
		missingGetters.clear();
		missing1ArgMethods.clear();
		elementsMissingFunctions.clear();
	}

	@Override
	public Map<String, Set<String>> getAllMissingGetters() {
		return missingGetters;
	}

	@Override
	public Map<String, Map<String, Set<String>>> getAllMissing1ArgMethods() {
		return missing1ArgMethods;
	}

	@Override
	public Set<String> getCollectedElements() {
		return new HashSet<String>(this.elementsMissingFunctions);
	}

}
