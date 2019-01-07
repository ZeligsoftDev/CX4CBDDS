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
package com.zeligsoft.domain.dds4ccm.idlimport;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Component;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Home;

/**
 * Utility methods for IDL3+ import.
 * 
 * @author smcfee
 *
 */
public class ImportUtils {

	/**
	 * Add the IDL3+ Scope to an IDL import operation.
	 */
	public static void setupSynchronicityMap() {
		asynchronousInterfaceList.clear();
	}
	
	private static boolean asynchronousInterface = false;
	private static ArrayList<Interface> asynchronousInterfaceList = new ArrayList<Interface>();
	
	public static void setAsynchronousInterface(Object o1, Object o2) {
		asynchronousInterface = true;
	}
	
	public static void checkSynchronicity(Interface zInterface) {
		if( asynchronousInterface && !(isMarkedAsynchronous(zInterface)) ) {
			asynchronousInterfaceList.add(zInterface);
		}
		asynchronousInterface = false;
	}
	
	public static boolean isMarkedAsynchronous(Interface intf) {
		return asynchronousInterfaceList.contains(intf);
	}
	
	public static void setPortSynchronicities(Component comp) {
		for( Port p : comp.getOwnedPorts()) {
			if( ZDLUtil.isZDLConcept(p, CCMNames.INTERFACE_PORT)) {
				Type t = p.getType();
				if( t == null ) {
					return;
				}
				if( ZDLUtil.isZDLConcept(t, CORBADomainNames.CORBAINTERFACE)) {
					if( isMarkedAsynchronous((Interface)t)) {
						ZDLUtil.setValue(p, CCMNames.INTERFACE_PORT, CCMNames.INTERFACE_PORT__IS_ASYNCHRONOUS, true);
					}
				}
			}
		}
	}
	
	private static String pragmaComponent = null;
	private static String pragmaHome = null;
	
	public static void setPragmaComponent(Preproc_Pragma_Component pragma, Object o2 ) {
		pragmaComponent = pragma.getValue();
	}
	
	public static void setPragmaHome(Preproc_Pragma_Home pragma, Object o2 ) {
		pragmaHome = pragma.getValue();
	}
	
	public static String getPragmaComponent() {
		String retVal = pragmaComponent;
		pragmaComponent = null;
		return retVal;
	}
	
	public static String getPragmaHome() {
		String retVal = pragmaHome;
		pragmaHome = null;
		return retVal;
	}
	
	
	/**
	 * Convert any CORBAStructs that are used in module instantiations to DDSMessages
	 * 
	 * @param pkg
	 */
	@SuppressWarnings("unchecked")
	public static void convertStructs(Package pkg) {
		List<Element> structs = IDL3PlusUtil.getConceptElements(pkg, CORBADomainNames.CORBASTRUCT);
		List<Element> instantiations = IDL3PlusUtil.getConceptElements(pkg, IDL3PlusNames.MODULE_INSTANTIATION);
		
		for( Element struct : structs) {
			
			boolean isInstantiated = false;
			for( Element instantiation : instantiations ) {
				EObject moduleBinding = 
					(EObject)ZDLUtil.getValue(
							instantiation, 
							IDL3PlusNames.MODULE_INSTANTIATION, 
							IDL3PlusNames.MODULE_INSTANTIATION__MODULE_BINDING);
				for( Element parameterBinding : (List<Element>)ZDLUtil.getValue(moduleBinding, IDL3PlusNames.MODULE_BINDING, IDL3PlusNames.MODULE_BINDING__PARAMETER_BINDING)) {
					if( ZDLUtil.getValue(parameterBinding, IDL3PlusNames.PARAMETER_BINDING, IDL3PlusNames.PARAMETER_BINDING__TYPE) == struct) {
						isInstantiated = true;
					}
				}
			}
			
			if( isInstantiated ) {
				
				DDS4CCMUtil.convertCORBAStructToDDSMessage(struct);

			}
			
			for (Element sub : struct.getOwnedElements()) {
				sub.getOwnedComments().clear();
			}
		}
	}

	/**
	 * Replace //@key comment with key annotation
	 * 
	 * @param field
	 */
	public static void configureFieldKey(Property field) {
		Comment keyComment = null;
		for (Comment c : field.getOwnedComments()) {
			if (c.getBody().contains("@key")) { //$NON-NLS-1$
				keyComment = c;
				break;
			}
		}
		if (keyComment != null) {
			field.getOwnedComments().remove(keyComment);
			CCMUtil.putZCXAnnotationDetail(field, "fieldkey", //$NON-NLS-1$
					Boolean.toString(true));
		}
	}
	
}
