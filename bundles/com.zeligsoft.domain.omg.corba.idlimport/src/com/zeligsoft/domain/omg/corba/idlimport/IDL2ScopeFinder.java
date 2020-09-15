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
package com.zeligsoft.domain.omg.corba.idlimport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;
import com.zeligsoft.domain.omg.corba.idlimport.l10n.Messages;

public class IDL2ScopeFinder extends AbstractScopeFinder {

	private static IDL2ScopeFinder instance = new IDL2ScopeFinder();
	
	private ArrayList<ScopedName> lookupNames = new ArrayList<ScopedName>();
	
	private IDL2ScopeFinder() {		
	}
	
	public static IDL2ScopeFinder INSTANCE() {
		return instance;
	}
	
	public void init() {
		moduleLookupList.clear();
		lookupNames.clear();
	}
	
	@Override
	public List<Element> findScopes(Element context, ScopedName lookupName) {
		ArrayList<Element> scopes = new ArrayList<Element>();
		
		if( ZDLUtil.isZDLConcept(context, CXDomainNames.CXINTERFACE) ) {
			scopes.addAll(getScopedList((Interface)context));
		} else if( ZDLUtil.isZDLConcept(context, CXDomainNames.CXMODULE)) {
			scopes.addAll(getScopedList((Package)context));
		} else if( ZDLUtil.isZDLConcept(context, CXDomainNames.IDLFILE)) {
			scopes.addAll(getScopedList((Package)context, lookupName, new ArrayList<Package>()));
		}
		
		if( lookupNames.contains(lookupName) == false ) {
			lookupNames.add(lookupName);

			scopes.addAll(importScopeFinder(context, lookupName.getName().get(0)));
		}
		
		return scopes;
	}

	
	/**
	 * Helper function that finds all scopes required for an Element from 
	 * imported packages as well as the imports from the imported packages,
	 * recursively
	 * 
	 * @param context
	 * 		the context element
	 * @param moduleName
	 * 		module name we are looking for
	 * @return
	 */
	private static ArrayList<NamedElement> importScopeFinder(Element context, String moduleName) {
		ArrayList<NamedElement> scopes = new ArrayList<NamedElement>();
		
		//check to see if this element should be added
		for( NamedElement foundModule : findIDLElement(
			context.getModel(), moduleName, CXDomainNames.CXMODULE)) {						
			scopes.add(foundModule);
			scopes.add((NamedElement)foundModule.getOwner());						
		}
		//check the if the imports should be added
		for (PackageImport pi : context.getModel().getPackageImports()) {
			for( NamedElement foundModule : findIDLElement(pi.getImportedPackage(), moduleName, CXDomainNames.CXMODULE)) {
				scopes.add(foundModule);
				scopes.add((NamedElement)foundModule.getOwner());
			}
			//Go through the imports of the imported packages, only add those that have not been added yet
			for (NamedElement e : importScopeFinder(pi.getImportedPackage(), moduleName)) {
				if (!scopes.contains(e)) {
					scopes.add(e);
				}
			}
		}
		return scopes;
	}
	
	/**
	 * Helper function that returns all inherited interfaces for a passed interface, up to any number of levels.
	 * 
	 * @param intf
	 * @return
	 */
	private static List<NamedElement> getScopedList(Interface intf) {
		ArrayList<NamedElement> retVal = new ArrayList<NamedElement>();
		
		retVal.add(intf);
		for( Classifier c : intf.getGenerals()) {
			if( c instanceof Interface ) {
				retVal.addAll(getScopedList((Interface)c));
			}
		}
		
		return retVal;
	}
	
	private static HashMap<Package, List<NamedElement>> moduleLookupList = new HashMap<Package, List<NamedElement>>();
	
	/**
	 * Helper function that returns all scopes with the same name as the passed package.
	 * @param pkg
	 * @param typeString
	 * @return
	 */
	private static List<NamedElement> getScopedList(Package pkg) {		
		
		List<NamedElement> retVal = moduleLookupList.get(pkg);
		if( retVal != null ) {
			return retVal;
		} else {
			retVal = new ArrayList<NamedElement>();
		}
		
		if( ZDLUtil.isZDLConcept(pkg, CXDomainNames.CXMODULE)) {		
			// For a module, search the model for instances of CXModule that have the same name.
			for( NamedElement foundModule : findIDLElement(pkg.getModel(), pkg.getName(), CXDomainNames.CXMODULE)) {
				retVal.add(foundModule);
				retVal.add((NamedElement)foundModule.getOwner()); // the IDL file is also needed 				
			}
			// Also search the package imports.
			for( PackageImport pi : pkg.getModel().getPackageImports()) {
				for (NamedElement e : importScopeFinder(pi.getImportedPackage(), pkg.getName())) {
					if (!retVal.contains(e)) retVal.add(e);
				}
			}
			moduleLookupList.put(pkg, retVal);
		} else {
			throw new IllegalArgumentException(Messages.IDL2ScopeFinder_0);
		}
		
		return retVal;
	}
	
	/**
	 * Helper function that returns all scopes with the same name as the passed package.
	 * @param pkg
	 * @param typeString
	 * @return
	 */
	private static List<NamedElement> getScopedList(Package pkg, ScopedName typeString, List<Package> visitedList) {		
		
		List<NamedElement> retVal = new ArrayList<NamedElement>();
		
		visitedList.add(pkg);
		
		if( ZDLUtil.isZDLConcept(pkg, CXDomainNames.IDLFILE)) {
			// For an IDLFile, search the IDLFile's include list for modules with the module name we are searching for.
			String moduleName = typeString.getName().get(0);
			if(typeString.getName().size() == 1){
				// This is global scope
				moduleName = UML2Util.EMPTY_STRING;
			}
			for( Dependency idlImportDependency : pkg.getClientDependencies()) {
				if( ZDLUtil.isZDLConcept(idlImportDependency, CXDomainNames.IDLIMPORT)) {
					if(UML2Util.isEmpty(moduleName)){
						retVal.add((Package)idlImportDependency.getTargets().get(0));
					}else{
						for( NamedElement foundModule : findIDLElement(
								(Package)idlImportDependency.getTargets().get(0), moduleName, CXDomainNames.CXMODULE)) {						
							retVal.add(foundModule);
							retVal.add((NamedElement)foundModule.getOwner());						
						}
						// recursive call for anything that this scope includes
						if( !(visitedList.contains(idlImportDependency.getTargets().get(0)))) {
							retVal.addAll(getScopedList((Package)idlImportDependency.getTargets().get(0), typeString, visitedList));	
						}	
					}
				}
			}
		} else {
			throw new IllegalArgumentException(Messages.IDL2ScopeFinder_1);
		}
		
		
		return retVal;
	}
	
	
}
