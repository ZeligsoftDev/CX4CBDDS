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

package com.zeligsoft.base.zml.codegeneration.xtend.utils;

import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.Parameter;

public class FunctionNames {

	public static String getProvidesPortDerivedFunction(Type component,
			Interface interface_, Operation operation) {
		String allParameters = ""; //$NON-NLS-1$
		for (Parameter p : operation.getOwnedParameters()) {
			if (p.getType() != null) {
				allParameters = allParameters + " " + getIDLType(p.getType().getName()) //$NON-NLS-1$
					+ " " + p.getName() + ", "; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return "void zce" //$NON-NLS-1$
				+ component.getName()
				+ "Worker_" //$NON-NLS-1$
				+ interface_.getName()
				+ "_" //$NON-NLS-1$
				+ operation.getName()
				+ "(zceBase_" //$NON-NLS-1$
				+ interface_.getName()
				+ " basePtr, " //$NON-NLS-1$
				+ allParameters
				+ "int iPortIndex, int iConnIndex ZCE_EXC_ENV_ARG)"; //$NON-NLS-1$
	}

	public static String getNamedElementName(NamedElement namedElement) {
		if (namedElement == null) {
			return ""; //$NON-NLS-1$
		}
		return namedElement.getName();
	}

	public static String getTypedElementName(Type typedElement) {
		if (typedElement == null) {
			return ""; //$NON-NLS-1$
		}
		return typedElement.getName();
	}
	
	private static String getIDLType(String umlType) {
		String type = null;
		if (umlType.equalsIgnoreCase("string")) {
			type = "char*";
		}
		return type;
	}
}
