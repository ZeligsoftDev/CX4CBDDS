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
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;

/**
 * Key provider for IDLFiles and their stereotype objects.
 * 
 * @author Sean McFee
 *
 */
public class IDLFileKey extends AbstractHierarchicalKey<IDLFileKey> {

	String fileName;
	
	public IDLFileKey(EObject element) {
		super(element);
		
		if( element instanceof Package ) {
			fileName = ((Package)element).getName();
		} else {
			for( EStructuralFeature feature : element.eClass().getEAllStructuralFeatures()) {
				if( feature.getName().matches("base_Package")) { //$NON-NLS-1$
					NamedElement n = (NamedElement)element.eGet(feature);
					fileName = element.eClass().getName() + "__" + n.getName(); //$NON-NLS-1$
				}
			}
		} 
	}

	@Override
	protected boolean keyEquals(IDLFileKey other) {

		if( fileName == null ) {
			return false;
		}
		return fileName.matches(other.fileName);
	}

	@Override
	protected int keyHash() {
		return (fileName == null)
		? 0
		: fileName.hashCode();
	}
}
