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
package com.zeligsoft.cx.codegen.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class OawDebug {

	public static boolean isDebugEnabled() {
		String debugEnvVar = System.getenv("XTEND_DEBUG");
		return "true".equalsIgnoreCase(debugEnvVar) || "1".equals(debugEnvVar);
	}

	public static void inspect( Long condition, Object obj ) {
		System.out.println( "[" + condition + "] inspecting " + obj );  //$NON-NLS-1$//$NON-NLS-2$
		condition.intValue();
	}

	public static Object inspect( Object obj ) {
		System.out.println( "inspecting " + obj );  //$NON-NLS-1$
		internalInspect(obj);
		return obj;
	}

	public static Object inspect( Object obj, String msg ) {
		System.out.println( "[" + msg + "]inspecting " + obj );  //$NON-NLS-1$
		internalInspect(obj);
		return obj;
	}
	
	private static void internalInspect(Object obj) {
		StringBuilder b = new StringBuilder();
		Class<?> klass = obj.getClass();
		appendClass(b, klass);
		appendSuperclass(b, klass);
		appendInterfaces(b, klass);
		appendFields(b, klass, obj);
		appendMethods(b, klass);
		System.out.println(b.toString());
	}

	/**
	 * @param b
	 * @param klass
	 */
	private static void appendClass(StringBuilder b, Class<?> klass) {
		b.append("class ");
		b.append(klass.getCanonicalName());
		b.append('\n');
	}

	/**
	 * @param b
	 * @param klass
	 */
	private static void appendSuperclass(StringBuilder b, Class<?> klass) {
		Class<?> superclass = klass.getSuperclass();
		if ("java.lang.Object".equals(superclass.getCanonicalName())) return;
		b.append("  superclass: ");
		b.append(superclass.getCanonicalName());
		b.append('\n');
	}

	/**
	 * @param b
	 * @param klass
	 */
	private static void appendInterfaces(StringBuilder b, Class<?> klass) {
		Class<?> interfaces[] = klass.getInterfaces();
		if (interfaces.length == 0) return;
		b.append("  interfaces:");
		b.append('\n');
		for (int i = 0; i < interfaces.length; i++ ) {
			b.append("    ");
			b.append(interfaces[i].getCanonicalName());
			b.append('\n');
		}
	}

	/**
	 * @param b
	 * @param klass
	 * @param obj
	 */
	private static void appendFields(StringBuilder b, Class<?> klass, Object obj) {
		Field fields[] = klass.getDeclaredFields();
		if (fields.length == 0) return;
		b.append("  fields:");
		b.append('\n');
		for (int i = 0; i < fields.length; i++) {
			b.append("    ");
			b.append(fields[i].toString());
			b.append(" = ");
			try {
				b.append(fields[i].get(obj).toString());
			} catch (IllegalArgumentException | IllegalAccessException e) {
				b.append("<illegal-access>");
			}
			b.append('\n');
		}
	}

	/**
	 * @param b
	 * @param klass
	 */
	private static void appendMethods(StringBuilder b, Class<?> klass) {
		Method methods[] = klass.getDeclaredMethods();
		if (methods.length == 0) return;
		b.append("  methods:");
		b.append('\n');
		for (int i = 0; i < methods.length; i++) {
			b.append("    ");
			b.append(methods[i].toString());
			b.append('\n');
		}
	}

	public static Object debug(Object ret, String msg) {
		System.out.println(msg);
		if (ret instanceof List) {
			return debugList(ret);
		}
		return ret;
	}
	
	public static Object debugList(Object l) {
		if (l instanceof List) {
			StringBuilder b = new StringBuilder();
			int len = ((List) l).size();
			b.append('[');
			b.append('\n');
			int i = 0;
			for (Object o : (List<?>)l) {
				b.append("  ");
				b.append(o.toString());
				if (i < len - 1) {
					b.append(',');
				}
				b.append('\n');
				i++;
			}
			b.append(']');
			System.out.println(b.toString());
		}
		return l;
	}
}
