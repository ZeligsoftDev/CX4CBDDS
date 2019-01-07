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
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;

/**
 * Abstract scope finder. Contains 
 * 
 * @author smcfee
 *
 */
public abstract class AbstractScopeFinder implements ScopeFinder {

	public List<Element> findScopes(Element context, ScopedName lookupName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void init() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Given a package, search its contents for an IDL element matching the name and concept.
	 * 
	 * @param root
	 * 		Package to search.
	 * @param name
	 * 		Name of the IDLFile we hope to find.
	 * @return
	 */
	protected static List<NamedElement> findIDLElement(Package root, String name, String concept) {
		List<NamedElement> returnValue = new ArrayList<NamedElement>();
		
		for( TreeIterator<?> iter = EcoreUtil.getAllContents(root, true); iter.hasNext(); ) {
			Object next = iter.next();
			if( ZDLUtil.isZDLConcept((EObject)next, concept)) {
				if( ((NamedElement)next).getName().equals(name) ) {						
					returnValue.add((NamedElement)next);
				}
			}	
		}				
		
		return returnValue;
	}

}
