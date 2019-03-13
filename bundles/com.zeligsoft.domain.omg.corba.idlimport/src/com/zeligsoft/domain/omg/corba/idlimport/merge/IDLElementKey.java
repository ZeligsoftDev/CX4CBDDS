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
package com.zeligsoft.domain.omg.corba.idlimport.merge;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;
import com.zeligsoft.domain.omg.corba.util.CORBAUtil;

public class IDLElementKey extends AbstractHierarchicalKey<IDLElementKey> {

	String repositoryId;
	
	public IDLElementKey(EObject element) {
		super(element);
		
		if( element instanceof NamedElement ) {
			repositoryId = CORBAUtil.getRepositoryId((NamedElement)element);
		} else {
			for( EStructuralFeature feature : element.eClass().getEAllStructuralFeatures()) {
				if( feature.getName().matches("base_NamedElement")  //$NON-NLS-1$
						|| feature.getName().matches("base_Dependency") //$NON-NLS-1$
						|| feature.getName().matches("base_Class")) { //$NON-NLS-1$
					NamedElement n = (NamedElement)element.eGet(feature);
					if( n != null) {
						repositoryId = element.eClass().getName() + "__" + CORBAUtil.getRepositoryId(n); //$NON-NLS-1$
					}
				}
			}
		} 
		
	}

	@Override
	protected boolean keyEquals(IDLElementKey other) {

		if( repositoryId == null ) {
			return false;
		}
		return repositoryId.matches(other.repositoryId);
	}

	@Override
	protected int keyHash() {
		return (repositoryId == null)
		? 0
		: repositoryId.hashCode();
	}

}