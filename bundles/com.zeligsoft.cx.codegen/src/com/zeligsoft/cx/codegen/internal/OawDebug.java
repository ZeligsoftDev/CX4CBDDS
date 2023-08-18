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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMapUtil.FeatureEList;
import org.eclipse.uml2.uml.NamedElement;

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
	
	public static String getNameOrId(Object obj) {
		String nameOrId = "_unknown_";
//		System.out.println("getNameOrId 1: " + obj.toString());
		assert obj != null;
		boolean found = false;
		if (obj instanceof EObject) {
//			System.out.println("getNameOrId 2: " + obj.toString());
			EObject eObj = (EObject) obj;
			for (EAttribute attribute : eObj.eClass().getEAllAttributes()) {
				if ("name".equals(attribute.getName())) {
					Object nameVal = eObj.eGet(attribute);
					if (nameVal instanceof List) {
						nameOrId = stringFromList((List)nameVal);
					} else {
						nameOrId = (String) nameVal.toString();
					}
					found = true;
					break;
				}
			}
			if (!found && eObj instanceof NamedElement) {
//				System.out.println("getNameOrId 3: " + obj.toString());
				NamedElement namedElement = (NamedElement) eObj;
				nameOrId = namedElement.getName();
				found = true;
			}
			if (!found && eObj instanceof ENamedElement) {
//				System.out.println("getNameOrId 4: " + obj.toString());
				ENamedElement eNamedElement = (ENamedElement) eObj;
				nameOrId = eNamedElement.getName();
				found = true;
			}
		}
		if (!found) {
//			System.out.println("getNameOrId 5: " + obj.toString());

			for (Class<?> klass = obj.getClass(); !found && klass != null; klass = klass.getSuperclass()) {
//				System.out.println("getNameOrId 6: " + klass.getName());
				Method methods[] = klass.getDeclaredMethods();
				for (Method method : methods) {
//					System.out.println("getNameOrId 7: " + method.getName());
					if ("getName".equals(method.getName())) {
						try {
							nameOrId = (String) method.invoke(obj);
							found = true;
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
				}
			}
			if (!found) {
//				System.out.println("getNameOrId 8: " + obj.toString());
				Class<?> klass = obj.getClass(); 
				Field fields[] = klass.getFields();
				for (Field field : fields) {
//					System.out.println("getNameOrId 9: " + field.getName());
					if ("name".equals(field.getName())) {
						try {
							nameOrId = (String) field.get(obj);
							found = true;
						} catch (IllegalArgumentException | IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
				}
			}
		}
//		System.out.println("getNameOrId 10: " + nameOrId);
		return nameOrId;
	}

	private static String stringFromList(List list) {
		int n = list.size();
		int i = 0;
		StringBuilder b = new StringBuilder();
		b.append('[');
		for (Object item: list) {
			b.append(item.toString());
			if (i < n - 1) b.append(", ");
			i++;
		}
		b.append(']');
		return b.toString();
	}
}
