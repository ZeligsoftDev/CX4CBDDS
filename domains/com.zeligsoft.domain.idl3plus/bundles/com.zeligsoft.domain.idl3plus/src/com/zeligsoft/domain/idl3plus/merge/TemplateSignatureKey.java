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
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.TemplateSignature;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;
import com.zeligsoft.domain.idl3plus.l10n.Messages;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class TemplateSignatureKey
	extends AbstractHierarchicalKey<TemplateSignatureKey>{

	protected String nearestNamedElementQName;
	
	/**
	 * @param element
	 */
	public TemplateSignatureKey(TemplateSignature element) {
		super(element);
		
		NamedElement nearestNamedElement = getNearestNamedElement(element);
		
		if(nearestNamedElement == null) {
			throw new IllegalArgumentException(Messages.TemplateSignatureKey_Exception_MustHaveAncestor);
		}
		
		nearestNamedElementQName =nearestNamedElement.getQualifiedName();
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey#keyEquals(com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey)
	 */
	@Override
	protected boolean keyEquals(TemplateSignatureKey other) {
		return UML2Util.safeEquals(nearestNamedElementQName, other.nearestNamedElementQName);
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey#keyHash()
	 */
	@Override
	protected int keyHash() {
		return (nearestNamedElementQName == null) ? 0 : nearestNamedElementQName.hashCode() * 23;
	}

	private NamedElement getNearestNamedElement(Element e) {
		if(e == null) {
			return null;
		} else if(e instanceof NamedElement) {
			return (NamedElement) e;
		} else {
			return getNearestNamedElement((Element) e.eContainer());
		}
	}
}
