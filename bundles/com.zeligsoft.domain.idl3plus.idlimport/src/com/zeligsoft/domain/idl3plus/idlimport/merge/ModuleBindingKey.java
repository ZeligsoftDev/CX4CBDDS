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
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;
import com.zeligsoft.domain.omg.corba.util.CORBAUtil;

/**
 * Key generator for ModuleBindings. The containing ModuleInstantiation is sufficient.
 * 
 * @author smcfee
 *
 */
@SuppressWarnings("nls")
public class ModuleBindingKey extends AbstractHierarchicalKey<ModuleBindingKey> {

	String key;
	
	public ModuleBindingKey(EObject element) {
		super(element);
		
		if( element instanceof Element ) {
			NamedElement container = (NamedElement)(element.eContainer());
			key = CORBAUtil.getRepositoryId(container) + "::ModuleBinding";
		} else {
			for( EStructuralFeature feature : element.eClass().getEAllStructuralFeatures()) {
				if( feature.getName().matches("base_NamedElement") 
						|| feature.getName().matches("base_Dependency")
						|| feature.getName().matches("base_Class")) {
					NamedElement n = (NamedElement)element.eGet(feature);
					if( n != null) {
						key = element.eClass().getName() + "__" + CORBAUtil.getRepositoryId(n);
					}
				}
			}
		} 
		
	}

	@Override
	protected boolean keyEquals(ModuleBindingKey other) {

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
