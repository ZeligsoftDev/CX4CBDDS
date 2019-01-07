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
package com.zeligsoft.base.util;

import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.Activator;

/**
 * @author eclipse
 *
 */
public class UMLTypeUtil {
	public static final String UML2_PACKAGE = "org.eclipse.uml2.uml."; //$NON-NLS-1$
	public static final String UML_NAMESPACE = "uml::"; //$NON-NLS-1$
	public static final UMLTypeUtil INSTANCE = new UMLTypeUtil();
	
	private UMLTypeUtil() {
		// don't need to create me I am a singleton and
		// have no state
	}
	
	@SuppressWarnings("static-access")
	public static boolean isUMLType(Element object, String umlType, boolean strict) {
		boolean result = false;
		String javaClass = null;
		
		if(!umlType.startsWith(UML2_PACKAGE)) {
			if(umlType.startsWith(UML_NAMESPACE)) {
				javaClass = 
					UML2_PACKAGE.concat(umlType.substring(UML_NAMESPACE.length()));
			} else {
				javaClass =
					UML2_PACKAGE.concat(umlType);
			}
		} else if (umlType.startsWith(UML_NAMESPACE)) {
			javaClass = umlType;
		}
		
		try {
			final java.lang.Class<?> umlClass = 
				object.getClass().getClassLoader().loadClass(javaClass);
			java.lang.Class<?> instanceClass = 
				object.eClass().getInstanceClass();
			
			result = umlClass.equals(instanceClass);
			
		} catch (ClassNotFoundException e) {
			Activator.warning(Activator.getDefault(), 
					"Unable to find class: " + javaClass, e); //$NON-NLS-1$
			result = false;
		}
		
		return result;
	}
	
	public static String umlType(Element object) {
		java.lang.Class<?> instanceClass = 
			object.eClass().getInstanceClass();
		
		return instanceClass.getName();
	}
}
