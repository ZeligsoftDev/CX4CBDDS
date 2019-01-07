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

import java.util.Collection;
import java.util.UUID;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.util.UMLUtil;

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
	
	public static String generateDCEUUID() {
		return "DCE:" + UUID.randomUUID().toString();
	}
	
	public static Interface getCFInterface(Element context, String interfaceName){
		Package cfIDL = getModelLibrary(context, "CF_IDL");
		
		if(cfIDL == null) {
			throw new IllegalArgumentException("Unable to find an import of the CF_IDL library");
		}
		
		Collection<NamedElement> intfObj = UMLUtil.findNamedElements(cfIDL.eResource(), "CF_IDL::CF::CF::" + interfaceName);
		
		if(intfObj.isEmpty()) {
			throw new IllegalArgumentException("Unable to find the CF interface: " + interfaceName);
		}
		
		return (Interface) intfObj.iterator().next();
	}

	public static void createInterfaceRealization(Component comp, String name, Interface intf) {
		comp.createInterfaceRealization(name, intf);
	}
	
	public static Element getCFPortType(Element context, String interfaceName, Boolean inv) {
		Package library = getModelLibrary(context, "SCALibrary");
		String portTypeName = inv ? interfaceName + "Inv" : interfaceName;
		if(library == null) {
			throw new IllegalArgumentException("Unable to find an import of the SCALibrary library");
		}
		
		Collection<NamedElement> intfObj = UMLUtil.findNamedElements(library.eResource(), "SCALibrary::" + portTypeName);
		
		if(intfObj.isEmpty()) {
			throw new IllegalArgumentException("Unable to find the CF port type: " + interfaceName);
		}
		
		return intfObj.iterator().next();
	}
	
	private static Package getRootPackage(Element context) {
		Element root = (Element) context;
		
		if(root == null) {
			return null;
		}
		
		// find the CORBA primitives library by looking at the root
		// given the context
		while(root.getOwner() != null) {
			root = root.getOwner();
		}
		
		return (Package) root;
	}
	
	private static Package getModelLibrary(Element context, String libraryName) {
		Package root = getRootPackage(context);
		Package library = null;
		
		if(root != null) {	
			for(PackageImport imp : root.getPackageImports()) {
				if(imp.getImportedPackage() != null && imp.getImportedPackage().getName().equals(libraryName)) {
					library = imp.getImportedPackage();
					break;
				}
			}
		}
		
		return library;
	}
}
