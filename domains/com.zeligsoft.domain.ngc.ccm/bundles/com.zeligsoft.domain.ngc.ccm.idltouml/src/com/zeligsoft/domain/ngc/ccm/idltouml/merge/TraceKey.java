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
package com.zeligsoft.domain.ngc.ccm.idltouml.merge;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;

/**
 * @author Toby McClean (tmcclean)
 *
 */
@SuppressWarnings("nls")
public class TraceKey extends AbstractHierarchicalKey<TraceKey> {
	
	private static final int HASH_CONSTANT = 43;

	private String sourceElement;
	
	private String ruleName;
	
	private String elementName;
	
	public TraceKey(org.eclipse.uml2.uml.NamedElement element) {
		super(element);
		
		EAnnotation annotation = element.getEAnnotation("@tao_idl_generated");
		elementName = element.getQualifiedName();
		if(annotation != null) {
			sourceElement = annotation.getDetails().get("source");
			ruleName = annotation.getDetails().get("transform");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey#keyEquals(com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey)
	 */
	@Override
	protected boolean keyEquals(TraceKey other) {
		if(sourceElement == null || ruleName == null || 
				other.sourceElement == null || other.ruleName == null) 
			return false;
		
		return UML2Util.safeEquals(sourceElement, other.sourceElement) &&
					UML2Util.safeEquals(ruleName, other.ruleName);
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey#keyHash()
	 */
	@Override
	protected int keyHash() {
		if(sourceElement == null || ruleName == null) {
			return (elementName == null) ? 
						0 :
						this.elementName.hashCode();
		}
			
		
		return sourceElement.hashCode() * HASH_CONSTANT + ruleName.hashCode();
	}

}
