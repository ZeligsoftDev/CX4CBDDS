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
package com.zeligsoft.domain.thalessdr.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.service.AbstractTraversalStrategy;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.sca.utils.SCANames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Traversal strategy for ThalesSDR elements.
 * 
 * @author smcfee
 *
 */
public class ThalesTraversalStrategy extends AbstractTraversalStrategy {

	@Override
	protected int countElements(Collection<? extends EObject> traversalRoots) {

		HashSet<EObject> toValidateList = new HashSet<EObject>();
		
		toValidateList.addAll(traversalRoots);
		
		for(EObject root : traversalRoots) {
			// process each traversal root
			addToValidateList(root, toValidateList);
		}
		
		return toValidateList.size();
	}

	@Override
	protected Iterator<? extends EObject> createIterator(
			Collection<? extends EObject> traversalRoots) {

		HashSet<EObject> toValidateList = new HashSet<EObject>();
		
		toValidateList.addAll(traversalRoots);
		
		for(EObject root : traversalRoots) {
			// process each traversal root
			addToValidateList(root, toValidateList);
		}
		
		return toValidateList.iterator();
	}
	
	/**
	 * Recursive function that adds to the validation list.
	 * If an element has not been added, call function on it recursively to see what else it wants to validate. 
	 * 
	 * @param object
	 * @param toValidateList
	 */
	@SuppressWarnings("unchecked")
	private void addToValidateList(EObject object, Set<EObject> toValidateList) {
		
		for( org.eclipse.uml2.uml.Class c : ZDLUtil.getAllZDLConcepts(object)) {

			for( Property p : c.getOwnedAttributes()) {
				// Properties created from domain references don't get a stereotype so I can't query ZDLNames.DOMAIN_ATTRIBUTE
				// There is an assumption here that all properties of the domain class correspond to a feature that ZDLUtil will
				// understand. So far this assumption has been true.
				Object obj = null;
				try {
					obj = ZDLUtil.getValue(object, c, p.getName());
				}
				catch( Exception e ) {
					continue;
				}
				if( obj != null && obj instanceof EObject ) {
					EObject eobj = (EObject)obj;
					Class conceptClass = ZDLUtil.getZDLConcept(eobj);
					if( shouldAdd(conceptClass)) {
						if( toValidateList.add(eobj)) {
							addToValidateList(eobj, toValidateList);
						}
					}
				}
				// ZDLUtil.getValue will sometimes return a collection, for example a deployment's parts.
				else if( obj != null && obj instanceof Collection ) {
					for( EObject eobj : (Collection<EObject>)obj ) {
						Class conceptClass = ZDLUtil.getZDLConcept(eobj);
						if( shouldAdd(conceptClass)) {
							if( toValidateList.add(eobj)) {
								addToValidateList(eobj, toValidateList);
							}
						}
					}
				}
			}
		}
	}
	
	private static Collection<String> allowedList = new ArrayList<String>();
	
	static {
	
		allowedList.add(ZMLMMNames.MESSAGE_PORT);
		allowedList.add(ZMLMMNames.DEPLOYMENT_PART);
		allowedList.add(ZMLMMNames.DEPLOYMENT);
		allowedList.add(SCANames.SCANODE_PART);
		allowedList.add(SCANames.SCAPLATFORM);
		allowedList.add(SCANames.SCAPART);
		allowedList.add(SCANames.SCACONNECTOR);
		allowedList.add(SCANames.SCAPROPERTY);
		allowedList.add(SCANames.SCABINARY);
		allowedList.add(SCANames.SCADEPENDENCY);
		allowedList.add(SCANames.SCAIMPLEMENTATION);
		allowedList.add(SCANames.DMDPROPERTIES);
		allowedList.add(SCANames.SCASOFTWARE_PACKAGE);
		allowedList.add(SCANames.SCACOMPONENT_INTERFACE);
		allowedList.add(CCMNames.ASSEMBLY_IMPLEMENTATION);
		allowedList.add(CCMNames.CCMPART);
		allowedList.add(CCMNames.CCMCONNECTOR);
		allowedList.add(CCMNames.MONOLITHIC_IMPLEMENTATION);
	}
	
	
	boolean shouldAdd(Class conceptClass) {
		if( conceptClass == null ) {
			return false;
		}
		return allowedList.contains(conceptClass.getQualifiedName());
	}

}
