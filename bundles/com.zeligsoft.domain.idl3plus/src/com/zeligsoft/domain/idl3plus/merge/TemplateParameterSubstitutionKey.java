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
package com.zeligsoft.domain.idl3plus.merge;

import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class TemplateParameterSubstitutionKey extends 
	AbstractHierarchicalKey<TemplateParameterSubstitutionKey>{
	
	private String formalParameterQName;
	
	/**
	 * @param element
	 */
	public TemplateParameterSubstitutionKey(TemplateParameterSubstitution element) {
		super(element);
		
		if(element.getFormal() != null) {
			TemplateParameter formalParameter = element.getFormal();
			if(formalParameter.getParameteredElement() instanceof NamedElement) {
				formalParameterQName = ((NamedElement) formalParameter.getParameteredElement()).getQualifiedName();
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey#keyEquals(com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey)
	 */
	@Override
	protected boolean keyEquals(TemplateParameterSubstitutionKey other) {
		return UML2Util.safeEquals(formalParameterQName, other.formalParameterQName);
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey#keyHash()
	 */
	@Override
	protected int keyHash() {
		return (formalParameterQName == null) ? 
				0 : formalParameterQName.hashCode();
	}

}
