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
package com.zeligsoft.domain.omg.ccm.idlimport;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.xtend.util.stdlib.ExtIssueReporter;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;
import com.zeligsoft.domain.omg.corba.idlimport.XtendUtils;
import com.zeligsoft.domain.omg.corba.idlimport.XtendUtils.unresolvedLookups;

@SuppressWarnings("nls")
public class IDL3ImportUtils {

	public static void applyIDL3FileConcept(Package pkg) {
		ZDLUtil.addZDLConcept(pkg, CCMNames.IDL3_FILE);
	}
	
	public static void addIdl3Scope() {
		IDL3ScopeFinder.INSTANCE().init();
		XtendUtils.addScope(IDL3ScopeFinder.INSTANCE());
	}
	
	/**
	 * Returns an interface with the given scoped name, with the scoped name relative to the repository
	 * ID of the element passed in. This method is intended to be used to retrieve an interface used
	 * as a type, e.g. for a port. If an interface is not found at that scoped name, add it to the 
	 * unresolvedLookups list with a lookup context of TypedElement.Type. 
	 * 
	 * @param s
	 * @param element
	 * @return
	 */
	public static org.eclipse.uml2.uml.Interface getInterface(ScopedName s, Element element) {
		
		Interface retVal = (Interface)XtendUtils.getType(element, s);
		
		if( retVal == null ) {
			unresolvedLookups.put((NamedElement)element, s, unresolvedLookups.LookupContext.TYPED_ELEMENT_TYPE);
		} 
		
		return retVal;
	}
	
	/**
	 * Adds generalization relationships to an imported component.
	 *  
	 * @param zdlComp
	 * 		The ZDL component being created.
	 * @param idlComp
	 * 		The IDL component being read.
	 */
	public static void addComponentGeneralizations(Component zdlComp, ComponentDecl idlComp) {
		for( ScopedName name : idlComp.getSupports()) {
			Type type = XtendUtils.getType(zdlComp, name);
			if( type != null && type instanceof Interface) {
				zdlComp.createInterfaceRealization("", (Interface)type);
			} else {
				unresolvedLookups.put(zdlComp, name, unresolvedLookups.LookupContext.GENERALIZATION);
			}
		}
		if( idlComp.getBase() != null ) {
			Type type = XtendUtils.getType(zdlComp, idlComp.getBase());
			if( type != null && type instanceof Component) {
				zdlComp.createGeneralization((Classifier)type);
			} else {
				unresolvedLookups.put(zdlComp, idlComp.getBase(), unresolvedLookups.LookupContext.GENERALIZATION);
			}
		}
		
	}
	
	
	/**
	 * Adds generalization relationships to an imported event.
	 *  
	 * @param zdlEvent
	 * 		The ZDL event being created.
	 * @param idlEvent
	 * 		The IDL event being read.
	 */
	public static void addEventGeneralizations(Interface zdlEvent, EventDcl idlEvent) {
		for( ScopedName name : idlEvent.getSupports()) {
			Type type = XtendUtils.getType(zdlEvent, name);
			if( type != null && type instanceof Interface) {
				zdlEvent.createGeneralization((Classifier)type);			
			} else {
				unresolvedLookups.put(zdlEvent, name, unresolvedLookups.LookupContext.GENERALIZATION);
			}
		}
		for( ScopedName name : idlEvent.getBase()) {
			Type type = XtendUtils.getType(zdlEvent, name);
			if( type != null && type instanceof Component) {
				zdlEvent.createGeneralization((Classifier)type);
			} else {
				unresolvedLookups.put(zdlEvent, name, unresolvedLookups.LookupContext.GENERALIZATION);
			}
		}
		
	}
	
	public static void configureHomeRelationships(Class zHome, HomeDecl home) {
		ScopedName name = home.getManages();
		ScopedName base = home.getBase();
		
		if( name != null ) {
			Type type = XtendUtils.getType(zHome, name);
			if( type != null && type instanceof Component) {
				Dependency manages = zHome.createDependency(type);
				ZDLUtil.addZDLConcept(manages, CCMNames.MANAGES);
				manages.setName(zHome.getName() + "__to__" + type.getName());
			} else {
				unresolvedLookups.put(zHome, name, unresolvedLookups.LookupContext.DEPENDENCY);
			}
		}
		if( base != null) {
			Type type = XtendUtils.getType(zHome, base);
			if( type != null && type instanceof Class) {
				zHome.createGeneralization((Classifier)type);
			} else {
				unresolvedLookups.put(zHome, base, unresolvedLookups.LookupContext.GENERALIZATION);
			}
		}
		
	}
	
	public static void setVisibility(Property stateMember, Boolean isPublic) {
		if( ZDLUtil.isZDLConcept(stateMember, CCMNames.STATE_MEMBER)) {
			if( isPublic ) {
				stateMember.setVisibility(VisibilityKind.PUBLIC_LITERAL);	
			} else {
				stateMember.setVisibility(VisibilityKind.PRIVATE_LITERAL);
			}
		}
	}
	
	/**
	 * Resolve any unresolved lookups.
	 */
	public static void resolveUnresolvedIdl3Lookups() {
			
		for( NamedElement namedElement : unresolvedLookups.keySet()) {
			
			for( unresolvedLookups.Lookup lookup : unresolvedLookups.get(namedElement)) {
				// Call getType again on the element, which should generally work the second time around.
				ScopedName scopedName = lookup.name;
				Type type = XtendUtils.getType(namedElement, scopedName);
				if( type != null ) {
					if( ZDLUtil.isZDLConcept(namedElement, CCMNames.HOME) 
							&& lookup.context == unresolvedLookups.LookupContext.DEPENDENCY) {
						Dependency manages = namedElement.createDependency(type);
						ZDLUtil.addZDLConcept(manages, CCMNames.MANAGES);
						manages.setName(namedElement.getName() + "__to__" + type.getName());
					} 
				} else {
					String scopedNameString = XtendUtils.getConstValue(scopedName);					
					ExtIssueReporter.reportError("Element " + namedElement.getQualifiedName().replace("test::", "") + " failed to resolve lookup for " + scopedNameString);
				}
			}
		}		
	}
	
}
