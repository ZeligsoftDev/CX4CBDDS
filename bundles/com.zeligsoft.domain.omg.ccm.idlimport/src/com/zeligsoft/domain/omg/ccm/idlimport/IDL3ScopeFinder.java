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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;
import com.zeligsoft.domain.omg.corba.idlimport.AbstractScopeFinder;

/**
 * Scope-finder for IDL3 concepts.
 * 
 * @author smcfee
 *
 */
public class IDL3ScopeFinder extends AbstractScopeFinder {

	private static IDL3ScopeFinder instance = new IDL3ScopeFinder();
	
	private IDL3ScopeFinder() {		
	}
	
	public static IDL3ScopeFinder INSTANCE() {
		return instance;
	}
	
	
	
	@Override
	public List<Element> findScopes(Element context, ScopedName lookupName) {
		ArrayList<Element> scopes = new ArrayList<Element>();
		
		if( ZDLUtil.isZDLConcept(context, CCMNames.EVENT) ) {
			scopes.addAll(getScopedList((Interface)context));
		} else if( ZDLUtil.isZDLConcept(context, CCMNames.CCMCOMPONENT)) {
			scopes.addAll(getScopedList((Component)context));
		}
		
		return scopes;
	}
	
	public void init() {
		
	}
	
	/**
	 * Helper function that returns all inherited interfaces for a passed classifier, up to any number of levels.
	 * 
	 * @param classifier
	 * @return
	 */
	private static List<NamedElement> getScopedList(Classifier classifier) {
		ArrayList<NamedElement> retVal = new ArrayList<NamedElement>();
		
		retVal.add(classifier);
		for( Classifier c : classifier.getGenerals()) {
			if( c instanceof Interface ) {
				retVal.addAll(getScopedList((Interface)c));
			}
		}
		
		return retVal;
	}
}