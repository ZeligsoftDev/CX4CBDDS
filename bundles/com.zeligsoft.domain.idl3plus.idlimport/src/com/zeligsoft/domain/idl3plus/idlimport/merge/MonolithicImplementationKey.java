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
package com.zeligsoft.domain.idl3plus.idlimport.merge;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.corba.CXDomainNames;

/**
 * Key generator for MonolithicImplementations. The containing ModuleInstantiation is sufficient.
 * 
 * @author smcfee
 *
 */
@SuppressWarnings("nls")
public class MonolithicImplementationKey extends AbstractHierarchicalKey<MonolithicImplementationKey> {

	String key;
	
	public MonolithicImplementationKey(EObject element) {
		super(element);
		
		if( element instanceof NamedElement ) {
			key = elementKey((NamedElement) element);			
		} else {
			for( EStructuralFeature feature : element.eClass().getEAllStructuralFeatures()) {
				if( feature.getName().matches("base_NamedElement") 
						|| feature.getName().matches("base_Dependency")
						|| feature.getName().matches("base_Class")) {
					NamedElement n = (NamedElement)element.eGet(feature);
					if( n != null) {
						key = element.eClass().getName() + "__" + elementKey(n);
					}
				}
			}
		} 
		
	}

	
	/**
	 * 
	 * 
	 * @param intf
	 * @return
	 */
	private String elementKey( NamedElement intf ) {
		
		if( ZDLUtil.isZDLConcept(intf, CCMNames.MONOLITHIC_IMPLEMENTATION) == false ) {
			throw new IllegalArgumentException("Method is only to be called on a Monolithic Implementation.");
		}
		
		String repositoryId = "";
		NamedElement namedElement = intf;

		while( namedElement != null ) {
			if( ZDLUtil.isZDLConcept(namedElement, CXDomainNames.CXNAMED_ELEMENT)
					|| ZDLUtil.isZDLConcept(namedElement, CCMNames.MONOLITHIC_IMPLEMENTATION)) {
				if( repositoryId.matches("") == false) {
					repositoryId = "/" + repositoryId;
				}
				repositoryId = namedElement.getName() + repositoryId;
				namedElement = (NamedElement)namedElement.getOwner();	
			} else if( namedElement instanceof org.eclipse.uml2.uml.Package ) {
				// A UML package should be skipped since its container could still be a CX Element.
				namedElement = (NamedElement)namedElement.getOwner();
			} else {
				// Any other object means we are done calculating the repository ID.
				namedElement = null;
			}
		}
		
		repositoryId = "IDL:" + repositoryId;
		return repositoryId;
	}

	@Override
	protected boolean keyEquals(MonolithicImplementationKey other) {

		if( key == null ) {
			return false;
		}
		return key.matches(other.key);
	}

	@Override
	protected int keyHash() {
		return (key == null)
		? 0
		: key.hashCode();
	}

}
