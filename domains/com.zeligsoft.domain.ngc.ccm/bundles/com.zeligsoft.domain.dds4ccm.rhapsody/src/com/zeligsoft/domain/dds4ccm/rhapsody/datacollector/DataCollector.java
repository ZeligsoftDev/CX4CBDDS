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

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.telelogic.rhapsody.core.IRPModelElement;

public class DataCollector {

	static class ClassData {
		final String classFqn;
		final Map<String, MethodData> methodDataMap = new HashMap<String, MethodData>();

		public ClassData(String classFqn) {
			this.classFqn = classFqn;
		}
	}

	static class MethodData {
		final String methodName;
		final String returnType;
		final Set<String> argumentValues = new HashSet<String>();
		final Set<String> collectionTypes = new HashSet<String>();
		final Class<?>[] argumentTypes;

		public MethodData(String methodName, String returnType,
				Class<?>[] argumentTypes) {
			this.methodName = methodName;
			this.returnType = returnType;
			this.argumentTypes = argumentTypes;

		}

	}

	final Map<String, ClassData> classDataMap = new HashMap<String, ClassData>();
	
	void record(IRPModelElement element, Method method, Object[] args) {
		final String className = element.getClass().getSimpleName();
		final String methodName = method.getName();

		final ClassData classData;
		if (classDataMap.containsKey(className)) {
			classData = classDataMap.get(className);
		} else {
			classData = new ClassData(className);
			classDataMap.put(className, classData);
		}
		final MethodData methodData;
		if (classData.methodDataMap.containsKey(methodName)) {
			methodData = classData.methodDataMap.get(methodName);
		} else {
			methodData = new MethodData(method.getName(), method
					.getReturnType().getSimpleName(),
					method.getParameterTypes());
			classData.methodDataMap.put(methodName, methodData);
		}

		if (args != null) {
			for (Object object : args) {
				methodData.argumentValues.add(object != null ? object
						.toString() : "null");
			}
		}
	}

	public void dump(String dataFile) {
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(dataFile);
			final List<String> classNames = new ArrayList<String>(
					classDataMap.keySet());
			Collections.sort(classNames);
			printWriter
					.append("<type interfacefqn=\"com.telelogic.rhapsody.core.IRPModelElement")
					.append("\" abstract=\"true\" superTypeFqn=\"\"/>")
					.println();
			for (String className : classNames) {
				printWriter
						.append("<type interfacefqn=\"com.telelogic.rhapsody.core.I")
						.append(className)
						.append("\" abstract=\"false\" superTypeFqn=\"com.telelogic.rhapsody.core.IRPModelElement\">");
				printWriter.println();
				final ClassData classData = classDataMap.get(className);
				final List<String> methodNames = new ArrayList<String>(
						classData.methodDataMap.keySet());
				Collections.sort(methodNames);
				for (String methodName : methodNames) {
					final MethodData methodData = classData.methodDataMap
							.get(methodName);

					if (!methodData.returnType.endsWith("RPCollection")
							&& methodData.argumentTypes.length == 0) {
						printWriter.append("    ").append("<getter name=\"")
								.append(methodName).append("\" kryoType=\"")
								.append(methodData.returnType).append("\"/>");
						printWriter.println();
					} else if (methodData.returnType.endsWith("RPCollection")) {
						printWriter
								.append("    ")
								.append("<collection name=\"")
								.append(methodName)
								.append("\" typeFqn=\"com.telelogic.rhapsody.core.IRPModelElement\" empty=\"")
								.append(methodData.collectionTypes.isEmpty() ? "true"
										: "false").append("\">");
						printWriter.println();
						printWriter.append("        ").append("<types>");
						for (String type : methodData.collectionTypes) {
							printWriter.append(type).append(' ');
						}
						printWriter.append("</types>");
						printWriter.println();
						printWriter.append("    ").append("</collection>");
						printWriter.println();
					} else if ("equals".equals(methodName)) {
						// do nothing...
					} else if (methodData.argumentTypes.length == 1) {
						printWriter
								.append("    ")
								.append("<method name=\"")
								.append(methodName)
								.append("\" defaultValue=\"")
								.append("String".equals(methodData.returnType) ? "new String()"
										: "null")
								.append("\" returns=\"")
								.append(methodData.returnType)
								.append("\" arguments=\"")
								.append(methodData.argumentTypes[0]
										.getCanonicalName()).append("\">")
								.println();
						for (String argValue : methodData.argumentValues) {
							printWriter.append("        ")
									.append("<argValue value=\"")
									.append(argValue).append("\"/>").println();
						}
						printWriter.append("    ").append("</method>")
								.println();
					}

				}
				printWriter.append("</type>");
				printWriter.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}

	}

	public Object proxy(IRPModelElement element) {
		final Class<? extends IRPModelElement> elementClass = element
				.getClass();
		return Proxy.newProxyInstance(elementClass.getClassLoader(),
				new Class<?>[] { elementClass.getInterfaces()[0] },
				new RecordingInvocationHandler(element, this));
	}

}