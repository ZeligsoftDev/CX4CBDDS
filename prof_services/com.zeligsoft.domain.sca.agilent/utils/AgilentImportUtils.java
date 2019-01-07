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
package com.zeligsoft.domain.sca.agilent.importer.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class AgilentImportUtils {
	public static void setParameterDirection(EObject parameter, String direction) {
		if(!(parameter instanceof Parameter)) {
			throw new IllegalArgumentException(String.format("Expecting a uml::Parameter got a %s", parameter.getClass().getName()));
		}
		
		Parameter param = (Parameter) parameter;
		
		if("in".equals(direction.toLowerCase())) {
			param.setDirection(ParameterDirectionKind.IN_LITERAL);
		} else if("out".equals(direction.toLowerCase())) {
			param.setDirection(ParameterDirectionKind.OUT_LITERAL);
		} else if ("inout".equals(direction.toLowerCase())) {
			param.setDirection(ParameterDirectionKind.INOUT_LITERAL);
		} else {
			throw new IllegalArgumentException(String.format("Unknown direction %s", direction));
		}
	}
	
	public static void setCORBAPrimitiveType(TypedElement context, String type) {
		
		
		Type idlType = getCORBAPrimitiveType(context, type);
		
		context.setType((Type) idlType);
	}
	
	public static Type getCORBAPrimitiveType(Element context, String type) {
		Element root = (Element) context;
		
		if(root == null) {
			return null;
		}
		
		// find the CORBA primitives library by looking at the root
		// given the context
		while(root.getOwner() != null) {
			root = root.getOwner();
		}
		
		Package pkg = (Package) root;
		Package idlPrimitives = null;
		for(PackageImport imp : pkg.getPackageImports()) {
			if(imp.getImportedPackage() != null && imp.getImportedPackage().getName().equals("IDLPrimitives")) {
				idlPrimitives = imp.getImportedPackage();
			}
		}
		
		if(idlPrimitives == null) {
			throw new IllegalArgumentException("Unable to find an import of the IDLPrimitives library");
		}
		
		return (Type) idlPrimitives.getPackagedElement(type);
	}
}
