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
package com.zeligsoft.domain.ngc.ccm.descriptorgeneration;

import java.util.Formatter;
import java.util.HashSet;
import java.util.Set;

/**
 * Debug utilities for xpand2 and xtend1 code.
 * Trace code can be left in templates, and enabled as needed
 * in code.
 * @author Paul Elder
 *
 */
public class XDebugUtil {
	
	/**
	 * Set ENABLED to true in order to see any traces.
	 * Shipping code should generally ship with this set to false
	 */
	private static boolean ENABLED = false;
	
	/**
	 * Individual traces can be enabled or disabled, too.
	 */
	private static final Set<String> enabledTraces = new HashSet<String>();
	
	public static void enableTrace(String topic) {
		if(ENABLED) {
			enabledTraces.add(topic);
		}
	}
	
	public static void disableTrace(String topic) {
		enabledTraces.remove(topic);
	}

	/**
	 * Trace for the given topic. Message follows the rules for 
	 * @param topic - a logging topic, enabled with {@link #enableTrace(String)}
	 * @param message - format specification, per {@link Formatter}
	 * @param parameters - parameter values referenced in the message string.
	 */
	public static void trace(String topic, String message, Object...parameters) {
		if(ENABLED && enabledTraces.contains(topic)) {
			System.out.append(topic).append(": ").format(message, parameters).println();
		}
	}
	
	public static void trace0(String topic, String message) {
		trace(topic, message);
	}
	
	public static void trace1(String topic, String message, Object parm0) {
		trace(topic, message, parm0);
	}
	
	public static void trace2(String topic, String message, Object parm0, Object parm1) {
		trace(topic, message, parm0, parm1);
	}
}
