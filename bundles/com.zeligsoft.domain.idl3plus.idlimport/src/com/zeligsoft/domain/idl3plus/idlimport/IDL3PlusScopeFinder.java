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
package com.zeligsoft.domain.idl3plus.idlimport;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;
import com.zeligsoft.domain.omg.corba.idlimport.AbstractScopeFinder;

/**
 * Scope finder for IDL3+ concepts.
 * 
 * @author smcfee
 *
 */
public class IDL3PlusScopeFinder extends AbstractScopeFinder {

	private static IDL3PlusScopeFinder instance = new IDL3PlusScopeFinder();
	
	private IDL3PlusScopeFinder() {		
	}
	
	public static IDL3PlusScopeFinder INSTANCE() {
		return instance;
	}
	
	@Override
	public List<Element> findScopes(Element context, ScopedName lookupName) {
		ArrayList<Element> scopes = new ArrayList<Element>();
		
		if( ZDLUtil.isZDLConcept(context, IDL3PlusNames.TEMPLATE_MODULE) ) {
			scopes.addAll(getScopedList(context));
		}
		
		return scopes;
	}
	
	public void init() {
	}
	
	/**
	 * Helper function that returns all inherited interfaces for a passed template module.
	 * 
	 * @param classifier
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static List<Element> getScopedList(Element templateModule) {
		ArrayList<Element> retVal = new ArrayList<Element>();
		
		EObject signature = (EObject)ZDLUtil.getValue(templateModule, IDL3PlusNames.TEMPLATE_MODULE, IDL3PlusNames.TEMPLATE_MODULE__SIGNATURE);
		retVal.addAll((List<Element>)ZDLUtil.getValue(signature, IDL3PlusNames.TEMPLATE_SIGNATURE, IDL3PlusNames.TEMPLATE_SIGNATURE__TYPE_PARAMETER));
		
		return retVal;
	}
}